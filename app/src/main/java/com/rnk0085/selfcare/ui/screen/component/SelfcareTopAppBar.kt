package com.rnk0085.selfcare.ui.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SelfcareTopAppBar(
    title: String,
    navigationType: NavigationType?,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        navigationIcon = {
            if (navigationType is NavigationType.Back) {
                IconButton(onClick = navigationType.onClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            }
        },
    )
}

sealed interface NavigationType {
    val onClick: () -> Unit

    data class Back(override val onClick: () -> Unit) : NavigationType
}

class NavigationTypeProvider : PreviewParameterProvider<NavigationType?> {
    override val values = sequenceOf(
        null,
        NavigationType.Back(onClick = {}),
    )
}

@Composable
@Preview
private fun SelfcareTopAppBarPreview(
    @PreviewParameter(NavigationTypeProvider::class) navigationType: NavigationType?,
) {
    SelfcareTheme {
        SelfcareTopAppBar(
            title = "タイトル",
            navigationType = navigationType,
        )
    }
}
