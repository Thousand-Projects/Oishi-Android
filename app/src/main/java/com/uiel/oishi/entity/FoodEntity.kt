package com.uiel.oishi.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uiel.oishi.Category

@Entity
data class Food(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val image: Int,
    val title: String,
    val description: String,
    val category: Category,
)

