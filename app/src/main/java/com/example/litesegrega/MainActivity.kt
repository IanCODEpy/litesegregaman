package com.example.litesegrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {


    override fun onResume() {
        super.onResume()
        recycler_view.adapter = ResiduoAdapter(GlobalResiduo)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        val f = NumberFormat.getCurrencyInstance(Locale("pt","br"))

        var sum_price = 0.0
        var sum_weight = 0.0
        var weight = ""
        for(i in GlobalResiduo){
            sum_price += i.price
        }

        for(i in GlobalResiduo){

            sum_weight += i.weight
        }

        txt_total_weight.text = "%.2f kg".format(sum_weight)
        txt_total_value.text = f.format(sum_price)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = ResiduoAdapter(GlobalResiduo)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        btn_go_add.setOnClickListener{

            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

    }
}
