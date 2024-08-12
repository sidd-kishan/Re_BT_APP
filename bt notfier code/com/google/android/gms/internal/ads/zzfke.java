/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  com.google.android.gms.common.util.Hex
 *  com.google.android.gms.internal.ads.zzadf
 *  com.google.android.gms.internal.ads.zzadh
 *  com.google.android.gms.internal.ads.zzadi
 *  com.google.android.gms.internal.ads.zzfjl
 *  com.google.android.gms.internal.ads.zzfjw
 *  com.google.android.gms.internal.ads.zzfjy
 *  com.google.android.gms.internal.ads.zzfkd
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzggm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.ads.zzadf;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzadi;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzfkd;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzggm;
import java.io.File;
import java.util.HashSet;

public final class zzfke {
    private static final Object zzf = new Object();
    private final Context zza;
    private final SharedPreferences zzb;
    private final String zzc;
    private final zzfjl zzd;
    private boolean zze = false;

    public zzfke(Context context, int n, zzfjl zzfjl2, boolean bl) {
        this.zza = context;
        this.zzc = Integer.toString(n - 1);
        this.zzb = context.getSharedPreferences("pcvmspf", 0);
        this.zzd = zzfjl2;
        this.zze = bl;
    }

    private final File zze(String string) {
        return new File(new File(this.zza.getDir("pccache", 0), this.zzc), string);
    }

    private final String zzf() {
        String string = String.valueOf(this.zzc);
        string = string.length() != 0 ? "FBAMTD".concat(string) : new String("FBAMTD");
        return string;
    }

    private final String zzg() {
        String string = String.valueOf(this.zzc);
        string = string.length() != 0 ? "LATMTD".concat(string) : new String("LATMTD");
        return string;
    }

    private static String zzh(zzadf zzadf2) {
        zzadh zzadh2 = zzadi.zzi();
        zzadh2.zza(zzadf2.zza().zza());
        zzadh2.zzb(zzadf2.zza().zzc());
        zzadh2.zzd(zzadf2.zza().zze());
        zzadh2.zze(zzadf2.zza().zzf());
        zzadh2.zzc(zzadf2.zza().zzd());
        return Hex.bytesToStringLowercase((byte[])((zzadi)zzadh2.zzah()).zzan().zzz());
    }

    private final void zzi(int n, long l) {
        zzfjl zzfjl2 = this.zzd;
        if (zzfjl2 == null) return;
        zzfjl2.zza(n, l);
    }

    private final void zzj(int n, long l, String string) {
        zzfjl zzfjl2 = this.zzd;
        if (zzfjl2 == null) return;
        zzfjl2.zzb(n, l, string);
    }

    private final zzadi zzk(int n) {
        String string = n == 1 ? this.zzb.getString(this.zzg(), null) : this.zzb.getString(this.zzf(), null);
        if (string == null) {
            return null;
        }
        long l = System.currentTimeMillis();
        try {
            zzgex zzgex2 = zzgex.zzt((byte[])Hex.stringToBytes((String)string));
            string = this.zze ? zzgfm.zza() : zzgfm.zzb();
            string = zzadi.zzh((zzgex)zzgex2, (zzgfm)string);
            return string;
        }
        catch (RuntimeException runtimeException) {
            this.zzi(2032, l);
        }
        catch (NullPointerException nullPointerException) {
            this.zzi(2029, l);
        }
        catch (zzggm zzggm2) {
        }
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zza(zzadf object, zzfkd object2) {
        long l = System.currentTimeMillis();
        Object object3 = zzf;
        synchronized (object3) {
            int n;
            Object object4 = this.zzk(1);
            Object object5 = object.zza().zza();
            int n2 = 0;
            if (object4 != null && object4.zza().equals(object5)) {
                this.zzi(4014, l);
                return false;
            }
            long l2 = System.currentTimeMillis();
            Object object6 = this.zze((String)object5);
            if (((File)object6).exists()) {
                boolean bl = ((File)object6).isDirectory();
                object4 = "1";
                if (!bl) {
                    object4 = "0";
                }
                bl = ((File)object6).isFile();
                object6 = "1";
                if (!bl) {
                    object6 = "0";
                }
                n = ((String)object4).length();
                int n3 = ((String)object6).length();
                StringBuilder stringBuilder = new StringBuilder(n + 5 + n3);
                stringBuilder.append("d:");
                stringBuilder.append((String)object4);
                stringBuilder.append(",f:");
                stringBuilder.append((String)object6);
                this.zzj(4023, l2, stringBuilder.toString());
                this.zzi(4015, l2);
            } else if (!((File)object6).mkdirs()) {
                boolean bl = ((File)object6).canWrite();
                object = "1";
                if (!bl) {
                    object = "0";
                }
                object = ((String)object).length() != 0 ? "cw:".concat((String)object) : new String("cw:");
                this.zzj(4024, l2, (String)object);
                this.zzi(4015, l2);
                return false;
            }
            object5 = this.zze((String)object5);
            object4 = new File((File)object5, "pcam.jar");
            object6 = new File((File)object5, "pcbc");
            if (!zzfjy.zzb((File)object4, (byte[])object.zzc().zzz())) {
                this.zzi(4016, l);
                return false;
            }
            if (!zzfjy.zzb((File)object6, (byte[])object.zzd().zzz())) {
                this.zzi(4017, l);
                return false;
            }
            if (object2 != null && !object2.zza((File)object4)) {
                this.zzi(4018, l);
                zzfjy.zze((File)object5);
                return false;
            }
            object4 = zzfke.zzh((zzadf)object);
            l2 = System.currentTimeMillis();
            object2 = this.zzb.getString(this.zzg(), null);
            object = this.zzb.edit();
            object.putString(this.zzg(), (String)object4);
            if (object2 != null) {
                object.putString(this.zzf(), (String)object2);
            }
            if (!object.commit()) {
                this.zzi(4019, l2);
                return false;
            }
            object = new HashSet();
            object2 = this.zzk(1);
            if (object2 != null) {
                object.add(object2.zza());
            }
            if ((object2 = this.zzk(2)) != null) {
                object.add(object2.zza());
            }
            object2 = new File(this.zza.getDir("pccache", 0), this.zzc);
            object2 = ((File)object2).listFiles();
            n = ((Object)object2).length;
            while (n2 < n) {
                object4 = object2[n2];
                if (!object.contains(((File)object4).getName())) {
                    zzfjy.zze((File)object4);
                }
                ++n2;
            }
            this.zzi(5014, l);
            return true;
        }
    }

    public final boolean zzb(zzadf zzadf2) {
        long l = System.currentTimeMillis();
        Object object = zzf;
        synchronized (object) {
            File file = this.zze(zzadf2.zza().zza());
            Object object2 = new File(file, "pcbc");
            if (!zzfjy.zzb((File)object2, (byte[])zzadf2.zzd().zzz())) {
                this.zzi(4020, l);
                return false;
            }
            object2 = zzfke.zzh(zzadf2);
            zzadf2 = this.zzb.edit();
            zzadf2.putString(this.zzg(), (String)object2);
            boolean bl = zzadf2.commit();
            if (bl) {
                this.zzi(5015, l);
            } else {
                this.zzi(4021, l);
            }
            return bl;
        }
    }

    public final zzfjw zzc(int n) {
        long l = System.currentTimeMillis();
        Object object = zzf;
        synchronized (object) {
            File file;
            zzadi zzadi2 = this.zzk(1);
            if (zzadi2 == null) {
                this.zzi(4022, l);
                return null;
            }
            File file2 = this.zze(zzadi2.zza());
            File file3 = file = new File(file2, "pcam.jar");
            if (!file.exists()) {
                file3 = new File(file2, "pcam");
            }
            File file4 = new File(file2, "pcbc");
            file = new File(file2, "pcopt");
            this.zzi(5016, l);
            file2 = new zzfjw(zzadi2, file3, file4, file);
            return file2;
        }
    }

    public final boolean zzd(int n) {
        long l = System.currentTimeMillis();
        Object object = zzf;
        synchronized (object) {
            Object object2 = this.zzk(1);
            if (object2 == null) {
                this.zzi(4025, l);
                return false;
            }
            File file = new File((File)(object2 = this.zze(object2.zza())), "pcam.jar");
            if (!file.exists()) {
                this.zzi(4026, l);
                return false;
            }
            file = new File((File)object2, "pcbc");
            if (!file.exists()) {
                this.zzi(4027, l);
                return false;
            }
            this.zzi(5019, l);
            return true;
        }
    }
}
