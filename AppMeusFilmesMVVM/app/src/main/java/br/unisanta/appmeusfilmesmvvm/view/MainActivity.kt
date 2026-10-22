package br.unisanta.appmeusfilmesmvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appmeusfilmesmvvm.R
import br.unisanta.appmeusfilmesmvvm.databinding.ActivityMainBinding
import br.unisanta.appmeusfilmesmvvm.viewmodel.filmeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: filmeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        vm = filmeViewModel()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAdicionar.setOnClickListener {
            val ok = vm.adicionar(
                binding.edtNome.text.toString(),
                binding.edtNota.text.toString(),
                binding.edtLogo.text.toString()
            )
            if (ok) {
                Toast.makeText(this, "Filme adicionado!", Toast.LENGTH_SHORT).show()
                binding.edtNome.text.clear()
                binding.edtNota.text.clear()
                binding.edtLogo.text.clear()
            } else {
                Toast.makeText(this, "Informe o nome e uma nota de 0 a 10", Toast.LENGTH_SHORT).show()
            }
        }

        binding.fabLista.setOnClickListener {
            startActivity(Intent(this, ListaActivity::class.java))
        }

    }
}