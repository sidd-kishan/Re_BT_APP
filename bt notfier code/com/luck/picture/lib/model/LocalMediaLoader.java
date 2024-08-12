/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.MediaStore$Files
 *  android.text.TextUtils
 *  android.util.Log
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.model._$$Lambda$LocalMediaLoader$LafE7yF8qALfFSTGs7g_TFKjrnc
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.model._$;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Deprecated
public final class LocalMediaLoader {
    private static final long FILE_SIZE_UNIT = 0x100000L;
    private static final String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final String ORDER_BY = "_id DESC";
    private static final String[] PROJECTION;
    private static final Uri QUERY_URI;
    private static final String TAG;
    private final PictureSelectionConfig config;
    private final boolean isAndroidQ;
    private final Context mContext;

    static {
        TAG = LocalMediaLoader.class.getSimpleName();
        QUERY_URI = MediaStore.Files.getContentUri((String)"external");
        PROJECTION = new String[]{"_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", "bucket_id", "date_added"};
    }

    public LocalMediaLoader(Context context) {
        this.mContext = context.getApplicationContext();
        this.isAndroidQ = SdkVersionUtils.checkedAndroid_Q();
        this.config = PictureSelectionConfig.getInstance();
    }

    private String getDurationCondition() {
        long l = this.config.videoMaxSecond == 0 ? Long.MAX_VALUE : (long)this.config.videoMaxSecond;
        Locale locale = Locale.CHINA;
        long l2 = Math.max(0L, (long)this.config.videoMinSecond);
        String string = Math.max(0L, (long)this.config.videoMinSecond) == 0L ? "" : "=";
        return String.format(locale, "%d <%s duration and duration <= %d", l2, string, l);
    }

    private String getFileSizeCondition() {
        long l = this.config.filterMaxFileSize == 0L ? Long.MAX_VALUE : this.config.filterMaxFileSize;
        Locale locale = Locale.CHINA;
        long l2 = Math.max(0L, this.config.filterMinFileSize);
        String string = Math.max(0L, this.config.filterMinFileSize) == 0L ? "" : "=";
        return String.format(locale, "%d <%s _size and _size <= %d", l2, string, l);
    }

    private LocalMediaFolder getImageFolder(String string, String string2, String object, List<LocalMediaFolder> list) {
        LocalMediaFolder localMediaFolder;
        Iterator<LocalMediaFolder> iterator;
        if (this.config.isFallbackVersion) {
            object = new File(string).getParentFile();
            iterator = list.iterator();
        } else {
            LocalMediaFolder localMediaFolder2;
            Object object2;
            Iterator<LocalMediaFolder> iterator2 = list.iterator();
            do {
                if (iterator2.hasNext()) continue;
                object2 = new LocalMediaFolder();
                object2.setName((String)object);
                object2.setFirstImagePath(string);
                object2.setFirstMimeType(string2);
                list.add((LocalMediaFolder)object2);
                return object2;
            } while (TextUtils.isEmpty((CharSequence)(object2 = (localMediaFolder2 = iterator2.next()).getName())) || !((String)object2).equals(object));
            return localMediaFolder2;
        }
        while (iterator.hasNext()) {
            localMediaFolder = iterator.next();
            String string3 = localMediaFolder.getName();
            if (TextUtils.isEmpty((CharSequence)string3) || object == null || !string3.equals(((File)object).getName())) continue;
            return localMediaFolder;
        }
        localMediaFolder = new LocalMediaFolder();
        object = object != null ? ((File)object).getName() : "";
        localMediaFolder.setName((String)object);
        localMediaFolder.setFirstImagePath(string);
        localMediaFolder.setFirstMimeType(string2);
        list.add(localMediaFolder);
        return localMediaFolder;
    }

    private String getQueryMimeCondition() {
        Object object = this.config.queryMimeTypeHashSet;
        HashSet<String> hashSet = object;
        if (object == null) {
            hashSet = new HashSet<String>();
        }
        if (!TextUtils.isEmpty((CharSequence)this.config.specifiedFormat)) {
            hashSet.add(this.config.specifiedFormat);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = hashSet.iterator();
        int n = -1;
        while (true) {
            if (!iterator.hasNext()) {
                if (this.config.chooseMode == PictureMimeType.ofVideo()) return stringBuilder.toString();
                if (this.config.isGif) return stringBuilder.toString();
                if (hashSet.contains(PictureMimeType.ofGIF())) return stringBuilder.toString();
                stringBuilder.append(NOT_GIF);
                return stringBuilder.toString();
            }
            String string = (String)iterator.next();
            if (TextUtils.isEmpty((CharSequence)string)) continue;
            if (this.config.chooseMode == PictureMimeType.ofVideo()) {
                if (string.startsWith("image") || string.startsWith("audio")) {
                    continue;
                }
            } else if (this.config.chooseMode != PictureMimeType.ofImage() ? this.config.chooseMode == PictureMimeType.ofAudio() && (string.startsWith("video") || string.startsWith("image")) : string.startsWith("audio") || string.startsWith("video")) continue;
            object = ++n == 0 ? " AND " : " OR ";
            stringBuilder.append((String)object);
            stringBuilder.append("mime_type");
            stringBuilder.append("='");
            stringBuilder.append(string);
            stringBuilder.append("'");
        }
    }

    private String getRealPathAndroid_Q(long l) {
        return QUERY_URI.buildUpon().appendPath(ValueOf.toString((Object)l)).build().toString();
    }

    private String getSelection() {
        String string = this.getDurationCondition();
        String string2 = this.getFileSizeCondition();
        String string3 = this.getQueryMimeCondition();
        int n = this.config.chooseMode;
        if (n == 0) return LocalMediaLoader.getSelectionArgsForAllMediaCondition(string, string2, string3);
        if (n == 1) return LocalMediaLoader.getSelectionArgsForImageMediaCondition(string2, string3);
        if (n == 2) return LocalMediaLoader.getSelectionArgsForVideoOrAudioMediaCondition(string2, string3);
        if (n == 3) return LocalMediaLoader.getSelectionArgsForVideoOrAudioMediaCondition(string, string3);
        return null;
    }

    private String[] getSelectionArgs() {
        int n = this.config.chooseMode;
        if (n == 0) return LocalMediaLoader.getSelectionArgsForAllMediaType();
        if (n == 1) return LocalMediaLoader.getSelectionArgsForSingleMediaType(1);
        if (n == 2) return LocalMediaLoader.getSelectionArgsForSingleMediaType(3);
        if (n == 3) return LocalMediaLoader.getSelectionArgsForSingleMediaType(2);
        return null;
    }

    private static String getSelectionArgsForAllMediaCondition(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append("media_type");
        stringBuilder.append("=?");
        stringBuilder.append(string3);
        stringBuilder.append(" OR ");
        stringBuilder.append("media_type");
        stringBuilder.append("=? AND ");
        stringBuilder.append(string);
        stringBuilder.append(") AND ");
        stringBuilder.append(string2);
        stringBuilder.toString();
        return stringBuilder.toString();
    }

    private static String[] getSelectionArgsForAllMediaType() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String getSelectionArgsForImageMediaCondition(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("media_type=?");
        stringBuilder.append(string2);
        stringBuilder.append(" AND ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private static String[] getSelectionArgsForSingleMediaType(int n) {
        return new String[]{String.valueOf(n)};
    }

    private static String getSelectionArgsForVideoOrAudioMediaCondition(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("media_type=?");
        stringBuilder.append(string2);
        stringBuilder.append(" AND ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    static /* synthetic */ int lambda$sortFolder$0(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null) return 0;
        if (localMediaFolder2.getData() == null) {
            return 0;
        }
        int n = localMediaFolder.getImageNum();
        return Integer.compare(localMediaFolder2.getImageNum(), n);
    }

    private void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, _$.Lambda.LocalMediaLoader.LafE7yF8qALfFSTGs7g_TFKjrnc.INSTANCE);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public List<LocalMediaFolder> loadAllMedia() {
        Throwable throwable2222222;
        Cursor cursor;
        block11: {
            cursor = this.mContext.getContentResolver().query(QUERY_URI, PROJECTION, this.getSelection(), this.getSelectionArgs(), ORDER_BY);
            if (cursor == null) {
                if (cursor == null) return null;
                if (cursor.isClosed()) return null;
                cursor.close();
                return null;
            }
            ArrayList<LocalMediaFolder> arrayList = new ArrayList<LocalMediaFolder>();
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            ArrayList<String> arrayList2 = new ArrayList<String>();
            if (cursor.getCount() > 0) {
                String string2;
                int n = cursor.getColumnIndexOrThrow(PROJECTION[0]);
                int n2 = cursor.getColumnIndexOrThrow(PROJECTION[1]);
                int n3 = cursor.getColumnIndexOrThrow(PROJECTION[2]);
                int n4 = cursor.getColumnIndexOrThrow(PROJECTION[3]);
                int n5 = cursor.getColumnIndexOrThrow(PROJECTION[4]);
                int n6 = cursor.getColumnIndexOrThrow(PROJECTION[5]);
                int n7 = cursor.getColumnIndexOrThrow(PROJECTION[6]);
                int n8 = cursor.getColumnIndexOrThrow(PROJECTION[7]);
                int n9 = cursor.getColumnIndexOrThrow(PROJECTION[8]);
                int n10 = cursor.getColumnIndexOrThrow(PROJECTION[9]);
                int n11 = cursor.getColumnIndexOrThrow(PROJECTION[10]);
                cursor.moveToFirst();
                do {
                    String string3;
                    long l = cursor.getLong(n);
                    String string4 = cursor.getString(n2);
                    String string5 = this.isAndroidQ ? this.getRealPathAndroid_Q(l) : string4;
                    string2 = string3 = cursor.getString(n3);
                    if (TextUtils.isEmpty((CharSequence)string3)) {
                        string2 = PictureMimeType.ofJPEG();
                    }
                    string3 = string2;
                    if (string2.endsWith("image/*")) {
                        string2 = PictureMimeType.isContent((String)string5) ? PictureMimeType.getImageMimeType((String)string4) : PictureMimeType.getImageMimeType((String)string5);
                        string3 = string2;
                        if (!this.config.isGif) {
                            string3 = string2;
                            if (PictureMimeType.isGif((String)string2)) continue;
                        }
                    }
                    if (!this.config.isWebp && string3.startsWith(PictureMimeType.ofWEBP()) || !this.config.isBmp && string3.startsWith(PictureMimeType.ofBMP())) continue;
                    int n12 = cursor.getInt(n4);
                    int n13 = cursor.getInt(n5);
                    long l2 = cursor.getLong(n6);
                    long l3 = cursor.getLong(n7);
                    String string6 = cursor.getString(n8);
                    String string7 = cursor.getString(n9);
                    long l4 = cursor.getLong(n10);
                    if (this.config.filterFileSize > 0.0f && (float)l3 > this.config.filterFileSize * 1048576.0f || PictureMimeType.isHasVideo((String)string3) && (this.config.videoMinSecond > 0 && l2 < (long)this.config.videoMinSecond || this.config.videoMaxSecond > 0 && l2 > (long)this.config.videoMaxSecond || l2 == 0L || l3 <= 0L)) continue;
                    string2 = new LocalMedia(l, string5, string4, string7, string6, l2, this.config.chooseMode, string3, n12, n13, l3, l4, cursor.getLong(n11));
                    string5 = this.getImageFolder(string5, string3, string6, arrayList);
                    string5.setBucketId(string2.getBucketId());
                    string5.getData().add(string2);
                    string5.setImageNum(string5.getImageNum() + 1);
                    string5.setBucketId(string2.getBucketId());
                    arrayList2.add(string2);
                    localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                } while (cursor.moveToNext());
                if (arrayList2.size() > 0) {
                    this.sortFolder(arrayList);
                    arrayList.add(0, localMediaFolder);
                    localMediaFolder.setFirstImagePath(((LocalMedia)arrayList2.get(0)).getPath());
                    localMediaFolder.setFirstMimeType(((LocalMedia)arrayList2.get(0)).getMimeType());
                    string2 = this.config.chooseMode == PictureMimeType.ofAudio() ? this.mContext.getString(R.string.picture_all_audio) : this.mContext.getString(R.string.picture_camera_roll);
                    localMediaFolder.setName(string2);
                    localMediaFolder.setBucketId(-1L);
                    localMediaFolder.setOfAllType(this.config.chooseMode);
                    localMediaFolder.setCameraFolder(true);
                    localMediaFolder.setData(arrayList2);
                }
            }
            if (cursor == null) return arrayList;
            {
                catch (Throwable throwable2222222) {
                    break block11;
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                    String string8 = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("loadAllMedia Data Error: ");
                    stringBuilder.append(exception.getMessage());
                    Log.i((String)string8, (String)stringBuilder.toString());
                    if (cursor == null) return null;
                }
                if (cursor.isClosed()) return null;
                cursor.close();
                return null;
            }
            if (cursor.isClosed()) return arrayList;
            cursor.close();
            return arrayList;
        }
        if (cursor == null) throw throwable2222222;
        if (cursor.isClosed()) throw throwable2222222;
        cursor.close();
        throw throwable2222222;
    }
}
