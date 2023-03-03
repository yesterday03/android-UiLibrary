package com.example.school;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;

public class DatabindingAdapter {

    public static class ImgLoadBindingAdapter {

        @BindingAdapter({"imgload"})
        public static void imgload(AppCompatImageView imageView, String url) {
            RequestOptions requestOptions = new RequestOptions();
            Glide.with(imageView)
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);
        }

        @BindingAdapter({"imgload","rounds"})
        public static void imgload(AppCompatImageView imageView, String url,int round) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.optionalTransform(new GlideRoundedCornersTransform(round, round, round, round));
            Glide.with(imageView)
                    .load(url)
                    .apply(requestOptions)
                    .into(imageView);
        }

//        @BindingAdapter({"jsonArryImgload","rounds"})
//        public static void diaryImgload(AppCompatImageView imageView, String content,int round) {
//            try {
//                RequestOptions requestOptions = new RequestOptions();
//                requestOptions.optionalTransform(new GlideRoundedCornersTransform(round, round, round, round));
//                JSONArray jsonArray = new JSONArray(content);
//                for (int i = 0 ; i < jsonArray.length();i++){
//                    if(jsonArray.getJSONObject(i).getInt("type") == 1){
//                        String imgUrl = jsonArray.getJSONObject(i).getString("ct");
//                        Glide.with(imageView)
//                                .load(imgUrl)
//                                .placeholder(R.mipmap.img_list_default)
//                                .error(R.mipmap.img_list_default)
//                                .apply(requestOptions)
//                                .into(imageView);
//                        return;
//                    }
//                }
//                Glide.with(imageView)
//                        .load(R.mipmap.img_list_default)
//                        .placeholder(R.mipmap.img_list_default)
//                        .error(R.mipmap.img_list_default)
//                        .apply(requestOptions)
//                        .into(imageView);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static class DrawableBindingAdapter {

        @BindingAdapter({"drawableL_w", "drawableL_h"})
        public static void drawableLeft(TextView appCompatTextView, int drawableL_w, int drawableL_h) {
            drawableL_w = ConvertUtils.dp2px(drawableL_w);
            drawableL_h = ConvertUtils.dp2px(drawableL_h);
            Drawable[] compoundDrawables = appCompatTextView.getCompoundDrawables();
            compoundDrawables[0].setBounds(0, 0, drawableL_w, drawableL_h);
            appCompatTextView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }

        @BindingAdapter({"drawableR_w", "drawableR_h"})
        public static void drawableRight(TextView appCompatTextView, int drawableR_w, int drawableR_h) {
            drawableR_w = ConvertUtils.dp2px(drawableR_w);
            drawableR_h = ConvertUtils.dp2px(drawableR_h);
            Drawable[] compoundDrawables = appCompatTextView.getCompoundDrawables();
            compoundDrawables[2].setBounds(0, 0, drawableR_w, drawableR_h);
            appCompatTextView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }

        @BindingAdapter({"drawableT_w", "drawableT_h"})
        public static void drawableTop(TextView appCompatTextView, int drawableT_w, int drawableT_h) {
            drawableT_w = ConvertUtils.dp2px(drawableT_w);
            drawableT_h = ConvertUtils.dp2px(drawableT_h);
            Drawable[] compoundDrawables = appCompatTextView.getCompoundDrawables();
            compoundDrawables[1].setBounds(0, 0, drawableT_w, drawableT_h);
            appCompatTextView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }

        @BindingAdapter({"drawableTop","drawableT_w", "drawableT_h"})
        public static void drawableTop(TextView appCompatTextView,int drawableTop, int drawableT_w, int drawableT_h) {
            Drawable drawable = ResourceUtils.getDrawable(drawableTop);
            drawableT_w = ConvertUtils.dp2px(drawableT_w);
            drawableT_h = ConvertUtils.dp2px(drawableT_h);
            drawable.setBounds(new Rect(0,0,drawableT_w,drawableT_h));
            Drawable[] compoundDrawables = appCompatTextView.getCompoundDrawables();
            appCompatTextView.setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public static class TextBindingAdapter{


        @BindingAdapter({"drawable_start","drawable_w","drawable_h", "text"})
        public static void textStartDrawable(AppCompatTextView appCompatTextView,int drawableRes,int drawable_w,int drawable_h,String text){
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

            SpannableString spannableString = new SpannableString(text);
            spannableStringBuilder.append("   "+spannableString);

            Drawable drawable = ResourceUtils.getDrawable(drawableRes);
            int dp2px_w = ConvertUtils.dp2px(drawable_w);
            int dp2px_h = ConvertUtils.dp2px(drawable_h);
            drawable.setBounds(new Rect(0,0,dp2px_w,dp2px_h));
            ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
            spannableStringBuilder.setSpan(imageSpan,0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            appCompatTextView.setText(spannableStringBuilder);
        }
    }
}
