package com.example.demokotlin.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor



@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "name", nullable = false, length = 50)
    var name: String,

    @Column(name = "email", length = 150)
    var email: String? = null,

    @Column(name = "password", nullable = false, length = 150)
    var password: String,

    @Column(name = "phone", nullable = false, length = 150)
    var phone: String
) {
    constructor() : this(name = "", email = null, password = "", phone = "")

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}