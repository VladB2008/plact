package com.example.myapplication.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object SignUp {

    var name by mutableStateOf("")

    var email by mutableStateOf("")

    var agreed by mutableStateOf(false)

    var error by mutableStateOf("")

    fun submit(): Boolean{
        error=when{
            name.isBlank() -> "Введите имя "
            !emailOk() -> "Почта должна быть вида name@mail.ru"
            !agreed -> "Без согласия записать нельзя"
            else -> ""
        }
        return error.isEmpty()
    }

    private fun emailOk(): Boolean{
        val mail = email.trim()
        if(mail.count{it =='@'} !=1) return false
        if (mail.any{it.isWhitespace()}) return false
        val(user, domain) = mail.split('@')
        if(user.isEmpty()) return false
        val parts = domain.split('.')
        return parts.size>=2 && parts.all {it.isNotEmpty()}

    }

}