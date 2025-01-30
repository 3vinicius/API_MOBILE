package com.example.demokotlin.repository;

import com.example.demokotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Int> {


    fun existsByEmailAndPassword(email: String, password: String): Boolean


    fun findByEmail(email: String): User
}