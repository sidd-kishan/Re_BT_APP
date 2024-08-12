/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  com.yalantis.ucrop.UCropActivity
 *  com.yalantis.ucrop.view.TransformImageView$TransformImageListener
 */
package com.yalantis.ucrop;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateInterpolator;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.TransformImageView;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropActivity.1
implements TransformImageView.TransformImageListener {
    final UCropActivity this$0;

    UCropActivity.1(UCropActivity uCropActivity) {
        this.this$0 = uCropActivity;
    }

    public void onLoadComplete() {
        UCropActivity.access$200((UCropActivity)this.this$0).animate().alpha(1.0f).setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
        this.this$0.mBlockingView.setClickable(UCropActivity.access$300((UCropActivity)this.this$0) ^ true);
        UCropActivity.access$402((UCropActivity)this.this$0, (boolean)false);
        this.this$0.supportInvalidateOptionsMenu();
    }

    public void onLoadFailure(Exception exception) {
        this.this$0.setResultError((Throwable)exception);
        this.this$0.onBackPressed();
    }

    public void onRotate(float f) {
        UCropActivity.access$000((UCropActivity)this.this$0, (float)f);
    }

    public void onScale(float f) {
        UCropActivity.access$100((UCropActivity)this.this$0, (float)f);
    }
}
