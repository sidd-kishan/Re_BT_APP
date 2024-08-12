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

public static class PictureImageGridAdapter.ViewHolder
extends RecyclerView.ViewHolder {
    View btnCheck;
    View contentView;
    ImageView ivPicture;
    TextView tvCheck;
    TextView tvDuration;
    TextView tvIsGif;
    TextView tvLongChart;

    public PictureImageGridAdapter.ViewHolder(View view) {
        super(view);
        this.contentView = view;
        this.ivPicture = (ImageView)view.findViewById(R.id.ivPicture);
        this.tvCheck = (TextView)view.findViewById(R.id.tvCheck);
        this.btnCheck = view.findViewById(R.id.btnCheck);
        this.tvDuration = (TextView)view.findViewById(R.id.tv_duration);
        this.tvIsGif = (TextView)view.findViewById(R.id.tv_isGif);
        this.tvLongChart = (TextView)view.findViewById(R.id.tv_long_chart);
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_check_style != 0) {
                this.tvCheck.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_check_style);
            }
            if (PictureSelectionConfig.uiStyle.picture_check_textSize != 0) {
                this.tvCheck.setTextSize((float)PictureSelectionConfig.uiStyle.picture_check_textSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_check_textColor != 0) {
                this.tvCheck.setTextColor(PictureSelectionConfig.uiStyle.picture_check_textColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_textSize > 0) {
                this.tvDuration.setTextSize((float)PictureSelectionConfig.uiStyle.picture_adapter_item_textSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_textColor != 0) {
                this.tvDuration.setTextColor(PictureSelectionConfig.uiStyle.picture_adapter_item_textColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text != 0) {
                this.tvIsGif.setText((CharSequence)view.getContext().getString(PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text));
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_show) {
                this.tvIsGif.setVisibility(0);
            } else {
                this.tvIsGif.setVisibility(8);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background != 0) {
                this.tvIsGif.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor != 0) {
                this.tvIsGif.setTextColor(PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize == 0) return;
            this.tvIsGif.setTextSize((float)PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize);
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureCheckedStyle == 0) return;
            this.tvCheck.setBackgroundResource(PictureSelectionConfig.style.pictureCheckedStyle);
        } else {
            view = AttrsUtils.getTypeValueDrawable((Context)view.getContext(), (int)R.attr.picture_checked_style, (int)R.drawable.picture_checkbox_selector);
            this.tvCheck.setBackground((Drawable)view);
        }
    }
}
