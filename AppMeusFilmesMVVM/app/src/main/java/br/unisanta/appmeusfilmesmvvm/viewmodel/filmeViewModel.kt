package br.unisanta.appmeusfilmesmvvm.viewmodel

import androidx.lifecycle.ViewModel
import br.unisanta.appmeusfilmesmvvm.model.Filme

class filmeViewModel : ViewModel() {
    companion object {
        private val filmes = mutableListOf<Filme>()
        private var proximoId = 1
    }

    fun adicionar(nome:String, nota: String, logo: String): Boolean{
        val n = nota.replace(',','.').toFloatOrNull()?:return false
        if(nome.isBlank() || n !in 0f..10f) return false
        filmes.add(Filme(proximoId++, nome.trim(),n,logo.trim()))
        return true
    }
    fun buscar(id: Int): Filme? = filmes.find { it.id == id }
    fun listar(): List<Filme> = filmes.toList()

    fun editar(id:Int, nome: String, nota: String, logo: String):Boolean{
        val n = nota.replace(',','.').toFloatOrNull()?:return false
        if (nome.isBlank() || n !in 0f..10f) return false
        val i = filmes.indexOfFirst { it.id == id }
        if (i < 0) return false
        filmes[i] = Filme(id, nome.trim(), n, logo.trim())
        return true
    }

}