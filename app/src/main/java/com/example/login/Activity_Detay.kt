package com.example.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class Activity_Detay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        val sp =getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)
        val otomatikGiris=sp.getString("kullancıAdi","kulancı adı yok")
        val otomatikSifre=sp.getString("sıfre","şifre yok")

        Cıkıs.setOnClickListener {
            val editor =sp.edit()
            editor.remove("kulancıAdi")
            editor.remove("sıfre")
            editor.commit()
            startActivity(Intent(this@Activity_Detay,MainActivity::class.java))
            finish()
        }
    }
}