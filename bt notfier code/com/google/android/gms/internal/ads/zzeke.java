/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblc
 *  com.google.android.gms.internal.ads.zzdtm
 *  com.google.android.gms.internal.ads.zzekb
 *  com.google.android.gms.internal.ads.zzekc
 *  com.google.android.gms.internal.ads.zzekd
 *  com.google.android.gms.internal.ads.zzekg
 *  com.google.android.gms.internal.ads.zzeki
 *  com.google.android.gms.internal.ads.zzfon
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzdtm;
import com.google.android.gms.internal.ads.zzekb;
import com.google.android.gms.internal.ads.zzekc;
import com.google.android.gms.internal.ads.zzekd;
import com.google.android.gms.internal.ads.zzekg;
import com.google.android.gms.internal.ads.zzeki;
import com.google.android.gms.internal.ads.zzfon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzeke {
    private final Map<String, zzekg> zza = new HashMap<String, zzekg>();
    private final Map<String, zzeki> zzb = new HashMap<String, zzeki>();
    private final Map<String, Map<String, List<zzekg>>> zzc = new HashMap<String, Map<String, List<zzekg>>>();
    private final Executor zzd;
    private JSONObject zze;

    public zzeke(Executor executor) {
        this.zzd = executor;
    }

    private final void zzg() {
        synchronized (this) {
            this.zzb.clear();
            this.zza.clear();
            this.zzi();
            this.zzh();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzh() {
        synchronized (this) {
            if ((Boolean)zzblc.zze.zze() != false) return;
            zzbjd zzbjd2 = zzbjl.zzbh;
            if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) return;
            zzbjd2 = zzt.zzg().zzp().zzn().zzg();
            if (zzbjd2 == null) {
                return;
            }
            JSONArray jSONArray = zzbjd2.getJSONArray("signal_adapters");
            int n = 0;
            while (n < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(n);
                zzbjd2 = zzeke.zzl(jSONObject.optJSONObject("data"));
                String string = jSONObject.optString("adapter_class_name");
                boolean bl = jSONObject.optBoolean("render", false);
                boolean bl2 = jSONObject.optBoolean("collect_signals", false);
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    Map<String, zzeki> map = this.zzb;
                    jSONObject = new zzeki(string, bl2, bl, (Bundle)zzbjd2);
                    map.put(string, (zzeki)jSONObject);
                }
                ++n;
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private final void zzi() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    /*
     * Enabled unnecessary exception pruning
     */
    private final List<zzekg> zzj(JSONObject object, String string) {
        synchronized (this) {
            String string2;
            int n;
            ArrayList<zzekg> arrayList = new ArrayList<zzekg>();
            if (object == null) {
                return arrayList;
            }
            Bundle bundle = zzeke.zzl(object.optJSONObject("data"));
            JSONArray jSONArray = object.optJSONArray("rtb_adapters");
            if (jSONArray == null) {
                return arrayList;
            }
            object = new ArrayList();
            int n2 = 0;
            for (n = 0; n < jSONArray.length(); ++n) {
                string2 = jSONArray.optString(n, "");
                if (TextUtils.isEmpty((CharSequence)string2)) continue;
                object.add(string2);
            }
            int n3 = object.size();
            n = n2;
            while (n < n3) {
                string2 = (String)object.get(n);
                this.zzd(string2);
                if (this.zza.get(string2) != null) {
                    jSONArray = new zzekg(string2, string, bundle);
                    arrayList.add((zzekg)jSONArray);
                }
                ++n;
            }
            return arrayList;
        }
    }

    private final void zzk(String arrayList, String string, List<zzekg> list) {
        synchronized (this) {
            if (TextUtils.isEmpty((CharSequence)((Object)arrayList))) return;
            if (TextUtils.isEmpty((CharSequence)string)) return;
            Object object = this.zzc.get(arrayList);
            HashMap<String, ArrayList<zzekg>> hashMap = object;
            if (object == null) {
                hashMap = new HashMap<String, ArrayList<zzekg>>();
            }
            this.zzc.put((String)((Object)arrayList), hashMap);
            object = (List)hashMap.get(string);
            arrayList = object;
            if (object == null) {
                arrayList = new ArrayList<zzekg>();
            }
            arrayList.addAll(list);
            hashMap.put(string, arrayList);
            return;
        }
    }

    private static final Bundle zzl(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject == null) return bundle;
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            bundle.putString(string, jSONObject.optString(string, ""));
        }
        return bundle;
    }

    public final void zza() {
        zzt.zzg().zzp().zzp((Runnable)new zzekb(this));
        this.zzd.execute((Runnable)new zzekc(this));
    }

    public final Map<String, zzeki> zzb() {
        synchronized (this) {
            zzfon zzfon2 = zzfon.zzb(this.zzb);
            return zzfon2;
        }
    }

    public final Map<String, List<Bundle>> zzc(String zzfon2, String object) {
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty((CharSequence)zzfon2) && !TextUtils.isEmpty((CharSequence)object)) {
                    Object object2;
                    Object object3 = this.zzc.get(zzfon2);
                    if (object3 == null) {
                        zzfon2 = zzfon.zza();
                        return zzfon2;
                    }
                    zzekg zzekg2 = object2 = object3.get(object);
                    if (object2 == null) {
                        zzekg2 = object3.get(zzdtm.zza((JSONObject)this.zze, (String)object, (String)zzfon2));
                    }
                    if (zzekg2 == null) {
                        zzfon2 = zzfon.zza();
                        return zzfon2;
                    }
                    zzfon2 = new HashMap();
                    object = zzekg2.iterator();
                    while (true) {
                        if (!object.hasNext()) {
                            zzfon2 = zzfon.zzb(zzfon2);
                            return zzfon2;
                        }
                        zzekg2 = (zzekg)object.next();
                        object3 = zzekg2.zza;
                        if (!zzfon2.containsKey(object3)) {
                            object2 = new ArrayList();
                            zzfon2.put(object3, object2);
                        }
                        ((List)zzfon2.get(object3)).add(zzekg2.zzc);
                    }
                }
                zzfon2 = zzfon.zza();
                return zzfon2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzd(String string) {
        synchronized (this) {
            boolean bl = TextUtils.isEmpty((CharSequence)string);
            if (bl) {
                return;
            }
            bl = this.zza.containsKey(string);
            if (bl) {
                return;
            }
            Map<String, zzekg> map = this.zza;
            Bundle bundle = new Bundle();
            zzekg zzekg2 = new zzekg(string, "", bundle);
            map.put(string, zzekg2);
            return;
        }
    }

    final /* synthetic */ void zze() {
        this.zzd.execute((Runnable)new zzekd(this));
    }
}
