/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContextWrapper
 *  androidx.fragment.app.FragmentActivity
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;

public class LifecycleActivity {
    private final Object zza;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull((Object)activity, (Object)"Activity must not be null");
        this.zza = activity;
    }

    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public Activity asActivity() {
        return (Activity)this.zza;
    }

    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity)this.zza;
    }

    public Object asObject() {
        return this.zza;
    }

    public boolean isChimera() {
        return false;
    }

    public boolean isSupport() {
        return this.zza instanceof FragmentActivity;
    }

    public final boolean zza() {
        return this.zza instanceof Activity;
    }
}
