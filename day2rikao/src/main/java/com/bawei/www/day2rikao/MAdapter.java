package com.bawei.www.day2rikao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bean.ResultBean.DataBean> mlist;

    public MAdapter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Bean.ResultBean.DataBean getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh ;
        if(convertView ==null){
            convertView = View.inflate(context, R.layout.item, null);
            vh = new ViewHolder();
            vh.item_img = convertView.findViewById(R.id.item_img);
            vh.ttitle = convertView.findViewById(R.id.ttitle);
            vh.tags = convertView.findViewById(R.id.tags);

            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.ttitle.setText(mlist.get(position).getTitle());
        vh.tags.setText(mlist.get(position).getTags());
        List<String> albums = mlist.get(position).getAlbums();

        String aa = albums.get(0);
        String[] album = new String[]{aa};

        ImageLoader.getInstance().displayImage(album[0],vh.item_img);

        return convertView;
    }

    public void setData(List<Bean.ResultBean.DataBean> data) {
        this.mlist = (ArrayList<Bean.ResultBean.DataBean>) data;
        notifyDataSetChanged();
    }

    class ViewHolder{
        ImageView item_img;
        TextView ttitle,tags;
    }
}
