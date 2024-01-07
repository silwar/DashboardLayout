package com.silwar.dashboard.generator

import com.silwar.dashboard.R

object ImageFactory {

    fun getDrawable(image: String?): Int {
        return when (image) {
            "scene_1" -> R.drawable.ic_image_1
            "scene_2" -> R.drawable.ic_image_2
            "scene_3" -> R.drawable.ic_image_3
            else -> R.drawable.ic_launcher_foreground
        }
    }
}