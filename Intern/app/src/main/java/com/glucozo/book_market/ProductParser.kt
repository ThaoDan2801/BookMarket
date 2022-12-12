//package com.glucozo.book_market
//
//import android.provider.MediaStore
//import android.util.Log
//import org.json.JSONArray
//import org.json.JSONObject
//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.net.HttpURLConnection
//import java.net.URL
//
//object ProductParser {
//    suspend fun getAllProducts(): List<Product> {
//
//
//            val products = arrayListOf<Product>()
//        try {
////            val url = URL("http://localhost/banhang/getloaispp.php")
//            val url = URL("https://my-json-server.typicode.com/ThaoDan2801/demo")
////        val url = URL("https://www.facebook.com/")
////      var url = URL("http://www.google.com")
////       val connection = url.openConnection()
//            val connection = url.openConnection() as HttpURLConnection
//            val inputStream = connection.inputStream
//            val br = BufferedReader(InputStreamReader(inputStream))
//            var line = br.readLine()// doc dong dau tien
//            val text = StringBuffer()
//            while (line != null) {
//                text.append(line) // append la them vao cuoi cung
//                line = br.readLine()
//            }
//            br.close()
//
//            val arrObj = JSONArray(text.toString())
//            for (i in 0 until arrObj.length()) {
//
//                val productObj = arrObj[i] as JSONObject
////                val id = productObj.getInt("id")
//                val picture = productObj.getString("picture")
//                val name = productObj.getString("name")
//                val author = productObj.getString("author")
//                val evaluate = productObj.getString("evaluate")
//                val price = productObj.getString("price")
//                val product = Product(author, evaluate, name, picture, price)
//                products.add(product)
//            }
//            return products
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return products
//
//
//
//
//    }
//
//}
