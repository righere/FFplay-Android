package com.righere.convexdplayer.Video;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by righere on 16-11-18.
 */

public class VideoProvider implements AbstractProvider{

    private Context context;

    public VideoProvider(Context context) {
        this.context = context;
    }

    @Override
    public List<VideoItem> getList() {
        List<VideoItem> list = null;
        if(context != null){
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            String selection = MediaStore.Video.Media.DATA + " like?";
            String[] selectArgs = new String[]{"%convexd%"};
            Cursor cursor = context.getContentResolver().query(
                    uri,null,selection,selectArgs, MediaStore.Video.Media.DEFAULT_SORT_ORDER);
            Log.i(TAG, "getList: " + MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString());
            if(cursor != null){
                list = new ArrayList<VideoItem>();
                while (cursor.moveToNext()){
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
                    String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM));
                    String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ARTIST));
                    String displayName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                    String mime_type = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE));
                    String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                    long duration = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));
                    long Size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                    VideoItem videoItem = new VideoItem(id,duration,Size,album,artist,displayName,title,mime_type,path);
                    list.add(videoItem);
                }
                cursor.close();
            }
        }
        return list;
    }
}
