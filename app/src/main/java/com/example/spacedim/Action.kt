package com.example.spacedim

data class Action(
    val sentence: String,
    val uiElement: UIElement,
    val time: Long = 8000
)
