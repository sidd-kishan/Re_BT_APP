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
class UCropActivity.6
implements HorizontalProgressWheelView.ScrollingListener {
    final UCropActivity this$0;

    UCropActivity.6(UCropActivity uCropActivity) {
        this.this$0 = uCropActivity;
    }

    public void onScroll(float f, float f2) {
        if (f > 0.0f) {
            UCropActivity.access$500((UCropActivity)this.this$0).zoomInImage(UCropActivity.access$500((UCropActivity)this.this$0).getCurrentScale() + f * ((UCropActivity.access$500((UCropActivity)this.this$0).getMaxScale() - UCropActivity.access$500((UCropActivity)this.this$0).getMinScale()) / 15000.0f));
        } else {
            UCropActivity.access$500((UCropActivity)this.this$0).zoomOutImage(UCropActivity.access$500((UCropActivity)this.this$0).getCurrentScale() + f * ((UCropActivity.access$500((UCropActivity)this.this$0).getMaxScale() - UCropActivity.access$500((UCropActivity)this.this$0).getMinScale()) / 15000.0f));
        }
    }

    public void onScrollEnd() {
        UCropActivity.access$500((UCropActivity)this.this$0).setImageToWrapCropBounds();
    }

    public void onScrollStart() {
        UCropActivity.access$500((UCropActivity)this.this$0).cancelAllAnimations();
    }
}
