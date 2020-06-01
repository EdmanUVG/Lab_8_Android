package com.example.lab_8_android.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.lab_8_android.R
import com.example.lab_8_android.database.HNEndpoints
import com.example.lab_8_android.database.PopularMovies
import com.example.lab_8_android.database.ServiceBuilder
import com.example.lab_8_android.databinding.FragmentNewsBinding
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request = ServiceBuilder.buildService(HNEndpoints::class.java)
        val call = request.getNews(getString(R.string.api_key))

        call.enqueue(object : Callback<PopularMovies>{
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful){
                    progress_bar.visibility = View.GONE
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = NewsAdapter(response.body()!!.results)
                    }
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
