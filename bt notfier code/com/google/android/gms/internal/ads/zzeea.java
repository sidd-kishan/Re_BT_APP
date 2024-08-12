/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.webkit.WebView
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbzk
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 *  com.google.android.gms.internal.ads.zzfga
 *  com.google.android.gms.internal.ads.zzfgc
 *  com.google.android.gms.internal.ads.zzfgd
 *  com.google.android.gms.internal.ads.zzfge
 *  com.google.android.gms.internal.ads.zzfgh
 *  com.google.android.gms.internal.ads.zzfgi
 *  com.google.android.gms.internal.ads.zzfgj
 *  com.google.android.gms.internal.ads.zzfgk
 *  com.google.android.gms.internal.ads.zzfgl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzfga;
import com.google.android.gms.internal.ads.zzfgc;
import com.google.android.gms.internal.ads.zzfgd;
import com.google.android.gms.internal.ads.zzfge;
import com.google.android.gms.internal.ads.zzfgh;
import com.google.android.gms.internal.ads.zzfgi;
import com.google.android.gms.internal.ads.zzfgj;
import com.google.android.gms.internal.ads.zzfgk;
import com.google.android.gms.internal.ads.zzfgl;

public final class zzeea
implements zzbzk {
    private static zzfgk zzb(String string) {
        if ("native".equals(string)) {
            return zzfgk.zza;
        }
        if (!"javascript".equals(string)) return zzfgk.zzc;
        return zzfgk.zzb;
    }

    /*
     * Unable to fully structure code
     */
    private static zzfgj zzj(String var0) {
        block4: {
            block2: {
                block3: {
                    var1_1 = var0.hashCode();
                    if (var1_1 == -1104128070) break block2;
                    if (var1_1 == 1318088141) break block3;
                    if (var1_1 != 1988248512 || !var0.equals("onePixel")) ** GOTO lbl-1000
                    var1_1 = 2;
                    break block4;
                }
                if (!var0.equals("definedByJavascript")) ** GOTO lbl-1000
                var1_1 = 1;
                break block4;
            }
            if (var0.equals("beginToRender")) {
                var1_1 = 0;
            } else lbl-1000:
            // 3 sources

            {
                var1_1 = -1;
            }
        }
        if (var1_1 == 0) return zzfgj.zzd;
        if (var1_1 == 1) return zzfgj.zza;
        if (var1_1 == 2) return zzfgj.zze;
        return zzfgj.zzb;
    }

    /*
     * Unable to fully structure code
     */
    private static zzfgh zzk(String var0) {
        block4: {
            block2: {
                block3: {
                    var1_1 = var0.hashCode();
                    if (var1_1 == -382745961) break block2;
                    if (var1_1 == 112202875) break block3;
                    if (var1_1 != 714893483 || !var0.equals("nativeDisplay")) ** GOTO lbl-1000
                    var1_1 = 1;
                    break block4;
                }
                if (!var0.equals("video")) ** GOTO lbl-1000
                var1_1 = 2;
                break block4;
            }
            if (var0.equals("htmlDisplay")) {
                var1_1 = 0;
            } else lbl-1000:
            // 3 sources

            {
                var1_1 = -1;
            }
        }
        if (var1_1 == 0) return zzfgh.zzb;
        if (var1_1 == 1) return zzfgh.zzc;
        if (var1_1 == 2) return zzfgh.zzd;
        return null;
    }

    public final boolean zza(Context context) {
        zzbjd zzbjd2 = zzbjl.zzdu;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zze.zzi((String)"Omid flag is disabled");
            return false;
        }
        if (zzfga.zzb()) {
            return true;
        }
        zzfga.zza((Context)context);
        return zzfga.zzb();
    }

    public final String zzc(Context context) {
        context = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)context) != false) return "a.1.3.3-google_20200416";
        return null;
    }

    public final IObjectWrapper zzd(String string, WebView webView, String string2, String string3, String string4, zzbzm zzbzm2, zzbzl zzbzl2, String string5) {
        string2 = zzbjl.zzdu;
        boolean bl = (Boolean)zzbet.zzc().zzc((zzbjd)string2);
        string2 = string3 = null;
        if (!bl) return string2;
        if (!zzfga.zzb()) {
            string2 = string3;
        } else {
            zzfgl zzfgl2 = zzfgl.zza((String)"Google", (String)string);
            string2 = zzeea.zzb("javascript");
            string = zzeea.zzk(zzbzl2.toString());
            if (string2 == zzfgk.zzc) {
                zze.zzi((String)"Omid html session error; Unable to parse impression owner: javascript");
                string2 = string3;
            } else if (string == null) {
                string = String.valueOf(zzbzl2);
                String.valueOf(string).length();
                zze.zzi((String)"Omid html session error; Unable to parse creative type: ".concat(String.valueOf(string)));
                string2 = string3;
            } else {
                zzbzl2 = zzeea.zzb(string4);
                if (string == zzfgh.zzd && zzbzl2 == zzfgk.zzc) {
                    string = String.valueOf(string4);
                    string = string.length() != 0 ? "Omid html session error; Video events owner unknown for video creative: ".concat(string) : new String("Omid html session error; Video events owner unknown for video creative: ");
                    zze.zzi((String)string);
                    string2 = string3;
                } else {
                    webView = zzfge.zza((zzfgl)zzfgl2, (WebView)webView, (String)string5, (String)"");
                    string2 = ObjectWrapper.wrap((Object)zzfgc.zze((zzfgd)zzfgd.zza((zzfgh)string, (zzfgj)zzeea.zzj(zzbzm2.toString()), (zzfgk)string2, (zzfgk)zzbzl2, (boolean)true), (zzfge)webView));
                }
            }
        }
        return string2;
    }

    public final IObjectWrapper zze(String string, WebView webView, String string2, String string3, String string4, String string5, zzbzm zzbzm2, zzbzl zzbzl2, String string6) {
        string2 = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string2) == false) return null;
        if (!zzfga.zzb()) {
            return null;
        }
        string5 = zzfgl.zza((String)string5, (String)string);
        string = zzeea.zzb("javascript");
        string2 = zzeea.zzb(string4);
        string3 = zzeea.zzk(zzbzl2.toString());
        if (string == zzfgk.zzc) {
            zze.zzi((String)"Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (string3 == null) {
            string = String.valueOf(zzbzl2);
            String.valueOf(string).length();
            zze.zzi((String)"Omid js session error; Unable to parse creative type: ".concat(String.valueOf(string)));
            return null;
        }
        if (string3 == zzfgh.zzd && string2 == zzfgk.zzc) {
            string = String.valueOf(string4);
            string = string.length() != 0 ? "Omid js session error; Video events owner unknown for video creative: ".concat(string) : new String("Omid js session error; Video events owner unknown for video creative: ");
            zze.zzi((String)string);
            return null;
        }
        webView = zzfge.zzb((zzfgl)string5, (WebView)webView, (String)string6, (String)"");
        return ObjectWrapper.wrap((Object)zzfgc.zze((zzfgd)zzfgd.zza((zzfgh)string3, (zzfgj)zzeea.zzj(zzbzm2.toString()), (zzfgk)string, (zzfgk)string2, (boolean)true), (zzfge)webView));
    }

    public final void zzf(IObjectWrapper object) {
        zzbjd zzbjd2 = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (!zzfga.zzb()) return;
        if (!((object = ObjectWrapper.unwrap((IObjectWrapper)object)) instanceof zzfgc)) return;
        ((zzfgc)object).zza();
    }

    public final void zzg(IObjectWrapper object) {
        zzbjd zzbjd2 = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (!zzfga.zzb()) return;
        if (!((object = ObjectWrapper.unwrap((IObjectWrapper)object)) instanceof zzfgc)) return;
        ((zzfgc)object).zzc();
    }

    public final void zzh(IObjectWrapper object, View view) {
        zzbjd zzbjd2 = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (!zzfga.zzb()) return;
        if (!((object = ObjectWrapper.unwrap((IObjectWrapper)object)) instanceof zzfgc)) return;
        ((zzfgc)object).zzb(view);
    }

    public final void zzi(IObjectWrapper object, View view) {
        zzbjd zzbjd2 = zzbjl.zzdu;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (!zzfga.zzb()) return;
        if (!((object = ObjectWrapper.unwrap((IObjectWrapper)object)) instanceof zzfgc)) return;
        ((zzfgc)object).zzd(view, zzfgi.zzc, "Ad overlay");
    }
}
