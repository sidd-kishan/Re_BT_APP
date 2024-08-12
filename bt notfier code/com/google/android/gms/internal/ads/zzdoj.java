/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzbvr
 *  com.google.android.gms.internal.ads.zzbvs
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdba
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdim
 *  com.google.android.gms.internal.ads.zzdmu
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzbvr;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdba;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdim;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzdoj
implements zzdmu {
    private final zzbvv zza;
    private final zzdbu zzb;
    private final zzdba zzc;
    private final zzdim zzd;
    private final Context zze;
    private final zzezz zzf;
    private final zzcgz zzg;
    private final zzfar zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbvr zzl;
    private final zzbvs zzm;

    public zzdoj(zzbvr zzbvr2, zzbvs zzbvs2, zzbvv zzbvv2, zzdbu zzdbu2, zzdba zzdba2, zzdim zzdim2, Context context, zzezz zzezz2, zzcgz zzcgz2, zzfar zzfar2, byte[] byArray) {
        this.zzl = zzbvr2;
        this.zzm = zzbvs2;
        this.zza = zzbvv2;
        this.zzb = zzdbu2;
        this.zzc = zzdba2;
        this.zzd = zzdim2;
        this.zze = context;
        this.zzf = zzezz2;
        this.zzg = zzcgz2;
        this.zzh = zzfar2;
    }

    private final void zza(View view) {
        try {
            zzbvv zzbvv2 = this.zza;
            if (zzbvv2 != null && !zzbvv2.zzu()) {
                this.zza.zzw(ObjectWrapper.wrap((Object)view));
                this.zzc.onAdClicked();
                view = zzbjl.zzhb;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)view) == false) return;
                this.zzd.zzb();
                return;
            }
            zzbvv2 = this.zzl;
            if (zzbvv2 != null && !zzbvv2.zzq()) {
                this.zzl.zzn(ObjectWrapper.wrap((Object)view));
                this.zzc.onAdClicked();
                view = zzbjl.zzhb;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)view) == false) return;
                this.zzd.zzb();
                return;
            }
            zzbvv2 = this.zzm;
            if (zzbvv2 == null) return;
            if (zzbvv2.zzo()) return;
            this.zzm.zzl(ObjectWrapper.wrap((Object)view));
            this.zzc.onAdClicked();
            view = zzbjl.zzhb;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)view) == false) return;
            this.zzd.zzb();
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to call handleClick", (Throwable)remoteException);
            return;
        }
    }

    private static final HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<String, View>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            try {
                Iterator<Map.Entry<String, WeakReference<View>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, WeakReference<View>> entry = iterator.next();
                    View view = (View)entry.getValue().get();
                    if (view == null) continue;
                    hashMap.put(entry.getKey(), view);
                }
                return hashMap;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zzA() {
    }

    /*
     * Exception decompiling
     */
    public final void zzd(View var1_1, Map<String, WeakReference<View>> var2_5, Map<String, WeakReference<View>> var3_6, View.OnTouchListener var4_7, View.OnClickListener var5_8) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [13 : 290->298)] android.os.RemoteException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final void zze(View view, Map<String, WeakReference<View>> zzbvv2) {
        try {
            view = ObjectWrapper.wrap((Object)view);
            zzbvv2 = this.zza;
            if (zzbvv2 != null) {
                zzbvv2.zzy((IObjectWrapper)view);
                return;
            }
            zzbvv2 = this.zzl;
            if (zzbvv2 != null) {
                zzbvv2.zzs((IObjectWrapper)view);
                return;
            }
            zzbvv2 = this.zzm;
            if (zzbvv2 == null) return;
            zzbvv2.zzq((IObjectWrapper)view);
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to call untrackView", (Throwable)remoteException);
            return;
        }
    }

    public final void zzf(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean bl) {
        if (this.zzj && this.zzf.zzH) {
            return;
        }
        this.zza(view);
    }

    public final void zzg(String string) {
    }

    public final void zzh(Bundle bundle) {
    }

    public final void zzi(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean bl) {
        if (!this.zzj) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!this.zzf.zzH) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
            return;
        }
        this.zza(view);
    }

    public final void zzj() {
        this.zzj = true;
    }

    public final boolean zzk() {
        return this.zzf.zzH;
    }

    public final void zzm(View view, MotionEvent motionEvent, View view2) {
    }

    public final void zzn(Bundle bundle) {
    }

    public final JSONObject zzo(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final JSONObject zzp(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zzq() {
    }

    public final void zzr(View view) {
    }

    public final void zzs(zzbob zzbob2) {
    }

    public final void zzt() {
    }

    public final void zzu(zzbgm zzbgm2) {
        com.google.android.gms.ads.internal.util.zze.zzi((String)"Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzv(zzbgi zzbgi2) {
        com.google.android.gms.ads.internal.util.zze.zzi((String)"Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzw() {
        throw null;
    }

    public final void zzx(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzi) {
                this.zzi = zzt.zzm().zzg(this.zze, this.zzg.zza, this.zzf.zzC.toString(), this.zzh.zzf);
            }
            if (!this.zzk) {
                return;
            }
            view = this.zza;
            if (view != null && !view.zzt()) {
                this.zza.zzv();
                this.zzb.zza();
                return;
            }
            view = this.zzl;
            if (view != null && !view.zzp()) {
                this.zzl.zzm();
                this.zzb.zza();
                return;
            }
            view = this.zzm;
            if (view == null) return;
            if (view.zzn()) return;
            this.zzm.zzk();
            this.zzb.zza();
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to call recordImpression", (Throwable)remoteException);
            return;
        }
    }

    public final void zzy() {
    }

    public final boolean zzz(Bundle bundle) {
        return false;
    }
}
