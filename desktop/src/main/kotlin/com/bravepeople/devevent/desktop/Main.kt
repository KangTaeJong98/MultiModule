package com.bravepeople.devevent.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bravepeople.devevent.feature.app.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
