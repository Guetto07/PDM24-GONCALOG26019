package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Calculadora()

        }
    }
}

@Composable fun Calculadora () {
    Column {
        Row {
            Button(onClick =) {
                Text(text = "7")
            }

            Button(onClick =) {
                Text(text = "8")
            }

            Button(onClick =) {
                Text(text = "9")
            }

            Button(onClick =) {
                Text(text = ":")
            }
        }
        Row {
            Button(onClick =) {
                Text(text = "4")
            }

            Button(onClick =) {
                Text(text = "5")
            }

            Button(onClick =) {
                Text(text = "6")
            }

            Button(onClick =) {
                Text(text = "x")
            }
        }
        Row {
            Button(onClick =) {
                Text(text = "1")
            }

            Button(onClick =) {
                Text(text = "2")
            }

            Button(onClick =) {
                Text(text = "3")
            }

            Button(onClick =) {
                Text(text = "-")
            }
        }
        Row {
            Row {
                Button(onClick =) {
                    Text(text = "0")
                }

                Button(onClick =) {
                    Text(text = ".")
                }

                Button(onClick =) {
                    Text(text = "=")
                }

                Button(onClick =) {
                    Text(text = "+")
                }
            }
        }
    }
}