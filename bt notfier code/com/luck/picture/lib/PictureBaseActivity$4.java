/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.PictureSelector
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 *  com.luck.picture.lib.tools.AndroidQTransformUtils
 */
package com.luck.picture.lib;

import android.content.Context;
import android.text.TextUtils;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import java.util.List;

class PictureBaseActivity.4
extends PictureThreadUtils.SimpleTask<List<LocalMedia>> {
    final PictureBaseActivity this$0;
    final List val$images;

    PictureBaseActivity.4(PictureBaseActivity pictureBaseActivity, List list) {
        this.this$0 = pictureBaseActivity;
        this.val$images = list;
    }

    public List<LocalMedia> doInBackground() {
        int n = this.val$images.size();
        int n2 = 0;
        while (n2 < n) {
            block5: {
                boolean bl;
                LocalMedia localMedia;
                block8: {
                    block7: {
                        block6: {
                            localMedia = (LocalMedia)this.val$images.get(n2);
                            if (localMedia == null || TextUtils.isEmpty((CharSequence)localMedia.getPath())) break block5;
                            bl = !localMedia.isCut() && !localMedia.isCompressed() && TextUtils.isEmpty((CharSequence)localMedia.getAndroidQToPath());
                            if (!bl || !PictureMimeType.isContent((String)localMedia.getPath())) break block6;
                            if (PictureMimeType.isHasHttp((String)localMedia.getPath())) break block7;
                            localMedia.setAndroidQToPath(AndroidQTransformUtils.copyPathToAndroidQ((Context)this.this$0.getContext(), (long)localMedia.getId(), (String)localMedia.getPath(), (int)localMedia.getWidth(), (int)localMedia.getHeight(), (String)localMedia.getMimeType(), (String)this.this$0.config.cameraFileName));
                            bl = true;
                            break block8;
                        }
                        if (localMedia.isCut() && localMedia.isCompressed()) {
                            localMedia.setAndroidQToPath(localMedia.getCompressPath());
                        }
                    }
                    bl = false;
                }
                if (this.this$0.config.isCheckOriginalImage) {
                    localMedia.setOriginal(true);
                    if (bl) {
                        localMedia.setOriginalPath(localMedia.getAndroidQToPath());
                    } else {
                        localMedia.setOriginalPath(AndroidQTransformUtils.copyPathToAndroidQ((Context)this.this$0.getContext(), (long)localMedia.getId(), (String)localMedia.getPath(), (int)localMedia.getWidth(), (int)localMedia.getHeight(), (String)localMedia.getMimeType(), (String)this.this$0.config.cameraFileName));
                    }
                }
            }
            ++n2;
        }
        return this.val$images;
    }

    public void onSuccess(List<LocalMedia> intent) {
        this.this$0.dismissDialog();
        if (intent == null) return;
        if (this.this$0.config.camera && this.this$0.config.selectionMode == 2) {
            int n = intent.size() > 0 ? intent.size() - 1 : 0;
            intent.addAll(n, this.this$0.selectionMedias);
        }
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onResult(intent);
        } else {
            intent = PictureSelector.putIntentResult(intent);
            this.this$0.setResult(-1, intent);
        }
        this.this$0.exit();
    }
}
