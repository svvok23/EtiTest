package com.vstudio.etitest.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R
import com.vstudio.etitest.common.ui.theme.ButtonHeightDefault
import com.vstudio.etitest.common.ui.theme.ButtonSecondaryBackground
import com.vstudio.etitest.common.ui.theme.ButtonSecondaryHeight
import com.vstudio.etitest.common.ui.theme.ButtonSecondaryIconColor
import com.vstudio.etitest.common.ui.theme.ButtonSecondaryIconSize
import com.vstudio.etitest.common.ui.theme.ButtonSecondaryTextColor
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.common.ui.theme.figma.icons.QuestionCircle

@Composable
fun HintChip(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(ButtonHeightDefault))
            .clickable(onClick = onClick)
            .minimumInteractiveComponentSize()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(ButtonSecondaryHeight))
                .background(ButtonSecondaryBackground)
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                color = ButtonSecondaryTextColor,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = ButtonSecondaryIconColor,
                modifier = Modifier.size(ButtonSecondaryIconSize)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HintChipPreview() {
    EtiTestTheme(darkTheme = true) {
        HintChip(
            text = stringResource(id = R.string.backup_selector_what_is_backup_button),
            icon = QuestionCircle,
            onClick = {}
        )
    }
}