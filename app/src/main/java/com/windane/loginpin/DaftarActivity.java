package com.windane.loginpin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity {

    EditText DaftarPin;
    Button Masuk, menumasuk;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        DaftarPin = findViewById(R.id.Pindaftar);
        Masuk = findViewById(R.id.daftarMasuk);
        menumasuk = findViewById(R.id.menuMasuk);
        DB = new DBHelper(this);

        menumasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DaftarActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = DaftarPin.getText().toString();

                if (pass.trim().equals("")){
                    Toast.makeText(DaftarActivity.this, "Masukan PIN", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(pass)){
                        Boolean cekpassword = DB.cekPassword(pass);
                        if (cekpassword== false){
                            Boolean insert = DB.insertData(pass);
                            if (insert== true){
                                Toast.makeText(DaftarActivity.this, "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(DaftarActivity.this, HomeActivity.class);
                                startActivity(i);
                            }
                        }
                    }
                }
            }
        });


    }
}