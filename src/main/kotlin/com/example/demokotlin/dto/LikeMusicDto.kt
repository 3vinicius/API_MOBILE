package com.example.demokotlin.dto

import java.io.Serializable

/**
 * DTO for {@link com.example.demokotlin.model.Likemusic}
 */
data class LikeMusicDto(
    val id: Int? = null,
    val likes: Int? = null,
    val idUser: Int? = null,
    val idMusic: Int? = null
) : Serializable