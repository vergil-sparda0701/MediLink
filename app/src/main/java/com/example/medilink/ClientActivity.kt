package com.example.medilink

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class ClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_client)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainClient)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //region desplegar datePicker
        val editText = findViewById<EditText>(R.id.txtFecha)

        editText.setOnClickListener {
            val calendario = Calendar.getInstance()
            val anio = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                val fechaSeleccionada = "$dayOfMonth/${month + 1}/$year"
                editText.setText(fechaSeleccionada)
            }, anio, mes, dia)

            datePicker.show()
        }

        //endregion

        //region Llenar cboSexo
        val spinner: Spinner = findViewById(R.id.cboSexo)
        val opciones = listOf("Masculino", "Femenino")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        //endregion

        //region Llenar cboEstadoCivil
        val spinner2: Spinner = findViewById(R.id.cboEstadoCivil)
        val opciones2 = listOf("Soltero/a", "Casado/a", "Divorciado/a", "Union libre")

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones2)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner2.adapter = adapter2

        //endregion

        //region Llenar cboSangre
        val spinner3: Spinner = findViewById(R.id.cboSangre)
        val opciones3 = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", "Desconocido")

        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones3)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner3.adapter = adapter3

        //endregion
    }
}
