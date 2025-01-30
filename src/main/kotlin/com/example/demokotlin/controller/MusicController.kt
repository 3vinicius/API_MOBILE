package com.example.demokotlin.controller

import com.example.demokotlin.dto.AllMusicLikedAndTotalDto
import com.example.demokotlin.dto.MusicDto
import com.example.demokotlin.model.Music
import com.example.demokotlin.service.LikedMusicService
import com.example.demokotlin.service.MusicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/music")
class MusicController(private val musicService : MusicService,
    private val likedMusicService: LikedMusicService

    ) {

    @GetMapping("/all")
    fun searchAllMusics(): MutableList<MusicDto> {
        return likedMusicService.searchAllMusics();
    }

    @PostMapping("/register")
    fun registerMusic(@RequestParam(value = "title" ) title:String,
                      @RequestParam(value = "link") link: String,
                      @RequestParam(value = "email") email: String,
                      @RequestParam(value = "thumbnail") thumbnail: String
                      ) : String {
        return musicService.insertMusic(title, link, email, thumbnail)
    }


    @GetMapping("/allMusicAndLikes")
    fun searchAllMusicsAndLikes(@RequestParam(value = "email") email: String): List<AllMusicLikedAndTotalDto> {
        return likedMusicService.searchAllMusicsAndLikes(email);
    }

}