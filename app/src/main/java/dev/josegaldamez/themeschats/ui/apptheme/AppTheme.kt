package dev.josegaldamez.themeschats.ui.apptheme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.josegaldamez.themeschats.enums.Themes
import dev.josegaldamez.themeschats.ui.apptheme.themes.natural.darkNaturalScheme
import dev.josegaldamez.themeschats.ui.apptheme.themes.natural.lightNaturalScheme
import dev.josegaldamez.themeschats.ui.apptheme.themes.original.darkOriginalScheme
import dev.josegaldamez.themeschats.ui.apptheme.themes.original.lightOriginalScheme
import dev.josegaldamez.themeschats.ui.apptheme.themes.sea.darkSeaScheme
import dev.josegaldamez.themeschats.ui.apptheme.themes.sea.lightSeaScheme

//import dev.josegaldamez.themeschats.ui.theme.DarkColorScheme
//import dev.josegaldamez.themeschats.ui.theme.LightColorScheme



@Composable
fun AppTheme(
    // elegir un tema - Original - natural - sunset
    theme: Themes,
    // solo aplica para la version 12+
    // es decir el API 31+
    isDynamicColors: Boolean = false,
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){

    // TODO: set colorSchemes
    val colors: ColorScheme

    if(isDynamicColors && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ){

        val contextLocal = LocalContext.current
        colors = if(isDarkMode) dynamicDarkColorScheme(contextLocal) else dynamicLightColorScheme(contextLocal)

    } else {

        colors = when(theme){
            Themes.ORIGINAL -> if (isDarkMode) darkOriginalScheme else lightOriginalScheme
            Themes.NATURAL -> if (isDarkMode) darkNaturalScheme else lightNaturalScheme
            Themes.SEA -> if (isDarkMode) darkSeaScheme else lightSeaScheme
        }


    }


    // TODO: set typography

    MaterialTheme(
        colorScheme = colors,
        content = content
    )


}