package com.bawei;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Banner img_banner;
    private TextView ttitle, oldprice, newprice;
    private ArrayList<String> request;
    private int page;
    private final int UPDATE_UI = 1;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_UI:
                    Bean.DataBean dataBean = (Bean.DataBean) msg.obj;
                    ttitle.setText(dataBean.getTitle());
                    oldprice.setText("原价"+dataBean.getPrice());
                    oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    newprice.setText("现价"+dataBean.getBargainPrice());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_banner = findViewById(R.id.img_banner);
        ttitle = findViewById(R.id.ttitle);
        oldprice = findViewById(R.id.oldprice);
        newprice = findViewById(R.id.newprice);


        img_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        page=1;
        initData();

        img_banner.setImageLoader(new ImageLoaderInterface<ImageView>() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                Bean.DataBean dataBean = (Bean.DataBean) path;
                for (int i = 0; i < request.size(); i++) {

                    com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(request.get(i), imageView);
                    page++;
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

        HttpUtil.getRequest("http://www.zhaoapi.cn/product/getProductDetail?pid=" + page, Bean.class, new HttpUtil.CallBack<Bean>() {
            @Override
            public void getdata(Bean bean) {

                request = new ArrayList<>();

                String images = bean.getData().getImages();

                Pattern pen = Pattern.compile("\\|");

                String[] img = pen.split(images);

                for (int i = 0; i < img.length; i++) {
                    request.add(img[i]);
                }
                img_banner.setImages(request);

                img_banner.start();
                handler.sendMessage(handler.obtainMessage(UPDATE_UI, bean.getData()));
            }
        });
    }
}
