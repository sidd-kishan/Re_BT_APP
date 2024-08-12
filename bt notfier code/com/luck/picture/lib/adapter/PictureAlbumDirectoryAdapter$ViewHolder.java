/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.tools.AttrsUtils
 */
package com.luck.picture.lib.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.tools.AttrsUtils;

static class PictureAlbumDirectoryAdapter.ViewHolder
extends RecyclerView.ViewHolder {
    ImageView ivFirstImage;
    TextView tvFolderName;
    TextView tvSign;

    public PictureAlbumDirectoryAdapter.ViewHolder(View view) {
        super(view);
        this.ivFirstImage = (ImageView)view.findViewById(R.id.first_image);
        this.tvFolderName = (TextView)view.findViewById(R.id.tv_folder_name);
        this.tvSign = (TextView)view.findViewById(R.id.tv_sign);
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_album_checkDotStyle != 0) {
                this.tvSign.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_album_checkDotStyle);
            }
            if (PictureSelectionConfig.uiStyle.picture_album_textColor != 0) {
                this.tvFolderName.setTextColor(PictureSelectionConfig.uiStyle.picture_album_textColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_album_textSize <= 0) return;
            this.tvFolderName.setTextSize((float)PictureSelectionConfig.uiStyle.picture_album_textSize);
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureFolderCheckedDotStyle != 0) {
                this.tvSign.setBackgroundResource(PictureSelectionConfig.style.pictureFolderCheckedDotStyle);
            }
            if (PictureSelectionConfig.style.folderTextColor != 0) {
                this.tvFolderName.setTextColor(PictureSelectionConfig.style.folderTextColor);
            }
            if (PictureSelectionConfig.style.folderTextSize <= 0) return;
            this.tvFolderName.setTextSize((float)PictureSelectionConfig.style.folderTextSize);
        } else {
            float f;
            Drawable drawable2 = AttrsUtils.getTypeValueDrawable((Context)view.getContext(), (int)R.attr.picture_folder_checked_dot, (int)R.drawable.picture_orange_oval);
            this.tvSign.setBackground(drawable2);
            int n = AttrsUtils.getTypeValueColor((Context)view.getContext(), (int)R.attr.picture_folder_textColor);
            if (n != 0) {
                this.tvFolderName.setTextColor(n);
            }
            if (!((f = AttrsUtils.getTypeValueSize((Context)view.getContext(), (int)R.attr.picture_folder_textSize)) > 0.0f)) return;
            this.tvFolderName.setTextSize(0, f);
        }
    }
}
