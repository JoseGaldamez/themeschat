package dev.josegaldamez.themeschats

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import dev.josegaldamez.themeschats.enums.Themes
import dev.josegaldamez.themeschats.ui.apptheme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            var themeSelected by rememberSaveable {
                mutableStateOf<Themes>( Themes.ORIGINAL )
            }

            AppTheme(
                theme = themeSelected
            ) {
                ChatScreen( changeTheme = {
                    themeSelected = it
                } )
            }

        }
    }
}
