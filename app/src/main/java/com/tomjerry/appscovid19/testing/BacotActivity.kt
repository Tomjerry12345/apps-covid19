package com.tomjerry.appscovid19.testing

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import com.tomjerry.appscovid19.R
import com.tomjerry.appscovid19.databinding.ActivityBacotBinding
import kotlinx.android.synthetic.main.activity_bacot.*


class BacotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityBacotBinding = DataBindingUtil.setContentView(this , R.layout.activity_bacot)
        binding.testku = User(2)

        scroll.post {
            val params = LinearLayoutCompat.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                scroll.height
            )

            tampilan1.layoutParams = params
            tampilan2.layoutParams = params
            tampilan3.layoutParams = params
        }

        Log.println(Log.ASSERT, "scroll ", "scroll (${scroll.height})")

        btn1.setOnClickListener {
            scroll.smoothScrollTo(0 , tampilan2.height)
        }
//
        btn2.setOnClickListener {
            scroll.smoothScrollTo(0 , tampilan2.height + tampilan1.height)
        }

        btn3.setOnClickListener {
            scroll.smoothScrollTo(0 , tampilan2.height + tampilan1.height)
        }

        back1.setOnClickListener {
            scroll.smoothScrollTo(0 , 0)
        }

        back2.setOnClickListener {
            scroll.smoothScrollTo(0 , tampilan2.height - tampilan1.height)
        }

        back3.setOnClickListener {
            scroll.smoothScrollTo(0 , tampilan2.height + tampilan1.height - tampilan1.height)
        }
//
    }

}
