/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Intent
 *  android.content.IntentSender
 *  androidx.activity.result.IntentSenderRequest
 */
package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.result.IntentSenderRequest;

public static final class IntentSenderRequest.Builder {
    private Intent mFillInIntent;
    private int mFlagsMask;
    private int mFlagsValues;
    private IntentSender mIntentSender;

    public IntentSenderRequest.Builder(PendingIntent pendingIntent) {
        this(pendingIntent.getIntentSender());
    }

    public IntentSenderRequest.Builder(IntentSender intentSender) {
        this.mIntentSender = intentSender;
    }

    public IntentSenderRequest build() {
        return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
    }

    public IntentSenderRequest.Builder setFillInIntent(Intent intent) {
        this.mFillInIntent = intent;
        return this;
    }

    public IntentSenderRequest.Builder setFlags(int n, int n2) {
        this.mFlagsValues = n;
        this.mFlagsMask = n2;
        return this;
    }
}
