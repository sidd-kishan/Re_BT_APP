/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

final class zzxb
extends FilterInputStream {
    private final HttpURLConnection zza;

    zzxb(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        }
        catch (IOException iOException) {
            inputStream = httpURLConnection.getErrorStream();
        }
        super(inputStream);
        this.zza = httpURLConnection;
    }

    @Override
    public final void close() throws IOException {
        super.close();
        this.zza.disconnect();
    }
}
