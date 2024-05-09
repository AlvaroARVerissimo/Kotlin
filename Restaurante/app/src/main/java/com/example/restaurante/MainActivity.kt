package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

// Declaração de uma variável para acessar os elementos da interface do usuário
private lateinit var binding:ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
    // Infla o layout da ActivityMain e atribui ao binding
    binding = ActivityMainBinding.inflate(layoutInflater)

    // Chama o método onCreate da superclasse
    super.onCreate(savedInstanceState)
    // Define o conteúdo da view para a ActivityMain
    setContentView(binding.root)

    // Recupera o nome de usuário passado como extra na Intent
    val username = intent.extras?.getString("username")

    // Se o nome de usuário não for nulo ou vazio, define o texto do TextView textOla
    if(!username.isNullOrEmpty()){
        binding.textOla.setText("Olá $username")
    }

    // Define um listener para o botão Fechar que finaliza a atividade
    binding.buttonFechar.setOnClickListener {
        finishAffinity()
    }

    // Define um listener para o botão Pedir que inicia a SplashActivity
    binding.buttonPedir.setOnClickListener {
        val i = Intent(this, SplashActivity::class.java)
        // Passa as quantidades de pizza, salada e hambúrguer como extras na Intent
        i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
        i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
        i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
        // Inicia a SplashActivity
        startActivity(i)
        // Finaliza a atividade atual
        finish()
    }

    // Define um listener para o CheckBox da pizza
    binding.checkPizza.setOnClickListener {
        // Se o CheckBox estiver marcado, define a quantidade de pizza como 1 e torna o preço visível
        if(binding.checkPizza.isChecked()){
            binding.editQuantidadePizza.setText("1")
            binding.textPrecoPizza.visibility = View.VISIBLE
        }else{
            // Se o CheckBox não estiver marcado, define a quantidade de pizza como 0 e esconde o preço
            binding.editQuantidadePizza.setText("0")
            binding.textPrecoPizza.visibility = View.GONE
        }
    }

    // Define um listener para o CheckBox da salada
    binding.checkSalada.setOnClickListener {
        // Se o CheckBox estiver marcado, define a quantidade de salada como 1 e torna o preço visível
        if(binding.checkSalada.isChecked()){
            binding.editQuantidadeSalada.setText("1")
            binding.textPrecoSalada.visibility = View.VISIBLE
        }else{
            // Se o CheckBox não estiver marcado, define a quantidade de salada como 0 e esconde o preço
            binding.editQuantidadeSalada.setText("0")
            binding.textPrecoSalada.visibility = View.GONE
        }
    }

    // Define um listener para o CheckBox do hambúrguer
    binding.checkHamburger.setOnClickListener {
        // Se o CheckBox estiver marcado, define a quantidade de hambúrguer como 1 e torna o preço visível
        if(binding.checkHamburger.isChecked()){
            binding.editQuantidadeHamburguer.setText("1")
            binding.textPrecoHamburguer.visibility = View.VISIBLE
        }else{
            // Se o CheckBox não estiver marcado, define a quantidade de hambúrguer como 0 e esconde o preço
            binding.editQuantidadeHamburguer.setText("0")
            binding.textPrecoHamburguer.visibility = View.GONE
        }
    }
}
}
