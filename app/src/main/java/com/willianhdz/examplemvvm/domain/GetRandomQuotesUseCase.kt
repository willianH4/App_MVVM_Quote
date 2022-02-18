package com.willianhdz.examplemvvm.domain

import com.willianhdz.examplemvvm.data.QuoteRepository
import com.willianhdz.examplemvvm.data.model.QuoteModel
import com.willianhdz.examplemvvm.data.model.QuoteProvider

class GetRandomQuotesUseCase {
    private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}