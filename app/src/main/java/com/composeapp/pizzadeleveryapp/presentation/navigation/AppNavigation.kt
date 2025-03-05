
package com.composeapp.pizzadeleveryapp.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.composeapp.pizzadeleveryapp.presentation.cart.CartScreen
import com.composeapp.pizzadeleveryapp.presentation.details.DetailsScreen
import com.composeapp.pizzadeleveryapp.presentation.home.HomeScreen
import com.composeapp.pizzadeleveryapp.presentation.login.LoginScreen
import com.composeapp.pizzadeleveryapp.presentation.navigation.graph.AppGraph
import com.composeapp.pizzadeleveryapp.presentation.onboarding.OnBoardingScreen
import com.composeapp.pizzadeleveryapp.presentation.signup.SignupScreen


@Composable
fun AppNavigation() {

    val duration = 500

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppGraph.OnBoarding,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(duration)
            )
        }, exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(duration)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(duration)
            )
        }, popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(duration)
            )
        }
        ){

        composable<AppGraph.OnBoarding> {
            OnBoardingScreen(navController)
        }

        composable<AppGraph.Login> {
            LoginScreen(navController)
        }

        composable<AppGraph.SignUp> {
            SignupScreen(navigator = navController)
        }

        composable<AppGraph.Home> {
            HomeScreen(navController)
        }

        composable<AppGraph.ProductDetails> {
            val route = it.toRoute<AppGraph.ProductDetails>()
            DetailsScreen(route.productId, navigator = navController)
        }

        composable<AppGraph.Cart> {
            CartScreen(navController)
        }


        composable<AppGraph.ForgotPassword> {  }



    }
}