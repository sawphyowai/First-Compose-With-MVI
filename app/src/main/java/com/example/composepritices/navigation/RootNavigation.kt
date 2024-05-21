package com.example.composepritices.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composepritices.R

object RootRoute{
    const val List="List"
    const val Grid="Grid"
    const val Detail="Detail?item={item}"
    const val Main="Main"
}

interface RootNavigationDestination{
    val route:String
    val icon:ImageVector
    val name:Int
    val id:Int
}

object ArticleToDetail:RootNavigationDestination{
    override val route: String
        get() = RootRoute.Detail
    override val icon: ImageVector
        get() =  Icons.Default.List
    override val name: Int
        get() = R.string.List
    override val id: Int
        get() = 4
}

object MainArticle : RootNavigationDestination {
    override val route: String
        get() = RootRoute.Main
    override val icon: ImageVector
        get() = Icons.Default.Home
    override val name: Int
        get() = R.string.Main
    override val id: Int
        get() = 1
}

object ArticleList:RootNavigationDestination{
    override val route: String
        get() = RootRoute.List
    override val icon: ImageVector
        get() =  Icons.Default.List
    override val name: Int
        get() = R.string.List
    override val id: Int
        get() = 2

}

object ArticleGrid:RootNavigationDestination{
    override val route: String
        get() = RootRoute.Grid
    override val icon: ImageVector
        get() = Icons.Default.Home
    override val name: Int
        get() =  R.string.Grid
    override val id: Int
        get() = 3
}


val ROOT_LEVEL_DESTINATION:List<RootNavigationDestination> =
     listOf(ArticleList,ArticleGrid)
