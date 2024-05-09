package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
    // Chama o método onCreate da superclasse
    super.onCreate(savedInstanceState)
    // Define o conteúdo da view para a ActivitySplash
    setContentView(R.layout.activity_splash)

    // Cria um Handler associado ao Looper principal (UI thread)
    Handler(Looper.getMainLooper()).postDelayed({
        // Recupera a Intent atual
        val i = intent
        // Cria uma nova Intent para a PedidoActivity
        val j = Intent(this,PedidoActivity::class.java)
        // Copia todos os extras da Intent atual para a nova Intent
        j.putExtras(i)
        // Inicia a PedidoActivity
        startActivity(j)
    },2000) // Atraso de 2 segundos (2000 milissegundos)
}
}
