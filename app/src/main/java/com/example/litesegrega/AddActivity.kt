package com.example.litesegrega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btn_add.setOnClickListener {

            val name = add_txt_name.text.toString()
            val weight = add_text_weight.text.toString()
            var price = 0.00
            val drawable = R.drawable.ic_camera_alt_black_24dp

            if (name.isNotEmpty() && weight.isNotEmpty()) {

                var weight_doub = weight.toDouble()
                price = weight_doub * 0.5

                val residue = Residuo(name, price, weight_doub, drawable)
                GlobalResiduo.add(residue)

                add_txt_name.text.clear()
                add_text_weight.text.clear()

            }

            else{

                if(name.isEmpty()){ add_txt_name.error = "por favor insira um nome"}
                else{null}

                if(weight.isEmpty()){add_text_weight.error = "por favor insira um peso"}
                else{null}

            }


        }

    }
}
