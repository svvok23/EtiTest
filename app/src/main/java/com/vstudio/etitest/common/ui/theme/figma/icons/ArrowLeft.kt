package com.vstudio.etitest.common.ui.theme.figma.icons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R

@Preview
@Composable
fun ArrowLeftPreview() {
    Icon(
        imageVector = ArrowLeft,
        contentDescription = stringResource(id = R.string.cd_backup_icon_preview),
        tint = Color.White,
        modifier = Modifier.size(124.dp)
    )
}

val ArrowLeft: ImageVector by lazy {
    ImageVector.Builder(
        name = "ArrowLeft",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            stroke = SolidColor(Color.White),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round
        ) {
            moveTo(15.5f, 4f)
            lineTo(8.207f, 11.293f)
            curveTo(7.817f, 11.683f, 7.817f, 12.317f, 8.207f, 12.707f)
            lineTo(15.5f, 20f)
        }
    }.build()
}
