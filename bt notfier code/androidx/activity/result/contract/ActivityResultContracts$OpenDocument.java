/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public static class ActivityResultContracts.OpenDocument
extends ActivityResultContract<String[], Uri> {
    public Intent createIntent(Context context, String[] stringArray) {
        return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", stringArray).setType("*/*");
    }

    public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] stringArray) {
        return null;
    }

    public final Uri parseResult(int n, Intent intent) {
        if (intent == null) return null;
        if (n == -1) return intent.getData();
        return null;
    }
}
