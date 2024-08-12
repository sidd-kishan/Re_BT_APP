/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakv
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakv;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamg;
import java.util.Collections;
import java.util.List;

public final class zzok {
    public final List<byte[]> zza;
    public final int zzb;
    public final String zzc;

    private zzok(List<byte[]> list, int n, String string) {
        this.zza = list;
        this.zzb = n;
        this.zzc = string;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static zzok zza(zzamf object) throws zzaha {
        Object object2;
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        try {
            object.zzk(21);
            n8 = object.zzn();
            n7 = object.zzn();
            n6 = object.zzg();
            n5 = 0;
            for (n4 = 0; n4 < n7; ++n4) {
                object.zzk(1);
                n3 = object.zzo();
                for (n = 0; n < n3; n5 += n2 + 4, ++n) {
                    n2 = object.zzo();
                    object.zzk(n2);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            zzaha zzaha2 = zzaha.zzb((String)"Error parsing HEVC config", (Throwable)arrayIndexOutOfBoundsException);
            throw zzaha2;
        }
        {
            object.zzh(n6);
            byte[] byArray = new byte[n5];
            object2 = null;
            n6 = 0;
            for (n = 0; n < n7; ++n) {
                n2 = object.zzn();
                int n9 = object.zzo();
                n4 = 0;
                zzamg zzamg2 = object2;
                while (n4 < n9) {
                    n3 = object.zzo();
                    System.arraycopy(zzalw.zza, 0, byArray, n6, 4);
                    int n10 = n6 + 4;
                    System.arraycopy(object.zzi(), object.zzg(), byArray, n10, n3);
                    object2 = zzamg2;
                    n6 = n4;
                    if ((n2 & 0x7F) == 33) {
                        object2 = zzamg2;
                        n6 = n4;
                        if (n4 == 0) {
                            object2 = new zzamg(byArray, n10, n10 + n3);
                            object2 = zzakv.zzb((zzamg)object2);
                            n6 = 0;
                        }
                    }
                    n4 = n10 + n3;
                    object.zzk(n3);
                    n3 = n6 + 1;
                    zzamg2 = object2;
                    n6 = n4;
                    n4 = n3;
                }
                object2 = zzamg2;
            }
            object = n5 == 0 ? null : Collections.singletonList(byArray);
        }
        {
            object = new zzok((List<byte[]>)object, (n8 & 3) + 1, (String)object2);
            return object;
        }
    }
}
