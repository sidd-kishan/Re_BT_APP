/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.yalantis.ucrop.PictureMultiCuttingActivity
 *  com.yalantis.ucrop.UCropActivity
 *  com.yalantis.ucrop.callback.BitmapCropCallback
 */
package com.yalantis.ucrop;

import android.net.Uri;
import com.yalantis.ucrop.PictureMultiCuttingActivity;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.callback.BitmapCropCallback;

/*
 * Exception performing whole class analysis ignored.
 */
class UCropActivity.8
implements BitmapCropCallback {
    final UCropActivity this$0;

    UCropActivity.8(UCropActivity uCropActivity) {
        this.this$0 = uCropActivity;
    }

    public void onBitmapCropped(Uri uri, int n, int n2, int n3, int n4) {
        UCropActivity uCropActivity = this.this$0;
        uCropActivity.setResultUri(uri, UCropActivity.access$500((UCropActivity)uCropActivity).getTargetAspectRatio(), n, n2, n3, n4);
        if (this.this$0.getCurrentActivity() instanceof PictureMultiCuttingActivity) return;
        this.this$0.onBackPressed();
    }

    public void onCropFailure(Throwable throwable) {
        this.this$0.setResultError(throwable);
        this.this$0.onBackPressed();
    }
}
