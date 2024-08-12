/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 *  com.google.android.gms.internal.ads.zzavk
 */
package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.gms.internal.ads.zzavk;

final class zzavi
extends HandlerThread
implements SurfaceTexture.OnFrameAvailableListener,
Handler.Callback {
    private final int[] zza = new int[1];
    private Handler zzb;
    private SurfaceTexture zzc;
    private Error zzd;
    private RuntimeException zze;
    private zzavk zzf;

    public zzavi() {
        super("dummySurface");
    }

    /*
     * Exception decompiling
     */
    public final boolean handleMessage(Message var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 12[TRYBLOCK] [42 : 625->639)] java.lang.Throwable
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

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzb.sendEmptyMessage(2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final zzavk zza(boolean bl) {
        this.start();
        this.zzb = new Handler(this.getLooper(), (Handler.Callback)this);
        synchronized (this) {
            Object object = this.zzb;
            boolean bl2 = false;
            object.obtainMessage(1, bl ? 1 : 0, 0).sendToTarget();
            bl = bl2;
            while (this.zzf == null && this.zze == null && (object = this.zzd) == null) {
                try {
                    ((Object)((Object)this)).wait();
                }
                catch (InterruptedException interruptedException) {
                    bl = true;
                }
            }
            // MONITOREXIT @DISABLED, blocks:[0, 3] lbl16 : MonitorExitStatement: MONITOREXIT : this
            if (bl) {
                Thread.currentThread().interrupt();
            }
            if ((object = this.zze) != null) throw object;
            object = this.zzd;
            if (object != null) throw object;
            return this.zzf;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
    }

    public final void zzb() {
        this.zzb.sendEmptyMessage(3);
    }
}
