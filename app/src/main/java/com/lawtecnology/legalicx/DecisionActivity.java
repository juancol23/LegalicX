package com.lawtecnology.legalicx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.firebase.messaging.FirebaseMessaging;
import com.lawtecnology.legalicx.util.Constants;
import com.lawtecnology.legalicx.util.CustomAdapter;

public class DecisionActivity extends AppCompatActivity {
    private LinearLayout btnIrAbogado;
    private LinearLayout btnAsesoria;

    String[] fruits={"Peru","Mexico","Colombia"};
    int images[] = {R.drawable.bandera_peru,
            R.drawable.mexico_ico,
            R.drawable.banderacolombiaicono};

    private SharedPreferences prefs_decision = null;
    private SharedPreferences prefs_tipo_usuario = null;

    private SharedPreferences prefs_pais = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        btnIrAbogado = findViewById(R.id.btnIrAbogado);
        btnAsesoria = findViewById(R.id.btnAsesoria);
        initPreferencias();
        FirebaseMessaging.getInstance().subscribeToTopic("legalic_notifacion");

        btnAsesoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs_decision.edit().putBoolean("prefs_decision", false).commit();
                prefs_tipo_usuario.edit().putString("prefs_tipo_usuario", "general").commit();
               // startActivity(new Intent(DecisionActivity.this, TabsDashboardAsesoriaActivity.class));
            }
        });

        btnIrAbogado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constants.DECISION = true;
                prefs_decision.edit().putBoolean("prefs_decision", true).commit();
                //    prefs_tipo_usuario.edit().putString("prefs_tipo_usuario", "abogado").commit();
               // startActivity(new Intent(DecisionActivity.this,LoginLegalicActivity.class));
            }
        });
        initSpiiner();
    }

    private void initPreferencias() {
        prefs_decision = getSharedPreferences("com.law.technology.legalic", MODE_PRIVATE);
        prefs_tipo_usuario = getSharedPreferences("com.law.technology.legalic", MODE_PRIVATE);
        prefs_pais = getSharedPreferences("com.law.technology.legalic", MODE_PRIVATE);
    }

    private void initSpiiner() {
        final Spinner spin = (Spinner) findViewById(R.id.spinner);

        if(prefs_pais.getString("prefs_pais","Peru").equalsIgnoreCase("Peru")){
            spin.post(new Runnable() {
                @Override
                public void run() {
                    spin.setSelection(0);
                }
            });
        }

        if(prefs_pais.getString("prefs_pais","Mexico").equalsIgnoreCase("Mexico")){
            spin.post(new Runnable() {
                @Override
                public void run() {
                    spin.setSelection(1);
                }
            });
        }

        if(prefs_pais.getString("prefs_pais","Colombia").equalsIgnoreCase("Colombia")){
            spin.post(new Runnable() {
                @Override
                public void run() {
                    spin.setSelection(2);
                }
            });
        }

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(DecisionActivity.this, "You Select Position: "+position+" fruits[position]"+fruits[position], Toast.LENGTH_SHORT).show();
                prefs_pais.edit().putString("prefs_pais", ""+fruits[position]).commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin.setSelection(2,false);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),images,fruits);
        spin.setAdapter(customAdapter);
    }
}