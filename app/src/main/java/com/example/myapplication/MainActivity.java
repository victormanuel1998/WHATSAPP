package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnviarMensaje(View view) {
        Intent enviar = new Intent(this, Message.class);
        final EditText etSaludo = findViewById(R.id.etSaludo);
        String mensaje = etSaludo.getText().toString();
        enviar.putExtra(EXTRA_MESSAGE, mensaje);
        startActivity(enviar);
    }

    public void Llamar(View view) {
        Intent llamar = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2311044173"));
        startActivity(llamar);
    }

    // Buscar cómo lanzar WhatsApp desde Intent
    public void IniciarWhatsApp(View view) {
        Intent iniciarWhatsApp = new Intent("com.whatsapp");
        iniciarWhatsApp.setAction(Intent.ACTION_SEND);
        final EditText etSaludo = findViewById(R.id.etSaludo);
        iniciarWhatsApp.putExtra(Intent.EXTRA_TEXT, etSaludo.getText().toString());
        iniciarWhatsApp.setType("text/plain");
        startActivity(iniciarWhatsApp);
    }
    public void enviarmsjwhatsapp(View view){
        final EditText etSaludo = findViewById(R.id.etSaludo);
       String hi = etSaludo.getText().toString();
        etSaludo.setText(hi+": te respondí");
    }
    public void limpiarForm(View view) {
        final EditText etSaludo = findViewById(R.id.etSaludo);
        etSaludo.setText("");

    }
    public void salir(View view) {
        System.exit(0);
    }
}