package com.miempresa.pasovariablesactividadesv4

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cerrar.*
import android.content.DialogInterface

import android.content.Intent
import android.view.KeyEvent.KEYCODE_BACK


class cerrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerrar)
        cancelar.setOnClickListener{
            onBackPressed()
        }

        cerrar.setOnClickListener {
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
        }

    }
}