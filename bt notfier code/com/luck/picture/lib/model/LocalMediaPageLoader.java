/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  android.provider.MediaStore$Files
 *  android.text.TextUtils
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 *  com.luck.picture.lib.model._$$Lambda$LocalMediaPageLoader$emBWSexBuXWFQXco8EsphZe7J40
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import com.luck.picture.lib.model._$;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class LocalMediaPageLoader {
    private static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    private static final String COLUMN_BUCKET_ID = "bucket_id";
    private static final String COLUMN_COUNT = "count";
    private static final long FILE_SIZE_UNIT = 0x100000L;
    private static final String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    private static final String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final String ORDER_BY = "_id DESC";
    private static final String[] PROJECTION;
    private static final String[] PROJECTION_29;
    private static final String[] PROJECTION_PAGE;
    private static final Uri QUERY_URI;
    private static final String TAG;
    private static LocalMediaPageLoader instance;
    private final PictureSelectionConfig config;
    private final Context mContext;

    static {
        TAG = LocalMediaPageLoader.class.getSimpleName();
        QUERY_URI = MediaStore.Files.getContentUri((String)"external");
        PROJECTION_29 = new String[]{"_id", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "mime_type"};
        PROJECTION = new String[]{"_id", "_data", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "mime_type", "COUNT(*) AS count"};
        PROJECTION_PAGE = new String[]{"_id", "_data", "mime_type", "width", "height", "duration", "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added"};
    }

    public LocalMediaPageLoader(Context context) {
        this.mContext = context;
        this.config = PictureSelectionConfig.getInstance();
    }

    static /* synthetic */ String access$000(LocalMediaPageLoader localMediaPageLoader, long l) {
        return localMediaPageLoader.getPageSelection(l);
    }

    static /* synthetic */ String[] access$100(LocalMediaPageLoader localMediaPageLoader, long l) {
        return localMediaPageLoader.getPageSelectionArgs(l);
    }

    static /* synthetic */ String access$1000(LocalMediaPageLoader localMediaPageLoader) {
        return localMediaPageLoader.getSelection();
    }

    static /* synthetic */ String[] access$1100(LocalMediaPageLoader localMediaPageLoader) {
        return localMediaPageLoader.getSelectionArgs();
    }

    static /* synthetic */ void access$1200(LocalMediaPageLoader localMediaPageLoader, List list) {
        localMediaPageLoader.sortFolder(list);
    }

    static /* synthetic */ String access$1300(Cursor cursor) {
        return LocalMediaPageLoader.getFirstUri(cursor);
    }

    static /* synthetic */ String access$1400(Cursor cursor) {
        return LocalMediaPageLoader.getFirstUrl(cursor);
    }

    static /* synthetic */ String access$1500(Cursor cursor) {
        return LocalMediaPageLoader.getFirstCoverMimeType(cursor);
    }

    static /* synthetic */ Uri access$200() {
        return QUERY_URI;
    }

    static /* synthetic */ String[] access$300() {
        return PROJECTION_PAGE;
    }

    static /* synthetic */ Context access$400(LocalMediaPageLoader localMediaPageLoader) {
        return localMediaPageLoader.mContext;
    }

    static /* synthetic */ String access$500(long l) {
        return LocalMediaPageLoader.getRealPathAndroid_Q(l);
    }

    static /* synthetic */ PictureSelectionConfig access$600(LocalMediaPageLoader localMediaPageLoader) {
        return localMediaPageLoader.config;
    }

    static /* synthetic */ String access$700() {
        return TAG;
    }

    static /* synthetic */ String[] access$800() {
        return PROJECTION_29;
    }

    static /* synthetic */ String[] access$900() {
        return PROJECTION;
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

    private static String getFirstCoverMimeType(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("mime_type"));
    }

    private static String getFirstUri(Cursor cursor) {
        return LocalMediaPageLoader.getRealPathAndroid_Q(cursor.getLong(cursor.getColumnIndex("_id")));
    }

    private static String getFirstUrl(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("_data"));
    }

    public static LocalMediaPageLoader getInstance(Context context) {
        if (instance != null) return instance;
        synchronized (LocalMediaPageLoader.class) {
            LocalMediaPageLoader localMediaPageLoader;
            if (instance != null) return instance;
            instance = localMediaPageLoader = new LocalMediaPageLoader(context.getApplicationContext());
        }
        return instance;
    }

    private String getPageSelection(long l) {
        String string = this.getDurationCondition();
        String string2 = this.getFileSizeCondition();
        String string3 = this.getQueryMimeCondition();
        int n = this.config.chooseMode;
        if (n == 0) return LocalMediaPageLoader.getPageSelectionArgsForAllMediaCondition(l, string3, string, string2);
        if (n == 1) return LocalMediaPageLoader.getPageSelectionArgsForImageMediaCondition(l, string3, string2);
        if (n == 2) return LocalMediaPageLoader.getPageSelectionArgsForVideoOrAudioMediaCondition(l, string3, string, string2);
        if (n == 3) return LocalMediaPageLoader.getPageSelectionArgsForVideoOrAudioMediaCondition(l, string3, string, string2);
        return null;
    }

    private String[] getPageSelectionArgs(long l) {
        int n = this.config.chooseMode;
        if (n != 0) {
            if (n == 1) return LocalMediaPageLoader.getSelectionArgsForPageSingleMediaType(1, l);
            if (n == 2) return LocalMediaPageLoader.getSelectionArgsForPageSingleMediaType(3, l);
            if (n == 3) return LocalMediaPageLoader.getSelectionArgsForPageSingleMediaType(2, l);
            return null;
        }
        if (l != -1L) return new String[]{String.valueOf(1), String.valueOf(3), ValueOf.toString((Object)l)};
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String getPageSelectionArgsForAllMediaCondition(long l, String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append("media_type");
        stringBuilder.append("=?");
        stringBuilder.append(string);
        stringBuilder.append(" OR ");
        stringBuilder.append("media_type");
        stringBuilder.append("=? AND ");
        stringBuilder.append(string2);
        stringBuilder.append(") AND ");
        if (l == -1L) {
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
        stringBuilder.append(COLUMN_BUCKET_ID);
        stringBuilder.append("=? AND ");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private static String getPageSelectionArgsForImageMediaCondition(long l, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append("media_type");
        stringBuilder.append("=?");
        if (l == -1L) {
            stringBuilder.append(string);
            stringBuilder.append(") AND ");
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        stringBuilder.append(string);
        stringBuilder.append(") AND ");
        stringBuilder.append(COLUMN_BUCKET_ID);
        stringBuilder.append("=? AND ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static String getPageSelectionArgsForVideoOrAudioMediaCondition(long l, String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append("media_type");
        stringBuilder.append("=?");
        stringBuilder.append(string);
        stringBuilder.append(" AND ");
        stringBuilder.append(string2);
        stringBuilder.append(") AND ");
        if (l == -1L) {
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
        stringBuilder.append(COLUMN_BUCKET_ID);
        stringBuilder.append("=? AND ");
        stringBuilder.append(string3);
        return stringBuilder.toString();
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

    private static String getRealPathAndroid_Q(long l) {
        return QUERY_URI.buildUpon().appendPath(ValueOf.toString((Object)l)).build().toString();
    }

    private String getSelection() {
        String string = this.getFileSizeCondition();
        String string2 = this.getQueryMimeCondition();
        int n = this.config.chooseMode;
        if (n == 0) return LocalMediaPageLoader.getSelectionArgsForAllMediaCondition(this.getDurationCondition(), string, string2);
        if (n == 1) return LocalMediaPageLoader.getSelectionArgsForImageMediaCondition(string2, string);
        if (n == 2) return LocalMediaPageLoader.getSelectionArgsForVideoOrAudioMediaCondition(string2, string);
        if (n == 3) return LocalMediaPageLoader.getSelectionArgsForVideoOrAudioMediaCondition(string2, string);
        return null;
    }

    private String[] getSelectionArgs() {
        int n = this.config.chooseMode;
        if (n == 0) return LocalMediaPageLoader.getSelectionArgsForAllMediaType();
        if (n == 1) return LocalMediaPageLoader.getSelectionArgsForSingleMediaType(1);
        if (n == 2) return LocalMediaPageLoader.getSelectionArgsForSingleMediaType(3);
        if (n == 3) return LocalMediaPageLoader.getSelectionArgsForSingleMediaType(2);
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
        if (SdkVersionUtils.checkedAndroid_Q()) {
            return stringBuilder.toString();
        }
        stringBuilder.append(")");
        stringBuilder.append(GROUP_BY_BUCKET_Id);
        return stringBuilder.toString();
    }

    private static String[] getSelectionArgsForAllMediaType() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String getSelectionArgsForImageMediaCondition(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            stringBuilder.append("media_type");
            stringBuilder.append("=?");
            stringBuilder.append(string);
            stringBuilder.append(" AND ");
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        stringBuilder.append("(");
        stringBuilder.append("media_type");
        stringBuilder.append("=?");
        stringBuilder.append(string);
        stringBuilder.append(") AND ");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        stringBuilder.append(GROUP_BY_BUCKET_Id);
        return stringBuilder.toString();
    }

    private static String[] getSelectionArgsForPageSingleMediaType(int n, long l) {
        String[] stringArray = l == -1L ? new String[]{String.valueOf(n)} : new String[]{String.valueOf(n), ValueOf.toString((Object)l)};
        return stringArray;
    }

    private static String[] getSelectionArgsForSingleMediaType(int n) {
        return new String[]{String.valueOf(n)};
    }

    private static String getSelectionArgsForVideoOrAudioMediaCondition(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            stringBuilder.append("media_type");
            stringBuilder.append("=?");
            stringBuilder.append(string);
            stringBuilder.append(" AND ");
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        stringBuilder.append("(");
        stringBuilder.append("media_type");
        stringBuilder.append("=?");
        stringBuilder.append(string);
        stringBuilder.append(") AND ");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        stringBuilder.append(GROUP_BY_BUCKET_Id);
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

    public static void setInstanceNull() {
        instance = null;
    }

    private void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, _$.Lambda.LocalMediaPageLoader.emBWSexBuXWFQXco8EsphZe7J40.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    public String getFirstCover(long l) {
        void var5_11;
        ContentResolver contentResolver;
        block11: {
            block14: {
                block12: {
                    block10: {
                        block13: {
                            Object object;
                            contentResolver = null;
                            try {
                                boolean bl = SdkVersionUtils.checkedAndroid_R();
                                if (bl) {
                                    object = MediaUtils.createQueryArgsBundle((String)this.getPageSelection(l), (String[])this.getPageSelectionArgs(l), (int)1, (int)0);
                                    contentResolver = object = this.mContext.getContentResolver().query(QUERY_URI, new String[]{"_id", "_data"}, (Bundle)object, null);
                                } else {
                                    object = this.mContext.getContentResolver();
                                    Uri uri = QUERY_URI;
                                    String string = this.getPageSelection(l);
                                    String[] stringArray = this.getPageSelectionArgs(l);
                                    contentResolver = object = object.query(uri, new String[]{"_id", "_data"}, string, stringArray, "_id DESC limit 1 offset 0");
                                }
                                if (contentResolver == null) break block10;
                            }
                            catch (Throwable throwable) {
                                break block11;
                            }
                            catch (Exception exception) {
                                contentResolver = null;
                                break block12;
                            }
                            try {
                                if (contentResolver.getCount() <= 0) break block10;
                                if (!contentResolver.moveToFirst()) break block13;
                                l = contentResolver.getLong(contentResolver.getColumnIndexOrThrow("_id"));
                                object = SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.getRealPathAndroid_Q(l) : contentResolver.getString(contentResolver.getColumnIndexOrThrow("_data"));
                                if (contentResolver == null) return object;
                            }
                            catch (Throwable throwable) {
                                break block11;
                            }
                            catch (Exception exception) {
                                break block12;
                            }
                            if (contentResolver.isClosed()) return object;
                            contentResolver.close();
                            return object;
                        }
                        if (contentResolver == null) return null;
                        if (contentResolver.isClosed()) return null;
                        contentResolver.close();
                        return null;
                    }
                    if (contentResolver == null) return null;
                    if (contentResolver.isClosed()) return null;
                    contentResolver.close();
                    break block14;
                }
                try {
                    void var5_9;
                    var5_9.printStackTrace();
                    if (contentResolver == null) return null;
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block11;
                }
                if (contentResolver.isClosed()) return null;
                contentResolver.close();
            }
            return null;
        }
        if (contentResolver == null) throw var5_11;
        if (contentResolver.isClosed()) throw var5_11;
        contentResolver.close();
        throw var5_11;
    }

    public void loadAllMedia(OnQueryDataResultListener<LocalMediaFolder> onQueryDataResultListener) {
        PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void loadPageMediaData(long l, int n, int n2, int n3, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void loadPageMediaData(long l, int n, int n2, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        this.loadPageMediaData(l, n, n2, this.config.pageSize, onQueryDataResultListener);
    }

    public void loadPageMediaData(long l, int n, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        this.loadPageMediaData(l, n, this.config.pageSize, this.config.pageSize, onQueryDataResultListener);
    }
}
