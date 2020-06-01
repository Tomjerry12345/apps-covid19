package com.tomjerry.appscovid19.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomjerry.appscovid19.repository.CovidRepository

@Suppress("UNCHECKED_CAST")
class MainFactory(
    private val setRepository: CovidRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(setRepository) as T
        throw IllegalArgumentException()
    }
}