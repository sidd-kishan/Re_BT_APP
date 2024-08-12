/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzoy
 *  com.google.android.gms.internal.ads.zzoz
 *  com.google.android.gms.internal.ads.zzpa
 *  com.google.android.gms.internal.ads.zzpb
 *  com.google.android.gms.internal.ads.zzpc
 *  com.google.android.gms.internal.ads.zzsk
 *  com.google.android.gms.internal.ads.zzsm
 *  com.google.android.gms.internal.ads.zzsn
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzoy;
import com.google.android.gms.internal.ads.zzoz;
import com.google.android.gms.internal.ads.zzpa;
import com.google.android.gms.internal.ads.zzpb;
import com.google.android.gms.internal.ads.zzpc;
import com.google.android.gms.internal.ads.zzsk;
import com.google.android.gms.internal.ads.zzsm;
import com.google.android.gms.internal.ads.zzsn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzso
extends zzsm {
    private zzsn zza;
    private int zzb;
    private boolean zzc;
    private zzpb zzd;
    private zzoz zze;

    zzso() {
    }

    protected final void zza(boolean bl) {
        super.zza(bl);
        if (bl) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    protected final long zzb(zzamf zzamf2) {
        Object object = zzamf2.zzi();
        int n = 0;
        if ((object[0] & 1) == 1) {
            return -1L;
        }
        byte by = zzamf2.zzi()[0];
        object = this.zza;
        zzakt.zze((Object)object);
        int n2 = object.zze;
        n2 = !object.zzd[by >> 1 & 255 >>> 8 - n2].zza ? object.zza.zze : object.zza.zzf;
        if (this.zzc) {
            n = (this.zzb + n2) / 4;
        }
        long l = n;
        if (zzamf2.zzj() < zzamf2.zze() + 4) {
            object = Arrays.copyOf(zzamf2.zzi(), zzamf2.zze() + 4);
            zzamf2.zzb(object, ((byte[])object).length);
        } else {
            zzamf2.zzf(zzamf2.zze() + 4);
        }
        object = zzamf2.zzi();
        object[zzamf2.zze() - 4] = (byte)(l & 0xFFL);
        object[zzamf2.zze() - 3] = (byte)(l >>> 8 & 0xFFL);
        object[zzamf2.zze() - 2] = (byte)(l >>> 16 & 0xFFL);
        object[zzamf2.zze() - 1] = (byte)(l >>> 24 & 0xFFL);
        this.zzc = true;
        this.zzb = n2;
        return l;
    }

    @EnsuresNonNullIf(expression={"#3.format"}, result=false)
    protected final boolean zzc(zzamf object, long l, zzsk zzsk2) throws IOException {
        Object object2;
        zzpa[] zzpaArray;
        block49: {
            int n;
            int n2;
            Object object3;
            int n3;
            int n4;
            int n5;
            zzpb zzpb2;
            block48: {
                block47: {
                    block46: {
                        int n6;
                        int n7;
                        if (this.zza != null) {
                            if (zzsk2.zza == null) throw null;
                            return false;
                        }
                        zzpb2 = this.zzd;
                        if (zzpb2 != null) break block46;
                        zzpc.zzc((int)1, (zzamf)object, (boolean)false);
                        int n8 = object.zzC();
                        int n9 = object.zzn();
                        int n10 = object.zzC();
                        int n11 = object.zzw();
                        if (n11 <= 0) {
                            n11 = -1;
                        }
                        if ((n7 = object.zzw()) <= 0) {
                            n7 = -1;
                        }
                        if ((n6 = object.zzw()) <= 0) {
                            n6 = -1;
                        }
                        int n12 = object.zzn();
                        int n13 = (int)Math.pow(2.0, n12 & 0xF);
                        n12 = (int)Math.pow(2.0, (n12 & 0xF0) >> 4);
                        int n14 = object.zzn();
                        object = Arrays.copyOf(object.zzi(), object.zze());
                        boolean bl = 1 == (n14 & 1);
                        this.zzd = new zzpb(n8, n9, n10, n11, n7, n6, n13, n12, bl, (byte[])object);
                        break block47;
                    }
                    zzpaArray = this.zze;
                    if (zzpaArray != null) break block48;
                    this.zze = zzpc.zzb((zzamf)object, (boolean)true, (boolean)true);
                }
                object = null;
                break block49;
            }
            object2 = new byte[object.zze()];
            System.arraycopy(object.zzi(), 0, object2, 0, object.zze());
            int n15 = zzpb2.zza;
            zzpc.zzc((int)5, (zzamf)object, (boolean)false);
            int n16 = object.zzn();
            Object object4 = new zzoy(object.zzi());
            object4.zzc(object.zzg() * 8);
            int n17 = 0;
            object = object4;
            while (true) {
                block55: {
                    block54: {
                        block53: {
                            block51: {
                                boolean bl;
                                block52: {
                                    block50: {
                                        if (n17 >= n16 + 1) break block50;
                                        if (object.zzb(24) != 5653314) {
                                            n17 = object.zzd();
                                            object = new StringBuilder(66);
                                            ((StringBuilder)object).append("expected code book to start with [0x56, 0x43, 0x42] at ");
                                            ((StringBuilder)object).append(n17);
                                            throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
                                        }
                                        n5 = object.zzb(16);
                                        n4 = object.zzb(24);
                                        long[] lArray = new long[n4];
                                        bl = object.zza();
                                        l = 0L;
                                        if (bl) break block51;
                                        bl = object.zza();
                                        break block52;
                                    }
                                    n3 = object.zzb(6);
                                    for (n17 = 0; n17 < n3 + 1; ++n17) {
                                        if (object.zzb(16) != 0) throw zzaha.zzb((String)"placeholder of time domain transforms not zeroed out", null);
                                    }
                                    break;
                                }
                                for (n3 = 0; n3 < n4; ++n3) {
                                    if (bl) {
                                        lArray[n3] = object.zza() ? (long)(object.zzb(5) + 1) : 0L;
                                        object4 = object;
                                        continue;
                                    }
                                    object4 = object;
                                    lArray[n3] = object4.zzb(5) + 1;
                                }
                                object3 = object;
                                object4 = zzpaArray;
                                object = object2;
                                break block53;
                            }
                            Object object5 = object;
                            n3 = object5.zzb(5) + 1;
                            n2 = 0;
                            while (true) {
                                object3 = object5;
                                object4 = zzpaArray;
                                object = object2;
                                if (n2 >= n4) break;
                                int n18 = object5.zzb(zzpc.zza((int)(n4 - n2)));
                                for (n = 0; n < n18 && n2 < n4; ++n2, ++n) {
                                    lArray[n2] = n3;
                                }
                                ++n3;
                            }
                        }
                        n = object3.zzb(4);
                        if (n > 2) {
                            object = new StringBuilder(53);
                            ((StringBuilder)object).append("lookup type greater than 2 not decodable: ");
                            ((StringBuilder)object).append(n);
                            throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
                        }
                        n3 = n;
                        if (n == 1) break block54;
                        if (n != 2) break block55;
                        n3 = 2;
                    }
                    object3.zzc(32);
                    object3.zzc(32);
                    n = object3.zzb(4);
                    object3.zzc(1);
                    if (n3 == 1) {
                        if (n5 != 0) {
                            double d = n4;
                            double d2 = n5;
                            Double.isNaN(d2);
                            l = (long)Math.floor(Math.pow(d, 1.0 / d2));
                        }
                    } else {
                        l = (long)n4 * (long)n5;
                    }
                    object3.zzc((int)((long)(n + 1) * l));
                }
                ++n17;
                zzpaArray = object4;
                object2 = object;
                object = object3;
            }
            n4 = object.zzb(6);
            n17 = 0;
            while (true) {
                if (n17 >= n4 + 1) break;
                n3 = object.zzb(16);
                if (n3 == 0) {
                    object.zzc(8);
                    object.zzc(16);
                    object.zzc(16);
                    object.zzc(6);
                    object.zzc(8);
                    n = object.zzb(4);
                    for (n3 = 0; n3 < n + 1; ++n3) {
                        object.zzc(8);
                    }
                } else {
                    if (n3 != 1) {
                        object = new StringBuilder(52);
                        ((StringBuilder)object).append("floor type greater than 1 not decodable: ");
                        ((StringBuilder)object).append(n3);
                        throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
                    }
                    n5 = object.zzb(5);
                    object3 = new int[n5];
                    n2 = -1;
                    for (n = 0; n < n5; ++n) {
                        n16 = object.zzb(4);
                        object3[n] = n16;
                        n3 = n2;
                        if (n16 > n2) {
                            n3 = n16;
                        }
                        n2 = n3;
                    }
                    object4 = new int[++n2];
                    for (n3 = 0; n3 < n2; ++n3) {
                        object4[n3] = (zzpa)(object.zzb(3) + 1);
                        n16 = object.zzb(2);
                        if (n16 > 0) {
                            object.zzc(8);
                        }
                        for (n = 0; n < 1 << n16; ++n) {
                            object.zzc(8);
                        }
                    }
                    object.zzc(2);
                    n16 = object.zzb(4);
                    n2 = 0;
                    n3 = 0;
                    for (n = 0; n < n5; ++n) {
                        n2 += object4[object3[n]];
                        while (n3 < n2) {
                            object.zzc(n16);
                            ++n3;
                        }
                    }
                }
                ++n17;
            }
            n2 = object.zzb(6);
            n17 = 0;
            while (true) {
                if (n17 < n2 + 1) {
                    if (object.zzb(16) > 2) throw zzaha.zzb((String)"residueType greater than 2 is not decodable", null);
                    object.zzc(24);
                    object.zzc(24);
                    object.zzc(24);
                    n16 = object.zzb(6) + 1;
                    object.zzc(8);
                    object4 = new int[n16];
                } else {
                    n2 = object.zzb(6);
                    break;
                }
                for (n3 = 0; n3 < n16; ++n3) {
                    n4 = object.zzb(3);
                    n = object.zza() ? object.zzb(5) : 0;
                    object4[n3] = n * 8 + n4;
                }
                for (n3 = 0; n3 < n16; ++n3) {
                    for (n = 0; n < 8; ++n) {
                        if ((object4[n3] & 1 << n) == 0) continue;
                        object.zzc(8);
                    }
                }
                ++n17;
            }
            for (n17 = 0; n17 < n2 + 1; ++n17) {
                n3 = object.zzb(16);
                if (n3 != 0) {
                    object4 = new StringBuilder(52);
                    ((StringBuilder)object4).append("mapping type other than 0 not supported: ");
                    ((StringBuilder)object4).append(n3);
                    Log.e((String)"VorbisUtil", (String)((StringBuilder)object4).toString());
                    continue;
                }
                n3 = object.zza() ? object.zzb(4) + 1 : 1;
                if (object.zza()) {
                    n16 = object.zzb(8);
                    for (n = 0; n < n16 + 1; ++n) {
                        n4 = n15 - 1;
                        object.zzc(zzpc.zza((int)n4));
                        object.zzc(zzpc.zza((int)n4));
                    }
                }
                if (object.zzb(2) != 0) throw zzaha.zzb((String)"to reserved bits must be zero after mapping coupling steps", null);
                if (n3 > 1) {
                    for (n = 0; n < n15; ++n) {
                        object.zzc(4);
                    }
                }
                for (n = 0; n < n3; ++n) {
                    object.zzc(8);
                    object.zzc(8);
                    object.zzc(8);
                }
            }
            n3 = object.zzb(6) + 1;
            object4 = new zzpa[n3];
            for (n17 = 0; n17 < n3; ++n17) {
                object4[n17] = new zzpa(object.zza(), object.zzb(16), object.zzb(16), object.zzb(8));
            }
            if (!object.zza()) {
                object = zzaha.zzb((String)"framing bit after modes not set as expected", null);
                throw object;
            }
            object = new zzsn(zzpb2, (zzoz)zzpaArray, (byte[])object2, (zzpa[])object4, zzpc.zza((int)(n3 - 1)));
        }
        this.zza = object;
        if (object == null) {
            return true;
        }
        zzpaArray = ((zzsn)object).zza;
        object2 = new ArrayList();
        ((ArrayList)object2).add(zzpaArray.zzg);
        ((ArrayList)object2).add(((zzsn)object).zzc);
        object = new zzaft();
        object.zzN("audio/vorbis");
        object.zzI(zzpaArray.zzd);
        object.zzJ(zzpaArray.zzc);
        object.zzaa(zzpaArray.zza);
        object.zzab(zzpaArray.zzb);
        object.zzP((List)object2);
        zzsk2.zza = object.zzah();
        return true;
    }

    protected final void zzj(long l) {
        super.zzj(l);
        int n = 0;
        boolean bl = l != 0L;
        this.zzc = bl;
        zzpb zzpb2 = this.zzd;
        if (zzpb2 != null) {
            n = zzpb2.zze;
        }
        this.zzb = n;
    }
}
