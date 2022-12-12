package com.glucozo.book_market.repository

import androidx.lifecycle.MutableLiveData
import com.glucozo.book_market.model.Product
import com.google.firebase.database.*

class ProductRepository {
    private  val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("book")

    @Volatile private  var INSTANCE: ProductRepository ?= null
    fun getInstance(): ProductRepository{
        return INSTANCE ?: synchronized(this){
            val instance = ProductRepository()
            INSTANCE = instance
            instance

        }
    }
    fun loadProduct(productList: MutableLiveData<List<Product>>){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _productList: List<Product> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Product::class.java)!!

                    }
                    productList.postValue(_productList)

                } catch (e: Exception) {

                }
            }

            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
            }
        })
    }
}

