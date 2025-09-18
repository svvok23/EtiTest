package com.vstudio.etitest.common.ui.theme.figma.icons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R

@Preview
@Composable
fun QuestionCirclePreview() {
    Icon(
        imageVector = QuestionCircle,
        contentDescription = stringResource(id = R.string.cd_backup_icon_preview),
        tint = Color.White,
        modifier = Modifier.size(124.dp)
    )
}

val QuestionCircle by lazy {
    ImageVector.Builder(
        name = "QuestionCircle",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(Color.White)) {
            moveTo(8f, 1f)
            curveTo(11.866f, 1f, 15f, 4.134f, 15f, 8f)
            curveTo(15f, 11.866f, 11.866f, 15f, 8f, 15f)
            curveTo(4.134f, 15f, 1f, 11.866f, 1f, 8f)
            curveTo(1f, 4.134f, 4.134f, 1f, 8f, 1f)
            close()
            moveTo(7.756f, 10.488f)
            curveTo(7.229f, 10.488f, 6.801f, 10.893f, 6.801f, 11.408f)
            curveTo(6.801f, 11.924f, 7.229f, 12.328f, 7.756f, 12.328f)
            curveTo(8.289f, 12.328f, 8.717f, 11.923f, 8.717f, 11.408f)
            curveTo(8.717f, 10.893f, 8.289f, 10.488f, 7.756f, 10.488f)
            close()
            moveTo(7.979f, 3.649f)
            curveTo(6.719f, 3.649f, 5.781f, 4.148f, 5.406f, 4.922f)
            curveTo(5.289f, 5.144f, 5.229f, 5.367f, 5.229f, 5.619f)
            curveTo(5.23f, 6.064f, 5.518f, 6.352f, 5.98f, 6.352f)
            curveTo(6.338f, 6.351f, 6.602f, 6.187f, 6.748f, 5.813f)
            curveTo(6.936f, 5.291f, 7.322f, 5.01f, 7.896f, 5.01f)
            curveTo(8.541f, 5.01f, 8.986f, 5.408f, 8.986f, 5.982f)
            curveTo(8.986f, 6.521f, 8.757f, 6.815f, 8.002f, 7.266f)
            curveTo(7.311f, 7.67f, 6.953f, 8.127f, 6.953f, 8.818f)
            verticalLineTo(8.9f)
            curveTo(6.953f, 9.381f, 7.246f, 9.721f, 7.744f, 9.721f)
            curveTo(8.16f, 9.721f, 8.389f, 9.492f, 8.477f, 9.1f)
            curveTo(8.553f, 8.607f, 8.729f, 8.355f, 9.508f, 7.904f)
            curveTo(10.334f, 7.418f, 10.762f, 6.814f, 10.762f, 5.93f)
            curveTo(10.762f, 4.565f, 9.642f, 3.65f, 7.979f, 3.649f)
            close()
        }
    }.build()
}
