package com.willianhdz.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.willianhdz.examplemvvm.data.model.QuoteModel
import com.willianhdz.examplemvvm.data.model.QuoteProvider
import com.willianhdz.examplemvvm.domain.GetQuotesUseCase
import com.willianhdz.examplemvvm.domain.GetRandomQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuotesUseCase()

    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result: List<QuoteModel>? = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote:QuoteModel? = getRandomQuotesUseCase()
        if (quote!=null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)
    }

}