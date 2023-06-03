package com.bravepeople.devevent.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.bravepeople.devevent.feature.app.App
import com.bravepeople.devevent.navigation.Navigator

public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                Navigator(
                    controller = rememberNavController()
                )
            )
        }
    }
}