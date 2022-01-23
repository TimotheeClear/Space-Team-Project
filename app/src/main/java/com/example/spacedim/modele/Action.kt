package com.example.spacedim.modele

import com.example.spacedim.modele.UIElement

data class Action(
    val sentence: String,
    val uiElement: UIElement,
    val time: Long = 8000
)
