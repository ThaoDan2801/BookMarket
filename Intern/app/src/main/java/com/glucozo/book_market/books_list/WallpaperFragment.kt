package com.glucozo.book_market.books_list

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ddona.wallpaper.adapter.ProductAdapter
import com.ddona.wallpaper.adapter.WallpaperItemClickListener
import com.glucozo.book_market.R
import com.glucozo.book_market.books_details.DetailProductFragment
import com.glucozo.book_market.databinding.FragmentBookBinding
import com.glucozo.book_market.model.Products


class WallpaperFragment : Fragment()
    , WallpaperItemClickListener
{

    private lateinit var binding: FragmentBookBinding

    //data
    private val images = arrayListOf(
        Pair(R.drawable.sacha, "January"),
        Pair(R.drawable.sachb, "February"),
        Pair(R.drawable.sachc, "March"),
        Pair(R.drawable.sache, "April"),
        Pair(R.drawable.sachf, "May"),
        Pair(R.drawable.sachg, "June"),
        Pair(R.drawable.sach, "July"),
        Pair(R.drawable.sachd, "August"),
        Pair(R.drawable.sachc, "September"),
        Pair(R.drawable.sachb, "November"),
        Pair(R.drawable.sachd, "October"),
        Pair(R.drawable.sachg, "December"),
        Pair(R.drawable.sacha, "January"),
        Pair(R.drawable.sachb, "February"),
        Pair(R.drawable.sachc, "March"),
        Pair(R.drawable.sache, "April"),
        Pair(R.drawable.sachf, "May"),
        Pair(R.drawable.sachg, "June"),
        Pair(R.drawable.sach, "July"),
    )
    private val wallpapers by lazy {
        Array(18) { i ->
            Products(images[i].first, images[i].second, "Trung Đoan")
        }
    }

    //adapter
    //adapter view
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater, container, false)
//        https://developer.android.com/reference/androidx/recyclerview/widget/StaggeredGridLayoutManager
        binding.rcWallpaper.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rcWallpaper.adapter = ProductAdapter(wallpapers.toList(), this)

        return binding.root
    }

override fun onWallpaperItemClick(position: Int) {
        val wallpaper =
            wallpapers[position] //wallpaper đc người dùng click,pass qua detail fragment
        val fragment = DetailProductFragment.newInstance(wallpaper)

        exitTransition = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.explode)

        enterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.fade)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.content, fragment)
            .commit()
    }


}