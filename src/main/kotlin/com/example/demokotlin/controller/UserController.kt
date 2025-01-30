package com.example.demokotlin.controller

import com.example.demokotlin.service.UserSerice
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController(private val userSerice: UserSerice){

    @PostMapping("/")
    fun insertUser(
        @RequestParam(value = "name") name: String,
        @RequestParam(value = "password") password: String,
        @RequestParam(value = "email") email: String,
        @RequestParam(value = "phone") phone: String
    ) : String {
        return userSerice.insertUser(name,password,email,phone)
    }

    @GetMapping("/autentic")
    fun autenticUser( @RequestParam(value = "password") password: String,
                      @RequestParam(value = "email") email: String,): Boolean{
        return userSerice.autenticUser(email, password)
    }
}
