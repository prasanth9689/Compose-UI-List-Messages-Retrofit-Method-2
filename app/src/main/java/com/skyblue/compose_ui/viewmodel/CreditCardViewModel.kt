package com.skyblue.compose_ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyblue.compose_ui.model.CreditCard
import com.skyblue.compose_ui.repository.CreditCardRepository
import kotlinx.coroutines.launch

class CreditCardViewModel : ViewModel() {
    private val repository = CreditCardRepository()

    private val _creditCards = MutableLiveData<List<CreditCard>>()
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCards()
                _creditCards.value = cards
            } catch (e: Exception) {
                // Handle error
                Log.e("err__", e.message.toString())
            }
        }
    }
}