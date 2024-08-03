package com.uiel.oishi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.uiel.oishi.entity.Food

@Dao
interface FoodDao {
    @Insert
    fun saveFood(food: Food)

    @Query("select * from food")
    fun queryFood(): List<Food>

    @Query("DELETE FROM food WHERE id = :foodId")
    fun deleteFood(foodId: Long)
}
