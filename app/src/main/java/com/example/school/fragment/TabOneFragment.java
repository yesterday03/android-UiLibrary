package com.example.school.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.example.school.BaseFragment;
import com.example.school.Image;
import com.example.school.R;
import com.example.school.RecyclerAdapter;
import com.example.school.User;
import com.example.school.databinding.FragmentTabOneBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.killua.ui.adapter.ViewPager2Adapter;
import com.killua.ui.utils.ItemPaddingDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabOneFragment extends BaseFragment<FragmentTabOneBinding> {

    private ViewModelProvider viewModelProvider;
    private static final int REQUEST_CODE = 10001;
    RecyclerAdapter adapter;
    private ViewPager2Adapter viewPager2Adapter;

    private TabLayoutMediator tabLayoutMediator;

    private List<String> thdKindsByScdKind;

    public static TabOneFragment newInstance() {
        TabOneFragment fragment = new TabOneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding.textView ……
        String url="http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg";
        User user=new User("abc","1230",url);
        viewBinding.setUser(user);

        viewBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent=new Intent(MainActivity.this,MainActivity2.class);

                //Toast.makeText(MainActivity.this,"text",Toast.LENGTH_SHORT).show();
                // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    // 检查该权限是否已经获取
//
//                    for (String permission : permissions) {
//                        //  GRANTED---授权  DINIED---拒绝
//                        if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_DENIED) {
//                            ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
//                        }
//                    }
//                }
                //startActivity(intent);

                ImageSelector.builder()
                        .useCamera(true) // 设置是否使用拍照
                        .setSingle(false)  //设置是否单选
                        .canPreview(false) //是否可以预览图片，默认为true
                        .setMaxSelectCount(5) // 图片的最大选择数量，小于等于0时，不限数量。
                        .start(getActivity(), REQUEST_CODE); // 打开相册

            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
         viewBinding.ry.setLayoutManager(new GridLayoutManager(getActivity(),3));
        viewBinding.ry.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewBinding.ry.setLayoutManager(linearLayoutManager);
        viewBinding.ry.addItemDecoration(new ItemPaddingDecoration(10));
        List<User> list=new ArrayList<>();
        adapter=new RecyclerAdapter(getActivity());
        viewBinding.ry.setAdapter(adapter);

        for (int i=0;i<mUrls.length;i++){
            User user1=new User("","",mUrls[i]);
            list.add(user1);
        }
        adapter.addAllAndClear(list);
        //init();
    }

    public final static String[] mUrls = new String[]{
            "http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/7c1ed21b0ef41bd5f2c2a9e953da81cb39db3d1d.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/55e736d12f2eb938d5277fd5d0628535e5dd6f4a.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/4e4a20a4462309f7e41f5cfe760e0cf3d6cad6ee.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/9d82d158ccbf6c81b94575cfb93eb13533fa40a2.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/4bed2e738bd4b31c1badd5a685d6277f9e2ff81e.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/0d338744ebf81a4c87a3add4d52a6059252da61e.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/f2deb48f8c5494ee5080c8142ff5e0fe99257e19.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/4034970a304e251f503521f5a586c9177e3e53f9.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fbb3586c0168224f4a20a4dd7e.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/e824b899a9014c087eb617650e7b02087af4f464.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/9c16fdfaaf51f3de1e296fa390eef01f3b29795a.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/b58f8c5494eef01f119945cbe2fe9925bc317d2a.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/902397dda144ad340668b847d4a20cf430ad851e.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/359b033b5bb5c9ea5c0e3c23d139b6003bf3b374.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a292d2472199d25bc315d607c7c.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/e824b899a9014c08878b2c4c0e7b02087af4f4a3.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/6d81800a19d8bc3e770bd00d868ba61ea9d345f2.jpg",
    };
}