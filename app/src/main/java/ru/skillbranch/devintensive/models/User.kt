package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
) {

    lateinit var introBit: String

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName,
        lastName,
        null
    )

    constructor(id: String) : this(id, firstName = "John", lastName = "Doe $id")

    init {
        println(
            "It's Alive!!! \n ${if (lastName === "Doe") "His name is $firstName, $lastName" else " And his name is $firstName, $lastName"} \n "
        )
    }


    companion object Factory {
        private var lastId = -1
        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = lastId.toString(), firstName = firstName, lastName = lastName)
        }
    }
}
