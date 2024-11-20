package com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector

import com.rnk0085.selfcare.R

enum class MoodType(val resourceId: Int) {
    VERY_GOOD(R.drawable.baseline_sentiment_very_satisfied),
    GOOD(R.drawable.baseline_sentiment_satisfied_alt),
    NORMAL(R.drawable.baseline_sentiment_neutral),
    BAD(R.drawable.baseline_sentiment_dissatisfied),
    VERY_BAD(R.drawable.baseline_sentiment_very_dissatisfied),
}