/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.text.TextUtils
 */
package com.google.android.gms.common.util;

import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class DataUtils {
    public static void copyStringToBuffer(String string, CharArrayBuffer charArrayBuffer) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            charArrayBuffer.sizeCopied = 0;
            return;
        }
        if (charArrayBuffer.data != null && charArrayBuffer.data.length >= string.length()) {
            string.getChars(0, string.length(), charArrayBuffer.data, 0);
        } else {
            charArrayBuffer.data = string.toCharArray();
        }
        charArrayBuffer.sizeCopied = string.length();
    }

    public static byte[] loadImageBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
