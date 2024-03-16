package com.example.composepritices.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composepritices.model.vo.ProductItemDataVO
import com.example.composepritices.ui.theme.ComposePriticesTheme
import com.google.gson.Gson

@Composable
fun BottomNavigation(
    navController: NavController
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        ROOT_LEVEL_DESTINATION.forEach { screen->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route==screen.route }==true,
                onClick = {
                          navController.rootDestination(screen.route, )
                },
                icon = {
                    Icon(imageVector = screen.icon,
                        contentDescription =
                        stringResource(id = screen.name))
                },
                label = {
                    Text(stringResource(id = screen.name))
                }
                )
        }
    }
}


@Preview
@Composable
fun BottomNavigationPreview(){
    ComposePriticesTheme {
        BottomNavigation(navController = rememberNavController())
    }
}

fun NavController.rootDestination(route: String){
    navigate(route){
        launchSingleTop=true
        popUpTo(
            this@rootDestination.graph.findStartDestination().id
        ){
            saveState=true
        }
        restoreState=true
    }
}


fun NavController.rootDestination(route:String, item: ProductItemDataVO){
    rootDestination(route + "?item=${Gson().toJson(item)}")
}
