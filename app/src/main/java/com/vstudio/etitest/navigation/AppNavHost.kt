package com.vstudio.etitest.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vstudio.etitest.ui.backup.manual.ManualBackupScreen
import com.vstudio.etitest.ui.backup.selector.BackupSelectorScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    navigationRouter: AppRouter,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.BACKUP_ACCOUNT_SELECTOR_ROUTE,
        modifier = modifier
    ) {
        composable(NavRoutes.BACKUP_ACCOUNT_SELECTOR_ROUTE) {
            BackupSelectorScreen(
                onNavigateBack = { /*TODO*/ },
                onWhatIsBackupClick = { /*TODO*/ },
                onSafeBackupClick = { /*TODO*/ },
                onManualBackupClick = { navigationRouter.navigateToManualBackupDisplayWords() }
            )
        }

        composable(NavRoutes.MANUAL_BACKUP_DISPLAY_WORDS_ROUTE) {
            ManualBackupScreen(
                onNavigateBack = { navigationRouter.navigateUp() },
                onHowItWorksClick = { /*TODO*/ },
                onContinue = { navigationRouter.navigateToManualBackupVerifyWords() },
            )
        }

        composable(route = NavRoutes.MANUAL_BACKUP_VERIFY_WORDS_ROUTE) {
            /*VerifyWordsScreen(
                onNavigateBack = { navigationRouter.navigateUp() },
                onVerificationCompleted = { navigationRouter.navigateToManualBackupSuccess() }
            )*/
        }

        composable(NavRoutes.MANUAL_BACKUP_SUCCESS_ROUTE) {
            Text("Manual Backup Success (route: ${NavRoutes.MANUAL_BACKUP_SUCCESS_ROUTE})")
        }
    }
}
