package com.nybsys.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nybsys.jetpack_compose.databinding.ActivityMainBinding
import com.nybsys.jetpack_compose.ui.theme.JetpackComposeTheme
import com.nybsys.jetpack_compose.ui.user.UserFragment
import com.nybsys.jetpack_compose.ui.user.UserListScreen

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Android Jetpack Compose"

        supportFragmentManager.beginTransaction()
            .add(R.id.container_main, UserFragment())
            .commit()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Android Jetpack Compose")
            })
        },
        content = {
            UserListScreen()
        },
        backgroundColor = Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MyApp()
    }
}