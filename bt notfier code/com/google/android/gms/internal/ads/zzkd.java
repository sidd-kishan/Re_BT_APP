/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzkc
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzkc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class zzkd
extends zzag {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzkd(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    /*
     * Unable to fully structure code
     */
    public final int zzg(byte[] var1_1, int var2_3, int var3_4) throws zzkc {
        block4: {
            if (var3_4 == 0) {
                return 0;
            }
            var5_5 = this.zzd;
            if (var5_5 == 0L) return -1;
            var4_6 = var3_4;
            if (var5_5 == -1L) ** GOTO lbl10
            var7_7 = var3_4;
            try {
                var4_6 = (int)Math.min(var5_5, var7_7);
lbl10:
                // 2 sources

                var9_8 = this.zzc;
                var3_4 = zzamq.zza;
                if ((var2_3 = var9_8.read(var1_1, var2_3, var4_6)) == -1) {
                    return -1;
                }
                var5_5 = this.zzd;
                if (var5_5 == -1L) break block4;
            }
            catch (IOException var1_2) {
                throw new zzkc((Throwable)var1_2, 2000);
            }
            this.zzd = var5_5 - (long)var2_3;
        }
        this.zzd(var2_3);
        return var2_3;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzh(zzan object) throws zzkc {
        block11: {
            Object object2 = object.zza;
            this.zzb = object2;
            String string = object2.getPath();
            if (string == null) throw null;
            if (string.startsWith("/android_asset/")) {
                object2 = string.substring(15);
            } else {
                object2 = string;
                if (string.startsWith("/")) {
                    object2 = string.substring(1);
                }
            }
            this.zzb((zzan)object);
            object2 = this.zza.open((String)object2, 1);
            this.zzc = object2;
            if (((InputStream)object2).skip(object.zzf) < object.zzf) break block11;
            long l = object.zzg;
            if (l != -1L) {
                this.zzd = l;
            } else {
                this.zzd = l = (long)this.zzc.available();
                if (l == Integer.MAX_VALUE) {
                    this.zzd = -1L;
                }
            }
            this.zze = true;
            this.zzc((zzan)object);
            return this.zzd;
        }
        try {
            zzkc zzkc2 = new zzkc(null, 2008);
            throw zzkc2;
        }
        catch (IOException iOException) {
            int n;
            if (!(iOException instanceof FileNotFoundException)) {
                n = 2000;
                throw new zzkc((Throwable)iOException, n);
            }
            n = 2005;
            throw new zzkc((Throwable)iOException, n);
        }
        catch (zzkc zzkc3) {
            throw zzkc3;
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
    public final void zzj() throws zzkc {
        Throwable throwable2222222;
        block6: {
            this.zzb = null;
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (!this.zze) return;
            this.zze = false;
            {
                catch (Throwable throwable2222222) {
                    break block6;
                }
                catch (IOException iOException) {}
                {
                    zzkc zzkc2 = new zzkc((Throwable)iOException, 2000);
                    throw zzkc2;
                }
            }
            this.zze();
            return;
        }
        this.zzc = null;
        if (!this.zze) {
            throw throwable2222222;
        }
        this.zze = false;
        this.zze();
        throw throwable2222222;
    }
}
