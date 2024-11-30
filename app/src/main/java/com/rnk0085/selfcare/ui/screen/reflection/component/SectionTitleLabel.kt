package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.sectionContentColor

@Composable
internal fun SectionTitleLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = sectionContentColor,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun SectionTitleLabelPreview() {
    SelfcareTheme {
        SectionTitleLabel(
            text = "タイトル",
        )
    }
}
