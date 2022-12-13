package com.example.coursesapp.data

import com.example.coursesapp.R
import com.example.coursesapp.model.Course

class DataSource {
    fun loadCourses(): List<Course> {
        return listOf(
            Course(R.drawable.architecture, R.string.architecture, 58),
            Course(R.drawable.business, R.string.business, 78),
            Course(R.drawable.crafts, R.string.crafts, 121),
            Course(R.drawable.culinary, R.string.culinary, 118),
            Course(R.drawable.design, R.string.design, 423),
            Course(R.drawable.fashion, R.string.fashion, 92),
            Course(R.drawable.film, R.string.film, 165),
            Course(R.drawable.gaming, R.string.gaming, 164),
            Course(R.drawable.drawing, R.string.drawing, 326),
            Course(R.drawable.lifestyle, R.string.lifestyle, 305),
            Course(R.drawable.music, R.string.music, 212),
            Course(R.drawable.painting, R.string.painting, 172),
            Course(R.drawable.photography, R.string.photography, 321),
            Course(R.drawable.tech, R.string.tech, 118),
        )
    }
}