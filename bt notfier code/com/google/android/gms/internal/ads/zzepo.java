/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Debug
 *  android.os.Debug$MemoryInfo
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzepq
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Debug;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzepq;
import java.util.concurrent.Callable;

final class zzepo
implements Callable {
    static final Callable zza = new zzepo();

    private zzepo() {
    }

    public final Object call() {
        Bundle bundle = new Bundle();
        Object object = zzbjl.zzE;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            object = new Debug.MemoryInfo();
            Debug.getMemoryInfo((Debug.MemoryInfo)object);
            bundle.putString("debug_info_dalvik_private_dirty", Integer.toString(((Debug.MemoryInfo)object).dalvikPrivateDirty));
            bundle.putString("debug_info_dalvik_pss", Integer.toString(((Debug.MemoryInfo)object).dalvikPss));
            bundle.putString("debug_info_dalvik_shared_dirty", Integer.toString(((Debug.MemoryInfo)object).dalvikSharedDirty));
            bundle.putString("debug_info_native_private_dirty", Integer.toString(((Debug.MemoryInfo)object).nativePrivateDirty));
            bundle.putString("debug_info_native_pss", Integer.toString(((Debug.MemoryInfo)object).nativePss));
            bundle.putString("debug_info_native_shared_dirty", Integer.toString(((Debug.MemoryInfo)object).nativeSharedDirty));
            bundle.putString("debug_info_other_private_dirty", Integer.toString(((Debug.MemoryInfo)object).otherPrivateDirty));
            bundle.putString("debug_info_other_pss", Integer.toString(((Debug.MemoryInfo)object).otherPss));
            bundle.putString("debug_info_other_shared_dirty", Integer.toString(((Debug.MemoryInfo)object).otherSharedDirty));
        }
        object = Runtime.getRuntime();
        bundle.putLong("runtime_free", ((Runtime)object).freeMemory());
        bundle.putLong("runtime_max", ((Runtime)object).maxMemory());
        bundle.putLong("runtime_total", ((Runtime)object).totalMemory());
        bundle.putInt("web_view_count", zzt.zzg().zzo());
        return new zzepq(bundle);
    }
}
