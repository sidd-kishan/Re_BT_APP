/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgco
 *  com.google.android.gms.internal.ads.zzgcx
 *  com.google.android.gms.internal.ads.zzgcz
 *  com.google.android.gms.internal.ads.zzgdb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgco;
import com.google.android.gms.internal.ads.zzgcx;
import com.google.android.gms.internal.ads.zzgcz;
import com.google.android.gms.internal.ads.zzgdb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class zzgcy {
    private final ECPublicKey zza;

    public zzgcy(ECPublicKey eCPublicKey) {
        this.zza = eCPublicKey;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final zzgcx zza(String var1_1, byte[] var2_6, byte[] var3_7, int var4_8, int var5_9) throws GeneralSecurityException {
        block26: {
            var11_10 = zzgcz.zzc((ECParameterSpec)this.zza.getParams());
            var16_11 = (ECPublicKey)var11_10.getPublic();
            var11_10 = (ECPrivateKey)var11_10.getPrivate();
            var13_12 = this.zza;
            var14_13 = var13_12.getParams();
            var12_14 = var11_10.getParams();
            if (!var14_13.getCurve().equals(var12_14.getCurve()) || !var14_13.getGenerator().equals(var12_14.getGenerator()) || !var14_13.getOrder().equals(var12_14.getOrder()) || (var7_15 = var14_13.getCofactor()) != (var8_16 = var12_14.getCofactor())) ** GOTO lbl52
            var12_14 = var13_12.getW();
            zzgcz.zza((ECPoint)var12_14, (EllipticCurve)var11_10.getParams().getCurve());
            var12_14 = new ECPublicKeySpec((ECPoint)var12_14, var11_10.getParams());
            var13_12 = ((KeyFactory)zzgdb.zzg.zzb("EC")).generatePublic((KeySpec)var12_14);
            var12_14 = (KeyAgreement)zzgdb.zze.zzb("ECDH");
            var12_14.init((Key)var11_10);
            try {
                block31: {
                    block33: {
                        block28: {
                            block29: {
                                block32: {
                                    block30: {
                                        var12_14.doPhase((Key)var13_12, true);
                                        var15_17 = var12_14.generateSecret();
                                        var13_12 = var11_10.getParams().getCurve();
                                        var11_10 = new BigInteger(1, var15_17);
                                        if (var11_10.signum() == -1 || var11_10.compareTo(zzgcz.zzb((EllipticCurve)var13_12)) >= 0) break block28;
                                        var17_18 = zzgcz.zzb((EllipticCurve)var13_12);
                                        var12_14 = var13_12.getA();
                                        var13_12 = var13_12.getB();
                                        var11_10 = var11_10.multiply((BigInteger)var11_10).add((BigInteger)var12_14).multiply((BigInteger)var11_10).add((BigInteger)var13_12).mod(var17_18);
                                        if (var17_18.signum() != 1) break block29;
                                        var18_19 = var11_10.mod(var17_18);
                                        if (!var18_19.equals(BigInteger.ZERO)) break block30;
                                        var11_10 = BigInteger.ZERO;
                                        break block31;
                                    }
                                    var10_20 = var17_18.testBit(0);
                                    var12_14 = null;
                                    if (!var10_20 || !var17_18.testBit(1)) break block32;
                                    var11_10 = var18_19.modPow(var17_18.add(BigInteger.ONE).shiftRight(2), var17_18);
                                    ** GOTO lbl89
                                }
                                var11_10 = var12_14;
                                if (!var17_18.testBit(0)) ** GOTO lbl89
                                var11_10 = var12_14;
                                if (var17_18.testBit(1)) ** GOTO lbl89
                                var11_10 = BigInteger.ONE;
                                var12_14 = var17_18.subtract(BigInteger.ONE).shiftRight(1);
                                var7_15 = 0;
                                break block33;
                            }
                            var1_1 = new InvalidAlgorithmParameterException("p must be positive");
                            throw var1_1;
                        }
                        var1_1 = new GeneralSecurityException("shared secret is out of range");
                        throw var1_1;
lbl52:
                        // 1 sources

                        try {
                            var1_1 = new GeneralSecurityException("invalid public key spec");
                            throw var1_1;
                        }
                        catch (NullPointerException var1_3) {
                        }
                        catch (IllegalArgumentException var1_4) {
                            // empty catch block
                        }
                        var1_5 = new GeneralSecurityException(var1_5.toString());
                        throw var1_5;
                    }
                    while (!(var19_21 = var11_10.multiply((BigInteger)var11_10).subtract(var18_19).mod(var17_18)).equals(BigInteger.ZERO)) {
                        var13_12 = var19_21.modPow((BigInteger)var12_14, var17_18);
                        if (var13_12.add(BigInteger.ONE).equals(var17_18)) {
                            var20_22 = var17_18.add(BigInteger.ONE).shiftRight(1);
                            var13_12 = BigInteger.ONE;
                            var12_14 = var11_10;
                            for (var7_15 = var20_22.bitLength() - 2; var7_15 >= 0; --var7_15) {
                                var21_23 = var12_14.multiply((BigInteger)var13_12);
                                var14_13 = var12_14.multiply((BigInteger)var12_14).add(var13_12.multiply((BigInteger)var13_12).mod(var17_18).multiply(var19_21)).mod(var17_18);
                                var13_12 = var21_23.add(var21_23).mod(var17_18);
                                if (var20_22.testBit(var7_15)) {
                                    var12_14 = var14_13.multiply((BigInteger)var11_10).add(var13_12.multiply(var19_21)).mod(var17_18);
                                    var13_12 = var11_10.multiply((BigInteger)var13_12).add((BigInteger)var14_13).mod(var17_18);
                                    continue;
                                }
                                var12_14 = var14_13;
                            }
                            var11_10 = var12_14;
                        } else {
                            var10_20 = var13_12.equals(BigInteger.ONE);
                            if (var10_20) {
                                var11_10 = var11_10.add(BigInteger.ONE);
                                if (++var7_15 != 128 || var17_18.isProbablePrime(80)) continue;
                                var1_1 = new InvalidAlgorithmParameterException("p is not prime");
                                throw var1_1;
                            }
                            var1_1 = new InvalidAlgorithmParameterException("p is not prime");
                            throw var1_1;
                        }
lbl89:
                        // 4 sources

                        if (var11_10 == null || var11_10.multiply((BigInteger)var11_10).mod(var17_18).compareTo(var18_19) == 0) break;
                        var1_1 = new GeneralSecurityException("Could not find a modular square root");
                        throw var1_1;
                    }
                }
                if (var11_10.testBit(0)) break block26;
                var17_18.subtract((BigInteger)var11_10).mod(var17_18);
            }
            catch (IllegalStateException var1_2) {
                throw new GeneralSecurityException(var1_2.toString());
            }
        }
        var11_10 = var16_11.getParams().getCurve();
        var14_13 = var16_11.getW();
        zzgcz.zza((ECPoint)var14_13, (EllipticCurve)var11_10);
        var7_15 = (zzgcz.zzb((EllipticCurve)var11_10).subtract(BigInteger.ONE).bitLength() + 7) / 8;
        if (--var5_9 != 0) {
            if (var5_9 != 2) {
                var5_9 = var7_15 + 1;
                var11_10 = new byte[var5_9];
                var12_14 = var14_13.getAffineX().toByteArray();
                var7_15 = ((Object)var12_14).length;
                System.arraycopy(var12_14, 0, var11_10, var5_9 - var7_15, var7_15);
                var6_24 = true != var14_13.getAffineY().testBit(0) ? 2 : 3;
                var11_10[0] = var6_24;
            } else {
                var5_9 = var7_15 + var7_15;
                var13_12 = new byte[var5_9];
                var12_14 = var14_13.getAffineX().toByteArray();
                var8_16 = ((Object)var12_14).length;
                var11_10 = var12_14;
                if (var8_16 > var7_15) {
                    var11_10 = Arrays.copyOfRange((byte[])var12_14, var8_16 - var7_15, var8_16);
                }
                var14_13 = var14_13.getAffineY().toByteArray();
                var8_16 = ((Object)var14_13).length;
                var12_14 = var14_13;
                if (var8_16 > var7_15) {
                    var12_14 = Arrays.copyOfRange((byte[])var14_13, var8_16 - var7_15, var8_16);
                }
                var8_16 = ((Object)var12_14).length;
                System.arraycopy(var12_14, 0, var13_12, var5_9 - var8_16, var8_16);
                var5_9 = ((Object)var11_10).length;
                System.arraycopy(var11_10, 0, var13_12, var7_15 - var5_9, var5_9);
                var11_10 = var13_12;
            }
        } else {
            var8_16 = var7_15 + var7_15 + 1;
            var11_10 = new byte[var8_16];
            var12_14 = var14_13.getAffineX().toByteArray();
            var13_12 = var14_13.getAffineY().toByteArray();
            var5_9 = ((Object)var13_12).length;
            System.arraycopy(var13_12, 0, var11_10, var8_16 - var5_9, var5_9);
            var5_9 = ((Object)var12_14).length;
            System.arraycopy(var12_14, 0, var11_10, var7_15 + 1 - var5_9, var5_9);
            var11_10[0] = 4;
        }
        var5_9 = 1;
        var13_12 = zzgco.zza((byte[][])new byte[][]{(byte[])var11_10, var15_17});
        var12_14 = (Mac)zzgdb.zzb.zzb((String)var1_1);
        if (var4_8 > var12_14.getMacLength() * 255) throw new GeneralSecurityException("size too large");
        if (var2_6 != null && var2_6.length != 0) {
            var12_14.init(new SecretKeySpec(var2_6, (String)var1_1));
        } else {
            var12_14.init(new SecretKeySpec(new byte[var12_14.getMacLength()], (String)var1_1));
        }
        var13_12 = var12_14.doFinal((byte[])var13_12);
        var2_6 = new byte[var4_8];
        var12_14.init(new SecretKeySpec((byte[])var13_12, (String)var1_1));
        var1_1 = new byte[0];
        var7_15 = 0;
        while (true) {
            var12_14.update((byte[])var1_1);
            var12_14.update(var3_7);
            var12_14.update((byte)var5_9);
            var1_1 = var12_14.doFinal();
            var9_25 = ((Object)var1_1).length;
            var8_16 = var7_15 + var9_25;
            if (var8_16 >= var4_8) {
                System.arraycopy(var1_1, 0, var2_6, var7_15, var4_8 - var7_15);
                return new zzgcx((byte[])var11_10, var2_6);
            }
            System.arraycopy(var1_1, 0, var2_6, var7_15, var9_25);
            ++var5_9;
            var7_15 = var8_16;
        }
    }
}
