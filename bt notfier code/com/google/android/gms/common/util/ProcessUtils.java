/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.IOUtils
 */
package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils {
    @Nullable
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String getMyProcessName() {
        block18: {
            block17: {
                block16: {
                    if (ProcessUtils.zza != null) return ProcessUtils.zza;
                    if (ProcessUtils.zzb == 0) {
                        ProcessUtils.zzb = Process.myPid();
                    }
                    var0 = ProcessUtils.zzb;
                    var1_1 /* !! */  = null;
                    var2_5 = null;
                    var3_8 = null;
                    if (var0 <= 0) {
                        var1_1 /* !! */  = var2_5;
                    } else {
                        var2_5 = new StringBuilder(25);
                        var2_5.append("/proc/");
                        var2_5.append(var0);
                        var2_5.append("/cmdline");
                        var5_10 = var2_5.toString();
                        var4_11 = StrictMode.allowThreadDiskReads();
                        break block16;
                    }
lbl22:
                    // 2 sources

                    while (true) {
                        ProcessUtils.zza = var1_1 /* !! */ ;
                        return ProcessUtils.zza;
                    }
                }
                var6_12 = new FileReader(var5_10);
                var2_5 = new BufferedReader(var6_12);
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)var4_11);
                try {}
                catch (IOException var3_9) {}
                {
                    catch (Throwable var1_3) {
                        var2_5 = var3_8;
                        break block17;
                    }
                    catch (IOException var2_7) {
                        var2_5 = null;
                        break block18;
                    }
lbl39:
                    // 1 sources

                    while (true) {
                        var3_8 = var2_5.readLine();
                        Preconditions.checkNotNull((Object)var3_8);
                        var3_8 = var3_8.trim();
                        var1_1 /* !! */  = var3_8;
                        break block18;
                        break;
                    }
                }
                finally {
                    ** continue;
                }
                {
                    catch (Throwable var2_6) {}
                    {
                        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)var4_11);
                        throw var2_6;
                    }
                }
            }
            IOUtils.closeQuietly((Closeable)var2_5);
            throw var1_4;
        }
        IOUtils.closeQuietly((Closeable)var2_5);
        ** while (true)
    }
}
