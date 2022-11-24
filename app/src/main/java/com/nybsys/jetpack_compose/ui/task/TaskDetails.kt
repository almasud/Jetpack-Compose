package com.nybsys.jetpack_compose.ui.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

/**
 * Created by Md. Abdullah Al Masud on 23/11/22.
 * Email: dev.almasud@gmail.com
 */

@Composable
fun TaskDetails(navHostController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        TitleText(title = "Task Details")
        LazyColumn {
            items(
                items = (0..5).toList(),
                itemContent = { item ->
                    TaskItem(title = "Details Item $item")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskDetailsPreview() {
    TaskDetails()
}