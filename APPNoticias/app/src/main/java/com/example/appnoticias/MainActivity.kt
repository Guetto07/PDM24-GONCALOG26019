package com.example.appnoticias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appnoticias.ui.theme.APPNoticiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APPNoticiasTheme {
                AppNoticiasScaffold()
            }
        }
    }
}

@Composable
fun AppNoticiasScaffold() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { /* Aqui você pode adicionar um TopAppBar, se quiser */ }
    ) { innerPadding ->
        NewsContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun NewsContent(modifier: Modifier = Modifier) {
    // Conteúdo da aplicação (substituir pelo conteúdo real)
    Text(
        text = "Bem-vindo ao App de Notícias!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAppNoticias() {
    APPNoticiasTheme {
        AppNoticiasScaffold()
    }
}
