package com.composeapp.pizzadeleveryapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Orange40,
    secondary = Gray80,
    tertiary = SkyBlue40,
    background = white,
    onPrimary = white
)


@Composable
fun PizzaDeliveryAppTheme(
    content: @Composable () -> Unit
) {


    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}