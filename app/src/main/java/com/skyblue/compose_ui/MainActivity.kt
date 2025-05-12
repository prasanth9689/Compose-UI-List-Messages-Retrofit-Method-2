package com.skyblue.compose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.skyblue.compose_ui.ui.theme.ComposeUIListMessagesRetrofitMethod2Theme
import com.skyblue.compose_ui.viewmodel.CreditCardViewModel
import com.skyblue.compose_ui.views.CreditCardScreen

class MainActivity : ComponentActivity() {
    private val viewModel: CreditCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUIListMessagesRetrofitMethod2Theme {
                CreditCardScreen(viewModel)
            }
        }
    }
}
