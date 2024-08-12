/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter$ViewHolder
 */
package com.yalantis.ucrop;

import android.view.View;
import com.yalantis.ucrop.PicturePhotoGalleryAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
class PicturePhotoGalleryAdapter.1
implements View.OnClickListener {
    final PicturePhotoGalleryAdapter this$0;
    final PicturePhotoGalleryAdapter.ViewHolder val$holder;

    PicturePhotoGalleryAdapter.1(PicturePhotoGalleryAdapter picturePhotoGalleryAdapter, PicturePhotoGalleryAdapter.ViewHolder viewHolder) {
        this.this$0 = picturePhotoGalleryAdapter;
        this.val$holder = viewHolder;
    }

    public void onClick(View view) {
        if (PicturePhotoGalleryAdapter.access$000((PicturePhotoGalleryAdapter)this.this$0) == null) return;
        PicturePhotoGalleryAdapter.access$000((PicturePhotoGalleryAdapter)this.this$0).onItemClick(this.val$holder.getAbsoluteAdapterPosition(), view);
    }
}
