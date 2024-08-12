/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.internal.zac
 *  com.google.android.gms.dynamic.LifecycleDelegate
 *  com.google.android.gms.dynamic.OnDelegateCreatedListener
 *  com.google.android.gms.dynamic.zaa
 *  com.google.android.gms.dynamic.zab
 *  com.google.android.gms.dynamic.zac
 *  com.google.android.gms.dynamic.zad
 *  com.google.android.gms.dynamic.zae
 *  com.google.android.gms.dynamic.zaf
 *  com.google.android.gms.dynamic.zag
 *  com.google.android.gms.dynamic.zah
 */
package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.dynamic.zaa;
import com.google.android.gms.dynamic.zab;
import com.google.android.gms.dynamic.zac;
import com.google.android.gms.dynamic.zad;
import com.google.android.gms.dynamic.zae;
import com.google.android.gms.dynamic.zaf;
import com.google.android.gms.dynamic.zag;
import com.google.android.gms.dynamic.zah;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    private T zaa;
    private Bundle zab;
    private LinkedList<zah> zac;
    private final OnDelegateCreatedListener<T> zad = new zaa(this);

    public static void showGooglePlayUnavailableMessage(FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int n = googleApiAvailability.isGooglePlayServicesAvailable(context);
        String string = com.google.android.gms.common.internal.zac.zac((Context)context, (int)n);
        String string2 = com.google.android.gms.common.internal.zac.zae((Context)context, (int)n);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView((View)linearLayout);
        frameLayout = new TextView(frameLayout.getContext());
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.setText((CharSequence)string);
        linearLayout.addView((View)frameLayout);
        googleApiAvailability = googleApiAvailability.getErrorResolutionIntent(context, n, null);
        if (googleApiAvailability == null) return;
        frameLayout = new Button(context);
        frameLayout.setId(16908313);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        frameLayout.setText((CharSequence)string2);
        linearLayout.addView((View)frameLayout);
        frameLayout.setOnClickListener((View.OnClickListener)new zae(context, (Intent)googleApiAvailability));
    }

    static /* synthetic */ LifecycleDelegate zaa(DeferredLifecycleHelper deferredLifecycleHelper, LifecycleDelegate lifecycleDelegate) {
        deferredLifecycleHelper.zaa = lifecycleDelegate;
        return lifecycleDelegate;
    }

    static /* synthetic */ LinkedList zab(DeferredLifecycleHelper deferredLifecycleHelper) {
        return deferredLifecycleHelper.zac;
    }

    static /* synthetic */ LifecycleDelegate zac(DeferredLifecycleHelper deferredLifecycleHelper) {
        return deferredLifecycleHelper.zaa;
    }

    static /* synthetic */ Bundle zad(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        deferredLifecycleHelper.zab = null;
        return null;
    }

    private final void zae(int n) {
        while (!this.zac.isEmpty()) {
            if (this.zac.getLast().zaa() < n) return;
            this.zac.removeLast();
        }
    }

    private final void zaf(Bundle bundle, zah zah2) {
        T t = this.zaa;
        if (t != null) {
            zah2.zab(t);
            return;
        }
        if (this.zac == null) {
            this.zac = new LinkedList();
        }
        this.zac.add(zah2);
        if (bundle != null) {
            zah2 = this.zab;
            if (zah2 == null) {
                this.zab = (Bundle)bundle.clone();
            } else {
                zah2.putAll(bundle);
            }
        }
        this.createDelegate(this.zad);
    }

    protected abstract void createDelegate(OnDelegateCreatedListener<T> var1);

    public T getDelegate() {
        return this.zaa;
    }

    protected void handleGooglePlayUnavailable(FrameLayout frameLayout) {
        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(frameLayout);
    }

    public void onCreate(Bundle bundle) {
        this.zaf(bundle, (zah)new zac(this, bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        this.zaf(bundle, (zah)new zad(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zaa != null) return frameLayout;
        this.handleGooglePlayUnavailable(frameLayout);
        return frameLayout;
    }

    public void onDestroy() {
        T t = this.zaa;
        if (t != null) {
            t.onDestroy();
            return;
        }
        this.zae(1);
    }

    public void onDestroyView() {
        T t = this.zaa;
        if (t != null) {
            t.onDestroyView();
            return;
        }
        this.zae(2);
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        this.zaf(bundle2, (zah)new zab(this, activity, bundle, bundle2));
    }

    public void onLowMemory() {
        T t = this.zaa;
        if (t == null) return;
        t.onLowMemory();
    }

    public void onPause() {
        T t = this.zaa;
        if (t != null) {
            t.onPause();
            return;
        }
        this.zae(5);
    }

    public void onResume() {
        this.zaf(null, (zah)new zag(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        Object object = this.zaa;
        if (object != null) {
            object.onSaveInstanceState(bundle);
            return;
        }
        object = this.zab;
        if (object == null) return;
        bundle.putAll(object);
    }

    public void onStart() {
        this.zaf(null, (zah)new zaf(this));
    }

    public void onStop() {
        T t = this.zaa;
        if (t != null) {
            t.onStop();
            return;
        }
        this.zae(4);
    }
}
