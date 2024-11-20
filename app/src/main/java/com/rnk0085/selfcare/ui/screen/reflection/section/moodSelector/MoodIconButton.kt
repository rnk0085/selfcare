package com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme


@Composable
internal fun MoodIconButton(
    moodType: MoodType,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val iconColor = if (isSelected) Color.Black else Color.LightGray

    // TODO: アイコンサイズを大きくする
    // TODO: アイコンごとに色を設定する
    IconButton(onClick) {
        Icon(
            painter = painterResource(moodType.resourceId),
            contentDescription = null,
            tint = iconColor,
        )
    }
}

@Preview
@Composable
private fun MoodIconButtonPreview() {
    SelfcareTheme {
        MoodIconButton(
            moodType = MoodType.NORMAL,
            isSelected = false,
            onClick = {},
        )
    }
}
