package com.example.lab_8_android.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lab_8_android.R
import com.example.lab_8_android.databinding.FragmentHomeBinding
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_home_fragment_to_newsFragment)
        }

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.hacker_news_text)

        return binding.root
    }

}
