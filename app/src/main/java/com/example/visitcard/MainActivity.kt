package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SkeletonScreen()
                }
            }
        }
    }
}

@Composable
fun InformationsCard(icon: Painter, information: String) {
    Column() {
        Divider(color = Color.White)
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)) {
            Icon(
                painter = icon, contentDescription = null, modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                tint = colorResource(
                    id = R.color.white
                )
            )
            Text(text = information,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }


}


@Composable
fun SkeletonScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.background_app))
    ) {
        Row(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxHeight().wrapContentHeight(Alignment.CenterVertically)) {
                InformationsCard(icon = painterResource(id = R.drawable.ic_baseline_call_24), information = "+55 (71) 98323-0048" )
                InformationsCard(icon = painterResource(id = R.drawable.ic_baseline_share_24), information = "Android Developer" )
                InformationsCard(icon = painterResource(id = R.drawable.ic_baseline_email_24), information = "brenercaique0806@gmail.com" )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SkeletonScreenPreview() {
   SkeletonScreen()
}

