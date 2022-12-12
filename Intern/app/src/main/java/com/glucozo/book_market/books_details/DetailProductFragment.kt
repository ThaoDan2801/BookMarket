package com.glucozo.book_market.books_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.glucozo.book_market.R
import com.glucozo.book_market.databinding.FragmentWallpaperDetailBinding
import com.glucozo.book_market.model.Products

class DetailProductFragment : Fragment() {
    private lateinit var binding: FragmentWallpaperDetailBinding
    private lateinit var wallpaper: Products

    //singleton
    companion object {
        fun newInstance(wallpaper: Products): DetailProductFragment {
            val fragment = DetailProductFragment()
            fragment.wallpaper = wallpaper
            return fragment
        }
    }
//    fun EventAdd{
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallpaperDetailBinding.inflate(inflater, container, false)
        binding.tvBook.text = wallpaper.name.toString()
        binding.tvTacgia.text = wallpaper.author
        Glide.with(binding.imgBook)
            .load(wallpaper.imageId)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.imgBook)
//        binding.btnSetAsWallpaper.setOnClickListener {
//            Thread {
//                WallpaperManager.getInstance(requireContext()).setResource(wallpaper.imageId)
//            }.start()
//        }
        return binding.root
    }

}