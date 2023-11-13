package com.example.lazycoulumrow.ui.composebles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lazycoulumrow.R
import com.example.lazycoulumrow.data.ElementList
import com.example.lazycoulumrow.data.TravelModel
import com.example.lazycoulumrow.ui.theme.BigBackground
import com.example.lazycoulumrow.ui.theme.BlackTransparent
import com.example.lazycoulumrow.ui.theme.DarkBlue
import com.example.lazycoulumrow.ui.theme.Gray

@Composable
fun BaseImage(modifier: Modifier = Modifier, imageData: String) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageData)
            .crossfade(true)
            .build(),
        contentDescription = "Base image",
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun BaseText(modifier: Modifier = Modifier, text: String, textSize: Int, textColor: Color) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = textSize.sp,
        color = textColor
    )
}

@Composable
fun BaseIcon(modifier: Modifier = Modifier, @DrawableRes imagePainter: Int) {
    Image(
        modifier = modifier,
        painter = painterResource(id = imagePainter),
        contentDescription = "BaseIcon",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun PersonInfo(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row {
            BaseImage(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                imageData = "https://i.pinimg.com/564x/2e/61/d5/2e61d55505e08369f69b040bdc832a86.jpg"
            )

            Column(modifier = Modifier.padding(start = 5.dp)) {
                BaseText(text = "Welcome back", textSize = 12, textColor = Color.Gray)
                BaseText(text = "Muhammad Mahdi", textSize = 16, textColor = Color.White)
            }
        }
        BaseIcon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(40.dp), imagePainter = R.drawable.bell
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier.background(color = DarkBlue),
        value = text,
        onValueChange = {
            text = it
        },
        leadingIcon = {
            BaseIcon(modifier = Modifier.size(24.dp), imagePainter = R.drawable.search)
        },
        label = {
            BaseText(text = "Search", textSize = 16, textColor = Color.Gray)
        },
        trailingIcon = {
            BaseIcon(modifier = Modifier.size(24.dp), imagePainter = R.drawable.filter)
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = DarkBlue,
            textColor = Color.Gray,
            unfocusedIndicatorColor = DarkBlue,
            focusedIndicatorColor = DarkBlue
        )
    )
}

@Composable
fun ElementCardOne(modifier: Modifier = Modifier, travel: TravelModel) {
    Box(modifier = modifier.clip(RoundedCornerShape(15.dp))) {
        BaseImage(
            modifier = Modifier.size(width = 140.dp, height = 160.dp),
            imageData = travel.imageData
        )
        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(BlackTransparent)
                .align(Alignment.TopEnd)
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                BaseText(text = travel.stars.toString(), textSize = 10, textColor = Color.White)
                BaseIcon(modifier = Modifier.size(10.dp), imagePainter = R.drawable.star)
            }
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomStart)
        ) {
            BaseText(text = travel.city, textSize = 14, textColor = Color.White)
            Row {
                BaseIcon(modifier = Modifier.size(12.dp), imagePainter = R.drawable.location)
                BaseText(text = travel.country, textSize = 10, textColor = Color.White)
            }
        }
    }
}

@Composable
fun ElementCardTwo(modifier: Modifier = Modifier, travel: TravelModel) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10))
            .background(DarkBlue)
            .padding(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)) {
            BaseImage(
                modifier = Modifier
                    .size(88.dp)
                    .clip(RoundedCornerShape(6)),
                imageData = travel.imageData
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Bottom)) {
                BaseText(text = travel.placeCall, textSize = 18, textColor = Color.White)
                Row {
                    BaseIcon(
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(16.dp), imagePainter = R.drawable.calendar
                    )
                    BaseText(
                        text = stringResource(
                            id = R.string.data,
                            travel.fromDay,
                            travel.beforeDay,
                            travel.month,
                            travel.year,
                        ), textSize = 14, textColor = Color.White
                    )
                }
                Box(modifier = Modifier.fillMaxWidth(
                    
                )) {
                    Row {
                        BaseIcon(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .size(16.dp),
                            imagePainter = R.drawable.money
                        )
                        BaseText(
                            text = travel.money.toString(),
                            textSize = 14,
                            textColor = Color.White
                        )
                        BaseText(
                            modifier = Modifier.align(Alignment.Bottom),
                            text = "/Day",
                            textSize = 10,
                            textColor = Gray
                        )
                    }
                    Row(modifier = Modifier.align(Alignment.TopEnd)) {
                        BaseIcon(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .size(16.dp),
                            imagePainter = R.drawable.location
                        )
                        BaseText(text = travel.country, textSize = 14, textColor = Color.White)

                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(BigBackground)
                .align(Alignment.TopEnd)
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                BaseText(text = travel.stars.toString(), textSize = 10, textColor = Color.White)
                BaseIcon(modifier = Modifier.size(10.dp), imagePainter = R.drawable.star)
            }
        }
    }
}

@Composable
fun ElementLazyRow(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top)
    ) {
        item {
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                BaseText(text = "Suggestions for you", textSize = 18, textColor = Color.White)
                Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                    BaseText(text = "See all", textSize = 12, textColor = Color.White)
                    BaseIcon(modifier = Modifier.size(16.dp), imagePainter = R.drawable.arrow_right)
                }
            }
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    Alignment.CenterHorizontally
                )
            ) {
                items(ElementList.setElementList()) {
                    ElementCardOne(travel = it)
                }
            }
        }

        item {
            BaseText(
                modifier = Modifier.padding(top = 20.dp),
                text = "The best tours",
                textSize = 18,
                textColor = Color.White
            )
        }

        items(ElementList.setElementList()) {
            ElementCardTwo(modifier = Modifier.fillMaxWidth(), travel = it)
        }
    }
}

@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(20.dp)) {
        PersonInfo(modifier = Modifier.fillMaxWidth())
        SearchTextField(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
        )
        ElementLazyRow(modifier = modifier)
    }
}