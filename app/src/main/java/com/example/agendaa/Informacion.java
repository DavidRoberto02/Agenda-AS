package com.example.agendaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.InflaterOutputStream;

public class Informacion extends AppCompatActivity {
    private Button Back;
    TextView info, info2, info3, info4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);


        //Boton Regresar y texto de informacion
        info = findViewById(R.id.info);
        info2 = findViewById(R.id.info2);
        info3 = findViewById(R.id.info3);
        info4 = findViewById(R.id.info4);
        final Intent intent = getIntent();
        info.setText(intent.getStringExtra("Nombre:"));
        info2.setText(intent.getStringExtra("Hora de cita:"));
        info3.setText(intent.getStringExtra("Motivo:"));
        info4.setText(intent.getStringExtra("Tiempo de duracion:"));
        Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            //Metodo de la transicion y traslado de la cita
            public void onClick(View v) {
                Intent traslado1 = new Intent(Informacion.this, MainActivity.class);
                startActivity(traslado1);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });

    }


}