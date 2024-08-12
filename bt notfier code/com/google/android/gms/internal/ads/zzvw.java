/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  com.google.android.gms.internal.ads.zzvm
 *  com.google.android.gms.internal.ads.zzvt
 *  com.google.android.gms.internal.ads.zzvv
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwo
 */
package com.google.android.gms.internal.ads;

import android.os.Process;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzvv;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwo;
import java.util.concurrent.BlockingQueue;

public final class zzvw
extends Thread {
    private final BlockingQueue<zzwc<?>> zza;
    private final zzvv zzb;
    private final zzvm zzc;
    private volatile boolean zzd = false;
    private final zzvt zze;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzvw(BlockingQueue blockingQueue, zzvv zzvv2, zzvm zzvm2, zzvt zzvt2, byte[] byArray) {
        this.zza = blockingQueue;
        this.zzb = zzvv2;
        this.zzc = zzvm2;
        this.zze = zzvt2;
    }

    /*
     * Exception decompiling
     */
    private void zzb() throws InterruptedException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [9 : 159->202)] java.lang.Throwable
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

    @Override
    public final void run() {
        Process.setThreadPriority((int)10);
        while (true) {
            try {
                while (true) {
                    this.zzb();
                }
            }
            catch (InterruptedException interruptedException) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzwo.zzc((String)"Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", (Object[])new Object[0]);
                continue;
            }
            break;
        }
    }

    public final void zza() {
        this.zzd = true;
        this.interrupt();
    }
}
