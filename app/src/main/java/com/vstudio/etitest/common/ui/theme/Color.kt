package com.vstudio.etitest.common.ui.theme

import androidx.compose.ui.graphics.Color
import com.vstudio.etitest.common.fromHex
import com.vstudio.etitest.common.ui.theme.figma.FigmaColors

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val Transparent = Color(0x00000000)

///////////

val BackgroundColor = Color.fromHex(FigmaColors.BackgroundPrimary)

val TextPrimary = Color.fromHex(FigmaColors.TextPrimary)
val TextSecondary = Color.fromHex(FigmaColors.TextSecondary)
val TextTertiary = Color.fromHex(FigmaColors.TextTertiary)
val Error = Color.fromHex(FigmaColors.WarningPrimary)

val EtiActiveBlue = Color.fromHex(FigmaColors.ContentActive)
val EtiActiveBlueBackground = Color.fromHex(FigmaColors.BackgroundActive)
val EtiActiveOrange = Color.fromHex(FigmaColors.WarningPrimary)
val EtiActiveOrangeBackground = Color.fromHex(FigmaColors.WarningSecondary)

val IconBackgroundBlue = Color.fromHex(FigmaColors.IconBackgroundBlue)
val IconBackgroundOrange = Color.fromHex(FigmaColors.IconBackgroundOrange)

val ButtonPrimaryBackground = Color.fromHex(FigmaColors.ButtonPrimaryActiveBackground)
val ButtonPrimaryDisabledBackground = Color.fromHex(FigmaColors.ButtonPrimaryDisabledBackground)
val ButtonPrimaryIconColor = Color.fromHex(FigmaColors.TextPrimary)
val ButtonPrimaryTextColor = Color.fromHex(FigmaColors.TextPrimary)

val ButtonSecondaryBackground = Color.fromHex(FigmaColors.ButtonSecondaryActiveBackground)
val ButtonSecondaryIconColor = Color.fromHex(FigmaColors.IconSecondary)
val ButtonSecondaryTextColor = Color.fromHex(FigmaColors.IconSecondary)

val CardBackgroundColor = Color.fromHex(FigmaColors.Neutral16)
val WordsListBackgroundColor = Color.fromHex(FigmaColors.Neutral10)
val WordsListBorderColor = Color.fromHex(FigmaColors.StrokeDisabled)

val ActiveTextColor = Color.fromHex(FigmaColors.Brand)

val VerifyWordsDefault = Color.fromHex(FigmaColors.Brand)
val VerifyWordsDefaultBackground = Color.fromHex(FigmaColors.BackgroundActive)
val VerifyWordsDefaultBorder = Color.fromHex(FigmaColors.AalienCoinSecondary)

val VerifyWordsIncorrect = Color.fromHex(FigmaColors.DangerPrimary)
val VerifyWordsIncorrectBackground = Color.fromHex(FigmaColors.DangerSecondary)
val VerifyWordsIncorrectBorder = Color.fromHex(FigmaColors.DangerSecondary)

val VerifyWordsCorrect = Color.fromHex(FigmaColors.SuccessPrimary)
val VerifyWordsCorrectBackground = Color.fromHex(FigmaColors.successSecondary)
val VerifyWordsCorrectBorder = Color.fromHex(FigmaColors.successSecondary)

val OptionWordBackground = Color.fromHex(FigmaColors.Neutral16)
val OptionWordStrokeBorder = Color.fromHex(FigmaColors.StrokeDefault)
val OptionWordBorder = Color.fromHex(FigmaColors.Neutral16)

val ProgressIndicatorColor = Color.fromHex(FigmaColors.Brand)
val ProgressIndicatorBackgroundColor = Color.fromHex(FigmaColors.Neutral16)