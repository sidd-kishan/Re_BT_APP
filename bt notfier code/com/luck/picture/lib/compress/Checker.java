/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.luck.picture.lib.compress;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

final class Checker
extends Enum<Checker> {
    private static final Checker[] $VALUES;
    private static final String JPG = ".jpg";
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_JPG = "image/jpg";
    public static final /* enum */ Checker SINGLE;
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE = new byte[]{-1, -40, -1};

    static {
        Checker checker;
        SINGLE = checker = new Checker();
        $VALUES = new Checker[]{checker};
    }

    private int getOrientation(byte[] byArray) {
        int n;
        int n2;
        int n3;
        int n4;
        block12: {
            block10: {
                block11: {
                    int n5;
                    if (byArray == null) {
                        return 0;
                    }
                    n4 = 0;
                    while (true) {
                        n3 = n4;
                        if (n4 + 3 >= byArray.length) break block10;
                        n3 = n2 = n4 + 1;
                        if ((byArray[n4] & 0xFF) != 255) break block10;
                        n = byArray[n2] & 0xFF;
                        if (n == 255) {
                            n4 = n2;
                            continue;
                        }
                        n4 = ++n2;
                        if (n == 216) continue;
                        if (n == 1) {
                            n4 = n2;
                            continue;
                        }
                        n3 = n2;
                        if (n == 217) break block10;
                        if (n == 218) {
                            n3 = n2;
                            break block10;
                        }
                        n5 = this.pack(byArray, n2, 2, false);
                        if (n5 < 2 || (n4 = n2 + n5) > byArray.length) break block11;
                        if (n == 225 && n5 >= 8 && this.pack(byArray, n2 + 2, 4, false) == 1165519206 && this.pack(byArray, n2 + 6, 2, false) == 0) break;
                    }
                    n3 = n2 + 8;
                    n4 = n5 - 8;
                    break block12;
                }
                Log.e((String)TAG, (String)"Invalid length");
                return 0;
            }
            n4 = 0;
        }
        if (n4 > 8) {
            n2 = this.pack(byArray, n3, 4, false);
            if (n2 != 1229531648 && n2 != 1296891946) {
                Log.e((String)TAG, (String)"Invalid byte order");
                return 0;
            }
            boolean bl = n2 == 1229531648;
            n = this.pack(byArray, n3 + 4, 4, bl) + 2;
            if (n >= 10 && n <= n4) {
                n2 = n3 + n;
                n3 = n4 - n;
            } else {
                Log.e((String)TAG, (String)"Invalid offset");
                return 0;
            }
            for (n4 = this.pack(byArray, n2 - 2, 2, bl); n4 > 0 && n3 >= 12; n2 += 12, n3 -= 12, --n4) {
                if (this.pack(byArray, n2, 2, bl) != 274) continue;
                n4 = this.pack(byArray, n2 + 8, 2, bl);
                if (n4 == 1) return 0;
                if (n4 == 3) return 180;
                if (n4 == 6) return 90;
                if (n4 == 8) return 270;
                Log.e((String)TAG, (String)"Unsupported orientation");
                return 0;
            }
        }
        Log.e((String)TAG, (String)"Orientation not found");
        return 0;
    }

    private boolean isJPG(byte[] byArray) {
        if (byArray == null) return false;
        if (byArray.length < 3) {
            return false;
        }
        byte by = byArray[0];
        byte by2 = byArray[1];
        byte by3 = byArray[2];
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{by, by2, by3});
    }

    private int pack(byte[] byArray, int n, int n2, boolean bl) {
        int n3;
        if (bl) {
            n += n2 - 1;
            n3 = -1;
        } else {
            n3 = 1;
        }
        int n4 = 0;
        while (n2 > 0) {
            n4 = byArray[n] & 0xFF | n4 << 8;
            n += n3;
            --n2;
        }
        return n4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private byte[] toByteArray(InputStream var1_1) {
        if (var1_1 == null) {
            return new byte[0];
        }
        var3_6 = new ByteArrayOutputStream();
        var4_8 = new byte[4096];
        while ((var2_9 = var1_1.read(var4_8, 0, 4096)) != -1) {
            var3_6.write(var4_8, 0, var2_9);
        }
        try {}
        catch (IOException var1_4) {}
        ** GOTO lbl23
lbl12:
        // 2 sources

        return var3_6.toByteArray();
        catch (Throwable var1_2) {
        }
        catch (Exception var1_3) {
            try {
                var3_6.close();
            }
            catch (IOException var1_5) {
                ** continue;
            }
lbl21:
            // 2 sources

            return new byte[0];
lbl23:
            // 1 sources

            var3_6.close();
            ** continue;
        }
        {
            var3_6.close();
        }
        throw var1_2;
    }

    public static Checker valueOf(String string) {
        return Enum.valueOf(Checker.class, string);
    }

    public static Checker[] values() {
        return (Checker[])$VALUES.clone();
    }

    String extSuffix(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return JPG;
        }
        try {
            boolean bl = string.startsWith("video");
            String string2 = bl ? "video/" : "image/";
            string = string.replace(string2, ".");
            return string;
        }
        catch (Exception exception) {
            return JPG;
        }
    }

    int getOrientation(InputStream inputStream) {
        return this.getOrientation(this.toByteArray(inputStream));
    }

    boolean isJPG(InputStream inputStream) {
        return this.isJPG(this.toByteArray(inputStream));
    }

    boolean isJPG(String string) {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (!string.startsWith(MIME_TYPE_HEIC) && !string.startsWith(MIME_TYPE_JPEG)) {
            if (!string.startsWith(MIME_TYPE_JPG)) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    boolean needCompress(int n, String object) {
        boolean bl;
        boolean bl2 = bl = true;
        if (n <= 0) return bl2;
        bl2 = ((File)(object = new File((String)object))).exists() && ((File)object).length() > (long)(n << 10) ? bl : false;
        return bl2;
    }

    boolean needCompressToLocalMedia(int n, String object) {
        boolean bl;
        boolean bl2 = bl = true;
        if (n <= 0) return bl2;
        bl2 = bl;
        if (TextUtils.isEmpty((CharSequence)object)) return bl2;
        bl2 = ((File)(object = new File((String)object))).exists() && ((File)object).length() > (long)(n << 10) ? bl : false;
        return bl2;
    }
}
