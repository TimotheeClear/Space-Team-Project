package com.example.spacedim.network

import com.example.spacedim.State

data class User(
    val id: Int,
    val name: String,
    val avatar: String,
    val score: Int,
    var state: State = State.OVER
)
