/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcla;
import java.util.HashMap;

final class zzckz
implements Runnable {
    final String zza;
    final String zzb;
    final String zzc;
    final String zzd;
    final zzcla zze;

    zzckz(zzcla zzcla2, String string, String string2, String string3, String string4) {
        this.zze = zzcla2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = string4;
    }

    @Override
    public final void run() {
        String string;
        int n;
        String string2;
        HashMap<String, String> hashMap;
        block22: {
            hashMap = new HashMap<String, String>();
            hashMap.put("event", "precacheCanceled");
            hashMap.put("src", this.zza);
            if (!TextUtils.isEmpty((CharSequence)this.zzb)) {
                hashMap.put("cachedSrc", this.zzb);
            }
            string2 = this.zzc;
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 725497484: {
                    if (!string2.equals("noCacheDir")) break;
                    n = 7;
                    break block22;
                }
                case 580119100: {
                    if (!string2.equals("expireFailed")) break;
                    n = 6;
                    break block22;
                }
                case 96784904: {
                    if (!string2.equals("error")) break;
                    n = 1;
                    break block22;
                }
                case 3387234: {
                    if (!string2.equals("noop")) break;
                    n = 4;
                    break block22;
                }
                case -32082395: {
                    if (!string2.equals("externalAbort")) break;
                    n = 10;
                    break block22;
                }
                case -354048396: {
                    if (!string2.equals("sizeExceeded")) break;
                    n = 11;
                    break block22;
                }
                case -642208130: {
                    if (!string2.equals("playerFailed")) break;
                    n = 5;
                    break block22;
                }
                case -659376217: {
                    if (!string2.equals("contentLengthMissing")) break;
                    n = 0;
                    break block22;
                }
                case -918817863: {
                    if (!string2.equals("downloadTimeout")) break;
                    n = 9;
                    break block22;
                }
                case -1347010958: {
                    if (!string2.equals("inProgress")) break;
                    n = 2;
                    break block22;
                }
                case -1396664534: {
                    if (!string2.equals("badUrl")) break;
                    n = 8;
                    break block22;
                }
                case -1947652542: {
                    if (!string2.equals("interrupted")) break;
                    n = 3;
                    break block22;
                }
            }
            n = -1;
        }
        string2 = string = "internal";
        switch (n) {
            default: {
                string2 = string;
                break;
            }
            case 10: 
            case 11: {
                string2 = "policy";
                break;
            }
            case 8: 
            case 9: {
                string2 = "network";
                break;
            }
            case 6: 
            case 7: {
                string2 = "io";
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
        }
        hashMap.put("type", string2);
        hashMap.put("reason", this.zzc);
        if (!TextUtils.isEmpty((CharSequence)this.zzd)) {
            hashMap.put("message", this.zzd);
        }
        zzcla.zzs((zzcla)this.zze, (String)"onPrecacheEvent", hashMap);
    }
}
