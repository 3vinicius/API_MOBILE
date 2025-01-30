package com.example.demokotlin.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musics")
data class Music (
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "title", length = Integer.MAX_VALUE)
    var title: String? = null,

    @Column(name = "link", nullable = false, length = 50)
    var link: String? = null,

    @Column(name = "thumbnail")
    var thumbnail: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    var idUser: User? = null
){
    constructor() : this(id = null, title = null, link = null, thumbnail = null )
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}