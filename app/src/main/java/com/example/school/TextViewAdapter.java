package com.example.school;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * 自定义BindingAdapters
 * Powered by jzman.
 * Created on 2018/12/6 0006.
 */
public class TextViewAdapter {

    @BindingAdapter("android:text")
    public static void setText(TextView view, CharSequence text) {
        //省略特殊处理...
        String txt = text.toString().toLowerCase();
        view.setText(txt);
    }

    @BindingAdapter({"imgload"})
    public static void imgload(ImageView imageView, String url) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
    @BindingAdapter({"imgload"})
    public static void imgload(ImageView imageView, Bitmap bitmap) {
        Drawable drawable=new BitmapDrawable(bitmap);
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(imageView)
                .load(drawable)
                .apply(requestOptions)
                .into(imageView);
    }
}

