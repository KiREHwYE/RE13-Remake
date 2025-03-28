package com.kire.database

import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import javax.inject.Inject

/**
 * Reads audio file metadata from the device's media store for storage in the local database.
 * This class provides functionality to query [MediaStore.Audio.Media.EXTERNAL_CONTENT_URI] and retrieve audio files,
 * constructing a list of [AudioFile]. It filters results to include only audio files using a MIME_TYPE constraint.
 *
 * @param context The application context used to access the [ContentResolver] for querying MediaStore.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
class AudioReader @Inject constructor(
    private val context: Context
) {

    /**
     * Retrieves a list of all audio files from the device's external storage via MediaStore.
     * This method queries [MediaStore.Audio.Media.EXTERNAL_CONTENT_URI] with a MIME_TYPE filter to ensure only audio files
     * are included, returning a list of [AudioFile] objects.
     *
     * @return A list of [AudioFile] objects representing audio files found on the device.
     */
    fun getAllAudioFiles(): List<AudioFile> {
        val audioFiles = mutableListOf<AudioFile>()

        val queryUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.ARTIST_ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.DATE_MODIFIED,
            MediaStore.Audio.Media.BITRATE,
            MediaStore.Audio.Media.SIZE,
            MediaStore.Audio.Media.DATA
        )
        val selection = "${MediaStore.Audio.Media.MIME_TYPE} LIKE ?"
        val selectionArgs = arrayOf("audio/%")

        context.contentResolver.query(
            queryUri,
            projection,
            selection,
            selectionArgs,
            null,
        )?.use { cursor ->

            val idColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media._ID
            )
            val titleColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.TITLE
            )
            val artistColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.ARTIST
            )
            val albumColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.ALBUM
            )
            val albumIdColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.ALBUM_ID
            )
            val artistIdColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.ARTIST_ID
            )
            val durationColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.DURATION
            )
            val dateModifiedColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.DATE_MODIFIED
            )
            val bitrateColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.BITRATE
            )
            val sizeColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.SIZE
            )
            val dataColumn = cursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.DATA
            )


            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val albumId = cursor.getLong(albumIdColumn)
                val artistId = cursor.getLong(artistIdColumn)
                val title = cursor.getString(titleColumn)
                val artist = cursor.getString(artistColumn)
                val album = cursor.getString(albumColumn)
                val duration = cursor.getLong(durationColumn)
                val dateModified = cursor.getLong(dateModifiedColumn)
                val bitrate = cursor.getLong(bitrateColumn)
                val size = cursor.getLong(sizeColumn)
                val data = cursor.getString(dataColumn)

                audioFiles.add(
                    AudioFile(
                        id = id,
                        albumId = albumId,
                        artistId = artistId,
                        title = title,
                        album = album,
                        artist = artist,
                        duration = duration,
                        dateModified = dateModified,
                        size = size,
                        bitrate = bitrate,
                        data = data,
                        artworkUri = ContentUris.withAppendedId(
                            MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                            albumId
                        ).toString()
                    )
                )
            }
        }

        return audioFiles.toList()
    }
}