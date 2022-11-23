package com.nybsys.jetpack_compose.ui.user

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nybsys.jetpack_compose.R
import com.nybsys.jetpack_compose.domain.model.User

/**
 * Created by Md. Abdullah Al Masud on 22/11/22.
 * Email: dev.almasud@gmail.com
 */

@Composable
fun UserListScreen() {
    val users = remember { mutableStateListOf(User(id = 1, name = "Abdullah Almasud")) }  // Hold the current state of composable observer
    Box(modifier = Modifier.fillMaxSize()) {
        UserList(users = users)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                users.add(User(id = 2, name = "New User"))
            }) {
            Text(text = "Add more")
        }
    }
}

@Composable
fun UserList(users: List<User>) { // Hold the current state
    LazyColumn {
        items(
            items = users,
            itemContent = { user ->
                UserCard(user)
            }

        )
    }
}

@Composable
fun UserCard(user: User) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.user
                ),
                contentDescription = user.name,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.LightGray, CircleShape)
                    .padding(12.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp)
            ) {
                Text(
                    text = user.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Button(onClick = {
                    Toast.makeText(context, "View profile is clicked for ${user.name}.", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "View profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UserListScreen()
}