package com.erif.jetpackcomposedemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erif.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

private fun intent(context: Context) {
    val intent = Intent(context, SecondActivity::class.java)
    context.startActivity(intent)
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Column (
        Modifier.width(IntrinsicSize.Max)
        .height(IntrinsicSize.Max)
            .background(Color.Green)
    ) {
        Text(
            text = "Hello $name!",
            style = TextStyle(color = Color.Cyan)
        )
        //Spacer(Modifier.height(10.dp))
        Button(onClick = {
            intent(context)
        },
            modifier = Modifier.fillMaxWidth()
                .padding(
                    10.dp,
                    0.dp,
                    10.dp,
                    0.dp
                )
        ) {
            Text(text = "Save Now")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Greeting("Android")
    }
}