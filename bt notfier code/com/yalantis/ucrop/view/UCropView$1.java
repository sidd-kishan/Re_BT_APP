/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.yalantis.ucrop.callback.CropBoundsChangeListener
 *  com.yalantis.ucrop.view.UCropView
 */
package com.yalantis.ucrop.view;

import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.view.UCropView;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropView.1
implements CropBoundsChangeListener {
    final UCropView this$0;

    UCropView.1(UCropView uCropView) {
        this.this$0 = uCropView;
    }

    public void onCropAspectRatioChanged(float f) {
        UCropView.access$000((UCropView)this.this$0).setTargetAspectRatio(f);
    }
}
