package br.unisanta.appmeusfilmesmvvm.view

import android.R.attr.onClick
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.appmeusfilmesmvvm.model.Filme
import br.unisanta.appmeusfilmesmvvm.databinding.ItemFilmeBinding
import coil.load

class FilmeAdapter (
    private val filmes: List<Filme>,
    private val onCLick: (Filme)-> Unit
): RecyclerView.Adapter<FilmeAdapter.VH>(){
    class VH(val b: ItemFilmeBinding) : RecyclerView.ViewHolder(b.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemFilmeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: VH, position: Int) {
        val f = filmes[position]
        holder.b.txtNome.text = f.nome
        holder.b.txtNota.text = "Nota: ${f.nota}"
        holder.b.imgLogo.load(f.logo) {
            placeholder(android.R.drawable.ic_menu_gallery)
            error(android.R.drawable.ic_menu_report_image)
        }
        holder.b.root.setOnClickListener { onCLick(f) }
    }
    override fun getItemCount() = filmes.size


}