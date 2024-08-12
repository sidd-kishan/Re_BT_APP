/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.util.Base64
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzazd
 *  com.google.android.gms.internal.ads.zzazf
 *  com.google.android.gms.internal.ads.zzbao
 *  com.google.android.gms.internal.ads.zzbap
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazd;
import com.google.android.gms.internal.ads.zzazf;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbap;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class zzazb {
    private final zzazf zza;
    private final zzbao zzb = zzbap.zze();
    private final boolean zzc;

    private zzazb() {
        this.zzc = false;
        this.zza = new zzazf();
    }

    public zzazb(zzazf zzazf2) {
        this.zza = zzazf2;
        zzazf2 = zzbjl.zzdo;
        this.zzc = (Boolean)zzbet.zzc().zzc((zzbjd)zzazf2);
    }

    public static zzazb zza() {
        return new zzazb();
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private final void zzd(int n) {
        synchronized (this) {
            Object object = this.zzb;
            object.zzd();
            zzazd zzazd2 = zzbjl.zzd();
            Object object2 = new ArrayList();
            Iterator iterator = zzazd2.iterator();
            while (iterator.hasNext()) {
                for (zzazd zzazd3 : ((String)iterator.next()).split(",")) {
                    try {
                        object2.add(Long.valueOf((String)zzazd3));
                    }
                    catch (NumberFormatException numberFormatException) {
                        zze.zza((String)"Experiment ID is not a number");
                    }
                }
            }
            object.zzc(object2);
            object = this.zza;
            object2 = ((zzbap)this.zzb.zzah()).zzao();
            zzazd2 = new zzazd((zzazf)object, (byte[])object2, null);
            zzazd2.zzb(--n);
            zzazd2.zza();
            object = String.valueOf(Integer.toString(n, 10));
            object = ((String)object).length() != 0 ? "Logging Event with event code : ".concat((String)object) : new String("Logging Event with event code : ");
            zze.zza((String)object);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private final void zze(int var1_1) {
        synchronized (this) {
            var2_2 = Environment.getExternalStorageDirectory();
            if (var2_2 == null) {
                return;
            }
            var3_7 = new File((File)var2_2, "clearcut_events.txt");
            var2_2 = new FileOutputStream(var3_7, true);
            {
                catch (FileNotFoundException var2_6) {
                    zze.zza((String)"Could not find file for Clearcut");
                    return;
                }
            }
            var2_2.write(this.zzf(var1_1).getBytes());
            try {
                var2_2.close();
                return;
            }
            catch (IOException var2_3) {
                zze.zza((String)"Could not close Clearcut output stream.");
                return;
            }
            {
                catch (Throwable var3_8) {
                    ** GOTO lbl31
                }
                catch (IOException var3_9) {}
                {
                    zze.zza((String)"Could not write Clearcut to file.");
                }
                try {
                    var2_2.close();
                    return;
                }
                catch (IOException var2_4) {
                    zze.zza((String)"Could not close Clearcut output stream.");
                    return;
                }
lbl31:
                // 1 sources

                try {
                    var2_2.close();
                    throw var3_8;
                }
                catch (IOException var2_5) {
                    zze.zza((String)"Could not close Clearcut output stream.");
                }
                throw var3_8;
            }
        }
    }

    private final String zzf(int n) {
        synchronized (this) {
            String string = String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzb.zza(), zzt.zzj().elapsedRealtime(), n - 1, Base64.encodeToString((byte[])((zzbap)this.zzb.zzah()).zzao(), (int)3));
            return string;
        }
    }

    public final void zzb(zzaza zzaza2) {
        synchronized (this) {
            boolean bl = this.zzc;
            if (!bl) return;
            try {
                zzaza2.zza(this.zzb);
                return;
            }
            catch (NullPointerException nullPointerException) {
                zzt.zzg().zzk((Throwable)nullPointerException, "AdMobClearcutLogger.modify");
                return;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(int n) {
        synchronized (this) {
            boolean bl = this.zzc;
            if (!bl) {
                return;
            }
            zzbjd zzbjd2 = zzbjl.zzdp;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                this.zze(n);
                return;
            }
            this.zzd(n);
            return;
        }
    }
}
