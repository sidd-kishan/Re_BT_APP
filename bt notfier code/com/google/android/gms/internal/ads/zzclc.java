/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzcld
 *  com.google.android.gms.internal.ads.zzfku
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcld;
import com.google.android.gms.internal.ads.zzfku;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

final class zzclc
implements zzfku {
    private final String zza;

    zzclc(String string) {
        this.zza = string;
    }

    public final URLConnection zza() {
        Object object = this.zza;
        int n = zzcld.zzd;
        zzt.zzo();
        Object object2 = zzbjl.zzu;
        int n2 = (Integer)zzbet.zzc().zzc((zzbjd)object2);
        object = new URL((String)object);
        n = 0;
        while (true) {
            if (++n > 20) {
                object = new IOException("Too many redirects (20)");
                throw object;
            }
            object2 = ((URL)object).openConnection();
            ((URLConnection)object2).setConnectTimeout(n2);
            ((URLConnection)object2).setReadTimeout(n2);
            if (!(object2 instanceof HttpURLConnection)) throw new IOException("Invalid protocol.");
            HttpURLConnection httpURLConnection = (HttpURLConnection)object2;
            object2 = new zzcgs(null);
            object2.zza(httpURLConnection, null);
            httpURLConnection.setInstanceFollowRedirects(false);
            int n3 = httpURLConnection.getResponseCode();
            object2.zzc(httpURLConnection, n3);
            if (n3 / 100 != 3) return httpURLConnection;
            String string = httpURLConnection.getHeaderField("Location");
            if (string == null) throw new IOException("Missing Location header in redirect");
            object2 = new URL((URL)object, string);
            if ((object = ((URL)object2).getProtocol()) == null) throw new IOException("Protocol is null");
            if (!((String)object).equals("http") && !((String)object).equals("https")) {
                if (((String)object).length() != 0) {
                    object = "Unsupported scheme: ".concat((String)object);
                    break;
                }
                object = new String("Unsupported scheme: ");
                break;
            }
            object = string.length() != 0 ? "Redirecting to ".concat(string) : new String("Redirecting to ");
            zze.zzd((String)object);
            httpURLConnection.disconnect();
            object = object2;
        }
        throw new IOException((String)object);
    }
}
