/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 */
package com.luck.picture.lib.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BroadcastManager {
    private static final String TAG = BroadcastManager.class.getSimpleName();
    private String action;
    private Intent intent;
    private LocalBroadcastManager localBroadcastManager;

    private void createIntent() {
        if (this.intent == null) {
            Log.d((String)TAG, (String)"intent is not created");
        }
        if (this.intent != null) return;
        if (!TextUtils.isEmpty((CharSequence)this.action)) {
            this.intent = new Intent(this.action);
        }
        Log.d((String)TAG, (String)"intent created with action");
    }

    public static BroadcastManager getInstance(Context context) {
        BroadcastManager broadcastManager = new BroadcastManager();
        broadcastManager.localBroadcastManager = LocalBroadcastManager.getInstance((Context)context.getApplicationContext());
        return broadcastManager;
    }

    public BroadcastManager action(String string) {
        this.action = string;
        return this;
    }

    public void broadcast() {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            return;
        }
        String string = this.action;
        if (string == null) {
            return;
        }
        intent.setAction(string);
        intent = this.localBroadcastManager;
        if (intent == null) return;
        intent.sendBroadcast(this.intent);
    }

    public BroadcastManager extras(Bundle bundle) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtras(bundle);
        return this;
    }

    public BroadcastManager intent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public BroadcastManager put(String string, double d) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, d);
        return this;
    }

    public BroadcastManager put(String string, float f) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, f);
        return this;
    }

    public BroadcastManager put(String string, int n) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, n);
        return this;
    }

    public BroadcastManager put(String string, long l) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, l);
        return this;
    }

    public BroadcastManager put(String string, Parcelable parcelable) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, parcelable);
        return this;
    }

    public BroadcastManager put(String string, String string2) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, string2);
        return this;
    }

    public BroadcastManager put(String string, ArrayList<? extends Parcelable> arrayList) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, arrayList);
        return this;
    }

    public BroadcastManager put(String string, boolean bl) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, bl);
        return this;
    }

    public BroadcastManager put(String string, Parcelable[] parcelableArray) {
        this.createIntent();
        Intent intent = this.intent;
        if (intent == null) {
            Log.e((String)TAG, (String)"intent create failed");
            return this;
        }
        intent.putExtra(string, parcelableArray);
        return this;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, List<String> object) {
        if (broadcastReceiver == null) return;
        if (object == null) return;
        IntentFilter intentFilter = new IntentFilter();
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                intentFilter.addAction((String)object.next());
            }
        }
        if ((object = this.localBroadcastManager) == null) return;
        object.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, String ... stringArray) {
        if (stringArray == null) return;
        if (stringArray.length <= 0) return;
        this.registerReceiver(broadcastReceiver, Arrays.asList(stringArray));
    }

    /*
     * Enabled force condition propagation
     */
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            this.localBroadcastManager.unregisterReceiver(broadcastReceiver);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver, String ... stringArray) {
        this.unregisterReceiver(broadcastReceiver);
    }
}
