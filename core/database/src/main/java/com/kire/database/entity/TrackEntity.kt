package com.kire.database.entity

import android.net.Uri
import androidx.room.Entity

/**
 * Represents song information, including fields for title, artist, album, etc.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(tableName = "tracks")
data class TrackEntity(
    val id: Long = 0,
    val artistId: Long? = 0,
    val albumId: Long? = 0,
    val title: String,
    val lyrics: String? = null,
    val duration: Long,
    val dateModified: Long,
    val bitrate: Long,
    val size: Long,
    val data: Uri,
    val artworkUri: Uri,
)