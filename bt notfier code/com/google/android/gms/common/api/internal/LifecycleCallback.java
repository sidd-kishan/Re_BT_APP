/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.os.Bundle
 *  androidx.fragment.app.FragmentActivity
 *  com.google.android.gms.common.api.internal.LifecycleActivity
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zzb
 *  com.google.android.gms.common.api.internal.zzd
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zzb;
import com.google.android.gms.common.api.internal.zzd;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    protected final LifecycleFragment mLifecycleFragment;

    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public static LifecycleFragment getFragment(Activity activity) {
        return LifecycleCallback.getFragment(new LifecycleActivity(activity));
    }

    public static LifecycleFragment getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    protected static LifecycleFragment getFragment(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.isSupport()) {
            return zzd.zza((FragmentActivity)lifecycleActivity.asFragmentActivity());
        }
        if (!lifecycleActivity.zza()) throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
        return zzb.zza((Activity)lifecycleActivity.asActivity());
    }

    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public Activity getActivity() {
        return this.mLifecycleFragment.getLifecycleActivity();
    }

    public void onActivityResult(int n, int n2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
