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
fun SuccessCirclePreview() {
    Icon(
        imageVector = SuccessCircle,
        contentDescription = stringResource(id = R.string.cd_backup_icon_preview),
        tint = Color.White,
        modifier = Modifier.size(124.dp)
    )
}

val SuccessCircle: ImageVector by lazy {
    ImageVector.Builder(
        name = "SuccessCircle",
        defaultWidth = 25.dp,
        defaultHeight = 24.dp,
        viewportWidth = 25f,
        viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.White)) {
            moveTo(12.5f, 2f)
            curveTo(18.023f, 2f, 22.5f, 6.477f, 22.5f, 12f)
            curveTo(22.5f, 17.523f, 18.023f, 22f, 12.5f, 22f)
            curveTo(6.977f, 22f, 2.5f, 17.523f, 2.5f, 12f)
            curveTo(2.5f, 6.477f, 6.977f, 2f, 12.5f, 2f)
            close()
            moveTo(17.897f, 8.972f)
            curveTo(17.511f, 8.577f, 16.878f, 8.57f, 16.483f, 8.956f)
            lineTo(11.553f, 13.776f)
            lineTo(9.238f, 11.462f)
            curveTo(8.848f, 11.072f, 8.215f, 11.072f, 7.824f, 11.462f)
            curveTo(7.434f, 11.852f, 7.434f, 12.485f, 7.824f, 12.876f)
            lineTo(10.314f, 15.366f)
            curveTo(10.993f, 16.044f, 12.09f, 16.05f, 12.775f, 15.38f)
            lineTo(17.882f, 10.386f)
            curveTo(18.276f, 10f, 18.283f, 9.366f, 17.897f, 8.972f)
            close()
        }
    }.build()
}
