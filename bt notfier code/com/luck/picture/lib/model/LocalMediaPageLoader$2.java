/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.net.Uri
 *  android.util.Log
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 *  com.luck.picture.lib.model.LocalMediaPageLoader
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.model;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class LocalMediaPageLoader.2
extends PictureThreadUtils.SimpleTask<List<LocalMediaFolder>> {
    final LocalMediaPageLoader this$0;
    final OnQueryDataResultListener val$listener;

    LocalMediaPageLoader.2(LocalMediaPageLoader localMediaPageLoader, OnQueryDataResultListener onQueryDataResultListener) {
        this.this$0 = localMediaPageLoader;
        this.val$listener = onQueryDataResultListener;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public List<LocalMediaFolder> doInBackground() {
        Uri uri;
        block15: {
            Object object = LocalMediaPageLoader.access$400((LocalMediaPageLoader)this.this$0).getContentResolver();
            uri = LocalMediaPageLoader.access$200();
            Object object2 = SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.access$800() : LocalMediaPageLoader.access$900();
            if ((uri = object.query(uri, (String[])object2, LocalMediaPageLoader.access$1000((LocalMediaPageLoader)this.this$0), LocalMediaPageLoader.access$1100((LocalMediaPageLoader)this.this$0), "_id DESC")) != null) {
                Throwable throwable2222222;
                Object object3;
                int n = uri.getCount();
                object = new ArrayList();
                if (n <= 0) break block15;
                boolean bl = SdkVersionUtils.checkedAndroid_Q();
                if (!bl) {
                    int n2;
                    uri.moveToFirst();
                    n = 0;
                    do {
                        object2 = new LocalMediaFolder();
                        long l = uri.getLong(uri.getColumnIndex("bucket_id"));
                        object3 = uri.getString(uri.getColumnIndex("bucket_display_name"));
                        String string2 = uri.getString(uri.getColumnIndex("mime_type"));
                        n2 = uri.getInt(uri.getColumnIndex("count"));
                        object2.setBucketId(l);
                        object2.setFirstImagePath(uri.getString(uri.getColumnIndex("_data")));
                        object2.setName((String)object3);
                        object2.setFirstMimeType(string2);
                        object2.setImageNum(n2);
                        object.add(object2);
                        n = n2 = n + n2;
                    } while (uri.moveToNext());
                    n = n2;
                } else {
                    long l;
                    object3 = new HashMap();
                    while (uri.moveToNext()) {
                        l = uri.getLong(uri.getColumnIndex("bucket_id"));
                        object2 = (Long)object3.get(l);
                        object2 = object2 == null ? Long.valueOf(1L) : Long.valueOf((Long)object2 + 1L);
                        object3.put(l, object2);
                    }
                    if (!uri.moveToFirst()) {
                        n = 0;
                    } else {
                        HashSet<Long> hashSet = new HashSet<Long>();
                        int n3 = 0;
                        do {
                            long l2;
                            if (hashSet.contains(l2 = uri.getLong(uri.getColumnIndex("bucket_id")))) {
                                n = n3;
                            } else {
                                object2 = new LocalMediaFolder();
                                object2.setBucketId(l2);
                                String string3 = uri.getString(uri.getColumnIndex("bucket_display_name"));
                                String string4 = uri.getString(uri.getColumnIndex("mime_type"));
                                l = (Long)object3.get(l2);
                                long l3 = uri.getLong(uri.getColumnIndex("_id"));
                                object2.setName(string3);
                                object2.setImageNum(ValueOf.toInt((Object)l));
                                object2.setFirstImagePath(LocalMediaPageLoader.access$500((long)l3));
                                object2.setFirstMimeType(string4);
                                object.add(object2);
                                hashSet.add(l2);
                                n = (int)((long)n3 + l);
                            }
                            n3 = n;
                        } while (uri.moveToNext());
                    }
                }
                LocalMediaPageLoader.access$1200((LocalMediaPageLoader)this.this$0, (List)object);
                object3 = new LocalMediaFolder();
                object3.setImageNum(n);
                object3.setChecked(true);
                object3.setBucketId(-1L);
                if (uri.moveToFirst()) {
                    object2 = SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.access$1300((Cursor)uri) : LocalMediaPageLoader.access$1400((Cursor)uri);
                    object3.setFirstImagePath((String)object2);
                    object3.setFirstMimeType(LocalMediaPageLoader.access$1500((Cursor)uri));
                }
                object2 = LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).chooseMode == PictureMimeType.ofAudio() ? LocalMediaPageLoader.access$400((LocalMediaPageLoader)this.this$0).getString(R.string.picture_all_audio) : LocalMediaPageLoader.access$400((LocalMediaPageLoader)this.this$0).getString(R.string.picture_camera_roll);
                object3.setName((String)object2);
                object3.setOfAllType(LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).chooseMode);
                object3.setCameraFolder(true);
                object.add(0, object3);
                if (uri == null) return object;
                if (uri.isClosed()) return object;
                uri.close();
                return object;
                {
                    catch (Throwable throwable2222222) {
                    }
                    catch (Exception exception) {}
                    {
                        exception.printStackTrace();
                        String string5 = LocalMediaPageLoader.access$700();
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("loadAllMedia Data Error: ");
                        ((StringBuilder)object2).append(exception.getMessage());
                        Log.i((String)string5, (String)((StringBuilder)object2).toString());
                        if (uri == null) return null;
                    }
                    if (uri.isClosed()) return null;
                    uri.close();
                    return null;
                }
                if (uri == null) throw throwable2222222;
                if (uri.isClosed()) throw throwable2222222;
                uri.close();
                throw throwable2222222;
            }
        }
        if (uri == null) return new ArrayList<LocalMediaFolder>();
        if (uri.isClosed()) return new ArrayList<LocalMediaFolder>();
        uri.close();
        return new ArrayList<LocalMediaFolder>();
    }

    public void onSuccess(List<LocalMediaFolder> list) {
        OnQueryDataResultListener onQueryDataResultListener = this.val$listener;
        if (onQueryDataResultListener == null) return;
        if (list == null) return;
        onQueryDataResultListener.onComplete(list, 1, false);
    }
}
