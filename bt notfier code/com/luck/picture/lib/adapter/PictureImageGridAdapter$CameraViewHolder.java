/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 */
package com.luck.picture.lib.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;

/*
 * Exception performing whole class analysis ignored.
 */
public class PictureImageGridAdapter.CameraViewHolder
extends RecyclerView.ViewHolder {
    final PictureImageGridAdapter this$0;
    TextView tvCamera;

    public PictureImageGridAdapter.CameraViewHolder(PictureImageGridAdapter object, View view) {
        this.this$0 = object;
        super(view);
        this.tvCamera = (TextView)view.findViewById(R.id.tvCamera);
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_backgroundColor != 0) {
                view.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_backgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize != 0) {
                this.tvCamera.setTextSize((float)PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor != 0) {
                this.tvCamera.setTextColor(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text != 0) {
                this.tvCamera.setText((CharSequence)view.getContext().getString(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text));
            } else {
                view = this.tvCamera;
                object = PictureImageGridAdapter.access$000((PictureImageGridAdapter)object).chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.access$100((PictureImageGridAdapter)object).getString(R.string.picture_tape) : PictureImageGridAdapter.access$100((PictureImageGridAdapter)object).getString(R.string.picture_take_picture);
                view.setText((CharSequence)object);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable == 0) return;
            this.tvCamera.setCompoundDrawablesWithIntrinsicBounds(0, PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable, 0, 0);
        } else {
            view = this.tvCamera;
            object = PictureImageGridAdapter.access$000((PictureImageGridAdapter)object).chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.access$100((PictureImageGridAdapter)object).getString(R.string.picture_tape) : PictureImageGridAdapter.access$100((PictureImageGridAdapter)object).getString(R.string.picture_take_picture);
            view.setText((CharSequence)object);
        }
    }
}
