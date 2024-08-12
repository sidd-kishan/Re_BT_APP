/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.content.IntentSender$SendIntentException
 *  android.os.Build
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;

public class GoogleApiActivity
extends Activity
implements DialogInterface.OnCancelListener {
    protected int zaa = 0;

    public static Intent zaa(Context context, PendingIntent pendingIntent, int n, boolean bl) {
        context = new Intent(context, GoogleApiActivity.class);
        context.putExtra("pending_intent", (Parcelable)pendingIntent);
        context.putExtra("failing_client_id", n);
        context.putExtra("notify_manager", bl);
        return context;
    }

    private final void zab() {
        Object object = this.getIntent().getExtras();
        if (object == null) {
            Log.e((String)"GoogleApiActivity", (String)"Activity started without extras");
            this.finish();
            return;
        }
        Object object2 = (PendingIntent)object.get("pending_intent");
        Integer n = (Integer)object.get("error_code");
        if (object2 == null && n == null) {
            Log.e((String)"GoogleApiActivity", (String)"Activity started without resolution");
            this.finish();
            return;
        }
        if (object2 == null) {
            int n2 = (Integer)Preconditions.checkNotNull((Object)n);
            GoogleApiAvailability.getInstance().showErrorDialogFragment((Activity)this, n2, 2, (DialogInterface.OnCancelListener)this);
            this.zaa = 1;
            return;
        }
        try {
            this.startIntentSenderForResult(object2.getIntentSender(), 1, null, 0, 0, 0);
            this.zaa = 1;
            return;
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            Log.e((String)"GoogleApiActivity", (String)"Failed to launch pendingIntent", (Throwable)sendIntentException);
            this.finish();
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            if (object.getBoolean("notify_manager", true)) {
                GoogleApiManager.zaa((Context)this).zaq(new ConnectionResult(22, null), this.getIntent().getIntExtra("failing_client_id", -1));
            } else {
                object = String.valueOf(object2);
                object2 = new StringBuilder(String.valueOf(object).length() + 36);
                ((StringBuilder)object2).append("Activity not found while launching ");
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(".");
                object2 = ((StringBuilder)object2).toString();
                object = object2;
                if (Build.FINGERPRINT.contains("generic")) {
                    object = String.valueOf(object2).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                }
                Log.e((String)"GoogleApiActivity", (String)object, (Throwable)activityNotFoundException);
            }
            this.zaa = 1;
            this.finish();
            return;
        }
    }

    protected final void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 1) {
            boolean bl = this.getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            this.setResult(n2, intent);
            if (bl) {
                intent = GoogleApiManager.zaa((Context)this);
                if (n2 != -1) {
                    if (n2 == 0) {
                        intent.zaq(new ConnectionResult(13, null), this.getIntent().getIntExtra("failing_client_id", -1));
                    }
                } else {
                    intent.zai();
                }
            }
        } else if (n == 2) {
            this.zaa = 0;
            this.setResult(n2, intent);
        }
        this.finish();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zaa = 0;
        this.setResult(0);
        this.finish();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa == 1) return;
        this.zab();
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
    }
}
