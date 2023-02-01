package com.example.playground.content.companion

class User private constructor(val nickname: String) {

    companion object {
        // 펙토리 메소드
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))
    }
}