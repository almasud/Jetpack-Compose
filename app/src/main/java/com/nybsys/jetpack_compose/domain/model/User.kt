package com.nybsys.jetpack_compose.domain.model

/**
 * Created by Md. Abdullah Al Masud on 22/11/22.
 * Email: dev.almasud@gmail.com
 */
data class User(
    val id: Int,
    val name: String,
    val profileUrl: String? = null
)
