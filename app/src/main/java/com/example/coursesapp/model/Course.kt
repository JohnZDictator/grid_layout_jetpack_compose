package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @DrawableRes val imageSourceId: Int,
    @StringRes val titleId: Int,
    val numCourses: Int,
)
