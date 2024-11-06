package com.example.pr_5_kotlin.retrofit.model

import androidx.lifecycle.LiveData

class ProductRepository (private val productDao: ProductDao) {
    val allProducts: LiveData<List<Product>> = productDao.getAllUsers()

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }
}