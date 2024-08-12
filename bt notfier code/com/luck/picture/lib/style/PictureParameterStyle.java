/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  com.luck.picture.lib.R$drawable
 */
package com.luck.picture.lib.style;

import android.graphics.Color;
import com.luck.picture.lib.R;

public class PictureParameterStyle {
    public int folderTextColor;
    public int folderTextSize;
    public boolean isChangeStatusBarFontColor;
    public boolean isCompleteReplaceNum;
    public boolean isNewSelectStyle;
    public boolean isOpenCheckNumStyle;
    public boolean isOpenCompletedNumStyle;
    public int pictureAlbumStyle;
    public int pictureBottomBgColor;
    @Deprecated
    public int pictureCancelTextColor;
    public int pictureCheckNumBgStyle;
    public int pictureCheckedStyle;
    public int pictureCompleteBackgroundStyle;
    public String pictureCompleteText;
    public int pictureCompleteTextColor;
    public int pictureCompleteTextSize;
    public int pictureContainerBackgroundColor;
    public int pictureExternalPreviewDeleteStyle;
    public boolean pictureExternalPreviewGonePreviewDelete;
    public int pictureFolderCheckedDotStyle;
    public int pictureLeftBackIcon;
    public int pictureNavBarColor;
    public int pictureOriginalControlStyle;
    public int pictureOriginalFontColor;
    public int pictureOriginalTextSize;
    public int picturePreviewBottomBgColor;
    public String picturePreviewText;
    public int picturePreviewTextColor;
    public int picturePreviewTextSize;
    public String pictureRightDefaultText;
    public int pictureRightDefaultTextColor;
    public int pictureRightSelectedTextColor;
    public int pictureRightTextSize;
    public int pictureStatusBarColor;
    public int pictureTitleBarBackgroundColor;
    public int pictureTitleBarHeight;
    public int pictureTitleDownResId;
    public int pictureTitleRightArrowLeftPadding;
    public int pictureTitleTextColor;
    public int pictureTitleTextSize;
    public int pictureTitleUpResId;
    public int pictureUnCompleteBackgroundStyle;
    public String pictureUnCompleteText;
    public int pictureUnCompleteTextColor;
    public String pictureUnPreviewText;
    public int pictureUnPreviewTextColor;
    public int pictureWeChatChooseStyle;
    public int pictureWeChatLeftBackStyle;
    public String pictureWeChatPreviewSelectedText;
    public int pictureWeChatPreviewSelectedTextSize;
    public int pictureWeChatTitleBackgroundStyle;

    public static PictureParameterStyle ofDefaultStyle() {
        PictureParameterStyle pictureParameterStyle = new PictureParameterStyle();
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = false;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureTitleBarBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureContainerBackgroundColor = Color.parseColor((String)"#000000");
        pictureParameterStyle.pictureTitleUpResId = R.drawable.picture_icon_arrow_up;
        pictureParameterStyle.pictureTitleDownResId = R.drawable.picture_icon_arrow_down;
        pictureParameterStyle.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle.pictureLeftBackIcon = R.drawable.picture_icon_back;
        pictureParameterStyle.pictureTitleTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureCancelTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureAlbumStyle = R.drawable.picture_item_select_bg;
        pictureParameterStyle.pictureCheckedStyle = R.drawable.picture_checkbox_selector;
        pictureParameterStyle.pictureBottomBgColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle.picturePreviewTextColor = Color.parseColor((String)"#FA632D");
        pictureParameterStyle.pictureUnPreviewTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureCompleteTextColor = Color.parseColor((String)"#FA632D");
        pictureParameterStyle.pictureUnCompleteTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.picturePreviewBottomBgColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle.pictureOriginalControlStyle = R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle.pictureOriginalFontColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle.pictureNavBarColor = Color.parseColor((String)"#393a3e");
        return pictureParameterStyle;
    }

    public static PictureParameterStyle ofNewStyle() {
        PictureParameterStyle pictureParameterStyle = new PictureParameterStyle();
        pictureParameterStyle.isNewSelectStyle = true;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = true;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureTitleBarBackgroundColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureContainerBackgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureTitleUpResId = R.drawable.picture_icon_wechat_up;
        pictureParameterStyle.pictureTitleDownResId = R.drawable.picture_icon_wechat_down;
        pictureParameterStyle.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle.pictureLeftBackIcon = R.drawable.picture_icon_close;
        pictureParameterStyle.pictureTitleTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureCancelTextColor = Color.parseColor((String)"#53575e");
        pictureParameterStyle.pictureRightDefaultTextColor = Color.parseColor((String)"#53575e");
        pictureParameterStyle.pictureRightSelectedTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureUnCompleteBackgroundStyle = R.drawable.picture_send_button_default_bg;
        pictureParameterStyle.pictureCompleteBackgroundStyle = R.drawable.picture_send_button_bg;
        pictureParameterStyle.pictureAlbumStyle = R.drawable.picture_item_select_bg;
        pictureParameterStyle.pictureCheckedStyle = R.drawable.picture_wechat_num_selector;
        pictureParameterStyle.pictureWeChatTitleBackgroundStyle = R.drawable.picture_album_bg;
        pictureParameterStyle.pictureWeChatChooseStyle = R.drawable.picture_wechat_select_cb;
        pictureParameterStyle.pictureWeChatLeftBackStyle = R.drawable.picture_icon_back;
        pictureParameterStyle.pictureBottomBgColor = Color.parseColor((String)"#393a3e");
        pictureParameterStyle.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle.picturePreviewTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureUnPreviewTextColor = Color.parseColor((String)"#9b9b9b");
        pictureParameterStyle.pictureCompleteTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureUnCompleteTextColor = Color.parseColor((String)"#53575e");
        pictureParameterStyle.picturePreviewBottomBgColor = Color.parseColor((String)"#a0393a3e");
        pictureParameterStyle.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle.pictureOriginalControlStyle = R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle.pictureOriginalFontColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle.pictureNavBarColor = Color.parseColor((String)"#393a3e");
        return pictureParameterStyle;
    }

    public static PictureParameterStyle ofSelectNumberStyle() {
        PictureParameterStyle pictureParameterStyle = new PictureParameterStyle();
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = true;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.pictureTitleBarBackgroundColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.pictureTitleUpResId = R.drawable.picture_icon_arrow_up;
        pictureParameterStyle.pictureTitleDownResId = R.drawable.picture_icon_arrow_down;
        pictureParameterStyle.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle.pictureLeftBackIcon = R.drawable.picture_icon_back;
        pictureParameterStyle.pictureTitleTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureCancelTextColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureAlbumStyle = R.drawable.picture_item_select_bg;
        pictureParameterStyle.pictureCheckedStyle = R.drawable.picture_checkbox_num_selector;
        pictureParameterStyle.pictureBottomBgColor = Color.parseColor((String)"#FAFAFA");
        pictureParameterStyle.pictureCheckNumBgStyle = R.drawable.picture_num_oval_blue;
        pictureParameterStyle.picturePreviewTextColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.pictureUnPreviewTextColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.pictureCompleteTextColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.pictureUnCompleteTextColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.picturePreviewBottomBgColor = Color.parseColor((String)"#FAFAFA");
        pictureParameterStyle.pictureOriginalControlStyle = R.drawable.picture_original_blue_checkbox;
        pictureParameterStyle.pictureOriginalFontColor = Color.parseColor((String)"#7D7DFF");
        pictureParameterStyle.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle.pictureExternalPreviewGonePreviewDelete = true;
        return pictureParameterStyle;
    }

    public static PictureParameterStyle ofSelectTotalStyle() {
        PictureParameterStyle pictureParameterStyle = new PictureParameterStyle();
        pictureParameterStyle.isChangeStatusBarFontColor = true;
        pictureParameterStyle.isOpenCompletedNumStyle = true;
        pictureParameterStyle.isOpenCheckNumStyle = false;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureTitleBarBackgroundColor = Color.parseColor((String)"#FFFFFF");
        pictureParameterStyle.pictureTitleUpResId = R.drawable.picture_icon_orange_arrow_up;
        pictureParameterStyle.pictureTitleDownResId = R.drawable.picture_icon_orange_arrow_down;
        pictureParameterStyle.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle.pictureLeftBackIcon = R.drawable.picture_icon_back_arrow;
        pictureParameterStyle.pictureTitleTextColor = Color.parseColor((String)"#000000");
        pictureParameterStyle.pictureCancelTextColor = Color.parseColor((String)"#000000");
        pictureParameterStyle.pictureAlbumStyle = R.drawable.picture_item_select_bg;
        pictureParameterStyle.pictureCheckedStyle = R.drawable.picture_checkbox_selector;
        pictureParameterStyle.pictureBottomBgColor = Color.parseColor((String)"#FAFAFA");
        pictureParameterStyle.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle.picturePreviewTextColor = Color.parseColor((String)"#FA632D");
        pictureParameterStyle.pictureUnPreviewTextColor = Color.parseColor((String)"#9b9b9b");
        pictureParameterStyle.pictureCompleteTextColor = Color.parseColor((String)"#FA632D");
        pictureParameterStyle.pictureUnCompleteTextColor = Color.parseColor((String)"#9b9b9b");
        pictureParameterStyle.picturePreviewBottomBgColor = Color.parseColor((String)"#FAFAFA");
        pictureParameterStyle.pictureOriginalControlStyle = R.drawable.picture_original_checkbox;
        pictureParameterStyle.pictureOriginalFontColor = Color.parseColor((String)"#53575e");
        pictureParameterStyle.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_black_delete;
        pictureParameterStyle.pictureExternalPreviewGonePreviewDelete = true;
        return pictureParameterStyle;
    }
}
