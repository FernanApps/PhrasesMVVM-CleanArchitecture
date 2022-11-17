package practice.phrases.mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import practice.phrases.mvvm.domain.GetQuotesUseCase
import practice.phrases.mvvm.domain.GetRandomQuoteUseCase
import practice.phrases.mvvm.domain.model.Quote
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private var getQuotesUseCase: GetQuotesUseCase,
    private var getRandomUseCase: GetRandomQuoteUseCase,
) : ViewModel() {

    private val _quoteModel = MutableLiveData<Quote>()
    val quoteModel: LiveData<Quote> get() = _quoteModel





    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun onCreate() {
        viewModelScope.launch {
            _isLoading.postValue(true)

            delay(1500)
            // = val result = getQuotesUseCase.invoke()
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                _quoteModel.postValue(result[0])
                _isLoading.postValue(false)
            }

        }
    }
    //val quoteModel = MutableLiveData<Quote>()

    fun randomQuote() {
        viewModelScope.launch {

            _isLoading.postValue(true)
            val quote = getRandomUseCase()
            if (quote != null) {
                _quoteModel.postValue(quote!!)
            }
            _isLoading.postValue(false)

        }

    }

    fun setQuoteModel(value: Quote){
        _quoteModel.value = value
    }



}