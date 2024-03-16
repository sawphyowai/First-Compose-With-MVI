package com.example.composepritices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composepritices.intent.Intent
import com.example.composepritices.model.viwemodel.ArticleViewModel
import com.example.composepritices.navigation.BottomNavigation
import com.example.composepritices.navigation.MainRootHost
import com.example.composepritices.navigation.RootHost
import com.example.composepritices.splash.SplashScreen
import com.example.composepritices.ui.compoments.SearchItemState


@Composable
fun checkSplashOrMainScreen(){

    var showLoadingScreen by remember{
       mutableStateOf(true)
    }
    val navController = rememberNavController()

    if(showLoadingScreen){
        SplashScreen(onTimeOut = {showLoadingScreen=false})
    }else{
        MainRootHost(navController)
    }
}
@Composable
fun MainAppStateFul(mainNavController: NavHostController){
    val navController = rememberNavController()
    MainAppStateLess(modifier = Modifier.padding(8.dp),navController,mainNavController)
}
@Composable
fun MainAppStateLess(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    mainNavController: NavHostController
){
    val viewModel:ArticleViewModel= hiltViewModel()
        Scaffold (
            modifier =modifier,
            topBar={
                SearchItemState(modifier){
                   viewModel.getAllService(Intent.FilterIntent(it))
                }
            },
            bottomBar = {
              BottomNavigation(navController)
            }
            ){paddingValues ->
            RootHost(
                mainNavController=mainNavController,
                navHostController =navController,
                modifier = modifier.padding(paddingValues)
            )
        }
}

