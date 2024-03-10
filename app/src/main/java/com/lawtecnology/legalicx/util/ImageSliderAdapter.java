package com.lawtecnology.legalicx.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.lawtecnology.legalicx.R;

import java.util.List;
public class ImageSliderAdapter extends PagerAdapter {

    private List<Integer> imageList;
    private LayoutInflater inflater;
    private Context context;

    public ImageSliderAdapter(Context context, List<Integer> imageList) {
        this.context = context;
        this.imageList = imageList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.slider_item, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(imageList.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}