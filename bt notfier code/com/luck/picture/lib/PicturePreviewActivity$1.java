/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.luck.picture.lib.PicturePreviewActivity
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib;

import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.ValueOf;

/*
 * Exception performing whole class analysis ignored.
 */
class PicturePreviewActivity.1
implements ViewPager.OnPageChangeListener {
    final PicturePreviewActivity this$0;

    PicturePreviewActivity.1(PicturePreviewActivity picturePreviewActivity) {
        this.this$0 = picturePreviewActivity;
    }

    public void onPageScrollStateChanged(int n) {
    }

    public void onPageScrolled(int n, float f, int n2) {
        PicturePreviewActivity picturePreviewActivity = this.this$0;
        PicturePreviewActivity.access$000((PicturePreviewActivity)picturePreviewActivity, (boolean)picturePreviewActivity.config.previewEggs, (int)n, (int)n2);
    }

    public void onPageSelected(int n) {
        PicturePreviewActivity picturePreviewActivity;
        this.this$0.position = n;
        PicturePreviewActivity.access$100((PicturePreviewActivity)this.this$0);
        LocalMedia localMedia = this.this$0.adapter.getItem(this.this$0.position);
        if (localMedia == null) {
            return;
        }
        this.this$0.index = localMedia.getPosition();
        if (!this.this$0.config.previewEggs) {
            if (this.this$0.config.checkNumMode) {
                this.this$0.check.setText((CharSequence)ValueOf.toString((Object)localMedia.getNum()));
                PicturePreviewActivity.access$200((PicturePreviewActivity)this.this$0, (LocalMedia)localMedia);
            }
            picturePreviewActivity = this.this$0;
            picturePreviewActivity.onImageChecked(picturePreviewActivity.position);
        }
        if (this.this$0.config.isOriginalControl) {
            boolean bl = PictureMimeType.isHasVideo((String)localMedia.getMimeType());
            picturePreviewActivity = this.this$0.mCbOriginal;
            n = bl ? 8 : 0;
            picturePreviewActivity.setVisibility(n);
            this.this$0.mCbOriginal.setChecked(this.this$0.config.isCheckOriginalImage);
        }
        this.this$0.onPageSelectedChange(localMedia);
        if (!this.this$0.config.isPageStrategy) return;
        if (this.this$0.isBottomPreview) return;
        if (!this.this$0.isHasMore) return;
        if (this.this$0.position != this.this$0.adapter.getSize() - 1 - 10) {
            if (this.this$0.position != this.this$0.adapter.getSize() - 1) return;
        }
        PicturePreviewActivity.access$300((PicturePreviewActivity)this.this$0);
    }
}
