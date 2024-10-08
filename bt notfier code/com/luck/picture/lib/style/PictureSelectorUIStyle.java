/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.app.PictureAppMaster
 *  com.luck.picture.lib.tools.ScreenUtils
 */
package com.luck.picture.lib.style;

import android.content.Context;
import android.graphics.Color;
import com.luck.picture.lib.R;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.tools.ScreenUtils;

public class PictureSelectorUIStyle {
    public boolean isCompleteReplaceNum;
    public boolean isNewSelectStyle;
    public int picture_adapter_item_audio_textLeftDrawable;
    public int picture_adapter_item_camera_backgroundColor;
    public int picture_adapter_item_camera_text;
    public int picture_adapter_item_camera_textColor;
    public int picture_adapter_item_camera_textSize;
    public int picture_adapter_item_camera_textTopDrawable;
    public int picture_adapter_item_gif_tag_background;
    public boolean picture_adapter_item_gif_tag_show = true;
    public int picture_adapter_item_gif_tag_textColor;
    public int picture_adapter_item_gif_tag_textSize;
    public int picture_adapter_item_tag_text;
    public int picture_adapter_item_textColor;
    public int picture_adapter_item_textSize;
    public int picture_adapter_item_video_textLeftDrawable;
    public int picture_album_backgroundStyle;
    public int picture_album_checkDotStyle;
    public int picture_album_textColor;
    public int picture_album_textSize;
    public int picture_bottom_barBackgroundColor;
    public int picture_bottom_barHeight;
    public int picture_bottom_completeDefaultText;
    public int picture_bottom_completeNormalText;
    public int picture_bottom_completeRedDotBackground;
    public int picture_bottom_completeRedDotTextColor;
    public int picture_bottom_completeRedDotTextSize;
    public int[] picture_bottom_completeTextColor;
    public int picture_bottom_completeTextSize;
    public int picture_bottom_gallery_backgroundColor;
    public int picture_bottom_gallery_frameBackground;
    public int picture_bottom_gallery_height;
    public int picture_bottom_originalPictureCheckStyle;
    public int picture_bottom_originalPictureText;
    public int picture_bottom_originalPictureTextColor;
    public int picture_bottom_originalPictureTextSize;
    public int picture_bottom_previewDefaultText;
    public int picture_bottom_previewNormalText;
    public int[] picture_bottom_previewTextColor;
    public int picture_bottom_previewTextSize;
    public int picture_bottom_selectedCheckStyle;
    public int picture_bottom_selectedText;
    public int picture_bottom_selectedTextColor;
    public int picture_bottom_selectedTextSize;
    public int picture_check_style;
    public int picture_check_textColor;
    public int picture_check_textSize;
    public int picture_container_backgroundColor;
    public int picture_navBarColor;
    public int picture_statusBarBackgroundColor;
    public boolean picture_statusBarChangeTextColor;
    public boolean picture_switchSelectNumberStyle;
    public boolean picture_switchSelectTotalStyle;
    public int picture_top_deleteButtonStyle;
    public int picture_top_leftBack;
    public boolean picture_top_showHideDeleteButton;
    public int picture_top_titleAlbumBackground;
    public int picture_top_titleArrowDownDrawable;
    public int picture_top_titleArrowLeftPadding;
    public int picture_top_titleArrowUpDrawable;
    public int picture_top_titleBarBackgroundColor;
    public int picture_top_titleBarHeight;
    public int picture_top_titleRightDefaultText;
    public int picture_top_titleRightNormalText;
    public int[] picture_top_titleRightTextColor;
    public int picture_top_titleRightTextDefaultBackground;
    public int picture_top_titleRightTextNormalBackground;
    public int picture_top_titleRightTextSize;
    public int picture_top_titleTextColor;
    public int picture_top_titleTextSize;

    public static PictureSelectorUIStyle ofDefaultStyle() {
        PictureSelectorUIStyle pictureSelectorUIStyle = new PictureSelectorUIStyle();
        pictureSelectorUIStyle.picture_statusBarBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_container_backgroundColor = Color.parseColor((String)"#000000");
        pictureSelectorUIStyle.picture_navBarColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_check_style = R.drawable.picture_checkbox_selector;
        pictureSelectorUIStyle.picture_top_leftBack = R.drawable.picture_icon_back;
        pictureSelectorUIStyle.picture_top_titleRightTextColor = new int[]{Color.parseColor((String)"#FFFFFF"), Color.parseColor((String)"#FFFFFF")};
        pictureSelectorUIStyle.picture_top_titleRightTextSize = 14;
        pictureSelectorUIStyle.picture_top_titleTextSize = 18;
        pictureSelectorUIStyle.picture_top_titleArrowUpDrawable = R.drawable.picture_icon_arrow_up;
        pictureSelectorUIStyle.picture_top_titleArrowDownDrawable = R.drawable.picture_icon_arrow_down;
        pictureSelectorUIStyle.picture_top_titleTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_top_titleBarBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_album_textSize = 16;
        pictureSelectorUIStyle.picture_album_backgroundStyle = R.drawable.picture_item_select_bg;
        pictureSelectorUIStyle.picture_album_textColor = Color.parseColor((String)"#4d4d4d");
        pictureSelectorUIStyle.picture_album_checkDotStyle = R.drawable.picture_orange_oval;
        pictureSelectorUIStyle.picture_bottom_previewTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_previewTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#FA632D")};
        pictureSelectorUIStyle.picture_bottom_completeRedDotTextSize = 12;
        pictureSelectorUIStyle.picture_bottom_completeTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_completeRedDotTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_bottom_completeRedDotBackground = R.drawable.picture_num_oval;
        pictureSelectorUIStyle.picture_bottom_completeTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#FA632D")};
        pictureSelectorUIStyle.picture_bottom_barBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_adapter_item_camera_backgroundColor = Color.parseColor((String)"#999999");
        pictureSelectorUIStyle.picture_adapter_item_camera_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_camera_textSize = 14;
        pictureSelectorUIStyle.picture_adapter_item_camera_textTopDrawable = R.drawable.picture_icon_camera;
        pictureSelectorUIStyle.picture_adapter_item_textSize = 12;
        pictureSelectorUIStyle.picture_adapter_item_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_video_textLeftDrawable = R.drawable.picture_icon_video;
        pictureSelectorUIStyle.picture_adapter_item_audio_textLeftDrawable = R.drawable.picture_icon_audio;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_originalPictureCheckStyle = R.drawable.picture_original_wechat_checkbox;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_bottom_previewNormalText = R.string.picture_preview_num;
        pictureSelectorUIStyle.picture_bottom_originalPictureText = R.string.picture_original_image;
        pictureSelectorUIStyle.picture_bottom_completeDefaultText = R.string.picture_please_select;
        pictureSelectorUIStyle.picture_bottom_completeNormalText = R.string.picture_completed;
        pictureSelectorUIStyle.picture_adapter_item_camera_text = R.string.picture_take_picture;
        pictureSelectorUIStyle.picture_top_titleRightDefaultText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_top_titleRightNormalText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_bottom_previewDefaultText = R.string.picture_preview;
        Context context = PictureAppMaster.getInstance().getAppContext();
        if (context == null) return pictureSelectorUIStyle;
        pictureSelectorUIStyle.picture_top_titleBarHeight = ScreenUtils.dip2px((Context)context, (float)48.0f);
        pictureSelectorUIStyle.picture_bottom_barHeight = ScreenUtils.dip2px((Context)context, (float)45.0f);
        pictureSelectorUIStyle.isCompleteReplaceNum = true;
        return pictureSelectorUIStyle;
    }

    public static PictureSelectorUIStyle ofNewStyle() {
        PictureSelectorUIStyle pictureSelectorUIStyle = new PictureSelectorUIStyle();
        pictureSelectorUIStyle.isNewSelectStyle = true;
        pictureSelectorUIStyle.picture_statusBarBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_container_backgroundColor = Color.parseColor((String)"#000000");
        pictureSelectorUIStyle.picture_switchSelectNumberStyle = true;
        pictureSelectorUIStyle.picture_navBarColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_check_style = R.drawable.picture_wechat_num_selector;
        pictureSelectorUIStyle.picture_top_leftBack = R.drawable.picture_icon_close;
        pictureSelectorUIStyle.picture_top_titleRightTextColor = new int[]{Color.parseColor((String)"#53575e"), Color.parseColor((String)"#FFFFFF")};
        pictureSelectorUIStyle.picture_top_titleRightTextSize = 14;
        pictureSelectorUIStyle.picture_top_titleTextSize = 18;
        pictureSelectorUIStyle.picture_top_titleArrowUpDrawable = R.drawable.picture_icon_wechat_up;
        pictureSelectorUIStyle.picture_top_titleArrowDownDrawable = R.drawable.picture_icon_wechat_down;
        pictureSelectorUIStyle.picture_top_titleTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_top_titleBarBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_top_titleAlbumBackground = R.drawable.picture_album_bg;
        pictureSelectorUIStyle.picture_album_textSize = 16;
        pictureSelectorUIStyle.picture_album_backgroundStyle = R.drawable.picture_item_select_bg;
        pictureSelectorUIStyle.picture_album_textColor = Color.parseColor((String)"#4d4d4d");
        pictureSelectorUIStyle.picture_album_checkDotStyle = R.drawable.picture_orange_oval;
        pictureSelectorUIStyle.picture_bottom_previewTextSize = 16;
        pictureSelectorUIStyle.picture_bottom_previewTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#FFFFFF")};
        pictureSelectorUIStyle.picture_bottom_completeTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#FA632D")};
        pictureSelectorUIStyle.picture_bottom_barBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureSelectorUIStyle.picture_adapter_item_camera_backgroundColor = Color.parseColor((String)"#999999");
        pictureSelectorUIStyle.picture_adapter_item_camera_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_camera_textSize = 14;
        pictureSelectorUIStyle.picture_adapter_item_camera_textTopDrawable = R.drawable.picture_icon_camera;
        pictureSelectorUIStyle.picture_adapter_item_textSize = 12;
        pictureSelectorUIStyle.picture_adapter_item_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_video_textLeftDrawable = R.drawable.picture_icon_video;
        pictureSelectorUIStyle.picture_adapter_item_audio_textLeftDrawable = R.drawable.picture_icon_audio;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_originalPictureCheckStyle = R.drawable.picture_original_wechat_checkbox;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_top_titleRightTextDefaultBackground = R.drawable.picture_send_button_default_bg;
        pictureSelectorUIStyle.picture_top_titleRightTextNormalBackground = R.drawable.picture_send_button_bg;
        Context context = PictureAppMaster.getInstance().getAppContext();
        if (context == null) return pictureSelectorUIStyle;
        pictureSelectorUIStyle.picture_top_titleBarHeight = ScreenUtils.dip2px((Context)context, (float)48.0f);
        pictureSelectorUIStyle.picture_top_titleRightDefaultText = R.string.picture_send;
        pictureSelectorUIStyle.picture_top_titleRightNormalText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_bottom_barHeight = ScreenUtils.dip2px((Context)context, (float)45.0f);
        pictureSelectorUIStyle.picture_bottom_previewDefaultText = R.string.picture_preview;
        pictureSelectorUIStyle.picture_bottom_previewNormalText = R.string.picture_preview_num;
        pictureSelectorUIStyle.picture_bottom_originalPictureText = R.string.picture_original_image;
        pictureSelectorUIStyle.picture_bottom_completeDefaultText = R.string.picture_please_select;
        pictureSelectorUIStyle.picture_bottom_completeNormalText = R.string.picture_completed;
        pictureSelectorUIStyle.picture_adapter_item_camera_text = R.string.picture_take_picture;
        pictureSelectorUIStyle.picture_bottom_selectedText = R.string.picture_select;
        pictureSelectorUIStyle.picture_bottom_selectedCheckStyle = R.drawable.picture_wechat_select_cb;
        pictureSelectorUIStyle.isCompleteReplaceNum = true;
        pictureSelectorUIStyle.picture_top_titleArrowLeftPadding = ScreenUtils.dip2px((Context)context, (float)3.0f);
        pictureSelectorUIStyle.picture_bottom_selectedTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_bottom_selectedTextSize = 16;
        pictureSelectorUIStyle.picture_bottom_gallery_height = ScreenUtils.dip2px((Context)context, (float)80.0f);
        pictureSelectorUIStyle.picture_bottom_gallery_backgroundColor = Color.parseColor((String)"#a0393a3e");
        pictureSelectorUIStyle.picture_bottom_gallery_frameBackground = R.drawable.picture_preview_gallery_border_bg;
        return pictureSelectorUIStyle;
    }

    public static PictureSelectorUIStyle ofSelectNumberStyle() {
        PictureSelectorUIStyle pictureSelectorUIStyle = new PictureSelectorUIStyle();
        pictureSelectorUIStyle.picture_statusBarBackgroundColor = Color.parseColor((String)"#7D7DFF");
        pictureSelectorUIStyle.picture_container_backgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_switchSelectNumberStyle = true;
        pictureSelectorUIStyle.picture_navBarColor = Color.parseColor((String)"#7D7DFF");
        pictureSelectorUIStyle.picture_check_style = R.drawable.picture_checkbox_num_selector;
        pictureSelectorUIStyle.picture_top_leftBack = R.drawable.picture_icon_back;
        pictureSelectorUIStyle.picture_top_titleRightTextColor = new int[]{Color.parseColor((String)"#FFFFFF"), Color.parseColor((String)"#FFFFFF")};
        pictureSelectorUIStyle.picture_top_titleRightTextSize = 14;
        pictureSelectorUIStyle.picture_top_titleTextSize = 18;
        pictureSelectorUIStyle.picture_top_titleArrowUpDrawable = R.drawable.picture_icon_arrow_up;
        pictureSelectorUIStyle.picture_top_titleArrowDownDrawable = R.drawable.picture_icon_arrow_down;
        pictureSelectorUIStyle.picture_top_titleTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_top_titleBarBackgroundColor = Color.parseColor((String)"#7D7DFF");
        pictureSelectorUIStyle.picture_album_textSize = 16;
        pictureSelectorUIStyle.picture_album_backgroundStyle = R.drawable.picture_item_select_bg;
        pictureSelectorUIStyle.picture_album_textColor = Color.parseColor((String)"#4d4d4d");
        pictureSelectorUIStyle.picture_album_checkDotStyle = R.drawable.picture_num_oval_blue;
        pictureSelectorUIStyle.picture_bottom_previewTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_previewTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#7D7DFF")};
        pictureSelectorUIStyle.picture_bottom_completeRedDotTextSize = 12;
        pictureSelectorUIStyle.picture_bottom_completeTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_completeRedDotTextColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_bottom_completeRedDotBackground = R.drawable.picture_num_oval_blue;
        pictureSelectorUIStyle.picture_bottom_completeTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#7D7DFF")};
        pictureSelectorUIStyle.picture_bottom_barBackgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_camera_backgroundColor = Color.parseColor((String)"#999999");
        pictureSelectorUIStyle.picture_adapter_item_camera_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_camera_textSize = 14;
        pictureSelectorUIStyle.picture_adapter_item_camera_textTopDrawable = R.drawable.picture_icon_camera;
        pictureSelectorUIStyle.picture_adapter_item_textSize = 12;
        pictureSelectorUIStyle.picture_adapter_item_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_video_textLeftDrawable = R.drawable.picture_icon_video;
        pictureSelectorUIStyle.picture_adapter_item_audio_textLeftDrawable = R.drawable.picture_icon_audio;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_originalPictureCheckStyle = R.drawable.picture_original_blue_checkbox;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextColor = Color.parseColor((String)"#7D7DFF");
        pictureSelectorUIStyle.picture_bottom_previewNormalText = R.string.picture_preview_num;
        pictureSelectorUIStyle.picture_bottom_originalPictureText = R.string.picture_original_image;
        pictureSelectorUIStyle.picture_bottom_completeDefaultText = R.string.picture_please_select;
        pictureSelectorUIStyle.picture_bottom_completeNormalText = R.string.picture_completed;
        pictureSelectorUIStyle.picture_adapter_item_camera_text = R.string.picture_take_picture;
        pictureSelectorUIStyle.picture_top_titleRightDefaultText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_top_titleRightNormalText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_bottom_previewDefaultText = R.string.picture_preview;
        Context context = PictureAppMaster.getInstance().getAppContext();
        if (context == null) return pictureSelectorUIStyle;
        pictureSelectorUIStyle.picture_top_titleBarHeight = ScreenUtils.dip2px((Context)context, (float)48.0f);
        pictureSelectorUIStyle.picture_bottom_barHeight = ScreenUtils.dip2px((Context)context, (float)45.0f);
        pictureSelectorUIStyle.isCompleteReplaceNum = true;
        return pictureSelectorUIStyle;
    }

    public static PictureSelectorUIStyle ofSelectTotalStyle() {
        PictureSelectorUIStyle pictureSelectorUIStyle = new PictureSelectorUIStyle();
        pictureSelectorUIStyle.picture_switchSelectTotalStyle = true;
        pictureSelectorUIStyle.picture_statusBarChangeTextColor = true;
        pictureSelectorUIStyle.picture_statusBarBackgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_container_backgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_navBarColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_check_style = R.drawable.picture_checkbox_selector;
        pictureSelectorUIStyle.picture_top_leftBack = R.drawable.picture_icon_back_arrow;
        pictureSelectorUIStyle.picture_top_titleRightTextColor = new int[]{Color.parseColor((String)"#000000"), Color.parseColor((String)"#000000")};
        pictureSelectorUIStyle.picture_top_titleRightTextSize = 14;
        pictureSelectorUIStyle.picture_top_titleTextSize = 18;
        pictureSelectorUIStyle.picture_top_titleArrowUpDrawable = R.drawable.picture_icon_orange_arrow_up;
        pictureSelectorUIStyle.picture_top_titleArrowDownDrawable = R.drawable.picture_icon_orange_arrow_down;
        pictureSelectorUIStyle.picture_top_titleTextColor = Color.parseColor((String)"#000000");
        pictureSelectorUIStyle.picture_top_titleBarBackgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_album_textSize = 16;
        pictureSelectorUIStyle.picture_album_backgroundStyle = R.drawable.picture_item_select_bg;
        pictureSelectorUIStyle.picture_album_textColor = Color.parseColor((String)"#4d4d4d");
        pictureSelectorUIStyle.picture_album_checkDotStyle = R.drawable.picture_orange_oval;
        pictureSelectorUIStyle.picture_bottom_previewTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_previewTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#FA632D")};
        pictureSelectorUIStyle.picture_bottom_completeTextColor = new int[]{Color.parseColor((String)"#9b9b9b"), Color.parseColor((String)"#FA632D")};
        pictureSelectorUIStyle.picture_bottom_barBackgroundColor = Color.parseColor((String)"#FAFAFA");
        pictureSelectorUIStyle.picture_adapter_item_camera_backgroundColor = Color.parseColor((String)"#999999");
        pictureSelectorUIStyle.picture_adapter_item_camera_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_camera_textSize = 14;
        pictureSelectorUIStyle.picture_adapter_item_camera_textTopDrawable = R.drawable.picture_icon_camera;
        pictureSelectorUIStyle.picture_adapter_item_textSize = 12;
        pictureSelectorUIStyle.picture_adapter_item_textColor = Color.parseColor((String)"#FFFFFF");
        pictureSelectorUIStyle.picture_adapter_item_video_textLeftDrawable = R.drawable.picture_icon_video;
        pictureSelectorUIStyle.picture_adapter_item_audio_textLeftDrawable = R.drawable.picture_icon_audio;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextSize = 14;
        pictureSelectorUIStyle.picture_bottom_originalPictureCheckStyle = R.drawable.picture_original_checkbox;
        pictureSelectorUIStyle.picture_bottom_originalPictureTextColor = Color.parseColor((String)"#53575e");
        pictureSelectorUIStyle.picture_bottom_previewNormalText = R.string.picture_preview_num;
        pictureSelectorUIStyle.picture_bottom_originalPictureText = R.string.picture_original_image;
        pictureSelectorUIStyle.picture_bottom_completeDefaultText = R.string.picture_done;
        pictureSelectorUIStyle.picture_bottom_completeNormalText = R.string.picture_done_front_num;
        pictureSelectorUIStyle.picture_adapter_item_camera_text = R.string.picture_take_picture;
        pictureSelectorUIStyle.picture_top_titleRightDefaultText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_top_titleRightNormalText = R.string.picture_cancel;
        pictureSelectorUIStyle.picture_bottom_previewDefaultText = R.string.picture_preview;
        Context context = PictureAppMaster.getInstance().getAppContext();
        if (context == null) return pictureSelectorUIStyle;
        pictureSelectorUIStyle.picture_top_titleBarHeight = ScreenUtils.dip2px((Context)context, (float)48.0f);
        pictureSelectorUIStyle.picture_bottom_barHeight = ScreenUtils.dip2px((Context)context, (float)45.0f);
        pictureSelectorUIStyle.isCompleteReplaceNum = true;
        return pictureSelectorUIStyle;
    }
}
