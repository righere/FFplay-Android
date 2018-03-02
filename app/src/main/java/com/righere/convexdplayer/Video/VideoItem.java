package com.righere.convexdplayer.Video;

import java.io.Serializable;

/**
 * Created by righere on 16-11-18.
 */

public class VideoItem implements Serializable {

    /**
     * video对象的属性
     */
    private int id;
    private long mVideoDuration;
    private long mVideoSize;
    private String album;
    private String artist;
    private String displayname;
    private String mVideoTitle;
    private String mVideoMimeType;
    private String path;
    private LoadImage loadImage;

    /**
     * @param id 视频文件的id
     * @param mVideoDuration 视频的文件时长
     * @param mVideoSize 视频文件的大小
     * @param album 文件的专辑
     * @param artist 文件的作者
     * @param displayname 显示文件名
     * @param mVideoTitle 视频目录中的文件头
     * @param mVideoMimeType 文件类型
     * @param path 文件路径
     */
    public VideoItem(int id, long mVideoDuration, long mVideoSize,
                     String album, String artist, String displayname,String mVideoTitle, String mVideoMimeType, String path) {
        super();
        this.id = id;
        this.mVideoDuration = mVideoDuration;
        this.mVideoSize = mVideoSize;
        this.album = album;
        this.artist = artist;
        this.displayname = displayname;
        this.mVideoTitle = mVideoTitle;
        this.mVideoMimeType = mVideoMimeType;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getmVideoDuration() {
        return mVideoDuration;
    }

    public long getmVideoSize() {
        return mVideoSize;
    }

    public void setmVideoSize(long mVideoSize) {
        this.mVideoSize = mVideoSize;
    }

    public String getmVideoTitle() {
        return mVideoTitle;
    }

    public void setmVideoTitle(String mVideoTitle) {
        this.mVideoTitle = mVideoTitle;
    }

    public String getmVideoMimeType() {
        return mVideoMimeType;
    }

    public void setmVideoMimeType(String mVideoMimeType) {
        this.mVideoMimeType = mVideoMimeType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public LoadImage getLoadImage() {
        return loadImage;
    }

    public void setLoadImage(LoadImage loadImage) {
        this.loadImage = loadImage;
    }
}
