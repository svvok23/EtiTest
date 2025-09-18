package com.vstudio.etitest.ui.backup.verify

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vstudio.etitest.R
import com.vstudio.etitest.common.ui.components.EtiRoundedTextBadge
import com.vstudio.etitest.common.ui.components.EtiTopAppBar
import com.vstudio.etitest.common.ui.components.PageIndicator
import com.vstudio.etitest.common.ui.components.ScreenTitleBar
import com.vstudio.etitest.common.ui.theme.ContentHorisontalPaddingDefault
import com.vstudio.etitest.common.ui.theme.EtiRoundedTextBadgeHeight
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.common.ui.theme.HorizontalPaddingMedium
import com.vstudio.etitest.common.ui.theme.OptionWordBackground
import com.vstudio.etitest.common.ui.theme.OptionWordBorder
import com.vstudio.etitest.common.ui.theme.OptionWordStrokeBorder
import com.vstudio.etitest.common.ui.theme.ProgressIndicatorBackgroundColor
import com.vstudio.etitest.common.ui.theme.ProgressIndicatorColor
import com.vstudio.etitest.common.ui.theme.ProgressIndicatorCornerRadius
import com.vstudio.etitest.common.ui.theme.ProgressIndicatorPointSize
import com.vstudio.etitest.common.ui.theme.ProgressIndicatorStrokeWidth
import com.vstudio.etitest.common.ui.theme.TitleBarEmptyIconVerticalPadding
import com.vstudio.etitest.common.ui.theme.TitleBarVerticalPadding
import com.vstudio.etitest.common.ui.theme.VerifyWordsCorrect
import com.vstudio.etitest.common.ui.theme.VerifyWordsCorrectBackground
import com.vstudio.etitest.common.ui.theme.VerifyWordsCorrectBorder
import com.vstudio.etitest.common.ui.theme.VerifyWordsDefault
import com.vstudio.etitest.common.ui.theme.VerifyWordsDefaultBackground
import com.vstudio.etitest.common.ui.theme.VerifyWordsDefaultBorder
import com.vstudio.etitest.common.ui.theme.VerifyWordsIncorrect
import com.vstudio.etitest.common.ui.theme.VerifyWordsIncorrectBackground
import com.vstudio.etitest.common.ui.theme.VerifyWordsIncorrectBorder
import com.vstudio.etitest.common.ui.theme.VerticalPaddingSmall
import com.vstudio.etitest.common.ui.theme.figma.icons.ArrowLeft
import com.vstudio.etitest.ui.backup.verify.VerifyWordsUiState.VerificationStatus.Correct
import com.vstudio.etitest.ui.backup.verify.VerifyWordsUiState.VerificationStatus.Incorrect
import com.vstudio.etitest.ui.backup.verify.VerifyWordsUiState.VerificationStatus.NotVerified
import kotlinx.coroutines.delay

private const val NAVIGATION_DELAY = 1000L

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyWordsScreen(
    viewModel: VerifyWordsViewModel = viewModel(),
    onNavigateBack: () -> Unit,
    onVerificationCompleted: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.verificationCompleted) {
        LaunchedEffect(Unit) {
            delay(NAVIGATION_DELAY)
            onVerificationCompleted()
        }
    }

    Scaffold(
        topBar = {
            VerifyWordsTopAppBar(
                progressSize = uiState.stepsCount,
                progressStep = uiState.currentStepIndex,
                onNavigateBack = onNavigateBack
            )
        },
    ) { paddingValues ->
        VerifyWordsContent(
            modifier = Modifier.padding(paddingValues),
            uiState = uiState,
            onWordSelected = { word -> viewModel.onWordSelected(word) },
        )
    }
}

@Composable
private fun VerifyWordsTopAppBar(
    progressSize: Int,
    progressStep: Int,
    onNavigateBack: () -> Unit,
) {
    EtiTopAppBar(
        navigationIcon = ArrowLeft,
        onNavigate = onNavigateBack,
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(ProgressIndicatorCornerRadius))
                .background(ProgressIndicatorBackgroundColor)
                .padding(12.dp)
                .align(Alignment.Center),
        ) {
            PageIndicator(
                numberOfPages = progressSize,
                selectedPage = progressStep,
                selectedColor = ProgressIndicatorColor,
                defaultColor = ProgressIndicatorColor,
                defaultRadius = ProgressIndicatorPointSize,
                selectedLength = ProgressIndicatorStrokeWidth,
                space = ProgressIndicatorPointSize,
            )
        }
    }
}

@Composable
private fun VerifyWordsContent(
    modifier: Modifier = Modifier,
    uiState: VerifyWordsUiState,
    onWordSelected: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = ContentHorisontalPaddingDefault),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(TitleBarEmptyIconVerticalPadding))

        ScreenTitleBar(
            title = stringResource(R.string.verify_words_screen_title),
            subtitle = stringResource(R.string.verify_words_screen_description),
        )

        Spacer(modifier = Modifier.height(TitleBarVerticalPadding))

        val statusTextColor = when (uiState.verificationStatus) {
            NotVerified -> VerifyWordsDefault
            Correct -> VerifyWordsCorrect
            Incorrect -> VerifyWordsIncorrect
        }
        val statusBackgroundColor = when (uiState.verificationStatus) {
            NotVerified -> VerifyWordsDefaultBackground
            Correct -> VerifyWordsCorrectBackground
            Incorrect -> VerifyWordsIncorrectBackground
        }
        val statusBorderColor = when (uiState.verificationStatus) {
            NotVerified -> VerifyWordsDefaultBorder
            Correct -> VerifyWordsCorrectBorder
            Incorrect -> VerifyWordsIncorrectBorder
        }

        EtiRoundedTextBadge(
            modifier = Modifier.heightIn(EtiRoundedTextBadgeHeight),
            text = stringResource(
                R.string.verify_words_choose_word_button_text,
                uiState.targetWordIndex + 1
            ),
            textStyle = MaterialTheme.typography.titleLarge.copy(
                color = statusTextColor
            ),
            backgroundColor = statusBackgroundColor,
            innerBorderColor = statusBorderColor,
            outerBorderColor = statusBorderColor,
        )

        Spacer(modifier = Modifier.height(TitleBarVerticalPadding))


        if (uiState.wordOptions.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(VerticalPaddingSmall),
                horizontalArrangement = Arrangement.spacedBy(HorizontalPaddingMedium),
            ) {
                val areGridItemsClickable = uiState.verificationStatus != Correct

                items(uiState.wordOptions, key = { it }) { word ->
                    EtiRoundedTextBadge(
                        modifier = Modifier.heightIn(EtiRoundedTextBadgeHeight),
                        text = word,
                        textStyle = MaterialTheme.typography.labelLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary
                        ),
                        backgroundColor = OptionWordBackground,
                        innerBorderColor = OptionWordBorder,
                        outerBorderColor = OptionWordStrokeBorder,
                        innerBorderWidth = 1.dp,
                        outerBorderWidth = 2.dp,
                        isInnerBorderDashed = true,
                        clickable = areGridItemsClickable,
                        onClick = { onWordSelected(word) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun VerifyWordsScreenPreview_IncorrectChecked() {
    EtiTestTheme(darkTheme = true) {
        VerifyWordsScreen(
            viewModel = VerifyWordsViewModel(),
            onNavigateBack = {},
            onVerificationCompleted = {}
        )
    }
}

