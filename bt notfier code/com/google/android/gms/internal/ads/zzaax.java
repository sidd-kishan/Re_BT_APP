/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaaw
 *  com.google.android.gms.internal.ads.zzzo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzzo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzaax {
    private static Cipher zza;
    private static final Object zzb;
    private static final Object zzc;

    static {
        zzb = new Object();
        zzc = new Object();
    }

    public zzaax(SecureRandom secureRandom) {
    }

    private static final Cipher zzc() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Object object = zzc;
        synchronized (object) {
            if (zza == null) {
                zza = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            Cipher cipher = zza;
            return cipher;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public final String zza(byte[] object, byte[] byArray) throws zzaaw {
        Object object2;
        int n = ((byte[])object).length;
        try {
            object2 = new SecretKeySpec((byte[])object, "AES");
            object = zzb;
            synchronized (object) {
            }
        }
        catch (BadPaddingException badPaddingException) {
            throw new zzaaw(this, (Throwable)badPaddingException);
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            throw new zzaaw(this, (Throwable)noSuchPaddingException);
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new zzaaw(this, (Throwable)illegalBlockSizeException);
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new zzaaw(this, (Throwable)invalidKeyException);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new zzaaw(this, (Throwable)noSuchAlgorithmException);
        }
        {
            zzaax.zzc().init(1, (Key)object2, (SecureRandom)null);
            object2 = zzaax.zzc().doFinal(byArray);
            byArray = zzaax.zzc().getIV();
        }
        {
            n = ((Object)object2).length + byArray.length;
            object = ByteBuffer.allocate(n);
            ((ByteBuffer)object).put(byArray).put((byte[])object2);
            ((Buffer)object).flip();
            byArray = new byte[n];
            ((ByteBuffer)object).get(byArray);
            return zzzo.zza((byte[])byArray, (boolean)false);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final byte[] zzb(byte[] object, String object2) throws zzaaw {
        block11: {
            byte[] byArray;
            Object object3;
            int n = ((byte[])object).length;
            try {
                object2 = zzzo.zzb((String)object2, (boolean)false);
                n = ((Object)object2).length;
                if (n <= 16) break block11;
                object3 = ByteBuffer.allocate(n);
                ((ByteBuffer)object3).put((byte[])object2);
                ((Buffer)object3).flip();
                object2 = new byte[16];
                byArray = new byte[n - 16];
                ((ByteBuffer)object3).get((byte[])object2);
                ((ByteBuffer)object3).get(byArray);
                object3 = new SecretKeySpec((byte[])object, "AES");
                object = zzb;
                synchronized (object) {
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new zzaaw(this, (Throwable)illegalArgumentException);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                throw new zzaaw(this, (Throwable)invalidAlgorithmParameterException);
            }
            catch (BadPaddingException badPaddingException) {
                throw new zzaaw(this, (Throwable)badPaddingException);
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                throw new zzaaw(this, (Throwable)noSuchPaddingException);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                throw new zzaaw(this, (Throwable)illegalBlockSizeException);
            }
            catch (InvalidKeyException invalidKeyException) {
                throw new zzaaw(this, (Throwable)invalidKeyException);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                throw new zzaaw(this, (Throwable)noSuchAlgorithmException);
            }
            {
                Cipher cipher = zzaax.zzc();
                IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object2);
                cipher.init(2, (Key)object3, ivParameterSpec);
                return zzaax.zzc().doFinal(byArray);
            }
        }
        object = new zzaaw;
        object(this);
        throw object;
    }
}
