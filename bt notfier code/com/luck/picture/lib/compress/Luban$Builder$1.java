/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.luck.picture.lib.compress.InputStreamAdapter
 *  com.luck.picture.lib.compress.Luban$Builder
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.compress.InputStreamAdapter;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Exception performing whole class analysis ignored.
 */
class Luban.Builder.1
extends InputStreamAdapter {
    final Luban.Builder this$0;
    final LocalMedia val$media;

    Luban.Builder.1(Luban.Builder builder, LocalMedia localMedia) {
        this.this$0 = builder;
        this.val$media = localMedia;
    }

    public LocalMedia getMedia() {
        return this.val$media;
    }

    public String getPath() {
        if (this.val$media.isCut()) {
            return this.val$media.getCutPath();
        }
        String string = TextUtils.isEmpty((CharSequence)this.val$media.getAndroidQToPath()) ? this.val$media.getPath() : this.val$media.getAndroidQToPath();
        return string;
    }

    public InputStream openInternal() throws IOException {
        if (PictureMimeType.isContent((String)this.val$media.getPath()) && !this.val$media.isCut()) {
            if (!TextUtils.isEmpty((CharSequence)this.val$media.getAndroidQToPath())) return new FileInputStream(this.val$media.getAndroidQToPath());
            return Luban.Builder.access$1900((Luban.Builder)this.this$0).getContentResolver().openInputStream(Uri.parse((String)this.val$media.getPath()));
        }
        if (PictureMimeType.isHasHttp((String)this.val$media.getPath()) && TextUtils.isEmpty((CharSequence)this.val$media.getCutPath())) {
            return null;
        }
        String string = this.val$media.isCut() ? this.val$media.getCutPath() : this.val$media.getPath();
        return new FileInputStream(string);
    }
}
