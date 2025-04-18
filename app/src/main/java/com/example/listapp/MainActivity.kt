package com.example.listapp

import android.net.Uri
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listapp.data.SampleData
import com.example.listapp.ui.theme.ListAppTheme
import com.example.listapp.view.SampleDataDetails
import com.example.listapp.view.SampleList
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListAppTheme {
                NavigatePage()
            }
        }
    }
}

@Composable
fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sample_list") {
        composable("sample_list") {
            SampleList(navController)
        }
        composable(
            route = "detail_page/{item}",
            arguments = listOf(navArgument("item") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val json = navBackStackEntry.arguments?.getString("item")
            json?.let {
                val decodedJson = Uri.decode(it)
                val item = Gson().fromJson(decodedJson, SampleData::class.java)
                SampleDataDetails(data = item)
            }

        }
    }
}



