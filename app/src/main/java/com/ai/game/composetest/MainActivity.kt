package com.ai.game.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.game.composetest.model.listItem
import com.ai.game.composetest.ui.theme.ComposeTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                DefaultPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingWithImage(name: String, from: String) {
    Box{
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        GreetingFrom(name, from);
    }
}

@Composable
fun GreetingFrom(name : String, from: String){
    Column{
        Text(
            text = "Happy Birthday $name",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = " - from : $from",
            fontSize = 16.sp
        )
    }
}

@Composable
fun ComposeArticle(){
    Column {
        Image(
            painter = painterResource(id = R.drawable.compose_article_image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Jetpack Compose tutorial",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager(){
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.task_completed),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "All tasks completed",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Text(
            text = "Nice work!",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ComposeQuadrant(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.weight(1.0f)
        ){
            Column (
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxHeight()
                    .background(Color.Green)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    text = "Text composable",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Displays text and follows Material Design guidelines.",
                    textAlign = TextAlign.Justify
                )
            }
            Column (
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Image composable",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Creates a composable that lays out and draws a given Painter class object.",
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row(
            modifier = Modifier.weight(1.0f)
        ){
            Column(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxHeight()
                    .background(Color.Cyan)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Row composable",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "A layout composable that places its children in a horizontal sequence.",
                    textAlign = TextAlign.Justify
                )
            }
            Column (
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxHeight()
                    .background(Color.LightGray)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Column composable",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "A layout composable that places its children in a vertical sequence.",
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Composable
fun BusinessCard(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .fillMaxWidth(),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Bhavye Goel",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            color = Color.White
        )
        Text(
            text = "Android Developer",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_call_24),
                contentDescription = null,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = "+91 7042233844",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_work_24),
                contentDescription = null,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = "@AndroidDev",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_email_24),
                contentDescription = null,
                modifier = Modifier.padding(end = 20.dp)
            )
            Text(
                text = "bhavye.goel2002@gmail.com",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun DiceRollerApp(){
    var result by remember {
        mutableStateOf(1)
    }
    var image = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_1
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(image),
            contentDescription = "1"
        )
        Button(
            onClick = {
                result = (1..6).random()
                Log.i("result", result.toString())
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                text = "ROLL"
            )
        }
    }
}

@Composable
fun LemonadeApp(){
    var result by remember {
        mutableStateOf(0)
    }
    var stringRes = when(result){
        0 -> R.string.Lemon_tree
        1 -> R.string.Lemon
        2 -> R.string.Glass_of_lemonade
        3 -> R.string.Empty_glass
        else -> R.string.Lemon_tree
    }

    var imageRes = when(result){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    var temp = (1..5).random()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(stringRes),
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painter = painterResource(imageRes),
            contentDescription = "lemonTree",
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color.Green
                )
                .clickable {
                    if (imageRes == R.drawable.lemon_squeeze && temp != 0) {
                        temp--;
                        Log.i("temp Value display", temp.toString())
                    } else result = (result + 1) % 4
                }
        )
    }
}

@Composable
fun TipTime(){
    var data by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Calculate Tip",
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        )
        DisplayText(data = data, onValueChange = {temp -> data = temp})
    }
}

@Composable
fun DisplayText(data: String, onValueChange: (String) -> Unit){
    TextField(
        value = data,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

@Composable
fun ScrollableListApp(){
    var items = loadImages()
    
    LazyColumn {
        items(items){ index ->
            SingleItemLazyColumn(item = index)
        }
    }
}

@Composable 
fun SingleItemLazyColumn(item: listItem){
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column{
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Image 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.text,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }

    }
}

fun loadImages(): List<listItem> {
    return listOf<listItem>(
        listItem("String 1", R.drawable.image1),
        listItem("String 1", R.drawable.image2),
        listItem("String 1", R.drawable.image3),
        listItem("String 1", R.drawable.image4),
        listItem("String 1", R.drawable.image5),
        listItem("String 1", R.drawable.image6),
        listItem("String 1", R.drawable.image7),
        listItem("String 1", R.drawable.image8),
        listItem("String 1", R.drawable.image9),
        listItem("String 1", R.drawable.image10))
}

@Composable
fun DropDownAnimation(){
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 5.dp,
    ){
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.image1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                        .padding(5.dp)
                        .clickable {

                        },
                    contentScale = ContentScale.Crop,
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 275.dp)
                        .clickable {
                            expanded = !expanded
                        }
                )
            }
            if(expanded) ShowExpansion()
        }
    }
}

@Composable
fun ShowExpansion(){
    Text(
        text = "This is an image",
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DropDownAnimation()
}