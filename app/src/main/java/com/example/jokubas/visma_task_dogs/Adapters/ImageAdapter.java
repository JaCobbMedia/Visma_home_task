package com.example.jokubas.visma_task_dogs.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<String> photoUrls;

    public ImageAdapter(Context c, ArrayList<String> urlList){
        context = c;
        photoUrls = urlList;
    }

    @Override
    public int getCount() {
        return photoUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(350,350));
            imageView.setPadding(5,5,5,5);
        }else{
            imageView = (ImageView) convertView;
        }

        Picasso.with(context).load(photoUrls.get(position)).into(imageView);

        return imageView;
    }
}
