/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.luck.picture.lib.compress.InputStreamAdapter
 *  com.luck.picture.lib.compress.Luban$Builder
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import android.net.Uri;
import com.luck.picture.lib.compress.InputStreamAdapter;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.IOException;
import java.io.InputStream;

/*
 * Exception performing whole class analysis ignored.
 */
class Luban.Builder.2
extends InputStreamAdapter {
    final Luban.Builder this$0;
    final Uri val$uri;

    Luban.Builder.2(Luban.Builder builder, Uri uri) {
        this.this$0 = builder;
        this.val$uri = uri;
    }

    public LocalMedia getMedia() {
        return null;
    }

    public String getPath() {
        return this.val$uri.getPath();
    }

    public InputStream openInternal() throws IOException {
        return Luban.Builder.access$1900((Luban.Builder)this.this$0).getContentResolver().openInputStream(this.val$uri);
    }
}
