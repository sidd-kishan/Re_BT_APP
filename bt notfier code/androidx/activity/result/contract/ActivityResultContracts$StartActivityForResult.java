/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.contract.ActivityResultContract
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;

public static final class ActivityResultContracts.StartActivityForResult
extends ActivityResultContract<Intent, ActivityResult> {
    public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

    public Intent createIntent(Context context, Intent intent) {
        return intent;
    }

    public ActivityResult parseResult(int n, Intent intent) {
        return new ActivityResult(n, intent);
    }
}
