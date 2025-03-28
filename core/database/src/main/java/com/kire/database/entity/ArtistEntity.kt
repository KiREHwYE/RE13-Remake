package com.kire.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents song artist information
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    val id: Long = 0,
    val name: String
)