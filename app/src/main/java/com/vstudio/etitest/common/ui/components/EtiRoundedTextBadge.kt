package com.vstudio.etitest.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.common.ui.theme.EtiRoundedTextBadgeDashLength
import com.vstudio.etitest.common.ui.theme.EtiRoundedTextBadgeDashSpace
import com.vstudio.etitest.common.ui.theme.VerifyWordsDefaultBackground
import com.vstudio.etitest.common.ui.theme.VerifyWordsDefaultBorder

@Composable
fun EtiRoundedTextBadge(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    backgroundColor: Color = VerifyWordsDefaultBackground,
    innerBorderColor: Color = VerifyWordsDefaultBorder,
    outerBorderColor: Color = VerifyWordsDefaultBorder,
    innerBorderWidth: Dp = 2.dp,
    outerBorderWidth: Dp = 2.dp,
    isInnerBorderDashed: Boolean = false,
    spaceBetweenBorders: Dp = 8.dp,
    mainCornerRadius: Dp = 16.dp,
    clickable: Boolean = false,
    onClick: () -> Unit = {},
) {
    val extendedCornerRadius = mainCornerRadius + spaceBetweenBorders

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(extendedCornerRadius))
            .clickable(
                enabled = clickable,
                onClick = onClick,
            )
            .then(
                if (outerBorderWidth > 0.dp) {
                    Modifier
                        .border(
                            width = outerBorderWidth,
                            color = outerBorderColor,
                            shape = RoundedCornerShape(extendedCornerRadius)
                        )
                        .padding(spaceBetweenBorders)
                } else {
                    Modifier
                }

            )
            .clip(RoundedCornerShape(mainCornerRadius))
            .background(backgroundColor)
            .then(
                if (innerBorderWidth > 0.dp) {
                    Modifier.drawBehind {
                        val strokeWidthPx = innerBorderWidth.toPx()
                        val inset = strokeWidthPx / 2
                        val cornerRadiusPx = mainCornerRadius.toPx() - inset
                        val drawableRect = size.toRect().deflate(inset)

                        if (isInnerBorderDashed) {
                            val dashPathEffectValues = floatArrayOf(
                                EtiRoundedTextBadgeDashLength.toPx(),
                                EtiRoundedTextBadgeDashSpace.toPx()
                            )
                            val pathEffect = PathEffect.dashPathEffect(dashPathEffectValues, 0f)

                            drawRoundRect(
                                color = innerBorderColor,
                                topLeft = drawableRect.topLeft,
                                size = drawableRect.size,
                                cornerRadius = CornerRadius(
                                    cornerRadiusPx,
                                    cornerRadiusPx
                                ),
                                style = Stroke(
                                    width = strokeWidthPx,
                                    pathEffect = pathEffect
                                )
                            )
                        } else {
                            drawRoundRect(
                                color = innerBorderColor,
                                topLeft = drawableRect.topLeft,
                                size = drawableRect.size,
                                cornerRadius = CornerRadius(
                                    cornerRadiusPx,
                                    cornerRadiusPx
                                ),
                                style = Stroke(width = strokeWidthPx)
                            )
                        }
                    }
                } else {
                    Modifier
                }
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
            maxLines = 1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StatusBadgePreviewCustomColors() {
    MaterialTheme {
        EtiRoundedTextBadge(
            text = "RoundedStatusBadge",
        )
    }
}

