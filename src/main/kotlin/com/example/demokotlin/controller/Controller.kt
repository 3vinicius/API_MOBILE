package com.example.demokotlin.controller

import com.example.demokotlin.model.User
import com.example.demokotlin.service.Service
import com.example.demokotlin.service.UserSerice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller (

) {


    @Autowired
    private lateinit var service: Service

    @Autowired
    private lateinit var userSerice: UserSerice;


    @GetMapping("/")
    fun index(@RequestParam("name") name: String): String {
        return "Hello, $name!"
    }

    @GetMapping("/login")
    fun login(@RequestParam("login") name: String,
            @RequestParam("password") password: String
    ): String {
        return "Hello, $name!"
    }

    @GetMapping("/buscarTodosUsuarios")
    fun buscarTodos(): List<User>{
        return userSerice.buscarUsuarios();
    }

    @GetMapping("/teste")
    fun teste(@RequestParam("a") a: Int,
              @RequestParam("b") b: Int) : Int{
        return service.sunValue(a,b)
    }
}