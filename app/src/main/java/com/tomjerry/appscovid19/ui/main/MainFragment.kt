package com.tomjerry.appscovid19.ui.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.databinding.MainFragmentBinding
import com.tomjerry.appscovid19.module.MPAndroidChart.components.AxisBase
import com.tomjerry.appscovid19.module.MPAndroidChart.formatter.ValueFormatter
import com.tomjerry.appscovid19.repository.CovidRepository
import kotlinx.android.synthetic.main.card_identification.*
import kotlinx.android.synthetic.main.data_statistik.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var mainViewModel : MainViewModel

    private var selection = true

    val quarters =
        arrayOf("Maret",  "" , "April"  , "" , "Mei" , "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = MainFragmentBinding.inflate(inflater , container, false)
        val factory = MainFactory(CovidRepository.instance)
        mainViewModel = ViewModelProvider(this , factory).get(MainViewModel::class.java)
        binding.mainViewModel = mainViewModel
        binding.infoCovid.mainViewModel = mainViewModel
        binding.cardIdentification.mainViewModel = mainViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.dataLoading.observe(viewLifecycleOwner , Observer {
            srlSet.isRefreshing = it
        })

        mainViewModel.lData.observe(viewLifecycleOwner, Observer {

            val formatter: ValueFormatter =
                object : ValueFormatter() {
                    override fun getAxisLabel(value: Float, axis: AxisBase): String {
                        return quarters[value.toInt()]
                    }
                }

            val xAxis = chart.xAxis
            xAxis.granularity = 1f // minimum axis-step (interval) is 1
            xAxis.valueFormatter = formatter

            val barWidth = 0.50f // x2 dataset

            it.barWidth = barWidth
            chart.data = it
            chart.setFitBars(true)
            chart.invalidate() // refresh

        })
        srlSet.setOnRefreshListener {
            mainViewModel.getResponse()
        }

        mainViewModel.identifikasi.observe(viewLifecycleOwner, Observer {
            if(it != "Belum Terindentifikasi") {
                ic_no_covid.background = context?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.bacteria) }
            }
        })

            scroll.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                Log.println(Log.ASSERT , "scroll_position", "$scrollY")
                if(scrollY >= 120 && selection) {
                    chart.animateY(3000)
                    selection = false

                }
            }


    }

}

