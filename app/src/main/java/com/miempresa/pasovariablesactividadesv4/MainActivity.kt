package com.miempresa.pasovariablesactividadesv4

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtseleccionados.isFocusable = false
        val values = arrayOf(
            "Juegos", "Aplicaciones",
            "Cursos", "Profesores", "Cerrar"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            values
        )

        lista.adapter = adapter
        lista.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val itemPosition = position
                val itemValue = lista.getItemAtPosition(position) as String
                val seleccionados = txtseleccionados.text.toString()
                when (itemValue){
                    "Juegos" -> {
                        val intent = Intent(this, juegos::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        intent.putExtra("itemvalue", itemValue)
                        startActivity(intent)
                    }
                    "Aplicaciones" -> {
                        val intent = Intent(this, aplicaciones::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        intent.putExtra("itemvalue", itemValue)
                        startActivity(intent)
                    }
                    "Cursos" -> {
                        val intent = Intent(this, cursos::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        intent.putExtra("itemvalue", itemValue)
                        startActivity(intent)
                    }
                    "Profesores" -> {
                        val intent = Intent(this, profesores::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        intent.putExtra("itemvalue", itemValue)
                        startActivity(intent)
                    }
                    "Cerrar" -> {
                        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                        builder.setMessage("¿Desea salir de la aplicación?")
                            .setPositiveButton("Si", DialogInterface.OnClickListener { dialog, id ->
                                val intent = Intent(Intent.ACTION_MAIN)
                                intent.addCategory(Intent.CATEGORY_HOME)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                            })
                            .setNegativeButton("Cancelar",
                                DialogInterface.OnClickListener { dialog, id -> dialog.dismiss() })
                        builder.show()
                        /*val intent = Intent(this, cerrar::class.java)
                        startActivity(intent)*/
                    }

                }
            }
        val bundle :Bundle?=intent.extras
        if (bundle!=null) {
            val recibidos = bundle.getString("parametro").toString()
            val datosactividad01 = bundle.getString("datosactividad01").toString()
            txtseleccionados.setText(datosactividad01+recibidos+"\n")


        }
                /*
                Toast.makeText(
                    this, "Posicion " + itemPosition + " Descripcion:" + itemValue,
                    Toast.LENGTH_LONG
                ).show()*/

    }
}