/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.IntentSenderRequest
 *  androidx.activity.result.IntentSenderRequest$Builder
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.fragment.app.FragmentManager;

/*
 * Exception performing whole class analysis ignored.
 */
static class FragmentManager.FragmentIntentSenderContract
extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
    FragmentManager.FragmentIntentSenderContract() {
    }

    public Intent createIntent(Context object, IntentSenderRequest intentSenderRequest) {
        Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intent2 = intentSenderRequest.getFillInIntent();
        object = intentSenderRequest;
        if (intent2 != null) {
            Bundle bundle = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            object = intentSenderRequest;
            if (bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                object = intentSenderRequest;
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    object = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent(null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                }
            }
        }
        intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", (Parcelable)object);
        if (!FragmentManager.isLoggingEnabled((int)2)) return intent;
        object = new StringBuilder();
        ((StringBuilder)object).append("CreateIntent created the following intent: ");
        ((StringBuilder)object).append(intent);
        Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
        return intent;
    }

    public ActivityResult parseResult(int n, Intent intent) {
        return new ActivityResult(n, intent);
    }
}
