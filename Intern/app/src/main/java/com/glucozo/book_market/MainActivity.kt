package com.glucozo.book_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glucozo.book_market.books_list.WallpaperFragment
import com.glucozo.book_market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
//    , WallpaperItemClickListener
{
    private lateinit var binding: ActivityMainBinding

    //    lateinit var productItemClickListener: ProductItemClickListener
    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.content)

    //    private val products = arrayListOf<Products>()
//    private lateinit var adapter: ProductAdapter
//    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, WallpaperFragment())
                .commit()
        }
    }


}
//interface ActivityAction {
//    fun buttonLeftClickListener()
//    fun buttonRightClickListener()
//}
//
//class FragmentA: Fragment(), ActivityAction {
//    override fun buttonLeftClickListener() {
//
//    }
//
//    override fun buttonRightClickListener() {
//
//    }
//}