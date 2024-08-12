/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.core.content.FileProvider
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Sink
 *  okio.Source
 */
package com.luck.picture.lib.tools;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.Locale;
import java.util.Objects;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class PictureFileUtils {
    public static final String POSTFIX = ".jpeg";
    public static final String POST_AUDIO = ".amr";
    public static final String POST_VIDEO = ".mp4";
    static final String TAG = "PictureFileUtils";

    private PictureFileUtils() {
    }

    /*
     * WARNING - void declaration
     */
    public static boolean bufferCopy(File file, OutputStream outputStream) {
        Object object;
        Throwable throwable;
        block8: {
            block9: {
                throwable = null;
                Object var5_5 = null;
                BufferedSink bufferedSink = null;
                Object var6_11 = null;
                try {
                    object = Okio.buffer((Source)Okio.source((File)file));
                    file = var6_11;
                }
                catch (Throwable throwable2) {
                    object = null;
                    file = bufferedSink;
                    break block8;
                }
                catch (Exception exception) {
                    throwable = null;
                    file = var5_5;
                    break block9;
                }
                try {
                    bufferedSink = Okio.buffer((Sink)Okio.sink((OutputStream)outputStream));
                    file = bufferedSink;
                    throwable = bufferedSink;
                    bufferedSink.writeAll((Source)object);
                    file = bufferedSink;
                    throwable = bufferedSink;
                    bufferedSink.flush();
                }
                catch (Throwable throwable3) {
                    bufferedSink = object;
                    object = file;
                    file = bufferedSink;
                    break block8;
                }
                catch (Exception exception) {
                    file = object;
                    break block9;
                }
                PictureFileUtils.close((Closeable)object);
                PictureFileUtils.close(outputStream);
                PictureFileUtils.close((Closeable)bufferedSink);
                return true;
            }
            try {
                void var4_9;
                var4_9.printStackTrace();
            }
            catch (Throwable throwable4) {
                object = throwable;
                throwable = throwable4;
                break block8;
            }
            PictureFileUtils.close((Closeable)((Object)file));
            PictureFileUtils.close(outputStream);
            PictureFileUtils.close((Closeable)((Object)throwable));
            return false;
        }
        PictureFileUtils.close((Closeable)((Object)file));
        PictureFileUtils.close(outputStream);
        PictureFileUtils.close((Closeable)object);
        throw throwable;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static boolean bufferCopy(BufferedSource bufferedSource, File file) {
        Throwable throwable2222222;
        File file2;
        block4: {
            File file3 = null;
            file2 = null;
            file2 = file = Okio.buffer((Sink)Okio.sink((File)file));
            file3 = file;
            file.writeAll((Source)bufferedSource);
            file2 = file;
            file3 = file;
            file.flush();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (Exception exception) {}
                file2 = file3;
                {
                    exception.printStackTrace();
                }
                PictureFileUtils.close((Closeable)bufferedSource);
                PictureFileUtils.close((Closeable)((Object)file3));
                return false;
            }
            PictureFileUtils.close((Closeable)bufferedSource);
            PictureFileUtils.close((Closeable)((Object)file));
            return true;
        }
        PictureFileUtils.close((Closeable)bufferedSource);
        PictureFileUtils.close((Closeable)((Object)file2));
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static boolean bufferCopy(BufferedSource bufferedSource, OutputStream outputStream) {
        Throwable throwable2222222;
        OutputStream outputStream2;
        block4: {
            OutputStream outputStream3 = null;
            outputStream2 = null;
            outputStream2 = outputStream = Okio.buffer((Sink)Okio.sink((OutputStream)outputStream));
            outputStream3 = outputStream;
            outputStream.writeAll((Source)bufferedSource);
            outputStream2 = outputStream;
            outputStream3 = outputStream;
            outputStream.flush();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (Exception exception) {}
                outputStream2 = outputStream3;
                {
                    exception.printStackTrace();
                }
                PictureFileUtils.close((Closeable)bufferedSource);
                PictureFileUtils.close(outputStream3);
                return false;
            }
            PictureFileUtils.close((Closeable)bufferedSource);
            PictureFileUtils.close(outputStream);
            return true;
        }
        PictureFileUtils.close((Closeable)bufferedSource);
        PictureFileUtils.close(outputStream2);
        throw throwable2222222;
    }

    /*
     * Enabled force condition propagation
     */
    public static void close(Closeable closeable) {
        if (!(closeable instanceof Closeable)) return;
        try {
            closeable.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void copyFile(String object, String object2) throws IOException {
        void var1_4;
        Object object3;
        block6: {
            block7: {
                Closeable closeable;
                Object object4;
                if (((String)object).equalsIgnoreCase((String)object2)) {
                    return;
                }
                Object object5 = null;
                object3 = null;
                try {
                    object4 = new File((String)object);
                    closeable = new FileInputStream((File)object4);
                    closeable = ((FileInputStream)closeable).getChannel();
                    object = object3;
                }
                catch (Throwable throwable) {
                    object3 = null;
                    object = object5;
                    break block6;
                }
                try {
                    object = object3;
                    object = object3;
                    object5 = new File((String)object2);
                    object = object3;
                    object4 = new FileOutputStream((File)object5);
                    object = object3;
                    object = object2 = ((FileOutputStream)object4).getChannel();
                    ((FileChannel)closeable).transferTo(0L, ((FileChannel)closeable).size(), (WritableByteChannel)object2);
                    object = object2;
                    ((AbstractInterruptibleChannel)closeable).close();
                    if (closeable == null) break block7;
                }
                catch (Throwable throwable) {
                    object3 = closeable;
                    object5 = object;
                    object = object3;
                    object3 = object5;
                    break block6;
                }
                ((AbstractInterruptibleChannel)closeable).close();
            }
            if (object2 == null) return;
            ((AbstractInterruptibleChannel)object2).close();
            return;
        }
        if (object != null) {
            ((AbstractInterruptibleChannel)object).close();
        }
        if (object3 == null) throw var1_4;
        ((AbstractInterruptibleChannel)object3).close();
        throw var1_4;
    }

    public static File createCameraFile(Context context, int n, String string, String string2, String string3) {
        return PictureFileUtils.createMediaFile(context, n, string, string2, string3);
    }

    public static String createFilePath(Context object, String charSequence, String charSequence2, String string) {
        String string2 = PictureMimeType.getLastImgSuffix((String)charSequence2);
        if (PictureMimeType.isHasVideo((String)charSequence2)) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(PictureFileUtils.getVideoDiskCacheDir((Context)object));
            ((StringBuilder)charSequence2).append(File.separator);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                object = string;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("VID_");
                    ((StringBuilder)object).append(((String)charSequence).toUpperCase());
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append((String)object);
                return ((StringBuilder)charSequence).toString();
            }
            object = string;
            if (TextUtils.isEmpty((CharSequence)string)) {
                object = new StringBuilder();
                ((StringBuilder)object).append(DateUtils.getCreateFileName((String)"VID_"));
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        if (PictureMimeType.isHasAudio((String)charSequence2)) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(PictureFileUtils.getAudioDiskCacheDir((Context)object));
            ((StringBuilder)charSequence2).append(File.separator);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                object = string;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("AUD_");
                    ((StringBuilder)object).append(((String)charSequence).toUpperCase());
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append((String)object);
                return ((StringBuilder)charSequence).toString();
            }
            object = string;
            if (TextUtils.isEmpty((CharSequence)string)) {
                object = new StringBuilder();
                ((StringBuilder)object).append(DateUtils.getCreateFileName((String)"AUD_"));
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(PictureFileUtils.getDiskCacheDir((Context)object));
        ((StringBuilder)charSequence2).append(File.separator);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            object = string;
            if (TextUtils.isEmpty((CharSequence)string)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("IMG_");
                ((StringBuilder)object).append(((String)charSequence).toUpperCase());
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        object = string;
        if (TextUtils.isEmpty((CharSequence)string)) {
            object = new StringBuilder();
            ((StringBuilder)object).append(DateUtils.getCreateFileName((String)"IMG_"));
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append((String)object);
        return ((StringBuilder)charSequence).toString();
    }

    private static File createMediaFile(Context context, int n, String string, String string2, String string3) {
        return PictureFileUtils.createOutFile(context, n, string, string2, string3);
    }

    private static File createOutFile(Context object, int n, String charSequence, String string, String object2) {
        object = object.getApplicationContext();
        if (TextUtils.isEmpty((CharSequence)object2)) {
            File file;
            if (TextUtils.equals((CharSequence)"mounted", (CharSequence)Environment.getExternalStorageState())) {
                file = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM);
                object = new StringBuilder();
                ((StringBuilder)object).append(file.getAbsolutePath());
                ((StringBuilder)object).append(File.separator);
                ((StringBuilder)object).append("Camera");
                ((StringBuilder)object).append(File.separator);
                object = new File(((StringBuilder)object).toString());
            } else {
                file = PictureFileUtils.getRootDirFile((Context)object, n);
                object = new StringBuilder();
                ((StringBuilder)object).append(file.getAbsolutePath());
                ((StringBuilder)object).append(File.separator);
                object = new File(((StringBuilder)object).toString());
            }
            object2 = object;
            if (!file.exists()) {
                file.mkdirs();
                object2 = object;
            }
        } else if (!Objects.requireNonNull(((File)(object2 = new File((String)object2))).getParentFile()).exists()) {
            ((File)object2).getParentFile().mkdirs();
        }
        if (!((File)object2).exists()) {
            ((File)object2).mkdirs();
        }
        boolean bl = TextUtils.isEmpty((CharSequence)charSequence);
        if (n == 2) {
            if (!bl) return new File((File)object2, (String)charSequence);
            object = new StringBuilder();
            ((StringBuilder)object).append(DateUtils.getCreateFileName((String)"VID_"));
            ((StringBuilder)object).append(POST_VIDEO);
            charSequence = ((StringBuilder)object).toString();
            return new File((File)object2, (String)charSequence);
        }
        if (n == 3) {
            if (!bl) return new File((File)object2, (String)charSequence);
            object = new StringBuilder();
            ((StringBuilder)object).append(DateUtils.getCreateFileName((String)"AUD_"));
            ((StringBuilder)object).append(POST_AUDIO);
            charSequence = ((StringBuilder)object).toString();
            return new File((File)object2, (String)charSequence);
        }
        object = string;
        if (TextUtils.isEmpty((CharSequence)string)) {
            object = POSTFIX;
        }
        if (!bl) return new File((File)object2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(DateUtils.getCreateFileName((String)"IMG_"));
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        return new File((File)object2, (String)charSequence);
    }

    public static void deleteAllCacheDirFile(Context object) {
        Object object22;
        Object object32 = object.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        int n = 0;
        if (object32 != null && (object22 = ((File)object32).listFiles()) != null) {
            for (Object object32 : object22) {
                if (!((File)object32).isFile()) continue;
                ((File)object32).delete();
            }
        }
        if ((object32 = object.getExternalFilesDir(Environment.DIRECTORY_MOVIES)) != null && (object32 = ((File)object32).listFiles()) != null) {
            for (Object object22 : object32) {
                if (!((File)object22).isFile()) continue;
                ((File)object22).delete();
            }
        }
        if ((object = object.getExternalFilesDir(Environment.DIRECTORY_MUSIC)) == null) return;
        if ((object = ((File)object).listFiles()) == null) return;
        int n2 = ((Object)object).length;
        int n3 = n;
        while (n3 < n2) {
            object32 = object[n3];
            if (((File)object32).isFile()) {
                ((File)object32).delete();
            }
            ++n3;
        }
    }

    public static void deleteCacheDirFile(Context object, int n) {
        Object object2 = n == PictureMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES;
        object = object.getExternalFilesDir((String)object2);
        if (object == null) return;
        object2 = ((File)object).listFiles();
        if (object2 == null) return;
        int n2 = ((File[])object2).length;
        n = 0;
        while (n < n2) {
            object = object2[n];
            if (((File)object).isFile()) {
                ((File)object).delete();
            }
            ++n;
        }
    }

    public static String getAudioDiskCacheDir(Context object) {
        if ((object = object.getExternalFilesDir(Environment.DIRECTORY_MUSIC)) != null) return ((File)object).getPath();
        return "";
    }

    public static String getDCIMCameraPath() {
        try {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("%");
            charSequence.append(Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM).getAbsolutePath());
            charSequence.append("/Camera");
            charSequence = charSequence.toString();
            return charSequence;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static String getDataColumn(Context context, Uri object, String string, String[] stringArray) {
        Throwable throwable2;
        Context context2;
        block5: {
            block6: {
                block4: {
                    Context context3 = null;
                    context2 = null;
                    context = context.getContentResolver().query(object, new String[]{"_data"}, string, stringArray, null);
                    if (context == null) break block4;
                    context2 = context;
                    context3 = context;
                    if (!context.moveToFirst()) break block4;
                    context2 = context;
                    context3 = context;
                    object = context.getString(context.getColumnIndexOrThrow("_data"));
                    if (context == null) return object;
                    {
                        catch (Throwable throwable2) {
                            break block5;
                        }
                        catch (IllegalArgumentException illegalArgumentException) {}
                        context2 = context3;
                        {
                            Log.i((String)TAG, (String)String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", illegalArgumentException.getMessage()));
                            if (context3 == null) return "";
                            context = context3;
                            break block6;
                        }
                    }
                    context.close();
                    return object;
                }
                if (context == null) return "";
            }
            context.close();
            return "";
        }
        if (context2 == null) throw throwable2;
        context2.close();
        throw throwable2;
    }

    public static String getDiskCacheDir(Context object) {
        if ((object = object.getExternalFilesDir(Environment.DIRECTORY_PICTURES)) != null) return ((File)object).getPath();
        return "";
    }

    public static String getPath(Context stringArray, Uri object) {
        Context context = stringArray.getApplicationContext();
        boolean bl = Build.VERSION.SDK_INT >= 19;
        stringArray = null;
        if (bl && DocumentsContract.isDocumentUri((Context)context, (Uri)object)) {
            if (PictureFileUtils.isExternalStorageDocument((Uri)object)) {
                stringArray = DocumentsContract.getDocumentId((Uri)object).split(":");
                if (!"primary".equalsIgnoreCase(stringArray[0])) return "";
                if (SdkVersionUtils.checkedAndroid_Q()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                    ((StringBuilder)object).append("/");
                    ((StringBuilder)object).append((String)stringArray[1]);
                    return ((StringBuilder)object).toString();
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(Environment.getExternalStorageDirectory());
                ((StringBuilder)object).append("/");
                ((StringBuilder)object).append((String)stringArray[1]);
                return ((StringBuilder)object).toString();
            }
            if (PictureFileUtils.isDownloadsDocument((Uri)object)) {
                stringArray = DocumentsContract.getDocumentId((Uri)object);
                return PictureFileUtils.getDataColumn(context, ContentUris.withAppendedId((Uri)Uri.parse((String)"content://downloads/public_downloads"), (long)ValueOf.toLong((Object)stringArray)), null, null);
            }
            if (!PictureFileUtils.isMediaDocument((Uri)object)) return "";
            String string = (object = DocumentsContract.getDocumentId((Uri)object).split(":"))[0];
            if ("image".equals(string)) {
                stringArray = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(string)) {
                stringArray = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                if (!"audio".equals(string)) return PictureFileUtils.getDataColumn(context, (Uri)stringArray, "_id=?", new String[]{object[1]});
                stringArray = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return PictureFileUtils.getDataColumn(context, (Uri)stringArray, "_id=?", new String[]{object[1]});
        }
        if ("content".equalsIgnoreCase(object.getScheme())) {
            if (!PictureFileUtils.isGooglePhotosUri((Uri)object)) return PictureFileUtils.getDataColumn(context, (Uri)object, null, null);
            return object.getLastPathSegment();
        }
        if (!"file".equalsIgnoreCase(object.getScheme())) return "";
        return object.getPath();
    }

    private static File getRootDirFile(Context context, int n) {
        if (n == 2) return context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (n == 3) return context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    public static String getVideoDiskCacheDir(Context object) {
        if ((object = object.getExternalFilesDir(Environment.DIRECTORY_MOVIES)) != null) return ((File)object).getPath();
        return "";
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFileExists(String string) {
        boolean bl = TextUtils.isEmpty((CharSequence)string) || new File(string).exists();
        return bl;
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri parUri(Context context, File file) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append(context.getPackageName());
        charSequence.append(".luckProvider");
        charSequence = charSequence.toString();
        context = Build.VERSION.SDK_INT > 23 ? FileProvider.getUriForFile((Context)context, (String)charSequence, (File)file) : Uri.fromFile((File)file);
        return context;
    }
}
