package com.tomjerry.appscovid19.ui.identifikasi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.ViewModelProvider

import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.databinding.IdentifikasiFragmentBinding
import com.tomjerry.appscovid19.repository.CovidRepository
import kotlinx.android.synthetic.main.identifikasi_fragment.*

class IdentifikasiFragment : Fragment() {

    private lateinit var viewModel: IdentifikasiViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = IdentifikasiFragmentBinding.inflate(inflater , container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        scroll.post {
            Log.println(Log.ASSERT, "scroll ", "scroll (${scroll.height})")
            val factory = IdentifikasiFactory(CovidRepository.instance , scroll.height , context , view)
            viewModel = ViewModelProvider(this , factory).get(IdentifikasiViewModel::class.java)
            tampilan1.layoutParams.height = scroll.height
            tampilan2.layoutParams.height = scroll.height
            tampilan3.layoutParams.height = scroll.height
        }


        // TODO: Use the ViewModel

//        btn1_1.setOnClickListener {
//            scroll.smoothScrollTo(0 , tampilan2.height)
//            btn2_1.isEnabled = false
//        }
////
//        btn2_1.setOnClickListener {
//            scroll.smoothScrollTo(0 , tampilan2.height + tampilan1.height)
//        }
//
//        btn3_1.setOnClickListener {
//            scroll.smoothScrollTo(0 , tampilan2.height + tampilan1.height)
//        }
//
//        back1_1.setOnClickListener {
//            scroll.smoothScrollTo(0 , 0)
//        }
//
//        back2_1.setOnClickListener {
//            scroll.smoothScrollTo(0 , tampilan2.height - tampilan1.height)
//        }
//
//        back3_1.setOnClickListener {
//            scroll.smoothScrollTo(0 , tampilan2.height + tampilan1.height - tampilan1.height)
//        }
    }

}
