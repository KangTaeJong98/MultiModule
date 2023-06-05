package com.bravepeople.devevent.feature.main

import com.bravepeople.devevent.navigation.Navigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun MainNavHost(
    modifier: Modifier,
    navigator: Navigator
)