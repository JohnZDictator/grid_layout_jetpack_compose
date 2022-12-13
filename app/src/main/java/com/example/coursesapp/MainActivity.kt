package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.data.DataSource
import com.example.coursesapp.model.Course
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}

@Composable
fun CourseApp() {
    val topicList = DataSource().loadCourses()
    CourseList(topicList)
}

@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .aspectRatio(2.8f),
        elevation = 8.dp
    ) {
        Row {
            Image(
                painter = painterResource(course.imageSourceId), 
                contentDescription = stringResource(course.titleId),
                modifier = Modifier.width(68.dp).height(68.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(course.titleId),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.body2
                )
                Row(
                    modifier = Modifier.padding(8.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "Check",
                        modifier = Modifier
                            .width(12.dp)
                            .height(12.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = course.numCourses.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun CourseList(topicList: List<Course>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(10.dp),
    ) {
        items(topicList.size) {
            CourseCard(course = topicList[it])
        }
    }
}

@Preview
@Composable
fun CourseCardPreview() {
    CourseCard(course = DataSource().loadCourses()[2])
}