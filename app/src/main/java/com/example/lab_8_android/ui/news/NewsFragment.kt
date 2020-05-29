package com.example.lab_8_android.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.example.lab_8_android.R
import com.example.lab_8_android.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.hacker_news_text)


        return binding.root
    }
}
