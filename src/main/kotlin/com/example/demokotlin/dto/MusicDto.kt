package com.example.demokotlin.dto

import java.io.Serializable

/**
 * DTO for {@link com.example.demokotlin.model.Music}
 */
data class MusicDto(
    val id: Int? = null,
    val title: String? = null,
    val link: String? = null,
    val likes: Long? = null,
    val userId:Int? =  null,
    val thumbnail: String? = null,

    ) : Serializable