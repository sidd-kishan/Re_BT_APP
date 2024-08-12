/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Looper
 *  androidx.collection.ArrayMap
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zzc
 *  com.google.android.gms.internal.common.zzh
 */
package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zzc;
import com.google.android.gms.internal.common.zzh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzd
extends Fragment
implements LifecycleFragment {
    private static final WeakHashMap<FragmentActivity, WeakReference<zzd>> zza = new WeakHashMap();
    private final Map<String, LifecycleCallback> zzb = Collections.synchronizedMap(new ArrayMap());
    private int zzc = 0;
    private Bundle zzd;

    public static zzd zza(FragmentActivity fragmentActivity) {
        Object object;
        block7: {
            block6: {
                zzd zzd2;
                object = zza.get(fragmentActivity);
                if (object != null) {
                    if ((object = (zzd)((Object)object.get())) != null) return object;
                }
                try {
                    zzd2 = (zzd)fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                    if (zzd2 == null) break block6;
                    object = zzd2;
                }
                catch (ClassCastException classCastException) {
                    throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", classCastException);
                }
                if (!zzd2.isRemoving()) break block7;
            }
            object = new zzd();
            fragmentActivity.getSupportFragmentManager().beginTransaction().add(object, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
        }
        zza.put(fragmentActivity, new WeakReference<WeakReference<zzd>>((WeakReference<zzd>)object));
        return object;
    }

    static /* synthetic */ int zzb(zzd zzd2) {
        return zzd2.zzc;
    }

    static /* synthetic */ Bundle zzc(zzd zzd2) {
        return zzd2.zzd;
    }

    public final void addCallback(String string, LifecycleCallback object) {
        if (!this.zzb.containsKey(string)) {
            this.zzb.put(string, (LifecycleCallback)object);
            if (this.zzc <= 0) return;
            new zzh(Looper.getMainLooper()).post((Runnable)new zzc(this, (LifecycleCallback)object, string));
            return;
        }
        object = new StringBuilder(String.valueOf(string).length() + 59);
        ((StringBuilder)object).append("LifecycleCallback with tag ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" already added to this fragment.");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public final void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.dump(string, fileDescriptor, printWriter, stringArray);
        Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().dump(string, fileDescriptor, printWriter, stringArray);
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String string, Class<T> clazz) {
        return (T)((LifecycleCallback)clazz.cast(this.zzb.get(string)));
    }

    public final boolean isCreated() {
        if (this.zzc <= 0) return false;
        return true;
    }

    public final boolean isStarted() {
        if (this.zzc < 2) return false;
        return true;
    }

    public final void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onActivityResult(n, n2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzc = 1;
        this.zzd = bundle;
        Iterator<Map.Entry<String, LifecycleCallback>> iterator = this.zzb.entrySet().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            LifecycleCallback lifecycleCallback = object.getValue();
            object = bundle != null ? bundle.getBundle(object.getKey()) : null;
            lifecycleCallback.onCreate(object);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzc = 5;
        Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzc = 3;
        Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        Iterator<Map.Entry<String, LifecycleCallback>> iterator = this.zzb.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, LifecycleCallback> entry = iterator.next();
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzc = 2;
        Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzc = 4;
        Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onStop();
        }
    }
}
