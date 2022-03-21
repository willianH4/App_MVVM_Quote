package com.willianhdz.examplemvvm.domain

import com.willianhdz.examplemvvm.data.QuoteRepository
import com.willianhdz.examplemvvm.data.model.QuoteModel
import com.willianhdz.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuotesUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {
//    private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}