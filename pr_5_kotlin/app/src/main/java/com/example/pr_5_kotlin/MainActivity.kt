package com.example.pr_5_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pr_5_kotlin.retrofit.api.MainApi
import com.example.pr_5_kotlin.retrofit.model.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val productApi = retrofit.create(MainApi::class.java)

        findViewById<Button>(R.id.fetchButton).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val product = productApi.getProductById(3) // Replace 3 with actual product ID
                    productViewModel.insert(product)
                } catch (e: Exception) {
                    Log.e("MainActivity", "Error fetching product", e)
                }
            }
        }

        productViewModel.allProducts.observe(this, Observer { products ->
            products?.let { productAdapter.setProducts(it) }
        })
    }
}