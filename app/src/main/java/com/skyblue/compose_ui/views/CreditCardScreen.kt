package com.skyblue.compose_ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skyblue.compose_ui.viewmodel.CreditCardViewModel


@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {
    val creditCards by viewModel.creditCards.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (creditCards.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(creditCards) { creditCard ->
                    ListItem(
                        //  modifier = Modifier.clip(MaterialTheme.shapes.small)
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.small)
                        ,
                        headlineContent = {
                            Text(
                                creditCard.title,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1
                                )
                        },
                        supportingContent = {
                            Text(
                                creditCard.body,
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1
                            )
                        },
                        leadingContent = {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "person icon",
                                Modifier
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                                    .padding(10.dp)
                            )
                        }
                    )
                    Divider() // Add a divider between items
                }
            }
        }
    }
}