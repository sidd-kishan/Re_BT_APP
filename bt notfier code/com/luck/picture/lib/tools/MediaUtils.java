/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Environment
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Files
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  androidx.exifinterface.media.ExifInterface
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.MediaExtraInfo
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.tools;

import android.content.ContentValues;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.io.Closeable;
import java.io.InputStream;

public class MediaUtils {
    public static Uri createAudioUri(Context object, String string) {
        ContentValues contentValues;
        String string2;
        Uri[] uriArray;
        Context context;
        block8: {
            block7: {
                context = object.getApplicationContext();
                uriArray = new Uri[]{null};
                string2 = Environment.getExternalStorageState();
                object = ValueOf.toString((Object)System.currentTimeMillis());
                contentValues = new ContentValues(3);
                contentValues.put("_display_name", DateUtils.getCreateFileName((String)"AUD_"));
                if (Build.VERSION.SDK_INT >= 29) {
                    contentValues.put("datetaken", (String)object);
                }
                if (TextUtils.isEmpty((CharSequence)string) || string.startsWith("image")) break block7;
                object = string;
                if (!string.startsWith("video")) break block8;
            }
            object = "audio/amr";
        }
        contentValues.put("mime_type", (String)object);
        if (string2.equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
            }
            uriArray[0] = context.getContentResolver().insert(MediaStore.Audio.Media.getContentUri((String)"external"), contentValues);
        } else {
            uriArray[0] = context.getContentResolver().insert(MediaStore.Audio.Media.getContentUri((String)"internal"), contentValues);
        }
        return uriArray[0];
    }

    public static Uri createImageUri(Context object, String string, String string2) {
        ContentValues contentValues;
        String string3;
        Uri[] uriArray;
        Context context;
        block12: {
            block11: {
                context = object.getApplicationContext();
                uriArray = new Uri[]{null};
                string3 = Environment.getExternalStorageState();
                object = ValueOf.toString((Object)System.currentTimeMillis());
                contentValues = new ContentValues(3);
                if (TextUtils.isEmpty((CharSequence)string)) {
                    contentValues.put("_display_name", DateUtils.getCreateFileName((String)"IMG_"));
                } else if (string.lastIndexOf(".") == -1) {
                    contentValues.put("_display_name", DateUtils.getCreateFileName((String)"IMG_"));
                } else {
                    contentValues.put("_display_name", string.replaceAll(string.substring(string.lastIndexOf(".")), ""));
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    contentValues.put("datetaken", (String)object);
                }
                if (TextUtils.isEmpty((CharSequence)string2)) break block11;
                object = string2;
                if (!string2.startsWith("video")) break block12;
            }
            object = "image/jpeg";
        }
        contentValues.put("mime_type", (String)object);
        if (string3.equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", "DCIM/Camera");
            }
            uriArray[0] = context.getContentResolver().insert(MediaStore.Images.Media.getContentUri((String)"external"), contentValues);
        } else {
            uriArray[0] = context.getContentResolver().insert(MediaStore.Images.Media.getContentUri((String)"internal"), contentValues);
        }
        return uriArray[0];
    }

    public static Bundle createQueryArgsBundle(String charSequence, String[] stringArray, int n, int n2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT < 26) return bundle;
        bundle.putString("android:query-arg-sql-selection", (String)charSequence);
        bundle.putStringArray("android:query-arg-sql-selection-args", stringArray);
        bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
        if (Build.VERSION.SDK_INT < 30) return bundle;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(n);
        ((StringBuilder)charSequence).append(" offset ");
        ((StringBuilder)charSequence).append(n2);
        bundle.putString("android:query-arg-sql-limit", ((StringBuilder)charSequence).toString());
        return bundle;
    }

    public static Uri createVideoUri(Context object, String string, String string2) {
        ContentValues contentValues;
        String string3;
        Uri[] uriArray;
        Context context;
        block12: {
            block11: {
                context = object.getApplicationContext();
                uriArray = new Uri[]{null};
                string3 = Environment.getExternalStorageState();
                object = ValueOf.toString((Object)System.currentTimeMillis());
                contentValues = new ContentValues(3);
                if (TextUtils.isEmpty((CharSequence)string)) {
                    contentValues.put("_display_name", DateUtils.getCreateFileName((String)"VID_"));
                } else if (string.lastIndexOf(".") == -1) {
                    contentValues.put("_display_name", DateUtils.getCreateFileName((String)"VID_"));
                } else {
                    contentValues.put("_display_name", string.replaceAll(string.substring(string.lastIndexOf(".")), ""));
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    contentValues.put("datetaken", (String)object);
                }
                if (TextUtils.isEmpty((CharSequence)string2)) break block11;
                object = string2;
                if (!string2.startsWith("image")) break block12;
            }
            object = "video/mp4";
        }
        contentValues.put("mime_type", (String)object);
        if (string3.equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
            }
            uriArray[0] = context.getContentResolver().insert(MediaStore.Video.Media.getContentUri((String)"external"), contentValues);
        } else {
            uriArray[0] = context.getContentResolver().insert(MediaStore.Video.Media.getContentUri((String)"internal"), contentValues);
        }
        return uriArray[0];
    }

    public static void deleteCamera(Context context, String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        if (!SdkVersionUtils.checkedAndroid_Q()) return;
        if (!PictureMimeType.isContent((String)string)) return;
        context.getContentResolver().delete(Uri.parse((String)string), null, null);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public static String getAudioFilePathFromUri(Context var0, Uri var1_3) {
        var2_6 = var3_5 = "";
        var1_3 = var0 /* !! */ .getApplicationContext().getContentResolver().query(var1_3, null, null, null, null);
        var0 /* !! */  = var3_5;
        if (var1_3 == null) ** GOTO lbl25
        try {
            var1_3.moveToFirst();
            var0 /* !! */  = var1_3.getString(var1_3.getColumnIndex("_data"));
            ** GOTO lbl25
        }
        catch (Throwable var4_7) {
            try {
                throw var4_7;
            }
            catch (Throwable var0_1) {
                if (var1_3 == null) ** GOTO lbl23
                try {
                    var1_3.close();
                    ** GOTO lbl23
                }
                catch (Throwable var1_4) {
                    var2_6 = var3_5;
                    try {
                        var4_7.addSuppressed(var1_4);
lbl23:
                        // 3 sources

                        var2_6 = var3_5;
                        throw var0_1;
lbl25:
                        // 2 sources

                        var2_6 = var0 /* !! */ ;
                        if (var1_3 == null) return var2_6;
                        var2_6 = var0 /* !! */ ;
                        var1_3.close();
                        return var0 /* !! */ ;
                    }
                    catch (Exception var0_2) {
                        var0_2.printStackTrace();
                    }
                }
            }
        }
        return var2_6;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static MediaExtraInfo getAudioSize(Context context, String string) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (PictureMimeType.isContent((String)string)) {
                    mediaMetadataRetriever.setDataSource(context, Uri.parse((String)string));
                } else {
                    mediaMetadataRetriever.setDataSource(string);
                }
                mediaExtraInfo.setDuration(ValueOf.toLong((Object)mediaMetadataRetriever.extractMetadata(9)));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        catch (Throwable throwable2222) {}
        mediaMetadataRetriever.release();
        return mediaExtraInfo;
        mediaMetadataRetriever.release();
        throw throwable2222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static long getCameraFirstBucketId(Context context) {
        Throwable throwable2222222;
        Context context2;
        block7: {
            block8: {
                block6: {
                    Context context3;
                    Context context4 = null;
                    context2 = context3 = null;
                    Context context5 = context4;
                    String string = PictureFileUtils.getDCIMCameraPath();
                    context2 = context3;
                    context5 = context4;
                    Bundle bundle = new String[1];
                    context2 = context3;
                    context5 = context4;
                    context2 = context3;
                    context5 = context4;
                    StringBuilder stringBuilder = new StringBuilder();
                    context2 = context3;
                    context5 = context4;
                    stringBuilder.append(string);
                    context2 = context3;
                    context5 = context4;
                    stringBuilder.append("%");
                    context2 = context3;
                    context5 = context4;
                    bundle[0] = stringBuilder.toString();
                    context2 = context3;
                    context5 = context4;
                    boolean bl = SdkVersionUtils.checkedAndroid_R();
                    if (bl) {
                        context2 = context3;
                        context5 = context4;
                        bundle = MediaUtils.createQueryArgsBundle("_data like ?", (String[])bundle, 1, 0);
                        context2 = context3;
                        context5 = context4;
                        context = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri((String)"external"), null, bundle, null);
                    } else {
                        context2 = context3;
                        context5 = context4;
                        context = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri((String)"external"), null, "_data like ?", (String[])bundle, "_id DESC limit 1 offset 0");
                    }
                    if (context == null) break block6;
                    context2 = context;
                    context5 = context;
                    if (context.getCount() <= 0) break block6;
                    context2 = context;
                    context5 = context;
                    if (!context.moveToFirst()) break block6;
                    context2 = context;
                    context5 = context;
                    long l = context.getLong(context.getColumnIndex("bucket_id"));
                    if (context == null) return l;
                    {
                        catch (Throwable throwable2222222) {
                            break block7;
                        }
                        catch (Exception exception) {}
                        context2 = context5;
                        {
                            exception.printStackTrace();
                            if (context5 == null) return -1L;
                            context = context5;
                            break block8;
                        }
                    }
                    context.close();
                    return l;
                }
                if (context == null) return -1L;
            }
            context.close();
            return -1L;
        }
        if (context2 == null) throw throwable2222222;
        context2.close();
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static int getDCIMLastImageId(Context context) {
        Throwable throwable2222222;
        Context context2;
        block8: {
            block7: {
                Context context3;
                int n = -1;
                Context context4 = null;
                context2 = context3 = null;
                Context context5 = context4;
                String string = PictureFileUtils.getDCIMCameraPath();
                context2 = context3;
                context5 = context4;
                String[] stringArray = new String[1];
                context2 = context3;
                context5 = context4;
                context2 = context3;
                context5 = context4;
                StringBuilder stringBuilder = new StringBuilder();
                context2 = context3;
                context5 = context4;
                stringBuilder.append(string);
                context2 = context3;
                context5 = context4;
                stringBuilder.append("%");
                context2 = context3;
                context5 = context4;
                stringArray[0] = stringBuilder.toString();
                context2 = context3;
                context5 = context4;
                if (SdkVersionUtils.checkedAndroid_R()) {
                    context2 = context3;
                    context5 = context4;
                    stringBuilder = MediaUtils.createQueryArgsBundle("_data like ?", stringArray, 1, 0);
                    context2 = context3;
                    context5 = context4;
                    context = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, (Bundle)stringBuilder, null);
                } else {
                    context2 = context3;
                    context5 = context4;
                    context = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data like ?", stringArray, "_id DESC limit 1 offset 0");
                }
                if (context == null) break block7;
                context2 = context;
                context5 = context;
                if (context.getCount() <= 0) break block7;
                context2 = context;
                context5 = context;
                if (!context.moveToFirst()) break block7;
                context2 = context;
                context5 = context;
                int n2 = context.getInt(context.getColumnIndex("_id"));
                context2 = context;
                context5 = context;
                int n3 = DateUtils.dateDiffer((long)context.getLong(context.getColumnIndex("date_added")));
                if (n3 <= 1) {
                    n = n2;
                }
                if (context == null) return n;
                {
                    catch (Throwable throwable2222222) {
                        break block8;
                    }
                    catch (Exception exception) {}
                    context2 = context5;
                    {
                        exception.printStackTrace();
                        if (context5 == null) return -1;
                    }
                    context5.close();
                    return -1;
                }
                context.close();
                return n;
            }
            if (context == null) return -1;
            context.close();
            return -1;
        }
        if (context2 == null) throw throwable2222222;
        context2.close();
        throw throwable2222222;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static MediaExtraInfo getImageSize(Context object, String string) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        Object object3 = null;
        Object object4 = null;
        Object var4_7 = null;
        Object object2 = object3;
        Object object5 = object4;
        try {
            try {
                if (PictureMimeType.isContent((String)string)) {
                    object2 = object3;
                    object5 = object4;
                    object2 = object = object.getContentResolver().openInputStream(Uri.parse((String)string));
                    object5 = object;
                    object2 = object;
                    object5 = object;
                    string = new ExifInterface((InputStream)object);
                } else {
                    object2 = object3;
                    object5 = object4;
                    string = new ExifInterface(string);
                    object = var4_7;
                }
                object2 = object;
                object5 = object;
                mediaExtraInfo.setWidth(string.getAttributeInt("ImageWidth", 1));
                object2 = object;
                object5 = object;
                mediaExtraInfo.setHeight(string.getAttributeInt("ImageLength", 1));
            }
            catch (Exception exception) {
                object2 = object5;
                exception.printStackTrace();
                object = object5;
            }
        }
        catch (Throwable throwable2222) {}
        PictureFileUtils.close((Closeable)object);
        return mediaExtraInfo;
        PictureFileUtils.close(object2);
        throw throwable2222;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static MediaExtraInfo getVideoSize(Context object, String string) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                int n;
                int n2;
                if (PictureMimeType.isContent((String)string)) {
                    mediaMetadataRetriever.setDataSource((Context)object, Uri.parse((String)string));
                } else {
                    mediaMetadataRetriever.setDataSource(string);
                }
                object = mediaMetadataRetriever.extractMetadata(24);
                if (!TextUtils.equals((CharSequence)"90", (CharSequence)object) && !TextUtils.equals((CharSequence)"270", (CharSequence)object)) {
                    n2 = ValueOf.toInt((Object)mediaMetadataRetriever.extractMetadata(18));
                    n = ValueOf.toInt((Object)mediaMetadataRetriever.extractMetadata(19));
                } else {
                    n = ValueOf.toInt((Object)mediaMetadataRetriever.extractMetadata(18));
                    n2 = ValueOf.toInt((Object)mediaMetadataRetriever.extractMetadata(19));
                }
                mediaExtraInfo.setWidth(n2);
                mediaExtraInfo.setHeight(n);
                mediaExtraInfo.setDuration(ValueOf.toLong((Object)mediaMetadataRetriever.extractMetadata(9)));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        catch (Throwable throwable2222) {}
        mediaMetadataRetriever.release();
        return mediaExtraInfo;
        mediaMetadataRetriever.release();
        throw throwable2222;
    }

    public static boolean isLongImg(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n <= 0) return bl2;
        if (n2 <= 0) {
            bl2 = bl;
        } else {
            bl2 = bl;
            if (n2 <= n * 3) return bl2;
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isLongImg(LocalMedia localMedia) {
        boolean bl;
        int n = localMedia.getWidth();
        int n2 = localMedia.getHeight();
        boolean bl2 = bl = false;
        if (n <= 0) return bl2;
        if (n2 <= 0) {
            bl2 = bl;
        } else {
            bl2 = bl;
            if (n2 <= n * 3) return bl2;
            bl2 = true;
        }
        return bl2;
    }

    public static void removeMedia(Context context, int n) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString(n)});
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
