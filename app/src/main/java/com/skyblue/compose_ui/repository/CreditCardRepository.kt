package com.skyblue.compose_ui.repository

import com.skyblue.compose_ui.model.CreditCard
import com.skyblue.compose_ui.retrofit.RetrofitInstance

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}