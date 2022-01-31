package com.windane.loginpin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText pass;
    Button masuk, daftar;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass = findViewById(R.id.Pin);
        masuk = findViewById(R.id.masukk);
        daftar = findViewById(R.id.daftar);
        DB = new DBHelper(this);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(i);
            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pinn = pass.getText().toString();
                if (pinn.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Masukan PIN", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean cek = DB.cekPassword(pinn);
                    if (cek==true){
                        Toast.makeText(MainActivity.this, "Masuk Berhasil", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "PIN Salah", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}