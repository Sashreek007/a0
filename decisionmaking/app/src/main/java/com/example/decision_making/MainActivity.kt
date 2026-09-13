package com.example.decision_making

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decision_making.ui.theme.DecisionmakingTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionmakingTheme {
               DecisionApp()
            }
        }
    }
}

@Composable
fun DecisionApp(){
    var result by remember { mutableStateOf("Should we go?") }
    var clicks by remember { mutableIntStateOf(0) }
    fun decide(probYes: Double) {
        result = if (Random.nextDouble() < probYes) "Yes" else "No"
        clicks++
    }
    val bg = when (result) {
        "Yes" -> Color(0xFF2E7D32)
        "No" -> Color(0xFFC62828)
        else -> Color(0xFF202020)
    }
    Column(
        modifier = Modifier.fillMaxSize().background(bg),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text(result, fontSize = 32.sp, color = Color.White)
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            Button(onClick = {decide(0.5)}) { Text("Ok!", color = Color.White) }
            Button(onClick = {decide(0.25)}) { Text("Meh", color = Color.White) }
            Button(onClick = {decide(0.1)}) { Text("Nah", color = Color.White) }
        }
        Text("Clicks: $clicks",color = Color.White, fontSize = 22.sp)
        Text("ID: 1852232  CCID: saddanki",color = Color.White, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DecisionPreview() {
  DecisionApp()
}