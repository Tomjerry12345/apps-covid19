package com.tomjerry.appscovid19.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.ScrollView
import androidx.navigation.findNavController
import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.ui.identifikasi.IdentifikasiFragmentDirections
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.btn_ok as btn_ok1

class CustomDialog {

    fun showDialog(context: Context? , msg: String , view: ScrollView) {
        val dialog = Dialog(context!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog)

        dialog.text2.text = msg

        dialog.btn_ok1.setOnClickListener {
            val actionIdentification = IdentifikasiFragmentDirections.actionIdentifikasiFragmentToMainFragment()
            view.findNavController().navigate(actionIdentification)
            dialog.dismiss()
        }

        dialog.show()
    }
}