package com.example.demokotlin.service

import com.example.demokotlin.dto.AllMusicLikedAndTotalDto
import com.example.demokotlin.dto.MusicDto
import com.example.demokotlin.model.LikeMusic
import com.example.demokotlin.model.Music
import com.example.demokotlin.model.User
import com.example.demokotlin.repository.LikeMusicRepository
import com.example.demokotlin.repository.MusicRepository
import com.example.demokotlin.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.example.demokotlin.shareds.ContaintsPhases.*

@Service
class LikedMusicService (
    private val musicRepository: MusicRepository,
    private val userRepository: UserRepository,
    private val linkedMusicRepository: LikeMusicRepository
) {


    @Transactional
    fun likeMusic(idMusic: Int, email:String): Any {
        return try {
            val user: User = userRepository.findByEmail(email)
            val likeMusic: LikeMusic = LikeMusic(idmusic = Music(idMusic), iduser = user)
            val result = linkedMusicRepository.findByIduserAndIdmusic(idmusic = Music(id = idMusic), iduser = user)
            if (result.isEmpty()){
                linkedMusicRepository.save(likeMusic)
                REGISTREFULL.returnInfo()
            } else {
                throw Exception(ERRORLIKE.toString())
            }
        }
         catch (ex: Exception) {
            throw ex;
        }
    }

    @Transactional
    fun unLikeMusic(idMusic: Int, email:String): Any {
        return try {
            val user: User = userRepository.findByEmail(email)
            if (linkedMusicRepository.findByIduserAndIdmusic(idmusic = Music(id = idMusic), iduser = user).isNotEmpty()){
                linkedMusicRepository.deleteByIduserAndIdmusic(iduser = user, idmusic = Music(id = idMusic))
            } else {
                throw Exception(ERRORUNLIK.returnInfo())
            }
        } catch (ex: Exception) {
            throw ex;
        }
    }


    fun searchAllMusics(): MutableList<MusicDto> {
        return try {
            val musicList : MutableList<Music> = musicRepository.findAll()
            val musicDtoList : MutableList<MusicDto> = mutableListOf()
            musicList.forEach { music ->
                val likesMusic: Long = linkedMusicRepository.countLikeMusicByIdmusic(music)
                musicDtoList.add(MusicDto(id = music.id, title = music.title, link = music.link, likes = likesMusic, userId = music.id, thumbnail = music.thumbnail))
            }
            musicDtoList
        } catch (ex: Exception){
            throw ex
        }
    }


    fun searchAllMusicsAndLikes(email: String): List<AllMusicLikedAndTotalDto> {
        return try {
            val user = userRepository.findByEmail(email);
            val musicLikedByUser = musicRepository.findMusics()
            val likesByUser =  musicRepository.findLikesByUser(idUser = user.id)

            if (likesByUser.isNotEmpty() && musicLikedByUser.isNotEmpty()){
                musicLikedByUser.forEach { music ->
                    likesByUser.forEach{likes ->
                        if (music.id == likes.idmusic?.id){
                            music.likedUser = 1
                        }
                    }
                }
            }

            musicLikedByUser
        } catch (ex: Exception){
            throw ex
        }
    }
}