package com.tomjerry.appscovid19.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.tomjerry.appscovid19.module.MPAndroidChart.data.BarData
import com.tomjerry.appscovid19.module.MPAndroidChart.data.BarDataSet
import com.tomjerry.appscovid19.module.MPAndroidChart.data.BarEntry
import com.tomjerry.appscovid19.module.MPAndroidChart.utils.ColorTemplate
import com.tomjerry.appscovid19.repository.CovidRepository
import kotlinx.coroutines.launch


class MainViewModel(private val covidRepository : CovidRepository) : ViewModel() {

    private val TAG: String = "MainActivityTAG"

    private val mKasusIndonesia: MutableLiveData<String> = MutableLiveData<String>()
    val kasusIndonesia : LiveData<String> = mKasusIndonesia
    private val mJmKasusIndonesia: MutableLiveData<String> = MutableLiveData<String>()
    val jmKasusIndonesia : LiveData<String> = mJmKasusIndonesia

    private val mSembuhIndonesia: MutableLiveData<String> = MutableLiveData<String>()
    val sembuhIndonesia: LiveData<String> = mSembuhIndonesia
    private val mJmSembuhIndonesia: MutableLiveData<String> = MutableLiveData<String>()
    val jmSembuhIndonesia : LiveData<String> = mJmSembuhIndonesia

    private val mMeninggalIndonesia: MutableLiveData<String> = MutableLiveData<String>()
    val meninggalIndonesia: LiveData<String> = mMeninggalIndonesia
    private val mJmMeninggalIndonesia: MutableLiveData<String> = MutableLiveData<String>()
    val jmMeninggalIndonesia : LiveData<String> = mJmMeninggalIndonesia

    private val mKasusMakassar: MutableLiveData<String> = MutableLiveData<String>()
    val kasusMakassar : LiveData<String> = mKasusMakassar
    private val mJmKasusMakassar: MutableLiveData<String> = MutableLiveData<String>()
    val jmKasusMakassar : LiveData<String> = mJmKasusMakassar

    private val mSembuhMakassar: MutableLiveData<String> = MutableLiveData<String>()
    val sembuhMakassar: LiveData<String> = mSembuhMakassar
    private val mJmSembuhMakassar: MutableLiveData<String> = MutableLiveData<String>()
    val jmSembuhMakassar : LiveData<String> = mJmSembuhMakassar

    private val mMeninggalMakassar: MutableLiveData<String> = MutableLiveData<String>()
    val meninggalMakassar: LiveData<String> = mMeninggalMakassar
    private val mJmMeninggalMakassar: MutableLiveData<String> = MutableLiveData<String>()
    val jmMeninggalMakassar : LiveData<String> = mJmMeninggalMakassar

    private val mLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val loading: LiveData<Boolean> = mLoading

    private val mDataloading: MutableLiveData<Boolean> = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = mDataloading

    private val mMessage: MutableLiveData<String> = MutableLiveData("Sedang Memuat.....")
    val message: LiveData<String> = mMessage

    private val mData: MutableLiveData<BarData> = MutableLiveData()
    val lData: LiveData<BarData> = mData

    private val mIdentifikasi: MutableLiveData<String> = MutableLiveData("Belum Terindentifikasi")
    val identifikasi : LiveData<String> = mIdentifikasi

    private val mDateIndonesia: MutableLiveData<String> = MutableLiveData()
    val dateIndonesia: LiveData<String> = mDateIndonesia

    private val mDateMakassar: MutableLiveData<String> = MutableLiveData()
    val dateMakassar: LiveData<String> = mDateMakassar

    init {
        getIndonesia()
        getMakassar()
        getStatus()
        getGolongan()
    }

    private fun getIndonesia() {
        viewModelScope.launch() {

            mLoading.value = true

            try {
                val indonesia = covidRepository.getIndonesia()
                Log.println(Log.ASSERT, TAG , "indonesiaku : $indonesia")
                mKasusIndonesia.value = indonesia?.get(0)?.status
                mJmKasusIndonesia.value = indonesia?.get(0)?.total

                mSembuhIndonesia.value = indonesia?.get(1)?.status
                mJmSembuhIndonesia.value = indonesia?.get(1)?.total

                mMeninggalIndonesia.value = indonesia?.get(2)?.status
                mJmMeninggalIndonesia.value = indonesia?.get(2)?.total

                mDateIndonesia.value = indonesia?.get(0)?.updated_at?.substring(0 , 10)

                mLoading.value = false
                mDataloading.value = false

            } catch (ex: Exception) {
                mLoading.value = true
                mDataloading.value = false
                mMessage.value = ex.toString()
            }

        }

    }

    private fun getMakassar() {
        viewModelScope.launch() {

            mLoading.value = true

            try {
                val makassar = covidRepository.getMakassar()
                Log.println(Log.ASSERT, TAG , "makassarku : $makassar")
                mKasusMakassar.value = makassar?.get(0)?.status
                mJmKasusMakassar.value = makassar?.get(0)?.total

                mSembuhMakassar.value = makassar?.get(1)?.status
                mJmSembuhMakassar.value = makassar?.get(1)?.total

                mMeninggalMakassar.value = makassar?.get(2)?.status
                mJmMeninggalMakassar.value = makassar?.get(2)?.total

                mDateMakassar.value = makassar?.get(0)?.updated_at?.substring(0 , 10)

                mLoading.value = false

            } catch (ex: Exception) {
                mLoading.value = true
                mMessage.value = ex.toString()
            }

        }

    }

    private fun getStatus() {
        viewModelScope.launch {

            mLoading.value = true

            try {
                val kasus = covidRepository.getKasus()
                val sembuh = covidRepository.getSembuh()
                val meninggal = covidRepository.getMeninggal()
                Log.println(Log.ASSERT, TAG, "kasusku : $kasus")
                Log.println(Log.ASSERT, TAG, "sembuhku : $sembuh")
                Log.println(Log.ASSERT, TAG, "meninggalx : $meninggal")

                val dataKasus = listOf(
                    kasus?.get(0)?.jumlah?.toFloat()?.let {
                        BarEntry(0f, it)
                    },
                    kasus?.get(1)?.jumlah?.toFloat()?.let {
                        BarEntry(1.70f, it)
                    },
                    kasus?.get(2)?.jumlah?.toFloat()?.let {
                        BarEntry(3.40f, it)
                    }
                )

                val dataSembuh = listOf(
                    sembuh?.get(0)?.jumlah?.toFloat()?.let {
                        BarEntry(0.50f, it)
                    },
                    sembuh?.get(1)?.jumlah?.toFloat()?.let {
                        BarEntry(2.20f, it)
                    },
                    sembuh?.get(2)?.jumlah?.toFloat()?.let {
                        BarEntry(3.90f, it)
                    }
                )

                val dataMeninggal = listOf(
                    meninggal?.get(0)?.jumlah?.toFloat()?.let {
                        BarEntry(1f, it)
                    },
                    meninggal?.get(1)?.jumlah?.toFloat()?.let {
                        BarEntry(2.70f, it)
                    },
                    meninggal?.get(2)?.jumlah?.toFloat()?.let {
                        BarEntry(4.40f, it)
                    }
                )

                Log.println(Log.ASSERT, "kasuzzz", "kasuszzz : $dataKasus")
                val set = BarDataSet(dataKasus, "Kasus")
                val set1 = BarDataSet(dataSembuh, "Sembuh")
                val set2 = BarDataSet(dataMeninggal, "Meninggal")

                set.colors = ColorTemplate.createColors(ColorTemplate.COLOR_KASUS)
                set1.colors = ColorTemplate.createColors(ColorTemplate.COLOR_SEMBUH)
                set2.colors = ColorTemplate.createColors(ColorTemplate.COLOR_MENINGGAL)

                val data = BarData(set, set1 , set2)

                mData.value = data

            } catch (ex: Exception) {
                Log.println(Log.ASSERT, "kasusError", "kasus Error : $ex")
            }
        }

    }

    private fun getGolongan() {
        viewModelScope.launch {
            try {
                val golongan = covidRepository.getGolongan()
                Log.println(Log.ASSERT , "golongan" , "$golongan")
                golongan?.let {
                    mIdentifikasi.value = it[0].status
                }
            } catch (ex : Exception) {
                Log.println(Log.ASSERT , "golonganError" , "golongan error : $ex")
            }
        }
    }

    fun getResponse() {
        viewModelScope.launch {
            mLoading.value = true
            try {
                covidRepository.getResponse()
                getIndonesia()
                getMakassar()
                getStatus()
                mLoading.value = false
                mDataloading.value = false
            } catch (ex: Exception) {
                mLoading.value = true
                mDataloading.value = false
                mMessage.value = ex.toString()
            }

        }
    }

    fun btnIdentification(view: View) {
        val actionIdentification = MainFragmentDirections.actionMainFragmentToIdentifikasiFragment()
        view.findNavController().navigate(actionIdentification)
    }

}
