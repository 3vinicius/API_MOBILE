package com.example.demokotlin.controller

import com.example.demokotlin.model.Music
import com.example.demokotlin.service.LikedMusicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/likemusic")
class LikeMusicController(private val serviceLikedMusicService: LikedMusicService) {


    @GetMapping("/like")
    fun likeMusics(@RequestParam(value = "idMusic" ) idMusic:Int,
                   @RequestParam(value = "email") email: String): Any {
        return serviceLikedMusicService.likeMusic(idMusic, email)
    }

    @GetMapping("/unlike")
    fun unLikeMusics(@RequestParam(value = "idMusic" ) idMusic:Int,
                     @RequestParam(value = "email") email: String): Any {
        return serviceLikedMusicService.unLikeMusic(idMusic, email);
    }
}