/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.compress.InputStreamAdapter
 *  com.luck.picture.lib.compress.Luban$Builder
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import com.luck.picture.lib.compress.InputStreamAdapter;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class Luban.Builder.3
extends InputStreamAdapter {
    final Luban.Builder this$0;
    final File val$file;

    Luban.Builder.3(Luban.Builder builder, File file) {
        this.this$0 = builder;
        this.val$file = file;
    }

    public LocalMedia getMedia() {
        return null;
    }

    public String getPath() {
        return this.val$file.getAbsolutePath();
    }

    public InputStream openInternal() throws IOException {
        return new FileInputStream(this.val$file);
    }
}
