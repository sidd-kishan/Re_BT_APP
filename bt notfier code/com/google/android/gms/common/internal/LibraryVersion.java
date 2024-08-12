/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.GmsLogger
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.IOUtils
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzb = new LibraryVersion();
    private ConcurrentHashMap<String, String> zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public String getVersion(String var1_1) {
        block14: {
            block16: {
                block17: {
                    block15: {
                        Preconditions.checkNotEmpty((String)var1_1, (Object)"Please provide a valid libraryName");
                        if (this.zzc.containsKey(var1_1)) {
                            return this.zzc.get(var1_1);
                        }
                        var9_5 = new Properties();
                        var8_6 = null;
                        var4_7 = null;
                        var5_8 = null;
                        var7_9 = null;
                        try {
                            var6_13 = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[]{var1_1}));
                            if (var6_13 != null) {
                                var4_7 = var8_6;
                            }
                            ** GOTO lbl45
                        }
                        catch (Throwable var1_3) {
                            break block14;
                        }
                        catch (IOException var7_11) {
                            var6_13 = null;
                            break block15;
                        }
                        try {
                            block18: {
                                var9_5.load((InputStream)var6_13);
                                var4_7 = var8_6;
                                var4_7 = var5_8 = var9_5.getProperty("version", null);
                                var7_9 = LibraryVersion.zza;
                                var4_7 = var5_8;
                                var2_14 = String.valueOf(var1_1).length();
                                var4_7 = var5_8;
                                var3_15 = String.valueOf(var5_8).length();
                                var4_7 = var5_8;
                                var4_7 = var5_8;
                                var8_6 = new StringBuilder(var2_14 + 12 + var3_15);
                                var4_7 = var5_8;
                                var8_6.append(var1_1);
                                var4_7 = var5_8;
                                var8_6.append(" version is ");
                                var4_7 = var5_8;
                                var8_6.append((String)var5_8);
                                var4_7 = var5_8;
                                var7_9.v("LibraryVersion", var8_6.toString());
                                break block18;
lbl45:
                                // 1 sources

                                var4_7 = var8_6;
                                var9_5 = LibraryVersion.zza;
                                var4_7 = var8_6;
                                var5_8 = String.valueOf(var1_1);
                                var4_7 = var8_6;
                                if (var5_8.length() != 0) {
                                    var4_7 = var8_6;
                                    var5_8 = "Failed to get app version for libraryName: ".concat((String)var5_8);
                                } else {
                                    var4_7 = var8_6;
                                    var5_8 = new String("Failed to get app version for libraryName: ");
                                }
                                var4_7 = var8_6;
                                var9_5.w("LibraryVersion", (String)var5_8);
                                var5_8 = var7_9;
                            }
                            var4_7 = var5_8;
                            if (var6_13 == null) break block16;
                        }
                        catch (Throwable var1_2) {
                            var4_7 = var6_13;
                            break block14;
                        }
                        catch (IOException var7_10) {
                            var5_8 = var6_13;
                            var6_13 = var4_7;
                            break block15;
                        }
                        IOUtils.closeQuietly((Closeable)var6_13);
                        var4_7 = var5_8;
                        break block16;
                    }
                    var4_7 = var5_8;
                    {
                        var9_5 = LibraryVersion.zza;
                        var4_7 = var5_8;
                        var8_6 = String.valueOf(var1_1);
                        var4_7 = var5_8;
                        if (var8_6.length() != 0) {
                            var4_7 = var5_8;
                            var8_6 = "Failed to get app version for libraryName: ".concat((String)var8_6);
                        } else {
                            var4_7 = var5_8;
                            var8_6 = new String("Failed to get app version for libraryName: ");
                        }
                        var4_7 = var5_8;
                        var9_5.e("LibraryVersion", (String)var8_6, (Throwable)var7_12);
                        if (var5_8 == null) break block17;
                    }
                    IOUtils.closeQuietly((Closeable)var5_8);
                }
                var4_7 = var6_13;
            }
            var5_8 = var4_7;
            if (var4_7 == null) {
                LibraryVersion.zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
                var5_8 = "UNKNOWN";
            }
            this.zzc.put(var1_1, (String)var5_8);
            return var5_8;
        }
        if (var4_7 == null) throw var1_4;
        IOUtils.closeQuietly(var4_7);
        throw var1_4;
    }
}
