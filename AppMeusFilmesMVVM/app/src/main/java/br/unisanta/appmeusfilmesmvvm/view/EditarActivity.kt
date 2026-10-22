package br.unisanta.appmeusfilmesmvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appmeusfilmesmvvm.R
import br.unisanta.appmeusfilmesmvvm.databinding.ActivityEditarBinding
import br.unisanta.appmeusfilmesmvvm.viewmodel.filmeViewModel
import coil.load

class EditarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarBinding
    private lateinit var vm: filmeViewModel
    private var filmeId = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditarBinding.inflate(layoutInflater)
        vm = filmeViewModel()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        filmeId = intent.getIntExtra("id", -1)
        val filme = vm.buscar(filmeId)
        if (filme == null) {
            finish()
            return
        }
        binding.edtNome.setText(filme.nome)
        binding.edtNota.setText(filme.nota.toString())
        binding.edtLogo.setText(filme.logo)
        binding.imgLogo.load(filme.logo)
        binding.btnSalvar.setOnClickListener {
            val ok = vm.editar(
                filmeId,
                binding.edtNome.text.toString(),
                binding.edtNota.text.toString(),
                binding.edtLogo.text.toString()
            )
            if (ok) {
                Toast.makeText(this, "Filme atualizado!", Toast.LENGTH_SHORT).show()
                finish() // volta para a lista, que recarrega no onResume
            } else {
                Toast.makeText(this, "Informe o nome e uma nota de 0 a 10", Toast.LENGTH_SHORT).show()
            }
        }


    }
}