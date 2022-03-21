package com.willianhdz.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.willianhdz.examplemvvm.data.model.QuoteModel
import com.willianhdz.examplemvvm.data.model.QuoteProvider
import com.willianhdz.examplemvvm.domain.GetQuotesUseCase
import com.willianhdz.examplemvvm.domain.GetRandomQuotesUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // preparamos para hacerla de tipo injectable
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuotesUseCase:GetRandomQuotesUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

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