/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakv
 *  com.google.android.gms.internal.ads.zzalv
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakv;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import java.util.ArrayList;
import java.util.List;

public final class zzne {
    public final List<byte[]> zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final float zze;
    public final String zzf;

    private zzne(List<byte[]> list, int n, int n2, int n3, float f, String string) {
        this.zza = list;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = n3;
        this.zze = f;
        this.zzf = string;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static zzne zza(zzamf object) throws zzaha {
        try {
            object.zzk(4);
            int n = (object.zzn() & 3) + 1;
            if (n != 3) {
                void var0_5;
                float f;
                int n2;
                ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
                int n3 = object.zzn() & 0x1F;
                for (n2 = 0; n2 < n3; ++n2) {
                    arrayList.add(zzne.zzb(object));
                }
                int n4 = object.zzn();
                for (n2 = 0; n2 < n4; ++n2) {
                    arrayList.add(zzne.zzb(object));
                }
                if (n3 > 0) {
                    byte[] byArray = (byte[])arrayList.get(0);
                    zzalv zzalv2 = zzalw.zzb((byte[])((byte[])arrayList.get(0)), (int)n, (int)byArray.length);
                    n3 = zzalv2.zze;
                    n2 = zzalv2.zzf;
                    f = zzalv2.zzg;
                    String string = zzakv.zza((int)zzalv2.zza, (int)zzalv2.zzb, (int)zzalv2.zzc);
                    return new zzne(arrayList, n, n3, n2, f, (String)var0_5);
                }
                Object var0_4 = null;
                n3 = -1;
                n2 = -1;
                f = 1.0f;
                return new zzne(arrayList, n, n3, n2, f, (String)var0_5);
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            zzaha zzaha2 = zzaha.zzb((String)"Error parsing AVC config", (Throwable)arrayIndexOutOfBoundsException);
            throw zzaha2;
        }
    }

    private static byte[] zzb(zzamf zzamf2) {
        int n = zzamf2.zzo();
        int n2 = zzamf2.zzg();
        zzamf2.zzk(n);
        return zzakv.zzc((byte[])zzamf2.zzi(), (int)n2, (int)n);
    }
}
