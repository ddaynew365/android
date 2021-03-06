package coms.example.allinonelowfiproject.dairy;

import android.widget.ImageButton;

public class MainData {

    private int iv_profile;
    private int iv_photo;
    private String tv_content;
    private String day;
    private ImageButton delete;

    public MainData(int iv_profile, int iv_photo, String tv_content, String day) {
        this.iv_profile = iv_profile;
        this.iv_photo = iv_photo;
        this.tv_content = tv_content;
        this.day = day;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public int getIv_photo() {
        return iv_photo;
    }

    public void setIv_photo(String tv_name) {
        this.iv_photo = iv_photo;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
