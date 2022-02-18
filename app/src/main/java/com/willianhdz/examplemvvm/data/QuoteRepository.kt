package com.willianhdz.examplemvvm.data

import com.willianhdz.examplemvvm.data.model.QuoteModel
import com.willianhdz.examplemvvm.data.model.QuoteProvider
import com.willianhdz.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}