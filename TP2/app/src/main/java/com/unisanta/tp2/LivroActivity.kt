package com.unisanta.tp2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)
        val txvinfoLivro = findViewById<TextView>(R.id.txv_infolivro)
        val txvinfoAutor = findViewById<TextView>(R.id.txv_infoautor)
        val fabRetorna = findViewById<FloatingActionButton>(R.id.fab_retorna)

        val nomeLivro = intent.getStringExtra("nome_livro")
        val nomeAutor = intent.getStringExtra("nome_autor")
        txvinfoLivro.setText(nomeLivro.toString())
        txvinfoAutor.setText(nomeAutor.toString())


        fabRetorna.setOnClickListener {

            finish()
        }


    }
}