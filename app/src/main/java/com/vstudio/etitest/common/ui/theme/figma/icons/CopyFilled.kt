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
fun CopyFilledPreview() {
    Icon(
        imageVector = CopyFilled,
        contentDescription = stringResource(id = R.string.cd_backup_icon_preview),
        tint = Color.White,
        modifier = Modifier.size(124.dp)
    )
}

val CopyFilled: ImageVector by lazy {
    ImageVector.Builder(
        name = "CopyFilled",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(Color.White)) {
            moveTo(9.667f, 4.667f)
            curveTo(9.867f, 4.667f, 10.059f, 4.704f, 10.236f, 4.769f)
            curveTo(10.258f, 4.776f, 10.28f, 4.783f, 10.301f, 4.792f)
            curveTo(10.326f, 4.802f, 10.35f, 4.815f, 10.375f, 4.826f)
            curveTo(10.396f, 4.836f, 10.416f, 4.846f, 10.436f, 4.856f)
            curveTo(10.472f, 4.875f, 10.506f, 4.894f, 10.539f, 4.915f)
            curveTo(10.546f, 4.919f, 10.554f, 4.923f, 10.561f, 4.928f)
            curveTo(10.595f, 4.95f, 10.628f, 4.973f, 10.66f, 4.997f)
            curveTo(10.671f, 5.005f, 10.681f, 5.012f, 10.691f, 5.021f)
            curveTo(10.717f, 5.04f, 10.741f, 5.061f, 10.766f, 5.082f)
            curveTo(10.783f, 5.098f, 10.8f, 5.114f, 10.817f, 5.131f)
            curveTo(10.837f, 5.149f, 10.856f, 5.168f, 10.874f, 5.188f)
            curveTo(10.889f, 5.203f, 10.903f, 5.218f, 10.917f, 5.233f)
            curveTo(10.94f, 5.259f, 10.961f, 5.285f, 10.982f, 5.313f)
            curveTo(10.992f, 5.325f, 11.002f, 5.338f, 11.012f, 5.352f)
            curveTo(11.031f, 5.378f, 11.05f, 5.406f, 11.067f, 5.434f)
            curveTo(11.08f, 5.453f, 11.092f, 5.472f, 11.104f, 5.492f)
            curveTo(11.117f, 5.515f, 11.13f, 5.538f, 11.143f, 5.562f)
            curveTo(11.154f, 5.583f, 11.163f, 5.605f, 11.174f, 5.627f)
            curveTo(11.187f, 5.656f, 11.201f, 5.685f, 11.213f, 5.715f)
            curveTo(11.215f, 5.72f, 11.217f, 5.725f, 11.219f, 5.729f)
            curveTo(11.292f, 5.917f, 11.333f, 6.12f, 11.333f, 6.333f)
            verticalLineTo(12.333f)
            curveTo(11.333f, 13.253f, 10.587f, 14f, 9.667f, 14f)
            horizontalLineTo(3.667f)
            curveTo(2.747f, 14f, 2f, 13.253f, 2f, 12.333f)
            verticalLineTo(6.333f)
            curveTo(2f, 5.413f, 2.747f, 4.667f, 3.667f, 4.667f)
            horizontalLineTo(9.667f)
            close()
            moveTo(12.334f, 2f)
            curveTo(13.254f, 2f, 14f, 2.747f, 14f, 3.667f)
            verticalLineTo(9.667f)
            curveTo(14f, 10.33f, 13.613f, 10.902f, 13.053f, 11.17f)
            curveTo(12.863f, 11.262f, 12.667f, 11.103f, 12.667f, 10.892f)
            verticalLineTo(6.334f)
            curveTo(12.667f, 4.677f, 11.323f, 3.334f, 9.667f, 3.334f)
            horizontalLineTo(5.109f)
            curveTo(4.898f, 3.334f, 4.739f, 3.138f, 4.83f, 2.948f)
            curveTo(5.099f, 2.387f, 5.671f, 2f, 6.334f, 2f)
            horizontalLineTo(12.334f)
            close()
        }
    }.build()
}
