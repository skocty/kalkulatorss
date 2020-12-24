package com.example.kalkulatorsmirnov

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     @SuppressLint("SetTextI18n")
     fun onDigitClick(v: View) {
         val math_operation = findViewById<TextView>(R.id.math_operation)
         var tmp = math_operation.text.toString()

         val btn = findViewById<Button>(v.id)

         math_operation.text = tmp+btn.text
         val btn_ac = findViewById<TextView>(R.id.btn_ac)
         btn_ac.setOnClickListener{math_operation.text=""
             val result_text = findViewById<TextView>(R.id.result_text)
             result_text.text = ""
         }
         val btn_back = findViewById<TextView>(R.id.btn_back)
         btn_back.setOnClickListener{
             val str = math_operation.text.toString()
             if(str.isNotEmpty()) {
                 math_operation.text = str.substring(0,str.length-1)
                 val result_text = findViewById<TextView>(R.id.result_text)
                 result_text.text=""


             }
             val btn_pavno = findViewById<TextView>(R.id.btn_pavno)
             btn_pavno.setOnClickListener{
                 try {val ex = ExpressionBuilder(math_operation.text.toString()).build()
                     val result = ex.evaluate()
                     val longRes = result.toLong()
                     val result_text = findViewById<TextView>(R.id.result_text)
                     if(result==longRes.toDouble()) {

                         result_text.text = longRes.toString()

                     }else
                         result_text.text = result.toString()

                 } catch (e:Exception){
                     Log.d("Ошибка","сообщение: ${e.message}" )


                 }



             }
             }


         }




//        // when - это аналог switch
//        when(v.id) {

            //R.id.btn_one - идентификатор кнопки
//            R.id.btn_one -> textView.text = tmp+'1'
//            R.id.btn_bs->{
//                if(tmp.isNotEmpty()) {
//                    textView.text = tmp.take(tmp.length-1)
//                }
//            }
    }




