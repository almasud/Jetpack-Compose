package com.nybsys.jetpack_compose.data

import com.nybsys.jetpack_compose.domain.model.User

/**
 * Created by Md. Abdullah Al Masud on 22/11/22.
 * Email: dev.almasud@gmail.com
 */
object DataProvider {
    val userList: List<User> = listOf(
        User(id = 1, name = "Abdullah"),
        User(id = 2, name = "Almasud"),
        User(id = 3, name = "Soumik"),
        User(id = 4, name = "Bhattacharjee"),
        User(id = 5, name = "Sheikh"),
        User(id = 6, name = "Faisal"),
        User(id = 7, name = "Kabir"),
        User(id = 8, name = "Wali"),
        User(id = 9, name = "Ahad"),
    )
}