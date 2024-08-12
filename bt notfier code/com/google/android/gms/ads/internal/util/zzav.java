/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.PointF
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.ViewConfiguration
 *  android.view.WindowManager$BadTokenException
 *  com.google.android.gms.ads.internal.util.zzaf
 *  com.google.android.gms.ads.internal.util.zzag
 *  com.google.android.gms.ads.internal.util.zzah
 *  com.google.android.gms.ads.internal.util.zzai
 *  com.google.android.gms.ads.internal.util.zzaj
 *  com.google.android.gms.ads.internal.util.zzak
 *  com.google.android.gms.ads.internal.util.zzal
 *  com.google.android.gms.ads.internal.util.zzam
 *  com.google.android.gms.ads.internal.util.zzan
 *  com.google.android.gms.ads.internal.util.zzao
 *  com.google.android.gms.ads.internal.util.zzap
 *  com.google.android.gms.ads.internal.util.zzaq
 *  com.google.android.gms.ads.internal.util.zzar
 *  com.google.android.gms.ads.internal.util.zzas
 *  com.google.android.gms.ads.internal.util.zzat
 *  com.google.android.gms.ads.internal.util.zzau
 *  com.google.android.gms.ads.internal.util.zzaz
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdxy
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzaf;
import com.google.android.gms.ads.internal.util.zzag;
import com.google.android.gms.ads.internal.util.zzah;
import com.google.android.gms.ads.internal.util.zzai;
import com.google.android.gms.ads.internal.util.zzaj;
import com.google.android.gms.ads.internal.util.zzak;
import com.google.android.gms.ads.internal.util.zzal;
import com.google.android.gms.ads.internal.util.zzam;
import com.google.android.gms.ads.internal.util.zzan;
import com.google.android.gms.ads.internal.util.zzao;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzaq;
import com.google.android.gms.ads.internal.util.zzar;
import com.google.android.gms.ads.internal.util.zzas;
import com.google.android.gms.ads.internal.util.zzat;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzaz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdxy;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzav {
    private final Context zza;
    private final zzdyc zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg = 0;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl = new zzaf(this);

    public zzav(Context context) {
        this.zza = context;
        this.zzh = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        zzt.zzq().zza();
        this.zzk = zzt.zzq().zzb();
        this.zzb = zzt.zzm().zzb();
    }

    public zzav(Context context, String string) {
        this(context);
        this.zzc = string;
    }

    private final boolean zzs(float f, float f2, float f3, float f4) {
        if (!(Math.abs(this.zzi.x - f) < (float)this.zzh)) return false;
        if (!(Math.abs(this.zzi.y - f2) < (float)this.zzh)) return false;
        if (!(Math.abs(this.zzj.x - f3) < (float)this.zzh)) return false;
        if (!(Math.abs(this.zzj.y - f4) < (float)this.zzh)) return false;
        return true;
    }

    private final void zzt(Context object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = zzav.zzu(arrayList, "None", true);
        int n2 = zzav.zzu(arrayList, "Shake", true);
        int n3 = zzav.zzu(arrayList, "Flick", true);
        zzdxy zzdxy2 = zzdxy.zza;
        int n4 = this.zzb.zzf().ordinal();
        if (n4 != 1) {
            if (n4 == 2) {
                n = n3;
            }
        } else {
            n = n2;
        }
        zzdxy2 = new AlertDialog.Builder(object, zzt.zze().zzm());
        object = new AtomicInteger(n);
        zzdxy2.setTitle((CharSequence)"Setup gesture");
        zzdxy2.setSingleChoiceItems((CharSequence[])arrayList.toArray(new String[0]), n, (DialogInterface.OnClickListener)new zzan((AtomicInteger)object));
        zzdxy2.setNegativeButton((CharSequence)"Dismiss", (DialogInterface.OnClickListener)new zzao(this));
        zzdxy2.setPositiveButton((CharSequence)"Save", (DialogInterface.OnClickListener)new zzap(this, (AtomicInteger)object, n, n2, n3));
        zzdxy2.setOnCancelListener((DialogInterface.OnCancelListener)new zzaq(this));
        zzdxy2.create().show();
    }

    private static final int zzu(List<String> list, String string, boolean bl) {
        if (!bl) {
            return -1;
        }
        list.add(string);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("{Dialog: ");
        stringBuilder.append(this.zzc);
        stringBuilder.append(",DebugSignal: ");
        stringBuilder.append(this.zzf);
        stringBuilder.append(",AFMA Version: ");
        stringBuilder.append(this.zze);
        stringBuilder.append(",Ad Unit ID: ");
        stringBuilder.append(this.zzd);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void zza(MotionEvent object) {
        int n = object.getActionMasked();
        int n2 = object.getHistorySize();
        int n3 = object.getPointerCount();
        if (n == 0) {
            this.zzg = 0;
            this.zzi = new PointF(object.getX(0), object.getY(0));
            return;
        }
        int n4 = this.zzg;
        if (n4 == -1) {
            return;
        }
        if (n4 == 0) {
            if (n != 5) return;
            this.zzg = 5;
            this.zzj = new PointF(object.getX(1), object.getY(1));
            Handler handler = this.zzk;
            object = this.zzl;
            zzbjd zzbjd2 = zzbjl.zzdc;
            handler.postDelayed((Runnable)object, ((Long)zzbet.zzc().zzc(zzbjd2)).longValue());
            return;
        }
        if (n4 != 5) return;
        if (n3 == 2) {
            if (n != 2) return;
            n3 = 0;
            for (n = 0; n < n2; n3 |= this.zzs(object.getHistoricalX(0, n), object.getHistoricalY(0, n), object.getHistoricalX(1, n), object.getHistoricalY(1, n)) ^ 1, ++n) {
            }
            if (this.zzs(object.getX(), object.getY(), object.getX(1), object.getY(1))) {
                if (n3 == 0) return;
            }
        }
        this.zzg = -1;
        this.zzk.removeCallbacks(this.zzl);
    }

    public final void zzb() {
        try {
            if (!(this.zza instanceof Activity)) {
                com.google.android.gms.ads.internal.util.zze.zzh((String)"Can not create dialog without Activity Context");
                return;
            }
            boolean bl = TextUtils.isEmpty((CharSequence)zzt.zzm().zzi());
            String string = "Creative preview (enabled)";
            if (bl) {
                string = "Creative preview";
            }
            bl = zzt.zzm().zzm();
            String string2 = "Troubleshooting (enabled)";
            if (!bl) {
                string2 = "Troubleshooting";
            }
            zzam zzam2 = new ArrayList();
            int n = zzav.zzu(zzam2, "Ad information", true);
            int n2 = zzav.zzu(zzam2, string, true);
            int n3 = zzav.zzu(zzam2, string2, true);
            string = zzbjl.zzgE;
            bl = (Boolean)zzbet.zzc().zzc((zzbjd)string);
            int n4 = zzav.zzu(zzam2, "Open ad inspector", bl);
            int n5 = zzav.zzu(zzam2, "Ad inspector settings", bl);
            string2 = new AlertDialog.Builder(this.zza, zzt.zze().zzm());
            string = string2.setTitle((CharSequence)"Select a debug mode");
            CharSequence[] charSequenceArray = zzam2.toArray(new String[0]);
            zzam2 = new zzam(this, n, n2, n3, n4, n5);
            string.setItems(charSequenceArray, (DialogInterface.OnClickListener)zzam2);
            string2.create().show();
            return;
        }
        catch (WindowManager.BadTokenException badTokenException) {
            com.google.android.gms.ads.internal.util.zze.zzb((String)"", (Throwable)badTokenException);
            return;
        }
    }

    public final void zzc(String string) {
        this.zzd = string;
    }

    public final void zzd(String string) {
        this.zze = string;
    }

    public final void zze(String string) {
        this.zzc = string;
    }

    public final void zzf(String string) {
        this.zzf = string;
    }

    final /* synthetic */ void zzg() {
        zzaz zzaz2 = zzt.zzm();
        Context context = this.zza;
        String string = this.zzd;
        String string2 = this.zze;
        String string3 = this.zzf;
        boolean bl = zzaz2.zzm();
        zzaz2.zzl(zzaz2.zze(context, string, string2));
        if (!zzaz2.zzm()) {
            zzaz2.zzf(context, string, string2);
            return;
        }
        if (!bl && !TextUtils.isEmpty((CharSequence)string3)) {
            zzaz2.zzh(context, string2, string3, string);
        }
        com.google.android.gms.ads.internal.util.zze.zzd((String)"Device is linked for debug signals.");
        zzaz2.zzn(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    final /* synthetic */ void zzh() {
        String string;
        String string2;
        Context context;
        zzaz zzaz2 = zzt.zzm();
        if (!zzaz2.zzd(context = this.zza, string2 = this.zzd, string = this.zze)) {
            zzaz2.zzn(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(zzaz2.zza)) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Creative is not pushed for this device.");
            zzaz2.zzn(context, "There was no creative pushed from DFP to the device.", false, false);
            return;
        }
        if ("1".equals(zzaz2.zza)) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"The app is not linked for creative preview.");
            zzaz2.zzf(context, string2, string);
            return;
        }
        if (!"0".equals(zzaz2.zza)) return;
        com.google.android.gms.ads.internal.util.zze.zzd((String)"Device is linked for in app preview.");
        zzaz2.zzn(context, "The device is successfully linked for creative preview.", false, true);
    }

    final /* synthetic */ void zzi(zzfsn zzfsn2) {
        if (!zzt.zzm().zze(this.zza, this.zzd, this.zze)) {
            zzt.zzm().zzf(this.zza, this.zzd, this.zze);
            return;
        }
        zzfsn2.execute((Runnable)new zzak(this));
    }

    final /* synthetic */ void zzj() {
        this.zzt(this.zza);
    }

    final /* synthetic */ void zzk() {
        this.zzt(this.zza);
    }

    final /* synthetic */ void zzl(zzfsn zzfsn2) {
        if (!zzt.zzm().zze(this.zza, this.zzd, this.zze)) {
            zzt.zzm().zzf(this.zza, this.zzd, this.zze);
            return;
        }
        zzfsn2.execute((Runnable)new zzal(this));
    }

    final /* synthetic */ void zzm() {
        zzt.zzm().zzc(this.zza);
    }

    final /* synthetic */ void zzn() {
        zzt.zzm().zzc(this.zza);
    }

    final /* synthetic */ void zzo(String string, DialogInterface dialogInterface, int n) {
        zzt.zzc();
        zzs.zzP((Context)this.zza, (Intent)Intent.createChooser((Intent)new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", string), (CharSequence)"Share via"));
    }

    final /* synthetic */ void zzp(AtomicInteger atomicInteger, int n, int n2, int n3, DialogInterface dialogInterface, int n4) {
        if (atomicInteger.get() != n) {
            if (atomicInteger.get() == n2) {
                this.zzb.zze(zzdxy.zzb);
            } else if (atomicInteger.get() == n3) {
                this.zzb.zze(zzdxy.zzc);
            } else {
                this.zzb.zze(zzdxy.zza);
            }
        }
        this.zzb();
    }

    final /* synthetic */ void zzq(int n, int n2, int n3, int n4, int n5, DialogInterface object, int n6) {
        if (n6 == n) {
            if (!(this.zza instanceof Activity)) {
                com.google.android.gms.ads.internal.util.zze.zzh((String)"Can not create dialog without Activity Context");
                return;
            }
            CharSequence charSequence = this.zzc;
            boolean bl = TextUtils.isEmpty((CharSequence)charSequence);
            object = "No debug information";
            if (!bl) {
                charSequence = ((String)charSequence).replaceAll("\\+", "%20");
                Uri uri = new Uri.Builder().encodedQuery((String)charSequence).build();
                charSequence = new StringBuilder();
                zzt.zzc();
                Map map = zzs.zzR((Uri)uri);
                for (String string : map.keySet()) {
                    ((StringBuilder)charSequence).append(string);
                    ((StringBuilder)charSequence).append(" = ");
                    ((StringBuilder)charSequence).append((String)map.get(string));
                    ((StringBuilder)charSequence).append("\n\n");
                }
                if (!TextUtils.isEmpty((CharSequence)(charSequence = ((StringBuilder)charSequence).toString().trim()))) {
                    object = charSequence;
                }
            }
            charSequence = new AlertDialog.Builder(this.zza);
            charSequence.setMessage((CharSequence)object);
            charSequence.setTitle((CharSequence)"Ad Information");
            charSequence.setPositiveButton((CharSequence)"Share", (DialogInterface.OnClickListener)new zzar(this, (String)object));
            charSequence.setNegativeButton((CharSequence)"Close", zzas.zza);
            charSequence.create().show();
            return;
        }
        if (n6 == n2) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Debug mode [Creative Preview] selected.");
            zzchg.zza.execute((Runnable)new zzai(this));
            return;
        }
        if (n6 == n3) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Debug mode [Troubleshooting] selected.");
            zzchg.zza.execute((Runnable)new zzaj(this));
            return;
        }
        if (n6 == n4) {
            object = zzchg.zze;
            zzfsn zzfsn2 = zzchg.zza;
            if (this.zzb.zzn()) {
                object.execute((Runnable)new zzat(this));
                return;
            }
            zzfsn2.execute((Runnable)new zzau(this, (zzfsn)object));
            return;
        }
        if (n6 != n5) return;
        object = zzchg.zze;
        zzfsn zzfsn3 = zzchg.zza;
        if (this.zzb.zzn()) {
            object.execute((Runnable)new zzag(this));
            return;
        }
        zzfsn3.execute((Runnable)new zzah(this, (zzfsn)object));
    }

    final /* synthetic */ void zzr() {
        this.zzg = 4;
        this.zzb();
    }
}
