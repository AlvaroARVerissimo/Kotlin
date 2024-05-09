package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
   // Declaração de uma variável 'binding' que será inicializada posteriormente.
// Esta variável será usada para acessar e manipular os elementos da interface do usuário.
private lateinit var binding: ActivityPedidoBinding

// Método onCreate é chamado quando a atividade é criada.
override fun onCreate(savedInstanceState: Bundle?) {
    // Infla o layout da atividade de pedido e inicializa a variável 'binding'.
    binding = ActivityPedidoBinding.inflate(layoutInflater)
    
    // Chama o método onCreate da superclasse.
    super.onCreate(savedInstanceState)
    
    // Define o layout da atividade como a visualização raiz no arquivo de layout vinculado.
    setContentView(binding.root)

    // Recupera a intenção que iniciou esta atividade.
    val i = intent
    
    // Recupera as quantidades de pizza, salada e hambúrguer passadas como extras na intenção.
    val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
    val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
    val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

    // Cria um texto de resumo do pedido, incluindo a quantidade e o preço de cada item.
    val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

    // Define o texto do elemento 'textResumo' como o texto de resumo do pedido.
    binding.textResumo.text = texto
}
}
