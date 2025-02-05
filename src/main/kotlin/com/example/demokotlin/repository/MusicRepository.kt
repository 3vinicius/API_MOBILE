package com.example.demokotlin.repository;

import com.example.demokotlin.dto.AllMusicLikedAndTotalDto
import com.example.demokotlin.model.LikeMusic
import com.example.demokotlin.model.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import com.example.demokotlin.querys.ConstantsQuery
import org.springframework.data.repository.query.Param

interface MusicRepository : JpaRepository<Music, Int> {

    @Query(ConstantsQuery.searchLikedsByUser, nativeQuery = true)
    fun findLikesByUser(@Param("idUser") idUser: Int?): List<LikeMusic>

    @Query(ConstantsQuery.searchMusicasAndTotalLikes, nativeQuery = true)
    fun findMusics(): List<AllMusicLikedAndTotalDto>

    fun findByLink(link: String): Music


    fun existsByLink(link: String): Boolean
}