package practice.phrases.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import practice.phrases.mvvm.model.QuoteModel
import practice.phrases.mvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: LiveData<QuoteModel> get() = _quoteModel

    //val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        _quoteModel.postValue(currentQuote)
        //quoteModel.postValue(currentQuote)
    }
}