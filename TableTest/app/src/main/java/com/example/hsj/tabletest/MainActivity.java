package com.example.hsj.tabletest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 *
 * @author 飞雪无情
 * @since 2011-1-20
 */
public class MainActivity extends AppCompatActivity {

        /** Called when the activity is first created. */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            findViewById(R.id.zfb).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,Zfb.class));
                }
            });

            GridView gridView=(GridView)findViewById(R.id.gridview);
            gridView.setAdapter(new ImageAdapter(this));
            //单击GridView元素的响应
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    //弹出单击的GridView元素的位置
                    Toast.makeText(MainActivity.this,mThumbIds[position], Toast.LENGTH_SHORT).show();
                }
            });
        }
        private class ImageAdapter extends BaseAdapter {
            private Context mContext;

            public ImageAdapter(Context context) {
                this.mContext=context;
            }

            @Override
            public int getCount() {
                return mThumbIds.length;
            }

            @Override
            public Object getItem(int position) {
                return mThumbIds[position];
            }

            @Override
            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //定义一个ImageView,显示在GridView里
                ImageView imageView;
                if(convertView==null){
                    imageView=new ImageView(mContext);
                    imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setPadding(0, 0, 0, 0);
                }else{
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(mThumbIds[position]);
                return imageView;
            }



        }
        //展示图片
        private Integer[] mThumbIds = {
                R.drawable.apple_pic, R.drawable.banana_pic,
                R.drawable.cherry_pic, R.drawable.grape_pic,
                R.drawable.watermelon_pic, R.drawable.mango_pic,
                R.drawable.grape_pic, R.drawable.pear_pic,
                R.drawable.strawberry_pic, R.drawable.pineapple_pic,
                R.drawable.apple_pic, R.drawable.banana_pic,
                R.drawable.cherry_pic, R.drawable.grape_pic,
                R.drawable.watermelon_pic, R.drawable.mango_pic,
                R.drawable.grape_pic, R.drawable.pear_pic,
                R.drawable.strawberry_pic, R.drawable.pineapple_pic
        };
    }
