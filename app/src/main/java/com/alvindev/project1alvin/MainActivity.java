package com.alvindev.project1alvin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editNama, editJumlah, editHarga;
    TextView txtOutput;
    Button btnProses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNama = (EditText)findViewById(R.id.editNamaBarang);
        editHarga = (EditText)findViewById(R.id.editHargaBarang);
        editJumlah = (EditText)findViewById(R.id.editJumlahBeli);
        txtOutput = (TextView)findViewById(R.id.txtOutput);
        btnProses = (Button)findViewById(R.id.btnSubmit);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editNama.getText().toString();
                Double harga = Double.parseDouble(editHarga.getText().toString());
                Integer jumlah = Integer.parseInt(editJumlah.getText().toString());

                Double total = harga*jumlah;
                Double diskon = 0.0;
                if(jumlah > 5){
                    diskon = 0.1*total;
                }
                Double bayar = total - diskon;
                txtOutput.setText("=== Detail Pesanan ===" +
                        "\nNama Barang     : " + nama +
                        "\nHarga Beli      : " + harga +
                        "\nJumlah Barang   : " + jumlah +
                        "\nTotal Harga     : " + total +
                        "\nDiskon          : " + diskon +
                        "\nTotal Bayar     : " + bayar);

            }
        });

    }
}