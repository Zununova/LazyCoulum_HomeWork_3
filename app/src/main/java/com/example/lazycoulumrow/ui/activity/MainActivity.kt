package com.example.lazycoulumrow.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazycoulumrow.ui.composebles.MainWindow
import com.example.lazycoulumrow.ui.theme.BigBackground
import com.example.lazycoulumrow.ui.theme.Blue
import com.example.lazycoulumrow.ui.theme.LazyCoulumRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyCoulumRowTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BigBackground
                ) {
                    PreviewMainComponents()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainComponents() {
    MainWindow(modifier = Modifier.fillMaxSize())
}
