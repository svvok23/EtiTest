package com.vstudio.etitest.ui.backup.verify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vstudio.etitest.Mock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val VERIFICATION_STEPS_COUNT = 2
private const val OPTIONS_COUNT = 6
private const val ACTION_DELAY = 1000L

data class VerifyWordsUiState(
    val currentStepIndex: Int = 0,
    val stepsCount: Int = VERIFICATION_STEPS_COUNT,
    val targetWordIndex: Int = 0,
    val wordOptions: List<String> = emptyList(),
    val verificationStatus: VerificationStatus = VerificationStatus.NotVerified,
    val verificationCompleted: Boolean = false,
) {
    sealed class VerificationStatus {
        object Correct : VerificationStatus()
        object Incorrect : VerificationStatus()
        object NotVerified : VerificationStatus() // not selected
    }
}

class VerifyWordsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(VerifyWordsUiState())
    val uiState: StateFlow<VerifyWordsUiState> = _uiState.asStateFlow()

    private val wordsIndexToVerify = generateSequence {
        (0..23).random()
    }
        .distinct()
        .take(VERIFICATION_STEPS_COUNT)
        .toList()
        .sorted()
    private val recoveryWords: List<String> = Mock.RecoveryWords
    private val randomWordsPool: List<String> = Mock.RecoveryWords

    init {
        prepareStep()
    }

    fun onWordSelected(word: String) {
        _uiState.update {
            val verificationStatus = if (verifyWord(
                    selectedWord = word,
                    recoveryWords = recoveryWords,
                    _uiState.value.targetWordIndex
                )
            ) {
                VerifyWordsUiState.VerificationStatus.Correct
            } else {
                VerifyWordsUiState.VerificationStatus.Incorrect
            }
            it.copy(
                verificationStatus = verificationStatus,
            )
        }

        processAction()
    }

    fun resetVerification() {
        _uiState.value = VerifyWordsUiState()
        prepareStep()
    }

    private fun prepareStep(step: Int = 0) = viewModelScope.launch {
        val verifyWordIndex = wordsIndexToVerify[step]
        val wordOptions = configureWordOptions(
            verifyWordIndex,
            recoveryWords,
            randomWordsPool
        )

        _uiState.update {
            it.copy(
                currentStepIndex = step,
                targetWordIndex = verifyWordIndex,
                wordOptions = wordOptions ?: emptyList(),
                verificationStatus = VerifyWordsUiState.VerificationStatus.NotVerified,
                verificationCompleted = step >= VERIFICATION_STEPS_COUNT,
            )
        }
    }

    private fun configureWordOptions(
        wordIndexToVerify: Int,
        recoveryWords: List<String>,
        randomWordsPool: List<String>,
        totalOptionsCount: Int = OPTIONS_COUNT,
    ): List<String>? {
        if (totalOptionsCount < 2) {
            throw IllegalArgumentException("totalOptionsCount must be at least 2")
        }

        if (wordIndexToVerify < 0 || wordIndexToVerify >= recoveryWords.size) {
            throw IllegalArgumentException("wordIndexToVerify or  is incorrect")
        }

        val correctWord = recoveryWords[wordIndexToVerify]
        val numberOfIncorrectOptions = totalOptionsCount - 1

        val incorrectOptions = randomWordsPool
            .filter { it != correctWord }
            .distinct()
            .shuffled()
            .take(numberOfIncorrectOptions)

        val wordOptions = mutableListOf<String>()
        wordOptions.add(correctWord)
        wordOptions.addAll(incorrectOptions)

        return wordOptions.shuffled()
    }

    private fun verifyWord(
        selectedWord: String,
        recoveryWords: List<String>,
        wordIndexToVerify: Int,
    ): Boolean {
        if (wordIndexToVerify < 0 || wordIndexToVerify >= recoveryWords.size) {
            throw IllegalArgumentException("wordIndexToVerify or  is incorrect")
        }

        val correctWord = recoveryWords[wordIndexToVerify]
        return selectedWord == correctWord
    }

    private fun processAction() = viewModelScope.launch {
        val currentState = _uiState.value
        if (currentState.verificationStatus == VerifyWordsUiState.VerificationStatus.Correct) {
            delay(ACTION_DELAY)

            val nextStep = currentState.currentStepIndex + 1
            if (nextStep < VERIFICATION_STEPS_COUNT) {
                prepareStep(nextStep)
            } else {
                _uiState.update {
                    it.copy(
                        verificationCompleted = true,
                    )
                }
            }
        }
    }
}