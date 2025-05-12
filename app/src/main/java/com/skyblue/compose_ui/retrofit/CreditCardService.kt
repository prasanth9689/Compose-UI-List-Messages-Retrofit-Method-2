package com.skyblue.compose_ui.retrofit

import com.skyblue.compose_ui.model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("posts")
    suspend fun getCreditCards(): List<CreditCard>
}