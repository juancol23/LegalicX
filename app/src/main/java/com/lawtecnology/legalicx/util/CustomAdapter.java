package com.lawtecnology.legalicx.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lawtecnology.legalicx.R;


public class CustomAdapter extends BaseAdapter {
    Context context;
    int images[];
    String[] fruit;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] flags, String[] fruit) {
        this.context = applicationContext;
        this.images = flags;
        this.fruit = fruit;
        inflter = (LayoutInflater.from(applicationContext));
    }

    public CustomAdapter(Context applicationContext, int[] flags) {
        this.context = applicationContext;
        this.images = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return images.length;
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
        ImageView icon;
        TextView names;
        if(fruit != null){
            view = inflter.inflate(R.layout.spinner_custom_layout, null);
            names = (TextView) view.findViewById(R.id.textView);
            names.setText(fruit[i]);

        }else{
            view = inflter.inflate(R.layout.spinner_custom_layout_blan, null);
        }
         icon = (ImageView) view.findViewById(R.id.imageView);


        icon.setImageResource(images[i]);


        return view;
    }
}