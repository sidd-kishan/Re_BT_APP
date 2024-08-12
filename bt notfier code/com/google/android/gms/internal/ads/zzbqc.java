/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.view.View
 *  androidx.core.app.NotificationManagerCompat
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzt
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzaat
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbki
 *  com.google.android.gms.internal.ads.zzbkj
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbpz
 *  com.google.android.gms.internal.ads.zzbqa
 *  com.google.android.gms.internal.ads.zzbqb
 *  com.google.android.gms.internal.ads.zzbsi
 *  com.google.android.gms.internal.ads.zzbyj
 *  com.google.android.gms.internal.ads.zzcfc
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzcmc
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnn
 *  com.google.android.gms.internal.ads.zzcnr
 *  com.google.android.gms.internal.ads.zzcnw
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzedy
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzflk
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbpz;
import com.google.android.gms.internal.ads.zzbqa;
import com.google.android.gms.internal.ads.zzbqb;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzcfc;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzcmc;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnn;
import com.google.android.gms.internal.ads.zzcnr;
import com.google.android.gms.internal.ads.zzcnw;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzfmg;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zzbqc<T extends zzbcv & zzcmc & zzbsi & zzcnn & zzdio & zzcnw>
implements zzbpr<T> {
    private final zzb zza;
    private final zzdvi zzb;
    private final zzffc zzc;
    private final zzcgy zzd;
    private final zzbyj zze;
    private final zzedq zzf;
    private com.google.android.gms.ads.internal.overlay.zzt zzg = null;

    public zzbqc(zzb zzb2, zzbyj zzbyj2, zzedq zzedq2, zzdvi zzdvi2, zzffc zzffc2) {
        this.zza = zzb2;
        this.zze = zzbyj2;
        this.zzf = zzedq2;
        this.zzb = zzdvi2;
        this.zzc = zzffc2;
        this.zzd = new zzcgy(null);
    }

    public static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    public static int zzd(Map<String, String> object) {
        if ((object = object.get("o")) == null) return -1;
        if ("p".equalsIgnoreCase((String)object)) {
            return 7;
        }
        if ("l".equalsIgnoreCase((String)object)) {
            return 6;
        }
        if (!"c".equalsIgnoreCase((String)object)) return -1;
        return zzt.zze().zzh();
    }

    static Uri zze(Context context, zzaas zzaas2, Uri uri, View view, Activity activity) {
        if (zzaas2 == null) {
            return uri;
        }
        Uri uri2 = uri;
        try {
            if (!zzaas2.zzf(uri)) return uri2;
            uri2 = zzaas2.zze(uri, context, view, activity);
        }
        catch (Exception exception) {
            zzt.zzg().zzk((Throwable)exception, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            uri2 = uri;
        }
        catch (zzaat zzaat2) {
            uri2 = uri;
        }
        return uri2;
    }

    static Uri zzf(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") == null) return uri;
            long l = SystemClock.uptimeMillis();
            Uri uri2 = uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(l)).build();
            return uri2;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            String string = String.valueOf(uri.toString());
            string = string.length() != 0 ? "Error adding click uptime parameter to url: ".concat(string) : new String("Error adding click uptime parameter to url: ");
            com.google.android.gms.ads.internal.util.zze.zzg((String)string, (Throwable)unsupportedOperationException);
        }
        return uri;
    }

    static /* synthetic */ void zzg(zzbqc zzbqc2, int n) {
        zzbqc2.zzk(n);
    }

    private final boolean zzh(T object, Context context, String string, String string2) {
        zzcml zzcml2;
        zzt.zzc();
        boolean bl = zzs.zzI((Context)context);
        zzt.zzc();
        zzbu zzbu2 = zzs.zzD((Context)context);
        zzdvi zzdvi2 = this.zzb;
        if (zzdvi2 != null) {
            zzedy.zzd((Context)context, (zzdvi)zzdvi2, (zzffc)this.zzc, (zzedq)this.zzf, (String)string2, (String)"offline_open");
        }
        boolean bl2 = (zzcml2 = (zzcml)object).zzP().zzg() && zzcml2.zzj() == null;
        if (bl) {
            this.zzf.zzc(this.zzd, string2);
            return false;
        }
        zzt.zzc();
        if (NotificationManagerCompat.from((Context)context).areNotificationsEnabled() && zzbu2 != null && !bl2) {
            zzdvi2 = zzbjl.zzga;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)zzdvi2)).booleanValue()) {
                if (zzcml2.zzP().zzg()) {
                    zzedy.zzc((Activity)zzcml2.zzj(), null, (zzbu)zzbu2, (zzedq)this.zzf, (zzdvi)this.zzb, (zzffc)this.zzc, (String)string2, (String)string);
                } else {
                    ((zzcnr)object).zzaJ(zzbu2, this.zzf, this.zzb, this.zzc, string2, string, zzt.zze().zzh());
                }
                string = this.zzb;
                if (string != null) {
                    zzedy.zzd((Context)context, (zzdvi)string, (zzffc)this.zzc, (zzedq)this.zzf, (String)string2, (String)"dialog_impression");
                }
                object.onAdClicked();
                return true;
            }
        }
        this.zzf.zzd(string2);
        if (this.zzb == null) return false;
        object = new HashMap();
        zzt.zzc();
        if (!NotificationManagerCompat.from((Context)context).areNotificationsEnabled()) {
            object.put((String)"dialog_not_shown_reason", (String)"notifications_disabled");
        } else if (zzbu2 == null) {
            object.put("dialog_not_shown_reason", "work_manager_unavailable");
        } else {
            string = zzbjl.zzga;
            if (!((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
                object.put("dialog_not_shown_reason", "notification_flow_disabled");
            } else if (bl2) {
                object.put("dialog_not_shown_reason", "fullscreen_no_activity");
            }
        }
        zzedy.zzh((Context)context, (zzdvi)this.zzb, (zzffc)this.zzc, (zzedq)this.zzf, (String)string2, (String)"dialog_not_shown", (Map)object);
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzi(T var1_1, Map<String, String> var2_3, boolean var3_4, String var4_5, boolean var5_6) {
        block13: {
            block16: {
                block15: {
                    block14: {
                        var7_7 = 1;
                        this.zzj(true);
                        var12_8 = (zzcml)var1_1 /* !! */ ;
                        var14_9 = var12_8.getContext();
                        var15_10 = var12_8.zzU();
                        var13_11 = var12_8.zzH();
                        var16_12 = (ActivityManager)var14_9.getSystemService("activity");
                        var17_13 = var2_3.get("u");
                        var8_14 = TextUtils.isEmpty((CharSequence)var17_13);
                        var11_15 = null;
                        var10_16 = null;
                        if (!var8_14) break block14;
                        var2_3 = var11_15;
                        break block13;
                    }
                    var11_15 = zzbqc.zzf(zzbqc.zze(var14_9, var15_10, Uri.parse((String)var17_13), var13_11, null));
                    var9_17 = Boolean.parseBoolean(var2_3.get("use_first_package"));
                    var8_14 = Boolean.parseBoolean(var2_3.get("use_running_process"));
                    var6_18 = var7_7;
                    if (!Boolean.parseBoolean(var2_3.get("use_custom_tabs"))) {
                        var2_3 = zzbjl.zzcT;
                        var6_18 = (Boolean)zzbet.zzc().zzc(var2_3) != false ? var7_7 : 0;
                    }
                    if ("http".equalsIgnoreCase(var11_15.getScheme())) {
                        var2_3 = var11_15.buildUpon().scheme("https").build();
                    } else {
                        var2_3 = var10_16;
                        if ("https".equalsIgnoreCase(var11_15.getScheme())) {
                            var2_3 = var11_15.buildUpon().scheme("http").build();
                        }
                    }
                    var17_13 = new ArrayList<E>();
                    var10_16 = zzbqb.zza((Uri)var11_15, (Context)var14_9, (zzaas)var15_10, (View)var13_11);
                    var2_3 = zzbqb.zza((Uri)var2_3, (Context)var14_9, (zzaas)var15_10, (View)var13_11);
                    if (var6_18 != 0) {
                        zzt.zzc();
                        zzs.zzu((Context)var14_9, (Intent)var10_16);
                        zzt.zzc();
                        zzs.zzu((Context)var14_9, (Intent)var2_3);
                    }
                    if ((var11_15 = zzbqb.zzc((Intent)var10_16, (ArrayList)var17_13, (Context)var14_9, (zzaas)var15_10, (View)var13_11)) == null) break block15;
                    var2_3 = zzbqb.zzd((Intent)var10_16, (ResolveInfo)var11_15, (Context)var14_9, (zzaas)var15_10, (View)var13_11);
                    break block13;
                }
                if (var2_3 == null || (var2_3 = zzbqb.zzb((Intent)var2_3, (Context)var14_9, (zzaas)var15_10, (View)var13_11)) == null) break block16;
                var11_15 = zzbqb.zzd((Intent)var10_16, (ResolveInfo)var2_3, (Context)var14_9, (zzaas)var15_10, (View)var13_11);
                var2_3 = var11_15;
                if (zzbqb.zzb((Intent)var11_15, (Context)var14_9, (zzaas)var15_10, (View)var13_11) != null) break block13;
            }
            if (var17_13.size() == 0) ** GOTO lbl-1000
            if (var8_14 && var16_12 != null && (var16_12 = var16_12.getRunningAppProcesses()) != null) {
                var7_7 = var17_13.size();
                for (var6_18 = 0; var6_18 < var7_7; ++var6_18) {
                    var2_3 = (ResolveInfo)var17_13.get(var6_18);
                    var11_15 = var16_12.iterator();
                    while (var11_15.hasNext()) {
                        if (!((ActivityManager.RunningAppProcessInfo)var11_15.next()).processName.equals(var2_3.activityInfo.packageName)) continue;
                        var2_3 = zzbqb.zzd((Intent)var10_16, (ResolveInfo)var2_3, (Context)var14_9, (zzaas)var15_10, (View)var13_11);
                        break block13;
                    }
                }
            }
            if (var9_17) {
                var2_3 = zzbqb.zzd((Intent)var10_16, (ResolveInfo)((ResolveInfo)var17_13.get(0)), (Context)var14_9, (zzaas)var15_10, (View)var13_11);
            } else lbl-1000:
            // 2 sources

            {
                var2_3 = var10_16;
            }
        }
        if (var3_4 && this.zzf != null && var2_3 != null) {
            if (this.zzh(var1_1 /* !! */ , var12_8.getContext(), var2_3.getData().toString(), var4_5) != false) return;
        }
        try {
            var1_1 /* !! */  = (zzcnr)var1_1 /* !! */ ;
            var4_5 = new zzc(var2_3, this.zzg);
            var1_1 /* !! */ .zzaF((zzc)var4_5, var5_6);
            return;
        }
        catch (ActivityNotFoundException var1_2) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)var1_2.getMessage());
            return;
        }
    }

    private final void zzj(boolean bl) {
        zzbyj zzbyj2 = this.zze;
        if (zzbyj2 == null) return;
        zzbyj2.zzb(bl);
    }

    private final void zzk(int n) {
        if (this.zzb == null) {
            return;
        }
        zzbjd zzbjd2 = zzbjl.zzgi;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzbjd2 = this.zzc;
            zzffb zzffb2 = zzffb.zza((String)"cct_action");
            zzffb2.zzc("cct_open_status", zzbki.zza((int)n));
            zzbjd2.zza(zzffb2);
            return;
        }
        zzbjd2 = this.zzb.zzd();
        zzbjd2.zzd("action", "cct_action");
        zzbjd2.zzd("cct_open_status", zzbki.zza((int)n));
        zzbjd2.zze();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(T var1_1, Map<String, String> var2_2) {
        block39: {
            block36: {
                block35: {
                    block38: {
                        block37: {
                            var9_3 = var2_2.get("u");
                            var12_4 = (zzcml)var1_1;
                            var8_5 /* !! */  = var12_4.getContext();
                            var13_6 = true;
                            var10_7 = zzcfc.zza((String)var9_3, (Context)var8_5 /* !! */ , (boolean)true);
                            var14_8 = var2_2.get("a");
                            if (var14_8 == null) {
                                com.google.android.gms.ads.internal.util.zze.zzi((String)"Action missing from an open GMSG.");
                                return;
                            }
                            var8_5 /* !! */  = this.zza;
                            if (var8_5 /* !! */  != null && !var8_5 /* !! */ .zzb()) {
                                this.zza.zzc(var10_7);
                                return;
                            }
                            var8_5 /* !! */  = var12_4.zzF();
                            var9_3 = var12_4.zzaB();
                            var4_9 = false;
                            if (var8_5 /* !! */  != null && var9_3 != null) {
                                var6_10 = var8_5 /* !! */ .zzaf;
                                var8_5 /* !! */  = var9_3.zzb;
                            } else {
                                var8_5 /* !! */  = "";
                                var6_10 = false;
                            }
                            var9_3 = zzbjl.zzgZ;
                            var5_11 = (Boolean)zzbet.zzc().zzc((zzbjd)var9_3) == false || var2_2.containsKey("sc") == false || var2_2.get("sc").equals("0") == false;
                            if ("expand".equalsIgnoreCase(var14_8)) {
                                if (var12_4.zzW()) {
                                    com.google.android.gms.ads.internal.util.zze.zzi((String)"Cannot expand WebView that is already expanded.");
                                    return;
                                }
                                this.zzj(false);
                                ((zzcnr)var1_1).zzaG(zzbqc.zzc(var2_2), zzbqc.zzd(var2_2), var5_11);
                                return;
                            }
                            if ("webapp".equalsIgnoreCase(var14_8)) {
                                this.zzj(false);
                                if (var10_7 != null) {
                                    ((zzcnr)var1_1).zzaH(zzbqc.zzc(var2_2), zzbqc.zzd(var2_2), var10_7, var5_11);
                                    return;
                                }
                                ((zzcnr)var1_1).zzaI(zzbqc.zzc(var2_2), zzbqc.zzd(var2_2), var2_2.get("html"), var2_2.get("baseurl"), var5_11);
                                return;
                            }
                            if (!"chrome_custom_tab".equalsIgnoreCase(var14_8)) break block36;
                            var9_3 = var12_4.getContext();
                            var11_12 = zzbjl.zzcV;
                            if (((Boolean)zzbet.zzc().zzc((zzbjd)var11_12)).booleanValue()) break block37;
                            var3_14 = var4_9;
                            break block35;
                        }
                        var11_12 = zzbjl.zzdb;
                        if (!((Boolean)zzbet.zzc().zzc((zzbjd)var11_12)).booleanValue()) break block38;
                        com.google.android.gms.ads.internal.util.zze.zza((String)"User opt out chrome custom tab.");
                        var3_14 = var4_9;
                        break block35;
                    }
                    var11_12 = zzbjl.zzcZ;
                    if (!((Boolean)zzbet.zzc().zzc((zzbjd)var11_12)).booleanValue()) ** GOTO lbl67
                    var11_12 = zzbjl.zzda;
                    var11_12 = (String)zzbet.zzc().zzc((zzbjd)var11_12);
                    var3_14 = var4_9;
                    if (var11_12.isEmpty()) break block35;
                    if (var9_3 == null) {
                        var3_14 = var4_9;
                    } else {
                        var9_3 = var9_3.getPackageName();
                        var11_12 = zzfmg.zzb((zzflk)zzflk.zzb((char)';')).zzd((CharSequence)var11_12).iterator();
                        do {
                            var3_14 = var4_9;
                            if (!var11_12.hasNext()) break block35;
                        } while (!((String)var11_12.next()).equals(var9_3));
lbl67:
                        // 2 sources

                        var3_14 = true;
                    }
                }
                var7_16 = zzbkj.zza((Context)var12_4.getContext());
                if (var3_14) {
                    if (!var7_16) {
                        this.zzk(4);
                    } else {
                        this.zzj(true);
                        if (TextUtils.isEmpty((CharSequence)var10_7)) {
                            com.google.android.gms.ads.internal.util.zze.zzi((String)"Cannot open browser with null or empty url");
                            this.zzk(7);
                            return;
                        }
                        var2_2 = Uri.parse((String)var10_7);
                        var2_2 = zzbqc.zzf(zzbqc.zze(var12_4.getContext(), var12_4.zzU(), (Uri)var2_2, var12_4.zzH(), var12_4.zzj()));
                        if (var6_10 && this.zzf != null && this.zzh(var1_1, var12_4.getContext(), var2_2.toString(), (String)var8_5 /* !! */ )) {
                            return;
                        }
                        this.zzg = new zzbpz(this);
                        ((zzcnr)var1_1).zzaF(new zzc(null, var2_2.toString(), null, null, null, null, null, null, ObjectWrapper.wrap((Object)this.zzg).asBinder(), true), var5_11);
                        return;
                    }
                }
                var2_2.put((String)"use_first_package", (String)"true");
                var2_2.put("use_running_process", "true");
                this.zzi(var1_1, (Map<String, String>)var2_2, var6_10, (String)var8_5 /* !! */ , var5_11);
                return;
            }
            if ("app".equalsIgnoreCase(var14_8) && "true".equalsIgnoreCase(var2_2.get("system_browser"))) {
                this.zzi(var1_1, (Map<String, String>)var2_2, var6_10, (String)var8_5 /* !! */ , var5_11);
                return;
            }
            if ("open_app".equalsIgnoreCase(var14_8)) {
                var9_3 = zzbjl.zzfS;
                if (!((Boolean)zzbet.zzc().zzc((zzbjd)var9_3)).booleanValue()) {
                    return;
                }
                this.zzj(true);
                var2_2 = var2_2.get("p");
                if (var2_2 == null) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"Package name missing from open app action.");
                    return;
                }
                if (var6_10 && this.zzf != null) {
                    if (this.zzh(var1_1, var12_4.getContext(), (String)var2_2, (String)var8_5 /* !! */ ) != false) return;
                }
                if ((var8_5 /* !! */  = var12_4.getContext().getPackageManager()) == null) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"Cannot get package manager from open app action.");
                    return;
                }
                if ((var2_2 = var8_5 /* !! */ .getLaunchIntentForPackage((String)var2_2)) == null) return;
                ((zzcnr)var1_1).zzaF(new zzc((Intent)var2_2, this.zzg), var5_11);
                return;
            }
            this.zzj(true);
            var16_18 = var2_2.get("intent_url");
            var7_17 = TextUtils.isEmpty((CharSequence)var16_18);
            var11_13 = null;
            var9_3 = var11_13;
            if (!var7_17) {
                try {
                    var9_3 = Intent.parseUri((String)var16_18, (int)0);
                }
                catch (URISyntaxException var15_19) {
                    var9_3 = String.valueOf(var16_18);
                    var9_3 = var9_3.length() != 0 ? "Error parsing the url: ".concat(var9_3) : new String("Error parsing the url: ");
                    com.google.android.gms.ads.internal.util.zze.zzg((String)var9_3, (Throwable)var15_19);
                    var9_3 = var11_13;
                }
            }
            if (var9_3 == null || var9_3.getData() == null || Uri.EMPTY.equals(var11_13 = var9_3.getData())) break block39;
            var11_13 = zzbqc.zzf(zzbqc.zze(var12_4.getContext(), var12_4.zzU(), (Uri)var11_13, var12_4.zzH(), var12_4.zzj()));
            if (TextUtils.isEmpty((CharSequence)var9_3.getType())) ** GOTO lbl-1000
            var15_20 = zzbjl.zzfT;
            if (((Boolean)zzbet.zzc().zzc(var15_20)).booleanValue()) {
                var9_3.setDataAndType((Uri)var11_13, var9_3.getType());
            } else lbl-1000:
            // 2 sources

            {
                var9_3.setData((Uri)var11_13);
            }
        }
        var11_13 = zzbjl.zzge;
        var3_15 = (Boolean)zzbet.zzc().zzc((zzbjd)var11_13) != false && "intent_async".equalsIgnoreCase(var14_8) != false && var2_2.containsKey("event_id") != false;
        var11_13 = new HashMap<K, V>();
        if (var3_15) {
            this.zzg = new zzbqa(this, var5_11, var1_1, (Map)var11_13, (Map)var2_2);
            var5_11 = false;
        }
        if (var9_3 != null) {
            if (var6_10 && this.zzf != null && this.zzh(var1_1, var12_4.getContext(), var9_3.getData().toString(), (String)var8_5 /* !! */ )) {
                if (var3_15 == false) return;
                var11_13.put((String)var2_2.get("event_id"), var13_6);
                ((zzbsi)var1_1).zze("openIntentAsync", (Map)var11_13);
                return;
            }
            ((zzcnr)var1_1).zzaF(new zzc((Intent)var9_3, this.zzg), var5_11);
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)var10_7)) {
            var9_3 = Uri.parse((String)var10_7);
            var9_3 = zzbqc.zzf(zzbqc.zze(var12_4.getContext(), var12_4.zzU(), (Uri)var9_3, var12_4.zzH(), var12_4.zzj())).toString();
        } else {
            var9_3 = var10_7;
        }
        if (var6_10 && this.zzf != null && this.zzh(var1_1, var12_4.getContext(), var9_3, (String)var8_5 /* !! */ )) {
            if (var3_15 == false) return;
            var11_13.put((String)var2_2.get("event_id"), var13_6);
            ((zzbsi)var1_1).zze("openIntentAsync", (Map)var11_13);
            return;
        }
        ((zzcnr)var1_1).zzaF(new zzc((String)var2_2.get("i"), var9_3, (String)var2_2.get("m"), (String)var2_2.get("p"), (String)var2_2.get("c"), (String)var2_2.get("f"), (String)var2_2.get("e"), this.zzg), var5_11);
    }
}
