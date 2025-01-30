package com.example.demokotlin.dto

import lombok.Getter
import lombok.Setter
import java.io.Serializable

/**
 * DTO for {@link com.example.demokotlin.model.Music}
 */


data class AllMusicLikedAndTotalDto(
    val id: Int? = null,
    val title: String? = null,
    val link: String? = null,
    val thumbnail: String? = null,
    val totalLikes: Long? = null,
    var likedUser: Int? = null
) : Serializable