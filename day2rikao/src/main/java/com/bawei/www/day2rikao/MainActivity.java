package com.bawei.www.day2rikao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView list_item;
    private MAdapter md;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page=1;
        list_item = findViewById(R.id.list_item);
        md = new MAdapter(this);
        list_item.setAdapter(md);

        initData();
        initPull();
    }

    private void initPull() {
        list_item.setMode(PullToRefreshBase.Mode.BOTH);
        list_item.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                initData();
            }
        });

    }

    private void initData() {

        HttpUtil.getRequest("http://apis.juhe.cn/cook/query?key=9dc74007e90b957d8c63f0a44445b0e4&menu=%E8%A5%BF%E7%BA%A2%E6%9F%BF&rn=10&pn="+page
                , Bean.class, new HttpUtil.CallBack<Bean>() {

                    @Override
                    public void getdata(Bean bean) {
                        List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                        md.setData(data);
                        page++;
                        list_item.onRefreshComplete();
                    }
                }
        );

    }
}
