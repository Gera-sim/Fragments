package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.SelectPage
import com.example.fragments.databinding.FragmentABinding

// Родительский класс, в котором будет наш ViewPager
class FragmentA : BindingFragment<FragmentABinding>(),
    SelectPage {

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentABinding {
        return FragmentABinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка названия песни и передача данных через аргументы
        binding.songText.text = requireArguments().getString(SONG_NAME_KEY)
            .plus(other = " | Parent")

        // Таким образом происходит установка адаптера нашему ViewPager
        val adapter = PagerAdapter(hostFragment = this)
        binding.pager.adapter = adapter
    }

    override fun navigateTo(page: Int) {
        binding.pager.currentItem = page
    }

    companion object {
        private const val SONG_NAME_KEY = "SONG_NAME_KEY"

        fun getInstance(songName: String): FragmentA = FragmentA().apply {
            arguments = bundleOf(SONG_NAME_KEY to songName)
        }
    }
}