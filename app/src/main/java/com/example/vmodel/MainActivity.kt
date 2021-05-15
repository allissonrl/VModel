package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var BtnMostrar: Button

    lateinit var nViewModel: MainViewModel

    var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initDados()
        initClick()


    }






    private fun initClick() {
        btnDados.setOnClickListener {
            nViewModel.contador()

        }
        BtnMostrar.setOnClickListener {
            Toast.makeText(applicationContext, "Valor Contador: ${nViewModel.mContador.value)}", Toast.LENGTH_SHORT).show()
        }
    }



    private fun initDados() {

        nViewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        txtContador = findViewById(R.id.TextContador)
        btnDados = findViewById(R.id.btnDados)
        BtnMostrar = findViewById(R.id.btnMostrar)

        nViewModel.mContador.observe(this, Observer {valor ->
            txtContador.setText(valor)
        })
    }
}