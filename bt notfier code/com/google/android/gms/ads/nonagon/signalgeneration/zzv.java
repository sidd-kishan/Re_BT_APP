/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.webkit.WebView
 *  com.google.android.gms.ads.AdFormat
 *  com.google.android.gms.ads.internal.util.zzca
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzb
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzf
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzg
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzh
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzi
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzj
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzk
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzl
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzm
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzn
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzo
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzp
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzq
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzr
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzs
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzu
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzx
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzz
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzaat
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdh
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcaf
 *  com.google.android.gms.internal.ads.zzcam
 *  com.google.android.gms.internal.ads.zzcfk
 *  com.google.android.gms.internal.ads.zzcfm
 *  com.google.android.gms.internal.ads.zzcfr
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdgn
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfbj
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;
import com.google.android.gms.ads.nonagon.signalgeneration.zzi;
import com.google.android.gms.ads.nonagon.signalgeneration.zzj;
import com.google.android.gms.ads.nonagon.signalgeneration.zzk;
import com.google.android.gms.ads.nonagon.signalgeneration.zzl;
import com.google.android.gms.ads.nonagon.signalgeneration.zzm;
import com.google.android.gms.ads.nonagon.signalgeneration.zzn;
import com.google.android.gms.ads.nonagon.signalgeneration.zzo;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzr;
import com.google.android.gms.ads.nonagon.signalgeneration.zzs;
import com.google.android.gms.ads.nonagon.signalgeneration.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzx;
import com.google.android.gms.ads.nonagon.signalgeneration.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdh;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdgn;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfbj;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class zzv
extends zzcfm {
    protected static final List<String> zza = new ArrayList<String>(Arrays.asList("/aclk", "/pcs/click"));
    protected static final List<String> zzb = new ArrayList<String>(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List<String> zzc = new ArrayList<String>(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    protected static final List<String> zzd = new ArrayList<String>(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final int zze = 0;
    private final zzcgz zzA;
    private String zzB;
    private final String zzC;
    private final zzcoj zzf;
    private Context zzg;
    private final zzaas zzh;
    private final zzfbj<zzdrh> zzi;
    private final zzfsn zzj;
    private final ScheduledExecutorService zzk;
    private zzcam zzl;
    private Point zzm = new Point();
    private Point zzn = new Point();
    private final Set<WebView> zzo = Collections.newSetFromMap(new WeakHashMap());
    private final zzb zzp;
    private final zzdvi zzq;
    private final zzffc zzr;
    private final zzffu zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final String zzx;
    private final String zzy;
    private final AtomicInteger zzz = new AtomicInteger(0);

    public zzv(zzcoj zzcoj2, Context context, zzaas zzaas2, zzfbj<zzdrh> zzfbj2, zzfsn zzfsn2, ScheduledExecutorService scheduledExecutorService, zzdvi zzdvi2, zzffc zzffc2, zzffu zzffu2, zzcgz zzcgz2) {
        this.zzf = zzcoj2;
        this.zzg = context;
        this.zzh = zzaas2;
        this.zzi = zzfbj2;
        this.zzj = zzfsn2;
        this.zzk = scheduledExecutorService;
        this.zzp = zzcoj2.zzw();
        this.zzq = zzdvi2;
        this.zzr = zzffc2;
        this.zzs = zzffu2;
        this.zzA = zzcgz2;
        zzcoj2 = zzbjl.zzfr;
        this.zzt = (Boolean)zzbet.zzc().zzc((zzbjd)zzcoj2);
        zzcoj2 = zzbjl.zzfq;
        this.zzu = (Boolean)zzbet.zzc().zzc((zzbjd)zzcoj2);
        zzcoj2 = zzbjl.zzfs;
        this.zzv = (Boolean)zzbet.zzc().zzc((zzbjd)zzcoj2);
        zzcoj2 = zzbjl.zzfu;
        this.zzw = (Boolean)zzbet.zzc().zzc((zzbjd)zzcoj2);
        zzcoj2 = zzbjl.zzft;
        this.zzx = (String)zzbet.zzc().zzc((zzbjd)zzcoj2);
        zzcoj2 = zzbjl.zzfv;
        this.zzy = (String)zzbet.zzc().zzc((zzbjd)zzcoj2);
        zzcoj2 = zzbjl.zzfw;
        this.zzC = (String)zzbet.zzc().zzc((zzbjd)zzcoj2);
    }

    static final /* synthetic */ Uri zzF(Uri uri, String string) {
        Uri uri2 = uri;
        if (TextUtils.isEmpty((CharSequence)string)) return uri2;
        uri2 = com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzL(uri, "nas", string);
        return uri2;
    }

    static final /* synthetic */ ArrayList zzG(List list, String string) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list = (Uri)iterator.next();
            if (com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzw((Uri)list) && !TextUtils.isEmpty((CharSequence)string)) {
                arrayList.add(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzL((Uri)list, "nas", string));
                continue;
            }
            arrayList.add(list);
        }
        return arrayList;
    }

    /*
     * Unable to fully structure code
     */
    private static boolean zzH(Uri var0, List<String> var1_1, List<String> var2_2) {
        var3_3 = var0.getHost();
        var0 = var0.getPath();
        if (var3_3 == null) return false;
        if (var0 == null) {
            return false;
        }
        var4_4 = var1_1.iterator();
        block0: while (true) {
            if (var4_4.hasNext() == false) return false;
            if (!var0.contains(var4_4.next())) continue;
            var1_1 = var2_2.iterator();
            do {
                if (var1_1.hasNext()) ** break;
                continue block0;
            } while (!var3_3.endsWith((String)var1_1.next()));
            break;
        }
        return true;
    }

    private final zzg zzI(Context object, String string, String string2, zzbdl zzbdl2, zzbdg zzbdg2) {
        zzf zzf2 = this.zzf.zzu();
        zzdam zzdam2 = new zzdam();
        zzdam2.zze(object);
        zzfap zzfap2 = new zzfap();
        object = string;
        if (string == null) {
            object = "adUnitId";
        }
        zzfap2.zzw((String)object);
        object = zzbdg2;
        if (zzbdg2 == null) {
            object = new zzbdh().zza();
        }
        zzfap2.zzr((zzbdg)object);
        object = zzbdl2;
        if (zzbdl2 == null) {
            object = new zzbdl();
        }
        zzfap2.zzt((zzbdl)object);
        zzdam2.zzf(zzfap2.zzL());
        zzf2.zzc(zzdam2.zzh());
        object = new zzx();
        object.zzb(string2);
        zzf2.zzb(new zzz((zzx)object, null));
        new zzdgn();
        return zzf2.zza();
    }

    private final zzfsm<String> zzJ(String string) {
        zzfru zzfru2 = new zzdrh[1];
        string = zzfsd.zzi((zzfsm)this.zzi.zzb(), (zzfrk)new zzp(this, (zzdrh[])zzfru2, string), (Executor)this.zzj);
        string.zze((Runnable)new zzq(this, (zzdrh[])zzfru2), (Executor)this.zzj);
        zzfru2 = zzfru.zzw((zzfsm)string);
        string = zzbjl.zzfy;
        return zzfsd.zzf((zzfsm)zzfsd.zzj((zzfsm)((zzfru)zzfsd.zzh((zzfsm)zzfru2, (long)((Integer)zzbet.zzc().zzc((zzbjd)string)).intValue(), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzk)), (zzfln)com.google.android.gms.ads.nonagon.signalgeneration.zzn.zza, (Executor)this.zzj), Exception.class, (zzfln)com.google.android.gms.ads.nonagon.signalgeneration.zzo.zza, (Executor)this.zzj);
    }

    private final boolean zzK() {
        Object object = this.zzl;
        if (object == null) return false;
        object = ((zzcam)object).zzb;
        if (object == null) return false;
        if (object.isEmpty()) return false;
        return true;
    }

    private static final Uri zzL(Uri object, String string, String string2) {
        int n;
        String string3 = object.toString();
        int n2 = n = string3.indexOf("&adurl=");
        if (n == -1) {
            n2 = string3.indexOf("?adurl=");
        }
        if (n2 == -1) return object.buildUpon().appendQueryParameter(string, string2).build();
        object = new StringBuilder(string3.substring(0, ++n2));
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("=");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("&");
        ((StringBuilder)object).append(string3.substring(n2));
        return Uri.parse((String)((StringBuilder)object).toString());
    }

    static /* synthetic */ Context zzc(zzv zzv2) {
        return zzv2.zzg;
    }

    static /* synthetic */ zzb zzd(zzv zzv2) {
        return zzv2.zzp;
    }

    static /* synthetic */ zzffu zzk(zzv zzv2) {
        return zzv2.zzs;
    }

    static /* synthetic */ boolean zzl(zzv zzv2) {
        return zzv2.zzt;
    }

    static /* synthetic */ boolean zzm(zzv zzv2) {
        return zzv2.zzu;
    }

    static /* synthetic */ boolean zzn(zzv zzv2) {
        return zzv2.zzv;
    }

    static /* synthetic */ boolean zzo(zzv zzv2) {
        return zzv2.zzw;
    }

    static /* synthetic */ String zzp(zzv zzv2) {
        return zzv2.zzx;
    }

    static /* synthetic */ String zzq(zzv zzv2) {
        return zzv2.zzy;
    }

    static /* synthetic */ AtomicInteger zzr(zzv zzv2) {
        return zzv2.zzz;
    }

    static /* synthetic */ zzcgz zzs(zzv zzv2) {
        return zzv2.zzA;
    }

    static /* synthetic */ String zzt(zzv zzv2) {
        return zzv2.zzB;
    }

    static /* synthetic */ String zzu(zzv zzv2, String string) {
        zzv2.zzB = string;
        return string;
    }

    static /* synthetic */ String zzv(zzv zzv2) {
        return zzv2.zzC;
    }

    static boolean zzw(Uri uri) {
        return com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzH(uri, zzc, zzd);
    }

    static /* synthetic */ Uri zzx(zzv zzv2, Uri uri, String string, String string2) {
        return com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzL(uri, string, "1");
    }

    static /* synthetic */ void zzy(zzv zzv2, String string, String string2, String string3) {
        zzbjd zzbjd2 = zzbjl.zzfl;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        zzbjd2 = zzbjl.zzgi;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzv2 = zzv2.zzr;
            string = zzffb.zza((String)string);
            string.zzc(string2, string3);
            zzv2.zza((zzffb)string);
            return;
        }
        zzv2 = zzv2.zzq.zzd();
        zzv2.zzd("action", string);
        zzv2.zzd(string2, string3);
        zzv2.zze();
    }

    final /* synthetic */ zzfsm zzA(zzdrh[] jSONObject, String string, zzdrh zzdrh2) throws Exception {
        jSONObject[0] = zzdrh2;
        Context context = this.zzg;
        zzcam zzcam2 = this.zzl;
        jSONObject = zzcam2.zzb;
        zzcam2 = zzca.zze((Context)context, (Map)jSONObject, (Map)jSONObject, (View)zzcam2.zza);
        JSONObject jSONObject2 = zzca.zzb((Context)this.zzg, (View)this.zzl.zza);
        jSONObject = zzca.zzc((View)this.zzl.zza);
        JSONObject jSONObject3 = zzca.zzd((Context)this.zzg, (View)this.zzl.zza);
        context = new JSONObject();
        context.put("asset_view_signal", (Object)zzcam2);
        context.put("ad_view_signal", (Object)jSONObject2);
        context.put("scroll_view_signal", (Object)jSONObject);
        context.put("lock_screen_signal", (Object)jSONObject3);
        if (string != "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") return zzdrh2.zzd(string, (JSONObject)context);
        context.put("click_signal", (Object)zzca.zzf(null, (Context)this.zzg, (Point)this.zzn, (Point)this.zzm));
        return zzdrh2.zzd(string, (JSONObject)context);
    }

    final /* synthetic */ zzfsm zzB(Uri uri) throws Exception {
        return zzfsd.zzj(this.zzJ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), (zzfln)new zzm(this, uri), (Executor)this.zzj);
    }

    final /* synthetic */ Uri zzC(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            iObjectWrapper = this.zzh.zze(uri, this.zzg, (View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), null);
            uri = iObjectWrapper;
        }
        catch (zzaat zzaat2) {
            zzcgt.zzj((String)"", (Throwable)zzaat2);
        }
        if (uri.getQueryParameter("ms") == null) throw new Exception("Failed to append spam signals to click url.");
        return uri;
    }

    final /* synthetic */ zzfsm zzD(ArrayList arrayList) throws Exception {
        return zzfsd.zzj(this.zzJ("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), (zzfln)new zzl(this, (List)arrayList), (Executor)this.zzj);
    }

    final /* synthetic */ ArrayList zzE(List object, IObjectWrapper object2) throws Exception {
        object2 = this.zzh.zzb() != null ? this.zzh.zzb().zzo(this.zzg, (View)ObjectWrapper.unwrap((IObjectWrapper)object2), null) : "";
        if (TextUtils.isEmpty((CharSequence)object2)) {
            object = new Exception("Failed to get view signals.");
            throw object;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = object.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                if (arrayList.isEmpty()) throw new Exception("Empty impression URLs result.");
                return arrayList;
            }
            object = (Uri)iterator.next();
            if (!com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzw((Uri)object)) {
                String string = String.valueOf(object);
                String.valueOf(string).length();
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Not a Google URL: ".concat(String.valueOf(string)));
                arrayList.add(object);
                continue;
            }
            arrayList.add(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzL((Uri)object, "ms", (String)object2));
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcfr zzcfr2, zzcfk zzcfk2) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        this.zzg = iObjectWrapper;
        zzfsd.zzp((zzfsm)this.zzI((Context)iObjectWrapper, zzcfr2.zza, zzcfr2.zzb, zzcfr2.zzc, zzcfr2.zzd).zza(), (zzfrz)new zzr(this, zzcfk2), (Executor)this.zzf.zze());
    }

    public final void zzf(IObjectWrapper object) {
        zzbjd zzbjd2 = zzbjl.zzfx;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        zzbjd2 = (MotionEvent)ObjectWrapper.unwrap((IObjectWrapper)object);
        object = this.zzl;
        object = object == null ? null : object.zza;
        this.zzm = zzca.zzh((MotionEvent)zzbjd2, (View)object);
        if (zzbjd2.getAction() == 0) {
            this.zzn = this.zzm;
        }
        object = MotionEvent.obtain((MotionEvent)zzbjd2);
        object.setLocation((float)this.zzm.x, (float)this.zzm.y);
        this.zzh.zzd((MotionEvent)object);
        object.recycle();
    }

    public final void zzg(List<Uri> zzfsm2, IObjectWrapper iObjectWrapper, zzcaf zzcaf2) {
        zzbjd zzbjd2 = zzbjl.zzfx;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            try {
                zzcaf2.zzf("The updating URL feature is not enabled.");
                return;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"", (Throwable)remoteException);
                return;
            }
        }
        zzfsm2 = this.zzj.zzb((Callable)new zzh(this, zzfsm2, iObjectWrapper));
        if (this.zzK()) {
            zzfsm2 = zzfsd.zzi((zzfsm)zzfsm2, (zzfrk)new zzi(this), (Executor)this.zzj);
        } else {
            com.google.android.gms.ads.internal.util.zze.zzh((String)"Asset view map is empty.");
        }
        zzfsd.zzp((zzfsm)zzfsm2, (zzfrz)new zzs(this, zzcaf2), (Executor)this.zzf.zze());
    }

    public final void zzh(List<Uri> zzfsm2, IObjectWrapper object, zzcaf zzcaf2) {
        Object object2;
        try {
            object2 = zzbjl.zzfx;
            if (!((Boolean)zzbet.zzc().zzc(object2)).booleanValue()) {
                zzcaf2.zzf("The updating URL feature is not enabled.");
                return;
            }
            if (zzfsm2.size() != 1) {
                zzcaf2.zzf("There should be only 1 click URL.");
                return;
            }
            object2 = zzfsm2.get(0);
            if (!com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzH((Uri)object2, zza, zzb)) {
                object2 = String.valueOf(object2);
                int n = String.valueOf(object2).length();
                object = new StringBuilder(n + 18);
                ((StringBuilder)object).append("Not a Google URL: ");
                ((StringBuilder)object).append((String)object2);
                com.google.android.gms.ads.internal.util.zze.zzi((String)((StringBuilder)object).toString());
                zzcaf2.zze((List)zzfsm2);
                return;
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
        zzfsm2 = this.zzj.zzb((Callable)new zzj(this, (Uri)object2, (IObjectWrapper)object));
        if (this.zzK()) {
            zzfsm2 = zzfsd.zzi((zzfsm)zzfsm2, (zzfrk)new zzk(this), (Executor)this.zzj);
        } else {
            com.google.android.gms.ads.internal.util.zze.zzh((String)"Asset view map is empty.");
        }
        zzfsd.zzp((zzfsm)zzfsm2, (zzfrz)new zzt(this, zzcaf2), (Executor)this.zzf.zze());
    }

    public final void zzi(zzcam zzcam2) {
        this.zzl = zzcam2;
        this.zzi.zza(1);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        zzbjd zzbjd2 = zzbjl.zzgH;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Not registering the webview because the Android API level is lower than Lollopop which has security risks on webviews.");
            return;
        }
        zzbjd2 = zzbjl.zzgI;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzfsd.zzp((zzfsm)this.zzI(this.zzg, null, AdFormat.BANNER.name(), null, null).zza(), (zzfrz)new zzu(this), (Executor)this.zzf.zze());
        }
        if ((iObjectWrapper = (WebView)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)) == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"The webView cannot be null.");
            return;
        }
        if (this.zzo.contains(iObjectWrapper)) {
            com.google.android.gms.ads.internal.util.zze.zzh((String)"This webview has already been registered.");
            return;
        }
        this.zzo.add((WebView)iObjectWrapper);
        iObjectWrapper.addJavascriptInterface((Object)new TaggingLibraryJsInterface((WebView)iObjectWrapper, this.zzh), "gmaSdk");
    }

    final /* synthetic */ void zzz(zzdrh[] zzdrh2) {
        if ((zzdrh2 = zzdrh2[0]) == null) return;
        this.zzi.zzc(zzfsd.zza((Object)zzdrh2));
    }
}
