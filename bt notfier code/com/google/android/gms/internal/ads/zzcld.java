/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcla;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzcld
extends zzcla {
    public static final int zzd = 0;
    private static final Set<String> zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcld(zzcjb object) {
        super((zzcjb)object);
        object = this.zza.getCacheDir();
        if (object == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Context.getCacheDir() returned null");
            return;
        }
        object = new File((File)object, "admobVideoStreams");
        this.zzg = object;
        if (!((File)object).isDirectory() && !this.zzg.mkdirs()) {
            object = String.valueOf(this.zzg.getAbsolutePath());
            object = ((String)object).length() != 0 ? "Could not create preload cache directory at ".concat((String)object) : new String("Could not create preload cache directory at ");
            com.google.android.gms.ads.internal.util.zze.zzi((String)object);
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false)) {
            if (this.zzg.setExecutable(true, false)) return;
        }
        object = ((String)(object = String.valueOf(this.zzg.getAbsolutePath()))).length() != 0 ? "Could not set cache file permissions at ".concat((String)object) : new String("Could not set cache file permissions at ");
        com.google.android.gms.ads.internal.util.zze.zzi((String)object);
        this.zzg = null;
    }

    private final File zza(File file) {
        return new File(this.zzg, String.valueOf(file.getName()).concat(".done"));
    }

    /*
     * Exception decompiling
     */
    public final boolean zzd(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 19[TRYBLOCK] [102 : 2516->2519)] java.lang.Throwable
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

    public final void zzm() {
        this.zzh = true;
    }
}
