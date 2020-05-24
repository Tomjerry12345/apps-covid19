package com.tomjerry.appscovid19.ui.identifikasi

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomjerry.appscovid19.repository.CovidRepository

@Suppress("UNCHECKED_CAST")
class IdentifikasiFactory(
    private val setRepository: CovidRepository ,
    private val tinggi: Int , private val context: Context? ,
    private val view: View?
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IdentifikasiViewModel::class.java))
            return IdentifikasiViewModel(setRepository , tinggi , context , view) as T
        throw IllegalArgumentException()
    }
}