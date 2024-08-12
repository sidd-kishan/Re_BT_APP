/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.luck.picture.lib.PictureExternalPreviewActivity
 *  com.luck.picture.lib.R$string
 */
package com.luck.picture.lib;

import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.R;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureExternalPreviewActivity.1
implements ViewPager.OnPageChangeListener {
    final PictureExternalPreviewActivity this$0;

    PictureExternalPreviewActivity.1(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        this.this$0 = pictureExternalPreviewActivity;
    }

    public void onPageScrollStateChanged(int n) {
    }

    public void onPageScrolled(int n, float f, int n2) {
    }

    public void onPageSelected(int n) {
        PictureExternalPreviewActivity.access$100((PictureExternalPreviewActivity)this.this$0).setText((CharSequence)this.this$0.getString(R.string.picture_preview_image_num, new Object[]{n + 1, PictureExternalPreviewActivity.access$000((PictureExternalPreviewActivity)this.this$0).size()}));
        PictureExternalPreviewActivity.access$202((PictureExternalPreviewActivity)this.this$0, (int)n);
    }
}
