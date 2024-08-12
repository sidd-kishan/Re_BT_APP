/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.activity.result.contract.ActivityResultContract;

public static class ActivityResultContracts.TakePicturePreview
extends ActivityResultContract<Void, Bitmap> {
    public Intent createIntent(Context context, Void void_) {
        return new Intent("android.media.action.IMAGE_CAPTURE");
    }

    public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void void_) {
        return null;
    }

    public final Bitmap parseResult(int n, Intent intent) {
        if (intent == null) return null;
        if (n == -1) return (Bitmap)intent.getParcelableExtra("data");
        return null;
    }
}
