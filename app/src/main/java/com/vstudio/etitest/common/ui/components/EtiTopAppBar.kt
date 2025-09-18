package com.vstudio.etitest.common.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.common.ui.theme.IconSizeMedium
import com.vstudio.etitest.common.ui.theme.TopBarHeight
import com.vstudio.etitest.common.ui.theme.TopBarHorizontalPadding
import com.vstudio.etitest.common.ui.theme.TopBarVerticalPadding
import com.vstudio.etitest.common.ui.theme.figma.icons.ArrowLeft
import com.vstudio.etitest.common.ui.theme.figma.icons.LockFilled
import com.vstudio.etitest.common.ui.theme.figma.icons.QuestionCircle

@Composable
fun EtiTopAppBar(
    windowInsets: WindowInsets = WindowInsets.statusBars,
    navigationIcon: ImageVector? = null,
    onNavigate: (() -> Unit)? = null,
    content: @Composable (BoxScope.() -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(windowInsets)
            .height(TopBarHeight)
            .padding(
                vertical = TopBarVerticalPadding,
                horizontal = TopBarHorizontalPadding
            )
    ) {
        if (navigationIcon != null && onNavigate != null) {
            IconButton(
                onClick = onNavigate,
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = stringResource(id = R.string.cd_navigate),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        content?.let { content() }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScreenTopAppBarBack() {
    EtiTestTheme(darkTheme = true) {
        EtiTopAppBar(
            navigationIcon = ArrowLeft,
            onNavigate = { /* Handle navigation */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScreenTopAppBarIcon() {
    EtiTestTheme(darkTheme = true) {
        EtiTopAppBar(
            navigationIcon = ArrowLeft,
            onNavigate = { /* Handle navigation */ },
        ) {
            Icon(
                imageVector = LockFilled,
                contentDescription = stringResource(id = R.string.cd_lock_icon),
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(IconSizeMedium)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScreenTopAppBarAction() {
    EtiTestTheme(darkTheme = true) {
        EtiTopAppBar(
            navigationIcon = ArrowLeft,
            onNavigate = { /* Handle navigation */ },
        ) {
            HintChip(
                text = stringResource(id = R.string.manual_backup_how_it_works_button),
                icon = QuestionCircle,
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                onClick = { /* Handle action */ },
            )
        }
    }
}

