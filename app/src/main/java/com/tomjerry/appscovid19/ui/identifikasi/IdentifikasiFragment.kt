package com.tomjerry.appscovid19.ui.identifikasi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.repository.CovidRepository
import kotlinx.android.synthetic.main.identifikasi_fragment.*

class IdentifikasiFragment : Fragment() {

    private lateinit var viewModel: IdentifikasiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.identifikasi_fragment , container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            scroll1.post {
                val factory = IdentifikasiFactory(CovidRepository.instance , context , scroll1)
                viewModel = ViewModelProvider(this , factory).get(IdentifikasiViewModel::class.java)
                Log.println(Log.ASSERT, "scroll ", "scroll (${scroll1.height})")
                tampilan1.layoutParams.height = scroll1.height
                tampilan2.layoutParams.height = scroll1.height
                tampilan3.layoutParams.height = scroll1.height
                tampilan1.requestLayout()
                tampilan2.requestLayout()
                tampilan3.requestLayout()
            }

        } catch (ex : Exception) {
            Log.println(Log.ASSERT, "scroll ", "scroll ($ex)")
        }

    }

}
