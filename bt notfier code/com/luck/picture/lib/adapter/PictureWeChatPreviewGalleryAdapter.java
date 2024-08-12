/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter$OnItemClickListener
 *  com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter$ViewHolder
 *  com.luck.picture.lib.adapter._$$Lambda$PictureWeChatPreviewGalleryAdapter$uprdlng3hwajRAxw4QP2P0y22dg
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter;
import com.luck.picture.lib.adapter._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;

public class PictureWeChatPreviewGalleryAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private final PictureSelectionConfig config;
    private List<LocalMedia> list;
    private OnItemClickListener listener;

    public PictureWeChatPreviewGalleryAdapter(PictureSelectionConfig pictureSelectionConfig) {
        this.config = pictureSelectionConfig;
    }

    public void addSingleMediaToData(LocalMedia localMedia) {
        List<LocalMedia> list = this.list;
        if (list == null) return;
        list.clear();
        this.list.add(localMedia);
        this.notifyDataSetChanged();
    }

    public LocalMedia getItem(int n) {
        Object object = this.list;
        object = object != null && object.size() > 0 ? this.list.get(n) : null;
        return object;
    }

    public int getItemCount() {
        List<LocalMedia> list = this.list;
        int n = list != null ? list.size() : 0;
        return n;
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.list;
        boolean bl = list == null || list.size() == 0;
        return bl;
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$PictureWeChatPreviewGalleryAdapter(ViewHolder viewHolder, int n, View view) {
        if (this.listener == null) return;
        if (viewHolder.getAdapterPosition() < 0) return;
        this.listener.onItemClick(viewHolder.getAdapterPosition(), this.getItem(n), view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        LocalMedia localMedia = this.getItem(n);
        if (localMedia == null) return;
        View view = viewHolder.viewBorder;
        boolean bl = localMedia.isChecked();
        int n2 = 0;
        int n3 = bl ? 0 : 8;
        view.setVisibility(n3);
        if (this.config != null && PictureSelectionConfig.imageEngine != null) {
            PictureSelectionConfig.imageEngine.loadImage(viewHolder.itemView.getContext(), localMedia.getPath(), viewHolder.ivImage);
        }
        view = viewHolder.ivPlay;
        n3 = PictureMimeType.isHasVideo((String)localMedia.getMimeType()) ? n2 : 8;
        view.setVisibility(n3);
        viewHolder.itemView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureWeChatPreviewGalleryAdapter.uprdlng3hwajRAxw4QP2P0y22dg(this, viewHolder, n));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(R.layout.picture_wechat_preview_gallery, viewGroup, false));
    }

    public void removeMediaToData(LocalMedia localMedia) {
        List<LocalMedia> list = this.list;
        if (list == null) return;
        if (list.size() <= 0) return;
        this.list.remove(localMedia);
        this.notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void setNewData(List<LocalMedia> list) {
        List<LocalMedia> list2 = list;
        if (list == null) {
            list2 = new ArrayList<LocalMedia>();
        }
        this.list = list2;
        this.notifyDataSetChanged();
    }
}
