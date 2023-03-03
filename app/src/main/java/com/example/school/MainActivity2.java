package com.example.school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.example.school.databinding.ActivityMain2Binding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends BaseActivity<ActivityMain2Binding> {
    private List<Image> imageList = new ArrayList<>();
    final int REQUEST_CODE = 10001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        initImages();
        RecyclerImgAdapter adapter=new RecyclerImgAdapter(this);
        viewBinding.ry.setLayoutManager(new GridLayoutManager(this,3));
        viewBinding.ry.setAdapter(adapter);
        adapter.addAllAndClear(imageList);
    }
    //查询图片信息
    private void initImages() {
        /* 因为手机本地图片过多，若将其全部查询出来并显示，需要耗费过多时间，
           这里定义一个count变量用于控制显示出的图片数目 */
        int count = 0;
        imageList = new ArrayList();
        @SuppressLint("Recycle") Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, null,  null, "date_added desc");
        while (cursor.moveToNext()) {

            @SuppressLint("Range") String name2 = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.EXPOSURE_TIME));
            Log.d("ImgActivity: ", "initImages: " + "imageName: " + name2);




            //获取图片的名称
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
            Log.d("ImgActivity: ", "initImages: " + "imageName: " + name);

            //获取图片的路径
            @SuppressLint("Range") byte[] data = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            String location = new String(data, 0, data.length - 1);
            Log.d("ImgActivity: ", "initImages: " + "imageLocation: " + location);
            //根据路径获取图片
            Bitmap bm = getImgFromDesc(location);

            //获取图片的详细信息
            @SuppressLint("Range") String desc = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION));
            Log.d("ImgActivity", "initImages: " + "ImageDesc: " + desc);

            Image image = new Image(bm, name, location);
            imageList.add(image);

            count++;
            //显示出3张图片，可改变该数字，控制显示出的图片数目
            if(count >= 30) break;
        }
        Log.d("ImgActivity: ", "initImage: " + "imageList.size: " + imageList.size());
    }
    //根据路径获取图片
    private Bitmap getImgFromDesc(String path) {
        Bitmap bm = null;
        File file = new File(path);
        // 动态申请权限
        String[] permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};


        // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取

            for (String permission : permissions) {
                //  GRANTED---授权  DINIED---拒绝
                if (ContextCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE);
                }
            }
        }

        boolean permission_readStorage = (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        boolean permission_camera = (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
        Log.d("ImgActivity:", "getImageFromDesc: \n");
        Log.d("ImgActivity: ", "readPermission: " + permission_readStorage + "\n");
        Log.d("ImgActivity： ", "cameraPermission: " + permission_camera + "\n");

        if(file.exists()) {
            bm = BitmapFactory.decodeFile(path);
        } else {
            //ToastUtil.showLong("该图片不存在！");
            Log.d("ImgActivity ", "getImgFromDesc: 该图片不存在！");
        }
        return bm;
    }
    public  void onRequestPermissionsResult(int requestCode , String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) { //请求授权信息
            case REQUEST_CODE:{//&&grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //收到授权
                    Toast.makeText(MainActivity2.this, "成功授权", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "你拒绝授权，无法使用图库", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            default:
        }
    }

}