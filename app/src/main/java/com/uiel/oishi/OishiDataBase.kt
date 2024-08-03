package com.uiel.oishi

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uiel.oishi.dao.FoodDao
import com.uiel.oishi.entity.Food

@Database(
    version = 1,
    entities = [Food::class]
)

abstract class OishiDataBase: RoomDatabase() {
    abstract fun getFoodDao(): FoodDao
}