/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;

public final class zzgcz {
    static void zza(ECPoint object, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigInteger = zzgcz.zzb(ellipticCurve);
        BigInteger bigInteger2 = ((ECPoint)object).getAffineX();
        object = ((ECPoint)object).getAffineY();
        if (bigInteger2 == null) throw new GeneralSecurityException("point is at infinity");
        if (object == null) throw new GeneralSecurityException("point is at infinity");
        if (bigInteger2.signum() == -1) throw new GeneralSecurityException("x is out of range");
        if (bigInteger2.compareTo(bigInteger) >= 0) throw new GeneralSecurityException("x is out of range");
        if (((BigInteger)object).signum() == -1) throw new GeneralSecurityException("y is out of range");
        if (((BigInteger)object).compareTo(bigInteger) >= 0) throw new GeneralSecurityException("y is out of range");
        if (!((BigInteger)object).multiply((BigInteger)object).mod(bigInteger).equals(bigInteger2.multiply(bigInteger2).add(ellipticCurve.getA()).multiply(bigInteger2).add(ellipticCurve.getB()).mod(bigInteger))) throw new GeneralSecurityException("Point is not on curve");
    }

    public static BigInteger zzb(EllipticCurve object) throws GeneralSecurityException {
        if (!((object = ((EllipticCurve)object).getField()) instanceof ECFieldFp)) throw new GeneralSecurityException("Only curves over prime order fields are supported");
        return ((ECFieldFp)object).getP();
    }

    public static KeyPair zzc(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator)zzgdb.zzf.zzb("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static ECParameterSpec zzd(int n) throws NoSuchAlgorithmException {
        if (--n == 0) return zzgcz.zzf("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
        if (n == 1) return zzgcz.zzf("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
        return zzgcz.zzf("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }

    public static ECPublicKey zze(int n, byte[] object, byte[] byArray) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec = zzgcz.zzd(n);
        object = new ECPoint(new BigInteger(1, (byte[])object), new BigInteger(1, byArray));
        zzgcz.zza((ECPoint)object, eCParameterSpec.getCurve());
        object = new ECPublicKeySpec((ECPoint)object, eCParameterSpec);
        return (ECPublicKey)((KeyFactory)zzgdb.zzg.zzb("EC")).generatePublic((KeySpec)object);
    }

    private static ECParameterSpec zzf(String object, String object2, String object3, String object4, String object5) {
        object = new BigInteger((String)object);
        object2 = new BigInteger((String)object2);
        BigInteger bigInteger = ((BigInteger)object).subtract(new BigInteger("3"));
        object3 = new BigInteger((String)object3, 16);
        object4 = new BigInteger((String)object4, 16);
        object5 = new BigInteger((String)object5, 16);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp((BigInteger)object), bigInteger, (BigInteger)object3), new ECPoint((BigInteger)object4, (BigInteger)object5), (BigInteger)object2, 1);
    }
}
