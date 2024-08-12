/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.IntentSenderRequest
 *  androidx.activity.result.contract.ActivityResultContract
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;

public static final class ActivityResultContracts.StartIntentSenderForResult
extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
    public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
    public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
    public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

    public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
        return new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, (Parcelable)intentSenderRequest);
    }

    public ActivityResult parseResult(int n, Intent intent) {
        return new ActivityResult(n, intent);
    }
}
