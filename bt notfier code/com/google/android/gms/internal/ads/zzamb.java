/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.telephony.PhoneStateListener
 *  android.telephony.TelephonyManager
 *  com.google.android.gms.internal.ads.zzaly
 *  com.google.android.gms.internal.ads.zzama
 *  com.google.android.gms.internal.ads.zzamc
 *  com.google.android.gms.internal.ads.zzamd
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzama;
import com.google.android.gms.internal.ads.zzamc;
import com.google.android.gms.internal.ads.zzamd;
import com.google.android.gms.internal.ads.zzamq;

final class zzamb
extends BroadcastReceiver {
    final zzamd zza;

    /* synthetic */ zzamb(zzamd zzamd2, zzama zzama2) {
        this.zza = zzamd2;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final void onReceive(Context var1_1, Intent var2_3) {
        block24: {
            block25: {
                block21: {
                    block22: {
                        block23: {
                            var2_3 = (ConnectivityManager)var1_1.getSystemService("connectivity");
                            var5_5 = 2;
                            var4_6 = 5;
                            if (var2_3 == null) break block21;
                            try {
                                var2_3 = var2_3.getActiveNetworkInfo();
                            }
                            catch (SecurityException var2_4) {}
                            if (var2_3 == null || !var2_3.isConnected()) break block22;
                            var6_8 = var2_3.getType();
                            if (var6_8 == 0) break block23;
                            var3_7 = var5_5;
                            if (var6_8 == 1) ** GOTO lbl46
                            if (var6_8 == 4 || var6_8 == 5) break block23;
                            if (var6_8 != 6) {
                                var3_7 = var6_8 != 9 ? 8 : 7;
                            }
                            ** GOTO lbl-1000
                            ** GOTO lbl46
                        }
                        var3_7 = var5_5;
                        switch (var2_3.getSubtype()) {
                            case 13: lbl-1000:
                            // 2 sources

                            {
                                var3_7 = 5;
                                ** GOTO lbl46
                            }
                            default: {
                                var3_7 = 6;
                                ** GOTO lbl46
                            }
                            case 20: {
                                if (zzamq.zza < 29) break block21;
                                var3_7 = 9;
                                ** GOTO lbl46
                            }
                            case 3: 
                            case 4: 
                            case 5: 
                            case 6: 
                            case 7: 
                            case 8: 
                            case 9: 
                            case 10: 
                            case 11: 
                            case 12: 
                            case 14: 
                            case 15: 
                            case 17: {
                                var3_7 = 4;
                                ** GOTO lbl46
                            }
                            case 1: 
                            case 2: {
                                var3_7 = 3;
                                ** GOTO lbl46
                            }
                            case 18: {
                                if (zzamq.zza < 29) break block24;
                                break;
                            }
                        }
                        break block25;
                    }
                    var3_7 = 1;
                    ** GOTO lbl46
                }
                var3_7 = 0;
lbl46:
                // 9 sources

                if (zzamq.zza < 29) break block24;
            }
            zzaly.zza();
            if (var3_7 == 5) {
                try {
                    var2_3 = (TelephonyManager)var1_1.getSystemService("phone");
                    if (var2_3 == null) throw null;
                    var1_1 = new zzamc(this.zza, null);
                    if (zzamq.zza < 31) {
                        var2_3.listen((PhoneStateListener)var1_1, 1);
                    } else {
                        var2_3.listen((PhoneStateListener)var1_1, 0x100000);
                    }
                    var2_3.listen((PhoneStateListener)var1_1, 0);
                    return;
                }
                catch (RuntimeException var1_2) {
                    var3_7 = var4_6;
                }
            }
        }
        zzamd.zzd((zzamd)this.zza, (int)var3_7);
    }
}
