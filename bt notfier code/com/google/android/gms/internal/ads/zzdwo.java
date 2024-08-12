/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbqo
 *  com.google.android.gms.internal.ads.zzdwh
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzdwr
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzdwh;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzdwr;
import java.util.HashMap;
import java.util.Map;

public final class zzdwo
extends zzbqo {
    private final zzdwr zza;
    private final zzdwm zzb;
    private final Map<Long, zzdwh> zzc = new HashMap<Long, zzdwh>();

    zzdwo(zzdwr zzdwr2, zzdwm zzdwm2) {
        this.zza = zzdwr2;
        this.zzb = zzdwm2;
    }

    /*
     * Exception decompiling
     */
    private static zzbdg zzc(Map<String, String> var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zze(String var1_1) throws RemoteException {
        block40: {
            block41: {
                block39: {
                    block38: {
                        var6_4 = zzbjl.zzgJ;
                        if (!((Boolean)zzbet.zzc().zzc((zzbjd)var6_4)).booleanValue()) {
                            return;
                        }
                        var6_4 = String.valueOf(var1_1);
                        var6_4 = var6_4.length() != 0 ? "Received H5 gmsg: ".concat((String)var6_4) : new String("Received H5 gmsg: ");
                        zze.zza((String)var6_4);
                        var1_1 = Uri.parse((String)var1_1);
                        zzt.zzc();
                        var1_1 = zzs.zzR((Uri)var1_1);
                        var7_5 /* !! */  = (String)var1_1.get("action");
                        if (TextUtils.isEmpty((CharSequence)var7_5 /* !! */ )) {
                            zze.zzd((String)"H5 gmsg did not contain an action");
                            return;
                        }
                        var2_6 = var7_5 /* !! */ .hashCode();
                        var3_7 = 0;
                        if (var2_6 == 579053441) break block38;
                        if (var2_6 != 871091088 || !var7_5 /* !! */ .equals("initialize")) ** GOTO lbl-1000
                        var2_6 = 0;
                        break block39;
                    }
                    if (var7_5 /* !! */ .equals("dispose_all")) {
                        var2_6 = 1;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var2_6 = -1;
                    }
                }
                if (var2_6 == 0) {
                    this.zzc.clear();
                    this.zzb.zza();
                    return;
                }
                if (var2_6 == 1) break block40;
                var6_4 = (String)var1_1.get("obj_id");
                try {
                    var6_4.getClass();
                    var4_8 = Long.parseLong((String)var6_4);
                }
                catch (NullPointerException | NumberFormatException var1_2) {
                    var1_3 = String.valueOf(var6_4);
                    var1_3 = var1_3.length() != 0 ? "H5 gmsg did not contain a valid object id: ".concat(var1_3) : new String("H5 gmsg did not contain a valid object id: ");
                    zze.zzd((String)var1_3);
                    return;
                }
                switch (var7_5 /* !! */ .hashCode()) {
                    default: {
                        break;
                    }
                    case 2109237041: {
                        if (!var7_5 /* !! */ .equals("create_rewarded_ad")) break;
                        var2_6 = 3;
                        break block41;
                    }
                    case 1671767583: {
                        if (!var7_5 /* !! */ .equals("dispose")) break;
                        var2_6 = 6;
                        break block41;
                    }
                    case 585513149: {
                        if (!var7_5 /* !! */ .equals("load_interstitial_ad")) break;
                        var2_6 = 1;
                        break block41;
                    }
                    case 393881811: {
                        if (!var7_5 /* !! */ .equals("create_interstitial_ad")) break;
                        var2_6 = var3_7;
                        break block41;
                    }
                    case -257098725: {
                        if (!var7_5 /* !! */ .equals("load_rewarded_ad")) break;
                        var2_6 = 4;
                        break block41;
                    }
                    case -1266374734: {
                        if (!var7_5 /* !! */ .equals("show_rewarded_ad")) break;
                        var2_6 = 5;
                        break block41;
                    }
                    case -1790951212: {
                        if (!var7_5 /* !! */ .equals("show_interstitial_ad")) break;
                        var2_6 = 2;
                        break block41;
                    }
                }
                var2_6 = -1;
            }
            switch (var2_6) {
                default: {
                    var1_1 = String.valueOf(var7_5 /* !! */ );
                    var1_1 = var1_1.length() != 0 ? "H5 gmsg contained invalid action: ".concat((String)var1_1) : new String("H5 gmsg contained invalid action: ");
                }
                case 6: {
                    var6_4 = this.zzc;
                    var1_1 = var4_8;
                    var6_4 = (zzdwh)var6_4.get(var1_1);
                    if (var6_4 == null) {
                        zze.zzd((String)"Could not dispose H5 ad, object ID does not exist");
                        return;
                    }
                    var6_4.zzc();
                    this.zzc.remove(var1_1);
                    var1_1 = new StringBuilder(36);
                    var1_1.append("Disposed H5 ad #");
                    var1_1.append(var4_8);
                    zze.zza((String)var1_1.toString());
                    return;
                }
                case 5: {
                    var1_1 = this.zzc.get(var4_8);
                    if (var1_1 == null) {
                        zze.zzd((String)"Could not show H5 ad, object ID does not exist");
                        this.zzb.zzj(var4_8);
                        return;
                    }
                    var1_1.zzb();
                    return;
                }
                case 4: {
                    var6_4 = this.zzc.get(var4_8);
                    if (var6_4 == null) {
                        zze.zzd((String)"Could not load H5 ad, object ID does not exist");
                        this.zzb.zzj(var4_8);
                        return;
                    }
                    var6_4.zza(zzdwo.zzc((Map<String, String>)var1_1));
                    return;
                }
                case 3: {
                    var2_6 = this.zzc.size();
                    var6_4 = zzbjl.zzgK;
                    if (var2_6 >= (Integer)zzbet.zzc().zzc((zzbjd)var6_4)) {
                        zze.zzi((String)"Could not create H5 ad, too many existing objects");
                        this.zzb.zzc(var4_8);
                        return;
                    }
                    var7_5 /* !! */  = this.zzc;
                    var6_4 = var4_8;
                    if (var7_5 /* !! */ .containsKey(var6_4)) {
                        zze.zzd((String)"Could not create H5 ad, object ID already exists");
                        this.zzb.zzc(var4_8);
                        return;
                    }
                    if (TextUtils.isEmpty((CharSequence)(var1_1 = (String)var1_1.get("ad_unit")))) {
                        zze.zzi((String)"Could not create H5 ad, missing ad unit id");
                        this.zzb.zzc(var4_8);
                        return;
                    }
                    var7_5 /* !! */  = this.zza.zzd();
                    var7_5 /* !! */ .zzc(var4_8);
                    var7_5 /* !! */ .zzb((String)var1_1);
                    var7_5 /* !! */  = var7_5 /* !! */ .zza().zzb();
                    this.zzc.put((Long)var6_4, (zzdwh)var7_5 /* !! */ );
                    this.zzb.zzb(var4_8);
                    var6_4 = new StringBuilder(String.valueOf(var1_1).length() + 55);
                    var6_4.append("Created H5 rewarded #");
                    var6_4.append(var4_8);
                    var6_4.append(" with ad unit ");
                    var6_4.append((String)var1_1);
                    zze.zza((String)var6_4.toString());
                    return;
                }
                case 2: {
                    var1_1 = this.zzc.get(var4_8);
                    if (var1_1 == null) {
                        zze.zzd((String)"Could not show H5 ad, object ID does not exist");
                        this.zzb.zzd(var4_8);
                        return;
                    }
                    var1_1.zzb();
                    return;
                }
                case 1: {
                    var6_4 = this.zzc.get(var4_8);
                    if (var6_4 == null) {
                        zze.zzd((String)"Could not load H5 ad, object ID does not exist");
                        this.zzb.zzd(var4_8);
                        return;
                    }
                    var6_4.zza(zzdwo.zzc((Map<String, String>)var1_1));
                    return;
                }
                case 0: {
                    var2_6 = this.zzc.size();
                    var6_4 = zzbjl.zzgK;
                    if (var2_6 >= (Integer)zzbet.zzc().zzc((zzbjd)var6_4)) {
                        zze.zzi((String)"Could not create H5 ad, too many existing objects");
                        this.zzb.zzc(var4_8);
                        return;
                    }
                    var7_5 /* !! */  = this.zzc;
                    var6_4 = var4_8;
                    if (var7_5 /* !! */ .containsKey(var6_4)) {
                        zze.zzd((String)"Could not create H5 ad, object ID already exists");
                        this.zzb.zzc(var4_8);
                        return;
                    }
                    if (TextUtils.isEmpty((CharSequence)(var1_1 = (String)var1_1.get("ad_unit")))) {
                        zze.zzi((String)"Could not create H5 ad, missing ad unit id");
                        this.zzb.zzc(var4_8);
                        return;
                    }
                    var7_5 /* !! */  = this.zza.zzd();
                    var7_5 /* !! */ .zzc(var4_8);
                    var7_5 /* !! */ .zzb((String)var1_1);
                    var7_5 /* !! */  = var7_5 /* !! */ .zza().zza();
                    this.zzc.put((Long)var6_4, (zzdwh)var7_5 /* !! */ );
                    this.zzb.zzb(var4_8);
                    var6_4 = new StringBuilder(String.valueOf(var1_1).length() + 59);
                    var6_4.append("Created H5 interstitial #");
                    var6_4.append(var4_8);
                    var6_4.append(" with ad unit ");
                    var6_4.append((String)var1_1);
                    zze.zza((String)var6_4.toString());
                    return;
                }
            }
            zze.zzd((String)var1_1);
            return;
        }
        var1_1 = this.zzc.values().iterator();
        while (true) {
            if (!var1_1.hasNext()) {
                this.zzc.clear();
                return;
            }
            var1_1.next().zzc();
        }
    }

    public final void zzf() {
        this.zzc.clear();
    }
}
