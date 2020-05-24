package com.tomjerry.appscovid19.ui.identifikasi

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.repository.CovidRepository
import kotlinx.android.synthetic.main.identifikasi_fragment.view.*

class IdentifikasiViewModel(private val covidRepository : CovidRepository,
                            private val tinggi : Int ,
                            private val context:Context? ,
                            private val view: View?)
    : ViewModel() {
    // TODO: Implement the ViewModel
    init {
        test()
    }
    fun test() {
        Toast.makeText(context , "tinggi : $tinggi" , Toast.LENGTH_SHORT).show()
        Log.println(Log.ASSERT , "test" , "tinggi : $tinggi")
        view?.let {
            it.btn1_1.setBackgroundColor(ResourcesCompat.getColor(Resources.getSystem() , R.color.grey , null))
        }
    }
}
