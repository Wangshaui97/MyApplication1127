package com.bawei.www.myapplication1127;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {

    private Banner img_banner;
    private TextView tTitle;
    private ArrayList<String> request;
    private final int UPDATE_UI=1;
    private int page;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_UI:
                    String ttilte = (String) msg.obj;
                    tTitle.setText(ttilte);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page=1;
        img_banner = findViewById(R.id.img_banner);
        tTitle = findViewById(R.id.ttitle);

        img_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);


        initData();

        img_banner.setImageLoader(new ImageLoaderInterface<ImageView>() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                Bean.DataBean dataBean= (Bean.DataBean) path;
                for(int i = 0;i<request.size();i++){
                    com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(request.get(i),imageView);
                }
            }

            @Override
            public ImageView createImageView(Context context) {

                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });



    }

    private void initData() {

        HttpUtil.getRequest("http://www.zhaoapi.cn/product/getProductDetail?pid="+page, Bean.class, new HttpUtil.CallBack<Bean>() {
            @Override
            public void getdata(Bean bean) {

                request = new ArrayList<>();

                String images = bean.getData().getImages();

                Pattern pen = Pattern.compile("\\|");



                String[] img= pen.split(images);

                for(int i =0 ;i<img.length;i++){
                    request.add(img[i]);
                }
                img_banner.setImages(request);
                //img_banner.setBannerTitles(getTitles(bean));
                img_banner.start();
                handler.sendMessage(handler.obtainMessage(UPDATE_UI,bean.getData().getTitle()));
            }
        });

    }

//    private List<String> getTitles(Bean bean) {
//        List<String> strings = new ArrayList<>();
//        strings.add(bean.getData().getTitle());
//        return strings;
//    }
}
