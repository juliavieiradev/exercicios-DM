package com.example.appMVVM.viewmodel

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import com.example.appMVVM.model.Usuario

class LoginViewModel : ViewModel(){
    private val usuarios = mutableListOf<Usuario>()
    fun entrar(email:String, senha:String):String{
        val usuario = usuarios.find { it.email == email && it.senha == senha }
        if(usuario != null){
            return "Usuário pode entrar!"
        }
        return "Usuario não cadastrado!"
    }
    fun cadastrar(email:String, senha:String):String{
        usuarios.add(Usuario(email, senha))
        return "Cadastrado com sucesso!"
    }
}