package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extention.TimeUnits
import ru.skillbranch.devintensive.extention.add
import ru.skillbranch.devintensive.extention.format
import ru.skillbranch.devintensive.extention.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")

    }

    @Test
    fun test_factory() {
//        val user = User.Factory.makeUser("John Cena")
//        val user1 = User.Factory.makeUser("John Wich")
        val user2 = User.Factory.makeUser("John Wick")
        val user = user2.copy("2", lastName = "John Cena", lastVisit = Date())

        println("$user2 \n $user")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, fistName, lastName) = getUserInfo()

        println("$id, $fistName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent()
        )
    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Роман Травушкин",)
        val user2 = user.copy(isOnline = true)
        println(user2)

        val userView = user2.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstractFactory() {
        val user = User.makeUser("John Wick")
        val textMessage =
            BaseMassage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imageMessage = BaseMassage.makeMessage(
            user,
            Chat("0"),
            payload = "any image url message",
            type = "image"
        )

        println(textMessage.formatMessage())
        println(imageMessage.formatMessage())
    }
}