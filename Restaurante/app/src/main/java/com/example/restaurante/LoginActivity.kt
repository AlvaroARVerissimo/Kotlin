package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding:ActivityLoginBinding
// Método onCreate é chamado quando a atividade é criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  // Infla o layout da atividade de login e inicializa a variável 'binding'.
        binding = ActivityLoginBinding.inflate(layoutInflater)
            // Define o layout da atividade como a visualização raiz no arquivo de layout vinculado.
        setContentView(binding.root)
    // Define um ouvinte de clique para o botão 'buttonEntrar'.
        binding.buttonEntrar.setOnClickListener {
              // Recupera o nome de usuário e a senha inseridos pelo usuário, removendo espaços em branco no início e no fim.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            
 // Se o nome de usuário for "abc" e a senha for "123", inicia a MainActivity.
            if (username.equals("abc") && password.equals("123")) {
                 // Cria uma intenção para iniciar a MainActivity.
                val i = Intent(this, MainActivity::class.java)
                 // Adiciona o nome de usuário como um extra na intenção.
                i.putExtra("username", username)
                  // Inicia a MainActivity e termina a atividade de login.
                startActivity(i)
                finish()
            } else {
                  // Se o nome de usuário ou a senha estiverem incorretos, exibe um Toast com a mensagem "Errou".
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}
