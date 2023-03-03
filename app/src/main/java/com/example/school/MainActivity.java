package com.example.school;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.ClickUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.donkingliang.imageselector.entry.Image;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.example.school.databinding.ActivityMainBinding;
import com.example.school.fragment.TabFourFragment;
import com.example.school.fragment.TabOneFragment;
import com.example.school.fragment.TabTwoFragment;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;
import com.killua.ui.adapter.BaseRecyclerAdapter;
import com.killua.ui.adapter.ViewPagerAdapter;
import com.killua.ui.utils.ItemPaddingDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements BaseRecyclerAdapter.OnItemClickListener<User>, ViewPager.OnPageChangeListener {

    @Titles
    private String[] mTitles ={"首页", "学习", "我的"};

    @SeleIcons
    private int[] mSeleIcons = {R.mipmap.aa_icon_home_selected, R.mipmap.aa_icon_learning_selected,R.mipmap.aa_icon_my_selected};

    @NorIcons
    private int[] mNormalIcons = {R.mipmap.aa_icon_home_default, R.mipmap.aa_icon_learning_default,R.mipmap.aa_icon_my_default};

    private Fragment[] fragments = {TabOneFragment.newInstance(), TabTwoFragment.newInstance(), TabFourFragment.newInstance()};
    private ViewPagerAdapter viewPagerAdapter;


    public void initView() {
        viewBinding.jpTabBar.setContainer(viewBinding.viewPage);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewBinding.viewPage.setAdapter(viewPagerAdapter);
        viewBinding.viewPage.setOffscreenPageLimit(4);
        viewBinding.viewPage.addOnPageChangeListener(this);
    }


    RecyclerAdapter adapter;
    List<User> contactsList=new ArrayList<>();
    // 准备申请的权限
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    private static final int REQUEST_CODE = 10001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //setContentView(R.layout.activity_main);
        //String url="http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg";
        //User user=new User("abc","1230",url);
        //viewBinding.setUser(user);
        //String text = viewBinding.textView.getText().toString();
        //c
//        viewBinding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
//
//                //Toast.makeText(MainActivity.this,"text",Toast.LENGTH_SHORT).show();
//                // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////                    // 检查该权限是否已经获取
////
////                    for (String permission : permissions) {
////                        //  GRANTED---授权  DINIED---拒绝
////                        if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_DENIED) {
////                            ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
////                        }
////                    }
////                }
//                //startActivity(intent);
//
//                ImageSelector.builder()
//                        .useCamera(true) // 设置是否使用拍照
//                        .setSingle(false)  //设置是否单选
//                        .canPreview(false) //是否可以预览图片，默认为true
//                        .setMaxSelectCount(5) // 图片的最大选择数量，小于等于0时，不限数量。
//                        .start(MainActivity.this, REQUEST_CODE); // 打开相册
//
//            }
//        });

        //Glide.with(this).load(url).into(viewBinding.imgUrl);
        //List<User> list=new ArrayList<>();
        // adapter=new RecyclerAdapter(this);
//        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<User>() {
//            @Override
//            public void onItemClick(View view, int postion, User user) {
//                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
//            }
//        });
       //adapter.setOnItemClickListener(this);
//        for (int i=0;i<mUrls.length;i++){
//            User user1=new User("","",mUrls[i]);
//            list.add(user1);
//        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
       // viewBinding.ry.setLayoutManager(new GridLayoutManager(this,3));
       //viewBinding.ry.setLayoutManager(new LinearLayoutManager(this));
       //viewBinding.ry.setLayoutManager(linearLayoutManager);
         //viewBinding.ry.addItemDecoration(new ItemPaddingDecoration(10));

        //viewBinding.ry.setAdapter(adapter);
        //adapter.addAllAndClear(list);
//        init();
//        ArrayList<Image> images = loadImage(this);
//        Toast.makeText(this,""+images.size(),Toast.LENGTH_SHORT).show();

    }

//public void init(){
//    // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//        // 检查该权限是否已经获取
//
//        for (String permission : permissions) {
//            //  GRANTED---授权  DINIED---拒绝
//            if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_DENIED) {
//                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
//            }
//        }
//    }
//    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
//        //调用系统通讯录
//        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_CONTACTS},1);
//        //系统系统通讯录授权第一次进行授权 ，询问是否授权
//    } else{
//        readCotacts();
//        //授权成功过后，每次打开自动读取通讯录
//    }
//}
    public  void onRequestPermissionsResult(int requestCode , String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) { //请求授权信息
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //收到授权
//                    readCotacts();
//                    Toast.makeText(MainActivity.this, "成功授权", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "你拒绝授权，无法使用通讯录", Toast.LENGTH_SHORT).show();
                    //finish();
                }
                break;
            case REQUEST_CODE:{//&&grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //收到授权
                    Toast.makeText(MainActivity.this, "成功授权", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "你拒绝授权，无法使用图库", Toast.LENGTH_SHORT).show();
                    //finish();
                }
            }
            default:
        }
    }

//    private  void  readCotacts(){
//        Cursor cursor = null;   //先置为空值
//        try {
//            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
//            if (cursor != null){  //当游标不为空
//                while (cursor.moveToNext()){
//                    @SuppressLint("Range") String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                    //读取电话簿名字
//                    @SuppressLint("Range") String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                    //读取电话簿电话
//                    User user=new User(displayName,number,null);
//                    contactsList.add(user);
//                    //输出名字和电话列表
//                }
////                adapter.notifyDataSetChanged();
//                viewBinding.ry2.setLayoutManager(new LinearLayoutManager(this));
//                Recycler2Adapter adapter1=new Recycler2Adapter(this);
//                viewBinding.ry2.setAdapter(adapter1);
//                adapter1.addAllAndClear(contactsList);
//                Log.e("TAG", "readCotacts: "+contactsList.get(1).getName() );
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if (cursor != null){   //当游标不为空
//                cursor.close();  //结束
//            }
//        }
//    }


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



    @Override
    public void onItemClick(View view, int postion, User user) {
        ClickUtils.applyPressedBgAlpha(view);
//        showToast("你点击了"+postion);
        Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
    }
    private static synchronized ArrayList<com.donkingliang.imageselector.entry.Image> loadImage(Context context) {

        //扫描图片
        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = context.getContentResolver();

        Cursor mCursor = mContentResolver.query(mImageUri, new String[]{
                        MediaStore.Images.Media.DATA,
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.DATE_ADDED,
                        MediaStore.Images.Media._ID,
                        MediaStore.Images.Media.MIME_TYPE,
                        MediaStore.Images.Media.SIZE},
                MediaStore.MediaColumns.SIZE + ">0",
                null,
                MediaStore.Images.Media.DATE_ADDED + " DESC");

        ArrayList<com.donkingliang.imageselector.entry.Image> images = new ArrayList<>();

        //读取扫描到的图片
        if (mCursor != null) {
            while (mCursor.moveToNext()) {
                // 获取图片的路径
                @SuppressLint("Range") long id = mCursor.getLong(mCursor.getColumnIndex(MediaStore.Images.Media._ID));
                @SuppressLint("Range") String path = mCursor.getString(
                        mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
                //获取图片名称
                @SuppressLint("Range") String name = mCursor.getString(
                        mCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                //获取图片时间
                @SuppressLint("Range") long time = mCursor.getLong(
                        mCursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED));

                if (String.valueOf(time).length() < 13) {
                    time *= 1000;
                }

                //获取图片类型
                @SuppressLint("Range") String mimeType = mCursor.getString(
                        mCursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE));

                //获取图片uri
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon()
                        .appendPath(String.valueOf(id)).build();

                images.add(new Image(path, time, name, mimeType, uri));
            }
            mCursor.close();
        }
        return images;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}