package com.rnk0085.selfcare.ui.screen.reflection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.screen.component.NavigationType
import com.rnk0085.selfcare.ui.screen.component.SelfcareTopAppBar

@Composable
internal fun ReflectionScreen(
    onBackClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            SelfcareTopAppBar(
                title = "ふりかえり",
                navigationType = NavigationType.Back(onClick = onBackClicked),
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("ふりかえり画面")

            Button(onClick = { /* TODO */ }) {
                Text("記録する")
            }
        }
    }
}

@Composable
@Preview
private fun ReflectionScreenPreview() {
    ReflectionScreen(
        onBackClicked = {},
    )
}
