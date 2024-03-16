package com.example.composepritices.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composepritices.MainAppStateFul
import com.example.composepritices.detail.DetailScreen
import com.example.composepritices.model.vo.ProductItemDataVO
import com.google.gson.Gson

@Composable
fun MainRootHost(
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = MainArticle.route) {
        composable(MainArticle.route) {
            MainAppStateFul(navHostController)
        }
        composable(
            route = ArticleToDetail.route,
            arguments = listOf(navArgument("item") { type = NavType.StringType })
        )
        { entryPoint ->
            val productItem = entryPoint.arguments?.getString("item")?.let {
                Gson().fromJson(it, ProductItemDataVO::class.java)
            }
            if (productItem != null)
            DetailScreen(productItem)
        }
    }
}