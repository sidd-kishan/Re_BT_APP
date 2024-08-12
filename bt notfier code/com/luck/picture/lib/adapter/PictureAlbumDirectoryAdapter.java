/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter$ViewHolder
 *  com.luck.picture.lib.adapter._$$Lambda$PictureAlbumDirectoryAdapter$A0GR_Ws1OIsHan7WkWhrO__kt08
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.listener.OnAlbumItemClickListener
 */
package com.luck.picture.lib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter;
import com.luck.picture.lib.adapter._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class PictureAlbumDirectoryAdapter
extends RecyclerView.Adapter<ViewHolder> {
    private int chooseMode;
    private List<LocalMediaFolder> folders = new ArrayList<LocalMediaFolder>();
    private OnAlbumItemClickListener onAlbumItemClickListener;

    public PictureAlbumDirectoryAdapter(PictureSelectionConfig pictureSelectionConfig) {
        this.chooseMode = pictureSelectionConfig.chooseMode;
    }

    public void bindFolderData(List<LocalMediaFolder> list) {
        List<LocalMediaFolder> list2 = list;
        if (list == null) {
            list2 = new ArrayList<LocalMediaFolder>();
        }
        this.folders = list2;
        this.notifyDataSetChanged();
    }

    public List<LocalMediaFolder> getFolderData() {
        List<LocalMediaFolder> list;
        List<LocalMediaFolder> list2 = list = this.folders;
        if (list != null) return list2;
        list2 = new ArrayList<LocalMediaFolder>();
        return list2;
    }

    public int getItemCount() {
        return this.folders.size();
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$PictureAlbumDirectoryAdapter(LocalMediaFolder localMediaFolder, int n, View view) {
        if (this.onAlbumItemClickListener == null) return;
        int n2 = this.folders.size();
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                localMediaFolder.setChecked(true);
                this.notifyDataSetChanged();
                this.onAlbumItemClickListener.onItemClick(n, localMediaFolder.isCameraFolder(), localMediaFolder.getBucketId(), localMediaFolder.getName(), localMediaFolder.getData());
                return;
            }
            this.folders.get(n3).setChecked(false);
            ++n3;
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int n) {
        LocalMediaFolder localMediaFolder = this.folders.get(n);
        String string2 = localMediaFolder.getName();
        int n2 = localMediaFolder.getImageNum();
        String string3 = localMediaFolder.getFirstImagePath();
        boolean bl = localMediaFolder.isChecked();
        int n3 = localMediaFolder.getCheckedNum();
        TextView textView = viewHolder.tvSign;
        n3 = n3 > 0 ? 0 : 4;
        textView.setVisibility(n3);
        viewHolder.itemView.setSelected(bl);
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_album_backgroundStyle != 0) {
                viewHolder.itemView.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_album_backgroundStyle);
            }
        } else if (PictureSelectionConfig.style != null && PictureSelectionConfig.style.pictureAlbumStyle != 0) {
            viewHolder.itemView.setBackgroundResource(PictureSelectionConfig.style.pictureAlbumStyle);
        }
        if (this.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder.ivFirstImage.setImageResource(R.drawable.picture_audio_placeholder);
        } else if (PictureSelectionConfig.imageEngine != null) {
            PictureSelectionConfig.imageEngine.loadFolderImage(viewHolder.itemView.getContext(), string3, viewHolder.ivFirstImage);
        }
        textView = viewHolder.itemView.getContext();
        if (localMediaFolder.getOfAllType() != -1) {
            string2 = localMediaFolder.getOfAllType() == PictureMimeType.ofAudio() ? textView.getString(R.string.picture_all_audio) : textView.getString(R.string.picture_camera_roll);
        }
        viewHolder.tvFolderName.setText((CharSequence)textView.getString(R.string.picture_camera_roll_num, new Object[]{string2, n2}));
        viewHolder.itemView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureAlbumDirectoryAdapter.A0GR_Ws1OIsHan7WkWhrO__kt08(this, localMediaFolder, n));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(R.layout.picture_album_folder_item, viewGroup, false));
    }

    public void setChooseMode(int n) {
        this.chooseMode = n;
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.onAlbumItemClickListener = onAlbumItemClickListener;
    }
}
