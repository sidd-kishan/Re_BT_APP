/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.luck.picture.lib.compress.InputStreamProvider
 *  com.luck.picture.lib.compress.Luban
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 *  com.luck.picture.lib.tools.SdkVersionUtils
 */
package com.luck.picture.lib.compress;

import android.content.Context;
import android.text.TextUtils;
import com.luck.picture.lib.compress.InputStreamProvider;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class Luban.1
extends PictureThreadUtils.SimpleTask<List<LocalMedia>> {
    final Luban this$0;
    final Context val$context;
    final Iterator val$iterator;

    Luban.1(Luban luban, Iterator iterator, Context context) {
        this.this$0 = luban;
        this.val$iterator = iterator;
        this.val$context = context;
    }

    public List<LocalMedia> doInBackground() {
        Luban.access$1402((Luban)this.this$0, (int)-1);
        while (true) {
            boolean bl = this.val$iterator.hasNext();
            Object var7_8 = null;
            if (!bl) return null;
            try {
                boolean bl2;
                Object object;
                Luban.access$1408((Luban)this.this$0);
                InputStreamProvider inputStreamProvider = (InputStreamProvider)this.val$iterator.next();
                bl = inputStreamProvider.getMedia().isCompressed();
                boolean bl3 = false;
                if (bl && !TextUtils.isEmpty((CharSequence)inputStreamProvider.getMedia().getCompressPath())) {
                    bl2 = !inputStreamProvider.getMedia().isCut() && ((File)(object = new File(inputStreamProvider.getMedia().getCompressPath()))).exists();
                    object = bl2 ? new File(inputStreamProvider.getMedia().getCompressPath()) : Luban.access$1500((Luban)this.this$0, (Context)this.val$context, (InputStreamProvider)inputStreamProvider);
                    object = ((File)object).getAbsolutePath();
                } else if (PictureMimeType.isHasHttp((String)inputStreamProvider.getMedia().getPath()) && TextUtils.isEmpty((CharSequence)inputStreamProvider.getMedia().getCutPath())) {
                    object = inputStreamProvider.getMedia().getPath();
                } else {
                    object = PictureMimeType.isHasVideo((String)inputStreamProvider.getMedia().getMimeType()) ? new File(inputStreamProvider.getPath()) : Luban.access$1500((Luban)this.this$0, (Context)this.val$context, (InputStreamProvider)inputStreamProvider);
                    object = ((File)object).getAbsolutePath();
                }
                if (Luban.access$1600((Luban)this.this$0) != null && Luban.access$1600((Luban)this.this$0).size() > 0) {
                    inputStreamProvider = (LocalMedia)Luban.access$1600((Luban)this.this$0).get(Luban.access$1400((Luban)this.this$0));
                    boolean bl4 = PictureMimeType.isHasHttp((String)object);
                    boolean bl5 = PictureMimeType.isHasVideo((String)inputStreamProvider.getMimeType());
                    bl = !bl4 && !bl5;
                    inputStreamProvider.setCompressed(bl);
                    if (bl4 || bl5) {
                        object = null;
                    }
                    inputStreamProvider.setCompressPath((String)object);
                    object = var7_8;
                    if (SdkVersionUtils.checkedAndroid_Q()) {
                        object = inputStreamProvider.getCompressPath();
                    }
                    inputStreamProvider.setAndroidQToPath((String)object);
                    bl2 = bl3;
                    if (Luban.access$1400((Luban)this.this$0) == Luban.access$1600((Luban)this.this$0).size() - 1) {
                        bl2 = true;
                    }
                    if (bl2) {
                        object = Luban.access$1600((Luban)this.this$0);
                        return object;
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.val$iterator.remove();
        }
    }

    public void onSuccess(List<LocalMedia> list) {
        if (Luban.access$1700((Luban)this.this$0) == null) {
            return;
        }
        if (list != null) {
            Luban.access$1700((Luban)this.this$0).onSuccess(list);
        } else {
            Luban.access$1700((Luban)this.this$0).onError(new Throwable("Failed to compress file"));
        }
    }
}
