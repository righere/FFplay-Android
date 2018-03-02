package com.righere.convexdplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.righere.convexdplayer.R;
import com.righere.convexdplayer.Video.LoadImage;
import com.righere.convexdplayer.Video.VideoItem;
import com.righere.convexdplayer.Video.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by righere on 16-11-18.
 */

public class VideoListAdapter extends BaseAdapter {
    private List<VideoItem> videoItems;
    private LayoutInflater mLayoutInflater;
    private ArrayList<LoadImage> thumbnail = new ArrayList<LoadImage>();

    public VideoListAdapter(Context context, List<VideoItem> videoItems){
        mLayoutInflater = LayoutInflater.from(context);
        this.videoItems = videoItems;
    }

    @Override
    public int getCount() {
        return thumbnail.size();
    }

    public void addthumbnail(LoadImage loadimage){
        thumbnail.add(loadimage);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.videolistitem,null);
            holder.img = (ImageView) convertView.findViewById(R.id.video_thumbnail);
            holder.videoname = (TextView) convertView.findViewById(R.id.video_name);
            holder.time = (TextView) convertView.findViewById(R.id.video_duration);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.videoname.setText(videoItems.get(position).getDisplayname());
        long min = videoItems.get(position).getmVideoDuration()/1000/60;
        long sec = videoItems.get(position).getmVideoDuration()/1000%60;
        holder.time.setText(min + " : " + sec);
        holder.img.setImageBitmap(thumbnail.get(position).getBitmap());
        return convertView;
    }
}
