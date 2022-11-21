package com.nybsys.jetpack_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nybsys.jetpack_compose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Title("Android")
                }
            }
        }
    }
}

@Composable
fun Title(name: String) {
    Surface(modifier = Modifier.wrapContentSize()) {
        val context = LocalContext.current
        Text(
            text = "Hello $name!",
            fontSize = 22.sp,
            color = colorResource(id = R.color.purple_700),
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier.clickable {
                Toast.makeText(context, "Title clicked!", Toast.LENGTH_SHORT).show()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Title("Android")
        }
    }
}