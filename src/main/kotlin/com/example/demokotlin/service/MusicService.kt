package com.example.demokotlin.service

import com.example.demokotlin.model.Music
import com.example.demokotlin.repository.MusicRepository
import com.example.demokotlin.repository.UserRepository
import com.example.demokotlin.shareds.ContaintsPhases
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class MusicService(
    private val musicRepository: MusicRepository,
    private val userRepository: UserRepository
    ) {



    fun searchAllMusic(): List<Music>{
        return musicRepository.findAll()
    }



    @Transactional
    fun insertMusic(title: String, link:String, email:String, thumbnail:String): String{
        return try {
            val user = userRepository.findByEmail(email)
            val music : Music = Music(title = title,link=link, thumbnail = thumbnail,idUser = user)
            musicRepository.save(music)
            ContaintsPhases.REGISTREFULL.returnInfo()
        } catch (err: Exception) {
            throw err
        }
    }
}