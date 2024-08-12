/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.zzc
 */
package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.zzc;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class zza
extends Thread {
    private final Map zzl;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzl = map;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    public final void run() {
        void var3_5;
        Object object;
        String string;
        CharSequence charSequence2;
        Object object2;
        block11: {
            block10: {
                new zzc();
                object2 = this.zzl;
                Object object3 = Uri.parse((String)"https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
                for (CharSequence charSequence2 : object2.keySet()) {
                    object3.appendQueryParameter((String)charSequence2, (String)object2.get(charSequence2));
                }
                string = object3.build().toString();
                try {
                    object3 = new URL(string);
                    object3 = (HttpURLConnection)((URL)object3).openConnection();
                }
                catch (RuntimeException runtimeException) {
                    break block10;
                }
                catch (IOException iOException) {
                    // empty catch block
                    break block10;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    object = indexOutOfBoundsException.getMessage();
                    object2 = new StringBuilder(String.valueOf(string).length() + 32 + String.valueOf(object).length());
                    charSequence2 = "Error while parsing ping URL: ";
                    break block11;
                }
                try {
                    int n = ((HttpURLConnection)object3).getResponseCode();
                    if (n >= 200) {
                        if (n < 300) return;
                    }
                    int n2 = String.valueOf(string).length();
                    charSequence2 = new StringBuilder(n2 + 65);
                    ((StringBuilder)charSequence2).append("Received non-success response code ");
                    ((StringBuilder)charSequence2).append(n);
                    ((StringBuilder)charSequence2).append(" from pinging URL: ");
                    ((StringBuilder)charSequence2).append(string);
                    Log.w((String)"HttpUrlPinger", (String)((StringBuilder)charSequence2).toString());
                }
                finally {
                    ((HttpURLConnection)object3).disconnect();
                }
                return;
            }
            object = var3_5.getMessage();
            object2 = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(object).length());
            charSequence2 = "Error while pinging URL: ";
        }
        ((StringBuilder)object2).append((String)charSequence2);
        ((StringBuilder)object2).append(string);
        ((StringBuilder)object2).append(". ");
        ((StringBuilder)object2).append((String)object);
        Log.w((String)"HttpUrlPinger", (String)((StringBuilder)object2).toString(), (Throwable)var3_5);
    }
}
