package com.example.demokotlin.model

import jakarta.persistence.*

@Entity
@Table(name = "likemusics")
data class LikeMusic (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "likes")
    var likes: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    var iduser: User? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmusic")
    var idmusic: Music? = null
) {
    constructor() : this(id = null, likes = null, iduser=null, idmusic=null)
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}