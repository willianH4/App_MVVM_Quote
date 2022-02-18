package com.willianhdz.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willianhdz.examplemvvm.model.QuoteModel
import com.willianhdz.examplemvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote : QuoteModel = QuoteProvider.random();
        quoteModel.postValue(currentQuote);
    }

}