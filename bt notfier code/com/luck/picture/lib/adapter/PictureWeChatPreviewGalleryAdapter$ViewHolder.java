/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.config.PictureSelectionConfig
 */
package com.luck.picture.lib.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureSelectionConfig;

static class PictureWeChatPreviewGalleryAdapter.ViewHolder
extends RecyclerView.ViewHolder {
    ImageView ivImage;
    ImageView ivPlay;
    View viewBorder;

    public PictureWeChatPreviewGalleryAdapter.ViewHolder(View view) {
        super(view);
        this.ivImage = (ImageView)view.findViewById(R.id.ivImage);
        this.ivPlay = (ImageView)view.findViewById(R.id.ivPlay);
        this.viewBorder = view.findViewById(R.id.viewBorder);
        if (PictureSelectionConfig.uiStyle == null) return;
        this.viewBorder.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_gallery_frameBackground);
    }
}
