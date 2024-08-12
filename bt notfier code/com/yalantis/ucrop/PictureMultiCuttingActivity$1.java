/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.yalantis.ucrop.PictureMultiCuttingActivity
 *  com.yalantis.ucrop.PicturePhotoGalleryAdapter$OnItemClickListener
 */
package com.yalantis.ucrop;

import android.view.View;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.yalantis.ucrop.PictureMultiCuttingActivity;
import com.yalantis.ucrop.PicturePhotoGalleryAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureMultiCuttingActivity.1
implements PicturePhotoGalleryAdapter.OnItemClickListener {
    final PictureMultiCuttingActivity this$0;

    PictureMultiCuttingActivity.1(PictureMultiCuttingActivity pictureMultiCuttingActivity) {
        this.this$0 = pictureMultiCuttingActivity;
    }

    public void onItemClick(int n, View view) {
        if (PictureMimeType.isHasVideo((String)((LocalMedia)PictureMultiCuttingActivity.access$000((PictureMultiCuttingActivity)this.this$0).get(n)).getMimeType())) {
            return;
        }
        if (PictureMultiCuttingActivity.access$100((PictureMultiCuttingActivity)this.this$0) == n) {
            return;
        }
        PictureMultiCuttingActivity.access$200((PictureMultiCuttingActivity)this.this$0);
        PictureMultiCuttingActivity.access$102((PictureMultiCuttingActivity)this.this$0, (int)n);
        view = this.this$0;
        PictureMultiCuttingActivity.access$302((PictureMultiCuttingActivity)view, (int)PictureMultiCuttingActivity.access$100((PictureMultiCuttingActivity)view));
        this.this$0.resetCutData();
    }
}
