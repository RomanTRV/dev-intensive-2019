package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extention.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    data: Date = Date(),
    var image: String?
):BaseMassage(id, from, chat, isIncoming, data ) {
    override fun formatMessage(): String =
        "id:$id, ${from?.firstName}, ${if (isIncoming) "Получил" else "Отправил"} изображение \"$image\" ${data.humanizeDiff()}"


}