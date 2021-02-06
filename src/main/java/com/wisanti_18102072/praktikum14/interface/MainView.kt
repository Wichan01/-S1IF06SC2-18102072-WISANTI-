package com.wisanti_18102072.praktikum14.`interface`

import android.widget.Toast
import com.wisanti_18102072.praktikum14.model.Login
import com.wisanti_18102072.praktikum14.model.Quote


interface MainView {
    fun showMessage(messsage: String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)

}
