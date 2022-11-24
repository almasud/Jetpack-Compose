package com.nybsys.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nybsys.jetpack_compose.ui.task.TaskDetails
import com.nybsys.jetpack_compose.ui.task.TaskList
import com.nybsys.jetpack_compose.ui.theme.JetpackComposeTheme
import com.nybsys.jetpack_compose.ui.user.UserListScreen

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
        content = {
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    TaskList(navController)
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
fun ComposeWithXml() {
    Column(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                View.inflate(context, R.layout.layout_one, null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 12.dp),
            update = { layoutView ->
                layoutView.findViewById<TextView>(R.id.tv_xml).apply {
                    setOnClickListener {
                        text = "I am from AndroidView"
                    }
                }
            }
        )
        UserListScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MyApp()
    }
}