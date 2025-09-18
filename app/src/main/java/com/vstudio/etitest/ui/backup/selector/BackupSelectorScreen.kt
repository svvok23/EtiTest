package com.vstudio.etitest.ui.backup.selector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.R
import com.vstudio.etitest.common.ui.theme.CardBackgroundColor
import com.vstudio.etitest.common.ui.theme.CardContentPadding
import com.vstudio.etitest.common.ui.theme.CardCornerRadius
import com.vstudio.etitest.common.ui.theme.ContentHorisontalPaddingDefault
import com.vstudio.etitest.common.ui.theme.EtiActiveBlue
import com.vstudio.etitest.common.ui.theme.EtiActiveBlueBackground
import com.vstudio.etitest.common.ui.theme.EtiActiveOrange
import com.vstudio.etitest.common.ui.theme.EtiActiveOrangeBackground
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.common.ui.theme.HorizontalPaddingMedium
import com.vstudio.etitest.common.ui.theme.HorizontalPaddingSmall
import com.vstudio.etitest.common.ui.theme.IconBackgroundBlue
import com.vstudio.etitest.common.ui.theme.IconBackgroundOrange
import com.vstudio.etitest.common.ui.theme.IconLabelCircleSize
import com.vstudio.etitest.common.ui.theme.IconSizeMedium
import com.vstudio.etitest.common.ui.theme.ScreenPaddingBottom
import com.vstudio.etitest.common.ui.theme.TagChipHeight
import com.vstudio.etitest.common.ui.theme.TagChipRadius
import com.vstudio.etitest.common.ui.theme.TitleBarVerticalPadding
import com.vstudio.etitest.common.ui.theme.VerticalPaddingSmall
import com.vstudio.etitest.common.ui.components.EtiTopAppBar
import com.vstudio.etitest.common.ui.components.HintChip
import com.vstudio.etitest.common.ui.components.ScreenTitleBar
import com.vstudio.etitest.common.ui.theme.figma.icons.ArrowLeft
import com.vstudio.etitest.common.ui.theme.figma.icons.LockFilled
import com.vstudio.etitest.common.ui.theme.figma.icons.QuestionCircle
import com.vstudio.etitest.common.ui.theme.figma.images.Alien
import com.vstudio.etitest.common.ui.theme.figma.images.Edit
import com.vstudio.etitest.common.ui.theme.labelXSmall
import com.vstudio.etitest.common.ui.theme.paragraphMedium
import com.vstudio.etitest.common.ui.theme.paragraphSmall

@Composable
fun BackupSelectorScreen(
    onNavigateBack: () -> Unit,
    onWhatIsBackupClick: () -> Unit,
    onSafeBackupClick: () -> Unit,
    onManualBackupClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BackupScreenTopAppBar(onNavigateBack = onNavigateBack)
        },
        bottomBar = {
            BackupScreenBottomBar(onHintButtonClick = onWhatIsBackupClick)
        },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = ContentHorisontalPaddingDefault)
        ) {

            Spacer(modifier = Modifier.height(HorizontalPaddingMedium))

            ScreenTitleBar(
                title = stringResource(id = R.string.backup_selector_screen_title),
                subtitle = stringResource(id = R.string.backup_selector_screen_subtitle),
            )

            Spacer(modifier = Modifier.height(TitleBarVerticalPadding))

            Text(
                text = stringResource(id = R.string.backup_selector_section_title),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onTertiary,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(VerticalPaddingSmall))

            BackupOptionCard(
                iconPainter = Alien,
                iconBackgroundColor = IconBackgroundBlue,
                title = stringResource(id = R.string.backup_selector_alien_backup_title),
                description = stringResource(id = R.string.backup_selector_alien_backup_description),
                tagText = stringResource(id = R.string.backup_selector_tag_recommended),
                tagTextColor = EtiActiveBlue,
                tagBackgroundColor = EtiActiveBlueBackground,
                onClick = onSafeBackupClick
            )

            Spacer(modifier = Modifier.height(VerticalPaddingSmall))

            BackupOptionCard(
                iconPainter = Edit,
                iconBackgroundColor = IconBackgroundOrange,
                title = stringResource(id = R.string.backup_selector_manual_backup_title),
                description = stringResource(id = R.string.backup_selector_manual_backup_description),
                tagText = stringResource(id = R.string.backup_selector_tag_careful),
                tagTextColor = EtiActiveOrange,
                tagBackgroundColor = EtiActiveOrangeBackground,
                onClick = onManualBackupClick
            )
        }
    }
}

@Composable
private fun BackupScreenTopAppBar(
    onNavigateBack: () -> Unit,
) {
    EtiTopAppBar(
        navigationIcon = ArrowLeft,
        onNavigate = onNavigateBack,
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

@Composable
private fun BackupOptionCard(
    iconPainter: Painter,
    iconBackgroundColor: Color,
    title: String,
    description: String,
    tagText: String,
    tagTextColor: Color,
    tagBackgroundColor: Color,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(CardCornerRadius))
            .background(CardBackgroundColor)
            .clickable(onClick = onClick)
            .padding(CardContentPadding),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(IconLabelCircleSize)
                .clip(CircleShape)
                .background(iconBackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = iconPainter,
                contentDescription = stringResource(id = R.string.cd_backup_option_icon),
                modifier = Modifier.size(IconSizeMedium)
            )
        }

        Spacer(modifier = Modifier.width(HorizontalPaddingMedium))

        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.paragraphMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(HorizontalPaddingSmall))
                TagChip(
                    text = tagText,
                    textColor = tagTextColor,
                    backgroundColor = tagBackgroundColor
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.paragraphSmall,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
private fun TagChip(
    text: String,
    textColor: Color,
    backgroundColor: Color,
) {
    Box(
        modifier = Modifier
            .height(TagChipHeight)
            .clip(RoundedCornerShape(TagChipRadius))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.labelXSmall,
        )
    }
}

@Composable
private fun BackupScreenBottomBar(onHintButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = ContentHorisontalPaddingDefault)
            .padding(bottom = ScreenPaddingBottom),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HintChip(
            text = stringResource(id = R.string.backup_selector_what_is_backup_button),
            icon = QuestionCircle,
            onClick = onHintButtonClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BackupScreenPreview() {
    EtiTestTheme(darkTheme = true) {
        BackupSelectorScreen(
            onNavigateBack = {},
            onWhatIsBackupClick = {},
            onSafeBackupClick = {},
            onManualBackupClick = {}
        )
    }
}