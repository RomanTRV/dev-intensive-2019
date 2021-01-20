package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMassage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val data: Date = Date()
) {
    abstract fun formatMessage(): String

    companion object AbstractFactory {
        var lastId = -1
        fun makeMessage(
            from: User?,
            chat: Chat,
            data: Date = Date(),
            type: String = "text",
            payload: Any?
        ): BaseMassage {
            lastId++
            return when (type) {
                "image" -> ImageMessage(
                    "$lastId",
                    from,
                    chat,
                    data = data,
                    image = payload as String
                )
                else -> TextMessage(
                    "$lastId",
                    from,
                    chat,
                    data = data,
                    text = payload as String
                )
            }
        }
    }
}