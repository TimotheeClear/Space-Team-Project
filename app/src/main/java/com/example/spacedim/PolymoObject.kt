package com.example.spacedim

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.example.spacedim.modele.Event
import com.example.spacedim.modele.EventType
import com.squareup.moshi.JsonAdapter

object PolymoObject {

    private val moshiSerializer : Moshi = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(Event::class.java,"type")
                .withSubtype(Event.NextAction::class.java, EventType.NEXT_ACTION.name)
                .withSubtype(Event.GameStarted::class.java, EventType.GAME_STARTED.name)
                .withSubtype(Event.GameOver::class.java, EventType.GAME_OVER.name)
                .withSubtype(Event.NextLevel::class.java, EventType.NEXT_LEVEL.name)
                .withSubtype(Event.WaitingForPlayer::class.java, EventType.WAITING_FOR_PLAYER.name)
                .withSubtype(Event.Error::class.java, EventType.ERROR.name)
                .withSubtype(Event.Ready::class.java, EventType.READY.name)
                .withSubtype(Event.PlayerAction::class.java, EventType.PLAYER_ACTION.name)
        )
        .add(KotlinJsonAdapterFactory())
        .build()

    val adapter: JsonAdapter<Event> = moshiSerializer.adapter(Event::class.java)
}