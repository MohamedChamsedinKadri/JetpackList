package com.example.listapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.listapp.R
import com.example.listapp.data.SampleData
import com.example.listapp.ui.theme.Purple80

@Composable
fun SampleDataDetails(data: SampleData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Purple80),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Detail Page")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(R.drawable.icon),
            contentDescription = "Image",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = data.name)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = data.desc)
    }
}
