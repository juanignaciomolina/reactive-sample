package com.droidko.reactivesample.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.droidko.reactivesample.utils.Colorify;

import java.util.ArrayList;

public class HomeImageAdapter extends PagerAdapter {

    // Vars
    private Context mContext;
    private ArrayList<String> mDataset = new ArrayList<>();

    public HomeImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        container.addView(imageView);

        loadImage(imageView, mDataset.get(position));

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void addPicture(String imageUrl) {
        mDataset.add(imageUrl);
        notifyDataSetChanged();
    }

    private void loadImage(ImageView imageView, String imageUrl) {

        // Set a cyclic colors background
        Glide
                .with(mContext)
                .load(imageUrl)
                .placeholder(Colorify.getRandomColor()) //FIXME COLOR NOT DISPLAYING. VIEW TOO SMALL?
                .crossFade()
                .centerCrop()
                .into(imageView);
    }
}
