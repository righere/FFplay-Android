package com.righere.convexdplayer.Video;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.righere.convexdplayer.Adapter.VideoListAdapter;
import com.righere.convexdplayer.R;
import com.righere.convexdplayer.sdl.SDLActivity;

import java.util.List;

/**
 * Created by righere on 16-11-18.
 * video_list界面
 */

public class VideoListActivity extends AppCompatActivity {
    private static final String TAG = "VideoListActivity";
    ListView mVideoList;
    VideoListAdapter mVideoListAdapter;
    List<VideoItem> videoItems;
    int VideoSize;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        AbstractProvider provider = new VideoProvider(this);
        videoItems = provider.getList();
        VideoSize = videoItems.size();
        mVideoListAdapter = new VideoListAdapter(VideoListActivity.this,videoItems);
        mVideoList = (ListView) findViewById(R.id.video_list);
        Log.i(TAG, "onCreate: "+ VideoSize);
        mVideoList.setAdapter(mVideoListAdapter);
        mVideoList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                VideoItem mVideoItem = videoItems.get(position);

                //传递视频的Uri
                Intent intent = new Intent();
                intent.setClass(VideoListActivity.this,SDLActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("video",mVideoItem);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Refresh_thumbnailListView();
    }

    /*刷新视频缩略图列表*/
    private void Refresh_thumbnailListView() {
        final Object data = getLastCustomNonConfigurationInstance();
        if(data == null){
            new LoadImagesFormSDCard().execute();
        }else {
            final LoadImage[] thumbnails = (LoadImage[]) data;
            if (thumbnails.length == 0){
                new LoadImagesFormSDCard().execute();
            }
            for (LoadImage thumbnail:thumbnails){
                addImage(thumbnail);
            }
        }

    }

    private class LoadImagesFormSDCard extends AsyncTask<Object,LoadImage,Object> {

        @Override
        protected Object doInBackground(Object... params) {
            Bitmap bitmap;
            for (int i = 0; i < VideoSize; i++) {
                bitmap = getVideoThumbnail(videoItems.get(i).getPath(),150,150, MediaStore.Video.Thumbnails.MINI_KIND);
                if(bitmap != null){
                    publishProgress(new LoadImage(bitmap));
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(LoadImage... values) {
            addImage(values);
        }
    }

    /**
     * 获取视频缩略图
     */

    private Bitmap getVideoThumbnail(String VideoPath,int width,int height,int kind){
        Bitmap bitmap;
        bitmap = ThumbnailUtils.createVideoThumbnail(VideoPath,kind);
        bitmap = ThumbnailUtils.extractThumbnail(bitmap,width,height,ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        return bitmap;
    }

    private void addImage(LoadImage... value) {
        for(LoadImage image : value){
            mVideoListAdapter.addthumbnail(image);
            mVideoListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        final ListView grid = mVideoList;
        final int count = grid.getChildCount();
        final LoadImage[] list = new LoadImage[count];

        for (int i = 0; i < count; i++) {
            final ImageView v = (ImageView) grid.getChildAt(i);
            list[i] = new LoadImage(
                    ((BitmapDrawable) v.getDrawable()).getBitmap());
        }
        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

