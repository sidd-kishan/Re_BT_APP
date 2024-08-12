/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.tasks.zzq
 */
package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.tasks.zzq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzv
extends LifecycleCallback {
    private final List<WeakReference<zzq<?>>> zza = new ArrayList();

    private zzv(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", (LifecycleCallback)this);
    }

    public static zzv zza(Activity object) {
        LifecycleFragment lifecycleFragment = zzv.getFragment((Activity)object);
        zzv zzv2 = (zzv)lifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zzv.class);
        object = zzv2;
        if (zzv2 != null) return object;
        object = new zzv(lifecycleFragment);
        return object;
    }

    public final void onStop() {
        List<WeakReference<zzq<?>>> list = this.zza;
        synchronized (list) {
            try {
                Iterator<WeakReference<zzq<?>>> iterator = this.zza.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.zza.clear();
                        return;
                    }
                    zzq zzq2 = (zzq)iterator.next().get();
                    if (zzq2 == null) continue;
                    zzq2.zzb();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final <T> void zzb(zzq<T> zzq2) {
        List<WeakReference<zzq<?>>> list = this.zza;
        synchronized (list) {
            List<WeakReference<zzq<?>>> list2 = this.zza;
            WeakReference<zzq<T>> weakReference = new WeakReference<zzq<T>>(zzq2);
            list2.add(weakReference);
            return;
        }
    }
}
