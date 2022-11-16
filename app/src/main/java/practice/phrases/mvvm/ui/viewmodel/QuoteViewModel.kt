package practice.phrases.mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import practice.phrases.mvvm.data.model.QuoteModel
import practice.phrases.mvvm.data.model.QuoteProvider
import practice.phrases.mvvm.domain.GetQuotesUseCase
import practice.phrases.mvvm.domain.GetRandomUseCase
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private var getQuotesUseCase: GetQuotesUseCase,
    private var getRandomUseCase: GetRandomUseCase
) : ViewModel() {

    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: LiveData<QuoteModel> get() = _quoteModel

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading




    fun onCreate() {
        viewModelScope.launch {
            _isLoading.postValue(true)

            delay(1500)
            //val result = getQuotesUseCase.invoke()
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                _quoteModel.postValue(result[0])
                _isLoading.postValue(false)
            }

        }
    }
    //val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        _isLoading.postValue(true)
        val quote = getRandomUseCase()
        if(quote != null){
            _quoteModel.postValue(quote!!)
        }

        _isLoading.postValue(false)
    }


}