package com.example.demokotlin.dto

import java.io.Serializable

/**
 * DTO for {@link com.example.demokotlin.model.User}
 */
data class UserDto(
    val id: Int? = null,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
    val phone: String? = null
) : Serializable