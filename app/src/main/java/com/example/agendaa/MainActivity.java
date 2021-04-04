package com.example.agendaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private EditText nombre, cita, tiempo;
    private Button guardar;
    private TextView citaguardar, hora;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TimePicker timePicker = findViewById(R.id.timepicker);
        //Se creara el listener para que detecte cuando se cambia la hora
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int i, int i1) {


                int hour = i;

                int minute = i1;


                Toast.makeText( MainActivity.this, +i +":" +i1, Toast.LENGTH_SHORT).show();
                hora.setText(+i +":" +i1);

            }
        });

        nombre = findViewById(R.id.nombre);
        hora = findViewById(R.id.hora);
        cita = findViewById(R.id.cita);
        tiempo = findViewById(R.id.tiempo);
        citaguardar = findViewById(R.id.citaguardar);
        //Boton Guardar
        guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*le damos funcion de trasladarse a la interfaz informacion
                y se inserta el metodo putExtra como transportador de la informacion
                de la cita guardada
                 */
                Intent  traslado = new Intent(MainActivity.this, Informacion.class);
                traslado.putExtra("Nombre:", nombre.getText().toString());
                traslado.putExtra("Hora de cita:", hora.getText().toString());
                traslado.putExtra("Motivo:", cita.getText().toString());
                traslado.putExtra("Tiempo de duracion:", tiempo.getText().toString());

                startActivity(traslado);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);

                //Accion de guardar los datos del boton
                String guardarnombre = nombre.getText().toString();
                String guardarcita = cita.getText().toString();
                String guardartiempo = tiempo.getText().toString();



                Toast.makeText(getApplicationContext(), "cita guardada:" +guardarnombre, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"motivo:" +guardarcita, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Tiempo:" +guardartiempo, Toast.LENGTH_SHORT).show();

                citaguardar.setText(nombre.getText().toString() + "/////"+ hora.getText().toString() + "/////" +
                        cita.getText().toString()+ "/////" + tiempo.getText().toString());



            }
        });

    }



}
