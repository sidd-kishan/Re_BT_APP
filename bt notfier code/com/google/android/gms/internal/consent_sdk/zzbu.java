/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  android.util.JsonWriter
 *  com.google.android.gms.internal.consent_sdk.zzbq
 */
package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.android.gms.internal.consent_sdk.zzbq;
import java.io.IOException;

public final class zzbu {
    public static final /* enum */ int zza = 1;
    public static final /* enum */ int zzb = 2;
    public static final /* enum */ int zzc = 3;
    public static final /* enum */ int zzd = 1;
    public static final /* enum */ int zze = 2;
    public static final /* enum */ int zzf = 3;
    public static final /* enum */ int zzg = 1;
    public static final /* enum */ int zzh = 2;
    public static final /* enum */ int zzi = 3;
    public static final /* enum */ int zzj = 4;
    public static final /* enum */ int zzk = 5;
    public static final /* enum */ int zzl = 6;
    public static final /* enum */ int zzm = 7;
    public static final /* enum */ int zzn = 8;
    private static final int[] zzo = new int[]{1, 2, 3};
    private static final int[] zzp = new int[]{1, 2, 3};
    private static final int[] zzq = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    /*
     * Unable to fully structure code
     */
    public static int zza(JsonReader var0) throws IOException {
        block4: {
            block2: {
                block3: {
                    var1_1 = (var0 = var0.nextString()).hashCode();
                    if (var1_1 == 64208429) break block2;
                    if (var1_1 == 82862015) break block3;
                    if (var1_1 != 1856333582 || !var0.equals("UNKNOWN_ACTION_TYPE")) ** GOTO lbl-1000
                    var1_1 = 0;
                    break block4;
                }
                if (!var0.equals("WRITE")) ** GOTO lbl-1000
                var1_1 = 1;
                break block4;
            }
            if (var0.equals("CLEAR")) {
                var1_1 = 2;
            } else lbl-1000:
            // 3 sources

            {
                var1_1 = -1;
            }
        }
        if (var1_1 == 0) return zzbu.zzd;
        if (var1_1 == 1) return zzbu.zze;
        if (var1_1 == 2) return zzbu.zzf;
        var0 = (var0 = String.valueOf(var0)).length() != 0 ? "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.Action.ActionTypefrom: ".concat((String)var0) : new String("Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.Action.ActionTypefrom: ");
        throw new IOException((String)var0);
    }

    public static void zza(int n, JsonWriter jsonWriter) throws IOException {
        if (n == 0) throw null;
        if ((n = zzbq.zza[n - 1]) == 1) {
            jsonWriter.value("UNKNOWN");
            return;
        }
        if (n == 2) {
            jsonWriter.value("ANDROID");
            return;
        }
        if (n != 3) return;
        jsonWriter.value("IOS");
    }

    public static int[] zza() {
        return (int[])zzo.clone();
    }

    public static int zzb(JsonReader object) throws IOException {
        int n;
        block20: {
            object = object.nextString();
            switch (((String)object).hashCode()) {
                default: {
                    break;
                }
                case 1725474845: {
                    if (!((String)object).equals("CONSENT_SIGNAL_NOT_REQUIRED")) break;
                    n = 5;
                    break block20;
                }
                case 467888915: {
                    if (!((String)object).equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) break;
                    n = 1;
                    break block20;
                }
                case 429411856: {
                    if (!((String)object).equals("CONSENT_SIGNAL_SUFFICIENT")) break;
                    n = 3;
                    break block20;
                }
                case -918677260: {
                    if (!((String)object).equals("CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION")) break;
                    n = 7;
                    break block20;
                }
                case -954325659: {
                    if (!((String)object).equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) break;
                    n = 2;
                    break block20;
                }
                case -1263695752: {
                    if (!((String)object).equals("CONSENT_SIGNAL_UNKNOWN")) break;
                    n = 0;
                    break block20;
                }
                case -1969035850: {
                    if (!((String)object).equals("CONSENT_SIGNAL_ERROR")) break;
                    n = 6;
                    break block20;
                }
                case -2058725357: {
                    if (!((String)object).equals("CONSENT_SIGNAL_COLLECT_CONSENT")) break;
                    n = 4;
                    break block20;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                object = String.valueOf(object);
                object = ((String)object).length() != 0 ? "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.ConsentSignalfrom: ".concat((String)object) : new String("Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.ConsentSignalfrom: ");
            }
            case 7: {
                return zzn;
            }
            case 6: {
                return zzm;
            }
            case 5: {
                return zzl;
            }
            case 4: {
                return zzk;
            }
            case 3: {
                return zzj;
            }
            case 2: {
                return zzi;
            }
            case 1: {
                return zzh;
            }
            case 0: {
                return zzg;
            }
        }
        throw new IOException((String)object);
    }

    public static int[] zzb() {
        return (int[])zzp.clone();
    }

    public static int[] zzc() {
        return (int[])zzq.clone();
    }
}
