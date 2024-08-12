/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzvb
 *  com.google.android.gms.internal.ads.zzvc
 *  com.google.android.gms.internal.ads.zzvd
 *  com.google.android.gms.internal.ads.zzve
 *  com.google.android.gms.internal.ads.zzvf
 *  com.google.android.gms.internal.ads.zzvg
 *  com.google.android.gms.internal.ads.zzvj
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzvb;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzvd;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzvf;
import com.google.android.gms.internal.ads.zzvg;
import com.google.android.gms.internal.ads.zzvj;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzvi {
    /*
     * Exception decompiling
     */
    public static X509Certificate[][] zza(String var0) throws zzvf, SecurityException, IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 12[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - void declaration
     */
    private static X509Certificate[][] zzb(FileChannel fileChannel, zzve object) throws SecurityException {
        void var0_4;
        int n;
        ByteBuffer byteBuffer;
        CertificateFactory certificateFactory;
        HashMap<Integer, byte[]> hashMap = new HashMap<Integer, byte[]>();
        ArrayList<X509Certificate[]> arrayList = new ArrayList<X509Certificate[]>();
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
        }
        catch (CertificateException certificateException) {
            RuntimeException runtimeException = new RuntimeException("Failed to obtain X.509 CertificateFactory", certificateException);
            throw runtimeException;
        }
        try {
            byteBuffer = zzvi.zzj(zzve.zza((zzve)object));
            n = 0;
        }
        catch (IOException iOException) {
            throw new SecurityException("Failed to read list of signers", iOException);
        }
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                if (n <= 0) throw new SecurityException("No signers found");
                if (hashMap.isEmpty()) throw new SecurityException("No content digests found");
                zzvi.zzd(hashMap, fileChannel, zzve.zzb((zzve)object), zzve.zzc((zzve)object), zzve.zzd((zzve)object), zzve.zze((zzve)object));
                return (X509Certificate[][])arrayList.toArray((T[])new X509Certificate[arrayList.size()][]);
            }
            ++n;
            try {
                arrayList.add(zzvi.zzc(zzvi.zzj(byteBuffer), hashMap, certificateFactory));
            }
            catch (SecurityException securityException) {
                break;
            }
            catch (BufferUnderflowException bufferUnderflowException) {
                break;
            }
            catch (IOException iOException) {
                // empty catch block
                break;
            }
        }
        object = new StringBuilder(48);
        ((StringBuilder)object).append("Failed to parse/verify signer #");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" block");
        throw new SecurityException(((StringBuilder)object).toString(), (Throwable)var0_4);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private static X509Certificate[] zzc(ByteBuffer var0, Map<Integer, byte[]> var1_14, CertificateFactory var2_15) throws SecurityException, IOException {
        block49: {
            var14_16 = zzvi.zzj((ByteBuffer)var0);
            var10_17 = zzvi.zzj((ByteBuffer)var0);
            var13_18 = zzvi.zzk((ByteBuffer)var0);
            var15_19 = new ArrayList<Integer>();
            var12_20 = null;
            var11_21 = null;
            var3_22 = -1;
            var4_23 = 0;
            block27: while (var10_17.hasRemaining()) {
                block48: {
                    block47: {
                        var5_24 = var4_23 + 1;
                        try {
                            var0 = zzvi.zzj((ByteBuffer)var10_17);
                            if (var0.remaining() >= 8) {
                                var6_25 = var0.getInt();
                                var15_19.add(var6_25);
                                if (var6_25 == 513 || var6_25 == 514 || var6_25 == 769) break block47;
                            }
                            ** GOTO lbl43
                        }
                        catch (BufferUnderflowException var0_1) {
                            break block48;
                        }
                        catch (IOException var0_2) {
                            // empty catch block
                            break block48;
                        }
                        switch (var6_25) {
                            default: {
                                var4_23 = var5_24;
                                continue block27;
                            }
                            case 257: 
                            case 258: 
                            case 259: 
                            case 260: 
                        }
                    }
                    if (var3_22 == -1) ** GOTO lbl39
                    {
                        var8_27 = zzvi.zzf(var6_25);
                        var7_26 = zzvi.zzf(var3_22);
                        var4_23 = var5_24;
                        if (var8_27 == 1) continue;
                        if (var7_26 != 1) {
                            var4_23 = var5_24;
                            continue;
                        }
lbl39:
                        // 3 sources

                        var11_21 = zzvi.zzk((ByteBuffer)var0);
                        var3_22 = var6_25;
                        var4_23 = var5_24;
                        continue;
lbl43:
                        // 1 sources

                        var0 = new SecurityException("Signature record too short");
                        throw var0;
                    }
                }
                var1_14 = new StringBuilder(45);
                var1_14.append("Failed to parse signature record #");
                var1_14.append(var5_24);
                throw new SecurityException(var1_14.toString(), (Throwable)var0_3);
            }
            if (var3_22 == -1) {
                if (var4_23 != 0) throw new SecurityException("No supported signatures found");
                throw new SecurityException("No signatures found");
            }
            if (var3_22 != 513 && var3_22 != 514) {
                if (var3_22 != 769) {
                    switch (var3_22) {
                        default: {
                            var0 = String.valueOf(Long.toHexString(var3_22));
                            var0 = var0.length() != 0 ? "Unknown signature algorithm: 0x".concat((String)var0) : new String("Unknown signature algorithm: 0x");
                            throw new IllegalArgumentException((String)var0);
                        }
                        case 257: 
                        case 258: 
                        case 259: 
                        case 260: 
                    }
                    var10_17 = "RSA";
                } else {
                    var10_17 = "DSA";
                }
            } else {
                var10_17 = "EC";
            }
            if (var3_22 != 513) {
                if (var3_22 != 514) {
                    if (var3_22 != 769) {
                        switch (var3_22) {
                            default: {
                                var0 = String.valueOf(Long.toHexString(var3_22));
                                var0 = var0.length() != 0 ? "Unknown signature algorithm: 0x".concat((String)var0) : new String("Unknown signature algorithm: 0x");
                                throw new IllegalArgumentException((String)var0);
                            }
                            case 260: {
                                var0 = Pair.create((Object)"SHA512withRSA", null);
                                break;
                            }
                            case 259: {
                                var0 = Pair.create((Object)"SHA256withRSA", null);
                                break;
                            }
                            case 258: {
                                var0 = Pair.create((Object)"SHA512withRSA/PSS", (Object)new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                break;
                            }
                            case 257: {
                                var0 = Pair.create((Object)"SHA256withRSA/PSS", (Object)new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                break;
                            }
                        }
                    } else {
                        var0 = Pair.create((Object)"SHA256withDSA", null);
                    }
                } else {
                    var0 = Pair.create((Object)"SHA512withECDSA", null);
                }
            } else {
                var0 = Pair.create((Object)"SHA256withECDSA", null);
            }
            var16_28 = (String)var0.first;
            var0 = (AlgorithmParameterSpec)var0.second;
            try {
                var17_29 = KeyFactory.getInstance((String)var10_17);
                var10_17 = new ArrayList<zzvg>(var13_18);
                var17_29 = var17_29.generatePublic((KeySpec)var10_17);
                var10_17 = Signature.getInstance(var16_28);
                var10_17.initVerify((PublicKey)var17_29);
                if (var0 != null) {
                    var10_17.setParameter((AlgorithmParameterSpec)var0);
                }
                var10_17.update(var14_16);
                var9_30 = var10_17.verify((byte[])var11_21);
                if (var9_30 == false) throw new SecurityException(String.valueOf(var16_28).concat(" signature did not verify"));
            }
            catch (SignatureException var0_8) {
                break block49;
            }
            catch (InvalidAlgorithmParameterException var0_9) {
                break block49;
            }
            catch (InvalidKeyException var0_10) {
                break block49;
            }
            catch (InvalidKeySpecException var0_11) {
                break block49;
            }
            catch (NoSuchAlgorithmException var0_12) {
                // empty catch block
                break block49;
            }
            var14_16.clear();
            var10_17 = zzvi.zzj(var14_16);
            var11_21 = new ArrayList<E>();
            var4_23 = 0;
            var0 = var12_20;
            while (var10_17.hasRemaining()) {
                var5_24 = var4_23 + 1;
                try {
                    var12_20 = zzvi.zzj((ByteBuffer)var10_17);
                    if (var12_20.remaining() < 8) {
                        var0 = new IOException("Record too short");
                        throw var0;
                    }
                    var6_25 = var12_20.getInt();
                    var11_21.add(var6_25);
                    var4_23 = var5_24;
                    if (var6_25 != var3_22) continue;
                    var0 = zzvi.zzk(var12_20);
                    var4_23 = var5_24;
                    continue;
                }
                catch (BufferUnderflowException var0_4) {
                }
                catch (IOException var0_5) {
                    // empty catch block
                }
                var1_14 = new StringBuilder(42);
                var1_14.append("Failed to parse digest record #");
                var1_14.append(var5_24);
                throw new IOException(var1_14.toString(), (Throwable)var0_6);
            }
            if (var15_19.equals(var11_21) == false) throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            if ((var1_14 = (Object)((byte[])var1_14.put(var3_22 = zzvi.zzf(var3_22), var0))) != null) {
                if (MessageDigest.isEqual((byte[])var1_14, (byte[])var0) == false) throw new SecurityException(zzvi.zzg(var3_22).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            var0 = zzvi.zzj(var14_16);
            var10_17 = new ArrayList<zzvg>();
            var3_22 = 0;
            while (true) {
                if (!var0.hasRemaining()) {
                    if (var10_17.isEmpty() != false) throw new SecurityException("No certificates listed");
                    if (Arrays.equals(var13_18, ((X509Certificate)var10_17.get(0)).getPublicKey().getEncoded()) == false) throw new SecurityException("Public key mismatch between certificate and signature record");
                    return var10_17.toArray(new X509Certificate[var10_17.size()]);
                }
                ++var3_22;
                var1_14 = zzvi.zzk((ByteBuffer)var0);
                try {
                    var11_21 = new ByteArrayInputStream((byte[])var1_14);
                    var11_21 = (X509Certificate)var2_15.generateCertificate((InputStream)var11_21);
                    var10_17.add(new zzvg((X509Certificate)var11_21, (byte[])var1_14));
                }
                catch (CertificateException var0_7) {
                    var1_14 = new StringBuilder(41);
                    var1_14.append("Failed to decode certificate #");
                    var1_14.append(var3_22);
                    throw new SecurityException(var1_14.toString(), var0_7);
                }
            }
        }
        var1_14 = new StringBuilder(String.valueOf(var16_28).length() + 27);
        var1_14.append("Failed to verify ");
        var1_14.append(var16_28);
        var1_14.append(" signature");
        var0_13 = new SecurityException(var1_14.toString(), var0_13);
        throw var0_13;
    }

    private static void zzd(Map<Integer, byte[]> object, FileChannel object2, long l, long l2, long l3, ByteBuffer object3) throws SecurityException {
        if (object.isEmpty()) {
            object = new SecurityException("No digests provided");
            throw object;
        }
        zzvd zzvd2 = new zzvd((FileChannel)object2, 0L, l);
        object2 = new zzvd((FileChannel)object2, l2, l3 - l2);
        object3 = ((ByteBuffer)object3).duplicate();
        ((ByteBuffer)object3).order(ByteOrder.LITTLE_ENDIAN);
        zzvj.zzc((ByteBuffer)object3, (long)l);
        zzvb zzvb2 = new zzvb((ByteBuffer)object3);
        int n = object.size();
        object3 = new int[n];
        Iterator iterator = object.keySet().iterator();
        Object object4 = 0;
        int n2 = 0;
        while (iterator.hasNext()) {
            object3[n2] = (Integer)iterator.next();
            ++n2;
        }
        try {
            object2 = zzvi.zze((int[])object3, new zzvc[]{zzvd2, object2, zzvb2});
            n2 = object4;
        }
        catch (DigestException digestException) {
            throw new SecurityException("Failed to compute digest(s) of contents", digestException);
        }
        while (n2 < n) {
            object4 = object3[n2];
            if (!MessageDigest.isEqual((byte[])object.get(object4), (byte[])object2[n2])) throw new SecurityException(zzvi.zzg(object4).concat(" digest of contents did not verify"));
            ++n2;
        }
    }

    private static byte[][] zze(int[] object, zzvc[] object2) throws DigestException {
        Object object3;
        Object object4;
        int n;
        int n2;
        Object object5 = 0;
        long l = 0L;
        for (n2 = 0; n2 < 3; l += (object2[n2].zza() + 1048575L) / 0x100000L, ++n2) {
        }
        if (l >= 0x1FFFFFL) {
            object = new StringBuilder(37);
            ((StringBuilder)object).append("Too many chunks: ");
            ((StringBuilder)object).append(l);
            object = new DigestException(((StringBuilder)object).toString());
            throw object;
        }
        int n3 = (int)l;
        byte[][] byArrayArray = new byte[((int[])object).length][];
        for (n2 = 0; n2 < (n = ((Object)object).length); ++n2) {
            object4 = new byte[zzvi.zzh((int)object[n2]) * n3 + 5];
            object4[0] = 90;
            zzvi.zzl(n3, object4, 1);
            byArrayArray[n2] = object4;
        }
        object4 = new byte[5];
        object4[0] = -91;
        Object object6 = new MessageDigest[n];
        for (n2 = 0; n2 < ((Object)object).length; ++n2) {
            object3 = zzvi.zzg((int)object[n2]);
            try {
                object6[n2] = MessageDigest.getInstance((String)object3);
                continue;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                throw new RuntimeException(((String)object3).concat(" digest not supported"), noSuchAlgorithmException);
            }
        }
        n3 = 0;
        for (n2 = 0; n2 < 3; ++object5, ++n2) {
            long l2;
            object3 = object2[n2];
            l = 0L;
            for (long i = object3.zza(); i > 0L; i -= l2, ++n3, l += l2) {
                int n4;
                int n5 = (int)Math.min(i, 0x100000L);
                zzvi.zzl(n5, object4, 1);
                for (n4 = 0; n4 < n; ++n4) {
                    object6[n4].update((byte[])object4);
                }
                try {
                    object3.zzb((MessageDigest[])object6, l, n5);
                }
                catch (IOException iOException) {
                    object2 = new StringBuilder(59);
                    ((StringBuilder)object2).append("Failed to digest chunk #");
                    ((StringBuilder)object2).append(n3);
                    ((StringBuilder)object2).append(" of section #");
                    ((StringBuilder)object2).append((int)object5);
                    throw new DigestException(((StringBuilder)object2).toString(), iOException);
                }
                for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                    Object object7 = object[n4];
                    Object object8 = object6[n4];
                    byte[] byArray = byArrayArray[n4];
                    int n6 = zzvi.zzh((int)object7);
                    if ((object7 = (Object)((MessageDigest)object8).digest(byArray, n3 * n6 + 5, n6)) == n6) continue;
                    object2 = ((MessageDigest)object8).getAlgorithm();
                    object = new StringBuilder(String.valueOf(object2).length() + 46);
                    ((StringBuilder)object).append("Unexpected output size of ");
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(" digest: ");
                    ((StringBuilder)object).append((int)object7);
                    throw new RuntimeException(((StringBuilder)object).toString());
                }
                l2 = n5;
            }
        }
        object4 = new byte[((Object)object).length][];
        n2 = 0;
        while (n2 < ((Object)object).length) {
            object5 = object[n2];
            object3 = byArrayArray[n2];
            object2 = zzvi.zzg(object5);
            try {
                object6 = MessageDigest.getInstance((String)object2);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                throw new RuntimeException(((String)object2).concat(" digest not supported"), noSuchAlgorithmException);
            }
            object4[n2] = (byte)((MessageDigest)object6).digest((byte[])object3);
            ++n2;
        }
        return object4;
    }

    private static int zzf(int n) {
        if (n == 513) return 1;
        if (n == 514) return 2;
        if (n == 769) return 1;
        switch (n) {
            default: {
                String string = String.valueOf(Long.toHexString(n));
                string = string.length() != 0 ? "Unknown signature algorithm: 0x".concat(string) : new String("Unknown signature algorithm: 0x");
                throw new IllegalArgumentException(string);
            }
            case 258: 
            case 260: {
                return 2;
            }
            case 257: 
            case 259: 
        }
        return 1;
    }

    private static String zzg(int n) {
        if (n == 1) return "SHA-256";
        if (n == 2) {
            return "SHA-512";
        }
        StringBuilder stringBuilder = new StringBuilder(44);
        stringBuilder.append("Unknown content digest algorthm: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static int zzh(int n) {
        if (n == 1) return 32;
        if (n == 2) {
            return 64;
        }
        StringBuilder stringBuilder = new StringBuilder(44);
        stringBuilder.append("Unknown content digest algorthm: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static ByteBuffer zzi(ByteBuffer object, int n) throws BufferUnderflowException {
        if (n < 0) {
            object = new StringBuilder(17);
            ((StringBuilder)object).append("size: ");
            ((StringBuilder)object).append(n);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        int n2 = ((Buffer)object).limit();
        int n3 = ((Buffer)object).position();
        if ((n += n3) < n3) throw new BufferUnderflowException();
        if (n > n2) throw new BufferUnderflowException();
        ((Buffer)object).limit(n);
        try {
            ByteBuffer byteBuffer = ((ByteBuffer)object).slice();
            byteBuffer.order(((ByteBuffer)object).order());
            ((Buffer)object).position(n);
            return byteBuffer;
        }
        finally {
            ((Buffer)object).limit(n2);
        }
    }

    private static ByteBuffer zzj(ByteBuffer object) throws IOException {
        if (((Buffer)object).remaining() < 4) {
            int n = ((Buffer)object).remaining();
            object = new StringBuilder(93);
            ((StringBuilder)object).append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            ((StringBuilder)object).append(n);
            throw new IOException(((StringBuilder)object).toString());
        }
        int n = ((ByteBuffer)object).getInt();
        if (n < 0) throw new IllegalArgumentException("Negative length");
        if (n <= ((Buffer)object).remaining()) {
            return zzvi.zzi((ByteBuffer)object, n);
        }
        int n2 = ((Buffer)object).remaining();
        object = new StringBuilder(101);
        ((StringBuilder)object).append("Length-prefixed field longer than remaining buffer. Field length: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", remaining: ");
        ((StringBuilder)object).append(n2);
        throw new IOException(((StringBuilder)object).toString());
    }

    private static byte[] zzk(ByteBuffer object) throws IOException {
        int n = ((ByteBuffer)object).getInt();
        if (n < 0) throw new IOException("Negative length");
        if (n <= ((Buffer)object).remaining()) {
            byte[] byArray = new byte[n];
            ((ByteBuffer)object).get(byArray);
            return byArray;
        }
        int n2 = ((Buffer)object).remaining();
        object = new StringBuilder(90);
        ((StringBuilder)object).append("Underflow while reading length-prefixed value. Length: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", available: ");
        ((StringBuilder)object).append(n2);
        throw new IOException(((StringBuilder)object).toString());
    }

    private static void zzl(int n, byte[] byArray, int n2) {
        byArray[1] = (byte)(n & 0xFF);
        byArray[2] = (byte)(n >>> 8 & 0xFF);
        byArray[3] = (byte)(n >>> 16 & 0xFF);
        byArray[4] = (byte)(n >> 24);
    }
}
