/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.yalantis.ucrop.UCropActivity
 *  com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$ScrollingListener
 */
package com.yalantis.ucrop;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropActivity.3
implements HorizontalProgressWheelView.ScrollingListener {
    final UCropActivity this$0;

    UCropActivity.3(UCropActivity uCropActivity) {
        this.this$0 = uCropActivity;
    }

    public void onScroll(float f, float f2) {
        UCropActivity.access$500((UCropActivity)this.this$0).postRotate(f / 42.0f);
    }

    public void onScrollEnd() {
        UCropActivity.access$500((UCropActivity)this.this$0).setImageToWrapCropBounds();
    }

    public void onScrollStart() {
        UCropActivity.access$500((UCropActivity)this.this$0).cancelAllAnimations();
    }
}
