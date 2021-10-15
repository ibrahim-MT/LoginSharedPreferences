package com.example.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp =getSharedPreferences("GirisBilgi",Context.MODE_PRIVATE)
        val otomatikGiris=sp.getString("kullancıAdi","kulancı adı yok")
        val otomatikSifre=sp.getString("sıfre","şifre yok")
        if (otomatikGiris=="admin"&&otomatikSifre=="12345"){
            startActivity(Intent(this@MainActivity,Activity_Detay::class.java))
            finish()
        }
        Giris.setOnClickListener {
            val ka =editTextTextKullancı.text.toString()
            val s =editTextTextSifre.text.toString()
            if (ka=="admin"&& s=="12345"){
                val editor =sp.edit()
                editor.putString("kullancıAdi",ka)
                editor.putString("sıfre",s)
                editor.commit()


                startActivity(Intent(this@MainActivity,Activity_Detay::class.java))
                finish()

            }else{
                Toast.makeText(applicationContext,"Hatalı Giriş",Toast.LENGTH_LONG).show()
            }

        }
    }
}