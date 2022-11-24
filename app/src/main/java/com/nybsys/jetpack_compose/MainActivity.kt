package com.nybsys.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nybsys.jetpack_compose.ui.BottomNavItem
import com.nybsys.jetpack_compose.ui.task.TaskDetails
import com.nybsys.jetpack_compose.ui.task.TaskList
import com.nybsys.jetpack_compose.ui.task.TitleText
import com.nybsys.jetpack_compose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                MyApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Android Jetpack Compose")
            })
        },
        bottomBar = {
                  val navItems = listOf(
                      BottomNavItem.Home,
                      BottomNavItem.Favorite,
                      BottomNavItem.Feed,
                      BottomNavItem.Profile,
                  )
            
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.teal_700)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                navItems.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(painter = painterResource(id = item.icon), contentDescription = item.title.toString())
                        },
                        label = { Text(text = stringResource(id = item.title)) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(alpha = 0.4f),
                        selected = currentRoute == item.navRoute,
                        onClick = {
                            navController.navigate(item.navRoute)
                        }
                    )
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = NAV_HOME
            ) {
                composable(NAV_HOME) {
                    TaskList(navController)
                }
                composable(NAV_FAVORITE) {
                    AppScreen(title = "Favorite Screen")
                }
                composable(NAV_FEED) {
                    AppScreen(title = "Favorite Feed")
                }
                composable(NAV_PROFILE) {
                    AppScreen(title = "Profile Screen")
                }
                composable("task-details?item={item}",
                arguments = listOf(
                    navArgument("item") {
                        type = NavType.StringType
                        defaultValue = "No value"
                        nullable = true
                    }
                )
                    ) {
                    val item = it.arguments?.getString("item")
                    TaskDetails(item = item)
                }
            }
        },
        backgroundColor = Color.LightGray
    )
}

@Composable
fun AppScreen(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TitleText(title = title)
    }
}

const val NAV_HOME = "home"
const val NAV_FAVORITE = "favorite"
const val NAV_FEED = "feed"
const val NAV_PROFILE = "profile"

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MyApp()
    }
}