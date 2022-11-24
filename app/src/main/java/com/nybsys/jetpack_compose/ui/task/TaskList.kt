package com.nybsys.jetpack_compose.ui.task

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nybsys.jetpack_compose.R

const val TAG: String = "TaskList"

/**
 * Created by Md. Abdullah Al Masud on 23/11/22.
 * Email: dev.almasud@gmail.com
 */

@Composable
fun TaskList(navHostController: NavHostController? = null) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(30.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        TitleText(title = "My Tasks")
        LazyColumn {
            items(
                items = (0..5).toList(),
                itemContent = { item ->
                    TaskItem(title = "Item $item", navHostController = navHostController)
                }
            )
        }
    }
}

@Composable
fun TaskItem(title: String, navHostController: NavHostController? = null) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 8.dp)
            .clickable {
                Log.d(TAG, "TaskItem: is clicked!")
                navHostController?.navigate("task-details?item=$title")
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_assignment),
                contentDescription = "Assignment",
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 12.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = Color.Black.copy(alpha = 0.7f))
            )
            Text(
                text = title,
                color = Color.Black.copy(alpha = 0.6f),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 24.dp, end = 12.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .wrapContentSize()
            .padding(vertical = 16.dp),
        color = Color.Black.copy(alpha = 0.6f),
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    )
}

@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    TaskList()
}