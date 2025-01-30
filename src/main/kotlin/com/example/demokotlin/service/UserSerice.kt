package com.example.demokotlin.service

import com.example.demokotlin.dto.UserDto
import com.example.demokotlin.model.User
import com.example.demokotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.example.demokotlin.shareds.ContaintsPhases

@Service
class UserSerice {

    @Autowired
    final lateinit var userRepository: UserRepository

    fun buscarUsuarios(): List<User>{
        return userRepository.findAll();
    }

    fun autenticUser(email:String, password: String) : Boolean{
        return userRepository.existsByEmailAndPassword(email, password)
    }

    @Transactional
    fun insertUser(name: String,password: String,email: String,phone: String) : String {
        return try {
            val user = User(name = name, email = email, password = password, phone = phone)
            userRepository.save(user)
            ContaintsPhases.REGISTREFULL.toString()
        } catch (err: Exception) {
            throw err
        }
    }
}