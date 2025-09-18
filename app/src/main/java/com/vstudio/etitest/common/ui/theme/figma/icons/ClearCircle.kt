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
fun ClearCirclePreview() {
    Icon(
        imageVector = ClearCircle,
        contentDescription = stringResource(id = R.string.cd_backup_icon_preview),
        tint = Color.White,
        modifier = Modifier.size(124.dp)
    )
}

val ClearCircle: ImageVector by lazy {
    ImageVector.Builder(
        name = "ClearCircle",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.White)) {
            moveTo(12f, 2f)
            curveTo(17.523f, 2f, 22f, 6.477f, 22f, 12f)
            curveTo(22f, 17.523f, 17.523f, 22f, 12f, 22f)
            curveTo(6.477f, 22f, 2f, 17.523f, 2f, 12f)
            curveTo(2f, 6.477f, 6.477f, 2f, 12f, 2f)
            close()
            moveTo(15.891f, 8.109f)
            curveTo(15.5f, 7.719f, 14.867f, 7.719f, 14.477f, 8.109f)
            lineTo(12.354f, 10.233f)
            curveTo(12.158f, 10.429f, 11.842f, 10.428f, 11.646f, 10.233f)
            lineTo(9.523f, 8.11f)
            curveTo(9.133f, 7.72f, 8.5f, 7.72f, 8.109f, 8.11f)
            curveTo(7.719f, 8.501f, 7.719f, 9.134f, 8.109f, 9.524f)
            lineTo(10.231f, 11.648f)
            curveTo(10.427f, 11.843f, 10.427f, 12.159f, 10.231f, 12.354f)
            lineTo(8.109f, 14.477f)
            curveTo(7.719f, 14.867f, 7.719f, 15.5f, 8.109f, 15.891f)
            curveTo(8.5f, 16.281f, 9.134f, 16.281f, 9.524f, 15.891f)
            lineTo(11.646f, 13.769f)
            curveTo(11.842f, 13.573f, 12.158f, 13.573f, 12.354f, 13.769f)
            lineTo(14.476f, 15.892f)
            curveTo(14.866f, 16.281f, 15.499f, 16.281f, 15.89f, 15.892f)
            curveTo(16.28f, 15.501f, 16.28f, 14.867f, 15.89f, 14.477f)
            lineTo(13.768f, 12.354f)
            curveTo(13.572f, 12.159f, 13.572f, 11.843f, 13.768f, 11.648f)
            lineTo(15.891f, 9.523f)
            curveTo(16.281f, 9.133f, 16.281f, 8.5f, 15.891f, 8.109f)
            close()
        }
    }.build()
}
