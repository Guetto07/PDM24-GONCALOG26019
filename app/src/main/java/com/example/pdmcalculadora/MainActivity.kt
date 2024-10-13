package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Calculadora()

        }
    }
}

@Composable
fun CreateButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(4.dp)) {
        Text(text)
    }
}
@Composable
fun Calculadora() {

    var display by remember { mutableStateOf("0") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text(text = display, modifier = Modifier.padding(16.dp))

        fun onButtonClick(value: String) {
            display = if (display == "0") value else display + value
        }

        Row {
            CreateButton(text = "7", onClick = { onButtonClick("7") })
            CreateButton(text = "8", onClick = { onButtonClick("8") })
            CreateButton(text = "9", onClick = { onButtonClick("9") })
            CreateButton(text = "/", onClick = { onButtonClick("/") })

        }
        Row {
            CreateButton(text = "4", onClick = { onButtonClick("4") })
            CreateButton(text = "5", onClick = { onButtonClick("5") })
            CreateButton(text = "6", onClick = { onButtonClick("6") })
            CreateButton(text = "x", onClick = { onButtonClick("x") })
        }
        Row {
            CreateButton(text = "1", onClick = { onButtonClick("1") })
            CreateButton(text = "2", onClick = { onButtonClick("2") })
            CreateButton(text = "3", onClick = { onButtonClick("3") })
            CreateButton(text = "-", onClick = { onButtonClick("-") })
        }
        Row {
            CreateButton(text = "0", onClick = { onButtonClick("0") })
            CreateButton(text = ".", onClick = { onButtonClick(".") })
            CreateButton(text = "=", onClick = { onButtonClick("=") })
            CreateButton(text = "+", onClick = { onButtonClick("+") })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface {
        Calculadora()
    }
}