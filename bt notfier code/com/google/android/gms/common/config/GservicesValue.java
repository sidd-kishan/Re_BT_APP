/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.config.zza
 *  com.google.android.gms.common.config.zzb
 *  com.google.android.gms.common.config.zzc
 *  com.google.android.gms.common.config.zzd
 *  com.google.android.gms.common.config.zze
 */
package com.google.android.gms.common.config;

import android.util.Log;
import com.google.android.gms.common.config.zza;
import com.google.android.gms.common.config.zzb;
import com.google.android.gms.common.config.zzc;
import com.google.android.gms.common.config.zzd;
import com.google.android.gms.common.config.zze;

public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final T zzb;
    private T zzd = null;

    protected GservicesValue(String string, T t) {
        this.zza = string;
        this.zzb = t;
    }

    public static boolean isInitialized() {
        Object object = zzc;
        synchronized (object) {
            return false;
        }
    }

    public static GservicesValue<Float> value(String string, Float f) {
        return new zzd(string, f);
    }

    public static GservicesValue<Integer> value(String string, Integer n) {
        return new zzc(string, n);
    }

    public static GservicesValue<Long> value(String string, Long l) {
        return new zzb(string, l);
    }

    public static GservicesValue<String> value(String string, String string2) {
        return new zze(string, string2);
    }

    public static GservicesValue<Boolean> value(String string, boolean bl) {
        return new zza(string, Boolean.valueOf(bl));
    }

    /*
     * Exception decompiling
     */
    public final T get() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [4 : 61->65)] java.lang.Throwable
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

    @Deprecated
    public final T getBinderSafe() {
        return this.get();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void override(T object) {
        Log.w((String)"GservicesValue", (String)"GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = object;
        object = zzc;
        // MONITORENTER : object
        Object object2 = zzc;
        // MONITORENTER : object2
        // MONITOREXIT : object2
        // MONITOREXIT : object
    }

    public void resetOverride() {
        this.zzd = null;
    }

    protected abstract T zza(String var1);
}
