package com.osimple.calculator

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    var f = 1
    var s = arrayOf("C", "0", "=")
    var s1 = arrayOf("+", "-", "×","÷")

    var text_: TextView? = null

    var n1 :Long = 0;
    var n2 :Long = 0;
    var is_n1 = true
    var calcCase = ""


    //var height_ :Int =100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        text_ = findViewById<TextView>(R.id.textArea);
        text_?.text = ""
        val table_ = findViewById(R.id.tableLayout) as TableLayout;

        // val GL : GridLayout = findViewById(R.id.grid)
        //val GL = GridView(this);

        for (i in s) {
            val button = Button(this);

            button.text = i;

            val CL_1 = table_.getChildAt(3) as TableRow;

            val params = TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            )
            //params.height = height_

            params.weight = 1f;

            button.setLayoutParams(params)
            button.minimumHeight = 80;
            button.textSize = 30f
            button.setOnClickListener(){

                Calculate(it)
            }

            CL_1.addView(button);
        }

        //f++;

        for (i in 0..2) {
            for (j in 0..2) {

                val button = Button(this);
                //button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)

                button.text = f.toString();

                //button.setMargin(i*10,0,0,0)
                //val rel_btn: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
                val CL_1 = table_.getChildAt(i) as TableRow;

                val params = TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                )
                //params.setMargins(0, 100, 0, 0)
                //params.height = height_
                params.weight = 1f;

                button.setLayoutParams(params)
                button.minimumHeight = 80;
                button.textSize = 30f
                button.setOnClickListener(){

                    Calculate(it)
                }


                //button.minWidth = 100;

                //button.layout(i * 100,0,0,0)


                //button.setLayoutParams(rel_btn);

                // GL.addView(button)
                CL_1.addView(button);

                f++;

            }

        }

        var l = 0
        for (i in s1) {
            val button = Button(this);

            button.text = i;

            val CL_1 = table_.getChildAt(l) as TableRow;

            val params = TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            )
            //params.height = height_

            params.weight = 1f;

            button.setLayoutParams(params)
            button.minimumHeight = 80;
            button.textSize = 40f

            button.setOnClickListener(){

                Calculate(it)
            }

            CL_1.addView(button);
            l++
        }

    }

    fun CalcInit()
    {
        is_n1 = true

        if(calcCase == "sum") {
            text_?.text = (n1 + n2).toString()
        }
        else if(calcCase == "minus")
        {
            text_?.text = (n1 - n2).toString()
        }
        else if(calcCase == "multiply")
        {
            text_?.text = (n1 * n2).toString()
        }
        else if(calcCase == "divide" && n2 > 0)
        {
            text_?.text = (n1 / n2).toString()
        }
        calcCase = ""
        //is_n1 = false
        n1 = text_?.text.toString().toLong()
        n2=0
    }

    fun Calculate(v:View)
    {
        if ((v as Button).text == "C") {
            text_?.text = ""
            is_n1 = true
            n1=0
            n2=0
            return;
        }
        else if((v as Button).text == "+")
        {
            if(calcCase != "")
            {
                CalcInit()
            }
            is_n1 = false
            text_?.text = ""
            calcCase = "sum"
            return;
        }
        else if((v as Button).text == "-")
        {
            if(calcCase != "")
            {
                CalcInit()
            }
            is_n1 = false
            text_?.text = ""
            calcCase = "minus"
            return;
        }
        else if((v as Button).text == "×")
        {
            if(calcCase != "")
            {
                CalcInit()
            }
            is_n1 = false
            text_?.text = ""
            calcCase = "multiply"
            return;
        }
        else if((v as Button).text == "÷")
        {
            if(calcCase != "")
            {
                CalcInit()
            }
            is_n1 = false
            text_?.text = ""
            calcCase = "divide"
            return;
        }
        else if((v as Button).text == "=")
        {
            CalcInit()
            return;
        }

        //var text_ = findViewById<TextView>(R.id.textArea);

        text_?.append((v as Button).text)

        if(is_n1)
        {
            try {
                n1 = text_?.text.toString().toLong()
                throw Exception("Limit reached")

            }catch(e : Exception){

            }
        }
        else
        {
            try{
                n2 = text_?.text.toString().toLong()
            throw Exception("Limit reached")
            }
            catch(e : Exception) {

            }
        }



    }



}