package com.vstudio.etitest.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vstudio.etitest.ui.backup.manual.ManualBackupScreen
import com.vstudio.etitest.ui.backup.selector.BackupSelectorScreen
import com.vstudio.etitest.ui.backup.verify.VerifyWordsScreen

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
            VerifyWordsScreen(
                onNavigateBack = { navigationRouter.navigateUp() },
                onVerificationCompleted = { navigationRouter.navigateToManualBackupSuccess() }
            )
        }

        composable(NavRoutes.MANUAL_BACKUP_SUCCESS_ROUTE) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Manual Backup Success (route: ${NavRoutes.MANUAL_BACKUP_SUCCESS_ROUTE})",
                    modifier = Modifier
                        .padding(20.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
