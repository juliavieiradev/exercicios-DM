package com.example.appMVVM.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appMVVM.viewmodel.LoginViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var loginvm : LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        loginvm = LoginViewModel()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnEntrar.setOnClickListener{
            val email = binding.edtEmailUsuario.text.toString()
            val senha = binding.edtSenhaUsuario.text.toString()
            val ret = loginvm.entrar(email, senha)
            Toast.makeText( this, ret, Toast.LENGTH_SHORT).show()
        }
        binding.btnCadastrar.setOnClickListener{
            val email = binding.edtEmailUsuario.text.toString()
            val senha = binding.edtSenhaUsuario.text.toString()
            val ret = loginvm.cadastrar(email, senha)
            Toast.makeText( this, ret, Toast.LENGTH_SHORT).show()
        }
    }
}