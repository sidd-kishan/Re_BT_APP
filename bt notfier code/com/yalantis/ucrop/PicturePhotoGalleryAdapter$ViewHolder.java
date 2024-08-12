/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.luck.picture.lib.R$id
 */
package com.yalantis.ucrop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;

public static class PicturePhotoGalleryAdapter.ViewHolder
extends RecyclerView.ViewHolder {
    ImageView iv_dot;
    ImageView mIvPhoto;
    ImageView mIvVideo;
    TextView tvGif;

    public PicturePhotoGalleryAdapter.ViewHolder(View view) {
        super(view);
        this.mIvPhoto = (ImageView)view.findViewById(R.id.iv_photo);
        this.mIvVideo = (ImageView)view.findViewById(R.id.iv_video);
        this.iv_dot = (ImageView)view.findViewById(R.id.iv_dot);
        this.tvGif = (TextView)view.findViewById(R.id.tv_gif);
    }
}
