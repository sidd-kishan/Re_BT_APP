/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  androidx.activity.result.contract.ActivityResultContract
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public static final class ActivityResultContracts.PickContact
extends ActivityResultContract<Void, Uri> {
    public Intent createIntent(Context context, Void void_) {
        return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
    }

    public Uri parseResult(int n, Intent intent) {
        if (intent == null) return null;
        if (n == -1) return intent.getData();
        return null;
    }
}
