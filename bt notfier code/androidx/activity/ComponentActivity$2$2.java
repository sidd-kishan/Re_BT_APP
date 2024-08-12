/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.IntentSender$SendIntentException
 *  androidx.activity.ComponentActivity$2
 */
package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity;
import java.io.Serializable;

class ComponentActivity.2
implements Runnable {
    final ComponentActivity.2 this$1;
    final IntentSender.SendIntentException val$e;
    final int val$requestCode;

    ComponentActivity.2(ComponentActivity.2 var1_1, int n, IntentSender.SendIntentException sendIntentException) {
        this.this$1 = var1_1;
        this.val$requestCode = n;
        this.val$e = sendIntentException;
    }

    @Override
    public void run() {
        this.this$1.dispatchResult(this.val$requestCode, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (Serializable)this.val$e));
    }
}
