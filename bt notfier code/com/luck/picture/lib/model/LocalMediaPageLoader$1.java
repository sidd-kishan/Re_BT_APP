/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.MediaData
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 *  com.luck.picture.lib.model.LocalMediaPageLoader
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 */
package com.luck.picture.lib.model;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaData;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
class LocalMediaPageLoader.1
extends PictureThreadUtils.SimpleTask<MediaData> {
    final LocalMediaPageLoader this$0;
    final long val$bucketId;
    final int val$limit;
    final OnQueryDataResultListener val$listener;
    final int val$page;
    final int val$pageSize;

    LocalMediaPageLoader.1(LocalMediaPageLoader localMediaPageLoader, long l, int n, int n2, int n3, OnQueryDataResultListener onQueryDataResultListener) {
        this.this$0 = localMediaPageLoader;
        this.val$bucketId = l;
        this.val$limit = n;
        this.val$page = n2;
        this.val$pageSize = n3;
        this.val$listener = onQueryDataResultListener;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public MediaData doInBackground() {
        void var23_86;
        void var24_80;
        block25: {
            CharSequence charSequence;
            block26: {
                MediaData mediaData;
                int n;
                boolean bl;
                block24: {
                    block23: {
                        Object var24_1 = null;
                        bl = SdkVersionUtils.checkedAndroid_R();
                        if (!bl) break block23;
                        try {
                            charSequence = MediaUtils.createQueryArgsBundle((String)LocalMediaPageLoader.access$000((LocalMediaPageLoader)this.this$0, (long)this.val$bucketId), (String[])LocalMediaPageLoader.access$100((LocalMediaPageLoader)this.this$0, (long)this.val$bucketId), (int)this.val$limit, (int)((this.val$page - 1) * this.val$pageSize));
                            charSequence = LocalMediaPageLoader.access$400((LocalMediaPageLoader)this.this$0).getContentResolver().query(LocalMediaPageLoader.access$200(), LocalMediaPageLoader.access$300(), (Bundle)charSequence, null);
                            break block24;
                        }
                        catch (Throwable throwable) {
                            break block25;
                        }
                        catch (Exception exception) {
                            charSequence = null;
                            break block26;
                        }
                    }
                    n = this.val$page;
                    if (n == -1) {
                        charSequence = "_id DESC";
                    } else {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("_id DESC limit ");
                        ((StringBuilder)charSequence).append(this.val$limit);
                        ((StringBuilder)charSequence).append(" offset ");
                        ((StringBuilder)charSequence).append((this.val$page - 1) * this.val$pageSize);
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                    charSequence = LocalMediaPageLoader.access$400((LocalMediaPageLoader)this.this$0).getContentResolver().query(LocalMediaPageLoader.access$200(), LocalMediaPageLoader.access$300(), LocalMediaPageLoader.access$000((LocalMediaPageLoader)this.this$0, (long)this.val$bucketId), LocalMediaPageLoader.access$100((LocalMediaPageLoader)this.this$0, (long)this.val$bucketId), (String)charSequence);
                }
                if (charSequence == null) {
                    if (charSequence == null) return null;
                    if (charSequence.isClosed()) return null;
                    charSequence.close();
                    return null;
                }
                CharSequence charSequence2 = charSequence;
                try {
                    ArrayList<LocalMedia> arrayList;
                    block27: {
                        CharSequence charSequence3 = charSequence;
                        arrayList = new ArrayList<LocalMedia>();
                        CharSequence charSequence4 = charSequence;
                        if (charSequence.getCount() <= 0) break block27;
                        CharSequence charSequence5 = charSequence;
                        int n2 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[0]);
                        CharSequence charSequence6 = charSequence;
                        int n3 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[1]);
                        CharSequence charSequence7 = charSequence;
                        n = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[2]);
                        CharSequence charSequence8 = charSequence;
                        int n4 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[3]);
                        CharSequence charSequence9 = charSequence;
                        int n5 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[4]);
                        CharSequence charSequence10 = charSequence;
                        int n6 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[5]);
                        CharSequence charSequence11 = charSequence;
                        int n7 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[6]);
                        CharSequence charSequence12 = charSequence;
                        int n8 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[7]);
                        CharSequence charSequence13 = charSequence;
                        int n9 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[8]);
                        CharSequence charSequence14 = charSequence;
                        int n10 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[9]);
                        CharSequence charSequence15 = charSequence;
                        int n11 = charSequence.getColumnIndexOrThrow(LocalMediaPageLoader.access$300()[10]);
                        CharSequence charSequence16 = charSequence;
                        charSequence.moveToFirst();
                        do {
                            block29: {
                                long l;
                                String string;
                                String string2;
                                long l2;
                                long l3;
                                int n12;
                                int n13;
                                String string3;
                                String string4;
                                String string5;
                                long l4;
                                block35: {
                                    block37: {
                                        block36: {
                                            block34: {
                                                block33: {
                                                    block32: {
                                                        block31: {
                                                            void var25_91;
                                                            block30: {
                                                                void var25_94;
                                                                block28: {
                                                                    CharSequence charSequence17 = charSequence;
                                                                    l4 = charSequence.getLong(n2);
                                                                    CharSequence charSequence18 = charSequence;
                                                                    string5 = charSequence.getString(n3);
                                                                    CharSequence charSequence19 = charSequence;
                                                                    if (SdkVersionUtils.checkedAndroid_Q()) {
                                                                        CharSequence charSequence20 = charSequence;
                                                                        string4 = LocalMediaPageLoader.access$500((long)l4);
                                                                    } else {
                                                                        string4 = string5;
                                                                    }
                                                                    CharSequence charSequence21 = charSequence;
                                                                    if (!LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).isFilterInvalidFile) break block28;
                                                                    CharSequence charSequence22 = charSequence;
                                                                    if (!PictureFileUtils.isFileExists((String)string5)) break block29;
                                                                }
                                                                CharSequence charSequence23 = charSequence;
                                                                String string6 = string3 = charSequence.getString(n);
                                                                CharSequence charSequence24 = charSequence;
                                                                if (TextUtils.isEmpty((CharSequence)string3)) {
                                                                    CharSequence charSequence25 = charSequence;
                                                                    String string7 = PictureMimeType.ofJPEG();
                                                                }
                                                                CharSequence charSequence26 = charSequence;
                                                                if (!var25_91.endsWith("image/*")) break block30;
                                                                CharSequence charSequence27 = charSequence;
                                                                if (PictureMimeType.isContent((String)string4)) {
                                                                    CharSequence charSequence28 = charSequence;
                                                                    String string8 = PictureMimeType.getImageMimeType((String)string5);
                                                                } else {
                                                                    CharSequence charSequence29 = charSequence;
                                                                    String string9 = PictureMimeType.getImageMimeType((String)string4);
                                                                }
                                                                string3 = var25_94;
                                                                CharSequence charSequence30 = charSequence;
                                                                if (LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).isGif) break block31;
                                                                string3 = var25_94;
                                                                CharSequence charSequence31 = charSequence;
                                                                if (!PictureMimeType.isGif((String)var25_94)) break block31;
                                                                break block29;
                                                            }
                                                            string3 = var25_91;
                                                        }
                                                        CharSequence charSequence32 = charSequence;
                                                        if (LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).isWebp) break block32;
                                                        CharSequence charSequence33 = charSequence;
                                                        if (string3.startsWith(PictureMimeType.ofWEBP())) break block29;
                                                    }
                                                    CharSequence charSequence34 = charSequence;
                                                    if (LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).isBmp) break block33;
                                                    CharSequence charSequence35 = charSequence;
                                                    if (string3.startsWith(PictureMimeType.ofBMP())) break block29;
                                                }
                                                CharSequence charSequence36 = charSequence;
                                                n13 = charSequence.getInt(n4);
                                                CharSequence charSequence37 = charSequence;
                                                n12 = charSequence.getInt(n5);
                                                CharSequence charSequence38 = charSequence;
                                                l3 = charSequence.getLong(n6);
                                                CharSequence charSequence39 = charSequence;
                                                l2 = charSequence.getLong(n7);
                                                CharSequence charSequence40 = charSequence;
                                                string2 = charSequence.getString(n8);
                                                CharSequence charSequence41 = charSequence;
                                                string = charSequence.getString(n9);
                                                CharSequence charSequence42 = charSequence;
                                                l = charSequence.getLong(n10);
                                                CharSequence charSequence43 = charSequence;
                                                if (!(LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).filterFileSize > 0.0f)) break block34;
                                                CharSequence charSequence44 = charSequence;
                                                if ((float)l2 > LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).filterFileSize * 1048576.0f) break block29;
                                            }
                                            CharSequence charSequence45 = charSequence;
                                            if (!PictureMimeType.isHasVideo((String)string3)) break block35;
                                            CharSequence charSequence46 = charSequence;
                                            if (LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).videoMinSecond <= 0) break block36;
                                            CharSequence charSequence47 = charSequence;
                                            if (l3 < (long)LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).videoMinSecond) break block29;
                                        }
                                        CharSequence charSequence48 = charSequence;
                                        if (LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).videoMaxSecond <= 0) break block37;
                                        CharSequence charSequence49 = charSequence;
                                        if (l3 > (long)LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).videoMaxSecond) break block29;
                                    }
                                    if (l3 == 0L || l2 <= 0L) break block29;
                                }
                                CharSequence charSequence51 = charSequence;
                                charSequence51 = charSequence;
                                LocalMedia localMedia = new LocalMedia(l4, string4, string5, string, string2, l3, LocalMediaPageLoader.access$600((LocalMediaPageLoader)this.this$0).chooseMode, string3, n13, n12, l2, l, charSequence.getLong(n11));
                                CharSequence charSequence52 = charSequence;
                                arrayList.add(localMedia);
                            }
                            CharSequence charSequence53 = charSequence;
                        } while (charSequence.moveToNext());
                    }
                    CharSequence charSequence54 = charSequence;
                    bl = charSequence.getCount() > 0;
                    CharSequence charSequence55 = charSequence;
                    mediaData = new MediaData(bl, arrayList);
                    if (charSequence == null) return mediaData;
                }
                catch (Exception exception) {
                    break block26;
                }
                if (charSequence.isClosed()) return mediaData;
                charSequence.close();
                return mediaData;
                catch (Throwable throwable) {
                    Object var24_70 = null;
                    break block25;
                }
                catch (Exception exception) {
                    charSequence = null;
                }
            }
            String string = charSequence;
            try {
                void var25_100;
                var25_100.printStackTrace();
                String string10 = charSequence;
                String string11 = LocalMediaPageLoader.access$700();
                CharSequence charSequence57 = charSequence;
                charSequence57 = charSequence;
                StringBuilder stringBuilder = new StringBuilder();
                CharSequence charSequence58 = charSequence;
                stringBuilder.append("loadMedia Page Data Error: ");
                CharSequence charSequence59 = charSequence;
                stringBuilder.append(var25_100.getMessage());
                CharSequence charSequence60 = charSequence;
                Log.i((String)string11, (String)stringBuilder.toString());
                if (charSequence == null) return null;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            if (charSequence.isClosed()) return null;
            charSequence.close();
            return null;
        }
        if (var24_80 == null) throw var23_86;
        if (var24_80.isClosed()) throw var23_86;
        var24_80.close();
        throw var23_86;
    }

    public void onSuccess(MediaData mediaData) {
        OnQueryDataResultListener onQueryDataResultListener = this.val$listener;
        if (onQueryDataResultListener == null) return;
        if (mediaData == null) return;
        onQueryDataResultListener.onComplete(mediaData.data, this.val$page, mediaData.isHasNextMore);
    }
}
