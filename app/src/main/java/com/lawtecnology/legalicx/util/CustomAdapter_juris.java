package com.lawtecnology.legalicx.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.valdemar.emprendedores.R;

public class CustomAdapter_juris extends BaseAdapter {
    Context context;
    String[] especialidad;
    LayoutInflater inflter;

    public CustomAdapter_juris(Context applicationContext, String[] especialidad) {
        this.context = applicationContext;
        this.especialidad = especialidad;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return especialidad.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_jurisprudencia_custom_layout, null);
        TextView names = (TextView) view.findViewById(R.id.textView);
        names.setText(especialidad[i]);
        return view;
    }
}