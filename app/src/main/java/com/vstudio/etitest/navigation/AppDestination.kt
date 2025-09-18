package com.vstudio.etitest.navigation

interface AppDestination {
    val route: String
}

object NavRoutes {
    const val BACKUP_ACCOUNT_SELECTOR_ROUTE = "backup_account_selector"
    //    const val MANUAL_BACKUP_INTRO_ROUTE = "manual_backup_intro"
    const val MANUAL_BACKUP_DISPLAY_WORDS_ROUTE = "manual_backup_display_words"
    const val MANUAL_BACKUP_VERIFY_WORDS_ROUTE = "manual_backup_verify_words"
    const val MANUAL_BACKUP_SUCCESS_ROUTE = "manual_backup_success"
}

object BackupAccountScreen : AppDestination {
    override val route = NavRoutes.BACKUP_ACCOUNT_SELECTOR_ROUTE
}

/*object ManualBackupIntroScreen : AppDestination {
    override val route = NavRoutes.MANUAL_BACKUP_INTRO_ROUTE
}*/

object ManualBackupDisplayWordsScreen : AppDestination {
    override val route = NavRoutes.MANUAL_BACKUP_DISPLAY_WORDS_ROUTE
}

object ManualBackupVerifyWordsScreen : AppDestination {
    override val route = NavRoutes.MANUAL_BACKUP_VERIFY_WORDS_ROUTE
}

object ManualBackupSuccessScreen : AppDestination {
    override val route = NavRoutes.MANUAL_BACKUP_SUCCESS_ROUTE
}