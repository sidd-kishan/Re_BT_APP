/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.data.AssetPathFetcher
 */
package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.AssetPathFetcher;
import java.io.IOException;

public class FileDescriptorAssetPathFetcher
extends AssetPathFetcher<ParcelFileDescriptor> {
    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String string) {
        super(assetManager, string);
    }

    protected void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }

    protected ParcelFileDescriptor loadResource(AssetManager assetManager, String string) throws IOException {
        return assetManager.openFd(string).getParcelFileDescriptor();
    }
}
