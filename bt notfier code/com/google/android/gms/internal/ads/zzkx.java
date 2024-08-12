/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzkv
 *  com.google.android.gms.internal.ads.zzkw
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzkv;
import com.google.android.gms.internal.ads.zzkw;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class zzkx
extends zzag {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzkx() {
        super(false);
    }

    public final int zzg(byte[] byArray, int n, int n2) throws zzkw {
        if (n2 == 0) {
            return 0;
        }
        long l = this.zzc;
        if (l == 0L) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int n3 = zzamq.zza;
            n = randomAccessFile.read(byArray, n, (int)Math.min(l, (long)n2));
            if (n <= 0) return n;
        }
        catch (IOException iOException) {
            throw new zzkw((Throwable)iOException, 2000);
        }
        this.zzc -= (long)n;
        this.zzd(n);
        return n;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final long zzh(zzan zzan2) throws zzkw {
        Object object;
        Uri uri;
        this.zzb = uri = zzan2.zza;
        this.zzb(zzan2);
        int n = 2006;
        try {
            object = uri.getPath();
            if (object == null) throw null;
            this.zza = object = new RandomAccessFile((String)object, "r");
        }
        catch (RuntimeException runtimeException) {
            throw new zzkw((Throwable)runtimeException, 2000);
        }
        catch (SecurityException securityException) {
            throw new zzkw((Throwable)securityException, 2006);
        }
        catch (FileNotFoundException fileNotFoundException) {
            if (!TextUtils.isEmpty((CharSequence)uri.getQuery()) || !TextUtils.isEmpty((CharSequence)uri.getFragment())) throw new zzkw(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), (Throwable)fileNotFoundException, 1004);
            if (zzamq.zza >= 21 && zzkv.zza((Throwable)fileNotFoundException.getCause())) throw new zzkw((Throwable)fileNotFoundException, n);
            n = 2005;
            throw new zzkw((Throwable)fileNotFoundException, n);
        }
        try {
            long l;
            ((RandomAccessFile)object).seek(zzan2.zzf);
            long l2 = l = zzan2.zzg;
            if (l == -1L) {
                l2 = this.zza.length() - zzan2.zzf;
            }
            this.zzc = l2;
            if (l2 < 0L) throw new zzkw(null, null, 2008);
            this.zzd = true;
        }
        catch (IOException iOException) {
            throw new zzkw((Throwable)iOException, 2000);
        }
        this.zzc(zzan2);
        return this.zzc;
    }

    public final Uri zzi() {
        return this.zzb;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void zzj() throws zzkw {
        Throwable throwable2222222;
        block6: {
            this.zzb = null;
            RandomAccessFile randomAccessFile = this.zza;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.zza = null;
            if (!this.zzd) return;
            this.zzd = false;
            {
                catch (Throwable throwable2222222) {
                    break block6;
                }
                catch (IOException iOException) {}
                {
                    zzkw zzkw2 = new zzkw((Throwable)iOException, 2000);
                    throw zzkw2;
                }
            }
            this.zze();
            return;
        }
        this.zza = null;
        if (!this.zzd) {
            throw throwable2222222;
        }
        this.zzd = false;
        this.zze();
        throw throwable2222222;
    }
}
