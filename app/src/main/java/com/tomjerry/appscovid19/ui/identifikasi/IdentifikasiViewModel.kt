package com.tomjerry.appscovid19.ui.identifikasi

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import android.widget.ScrollView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.model.Golongan
import com.tomjerry.appscovid19.repository.CovidRepository
import com.tomjerry.appscovid19.utils.CustomDialog
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.identifikasi_fragment.view.*
import kotlinx.coroutines.launch

class IdentifikasiViewModel
    (
        private val covidRepository : CovidRepository,
        val context:Context? ,
        private val view: ScrollView
    ) : ViewModel() {
    // TODO: Implement the ViewModel

    private val answer = arrayListOf(true , true , true)
    private val selection = arrayListOf(false , false , false)
    private  var dataku = mutableListOf(Golongan("null" , "null"))

    init {
        val grey = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.grey) }
        val red = context?.let { it1 -> ContextCompat.getColorStateList(it1 , R.color.red) }
        val green = context?.let { it1 -> ContextCompat.getColorStateList(it1 , R.color.green) }
        val white = context?.let { it1 -> ContextCompat.getColorStateList(it1 , R.color.white) }
        val black = context?.let { it1 -> ContextCompat.getColorStateList(it1 , R.color.black) }

        view.btn1_1.setOnClickListener {
            it.backgroundTintList = grey
            view.back1_1.backgroundTintList = green
            it.isEnabled = false
            view.back1_1.isEnabled = true
            view.back1_1.setTextColor(black)
            answer[0] = true
            selection[0] = true
        }
        view.back1_1.setOnClickListener {
            it.backgroundTintList = grey
            view.back1_1.setTextColor(white)
            view.btn1_1.backgroundTintList = red
            it.isEnabled = false
            view.btn1_1.isEnabled = true
            answer[0] = false
            selection[0] = true
        }
        view.btn2_1.setOnClickListener {
            it.backgroundTintList = grey
            view.back2_1.backgroundTintList = green
            it.isEnabled = false
            view.back2_1.isEnabled = true
            view.back2_1.setTextColor(black)
            answer[1] = true
            selection[1] = true
        }
        view.back2_1.setOnClickListener {
            it.backgroundTintList = grey
            view.back2_1.setTextColor(white)
            view.btn2_1.backgroundTintList = red
            it.isEnabled = false
            view.btn2_1.isEnabled = true
            answer[1] = false
            selection[1] = true
        }
        view.btn3_1.setOnClickListener {
            it.backgroundTintList = grey
            view.back3_1.backgroundTintList = green
            it.isEnabled = false
            view.back3_1.isEnabled = true
            view.back3_1.setTextColor(black)
            answer[2] = true
            selection[2] = true
        }
        view.back3_1.setOnClickListener {
            it.backgroundTintList = grey
            view.back3_1.setTextColor(white)
            view.btn3_1.backgroundTintList = red
            it.isEnabled = false
            view.btn3_1.isEnabled = true
            answer[2] = false
            selection[2] = true
        }
        view.next1_1.setOnClickListener {
            view.smoothScrollTo(0 , view.height)
        }
        view.next2_1.setOnClickListener {
            view.smoothScrollTo(0 , view.height * 2)
        }
        view.previous2_1.setOnClickListener {
            view.smoothScrollTo(0 , view.height - view.height)
        }
        view.next3_1.setOnClickListener {
            if (!selection[0]) {
                showSnackbar(it , "belum di isi pada pertanyaan ke 1")
                view.smoothScrollTo(0 , view.height - view.height)
            } else if (!selection[1]) {
                showSnackbar(it , "belum di isi pada pertanyaan ke 2")
                view.smoothScrollTo(0 , view.height * 2 - view.height)
            } else if (!selection[2]) {
                showSnackbar(it , "belum di isi pada pertanyaan ke 3")
            } else {
                if (answer[0] && answer[1] && answer[2]) {
                    dataku[0].status = "PDP"
                    dataku[0].id = "001"
                    addGolongan(dataku , "Anda Tergolong PDP")
                }
                else if (answer[0] && answer[1] && !answer[2]) {
                    dataku[0].status = "ODP"
                    dataku[0].id = "001"
                    addGolongan(dataku, "Anda Tergolong ODP")
                } else if (answer[0] && !answer[1] && !answer[2]) {
                    dataku[0].status = "OTG"
                    dataku[0].id = "001"
                    addGolongan(dataku , "Anda Tergolong OTG")
                } else if (!answer[0] && !answer[1] && !answer[2]) {
                    dataku[0].status = "Bebas Covid"
                    dataku[0].id = "001"
                    addGolongan(dataku , "Bebas Covid")
                } else {
                    dataku[0].status = "Tidak Terindentifikasi Tapi Memiliki Salah Satu Gejala"
                    dataku[0].id = "001"
                    addGolongan(dataku , "Tidak Terindentifikasi Tapi Memiliki Salah Satu Gejala")
                }

            }
        }
        view.previous3_1.setOnClickListener {
            view.smoothScrollTo(0 , view.height * 2 - view.height)
        }
    }

    private fun showSnackbar(view: View, text: String) {
        val snackbar = Snackbar.make(view , text , Snackbar.LENGTH_SHORT)
        val snackView = snackbar.view
        snackView.setBackgroundResource(R.color.red)
        snackbar.show()
    }

    private fun addGolongan(list: MutableList<Golongan> , msg: String) {
        viewModelScope.launch {
            covidRepository.addGolongan(list , covidRepository.getGolongan())
//            val actionIdentification = IdentifikasiFragmentDirections.actionIdentifikasiFragmentToMainFragment()
//            view.findNavController().navigate(actionIdentification)
            val customDialog = CustomDialog()
            customDialog.showDialog(context , msg , view)
        }
    }

}


