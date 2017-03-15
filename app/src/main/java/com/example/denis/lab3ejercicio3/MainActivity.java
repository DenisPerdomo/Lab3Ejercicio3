package com.example.denis.lab3ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etname;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazamos los objetos.
        etname = (EditText) findViewById(R.id.etname);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    //Método para el boton Verificar
    public void verify(View v){
        Intent i = new Intent(this,VerifyCondition.class);
        i.putExtra("name", etname.getText().toString());
        startActivityForResult(i,1);
    }

    //Método para recuperar el resultado de la segunda activity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        String result = data.getExtras().getString("resultado");
        if (resultCode == RESULT_OK){
            txtResult.setText("Respuesta: " + result);
        }
    }

    //Hacer el menu visible
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Seleccionar los items del menu.
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.miAcerca) {
            Intent AcercaDe = new Intent(this,AcercaDe.class);
            startActivity(AcercaDe);
            return true;
        }
        if (id == R.id.iPref) {
            Intent Preferencias = new Intent(this,Preferencias.class);
            startActivity(Preferencias);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
