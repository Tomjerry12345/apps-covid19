package com.tomjerry.appscovid19.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomjerry.appscovid19.repository.CovidRepository

@Suppress("UNCHECKED_CAST")
class MainFactory(
    private val setRepository: CovidRepository ,
    private val context: Context?
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(setRepository , context) as T
        throw IllegalArgumentException()
    }
}