package com.example.demokotlin.repository;

import com.example.demokotlin.dto.AllMusicLikedAndTotalDto
import com.example.demokotlin.model.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import com.example.demokotlin.querys.ConstantsQuery
import org.springframework.data.repository.query.Param

interface MusicRepository : JpaRepository<Music, Int> {

    @Query(ConstantsQuery.buscarMusicas, nativeQuery = true)
    fun findMusics(@Param("idUser") idUser: Int?): List<AllMusicLikedAndTotalDto>

    fun findByLink(link: String): Music
}