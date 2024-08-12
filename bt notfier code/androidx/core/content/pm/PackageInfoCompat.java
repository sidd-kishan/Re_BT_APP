/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 *  android.os.Build$VERSION
 *  androidx.core.content.pm.PackageInfoCompat$Api28Impl
 */
package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.core.content.pm.PackageInfoCompat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public final class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(byte[][] byArray, byte[] byArray2) {
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (Arrays.equals(byArray2, byArray[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] byArray) {
        try {
            byArray = MessageDigest.getInstance("SHA256").digest(byArray);
            return byArray;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", noSuchAlgorithmException);
        }
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT < 28) return packageInfo.versionCode;
        return packageInfo.getLongVersionCode();
    }

    public static List<Signature> getSignatures(PackageManager signatureArray, String string) throws PackageManager.NameNotFoundException {
        signatureArray = Build.VERSION.SDK_INT >= 28 ? (Api28Impl.hasMultipleSigners((SigningInfo)(signatureArray = signatureArray.getPackageInfo((String)string, (int)0x8000000).signingInfo)) ? Api28Impl.getApkContentsSigners((SigningInfo)signatureArray) : Api28Impl.getSigningCertificateHistory((SigningInfo)signatureArray)) : signatureArray.getPackageInfo((String)string, (int)64).signatures;
        if (signatureArray != null) return Arrays.asList(signatureArray);
        return Collections.emptyList();
    }

    public static boolean hasSignatures(PackageManager object, String object2, Map<byte[], Integer> object3, boolean bl) throws PackageManager.NameNotFoundException {
        int n;
        Object object4;
        if (object3.isEmpty()) {
            return false;
        }
        Object object5 = object3.keySet();
        Iterator<byte[]> iterator = object5.iterator();
        while (iterator.hasNext()) {
            object4 = iterator.next();
            if (object4 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Cert byte array cannot be null when verifying ");
                ((StringBuilder)object).append((String)object2);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            if ((object4 = object3.get(object4)) == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Type must be specified for cert when verifying ");
                ((StringBuilder)object).append((String)object2);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            n = object4.intValue();
            if (n == 0 || n == 1) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("Unsupported certificate type ");
            ((StringBuilder)object).append(object4);
            ((StringBuilder)object).append(" when verifying ");
            ((StringBuilder)object).append((String)object2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object4 = PackageInfoCompat.getSignatures((PackageManager)object, (String)object2);
        if (!bl && Build.VERSION.SDK_INT >= 28) {
            object4 = object5.iterator();
            do {
                if (!object4.hasNext()) return true;
            } while (Api28Impl.hasSigningCertificate((PackageManager)object, (String)object2, (byte[])(object5 = (Object)((byte[])object4.next())), (int)object3.get(object5)));
            return false;
        }
        if (object4.size() == 0) return false;
        if (object3.size() > object4.size()) return false;
        if (bl && object3.size() != object4.size()) {
            return false;
        }
        bl = object3.containsValue(1);
        object = null;
        if (bl) {
            object2 = new byte[object4.size()][];
            n = 0;
            while (true) {
                object = object2;
                if (n >= object4.size()) break;
                object2[n] = PackageInfoCompat.computeSHA256Digest(((Signature)object4.get(n)).toByteArray());
                ++n;
            }
        }
        if (!(object2 = object5.iterator()).hasNext()) return false;
        n = (Integer)(object3 = object3.get(object2 = (Object)((byte[])object2.next())));
        if (n == 0) {
            if (object4.contains(new Signature((byte[])object2))) return true;
            return false;
        }
        if (n == 1) {
            if (PackageInfoCompat.byteArrayContains((byte[][])object, (byte[])object2)) return true;
            return false;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unsupported certificate type ");
        ((StringBuilder)object).append(object3);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }
}
