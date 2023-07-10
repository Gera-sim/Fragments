package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.SelectPage
import com.example.fragments.databinding.FragmentBNestedBinding

// Второй фрагмент для ViewPager
class NestedFragmentB : BindingFragment<FragmentBNestedBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBNestedBinding {
        return FragmentBNestedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка названия песни и передача данных Activity
        binding.songText.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | B")

        /**
         * Тут так же при нажатии на кнопку заменяем фрагмент из "fragment_child_container" на
         * другой
         */
        binding.button.setOnClickListener {
            (parentFragment as? SelectPage)?.navigateTo(page = 0)
        }
    }
}