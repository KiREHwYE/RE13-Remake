package com.kire.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tracks")
data class TrackEntity(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Long = 0,
    val artistId: Long? = 0,
    val albumId: Long? = 0,
    val title: String,
    val duration: Long,
    val lyrics: String,
    val filePath: String,
    val dateAdded: String? = null,
    val artworkUri: String?,
)