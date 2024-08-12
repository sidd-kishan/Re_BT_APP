/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;

final class zzjt {
    static String zza(zzgr zzgr2) {
        StringBuilder stringBuilder = new StringBuilder(zzgr2.zzc());
        int n = 0;
        while (n < zzgr2.zzc()) {
            byte by = zzgr2.zza(n);
            if (by != 34) {
                if (by != 39) {
                    if (by != 92) {
                        switch (by) {
                            default: {
                                if (by >= 32 && by <= 126) {
                                    stringBuilder.append((char)by);
                                    break;
                                }
                                stringBuilder.append('\\');
                                stringBuilder.append((char)((by >>> 6 & 3) + 48));
                                stringBuilder.append((char)((by >>> 3 & 7) + 48));
                                stringBuilder.append((char)((by & 7) + 48));
                                break;
                            }
                            case 13: {
                                stringBuilder.append("\\r");
                                break;
                            }
                            case 12: {
                                stringBuilder.append("\\f");
                                break;
                            }
                            case 11: {
                                stringBuilder.append("\\v");
                                break;
                            }
                            case 10: {
                                stringBuilder.append("\\n");
                                break;
                            }
                            case 9: {
                                stringBuilder.append("\\t");
                                break;
                            }
                            case 8: {
                                stringBuilder.append("\\b");
                                break;
                            }
                            case 7: {
                                stringBuilder.append("\\a");
                                break;
                            }
                        }
                    } else {
                        stringBuilder.append("\\\\");
                    }
                } else {
                    stringBuilder.append("\\'");
                }
            } else {
                stringBuilder.append("\\\"");
            }
            ++n;
        }
        return stringBuilder.toString();
    }
}
