package com.unisanta.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNomeLivro = findViewById<EditText>(R.id.edt_nome)
        val edtNomeAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabInfos = findViewById<FloatingActionButton>(R.id.fab_info)

        var nomeLivro = " "
        var nomeAutor = " "

        btnCadastrar.setOnClickListener {
            if (nomeLivro.isEmpty() || nomeAutor.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                nomeLivro = edtNomeLivro.text.toString().trim()
                nomeAutor = edtNomeAutor.text.toString().trim()
                Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            }

        }


        fabInfos.setOnClickListener {
            if (nomeLivro.isEmpty() || nomeAutor.isEmpty()){
                Toast.makeText(this,"Nenhum livro cadastrado",Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, LivroActivity::class.java)
                intent.putExtra("nome_livro", nomeLivro)
                intent.putExtra("nome_autor", nomeAutor)
                startActivity(intent)
            }
        }
    }
}