package com.vstudio.etitest.ui.backup.manual

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.Clipboard
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vstudio.etitest.Mock
import com.vstudio.etitest.R
import com.vstudio.etitest.common.SPACE
import com.vstudio.etitest.common.ui.theme.ActiveTextColor
import com.vstudio.etitest.common.ui.theme.ButtonHeightDefault
import com.vstudio.etitest.common.ui.theme.ButtonRadiusDefault
import com.vstudio.etitest.common.ui.theme.CardBorderSize
import com.vstudio.etitest.common.ui.theme.CardContentPadding
import com.vstudio.etitest.common.ui.theme.CardCornerRadius
import com.vstudio.etitest.common.ui.theme.ContentHorisontalPaddingDefault
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.common.ui.theme.HorizontalPaddingSmall
import com.vstudio.etitest.common.ui.theme.IconSizeLarge
import com.vstudio.etitest.common.ui.theme.IconSizeSmall
import com.vstudio.etitest.common.ui.theme.ScreenPaddingBottom
import com.vstudio.etitest.common.ui.theme.TitleBarVerticalPadding
import com.vstudio.etitest.common.ui.theme.VerticalPaddingLarge
import com.vstudio.etitest.common.ui.theme.VerticalPaddingMedium
import com.vstudio.etitest.common.ui.theme.VerticalPaddingSmall
import com.vstudio.etitest.common.ui.theme.WordsListBackgroundColor
import com.vstudio.etitest.common.ui.theme.WordsListBorderColor
import com.vstudio.etitest.common.ui.components.EtiTopAppBar
import com.vstudio.etitest.common.ui.components.HintChip
import com.vstudio.etitest.common.ui.components.ScreenTitleBar
import com.vstudio.etitest.common.ui.components.buttonPrimaryAnimatedColors
import com.vstudio.etitest.common.ui.theme.figma.icons.ArrowLeft
import com.vstudio.etitest.common.ui.theme.figma.icons.CopyFilled
import com.vstudio.etitest.common.ui.theme.figma.icons.QuestionCircle
import com.vstudio.etitest.common.ui.theme.figma.images.WriteDown
import com.vstudio.etitest.common.ui.theme.paragraphSmall
import com.vstudio.etitest.common.ui.theme.paragraphXSmall
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TIMER_START_VALUE = 5

@Composable
fun ManualBackupScreen(
    onNavigateBack: () -> Unit,
    onHowItWorksClick: () -> Unit,
    onContinue: () -> Unit,
    // TODO: use ViewModel
    recoveryWords: List<String> = Mock.RecoveryWords,
) {
    val clipboardManager = LocalClipboard.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            ManualBackupScreenTopAppBar(
                onNavigateBack = onNavigateBack,
                onHintClick = onHowItWorksClick,
            )
        },
        bottomBar = {
            ButtonBottomBar(
                onClick = onContinue
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = ContentHorisontalPaddingDefault),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(VerticalPaddingSmall))

            Image(
                painter = WriteDown,
                contentDescription = null,
                modifier = Modifier.size(IconSizeLarge)
            )

            Spacer(Modifier.height(VerticalPaddingSmall))

            val annotatedSubtitle = buildAnnotatedString {
                append(stringResource(id = R.string.manual_backup_screen_subtitle_part1))
                append(String.SPACE)
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    append(stringResource(id = R.string.manual_backup_screen_subtitle_part2_bold))
                }
            }

            ScreenTitleBar(
                title = stringResource(id = R.string.manual_backup_screen_title),
                subtitle = annotatedSubtitle,
            )

            Spacer(Modifier.height(TitleBarVerticalPadding))

            WordsTable(words = recoveryWords)

            Spacer(Modifier.height(VerticalPaddingSmall))

            val copiedMessage = stringResource(id = R.string.manual_backup_words_copied_message)
            val copiedLabel = stringResource(R.string.backup_selector_screen_title)
            TextButton(
                onClick = {
                    scope.launch {

                        copyWordsToClipboard(
                            words = recoveryWords,
                            label = copiedLabel,
                            clipboardManager = clipboardManager,
                        ) {
                            /*scope.launch {
                            snackbarHostState.showSnackbar(
                                message = copiedMessage,
                                duration = SnackbarDuration.Short,
                            )
                        }*/
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = CopyFilled,
                    contentDescription = stringResource(id = R.string.cd_copy_to_clipboard_icon),
                    tint = ActiveTextColor,
                    modifier = Modifier.size(IconSizeSmall)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = stringResource(id = R.string.manual_backup_copy_to_clipboard_button),
                    style = MaterialTheme.typography.labelMedium,
                    color = ActiveTextColor,
                )
            }

            Spacer(Modifier.height(VerticalPaddingLarge))
        }
    }
}

@Composable
fun WordsTable(words: List<String>) {
    val halfSize = (words.size + 1) / 2
    val firstColumnWords = words.subList(0, halfSize)
    val secondColumnWords = words.subList(halfSize, words.size)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(CardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = WordsListBackgroundColor
        ),
        border = BorderStroke(
            width = CardBorderSize,
            color = WordsListBorderColor
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CardContentPadding),
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(firstColumnWords) { indexInColumn, word ->
                    WordItem(
                        index = indexInColumn + 1,
                        word = word,
                    )
                }
            }

            VerticalDivider(
                color = WordsListBorderColor,
                thickness = CardBorderSize,
                modifier = Modifier.fillMaxHeight()
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = CardContentPadding),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(secondColumnWords) { indexInColumn, word ->
                    WordItem(
                        index = indexInColumn + halfSize + 1,
                        word = word,
                    )
                }
            }
        }
    }
}

@Composable
private fun WordItem(index: Int, word: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = index.toString(),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.paragraphXSmall,
            modifier = Modifier.width(18.dp)
        )
        Spacer(Modifier.width(HorizontalPaddingSmall))
        Text(
            text = word,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.paragraphSmall,
        )
    }
}

@Composable
private fun ManualBackupScreenTopAppBar(
    onNavigateBack: () -> Unit,
    onHintClick: () -> Unit,
) {
    EtiTopAppBar(
        navigationIcon = ArrowLeft,
        onNavigate = onNavigateBack,
    ) {
        HintChip(
            text = stringResource(id = R.string.manual_backup_how_it_works_button),
            icon = QuestionCircle,
            modifier = Modifier
                .align(Alignment.CenterEnd),
            onClick = onHintClick,
        )
    }
}

@Composable
private fun ButtonBottomBar(onClick: () -> Unit) {
    var countdownSeconds by rememberSaveable { mutableIntStateOf(TIMER_START_VALUE) }
    var isContinueButtonEnabled by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(countdownSeconds) {
        while (countdownSeconds > 0) {
            delay(1000L)
            countdownSeconds--
        }
        isContinueButtonEnabled = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = ContentHorisontalPaddingDefault)
            .padding(bottom = ScreenPaddingBottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        @Composable
        fun getButtonText(): AnnotatedString = if (isContinueButtonEnabled) {
            AnnotatedString(stringResource(R.string.continue_button))
        } else {
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                ) {
                    append(stringResource(id = R.string.manual_backup_continue_button_countdown_text))
                    append(String.SPACE)
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    append(countdownSeconds.toString())
                    append(String.SPACE)
                    append(stringResource(id = R.string.manual_backup_continue_button_countdown_sec))
                }
            }
        }

        Button(
            onClick = { if (isContinueButtonEnabled) onClick() },
            enabled = isContinueButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(ButtonHeightDefault),
            shape = RoundedCornerShape(ButtonRadiusDefault),
            colors = buttonPrimaryAnimatedColors(isEnabled = isContinueButtonEnabled)
        ) {
            Text(
                text = getButtonText(),
                style = MaterialTheme.typography.labelLarge
            )
        }

        Spacer(modifier = Modifier.height(VerticalPaddingMedium))
    }
}

private suspend fun copyWordsToClipboard(
    words: List<String>,
    clipboardManager: Clipboard,
    label: String,
    onCopied: (String) -> Unit = {},
) {
    val textToCopy = buildString {
        words.forEachIndexed { index, word ->
            append("${index + 1} $word")
            if (index < words.size - 1) {
                appendLine()
            }
        }
    }
    val clipData = android.content.ClipData.newPlainText(
        label,
        textToCopy
    )
    val clipEntry = ClipEntry(clipData)
    clipboardManager.setClipEntry(clipEntry)
    onCopied(textToCopy)
}

@Preview(showBackground = true)
@Composable
private fun ManualBackupScreenPreview() {
    EtiTestTheme(darkTheme = true) {
        ManualBackupScreen(
            onNavigateBack = {},
            onHowItWorksClick = {},
            onContinue = {},
        )
    }
}
