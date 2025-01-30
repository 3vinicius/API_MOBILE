package com.example.demokotlin.repository;

import com.example.demokotlin.dto.LikeMusicDto
import com.example.demokotlin.model.LikeMusic
import com.example.demokotlin.model.Music
import com.example.demokotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface LikeMusicRepository : JpaRepository<LikeMusic, Int> {

    fun countLikeMusicByIdmusic(idmusic: Music): Long

    fun deleteByIduserAndIdmusic(iduser: User?, idmusic: Music?)

    fun findByIduserAndIdmusic(iduser: User, idmusic: Music): List<LikeMusic>
}