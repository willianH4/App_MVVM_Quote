package com.willianhdz.examplemvvm.data.network

import com.willianhdz.examplemvvm.core.RetrofitHelper
import com.willianhdz.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}