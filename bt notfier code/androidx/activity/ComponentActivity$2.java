/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.activity.ComponentActivity
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.IntentSenderRequest
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 *  androidx.core.app.ActivityCompat
 *  androidx.core.app.ActivityOptionsCompat
 */
package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

class ComponentActivity.2
extends ActivityResultRegistry {
    final ComponentActivity this$0;

    ComponentActivity.2(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public <I, O> void onLaunch(int n, ActivityResultContract<I, O> stringArray, I object, ActivityOptionsCompat activityOptionsCompat) {
        ComponentActivity componentActivity = this.this$0;
        ActivityResultContract.SynchronousResult synchronousResult = stringArray.getSynchronousResult((Context)componentActivity, object);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        object = stringArray.createIntent((Context)componentActivity, object);
        stringArray = null;
        if (object.getExtras() != null && object.getExtras().getClassLoader() == null) {
            object.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (object.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            stringArray = object.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            object.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else if (activityOptionsCompat != null) {
            stringArray = activityOptionsCompat.toBundle();
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(object.getAction())) {
            object = object.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            stringArray = object;
            if (object == null) {
                stringArray = new String[]{};
            }
            ActivityCompat.requestPermissions((Activity)componentActivity, (String[])stringArray, (int)n);
        } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(object.getAction())) {
            object = (IntentSenderRequest)object.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                ActivityCompat.startIntentSenderForResult((Activity)componentActivity, (IntentSender)object.getIntentSender(), (int)n, (Intent)object.getFillInIntent(), (int)object.getFlagsMask(), (int)object.getFlagsValues(), (int)0, (Bundle)stringArray);
            }
            catch (IntentSender.SendIntentException sendIntentException) {
                new Handler(Looper.getMainLooper()).post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            }
        } else {
            ActivityCompat.startActivityForResult((Activity)componentActivity, object, (int)n, (Bundle)stringArray);
        }
    }
}
