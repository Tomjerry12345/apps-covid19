package com.tomjerry.appscovid19.ui.main

import android.R
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tomjerry.appscovid19.databinding.MainFragmentBinding
import com.tomjerry.appscovid19.module.MPAndroidChart.components.AxisBase
import com.tomjerry.appscovid19.module.MPAndroidChart.formatter.ValueFormatter
import com.tomjerry.appscovid19.repository.CovidRepository
import kotlinx.android.synthetic.main.data_statistik.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var mainViewModel : MainViewModel

    private var selection = true

    val quarters =
        arrayOf("Maret",  "" , "April"  , "" , "Mei" , "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = MainFragmentBinding.inflate(inflater , container, false)
        val factory = MainFactory(CovidRepository.instance , context)
        mainViewModel = ViewModelProvider(this , factory).get(MainViewModel::class.java)
        binding.viewModel = mainViewModel
        binding.infoCovid.viewModel = binding.viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

            Log.println(Log.ASSERT, "test", "dataku : $it")
            it.barWidth = barWidth
            chart.data = it
            chart.setFitBars(true)
            chart.invalidate() // refresh

        })
        srlSet.setOnRefreshListener {
            mainViewModel.getIndonesia()
            mainViewModel.getMakassar()
            mainViewModel.getStatus()
        }

        scroll.viewTreeObserver.addOnScrollChangedListener {
            if(scroll.scrollY >= 120 && selection) {
                chart.animateY(3000)
                selection = false
            }

        }
    }

}

