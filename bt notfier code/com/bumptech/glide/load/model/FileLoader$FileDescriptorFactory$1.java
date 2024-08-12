/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.model.FileLoader$FileOpener
 */
package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.FileLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileLoader.FileDescriptorFactory.1
implements FileLoader.FileOpener<ParcelFileDescriptor> {
    FileLoader.FileDescriptorFactory.1() {
    }

    public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }

    public ParcelFileDescriptor open(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open((File)file, (int)0x10000000);
    }
}
