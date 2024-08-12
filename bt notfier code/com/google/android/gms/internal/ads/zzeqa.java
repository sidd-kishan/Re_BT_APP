/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzepw
 *  com.google.android.gms.internal.ads.zzeqb
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzepw;
import com.google.android.gms.internal.ads.zzeqb;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final class zzeqa
implements zzery<zzeqb> {
    private final zzfsn zza;
    private final zzfar zzb;
    private final PackageInfo zzc;
    private final zzg zzd;

    public zzeqa(zzfsn zzfsn2, zzfar zzfar2, PackageInfo packageInfo, zzg zzg2) {
        this.zza = zzfsn2;
        this.zzb = zzfar2;
        this.zzc = packageInfo;
        this.zzd = zzg2;
    }

    public final zzfsm<zzeqb> zza() {
        return this.zza.zzb((Callable)new zzepw(this));
    }

    final /* synthetic */ void zzb(ArrayList object, Bundle bundle) {
        block17: {
            block22: {
                String string;
                block18: {
                    block20: {
                        block21: {
                            int n;
                            block19: {
                                bundle.putInt("native_version", 3);
                                bundle.putStringArrayList("native_templates", (ArrayList)object);
                                bundle.putStringArrayList("native_custom_templates", this.zzb.zzh);
                                n = this.zzb.zzi.zza;
                                string = "landscape";
                                if (n > 3) {
                                    bundle.putBoolean("enable_native_media_orientation", true);
                                    n = this.zzb.zzi.zzh;
                                    object = n != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? "unknown" : "square") : "portrait") : "landscape") : "any";
                                    if (!"unknown".equals(object)) {
                                        bundle.putString("native_media_orientation", (String)object);
                                    }
                                }
                                if ((n = this.zzb.zzi.zzc) != 0) {
                                    if (n != 1) {
                                        object = string;
                                        if (n != 2) {
                                            object = "unknown";
                                        }
                                    } else {
                                        object = "portrait";
                                    }
                                } else {
                                    object = "any";
                                }
                                if (!"unknown".equals(object)) {
                                    bundle.putString("native_image_orientation", (String)object);
                                }
                                bundle.putBoolean("native_multiple_images", this.zzb.zzi.zzd);
                                bundle.putBoolean("use_custom_mute", this.zzb.zzi.zzg);
                                object = this.zzc;
                                n = object == null ? 0 : ((PackageInfo)object).versionCode;
                                if (n > this.zzd.zzl()) {
                                    this.zzd.zzy();
                                    this.zzd.zzk(n);
                                }
                                JSONObject jSONObject = this.zzd.zzx();
                                string = null;
                                object = string;
                                if (jSONObject != null) {
                                    jSONObject = jSONObject.optJSONArray(this.zzb.zzf);
                                    object = string;
                                    if (jSONObject != null) {
                                        object = jSONObject.toString();
                                    }
                                }
                                if (!TextUtils.isEmpty((CharSequence)object)) {
                                    bundle.putString("native_advanced_settings", (String)object);
                                }
                                if ((n = this.zzb.zzk) > 1) {
                                    bundle.putInt("max_num_ads", n);
                                }
                                if ((string = this.zzb.zzb) == null) break block17;
                                if (!TextUtils.isEmpty((CharSequence)((zzbrx)string).zzc)) break block18;
                                n = ((zzbrx)string).zza;
                                object = "p";
                                if (n < 2) break block19;
                                n = ((zzbrx)string).zzd;
                                if (n != 2 && n == 3) break block20;
                                break block21;
                            }
                            n = ((zzbrx)string).zzb;
                            if (n == 1) break block21;
                            if (n == 2) break block20;
                            object = new StringBuilder(52);
                            ((StringBuilder)object).append("Instream ad video aspect ratio ");
                            ((StringBuilder)object).append(n);
                            ((StringBuilder)object).append(" is wrong.");
                            zzcgt.zzf((String)((StringBuilder)object).toString());
                        }
                        object = "l";
                    }
                    bundle.putString("ia_var", (String)object);
                    break block22;
                }
                bundle.putString("ad_tag", ((zzbrx)string).zzc);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.zzb.zza() == null) return;
        bundle.putBoolean("has_delayed_banner_listener", true);
    }
}
