/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzabu
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzada
 *  com.google.android.gms.internal.ads.zzadc
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzyc
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzzp
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzada;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzzp;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzacc
extends zzacz {
    private static final zzada<zzzp> zzi = new zzada();
    private final Context zzj;

    public zzacc(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2, Context context, zzyc zzyc2) {
        super(zzabr2, "NK1iwlHEHCICBCLEvTy0TnuhgEeSXovnPs9zKPvVW8trSfaaB+/inefY+5AxSSUI", "/qulcnd5BAOc2NixUFmrPgx+DAD1V/hpoK4nowHOBbg=", zzyj2, n, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            Object object;
            if (this.zzb.zzo() != null) {
                this.zzb.zzo().get();
            }
            if ((object = this.zzb.zzn()) == null) return null;
            if (!object.zza()) return null;
            object = object.zzc();
            return object;
        }
        catch (InterruptedException | ExecutionException exception) {
        }
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Object object;
        Object object2;
        AtomicReference atomicReference = zzi.zza(this.zzj.getPackageName());
        synchronized (atomicReference) {
            object2 = (zzzp)atomicReference.get();
            if (object2 == null || zzabu.zze((String)((zzzp)object2).zza) || ((zzzp)object2).zza.equals("E") || ((zzzp)object2).zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                int n;
                if (!zzabu.zze(null)) {
                    n = 5;
                } else {
                    object2 = !zzabu.zze(null) ? Boolean.valueOf(false) : Boolean.valueOf(false);
                    n = ((Boolean)object2).booleanValue() && this.zzb.zzk() ? 4 : 3;
                }
                boolean bl = n == 3;
                object2 = zzbjl.zzbB;
                Boolean bl2 = (Boolean)zzbet.zzc().zzc((zzbjd)object2);
                object2 = zzbjl.zzbA;
                object2 = (Boolean)zzbet.zzc().zzc((zzbjd)object2) != false ? this.zzb() : null;
                object = object2;
                if (bl2.booleanValue()) {
                    object = object2;
                    if (this.zzb.zzk()) {
                        object = object2;
                        if (zzabu.zze((String)object2)) {
                            object = this.zzc();
                        }
                    }
                }
                object = (String)this.zzf.invoke(null, this.zzj, bl, object);
                object2 = new zzzp((String)object);
                if (zzabu.zze((String)((zzzp)object2).zza) || ((zzzp)object2).zza.equals("E")) {
                    if (--n != 3) {
                        if (n == 4) throw null;
                    } else {
                        object = this.zzc();
                        if (!zzabu.zze((String)object)) {
                            ((zzzp)object2).zza = object;
                        }
                    }
                }
                atomicReference.set(object2);
            }
            object = (zzzp)atomicReference.get();
        }
        object2 = this.zze;
        synchronized (object2) {
            if (object == null) return;
            this.zze.zzo(object.zza);
            this.zze.zzu(object.zzb);
            this.zze.zzt(object.zzc);
            this.zze.zzD(object.zzd);
            this.zze.zzE(object.zze);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    protected final String zzb() {
        Object object = null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Object object2 = zzbjl.zzbC;
            byte[] byArray = zzabu.zzc((String)((String)zzbet.zzc().zzc((zzbjd)object2)));
            object2 = new ArrayList();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            object2.add(certificateFactory.generateCertificate(byteArrayInputStream));
            if (!Build.TYPE.equals("user")) {
                zzbjd zzbjd2 = zzbjl.zzbD;
                byte[] byArray2 = zzabu.zzc((String)((String)zzbet.zzc().zzc(zzbjd2)));
                byteArrayInputStream = new ByteArrayInputStream(byArray2);
                object2.add(certificateFactory.generateCertificate(byteArrayInputStream));
            }
            certificateFactory = this.zzj;
            object2 = zzadc.zza((Context)certificateFactory, (String)certificateFactory.getPackageName(), (List)object2, (Executor)this.zzb.zze());
            return object2;
        }
        catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException throwable) {
            return object;
        }
    }
}
