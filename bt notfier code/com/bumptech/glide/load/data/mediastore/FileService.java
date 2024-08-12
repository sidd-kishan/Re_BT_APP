/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.data.mediastore;

import java.io.File;

class FileService {
    FileService() {
    }

    public boolean exists(File file) {
        return file.exists();
    }

    public File get(String string) {
        return new File(string);
    }

    public long length(File file) {
        return file.length();
    }
}
