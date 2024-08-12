/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzadi
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzadi;
import com.google.android.gms.internal.ads.zzgex;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class zzfjw {
    private final zzadi zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzfjw(zzadi zzadi2, File file, File file2, File file3) {
        this.zza = zzadi2;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzadi zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzb;
    }

    public final File zzc() {
        return this.zzc;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final byte[] zzd() {
        byte[] byArray;
        block7: {
            void var1_11;
            block8: {
                void var1_6;
                void var3_16;
                block6: {
                    byte[] byArray2 = this.zze;
                    Object var3_14 = null;
                    if (byArray2 != null) break block7;
                    Object object = this.zzd;
                    FileInputStream fileInputStream = new FileInputStream((File)object);
                    try {
                        object = zzgex.zzw((InputStream)fileInputStream).zzz();
                    }
                    catch (Throwable throwable) {
                        FileInputStream fileInputStream2 = fileInputStream;
                        Throwable throwable2 = throwable;
                        break block6;
                    }
                    IOUtils.closeQuietly((Closeable)fileInputStream);
                    Object object2 = object;
                    break block8;
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                IOUtils.closeQuietly((Closeable)var3_16);
                throw var1_6;
                catch (IOException iOException) {
                    void var1_9;
                    block9: {
                        Object var1_8 = null;
                        break block9;
                        catch (IOException iOException2) {}
                    }
                    IOUtils.closeQuietly((Closeable)var1_9);
                    Object var1_10 = null;
                }
            }
            this.zze = var1_11;
        }
        if ((byArray = this.zze) != null) return Arrays.copyOf(byArray, byArray.length);
        return null;
    }

    public final boolean zze(long l) {
        if (this.zza.zzd() - System.currentTimeMillis() / 1000L >= 3600L) return false;
        return true;
    }
}
