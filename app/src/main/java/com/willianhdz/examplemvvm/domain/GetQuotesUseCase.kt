package com.willianhdz.examplemvvm.domain

import com.willianhdz.examplemvvm.data.QuoteRepository
import com.willianhdz.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuotes()
    }

}