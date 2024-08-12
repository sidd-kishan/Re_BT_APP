/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;

public final class zze {
    public static boolean zza(zzfal zzfal2) {
        if (!zze.zze(zzfal2)) {
            return false;
        }
        zzfal2 = zzfal2.zza.zza.zzd;
        if (zzfal2.zzs != null) return true;
        if (zzfal2.zzx == null) return false;
        return true;
    }

    public static String zzb(zzfal zzfal2) {
        if (zze.zze(zzfal2)) return zzfal2.zza.zza.zzd.zzp;
        return "";
    }

    public static String zzc(zzfal object) {
        block20: {
            int n;
            block21: {
                block19: {
                    boolean bl = zze.zze((zzfal)object);
                    String string = "unspecified";
                    if (!bl) {
                        return "unspecified";
                    }
                    object = zze.zzd(((zzfal)object).zza.zza);
                    if (!TextUtils.isEmpty((CharSequence)object)) break block19;
                    object = string;
                    break block20;
                }
                switch (((String)object).hashCode()) {
                    default: {
                        break;
                    }
                    case 1743582868: {
                        if (!((String)object).equals("requester_type_6")) break;
                        n = 6;
                        break block21;
                    }
                    case 1743582867: {
                        if (!((String)object).equals("requester_type_5")) break;
                        n = 5;
                        break block21;
                    }
                    case 1743582866: {
                        if (!((String)object).equals("requester_type_4")) break;
                        n = 4;
                        break block21;
                    }
                    case 1743582865: {
                        if (!((String)object).equals("requester_type_3")) break;
                        n = 3;
                        break block21;
                    }
                    case 1743582864: {
                        if (!((String)object).equals("requester_type_2")) break;
                        n = 2;
                        break block21;
                    }
                    case 1743582863: {
                        if (!((String)object).equals("requester_type_1")) break;
                        n = 1;
                        break block21;
                    }
                    case 1743582862: {
                        if (!((String)object).equals("requester_type_0")) break;
                        n = 0;
                        break block21;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    break;
                }
                case 6: {
                    return "6";
                }
                case 5: {
                    return "5";
                }
                case 4: {
                    return "4";
                }
                case 3: {
                    return "3";
                }
                case 2: {
                    return "2";
                }
                case 1: {
                    return "1";
                }
                case 0: {
                    return "0";
                }
            }
        }
        return object;
    }

    public static String zzd(zzfar zzfar2) {
        zzfar2 = zzfar2.zzd.zzc;
        if (zzfar2 != null) return zzfar2.getString("query_info_type");
        return "unspecified";
    }

    private static boolean zze(zzfal zzfal2) {
        if (zzfal2 == null) return false;
        return true;
    }
}
