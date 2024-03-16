package com.example.composepritices.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composepritices.articlegrid.ArticleGridScreen
import com.example.composepritices.articlelist.ArticleListScreen
import com.example.composepritices.model.viwemodel.ArticleViewModel

@Composable
fun RootHost(
    mainNavController: NavController,
    navHostController: NavHostController,
    modifier: Modifier
){
    val viewModel:ArticleViewModel= hiltViewModel()
    val productItem by viewModel.articleService.collectAsStateWithLifecycle()

    NavHost(navController = navHostController, startDestination =ArticleList.route ){
        composable(
            ArticleList.route,
            ){
            ArticleListScreen(modifier, productItemState = productItem){
                mainNavController.rootDestination("Detail", it)
            }
        }
        composable(
            ArticleGrid.route,
        ){
            ArticleGridScreen(modifier,productItem){
                mainNavController.rootDestination("Detail", it)
            }
        }
    }
}