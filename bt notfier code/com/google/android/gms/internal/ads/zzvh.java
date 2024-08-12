/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

class zzvh
extends X509Certificate {
    private final X509Certificate zza;

    public zzvh(X509Certificate x509Certificate) {
        this.zza = x509Certificate;
    }

    @Override
    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.zza.checkValidity();
    }

    @Override
    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.zza.checkValidity(date);
    }

    @Override
    public final int getBasicConstraints() {
        return this.zza.getBasicConstraints();
    }

    @Override
    public final Set<String> getCriticalExtensionOIDs() {
        return this.zza.getCriticalExtensionOIDs();
    }

    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.zza.getEncoded();
    }

    @Override
    public final byte[] getExtensionValue(String string) {
        return this.zza.getExtensionValue(string);
    }

    @Override
    public final Principal getIssuerDN() {
        return this.zza.getIssuerDN();
    }

    @Override
    public final boolean[] getIssuerUniqueID() {
        return this.zza.getIssuerUniqueID();
    }

    @Override
    public final boolean[] getKeyUsage() {
        return this.zza.getKeyUsage();
    }

    @Override
    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.zza.getNonCriticalExtensionOIDs();
    }

    @Override
    public final Date getNotAfter() {
        return this.zza.getNotAfter();
    }

    @Override
    public final Date getNotBefore() {
        return this.zza.getNotBefore();
    }

    @Override
    public final PublicKey getPublicKey() {
        return this.zza.getPublicKey();
    }

    @Override
    public final BigInteger getSerialNumber() {
        return this.zza.getSerialNumber();
    }

    @Override
    public final String getSigAlgName() {
        return this.zza.getSigAlgName();
    }

    @Override
    public final String getSigAlgOID() {
        return this.zza.getSigAlgOID();
    }

    @Override
    public final byte[] getSigAlgParams() {
        return this.zza.getSigAlgParams();
    }

    @Override
    public final byte[] getSignature() {
        return this.zza.getSignature();
    }

    @Override
    public final Principal getSubjectDN() {
        return this.zza.getSubjectDN();
    }

    @Override
    public final boolean[] getSubjectUniqueID() {
        return this.zza.getSubjectUniqueID();
    }

    @Override
    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.zza.getTBSCertificate();
    }

    @Override
    public final int getVersion() {
        return this.zza.getVersion();
    }

    @Override
    public final boolean hasUnsupportedCriticalExtension() {
        return this.zza.hasUnsupportedCriticalExtension();
    }

    @Override
    public final String toString() {
        return this.zza.toString();
    }

    @Override
    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.zza.verify(publicKey);
    }

    @Override
    public final void verify(PublicKey publicKey, String string) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.zza.verify(publicKey, string);
    }
}
