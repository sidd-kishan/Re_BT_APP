/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Parcelable
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;

public static class ActivityResultContracts.TakeVideo
extends ActivityResultContract<Uri, Bitmap> {
    public Intent createIntent(Context context, Uri uri) {
        return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", (Parcelable)uri);
    }

    public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri uri) {
        return null;
    }

    public final Bitmap parseResult(int n, Intent intent) {
        if (intent == null) return null;
        if (n == -1) return (Bitmap)intent.getParcelableExtra("data");
        return null;
    }
}
