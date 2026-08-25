package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtEdad;

    private TextView txtResultado;
    private TextView txtAsistencia;

    private Button btnVerificar;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Conectar elementos del XML
        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);

        txtResultado = findViewById(R.id.txtResultado);
        txtAsistencia = findViewById(R.id.txtAsistencia);

        btnVerificar = findViewById(R.id.btnVerificar);
        btnRegistrar = findViewById(R.id.btnRegistrar);


        // ==========================================
        // VERIFICAR EDAD
        // ==========================================

        btnVerificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nombre = txtNombre.getText().toString().trim();
                String edadTexto = txtEdad.getText().toString().trim();

                if (nombre.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Ingrese el nombre del estudiante",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                if (edadTexto.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Ingrese la edad",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                int edad;

                try {

                    edad = Integer.parseInt(edadTexto);

                } catch (NumberFormatException e) {

                    Toast.makeText(
                            MainActivity.this,
                            "Ingrese una edad válida",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }


                // Verificación de edad
                if (edad >= 18) {

                    txtResultado.setText(
                            "Estudiante: " + nombre +
                                    "\nEdad: " + edad + " años" +
                                    "\n✓ Mayor de edad"
                    );

                } else {

                    txtResultado.setText(
                            "Estudiante: " + nombre +
                                    "\nEdad: " + edad + " años" +
                                    "\n⚠ Menor de edad"
                    );
                }
            }
        });


        // ==========================================
        // REGISTRAR ASISTENCIA
        // ==========================================

        btnRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nombre = txtNombre.getText().toString().trim();

                if (nombre.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Primero ingrese el nombre del estudiante",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                txtAsistencia.setText(
                        "✓ ASISTENCIA REGISTRADA\n\n" +
                                "Estudiante: " + nombre + "\n" +
                                "Curso: DESARROLLO DE APLICACIONES\n" +
                                "Estado: PRESENTE"
                );

                Toast.makeText(
                        MainActivity.this,
                        "Asistencia registrada correctamente",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}