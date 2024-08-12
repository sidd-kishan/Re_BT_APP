/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvh;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

final class zzvg
extends zzvh {
    private final byte[] zza;

    public zzvg(X509Certificate x509Certificate, byte[] byArray) {
        super(x509Certificate);
        this.zza = byArray;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.zza;
    }
}
