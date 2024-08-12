/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzmv
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzmv;

public final class zzmx {
    public static final int zza = 0;
    private static final int[] zzb = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzmv zza(byte[] byArray) throws zzaha {
        return zzmx.zzb(new zzame(byArray, byArray.length), false);
    }

    public static zzmv zzb(zzame object, boolean bl) throws zzaha {
        int n;
        int n2;
        CharSequence charSequence;
        int n3;
        block22: {
            int n4;
            int n5;
            int n6;
            block26: {
                block25: {
                    block23: {
                        block24: {
                            block21: {
                                int n7;
                                block20: {
                                    n6 = zzmx.zzc((zzame)object);
                                    n3 = zzmx.zzd((zzame)object);
                                    n5 = object.zzh(4);
                                    charSequence = new StringBuilder(19);
                                    charSequence.append("mp4a.40.");
                                    charSequence.append(n6);
                                    charSequence = charSequence.toString();
                                    n4 = 22;
                                    if (n6 == 5) break block20;
                                    n2 = n6;
                                    n = n5;
                                    if (n6 != 29) break block21;
                                }
                                n6 = zzmx.zzd((zzame)object);
                                n2 = n7 = zzmx.zzc((zzame)object);
                                n3 = n6;
                                n = n5;
                                if (n7 == 22) {
                                    n = object.zzh(4);
                                    n3 = n6;
                                    n2 = n7;
                                }
                            }
                            if (!bl) break block22;
                            n6 = 3;
                            if (n2 != 1 && n2 != 2 && n2 != 3 && n2 != 4 && n2 != 6 && n2 != 7 && n2 != 17) {
                                switch (n2) {
                                    default: {
                                        object = new StringBuilder(42);
                                        ((StringBuilder)object).append("Unsupported audio object type: ");
                                        ((StringBuilder)object).append(n2);
                                        throw zzaha.zzc((String)((StringBuilder)object).toString());
                                    }
                                    case 19: 
                                    case 20: 
                                    case 21: 
                                    case 22: 
                                    case 23: 
                                }
                            }
                            if (object.zzg()) {
                                Log.w((String)"AacUtil", (String)"Unexpected frameLengthFlag = 1");
                            }
                            if (object.zzg()) {
                                object.zzf(14);
                            }
                            bl = object.zzg();
                            if (n == 0) throw new UnsupportedOperationException();
                            if (n2 == 6) break block23;
                            if (n2 != 20) break block24;
                            n2 = 20;
                            n5 = 20;
                            break block25;
                        }
                        n5 = n2;
                        break block26;
                    }
                    n5 = n2;
                }
                object.zzf(3);
            }
            if (bl) {
                if (n2 == 22) {
                    object.zzf(16);
                    n2 = n4;
                }
                if (n2 == 17 || n2 == 19 || n2 == 20 || n2 == 23) {
                    object.zzf(3);
                }
                object.zzf(1);
            }
            switch (n5) {
                default: {
                    break;
                }
                case 17: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: {
                    n5 = object.zzh(2);
                    if (n5 != 2) {
                        n2 = n6;
                        if (n5 != 3) {
                            break;
                        }
                    } else {
                        n2 = n5;
                    }
                    object = new StringBuilder(33);
                    ((StringBuilder)object).append("Unsupported epConfig: ");
                    ((StringBuilder)object).append(n2);
                    throw zzaha.zzc((String)((StringBuilder)object).toString());
                }
            }
        }
        if ((n2 = zzc[n]) == -1) throw zzaha.zzb(null, null);
        return new zzmv(n3, n2, (String)charSequence, null);
    }

    private static int zzc(zzame zzame2) {
        int n = zzame2.zzh(5);
        if (n != 31) return n;
        return zzame2.zzh(6) + 32;
    }

    private static int zzd(zzame zzame2) throws zzaha {
        int n = zzame2.zzh(4);
        if (n == 15) {
            n = zzame2.zzh(24);
        } else {
            if (n >= 13) throw zzaha.zzb(null, null);
            n = zzb[n];
        }
        return n;
    }
}
