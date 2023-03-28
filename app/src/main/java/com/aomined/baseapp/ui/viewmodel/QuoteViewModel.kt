package com.test.mvvmapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aomined.baseapp.data.network.QuoteService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
  private val quoteService: QuoteService
): ViewModel() {
   // val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
        isLoading.postValue(true)
       /* viewModelScope.launch {
            val result = getQuotesUsesCase()

            if(result.isNotEmpty()){
                quoteModel.postValue(result[0])
            }
            isLoading.postValue(false)
        }*/
    }

    fun randomQuote(){
        /*isLoading.postValue(true)
       val random = getRandomQuoteUseCase()
        if(random != null){
            quoteModel.postValue(random)
        }

        isLoading.postValue(false)*/
    }



}