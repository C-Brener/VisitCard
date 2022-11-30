package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun PresentationCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .testTag("Logo")
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.my_name),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.fillMaxWidth().testTag("Name Owner")
        )
        Text(
            text = "Android Developer in Build Process",
            fontSize = 24.sp,
            color = Color(0xFF3DDC84),
            modifier = Modifier.fillMaxWidth().testTag("Job"),
            textAlign = TextAlign.Center
        )

    }
}


@Composable
fun InformationsCard(icon: Painter, information: String, modifier: Modifier) {
    Column() {
        Divider(color = Color.White, modifier = Modifier.fillMaxWidth())
        Row(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = icon, contentDescription = null, modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .testTag("Icon"),
                tint = colorResource(
                    id = R.color.green
                )
            )
            Text(
                text = information,
                modifier = Modifier.fillMaxWidth().testTag("Contact Informations"),
                textAlign = TextAlign.Center,
                color = Color.White
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
            .testTag("Skeleton")
            .background(color = colorResource(id = R.color.background_app))
    ) {
        Row(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            PresentationCard()
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column {
                InformationsCard(
                    icon = painterResource(id = R.drawable.ic_baseline_call_24),
                    information = "+55 (71) 98323-0048",
                    modifier = Modifier.padding(10.dp)
                )
                InformationsCard(
                    icon = painterResource(id = R.drawable.ic_baseline_share_24),
                    information = "Android Developer",
                    modifier = Modifier.padding(10.dp)
                )
                InformationsCard(
                    icon = painterResource(id = R.drawable.ic_baseline_email_24),
                    information = "brenercaique0806@gmail.com",
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SkeletonScreenPreview() {
    SkeletonScreen()
}

