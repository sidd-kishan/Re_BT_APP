/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzkk
 *  com.google.android.gms.internal.ads.zzkl
 */
package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzkk;
import com.google.android.gms.internal.ads.zzkl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class zzkm
extends zzag {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzkm(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    /*
     * Unable to fully structure code
     */
    public final int zzg(byte[] var1_1, int var2_3, int var3_4) throws zzkl {
        block4: {
            if (var3_4 == 0) {
                return 0;
            }
            var7_5 = this.zze;
            if (var7_5 == 0L) return -1;
            var4_6 = var3_4;
            if (var7_5 == -1L) ** GOTO lbl10
            var5_7 = var3_4;
            try {
                var4_6 = (int)Math.min(var7_5, var5_7);
lbl10:
                // 2 sources

                var9_8 = this.zzd;
                var3_4 = zzamq.zza;
                if ((var2_3 = var9_8.read(var1_1, var2_3, var4_6)) == -1) {
                    return -1;
                }
                var5_7 = this.zze;
                if (var5_7 == -1L) break block4;
            }
            catch (IOException var1_2) {
                throw new zzkl(var1_2, 2000);
            }
            this.zze = var5_7 - (long)var2_3;
        }
        this.zzd(var2_3);
        return var2_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final long zzh(zzan var1_1) throws zzkl {
        block15: {
            var2_4 = 2000;
            try {
                var11_5 = var1_1 /* !! */ .zza;
                this.zzb = var11_5;
                this.zzb(var1_1 /* !! */ );
                if ("content".equals(var1_1 /* !! */ .zza.getScheme())) {
                    var10_6 = new Bundle();
                    if (zzamq.zza >= 31) {
                        zzkk.zza((Bundle)var10_6);
                    }
                    var10_6 = this.zza.openTypedAssetFileDescriptor((Uri)var11_5, "*/*", (Bundle)var10_6);
                } else {
                    var10_6 = this.zza.openAssetFileDescriptor((Uri)var11_5, "r");
                }
                this.zzc = var10_6;
                if (var10_6 == null) ** GOTO lbl60
                var4_7 = var10_6.getLength();
                var11_5 = new FileInputStream(var10_6.getFileDescriptor());
                this.zzd = var11_5;
                if (var4_7 != -1L && var1_1 /* !! */ .zzf > var4_7) {
                    var1_1 /* !! */  = new zzkl(null, 2008);
                    throw var1_1 /* !! */ ;
                }
                var6_8 = var10_6.getStartOffset();
                if ((var6_8 = var11_5.skip(var1_1 /* !! */ .zzf + var6_8) - var6_8) != var1_1 /* !! */ .zzf) ** GOTO lbl58
                if (var4_7 == -1L) {
                    var10_6 = var11_5.getChannel();
                    var4_7 = var10_6.size();
                    if (var4_7 == 0L) {
                        this.zze = -1L;
                        var4_7 = -1L;
                    } else {
                        this.zze = var4_7 -= var10_6.position();
                        if (var4_7 < 0L) {
                            var1_1 /* !! */  = new zzkl(null, 2008);
                            throw var1_1 /* !! */ ;
                        }
                    }
                    break block15;
                }
            }
            catch (IOException var1_2) {
                if (!(var1_2 instanceof FileNotFoundException)) throw new zzkl(var1_2, var2_4);
                var2_4 = 2005;
                throw new zzkl(var1_2, var2_4);
            }
            catch (zzkl var1_3) {
                throw var1_3;
            }
            {
                this.zze = var4_7 -= var6_8;
                if (var4_7 < 0L) ** GOTO lbl-1000
            }
        }
        var8_9 = var1_1 /* !! */ .zzg;
        if (var8_9 != -1L) {
            var6_8 = var8_9;
            if (var4_7 != -1L) {
                var6_8 = Math.min(var4_7, var8_9);
            }
            this.zze = var6_8;
        }
        this.zzf = true;
        this.zzc(var1_1 /* !! */ );
        var4_7 = var1_1 /* !! */ .zzg;
        if (var4_7 == -1L) return this.zze;
        return var4_7;
lbl-1000:
        // 1 sources

        {
            var1_1 /* !! */  = new zzkl(null, 2008);
            throw var1_1 /* !! */ ;
lbl58:
            // 1 sources

            var1_1 /* !! */  = new zzkl(null, 2008);
            throw var1_1 /* !! */ ;
lbl60:
            // 1 sources

            var12_10 = String.valueOf(var11_5);
            var3_11 = String.valueOf(var12_10).length();
            var11_5 = new StringBuilder(var3_11 + 36);
            var11_5.append("Could not open file descriptor for: ");
            var11_5.append(var12_10);
            var1_1 /* !! */  = new IOException(var11_5.toString());
            var10_6 = new zzkl((IOException)var1_1 /* !! */ , 2000);
            throw var10_6;
        }
    }

    public final Uri zzi() {
        return this.zzb;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void zzj() throws zzkl {
        Throwable throwable4222222;
        block18: {
            Throwable throwable22222222;
            block16: {
                Throwable throwable32222222;
                block17: {
                    this.zzb = null;
                    FileInputStream fileInputStream = this.zzd;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.zzd = null;
                    {
                        catch (Throwable throwable22222222) {
                            break block16;
                        }
                        catch (IOException iOException) {}
                        {
                            zzkl zzkl2 = new zzkl(iOException, 2000);
                            throw zzkl2;
                        }
                    }
                    fileInputStream = this.zzc;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.zzc = null;
                    if (!this.zzf) return;
                    this.zzf = false;
                    {
                        catch (Throwable throwable32222222) {
                            break block17;
                        }
                        catch (IOException iOException) {}
                        {
                            zzkl zzkl3 = new zzkl(iOException, 2000);
                            throw zzkl3;
                        }
                    }
                    this.zze();
                    return;
                }
                this.zzc = null;
                if (!this.zzf) throw throwable32222222;
                this.zzf = false;
                this.zze();
                throw throwable32222222;
            }
            this.zzd = null;
            AssetFileDescriptor assetFileDescriptor = this.zzc;
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            this.zzc = null;
            if (!this.zzf) throw throwable22222222;
            this.zzf = false;
            {
                catch (Throwable throwable4222222) {
                    break block18;
                }
                catch (IOException iOException) {}
                {
                    zzkl zzkl4 = new zzkl(iOException, 2000);
                    throw zzkl4;
                }
            }
            this.zze();
            throw throwable22222222;
        }
        this.zzc = null;
        if (!this.zzf) {
            throw throwable4222222;
        }
        this.zzf = false;
        this.zze();
        throw throwable4222222;
    }
}
