package com.example.demokotlin.shareds

enum class ContaintsPhases(var result : String) {
    REGISTREFULL("Registre sucessful"),
    ERRORLIKE("Music have Liked"),
    ERRORUNLIK("Not has like in music")

    ;
    fun returnInfo():String {
        return result;
    }
}