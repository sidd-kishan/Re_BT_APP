/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfmh
 *  com.google.android.gms.internal.ads.zzfqp
 *  com.google.android.gms.internal.ads.zzged
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfmh;
import com.google.android.gms.internal.ads.zzfqp;
import com.google.android.gms.internal.ads.zzged;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public final class zzfjk {
    public static boolean zza(int n) {
        if (--n == 2) return true;
        if (n == 4) return true;
        if (n == 5) return true;
        if (n == 6) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static final int zzb(Context var0, zzfii var1_1) {
        block19: {
            block24: {
                block25: {
                    block23: {
                        block18: {
                            block21: {
                                block22: {
                                    block17: {
                                        block16: {
                                            block20: {
                                                var4_2 = new File(new File(var0 /* !! */ .getApplicationInfo().dataDir), "lib");
                                                if (var4_2.exists()) break block20;
                                                var1_1.zze(5017, "No lib/");
                                                break block21;
                                            }
                                            var5_6 /* !! */  = var4_2.listFiles((FilenameFilter)new zzfqp(Pattern.compile(".*\\.so$", 2)));
                                            if (var5_6 /* !! */  == null || var5_6 /* !! */ .length == 0) break block22;
                                            var4_2 = new FileInputStream(var5_6 /* !! */ [0]);
                                            var5_6 /* !! */  = (File[])new byte[20];
                                            if (var4_2.read((byte[])var5_6 /* !! */ ) != 20) break block16;
                                            var6_8 = new byte[]{0, 0};
                                            if (var5_6 /* !! */ [5] == 2) {
                                                zzfjk.zzc((byte[])var5_6 /* !! */ , null, var0 /* !! */ , var1_1);
                                                break block16;
                                            }
                                            var6_8[0] = (byte)var5_6 /* !! */ [19];
                                            var6_8[1] = (byte)var5_6 /* !! */ [18];
                                            var2_5 = ByteBuffer.wrap(var6_8).getShort();
                                            if (var2_5 == 3) ** GOTO lbl43
                                            if (var2_5 == 40) ** GOTO lbl40
                                            if (var2_5 == 62) ** GOTO lbl37
                                            if (var2_5 == 183) break block17;
                                            zzfjk.zzc((byte[])var5_6 /* !! */ , null, var0 /* !! */ , var1_1);
                                        }
                                        var4_2.close();
                                    }
                                    var4_2.close();
                                    var2_5 = 6;
                                    break block18;
lbl37:
                                    // 1 sources

                                    var4_2.close();
                                    var2_5 = 7;
                                    break block18;
lbl40:
                                    // 1 sources

                                    var4_2.close();
                                    var2_5 = 3;
                                    break block18;
lbl43:
                                    // 1 sources

                                    var4_2.close();
                                    var2_5 = 5;
                                    break block18;
                                    catch (Throwable var5_7) {
                                        try {
                                            var4_2.close();
                                            throw var5_7;
                                        }
                                        catch (Throwable var4_3) {
                                            try {
                                                zzged.zza((Throwable)var5_7, (Throwable)var4_3);
                                                throw var5_7;
                                            }
                                            catch (IOException var4_4) {
                                                zzfjk.zzc(null, var4_4.toString(), var0 /* !! */ , var1_1);
                                            }
                                        }
                                    }
                                    var2_5 = 1;
                                    break block18;
                                }
                                var1_1.zze(5017, "No .so");
                            }
                            var2_5 = 1000;
                        }
                        var3_9 = var2_5;
                        if (var2_5 != 1000) break block19;
                        var4_2 = zzfjk.zzd(var0 /* !! */ , var1_1);
                        if (!TextUtils.isEmpty((CharSequence)var4_2)) break block23;
                        zzfjk.zzc(null, "Empty dev arch", var0 /* !! */ , var1_1);
                        ** GOTO lbl81
                    }
                    if (var4_2.equalsIgnoreCase("i686") || var4_2.equalsIgnoreCase("x86")) break block24;
                    if (!var4_2.equalsIgnoreCase("x86_64")) break block25;
                    var3_9 = 7;
                    break block19;
                }
                if (var4_2.equalsIgnoreCase("arm64-v8a")) {
                    var3_9 = 6;
                    break block19;
                } else if (!var4_2.equalsIgnoreCase("armeabi-v7a") && !var4_2.equalsIgnoreCase("armv71")) {
                    zzfjk.zzc(null, (String)var4_2, var0 /* !! */ , var1_1);
lbl81:
                    // 2 sources

                    var3_9 = 1;
                    break block19;
                } else {
                    var3_9 = 3;
                }
                break block19;
            }
            var3_9 = 5;
        }
        var0 /* !! */  = var3_9 != 1 ? (var3_9 != 3 ? (var3_9 != 5 ? (var3_9 != 6 ? (var3_9 != 7 ? "null" : "X86_64") : "ARM64") : "X86") : "ARM7") : "UNSUPPORTED";
        var1_1.zze(5018, (String)var0 /* !! */ );
        return var3_9;
    }

    private static final void zzc(byte[] byArray, String string, Context object, zzfii zzfii2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("os.arch:");
        ((StringBuilder)object).append(zzfmh.zzu.zza());
        ((StringBuilder)object).append(";");
        try {
            Object[] objectArray = (String[])Build.class.getField("SUPPORTED_ABIS").get(null);
            if (objectArray != null) {
                ((StringBuilder)object).append("supported_abis:");
                ((StringBuilder)object).append(Arrays.toString(objectArray));
                ((StringBuilder)object).append(";");
            }
        }
        catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            // empty catch block
        }
        ((StringBuilder)object).append("CPU_ABI:");
        ((StringBuilder)object).append(Build.CPU_ABI);
        ((StringBuilder)object).append(";CPU_ABI2:");
        ((StringBuilder)object).append(Build.CPU_ABI2);
        ((StringBuilder)object).append(";");
        if (byArray != null) {
            ((StringBuilder)object).append("ELF:");
            ((StringBuilder)object).append(Arrays.toString(byArray));
            ((StringBuilder)object).append(";");
        }
        if (string != null) {
            ((StringBuilder)object).append("dbg:");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(";");
        }
        zzfii2.zze(4007, ((StringBuilder)object).toString());
    }

    private static final String zzd(Context object, zzfii zzfii2) {
        block4: {
            HashSet<String> hashSet = new HashSet<String>(Arrays.asList("i686", "armv71"));
            object = zzfmh.zzu.zza();
            if (!TextUtils.isEmpty((CharSequence)object)) {
                if (hashSet.contains(object)) return object;
            }
            try {
                object = (String[])Build.class.getField("SUPPORTED_ABIS").get(null);
                if (object == null || ((String[])object).length <= 0) break block4;
            }
            catch (IllegalAccessException illegalAccessException) {
                zzfii2.zzc(2024, 0L, (Exception)illegalAccessException);
                break block4;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                zzfii2.zzc(2024, 0L, (Exception)noSuchFieldException);
                break block4;
            }
            object = object[0];
            return object;
        }
        if (Build.CPU_ABI == null) return Build.CPU_ABI2;
        return Build.CPU_ABI;
    }
}
