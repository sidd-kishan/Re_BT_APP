/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvm
 *  com.google.android.gms.internal.ads.zzwo
 *  com.google.android.gms.internal.ads.zzwu
 *  com.google.android.gms.internal.ads.zzwv
 *  com.google.android.gms.internal.ads.zzww
 *  com.google.android.gms.internal.ads.zzwx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzwo;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzwv;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzwx;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzwy
implements zzvm {
    private final Map<String, zzwv> zza = new LinkedHashMap<String, zzwv>(16, 0.75f, true);
    private long zzb = 0L;
    private final zzwx zzc;
    private final int zzd;

    public zzwy(zzwx zzwx2, int n) {
        this.zzc = zzwx2;
        this.zzd = 0x500000;
    }

    public zzwy(File file, int n) {
        this.zzc = new zzwu(this, file);
        this.zzd = 0x1400000;
    }

    static byte[] zzg(zzww object, long l) throws IOException {
        int n;
        long l2 = object.zza();
        if (l >= 0L && l <= l2 && (long)(n = (int)l) == l) {
            byte[] byArray = new byte[n];
            new DataInputStream((InputStream)object).readFully(byArray);
            return byArray;
        }
        object = new StringBuilder(73);
        ((StringBuilder)object).append("streamToBytes length=");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(", maxLength=");
        ((StringBuilder)object).append(l2);
        throw new IOException(((StringBuilder)object).toString());
    }

    static void zzh(OutputStream outputStream, int n) throws IOException {
        outputStream.write(n & 0xFF);
        outputStream.write(n >> 8 & 0xFF);
        outputStream.write(n >> 16 & 0xFF);
        outputStream.write(n >> 24 & 0xFF);
    }

    static int zzi(InputStream inputStream) throws IOException {
        int n = zzwy.zzp(inputStream);
        int n2 = zzwy.zzp(inputStream);
        int n3 = zzwy.zzp(inputStream);
        return zzwy.zzp(inputStream) << 24 | (n | n2 << 8 | n3 << 16);
    }

    static void zzj(OutputStream outputStream, long l) throws IOException {
        outputStream.write((byte)l);
        outputStream.write((byte)(l >>> 8));
        outputStream.write((byte)(l >>> 16));
        outputStream.write((byte)(l >>> 24));
        outputStream.write((byte)(l >>> 32));
        outputStream.write((byte)(l >>> 40));
        outputStream.write((byte)(l >>> 48));
        outputStream.write((byte)(l >>> 56));
    }

    static long zzk(InputStream inputStream) throws IOException {
        return (long)zzwy.zzp(inputStream) & 0xFFL | ((long)zzwy.zzp(inputStream) & 0xFFL) << 8 | ((long)zzwy.zzp(inputStream) & 0xFFL) << 16 | ((long)zzwy.zzp(inputStream) & 0xFFL) << 24 | ((long)zzwy.zzp(inputStream) & 0xFFL) << 32 | ((long)zzwy.zzp(inputStream) & 0xFFL) << 40 | ((long)zzwy.zzp(inputStream) & 0xFFL) << 48 | (0xFFL & (long)zzwy.zzp(inputStream)) << 56;
    }

    static void zzl(OutputStream outputStream, String object) throws IOException {
        object = ((String)object).getBytes("UTF-8");
        int n = ((Object)object).length;
        zzwy.zzj(outputStream, n);
        outputStream.write((byte[])object, 0, n);
    }

    static String zzm(zzww zzww2) throws IOException {
        return new String(zzwy.zzg(zzww2, zzwy.zzk((InputStream)zzww2)), "UTF-8");
    }

    private final void zzn(String string, zzwv zzwv2) {
        if (!this.zza.containsKey(string)) {
            this.zzb += zzwv2.zza;
        } else {
            zzwv zzwv3 = this.zza.get(string);
            this.zzb += zzwv2.zza - zzwv3.zza;
        }
        this.zza.put(string, zzwv2);
    }

    private final void zzo(String string) {
        if ((string = this.zza.remove(string)) == null) return;
        this.zzb -= ((zzwv)string).zza;
    }

    private static int zzp(InputStream inputStream) throws IOException {
        int n = inputStream.read();
        if (n == -1) throw new EOFException();
        return n;
    }

    private static final String zzq(String string) {
        int n = string.length() / 2;
        String string2 = String.valueOf(String.valueOf(string.substring(0, n).hashCode()));
        string = (string = String.valueOf(String.valueOf(string.substring(n).hashCode()))).length() != 0 ? string2.concat(string) : new String(string2);
        return string;
    }

    /*
     * Exception decompiling
     */
    public final zzvl zza(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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
     * Exception decompiling
     */
    public final void zzb(String var1_1, zzvl var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[UNCONDITIONALDOLOOP]], but top level block is 6[TRYBLOCK]
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
     * Exception decompiling
     */
    public final void zzc() {
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

    public final void zzd(String string, boolean bl) {
        synchronized (this) {
            zzvl zzvl2 = this.zza(string);
            if (zzvl2 == null) return;
            zzvl2.zzf = 0L;
            zzvl2.zze = 0L;
            this.zzb(string, zzvl2);
            return;
        }
    }

    public final void zze(String string) {
        synchronized (this) {
            boolean bl = this.zzf(string).delete();
            this.zzo(string);
            if (bl) return;
            zzwo.zzb((String)"Could not delete cache entry for key=%s, filename=%s", (Object[])new Object[]{string, zzwy.zzq(string)});
            return;
        }
    }

    public final File zzf(String string) {
        return new File(this.zzc.zza(), zzwy.zzq(string));
    }
}
