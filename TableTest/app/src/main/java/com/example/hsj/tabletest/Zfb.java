package com.example.hsj.tabletest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Zfb extends AppCompatActivity {
    private GridView gridview;
    GridViewSim myGridView;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zfb);

        gridview=(GridView)findViewById(R.id.gridview_zfb);

        myGridView=new GridViewSim(this,text,mThumbIds);
        gridview.setAdapter(myGridView);

        //单击GridView元素的响应
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //弹出单击的GridView元素的位置
                Toast.makeText(Zfb.this,mThumbIds[position], Toast.LENGTH_SHORT).show();
            }
        });

        inflater= LayoutInflater.from(this);
    }

    class GridViewSim extends BaseAdapter{
        private Context context=null;
        private String data[]=null;
        private int imgId[]=null;


        private class Holder{

            ImageView item_img;
            TextView item_tex;

            public ImageView getItem_img() {
                return item_img;
            }

            public void setItem_img(ImageView item_img) {
                this.item_img = item_img;
            }

            public TextView getItem_tex() {
                return item_tex;
            }

            public void setItem_tex(TextView item_tex) {
                this.item_tex = item_tex;
            }




        }
        //构造方法
        public GridViewSim(Context context, String[] data, int[] imgId) {
            this.context = context;
            this.data = data;
            this.imgId = imgId;
        }


        @Override
        public int getCount() {


            return data.length;

        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            Holder holder;
            if(view==null){
                view=inflater.inflate(R.layout.activity_zfb_item,null);
                holder=new Holder();
                holder.item_img=(ImageView)view.findViewById(R.id.iv_item);
                holder.item_tex=(TextView)view.findViewById(R.id.tv_item);
                view.setTag(holder);
            }else{
                holder=(Holder) view.getTag();
            }
            holder.item_tex.setText(data[position]);
            holder.item_img.setImageResource(imgId[position]);

            return view;
        }
    }
    //展示图片
    private int[] mThumbIds = {
            R.drawable.apple_pic, R.drawable.banana_pic,
            R.drawable.cherry_pic, R.drawable.grape_pic,
            R.drawable.watermelon_pic, R.drawable.mango_pic,
            R.drawable.grape_pic, R.drawable.pear_pic,
            R.drawable.strawberry_pic
    };
    //文字
    private String text[]={"text1","text2","text3","text4","text5","text6","text7","text8","text9"};
}
