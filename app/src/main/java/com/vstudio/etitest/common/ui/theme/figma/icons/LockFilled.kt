package com.vstudio.etitest.common.ui.theme.figma.icons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R

@Preview
@Composable
fun LockFilledPreview() {
    Icon(
        imageVector = LockFilled,
        contentDescription = stringResource(id = R.string.cd_backup_icon_preview),
        tint = Color.White,
        modifier = Modifier.size(124.dp)
    )
}

val LockFilled: ImageVector by lazy {
    ImageVector.Builder(
        name = "LockFilled",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        group(
            clipPathData = PathData {
                moveTo(0f, 0f)
                horizontalLineToRelative(24f)
                verticalLineToRelative(24f)
                horizontalLineToRelative(-24f)
                close()
            }
        ) {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 2f)
                curveTo(15.314f, 2f, 18f, 4.686f, 18f, 8f)
                verticalLineTo(9.605f)
                curveTo(19.141f, 9.837f, 20f, 10.846f, 20f, 12.056f)
                verticalLineTo(19.5f)
                curveTo(20f, 20.881f, 18.881f, 22f, 17.5f, 22f)
                horizontalLineTo(6.5f)
                curveTo(5.119f, 22f, 4f, 20.881f, 4f, 19.5f)
                verticalLineTo(12.056f)
                curveTo(4f, 10.846f, 4.859f, 9.837f, 6f, 9.605f)
                verticalLineTo(8f)
                curveTo(6f, 4.686f, 8.686f, 2f, 12f, 2f)
                close()
                moveTo(13.032f, 13.989f)
                curveTo(12.177f, 13.495f, 11.021f, 13.896f, 10.451f, 14.884f)
                curveTo(9.881f, 15.872f, 10.112f, 17.073f, 10.967f, 17.566f)
                curveTo(11.822f, 18.06f, 12.979f, 17.66f, 13.549f, 16.672f)
                curveTo(14.119f, 15.684f, 13.887f, 14.483f, 13.032f, 13.989f)
                close()
                moveTo(12f, 4f)
                curveTo(9.791f, 4f, 8f, 5.791f, 8f, 8f)
                verticalLineTo(9.556f)
                horizontalLineTo(16f)
                verticalLineTo(8f)
                curveTo(16f, 5.791f, 14.209f, 4f, 12f, 4f)
                close()
            }
        }
    }.build()
}