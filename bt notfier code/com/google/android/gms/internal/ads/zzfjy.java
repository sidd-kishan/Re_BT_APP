/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.common.util.IOUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class zzfjy {
    public static File zza(String string, String string2, File file) {
        if (TextUtils.isEmpty((CharSequence)string)) return null;
        if (!TextUtils.isEmpty((CharSequence)string2)) return new File(zzfjy.zzc(string, file), string2);
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean zzb(File file, byte[] object) {
        FileOutputStream fileOutputStream;
        block7: {
            void var0_4;
            block6: {
                Object var4_7 = null;
                Object var3_8 = null;
                try {
                    fileOutputStream = new FileOutputStream(file);
                }
                catch (Throwable throwable) {
                    object = var3_8;
                    break block6;
                }
                catch (IOException iOException) {
                    fileOutputStream = var4_7;
                    break block7;
                }
                try {
                    fileOutputStream.write((byte[])object);
                    fileOutputStream.flush();
                }
                catch (Throwable throwable) {
                    object = fileOutputStream;
                    break block6;
                }
                catch (IOException iOException) {
                    break block7;
                }
                IOUtils.closeQuietly((Closeable)fileOutputStream);
                return true;
            }
            IOUtils.closeQuietly((Closeable)object);
            throw var0_4;
        }
        IOUtils.closeQuietly((Closeable)fileOutputStream);
        return false;
    }

    public static File zzc(String object, File file) {
        if (TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        object = new File(file, (String)object);
        zzfjy.zzd((File)object, false);
        return object;
    }

    public static File zzd(File file, boolean bl) {
        if (bl && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (file.exists()) return file;
        file.mkdirs();
        return file;
    }

    public static boolean zze(File file) {
        boolean bl;
        if (!file.exists()) {
            return true;
        }
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            bl = true;
        } else {
            int n = fileArray.length;
            int n2 = 0;
            boolean bl2 = true;
            while (true) {
                bl = bl2;
                if (n2 >= n) break;
                File file2 = fileArray[n2];
                bl2 = file2 != null && zzfjy.zze(file2) && bl2;
                ++n2;
            }
        }
        if (!file.delete()) return false;
        if (!bl) return false;
        return true;
    }
}
