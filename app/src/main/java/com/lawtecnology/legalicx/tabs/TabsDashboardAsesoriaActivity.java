package com.lawtecnology.legalicx.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.lawtecnology.legalicx.R;
import com.lawtecnology.legalicx.util.ImageSliderAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabsDashboardAsesoriaActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ImageSliderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_dashboard_asesoria);

        viewPager = findViewById(R.id.view_pager);

        // Crear una lista de imágenes (pueden ser recursos drawables, URL, etc.)
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.fondoplashnuevo);
        imageList.add(R.drawable.logolegalic);
        imageList.add(R.drawable.fondoplashnuevo);
        imageList.add(R.drawable.logolegalic);


        adapter = new ImageSliderAdapter(this, imageList);
        //viewPager.setAdapter(adapter);

    }
}