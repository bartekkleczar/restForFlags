package org.example

import kotlinx.serialization.Serializable

@Serializable
data class CountryDTO(
    val code: String,
    val name: String,
    val flagPath: String
)
