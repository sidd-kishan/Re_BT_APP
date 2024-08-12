/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.Pair
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzapj
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzapm
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzapo
 *  com.google.android.gms.internal.ads.zzapp
 *  com.google.android.gms.internal.ads.zzapq
 *  com.google.android.gms.internal.ads.zzapt
 *  com.google.android.gms.internal.ads.zzapu
 *  com.google.android.gms.internal.ads.zzapv
 *  com.google.android.gms.internal.ads.zzapw
 *  com.google.android.gms.internal.ads.zzapx
 *  com.google.android.gms.internal.ads.zzaqi
 *  com.google.android.gms.internal.ads.zzaqj
 *  com.google.android.gms.internal.ads.zzaqk
 *  com.google.android.gms.internal.ads.zzaqt
 *  com.google.android.gms.internal.ads.zzaqu
 *  com.google.android.gms.internal.ads.zzaqv
 *  com.google.android.gms.internal.ads.zzarb
 *  com.google.android.gms.internal.ads.zzarc
 *  com.google.android.gms.internal.ads.zzard
 *  com.google.android.gms.internal.ads.zzare
 *  com.google.android.gms.internal.ads.zzauv
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzavb
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzapj;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapm;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzapo;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzapu;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzaqu;
import com.google.android.gms.internal.ads.zzaqv;
import com.google.android.gms.internal.ads.zzarb;
import com.google.android.gms.internal.ads.zzarc;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzave;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class zzaqw
implements zzapo {
    public static final zzapq zza = new zzaqt();
    private static final int zzb = zzave.zzl((String)"seig");
    private static final byte[] zzc = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final SparseArray<zzaqv> zzd;
    private final zzaux zze;
    private final zzaux zzf;
    private final zzaux zzg;
    private final zzaux zzh;
    private final zzaux zzi = new zzaux(16);
    private final byte[] zzj;
    private final Stack<zzaqi> zzk;
    private final LinkedList<zzaqu> zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private int zzp;
    private zzaux zzq;
    private long zzr;
    private long zzs = -9223372036854775807L;
    private zzaqv zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private zzapp zzx;
    private boolean zzy;

    public zzaqw() {
        this(0, null, null);
    }

    public zzaqw(int n, zzavb zzavb2, zzarc zzarc2) {
        this.zze = new zzaux(zzauv.zza);
        this.zzf = new zzaux(5);
        this.zzg = new zzaux();
        this.zzh = new zzaux(1);
        this.zzj = new byte[16];
        this.zzk = new Stack();
        this.zzl = new LinkedList();
        this.zzd = new SparseArray();
        this.zza();
    }

    private final void zza() {
        this.zzm = 0;
        this.zzp = 0;
    }

    /*
     * Exception decompiling
     */
    private final void zzb(long var1_1) throws zzanp {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 7[UNCONDITIONALDOLOOP]
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

    private static void zzc(zzaux object, int n, zzare zzare2) throws zzanp {
        object.zzi(n + 8);
        n = zzaqk.zzf((int)object.zzr());
        if ((n & 1) != 0) throw new zzanp("Overriding TrackEncryptionBox parameters is unsupported.");
        boolean bl = (n & 2) != 0;
        int n2 = object.zzu();
        n = zzare2.zze;
        if (n2 == n) {
            Arrays.fill(zzare2.zzm, 0, n2, bl);
            zzare2.zza(object.zzd());
            object.zzk(zzare2.zzp.zza, 0, zzare2.zzo);
            zzare2.zzp.zzi(0);
            zzare2.zzq = false;
            return;
        }
        object = new StringBuilder(41);
        ((StringBuilder)object).append("Length mismatch: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(n);
        throw new zzanp(((StringBuilder)object).toString());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static zzapk zzh(List<zzaqj> var0) {
        var2_1 = var0.size();
        var5_2 = null;
        var1_3 = 0;
        while (true) {
            block8: {
                block9: {
                    if (var1_3 >= var2_1) {
                        if (var5_2 != null) return new zzapk(var5_2);
                        return null;
                    }
                    var6_6 /* !! */  = var0.get(var1_3);
                    var4_5 = var5_2;
                    if (var6_6 /* !! */ .zzaR != zzaqk.zzX) break block8;
                    var4_5 = var5_2;
                    if (var5_2 == null) {
                        var4_5 = new ArrayList();
                    }
                    if ((var5_2 = new zzaux((byte[])(var6_6 /* !! */  = (zzaqj)var6_6 /* !! */ .zza.zza))).zze() < 32) ** GOTO lbl-1000
                    var5_2.zzi(0);
                    if (var5_2.zzr() != var5_2.zzd() + 4 || var5_2.zzr() != zzaqk.zzX) ** GOTO lbl-1000
                    var3_4 = zzaqk.zze((int)var5_2.zzr());
                    if (var3_4 <= 1) break block9;
                    var5_2 = new StringBuilder(37);
                    var5_2.append("Unsupported pssh version: ");
                    var5_2.append(var3_4);
                    Log.w((String)"PsshAtomUtil", (String)var5_2.toString());
                    ** GOTO lbl-1000
                }
                var8_8 = new UUID(var5_2.zzs(), var5_2.zzs());
                if (var3_4 == 1) {
                    var5_2.zzj(var5_2.zzu() * 16);
                }
                if ((var3_4 = var5_2.zzu()) != var5_2.zzd()) lbl-1000:
                // 4 sources

                {
                    var5_2 = null;
                } else {
                    var7_7 = new byte[var3_4];
                    var5_2.zzk(var7_7, 0, var3_4);
                    var5_2 = Pair.create((Object)var8_8, (Object)var7_7);
                }
                var5_2 = var5_2 == null ? null : (UUID)var5_2.first;
                if (var5_2 == null) {
                    Log.w((String)"FragmentedMp4Extractor", (String)"Skipped pssh atom (failed to extract uuid)");
                } else {
                    var4_5.add(new zzapj((UUID)var5_2, "video/mp4", (byte[])var6_6 /* !! */ , false));
                }
            }
            ++var1_3;
            var5_2 = var4_5;
        }
    }

    public final void zzd(zzapp zzapp2) {
        this.zzx = zzapp2;
    }

    public final void zze(long l, long l2) {
        int n = this.zzd.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zzl.clear();
                this.zzk.clear();
                this.zza();
                return;
            }
            ((zzaqv)this.zzd.valueAt(n2)).zzb();
            ++n2;
        }
    }

    public final boolean zzf(zzapn zzapn2) throws IOException, InterruptedException {
        return zzarb.zza((zzapn)zzapn2);
    }

    /*
     * WARNING - void declaration
     */
    public final int zzg(zzapn object, zzapt object2) throws IOException, InterruptedException {
        int n;
        void var3_56;
        void var2_32;
        void var1_18;
        boolean bl;
        int n2;
        void var2_24;
        long l;
        long l2;
        int n3;
        block53: {
            int n4;
            int n5;
            block54: {
                boolean bl2;
                void var21_69;
                Object object3 = object;
                while (true) {
                    zzare zzare2;
                    long l3;
                    SparseArray<zzaqv> sparseArray;
                    int n6;
                    block58: {
                        block56: {
                            block57: {
                                n6 = this.zzm;
                                n3 = 0;
                                if (n6 == 0) break block56;
                                if (n6 == 1) break block57;
                                l2 = Long.MAX_VALUE;
                                if (n6 != 2) {
                                    if (n6 != 3) break block53;
                                    if (this.zzt != null) break block54;
                                    sparseArray = this.zzd;
                                    n3 = sparseArray.size();
                                    Object var21_68 = null;
                                    l = l2;
                                    break block58;
                                } else {
                                    void var22_94;
                                    n3 = this.zzd.size();
                                    Object var22_93 = null;
                                    for (n6 = 0; n6 < n3; ++n6) {
                                        void var21_80;
                                        zzare zzare3 = ((zzaqv)this.zzd.valueAt((int)n6)).zza;
                                        void var21_77 = var22_94;
                                        l = l2;
                                        if (zzare3.zzq) {
                                            l3 = zzare3.zzc;
                                            void var21_78 = var22_94;
                                            l = l2;
                                            if (l3 < l2) {
                                                zzaqv zzaqv2 = (zzaqv)this.zzd.valueAt(n6);
                                                l = l3;
                                            }
                                        }
                                        void var22_95 = var21_80;
                                        l2 = l;
                                    }
                                    if (var22_94 == null) {
                                        this.zzm = 3;
                                        continue;
                                    }
                                    n6 = (int)(l2 - object.zzh());
                                    if (n6 < 0) throw new zzanp("Offset to encryption data was negative.");
                                    var2_24.zzd(n6, false);
                                    zzare zzare4 = var22_94.zza;
                                    var2_24.zzb(zzare4.zzp.zza, 0, zzare4.zzo, false);
                                    zzare4.zzp.zzi(0);
                                    zzare4.zzq = false;
                                    continue;
                                }
                            }
                            n6 = (int)this.zzo - this.zzp;
                            zzaux zzaux2 = this.zzq;
                            if (zzaux2 != null) {
                                var2_24.zzb(zzaux2.zza, 8, n6, false);
                                zzaqj zzaqj2 = new zzaqj(this.zzn, this.zzq);
                                l3 = object.zzh();
                                if (!this.zzk.isEmpty()) {
                                    this.zzk.peek().zza(zzaqj2);
                                } else {
                                    if (zzaqj2.zzaR == zzaqk.zzD) {
                                        zzare2 = zzaqj2.zza;
                                        zzare2.zzi(8);
                                        n6 = zzare2.zzr();
                                        zzare2.zzj(4);
                                        long l4 = zzare2.zzp();
                                        if (zzaqk.zze((int)n6) == 0) {
                                            l2 = zzare2.zzp();
                                            l = zzare2.zzp();
                                        } else {
                                            l2 = zzare2.zzv();
                                            l = zzare2.zzv();
                                        }
                                        long l5 = l3 + l;
                                        long l6 = zzave.zzj((long)l2, (long)1000000L, (long)l4);
                                        zzare2.zzj(2);
                                        n6 = zzare2.zzm();
                                        int[] nArray = new int[n6];
                                        long[] lArray = new long[n6];
                                        long[] lArray2 = new long[n6];
                                        long[] lArray3 = new long[n6];
                                        l = l6;
                                        l3 = l2;
                                        l2 = l5;
                                        while (n3 < n6) {
                                            n2 = zzare2.zzr();
                                            if ((n2 & Integer.MIN_VALUE) != 0) throw new zzanp("Unhandled indirect reference");
                                            l5 = zzare2.zzp();
                                            nArray[n3] = n2 & Integer.MAX_VALUE;
                                            lArray[n3] = l2;
                                            lArray3[n3] = l;
                                            l = zzave.zzj((long)(l3 += l5), (long)1000000L, (long)l4);
                                            lArray2[n3] = l - lArray3[n3];
                                            zzare2.zzj(4);
                                            l2 += (long)nArray[n3];
                                            ++n3;
                                        }
                                        Pair pair = Pair.create((Object)l6, (Object)new zzapm(nArray, lArray, lArray2, lArray3));
                                        ((Long)pair.first).longValue();
                                        this.zzx.zzc((zzapv)pair.second);
                                        this.zzy = true;
                                    }
                                    Object object4 = object;
                                }
                            } else {
                                var2_24.zzd(n6, false);
                            }
                            this.zzb(object.zzh());
                            continue;
                        }
                        if (this.zzp == 0) {
                            if (!var2_24.zzb(this.zzi.zza, 0, 8, true)) {
                                return -1;
                            }
                            this.zzp = 8;
                            this.zzi.zzi(0);
                            this.zzo = this.zzi.zzp();
                            this.zzn = this.zzi.zzr();
                        }
                        l2 = l = this.zzo;
                        if (l == 1L) {
                            var2_24.zzb(this.zzi.zza, 8, 8, false);
                            this.zzp += 8;
                            this.zzo = l2 = this.zzi.zzv();
                        }
                        if (l2 < (long)this.zzp) {
                            zzanp zzanp2 = new zzanp("Atom size less than header length (unsupported).");
                            throw zzanp2;
                        }
                        l2 = object.zzh() - (long)this.zzp;
                        if (this.zzn == zzaqk.zzN) {
                            n3 = this.zzd.size();
                            for (n6 = 0; n6 < n3; ++n6) {
                                zzare zzare5 = ((zzaqv)this.zzd.valueAt((int)n6)).zza;
                                zzare5.zzc = l2;
                                zzare5.zzb = l2;
                            }
                        }
                        if (this.zzn == zzaqk.zzk) {
                            this.zzt = null;
                            this.zzr = l2 + this.zzo;
                            if (!this.zzy) {
                                this.zzx.zzc((zzapv)new zzapu(this.zzs));
                                this.zzy = true;
                            }
                            this.zzm = 2;
                            continue;
                        }
                        n6 = this.zzn;
                        if (n6 != zzaqk.zzE && n6 != zzaqk.zzG && n6 != zzaqk.zzH && n6 != zzaqk.zzI && n6 != zzaqk.zzJ && n6 != zzaqk.zzN && n6 != zzaqk.zzO && n6 != zzaqk.zzP && n6 != zzaqk.zzS) {
                            n6 = this.zzn;
                            if (n6 != zzaqk.zzV && n6 != zzaqk.zzU && n6 != zzaqk.zzF && n6 != zzaqk.zzD && n6 != zzaqk.zzW && n6 != zzaqk.zzz && n6 != zzaqk.zzA && n6 != zzaqk.zzR && n6 != zzaqk.zzB && n6 != zzaqk.zzC && n6 != zzaqk.zzX && n6 != zzaqk.zzaf && n6 != zzaqk.zzag && n6 != zzaqk.zzak && n6 != zzaqk.zzaj && n6 != zzaqk.zzah && n6 != zzaqk.zzai && n6 != zzaqk.zzT && n6 != zzaqk.zzQ && n6 != zzaqk.zzaI) {
                                if (this.zzo > Integer.MAX_VALUE) throw new zzanp("Skipping atom with length > 2147483647 (unsupported).");
                                this.zzq = null;
                                this.zzm = 1;
                                continue;
                            }
                            if (this.zzp != 8) throw new zzanp("Leaf atom defines extended atom size (unsupported).");
                            l2 = this.zzo;
                            if (l2 > Integer.MAX_VALUE) throw new zzanp("Leaf atom with length > 2147483647 (unsupported).");
                            this.zzq = new zzaux((int)l2);
                            System.arraycopy(this.zzi.zza, 0, this.zzq.zza, 0, 8);
                            this.zzm = 1;
                            continue;
                        }
                        l2 = object.zzh() + this.zzo - 8L;
                        this.zzk.add(new zzaqi(this.zzn, l2));
                        if (this.zzo == (long)this.zzp) {
                            this.zzb(l2);
                            continue;
                        }
                        this.zza();
                        continue;
                    }
                    for (n6 = 0; n6 < n3; ++n6) {
                        zzaqv zzaqv3 = (zzaqv)sparseArray.valueAt(n6);
                        n2 = zzaqv3.zzg;
                        zzare2 = zzaqv3.zza;
                        if (n2 == zzare2.zzd) {
                            l2 = l;
                        } else {
                            l3 = zzare2.zzf[n2];
                            l2 = l;
                            if (l3 < l) {
                                zzaqv zzaqv4 = zzaqv3;
                                l2 = l3;
                            }
                        }
                        l = l2;
                    }
                    if (var21_69 != null) break;
                    n6 = (int)(this.zzr - object.zzh());
                    if (n6 < 0) throw new zzanp("Offset to end of mdat was negative.");
                    var2_24.zzd(n6, false);
                    this.zza();
                }
                int n7 = n3 = (int)(var21_69.zza.zzf[var21_69.zzg] - object.zzh());
                if (n3 < 0) {
                    Log.w((String)"FragmentedMp4Extractor", (String)"Ignoring negative offset to sample data.");
                    bl2 = false;
                }
                var2_24.zzd(bl2 ? 1 : 0, false);
                this.zzt = var21_69;
            }
            zzaqv zzaqv5 = this.zzt;
            zzare zzare6 = zzaqv5.zza;
            int[] nArray = zzare6.zzh;
            n2 = zzaqv5.zze;
            this.zzu = n5 = nArray[n2];
            if (zzare6.zzl) {
                void var3_50;
                void var3_45;
                void var1_5;
                zzaux zzaux3 = zzare6.zzp;
                int n8 = zzare6.zza.zza;
                zzard zzard2 = zzare6.zzn;
                if (zzard2 == null) {
                    zzard zzard3 = zzaqv5.zzc.zzh[n8];
                }
                n3 = var1_5.zza;
                bl = zzare6.zzm[n2];
                zzaux zzaux4 = this.zzh;
                byte[] byArray = zzaux4.zza;
                if (!bl) {
                    boolean bl3 = false;
                } else {
                    int n9 = 128;
                }
                byArray[0] = (byte)(var3_45 | n3);
                zzaux4.zzi(0);
                zzapx zzapx2 = zzaqv5.zzb;
                zzapx2.zzb(this.zzh, 1);
                zzapx2.zzb(zzaux3, n3);
                if (!bl) {
                    int n10 = n3 + 1;
                } else {
                    int n11 = zzaux3.zzm();
                    zzaux3.zzj(-2);
                    int n12 = n11 * 6 + 2;
                    zzapx2.zzb(zzaux3, n12);
                    int n13 = n3 + 1 + n12;
                }
                this.zzv = var3_50;
                this.zzu = n4 = this.zzu + var3_50;
            } else {
                this.zzv = 0;
            }
            if (this.zzt.zzc.zzg == 1) {
                this.zzu = n4 - 8;
                var2_24.zzd(8, false);
            }
            this.zzm = 4;
            this.zzw = 0;
        }
        zzaqv zzaqv6 = this.zzt;
        zzare zzare7 = zzaqv6.zza;
        zzarc zzarc2 = zzaqv6.zzc;
        zzapx zzapx3 = zzaqv6.zzb;
        n3 = zzaqv6.zze;
        int n14 = zzarc2.zzk;
        if (n14 == 0) {
            int n15;
            while ((n15 = this.zzv) < (n2 = this.zzu)) {
                n15 = zzapx3.zzd((zzapn)var2_24, n2 - n15, false);
                this.zzv += n15;
            }
        } else {
            byte[] byArray = this.zzf.zza;
            byArray[0] = 0;
            byArray[1] = 0;
            byArray[2] = 0;
            n2 = 4 - n14;
            while (this.zzv < this.zzu) {
                int n16 = this.zzw;
                if (n16 == 0) {
                    var2_24.zzb(byArray, n2, n14 + 1, false);
                    this.zzf.zzi(0);
                    this.zzw = this.zzf.zzu() - 1;
                    this.zze.zzi(0);
                    zzapx3.zzb(this.zze, 4);
                    zzapx3.zzb(this.zzf, 1);
                    this.zzv += 5;
                    this.zzu += n2;
                    continue;
                }
                n16 = zzapx3.zzd((zzapn)var2_24, n16, false);
                this.zzv += n16;
                this.zzw -= n16;
            }
        }
        l2 = zzare7.zzj[n3];
        l = zzare7.zzi[n3];
        bl = zzare7.zzl;
        if (!bl) {
            boolean bl4 = false;
        } else {
            int n17 = 0x40000000;
        }
        int n18 = zzare7.zzk[n3];
        if (bl) {
            void var2_29;
            void var1_15;
            zzard zzard4;
            zzard zzard5 = zzard4 = zzare7.zzn;
            if (zzard4 == null) {
                zzard zzard6 = zzarc2.zzh[zzare7.zza.zza];
            }
            zzaqv zzaqv7 = this.zzt;
            if (var1_15 != zzaqv7.zzi) {
                zzapw zzapw2 = new zzapw(1, var1_15.zzb);
            } else {
                zzapw zzapw3 = zzaqv7.zzh;
            }
            void var21_74 = var2_29;
            void var2_30 = var1_15;
            void var1_16 = var21_74;
        } else {
            Object var2_31 = null;
            Object var1_17 = null;
        }
        zzaqv zzaqv8 = this.zzt;
        zzaqv8.zzh = var1_18;
        zzaqv8.zzi = var2_32;
        zzapx3.zzc((l2 + l) * 1000L, var3_56 | n18, this.zzu, 0, (zzapw)var1_18);
        if (!this.zzl.isEmpty()) {
            zzaqu zzaqu2 = this.zzl.removeFirst();
            int n19 = zzaqu2.zzb;
            l2 = zzaqu2.zza;
            throw null;
        }
        zzaqv zzaqv9 = this.zzt;
        ++zzaqv9.zze;
        zzaqv9.zzf = n = zzaqv9.zzf + 1;
        int[] nArray = zzare7.zzg;
        n3 = zzaqv9.zzg;
        if (n == nArray[n3]) {
            zzaqv9.zzg = n3 + 1;
            zzaqv9.zzf = 0;
            this.zzt = null;
        }
        this.zzm = 3;
        return 0;
    }
}
