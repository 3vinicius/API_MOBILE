package com.example.demokotlin.service

import org.springframework.stereotype.Service


@Service
class Service {
    fun sunValue(numberA: Int, numberB: Int): Int{
        return numberA+numberB
    }
}