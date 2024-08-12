/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  com.yalantis.ucrop.callback.OverlayViewChangeListener
 *  com.yalantis.ucrop.view.UCropView
 */
package com.yalantis.ucrop.view;

import android.graphics.RectF;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.view.UCropView;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropView.2
implements OverlayViewChangeListener {
    final UCropView this$0;

    UCropView.2(UCropView uCropView) {
        this.this$0 = uCropView;
    }

    public void onCropRectUpdated(RectF rectF) {
        UCropView.access$100((UCropView)this.this$0).setCropRect(rectF);
    }

    public void postTranslate(float f, float f2) {
        UCropView.access$100((UCropView)this.this$0).postTranslate(f, f2);
    }
}
