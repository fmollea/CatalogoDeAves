package com.fmollea.infoaves.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class adapterImageViewPager extends PagerAdapter {

    Context context;
    String[] url_arr;

    public adapterImageViewPager(Context pContext, String[] pUrl_arr){
        context = pContext;
        url_arr = pUrl_arr;
    }

    @Override
    public int getCount() {
        return url_arr.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(View container, int position){
        ImageView image = new ImageView(context);

        Glide.with(context)
                .load(url_arr[position])
                .into(image);

        ViewPager viewPager = ((ViewPager) container);
        viewPager.addView(image);
        return image;
    }

    @Override
    public void destroyItem (View container, int position, Object view){
        ViewPager viewPager = (ViewPager) container;
        viewPager.removeView((View)view);
    }

    @Override
    public CharSequence getPageTitle (int position){
        return  (position +1) +"/"+ url_arr.length;
    }
}
