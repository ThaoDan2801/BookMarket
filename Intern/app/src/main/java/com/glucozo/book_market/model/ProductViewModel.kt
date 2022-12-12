package com.glucozo.book_market.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glucozo.book_market.repository.ProductRepository

class ProductViewModel : ViewModel (){
    private  val repository: ProductRepository
    private  val _allProducts = MutableLiveData<List<Product>>()
    val allProducts:LiveData<List<Product>> = _allProducts

    init {
        repository = ProductRepository().getInstance()
        repository.loadProduct(_allProducts)
    }
}