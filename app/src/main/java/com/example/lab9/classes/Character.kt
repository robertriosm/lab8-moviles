package com.example.lab9.classes

import java.io.Serializable

data class Character (
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String = ""
):Serializable
