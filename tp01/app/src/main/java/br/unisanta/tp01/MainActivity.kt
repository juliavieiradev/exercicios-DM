package br.unisanta.tp01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtUsuario = findViewById<EditText>(R.id.edt_usuario)
        val edtIdade = findViewById<EditText>(R.id.edt_idade)
        val btnBoasVindas = findViewById<Button>(R.id.btn_boasvindas)
        val txvSaudar = findViewById<TextView>(R.id.txv_saudar)
        val edtTemperatura = findViewById<EditText>(R.id.edt_temp)
        val btnConverter = findViewById<Button>(R.id.btn_temp)
        val txvTemperatura = findViewById<TextView>(R.id.txv_temp)
        val txvTensao = findViewById<EditText>(R.id.txv_tensao)
        val txvCorrente = findViewById<EditText>(R.id.txv_corrente)
        val txvResistencia = findViewById<EditText>(R.id.txv_resistencia)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val txvResultado = findViewById<TextView>(R.id.txv_result)


        btnBoasVindas.setOnClickListener{
            val usuario = edtUsuario.text.toString()
            val idade   = edtIdade.text.toString()
            txvSaudar.setText("Bem-vindo, $usuario! A sua idade é $idade")
            edtUsuario.text.clear()
            edtIdade.text.clear()
        }

        btnConverter.setOnClickListener{
            val celsius = edtTemperatura.text.toString().toDouble()
            val resultado = ( celsius * 1.8) + 32
            txvTemperatura.setText("Valor convertido: $resultado")
            edtTemperatura.text.clear()
        }

        btnCalcular.setOnClickListener {

            val v = txvTensao.text.toString()
            val r = txvResistencia.text.toString()
            val i = txvCorrente.text.toString()

            if (v == "" && r != "" && i != "") {

                val resistencia = r.toDouble()
                val corrente = i.toDouble()

                val tensao = resistencia * corrente

                txvResultado.text = "Tensão = $tensao V"

            } else if (v != "" && r == "" && i != "") {

                val tensao = v.toDouble()
                val corrente = i.toDouble()

                val resistencia = tensao / corrente

                txvResultado.text = "Resistência = $resistencia Ω"

            } else if (v != "" && r != "" && i == "") {

                val tensao = v.toDouble()
                val resistencia = r.toDouble()

                val corrente = tensao / resistencia

                txvResultado.text = "Corrente = $corrente A"

            } else {

                txvResultado.text = "Preencha exatamente dois campos."

            }


        }




    }
}