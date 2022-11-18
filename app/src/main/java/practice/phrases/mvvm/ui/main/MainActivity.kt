package practice.phrases.mvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import practice.phrases.mvvm.databinding.ActivityMainBinding
import practice.phrases.mvvm.ui.main.QuoteViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserves()
        initActions()

        quoteViewModel.onCreate()



    }
    private fun initObserves(){
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer { load ->
            binding.loading.isVisible = load
        })

    }
    private fun initActions(){
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }
}