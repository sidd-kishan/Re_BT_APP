/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcig
 *  com.google.android.gms.internal.ads.zzcih
 *  com.google.android.gms.internal.ads.zzcii
 *  com.google.android.gms.internal.ads.zzcik
 *  com.google.android.gms.internal.ads.zzcil
 *  com.google.android.gms.internal.ads.zzcim
 *  com.google.android.gms.internal.ads.zzcin
 *  com.google.android.gms.internal.ads.zzcio
 *  com.google.android.gms.internal.ads.zzcit
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcjc
 *  com.google.android.gms.internal.ads.zzcjd
 *  com.google.android.gms.internal.ads.zzcjs
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcig;
import com.google.android.gms.internal.ads.zzcih;
import com.google.android.gms.internal.ads.zzcii;
import com.google.android.gms.internal.ads.zzcik;
import com.google.android.gms.internal.ads.zzcil;
import com.google.android.gms.internal.ads.zzcim;
import com.google.android.gms.internal.ads.zzcin;
import com.google.android.gms.internal.ads.zzcio;
import com.google.android.gms.internal.ads.zzcit;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcjc;
import com.google.android.gms.internal.ads.zzcjd;
import com.google.android.gms.internal.ads.zzcjs;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcip
extends FrameLayout
implements zzcih {
    private final zzcjb zza;
    private final FrameLayout zzb;
    private final View zzc;
    private final zzbka zzd;
    private final zzcjd zze;
    private final long zzf;
    private final zzcii zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcip(Context object, zzcjb object2, int n, boolean bl, zzbka zzbka2, zzcja zzcja2) {
        super(object);
        FrameLayout frameLayout;
        this.zza = object2;
        this.zzd = zzbka2;
        this.zzb = frameLayout = new FrameLayout(object);
        this.addView((View)frameLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull((Object)object2.zzk());
        frameLayout = object2.zzk().zza;
        frameLayout = object.getApplicationInfo();
        if (frameLayout != null && frameLayout.targetSdkVersion < 11) {
            object2 = null;
        } else {
            frameLayout = new zzcjc(object, object2.zzt(), object2.zzm(), zzbka2, object2.zzi());
            object2 = n == 2 ? new zzcjs(object, (zzcjc)frameLayout, object2, bl, zzcit.zza((zzcjb)object2), zzcja2) : new zzcig(object, object2, bl, zzcit.zza((zzcjb)object2), zzcja2, new zzcjc(object, object2.zzt(), object2.zzm(), zzbka2, object2.zzi()));
        }
        this.zzg = object2;
        object2 = new View(object);
        this.zzc = object2;
        object2.setBackgroundColor(0);
        object2 = this.zzg;
        if (object2 != null) {
            this.zzb.addView((View)object2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
            object2 = zzbjl.zzA;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) {
                this.zzb.addView(this.zzc, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                this.zzb.bringChildToFront(this.zzc);
            }
            object2 = zzbjl.zzx;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) {
                this.zzC();
            }
        }
        this.zzq = new ImageView(object);
        object = zzbjl.zzC;
        this.zzf = (Long)zzbet.zzc().zzc((zzbjd)object);
        object = zzbjl.zzz;
        this.zzk = bl = ((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue();
        object2 = this.zzd;
        if (object2 != null) {
            object = true != bl ? "0" : "1";
            object2.zzd("spinner_used", (String)object);
        }
        this.zze = new zzcjd(this);
        object = this.zzg;
        if (object != null) {
            object.zze((zzcih)this);
        }
        if (this.zzg != null) return;
        this.zzf("AdVideoUnderlay Error", "Allocating player failed.");
    }

    static /* synthetic */ void zzF(zzcip zzcip2, String string, String[] stringArray) {
        zzcip2.zzI(string, stringArray);
    }

    private final boolean zzH() {
        if (this.zzq.getParent() == null) return false;
        return true;
    }

    private final void zzI(String string, String ... stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", string);
        int n = stringArray.length;
        int n2 = 0;
        string = null;
        while (true) {
            if (n2 >= n) {
                this.zza.zze("onVideoEvent", hashMap);
                return;
            }
            String string2 = stringArray[n2];
            if (string == null) {
                string = string2;
            } else {
                hashMap.put(string, string2);
                string = null;
            }
            ++n2;
        }
    }

    private final void zzJ() {
        if (this.zza.zzj() == null) {
            return;
        }
        if (!this.zzi) return;
        if (this.zzj) return;
        this.zza.zzj().getWindow().clearFlags(128);
        this.zzi = false;
    }

    public final void finalize() throws Throwable {
        try {
            this.zze.zza();
            zzcii zzcii2 = this.zzg;
            if (zzcii2 == null) return;
            zzchg.zze.execute(zzcik.zza((zzcii)zzcii2));
            return;
        }
        finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean bl) {
        super.onWindowFocusChanged(bl);
        if (bl) {
            this.zze.zzb();
        } else {
            this.zze.zza();
            this.zzm = this.zzl;
        }
        zzs.zza.post((Runnable)new zzcil(this, bl));
    }

    public final void onWindowVisibilityChanged(int n) {
        boolean bl;
        super.onWindowVisibilityChanged(n);
        if (n == 0) {
            this.zze.zzb();
            bl = true;
        } else {
            this.zze.zza();
            this.zzm = this.zzl;
            bl = false;
        }
        zzs.zza.post((Runnable)new zzcio(this, bl));
    }

    public final void zzA(int n) {
        this.zzg.zzB(n);
    }

    public final void zzB(MotionEvent motionEvent) {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.dispatchTouchEvent(motionEvent);
    }

    public final void zzC() {
        Object object = this.zzg;
        if (object == null) {
            return;
        }
        TextView textView = new TextView(object.getContext());
        object = String.valueOf(this.zzg.zzd());
        object = ((String)object).length() != 0 ? "AdMob - ".concat((String)object) : new String("AdMob - ");
        textView.setText((CharSequence)object);
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.zzb.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzb.bringChildToFront((View)textView);
    }

    public final void zzD() {
        this.zze.zza();
        zzcii zzcii2 = this.zzg;
        if (zzcii2 != null) {
            zzcii2.zzg();
        }
        this.zzJ();
    }

    final void zzE() {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        long l = zzcii2.zzk();
        if (this.zzl == l) return;
        if (l <= 0L) return;
        float f = (float)l / 1000.0f;
        zzcii2 = zzbjl.zzbl;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)zzcii2)).booleanValue()) {
            this.zzI("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzg.zzr()), "qoeCachedBytes", String.valueOf(this.zzg.zzq()), "qoeLoadedBytes", String.valueOf(this.zzg.zzp()), "droppedFrames", String.valueOf(this.zzg.zzs()), "reportTime", String.valueOf(zzt.zzj().currentTimeMillis()));
        } else {
            this.zzI("timeupdate", "time", String.valueOf(f));
        }
        this.zzl = l;
    }

    final /* synthetic */ void zzG(boolean bl) {
        this.zzI("windowFocusChanged", "hasWindowFocus", String.valueOf(bl));
    }

    public final void zza() {
        this.zze.zzb();
        zzs.zza.post((Runnable)new zzcim(this));
    }

    public final void zzb() {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        if (this.zzm != 0L) return;
        int n = zzcii2.zzj();
        int n2 = this.zzg.zzn();
        int n3 = this.zzg.zzo();
        this.zzI("canplaythrough", "duration", String.valueOf((float)n / 1000.0f), "videoWidth", String.valueOf(n2), "videoHeight", String.valueOf(n3));
    }

    public final void zzc() {
        if (this.zza.zzj() != null && !this.zzi) {
            boolean bl = (this.zza.zzj().getWindow().getAttributes().flags & 0x80) != 0;
            this.zzj = bl;
            if (!bl) {
                this.zza.zzj().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzd() {
        this.zzI("pause", new String[0]);
        this.zzJ();
        this.zzh = false;
    }

    public final void zze() {
        this.zzI("ended", new String[0]);
        this.zzJ();
    }

    public final void zzf(String string, String string2) {
        this.zzI("error", "what", string, "extra", string2);
    }

    public final void zzg(String string, String string2) {
        this.zzI("exception", "what", "ExoPlayerAdapter exception", "extra", string2);
    }

    public final void zzh() {
        if (this.zzr && this.zzp != null && !this.zzH()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzb.addView((View)this.zzq, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            this.zzb.bringChildToFront((View)this.zzq);
        }
        this.zze.zza();
        this.zzm = this.zzl;
        zzs.zza.post((Runnable)new zzcin(this));
    }

    public final void zzi() {
        StringBuilder stringBuilder;
        if (this.zzh && this.zzH()) {
            this.zzb.removeView((View)this.zzq);
        }
        if (this.zzp == null) return;
        long l = zzt.zzj().elapsedRealtime();
        if (this.zzg.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        l = zzt.zzj().elapsedRealtime() - l;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            stringBuilder = new StringBuilder(46);
            stringBuilder.append("Spinner frame grab took ");
            stringBuilder.append(l);
            stringBuilder.append("ms");
            com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        }
        if (l <= this.zzf) return;
        com.google.android.gms.ads.internal.util.zze.zzi((String)"Spinner frame grab crossed jank threshold! Suspending spinner.");
        this.zzk = false;
        this.zzp = null;
        stringBuilder = this.zzd;
        if (stringBuilder == null) return;
        stringBuilder.zzd("spinner_jank", Long.toString(l));
    }

    public final void zzj(int n, int n2) {
        if (!this.zzk) {
            return;
        }
        zzbjd zzbjd2 = zzbjl.zzB;
        n = Math.max(n / (Integer)zzbet.zzc().zzc(zzbjd2), 1);
        zzbjd2 = zzbjl.zzB;
        n2 = Math.max(n2 / (Integer)zzbet.zzc().zzc(zzbjd2), 1);
        zzbjd2 = this.zzp;
        if (zzbjd2 != null && zzbjd2.getWidth() == n) {
            if (this.zzp.getHeight() == n2) return;
        }
        this.zzp = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        this.zzr = false;
    }

    public final void zzk() {
        this.zzc.setVisibility(4);
    }

    public final void zzl(int n) {
        zzbjd zzbjd2 = zzbjl.zzA;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        this.zzb.setBackgroundColor(n);
        this.zzc.setBackgroundColor(n);
    }

    public final void zzm(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            stringBuilder = new StringBuilder(75);
            stringBuilder.append("Set video bounds to x:");
            stringBuilder.append(n);
            stringBuilder.append(";y:");
            stringBuilder.append(n2);
            stringBuilder.append(";w:");
            stringBuilder.append(n3);
            stringBuilder.append(";h:");
            stringBuilder.append(n4);
            com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        }
        if (n3 == 0) return;
        if (n4 == 0) return;
        stringBuilder = new FrameLayout.LayoutParams(n3, n4);
        stringBuilder.setMargins(n, n2, 0, 0);
        this.zzb.setLayoutParams((ViewGroup.LayoutParams)stringBuilder);
        this.requestLayout();
    }

    public final void zzn(String string, String[] stringArray) {
        this.zzn = string;
        this.zzo = stringArray;
    }

    public final void zzo(float f, float f2) {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) return;
        zzcii2.zzm(f, f2);
    }

    public final void zzp() {
        if (this.zzg == null) {
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)this.zzn)) {
            this.zzg.zzw(this.zzn, this.zzo);
            return;
        }
        this.zzI("no_src", new String[0]);
    }

    public final void zzq() {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.zzi();
    }

    public final void zzr() {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.zzh();
    }

    public final void zzs(int n) {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.zzl(n);
    }

    public final void zzt() {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.zzb.zza(true);
        zzcii2.zzt();
    }

    public final void zzu() {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.zzb.zza(false);
        zzcii2.zzt();
    }

    public final void zzv(float f) {
        zzcii zzcii2 = this.zzg;
        if (zzcii2 == null) {
            return;
        }
        zzcii2.zzb.zzb(f);
        zzcii2.zzt();
    }

    public final void zzw(int n) {
        this.zzg.zzx(n);
    }

    public final void zzx(int n) {
        this.zzg.zzy(n);
    }

    public final void zzy(int n) {
        this.zzg.zzz(n);
    }

    public final void zzz(int n) {
        this.zzg.zzA(n);
    }
}
