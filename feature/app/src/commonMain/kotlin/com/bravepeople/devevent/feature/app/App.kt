package com.bravepeople.devevent.feature.app

import com.bravepeople.devevent.navigation.Navigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bravepeople.devevent.feature.main.MainNavHost

@Composable
public fun App(navigator: Navigator) {
    MainNavHost(
        modifier = Modifier,
        navigator = navigator
    )
}