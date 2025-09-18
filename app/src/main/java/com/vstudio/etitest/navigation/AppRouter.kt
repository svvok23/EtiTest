package com.vstudio.etitest.navigation

import androidx.navigation.NavController

class AppRouter(private val navController: NavController) {

    fun navigateToBackupAccount() {
        navController.navigate(BackupAccountScreen.route)
    }

    fun navigateToManualBackupDisplayWords() {
        navController.navigate(ManualBackupDisplayWordsScreen.route)
    }

    fun navigateToManualBackupVerifyWords() {
        navController.navigate(ManualBackupVerifyWordsScreen.route)
    }

    fun navigateToManualBackupSuccess() {
        navController.navigate(ManualBackupSuccessScreen.route) {
            popUpTo(navController.graph.startDestinationId) { inclusive = true }
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }
}
