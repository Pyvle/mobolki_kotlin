package com.example.pr_5_kotlin.retrofit.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insert(product: Product)
    @Query("SELECT * FROM products")
    fun getAllUsers(): LiveData<List<Product>>
}