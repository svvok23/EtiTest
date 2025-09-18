package com.vstudio.etitest.common.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R
import com.vstudio.etitest.common.EMPTY
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.common.ui.theme.ScreenTitlePadding
import com.vstudio.etitest.common.ui.theme.figma.icons.QuestionCircle
import com.vstudio.etitest.common.ui.theme.paragraphSmall

@Composable
fun ScreenTitleBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: AnnotatedString,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                textAlign = TextAlign.Center
            ),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ScreenTitlePadding)
        )

        if (subtitle.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.paragraphSmall.copy(
                    textAlign = TextAlign.Center
                ),
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = ScreenTitlePadding)
            )
        }
    }
}

@Composable
fun ScreenTitleBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String = String.EMPTY,
) = ScreenTitleBar(
    title = title,
    modifier = modifier,
    subtitle = AnnotatedString(subtitle)
)

@Preview(showBackground = true)
@Composable
fun ScreenTitleBarPreview() {
    EtiTestTheme(darkTheme = true) {
        ScreenTitleBar(
            title = stringResource(R.string.backup_selector_screen_title),
            subtitle = stringResource(R.string.backup_selector_screen_subtitle)
        )
    }
}