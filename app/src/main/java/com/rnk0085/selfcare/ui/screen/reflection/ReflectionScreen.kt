package com.rnk0085.selfcare.ui.screen.reflection

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.screen.component.NavigationType
import com.rnk0085.selfcare.ui.screen.component.SelfcareTopAppBar
import com.rnk0085.selfcare.ui.screen.reflection.page.ReflectionPage

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
        ReflectionPage(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}

@Composable
@Preview
private fun ReflectionScreenPreview() {
    ReflectionScreen(
        onBackClicked = {},
    )
}
