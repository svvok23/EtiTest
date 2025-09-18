package com.vstudio.etitest.common.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.vstudio.etitest.common.ui.theme.ButtonPrimaryBackground
import com.vstudio.etitest.common.ui.theme.ButtonPrimaryDisabledBackground

private const val ANIMATION_DURATION = 300

@Composable
fun buttonPrimaryAnimatedColors(isEnabled: Boolean): ButtonColors {

    val animatedBackgroundColor by animateColorAsState(
        targetValue = if (isEnabled) ButtonPrimaryBackground else ButtonPrimaryDisabledBackground,
        animationSpec = tween(ANIMATION_DURATION),
        label = "ContinueButtonBackground"
    )

    val animatedContentColor by animateColorAsState(
        targetValue = if (isEnabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onTertiary,
        animationSpec = tween(ANIMATION_DURATION),
        label = "ContinueButtonBackground"
    )

    return ButtonDefaults.buttonColors(
        containerColor = animatedBackgroundColor,
        contentColor = animatedContentColor,
        disabledContainerColor = animatedBackgroundColor,
        disabledContentColor = animatedContentColor
    )
}