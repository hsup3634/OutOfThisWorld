package com.example.outofthisworld;

public class ContentDetail {

    private String ytTitle;
    private String ytDescription;

    // unique identifier of a Topic
    private int topicID;
    // Name of the Topic
    private String title;
    // Text Description of the Topic
    private String text;
    // Resource ID of associated image (e.g. R.drawable.my_image)
    private int imageDrawableId;

    private String youtubeVideo;


    public ContentDetail(int topicID, String title, String text, int imageDrawableId) {
        this.topicID = topicID;
        this.title = title;
        this.text = text;
        this.imageDrawableId = imageDrawableId;
    }

    public String getYtTitle() {
        return ytTitle;
    }

    public void setYtTitle(String ytTitle) {
        this.ytTitle = ytTitle;
    }

    public String getYtDescription() {
        return ytDescription;
    }

    public void setYtDescription(String ytDescription) {
        this.ytDescription = ytDescription;
    }

    public ContentDetail(int topicID, String youtubeVideo, String ytTitle, String ytDescription) {
        this.topicID = topicID;
        this.youtubeVideo = youtubeVideo;
        this.ytTitle = ytTitle;
        this.ytDescription = ytDescription;
    }


    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }

    public String getYoutubeVideo() {
        return youtubeVideo;
    }

    public void setYoutubeVideo(String youtubeVideo) {
        this.youtubeVideo = youtubeVideo;
    }
}