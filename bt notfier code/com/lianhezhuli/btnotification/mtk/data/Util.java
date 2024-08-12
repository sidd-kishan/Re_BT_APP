/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.PowerManager
 *  android.os.StatFs
 *  android.provider.ContactsContract$PhoneLookup
 *  com.lianhezhuli.btnotification.mtk.data.AppList
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.data;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.ContactsContract;
import com.lianhezhuli.btnotification.mtk.data.AppList;
import com.orhanobut.logger.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

public final class Util {
    private static final String LOG_TAG = "Util";
    private static int sMessageId = 256;

    private static Bitmap createIcon(Context context, ApplicationInfo applicationInfo, boolean bl) {
        if (context != null && applicationInfo != null) {
            applicationInfo = context.getPackageManager().getApplicationIcon(applicationInfo);
            context = bl ? Bitmap.createBitmap((int)applicationInfo.getIntrinsicWidth(), (int)applicationInfo.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888) : Util.createWhiteBitmap();
            Canvas canvas = new Canvas((Bitmap)context);
            applicationInfo.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            applicationInfo.draw(canvas);
        } else {
            context = Util.createWhiteBitmap();
        }
        return context;
    }

    private static Bitmap createWhiteBitmap() {
        Bitmap bitmap = Bitmap.createBitmap((int)40, (int)40, (Bitmap.Config)Bitmap.Config.RGB_565);
        int[] nArray = new int[1600];
        int n = 0;
        while (true) {
            if (n >= 40) {
                bitmap.setPixels(nArray, 0, 40, 0, 0, 40, 40);
                return bitmap;
            }
            for (int i = 0; i < 40; ++i) {
                int n2 = n * 40 + i;
                nArray[n2] = (nArray[n2] >> 16 & 0xFF | 0xFF) << 16 | 0xFF000000 | (nArray[n2] >> 8 & 0xFF | 0xFF) << 8 | (nArray[n2] & 0xFF | 0xFF);
            }
            ++n;
        }
    }

    public static int genMessageId() {
        int n = sMessageId;
        sMessageId = n + 1;
        return n;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public static byte[] getAlphaJpegImage(Bitmap bitmap) {
        byte[] byArray;
        Logger.i((String)"getAlphaJpegImage()", (Object[])new Object[0]);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)byteArrayOutputStream);
        byte[] byArray2 = byteArrayOutputStream.toByteArray();
        if (!bitmap.hasAlpha()) {
            return byArray2;
        }
        int n = bitmap.getWidth();
        int n2 = bitmap.getHeight();
        int n3 = n * n2 + 2;
        int n4 = byteArrayOutputStream.size() + 2 + n3;
        if (n4 > 65535) {
            return byArray2;
        }
        try {
            byArray = new byte[n4];
            byArray2 = byArray;
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, byArray, 0, 2);
            byArray[2] = -1;
            byArray[3] = -18;
        }
        catch (IOException iOException) {
            return byArray2;
        }
        byArray[4] = (byte)(n3 >> 8);
        byte by = (byte)(n3 & 0xFF);
        n4 = 5;
        byArray[5] = by;
        for (n3 = 0; n3 < n2; ++n3) {
            for (int i = 0; i < n; ++n4, ++i) {
                byArray2 = byArray;
                {
                    byArray[n4] = (byte)Color.alpha((int)bitmap.getPixel(i, n3));
                    continue;
                }
            }
        }
        byArray2 = byArray;
        {
            System.arraycopy(byteArrayOutputStream.toByteArray(), 2, byArray, n4 + 1, byteArrayOutputStream.size() - 2);
            byArray2 = byArray;
            byteArrayOutputStream.close();
            return byArray;
        }
    }

    public static Bitmap getAppIcon(Context context, ApplicationInfo applicationInfo) {
        Logger.i((String)"getAppIcon()", (Object[])new Object[0]);
        return Util.createIcon(context, applicationInfo, true);
    }

    public static ApplicationInfo getAppInfo(Context context, CharSequence charSequence) {
        context = context.getPackageManager();
        try {
            context = context.getApplicationInfo(charSequence.toString(), 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            context = null;
        }
        return context;
    }

    public static String getAppName(Context object, ApplicationInfo applicationInfo) {
        object = object != null && applicationInfo != null ? object.getPackageManager().getApplicationLabel(applicationInfo).toString() : "(unknown)";
        return object;
    }

    public static long getAvailableStore(String string) {
        string = new StatFs(string);
        long l = string.getBlockSize();
        return (long)string.getAvailableBlocks() * l / 1024L;
    }

    public static String getContactName(Context object, String charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (((String)charSequence).equals("")) {
            return null;
        }
        try {
            Uri uri = Uri.withAppendedPath((Uri)ContactsContract.PhoneLookup.CONTENT_FILTER_URI, (String)Uri.encode((String)charSequence));
            uri = object.getContentResolver().query(uri, new String[]{"display_name"}, null, null, null);
            object = charSequence;
            if (uri != null) {
                object = charSequence;
                if (uri.moveToFirst()) {
                    object = uri.getString(0);
                }
            }
            uri.close();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getContactName(), contactName=");
            ((StringBuilder)charSequence).append((String)object);
            Logger.i((String)((StringBuilder)charSequence).toString(), (Object[])new Object[0]);
            return object;
        }
        catch (Exception exception) {
            Logger.i((String)"getContactName Exception", (Object[])new Object[0]);
            return null;
        }
    }

    public static String getFormatedDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static byte[] getJpgBytes(Bitmap bitmap) {
        Logger.i((String)"getJpgBytesFromBitmap()", (Object[])new Object[0]);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String getKeyFromValue(CharSequence charSequence) {
        Iterator iterator = AppList.getInstance().getAppList().entrySet().iterator();
        String string = null;
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (!entry.getValue().equals(charSequence)) continue;
            string = entry.getKey().toString();
        }
        return string;
    }

    public static Bitmap getMessageIcon(Context context, ApplicationInfo applicationInfo) {
        return Util.createIcon(context, applicationInfo, false);
    }

    public static int getUtcTime(long l) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        return (int)(calendar.getTimeInMillis() / 1000L);
    }

    public static int getUtcTimeZone(long l) {
        int n;
        Serializable serializable = TimeZone.getDefault();
        int n2 = n = ((TimeZone)serializable).getRawOffset();
        if (((TimeZone)serializable).inDaylightTime(new Date(l))) {
            n2 = n + ((TimeZone)serializable).getDSTSavings();
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("getUtcTimeZone(), UTC time zone=");
        ((StringBuilder)serializable).append(n2);
        Logger.i((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
        return n2;
    }

    public static boolean isScreenLocked(Context object) {
        object = ((KeyguardManager)object.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isScreenOn(), isScreenOn=");
        stringBuilder.append(object);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        return (Boolean)object;
    }

    public static boolean isScreenOn(Context object) {
        object = ((PowerManager)object.getSystemService("power")).isScreenOn();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isScreenOn(), isScreenOn=");
        stringBuilder.append(object);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        return (Boolean)object;
    }

    public static boolean isSystemApp(ApplicationInfo applicationInfo) {
        boolean bl;
        int n = applicationInfo.flags;
        boolean bl2 = bl = true;
        if ((n & 1) != 0) return bl2;
        bl2 = (applicationInfo.flags & 0x80) != 0 ? bl : false;
        return bl2;
    }

    private static Bitmap resizeBitmapByScale(Bitmap bitmap, float f, float f2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("resizeBitmapByScale(), widthScale=");
        stringBuilder.append(f);
        stringBuilder.append(", heightScale=");
        stringBuilder.append(f2);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        stringBuilder = new Matrix();
        stringBuilder.postScale(f, f2);
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)stringBuilder, (boolean)true);
    }

    public static Bitmap resizeBitmapBySize(Bitmap bitmap, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("resizeBitmapBySize(), width=");
        stringBuilder.append(n);
        stringBuilder.append(", height=");
        stringBuilder.append(n2);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        return Util.resizeBitmapByScale(bitmap, (float)n / (float)bitmap.getWidth(), (float)n2 / (float)bitmap.getHeight());
    }
}
