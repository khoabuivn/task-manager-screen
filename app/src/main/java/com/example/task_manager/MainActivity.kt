package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_manager.ui.theme.TaskmanagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskmanagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskManagerApp()
                }
            }
        }
    }
}

@Composable
fun TaskManagerApp() {
    TaskManagerScreen(
        status = stringResource(R.string.status_text),
        comment = stringResource(R.string.comment_text),
        imagePainter = painterResource(R.drawable.ic_task_completed)
    )
}

@Composable
private fun TaskManagerScreen(
    status: String,
    comment: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
    ){
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),
        )
        Text(
            textAlign = TextAlign.Center,
            text = status,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.fillMaxWidth().padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            textAlign = TextAlign.Center,
            text = comment,
            fontSize = 16.sp,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskmanagerTheme {
        TaskManagerApp()
    }
}