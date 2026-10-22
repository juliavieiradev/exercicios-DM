package br.unisanta.appmeusfilmesmvvm.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.unisanta.appmeusfilmesmvvm.R
import br.unisanta.appmeusfilmesmvvm.databinding.ActivityListaBinding
import br.unisanta.appmeusfilmesmvvm.viewmodel.filmeViewModel

class ListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding
    private lateinit var vm: filmeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaBinding.inflate(layoutInflater)
        vm = filmeViewModel()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvFilmes.layoutManager = LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        binding.rvFilmes.adapter = FilmeAdapter(vm.listar()) { filme ->
            val intent = Intent(this, EditarActivity::class.java)
            intent.putExtra("id", filme.id)
            startActivity(intent)
        }
    }
}