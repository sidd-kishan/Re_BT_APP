/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;

public static class ActivityResultContracts.OpenDocumentTree
extends ActivityResultContract<Uri, Uri> {
    public Intent createIntent(Context context, Uri uri) {
        context = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        if (Build.VERSION.SDK_INT < 26) return context;
        if (uri == null) return context;
        context.putExtra("android.provider.extra.INITIAL_URI", (Parcelable)uri);
        return context;
    }

    public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri uri) {
        return null;
    }

    public final Uri parseResult(int n, Intent intent) {
        if (intent == null) return null;
        if (n == -1) return intent.getData();
        return null;
    }
}
