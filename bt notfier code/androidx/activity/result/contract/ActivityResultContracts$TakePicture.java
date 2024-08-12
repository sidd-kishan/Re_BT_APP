/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Parcelable
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;

public static class ActivityResultContracts.TakePicture
extends ActivityResultContract<Uri, Boolean> {
    public Intent createIntent(Context context, Uri uri) {
        return new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", (Parcelable)uri);
    }

    public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
        return null;
    }

    public final Boolean parseResult(int n, Intent intent) {
        boolean bl = n == -1;
        return bl;
    }
}
