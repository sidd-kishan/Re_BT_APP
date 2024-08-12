/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzaix
 *  com.google.android.gms.internal.ads.zzajt
 *  com.google.android.gms.internal.ads.zzaju
 *  com.google.android.gms.internal.ads.zzajv
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzaix;
import com.google.android.gms.internal.ads.zzajt;
import com.google.android.gms.internal.ads.zzaju;
import com.google.android.gms.internal.ads.zzajv;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class zzajw {
    public static final zzaju zza = zzajt.zza;

    /*
     * Enabled force condition propagation
     */
    public static final zzaiv zza(byte[] object, int n, zzaju zzaju2, zzaix object2) {
        int n2;
        object2 = new ArrayList();
        zzamf zzamf2 = new zzamf((byte[])object, n);
        n = zzamf2.zzd();
        int n3 = 10;
        boolean bl = false;
        if (n < 10) {
            Log.w((String)"Id3Decoder", (String)"Data too short to be an ID3 tag");
            return null;
        }
        n = zzamf2.zzr();
        if (n != 0x494433) {
            object = String.valueOf(String.format("%06X", n));
            object = ((String)object).length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat((String)object) : new String("Unexpected first three bytes of ID3 tag header: 0x");
            Log.w((String)"Id3Decoder", (String)object);
            return null;
        }
        int n4 = zzamf2.zzn();
        zzamf2.zzk(1);
        int n5 = zzamf2.zzn();
        int n6 = zzamf2.zzA();
        if (n4 == 2) {
            n = n6;
            if ((n5 & 0x40) != 0) {
                Log.w((String)"Id3Decoder", (String)"Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (n4 == 3) {
            n = n6;
            if ((n5 & 0x40) != 0) {
                n = zzamf2.zzv();
                zzamf2.zzk(n);
                n = n6 - (n + 4);
            }
        } else if (n4 == 4) {
            n2 = n6;
            if ((n5 & 0x40) != 0) {
                n = zzamf2.zzA();
                zzamf2.zzk(n - 4);
                n2 = n6 - n;
            }
            n = n2;
            if ((n5 & 0x10) != 0) {
                n = n2 - 10;
            }
        } else {
            object = new StringBuilder(57);
            ((StringBuilder)object).append("Skipped ID3 tag with unsupported majorVersion=");
            ((StringBuilder)object).append(n4);
            Log.w((String)"Id3Decoder", (String)((StringBuilder)object).toString());
            return null;
        }
        boolean bl2 = n4 < 4 && (n5 & 0x80) != 0;
        object = new zzajv(n4, bl2, n);
        if (object == null) {
            return null;
        }
        n6 = zzamf2.zzg();
        n = n3;
        if (zzajv.zza((zzajv)object) == 2) {
            n = 6;
        }
        n2 = zzajv.zzc((zzajv)object);
        if (zzajv.zzb((zzajv)object)) {
            n2 = zzajw.zzd(zzamf2, zzajv.zzc((zzajv)object));
        }
        zzamf2.zzf(n6 + n2);
        bl2 = bl;
        if (!zzajw.zzb(zzamf2, zzajv.zza((zzajv)object), n, false)) {
            if (zzajv.zza((zzajv)object) == 4 && zzajw.zzb(zzamf2, 4, n, true)) {
                bl2 = true;
            } else {
                n = zzajv.zza((zzajv)object);
                object = new StringBuilder(56);
                ((StringBuilder)object).append("Failed to validate ID3 tag with majorVersion=");
                ((StringBuilder)object).append(n);
                Log.w((String)"Id3Decoder", (String)((StringBuilder)object).toString());
                return null;
            }
        }
        while (zzamf2.zzd() >= n) {
            zzajx zzajx2 = zzajw.zzc(zzajv.zza((zzajv)object), zzamf2, bl2, n, zzaju2);
            if (zzajx2 == null) continue;
            object2.add(zzajx2);
        }
        return new zzaiv((List)object2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private static boolean zzb(zzamf zzamf2, int n, int n2, boolean bl) {
        int n3 = zzamf2.zzg();
        while (true) {
            long l;
            int n4;
            int n5;
            int n6;
            block15: {
                block17: {
                    block16: {
                        int n7;
                        block14: {
                            long l2;
                            block13: {
                                try {
                                    n6 = zzamf2.zzd();
                                    n7 = 1;
                                    n5 = 1;
                                    if (n6 < n2) break;
                                    if (n >= 3) {
                                        n6 = zzamf2.zzv();
                                        l2 = zzamf2.zzt();
                                        n4 = zzamf2.zzo();
                                        break block13;
                                    }
                                    n6 = zzamf2.zzr();
                                    n4 = zzamf2.zzr();
                                }
                                catch (Throwable throwable) {
                                    zzamf2.zzh(n3);
                                    throw throwable;
                                }
                                l2 = n4;
                                n4 = 0;
                            }
                            if (n6 == 0 && l2 == 0L && n4 == 0) {
                                zzamf2.zzh(n3);
                                return true;
                            }
                            l = l2;
                            if (n == 4) {
                                l = l2;
                                if (!bl) {
                                    if ((0x808080L & l2) != 0L) {
                                        zzamf2.zzh(n3);
                                        return false;
                                    }
                                    l = l2 >> 24 << 21 | ((0xFFL & l2 >> 16) << 14 | (l2 & 0xFFL | (l2 >> 8 & 0xFFL) << 7));
                                }
                            }
                            if (n != 4) break block14;
                            n6 = (n4 & 0x40) != 0 ? n5 : 0;
                            n4 &= 1;
                            break block15;
                        }
                        if (n != 3) break block16;
                        n6 = (n4 & 0x20) != 0 ? 1 : 0;
                        n5 = n6;
                        if ((n4 & 0x80) == 0) break block17;
                        n4 = n7;
                        break block15;
                    }
                    n5 = 0;
                }
                n4 = 0;
                n6 = n5;
            }
            n5 = n6;
            if (n4 != 0) {
                n5 = n6 + 4;
            }
            if (l < (long)n5) {
                zzamf2.zzh(n3);
                return false;
            }
            n6 = zzamf2.zzd();
            if ((long)n6 < l) {
                zzamf2.zzh(n3);
                return false;
            }
            n6 = (int)l;
            {
                zzamf2.zzk(n6);
                continue;
            }
            break;
        }
        zzamf2.zzh(n3);
        return true;
    }

    /*
     * Exception decompiling
     */
    private static zzajx zzc(int var0, zzamf var1_1, boolean var2_2, int var3_3, zzaju var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [41, 40 : 901->1284)] java.lang.Throwable
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

    private static int zzd(zzamf zzamf2, int n) {
        int n2;
        int n3;
        byte[] byArray = zzamf2.zzi();
        int n4 = n3 = zzamf2.zzg();
        int n5 = n;
        while ((n2 = n4 + 1) < n3 + n5) {
            n = n5;
            if ((byArray[n4] & 0xFF) == 255) {
                n = n5;
                if (byArray[n2] == 0) {
                    System.arraycopy(byArray, n4 + 2, byArray, n2, n5 - (n4 - n3) - 2);
                    n = n5 - 1;
                }
            }
            n4 = n2;
            n5 = n;
        }
        return n5;
    }

    private static String zze(int n) {
        if (n == 1) return "UTF-16";
        if (n == 2) return "UTF-16BE";
        if (n == 3) return "UTF-8";
        return "ISO-8859-1";
    }

    private static String zzf(int n, int n2, int n3, int n4, int n5) {
        String string = n == 2 ? String.format(Locale.US, "%c%c%c", n2, n3, n4) : String.format(Locale.US, "%c%c%c%c", n2, n3, n4, n5);
        return string;
    }

    private static int zzg(byte[] byArray, int n, int n2) {
        int n3 = zzajw.zzh(byArray, n);
        if (n2 == 0) return n3;
        if (n2 == 3) return n3;
        n2 = n3;
        while (n2 < (n3 = byArray.length) - 1) {
            if ((n2 - n) % 2 == 0) {
                if (byArray[n2 + 1] == 0) return n2;
            }
            n2 = zzajw.zzh(byArray, n2 + 1);
        }
        return n3;
    }

    private static int zzh(byte[] byArray, int n) {
        int n2;
        while (n < (n2 = byArray.length)) {
            if (byArray[n] == 0) {
                return n;
            }
            ++n;
        }
        return n2;
    }

    private static int zzi(int n) {
        if (n == 0) return 1;
        if (n != 3) return 2;
        return 1;
    }

    private static byte[] zzj(byte[] byArray, int n, int n2) {
        if (n2 > n) return Arrays.copyOfRange(byArray, n, n2);
        return zzamq.zzf;
    }

    private static String zzk(byte[] byArray, int n, int n2, String string) throws UnsupportedEncodingException {
        if (n2 <= n) return "";
        if (n2 <= byArray.length) return new String(byArray, n, n2 - n, string);
        return "";
    }
}
