/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.provider.CalendarContract$Events
 *  android.text.TextUtils
 *  com.google.android.gms.ads.impl.R$string
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbiv
 *  com.google.android.gms.internal.ads.zzbyf
 *  com.google.android.gms.internal.ads.zzbyg
 *  com.google.android.gms.internal.ads.zzbyp
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbyg;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzcml;
import java.util.Map;

public final class zzbyh
extends zzbyp {
    private final Map<String, String> zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbyh(zzcml zzcml2, Map<String, String> map) {
        super(zzcml2, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcml2.zzj();
        this.zzc = this.zzd("description");
        this.zzf = this.zzd("summary");
        this.zzd = this.zze("start_ticks");
        this.zze = this.zze("end_ticks");
        this.zzg = this.zzd("location");
    }

    static /* synthetic */ Context zza(zzbyh zzbyh2) {
        return zzbyh2.zzb;
    }

    private final String zzd(String string) {
        string = TextUtils.isEmpty((CharSequence)this.zza.get(string)) ? "" : this.zza.get(string);
        return string;
    }

    /*
     * Enabled force condition propagation
     */
    private final long zze(String string) {
        string = this.zza.get(string);
        long l = -1L;
        if (string == null) {
            return -1L;
        }
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            return l;
        }
    }

    public final void zzb() {
        if (this.zzb == null) {
            this.zzf("Activity context is not available.");
            return;
        }
        zzt.zzc();
        if (!new zzbiv(this.zzb).zzb()) {
            this.zzf("This feature is not available on the device.");
            return;
        }
        zzt.zzc();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
        Resources resources = zzt.zzg().zzj();
        String string2 = resources != null ? resources.getString(R.string.s5) : "Create calendar event";
        builder.setTitle((CharSequence)string2);
        string2 = resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?";
        builder.setMessage((CharSequence)string2);
        string2 = resources != null ? resources.getString(R.string.s3) : "Accept";
        builder.setPositiveButton((CharSequence)string2, (DialogInterface.OnClickListener)new zzbyf(this));
        string2 = resources != null ? resources.getString(R.string.s4) : "Decline";
        builder.setNegativeButton((CharSequence)string2, (DialogInterface.OnClickListener)new zzbyg(this));
        builder.create().show();
    }

    final Intent zzc() {
        Intent intent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra("title", this.zzc);
        intent.putExtra("eventLocation", this.zzg);
        intent.putExtra("description", this.zzf);
        long l = this.zzd;
        if (l > -1L) {
            intent.putExtra("beginTime", l);
        }
        if ((l = this.zze) > -1L) {
            intent.putExtra("endTime", l);
        }
        intent.setFlags(0x10000000);
        return intent;
    }
}
