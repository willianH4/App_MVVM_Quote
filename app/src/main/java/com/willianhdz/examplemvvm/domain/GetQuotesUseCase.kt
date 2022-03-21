package com.willianhdz.examplemvvm.domain

import com.willianhdz.examplemvvm.data.QuoteRepository
import com.willianhdz.examplemvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

//    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuotes()
    }

}