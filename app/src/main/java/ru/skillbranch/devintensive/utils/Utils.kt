package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val parts: List<String>? = payload?.split(divider)
        var nickname: String =""


        if (parts != null) {
            for (i in parts.indices) {

                var latinName: String = ""

                for (init in parts[i]) {
                    latinName += when (init) {
                        'А', 'а' -> "a"
                        'Б', 'б' -> "b"
                        'В', 'в' -> "v"
                        'Г', 'г' -> "g"
                        'Д', 'д' -> "d"
                        'Е', 'е' -> "e"
                        'Ё', 'ё' -> "jo"
                        'Ж', 'ж' -> "zh"
                        'З', 'з' -> "z"
                        'И', 'и' -> "i"
                        'Й', 'й' -> "y"
                        'К', 'к' -> "k"
                        'Л', 'л' -> "l"
                        'М', 'м' -> "m"
                        'Н', 'н' -> "n"
                        'О', 'о' -> "o"
                        'П', 'п' -> "p"
                        'Р', 'р' -> "r"
                        'С', 'с' -> "s"
                        'Т', 'т' -> "t"
                        'У', 'у' -> "u"
                        'Ф', 'ф' -> "f"
                        'Х', 'х' -> "kh"
                        'Ц', 'ц' -> "c"
                        'Ч', 'ч' -> "ch"
                        'Ш', 'ш' -> "sh"
                        'Щ', 'щ' -> "shh"
                        'Ъ', 'ъ' -> "jhh"
                        'Ы', 'ы' -> "ih"
                        'Ь', 'ь' -> "jh"
                        'Э', 'э' -> "eh"
                        'Ю', 'ю' -> "ju"
                        'Я', 'я' -> "ja"
                        else -> "_"
                    }

                }
                nickname += latinName.capitalize()
            }
        }
        return nickname
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        return "${firstName?.capitalize()?.firstOrNull()}${lastName?.capitalize()?.firstOrNull()}"
    }


}

