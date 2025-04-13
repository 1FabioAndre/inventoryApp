package com.webservices.budgetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.webservices.budgetapp.ui.theme.InventoryAppTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InventoryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                       MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InventoryAppTheme {
        Greeting("Android")
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(value = 0) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Counter: $count",
            style = MaterialTheme.typography.bodyLarge
        )
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
    }

    Row {
        Text(text = "Android")
        Text(text = "Kotlin")
        Text(text = "Compose")
    }

    Box(modifier = Modifier.size(100.dp),
        contentAlignment = Alignment.Center) {
        Icon(modifier = Modifier.size(80.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green)
        Text(text = "$count")
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        items(count = 100) { it: Int ->
            Text(modifier = Modifier.padding(8.dp), text = "Item number is $it")
        }
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth().background(Color.LightGray)
    ) {
        items(count = 30) { it: Int ->
            Text(modifier = Modifier.padding(9.dp), text = "Item row $it")
        }
    }

    LazyVerticalGrid(columns = GridCells.Fixed(count = 3)) {
        items(count = 100) { it: Int ->
            Text(modifier = Modifier.padding(8.dp), text = "Item is $it")
        }
    }
}