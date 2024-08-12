/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter$OnItemClickListener
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter$ViewHolder
 */
package com.yalantis.ucrop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.yalantis.ucrop.PicturePhotoGalleryAdapter;
import java.util.List;

public class PicturePhotoGalleryAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private final List<LocalMedia> list;
    private OnItemClickListener listener;

    public PicturePhotoGalleryAdapter(List<LocalMedia> list) {
        this.list = list;
    }

    static /* synthetic */ OnItemClickListener access$000(PicturePhotoGalleryAdapter picturePhotoGalleryAdapter) {
        return picturePhotoGalleryAdapter.listener;
    }

    public int getItemCount() {
        List<LocalMedia> list = this.list;
        int n = list != null ? list.size() : 0;
        return n;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        LocalMedia localMedia = this.list.get(n);
        String string = localMedia.getPath();
        boolean bl = localMedia.isCut();
        n = 0;
        if (bl) {
            viewHolder.iv_dot.setVisibility(0);
            viewHolder.iv_dot.setImageResource(R.drawable.ucrop_oval_true);
        } else {
            viewHolder.iv_dot.setVisibility(4);
        }
        if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
            viewHolder.mIvPhoto.setVisibility(8);
            viewHolder.mIvVideo.setVisibility(0);
            viewHolder.mIvVideo.setImageResource(R.drawable.ucrop_ic_default_video);
        } else {
            viewHolder.mIvPhoto.setVisibility(0);
            viewHolder.mIvVideo.setVisibility(8);
            TextView textView = viewHolder.tvGif;
            if (!PictureMimeType.isGif((String)localMedia.getMimeType())) {
                n = 8;
            }
            textView.setVisibility(n);
            if (PictureSelectionConfig.imageEngine != null) {
                PictureSelectionConfig.imageEngine.loadGridImage(viewHolder.itemView.getContext(), string, viewHolder.mIvPhoto);
            }
            viewHolder.itemView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(R.layout.ucrop_picture_gf_adapter_edit_list, viewGroup, false));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
