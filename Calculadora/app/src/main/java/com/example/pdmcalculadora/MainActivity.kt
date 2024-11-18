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
            MaterialTheme {
                Surface {
                    Calculadora()
                }
            }
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
    var lastOperator by remember { mutableStateOf("") }
    var operand by remember { mutableStateOf("") }
    var resetDisplayOnNextInput by remember { mutableStateOf(false) }

    // Lógica de clique dos botões
    fun onButtonClick(value: String) {
        when (value) {
            
            in listOf("+", "-", "x", "/") -> {
                if (lastOperator.isEmpty()) {
                    operand = display
                } else if (!resetDisplayOnNextInput) {
                    // Executar a operação anterior
                    operand = when (lastOperator) {
                        "+" -> (operand.toDouble() + display.toDouble()).toString()
                        "-" -> (operand.toDouble() - display.toDouble()).toString()
                        "x" -> (operand.toDouble() * display.toDouble()).toString()
                        "/" -> (operand.toDouble() / display.toDouble()).toString()
                        else -> display
                    }
                }
                lastOperator = value
                resetDisplayOnNextInput = true
            }
            "=" -> {
                if (lastOperator.isNotEmpty()) {
                    display = when (lastOperator) {
                        "+" -> (operand.toDouble() + display.toDouble()).toString()
                        "-" -> (operand.toDouble() - display.toDouble()).toString()
                        "x" -> (operand.toDouble() * display.toDouble()).toString()
                        "/" -> (operand.toDouble() / display.toDouble()).toString()
                        else -> display
                    }
                    lastOperator = ""
                    operand = ""
                    resetDisplayOnNextInput = true
                }
            }
            "C" -> {
                display = "0"
                operand = ""
                lastOperator = ""
                resetDisplayOnNextInput = false
            }
        }
    }

    // Layout da Calculadora
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        // Display
        Text(
            text = display,
            modifier = Modifier.padding(16.dp)
        )

        // Botões
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
            CreateButton(text = "C", onClick = { onButtonClick("C") })
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
