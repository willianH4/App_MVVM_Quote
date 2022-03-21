package com.willianhdz.examplemvvm.data

import com.willianhdz.examplemvvm.data.model.QuoteModel
import com.willianhdz.examplemvvm.data.model.QuoteProvider
import com.willianhdz.examplemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider) {

//    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }

}