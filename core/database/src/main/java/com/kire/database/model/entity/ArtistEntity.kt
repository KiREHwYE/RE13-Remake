package com.kire.database.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents song artist information

 * @param id Unique identifier of artist. Defaults to 0 if not specified.
 * @param artist What artist calls himself, name or pseudonym
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    val id: Long = 0,
    val artist: String
)