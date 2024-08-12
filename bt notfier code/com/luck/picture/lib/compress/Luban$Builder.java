/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.luck.picture.lib.compress.CompressionPredicate
 *  com.luck.picture.lib.compress.InputStreamProvider
 *  com.luck.picture.lib.compress.Luban
 *  com.luck.picture.lib.compress.OnCompressListener
 *  com.luck.picture.lib.compress.OnRenameListener
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import android.content.Context;
import android.net.Uri;
import com.luck.picture.lib.compress.CompressionPredicate;
import com.luck.picture.lib.compress.InputStreamProvider;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.compress.OnRenameListener;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Luban.Builder {
    private int compressQuality;
    private final Context context;
    private int dataCount;
    private boolean focusAlpha;
    private boolean isAutoRotating;
    private boolean isCamera;
    private OnCompressListener mCompressListener;
    private CompressionPredicate mCompressionPredicate;
    private int mLeastCompressSize = 100;
    private String mNewFileName;
    private final List<String> mPaths;
    private OnRenameListener mRenameListener;
    private final List<InputStreamProvider> mStreamProviders;
    private String mTargetDir;
    private List<LocalMedia> mediaList;

    Luban.Builder(Context context) {
        this.context = context;
        this.mPaths = new ArrayList<String>();
        this.mediaList = new ArrayList<LocalMedia>();
        this.mStreamProviders = new ArrayList<InputStreamProvider>();
    }

    static /* synthetic */ List access$000(Luban.Builder builder) {
        return builder.mPaths;
    }

    static /* synthetic */ List access$100(Luban.Builder builder) {
        return builder.mediaList;
    }

    static /* synthetic */ int access$1000(Luban.Builder builder) {
        return builder.compressQuality;
    }

    static /* synthetic */ boolean access$1100(Luban.Builder builder) {
        return builder.isAutoRotating;
    }

    static /* synthetic */ boolean access$1200(Luban.Builder builder) {
        return builder.focusAlpha;
    }

    static /* synthetic */ boolean access$1300(Luban.Builder builder) {
        return builder.isCamera;
    }

    static /* synthetic */ Context access$1900(Luban.Builder builder) {
        return builder.context;
    }

    static /* synthetic */ int access$200(Luban.Builder builder) {
        return builder.dataCount;
    }

    static /* synthetic */ String access$300(Luban.Builder builder) {
        return builder.mTargetDir;
    }

    static /* synthetic */ String access$400(Luban.Builder builder) {
        return builder.mNewFileName;
    }

    static /* synthetic */ OnRenameListener access$500(Luban.Builder builder) {
        return builder.mRenameListener;
    }

    static /* synthetic */ List access$600(Luban.Builder builder) {
        return builder.mStreamProviders;
    }

    static /* synthetic */ OnCompressListener access$700(Luban.Builder builder) {
        return builder.mCompressListener;
    }

    static /* synthetic */ int access$800(Luban.Builder builder) {
        return builder.mLeastCompressSize;
    }

    static /* synthetic */ CompressionPredicate access$900(Luban.Builder builder) {
        return builder.mCompressionPredicate;
    }

    private Luban build() {
        return new Luban(this, null);
    }

    private Luban.Builder load(LocalMedia localMedia) {
        this.mStreamProviders.add((InputStreamProvider)new /* Unavailable Anonymous Inner Class!! */);
        return this;
    }

    public Luban.Builder filter(CompressionPredicate compressionPredicate) {
        this.mCompressionPredicate = compressionPredicate;
        return this;
    }

    public File get(String string) throws IOException {
        return Luban.access$2100((Luban)this.build(), (InputStreamProvider)new /* Unavailable Anonymous Inner Class!! */, (Context)this.context);
    }

    public List<File> get() throws Exception {
        return Luban.access$2200((Luban)this.build(), (Context)this.context);
    }

    public Luban.Builder ignoreBy(int n) {
        this.mLeastCompressSize = n;
        return this;
    }

    public Luban.Builder isAutoRotating(boolean bl) {
        this.isAutoRotating = bl;
        return this;
    }

    public Luban.Builder isCamera(boolean bl) {
        this.isCamera = bl;
        return this;
    }

    public void launch() {
        Luban.access$2000((Luban)this.build(), (Context)this.context);
    }

    public Luban.Builder load(Uri uri) {
        this.mStreamProviders.add((InputStreamProvider)new /* Unavailable Anonymous Inner Class!! */);
        return this;
    }

    public Luban.Builder load(InputStreamProvider inputStreamProvider) {
        this.mStreamProviders.add(inputStreamProvider);
        return this;
    }

    public Luban.Builder load(File file) {
        this.mStreamProviders.add((InputStreamProvider)new /* Unavailable Anonymous Inner Class!! */);
        return this;
    }

    public Luban.Builder load(String string) {
        this.mStreamProviders.add((InputStreamProvider)new /* Unavailable Anonymous Inner Class!! */);
        return this;
    }

    public <T> Luban.Builder load(List<T> list) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            list = iterator.next();
            if (list instanceof String) {
                this.load((String)((Object)list));
                continue;
            }
            if (list instanceof File) {
                this.load((File)((Object)list));
                continue;
            }
            if (!(list instanceof Uri)) throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
            this.load((Uri)list);
        }
        return this;
    }

    public <T> Luban.Builder loadMediaData(List<LocalMedia> object) {
        this.mediaList = object;
        this.dataCount = object.size();
        object = object.iterator();
        while (object.hasNext()) {
            this.load((LocalMedia)object.next());
        }
        return this;
    }

    public Luban.Builder putGear(int n) {
        return this;
    }

    public Luban.Builder setCompressListener(OnCompressListener onCompressListener) {
        this.mCompressListener = onCompressListener;
        return this;
    }

    public Luban.Builder setCompressQuality(int n) {
        this.compressQuality = n;
        return this;
    }

    public Luban.Builder setFocusAlpha(boolean bl) {
        this.focusAlpha = bl;
        return this;
    }

    public Luban.Builder setNewCompressFileName(String string) {
        this.mNewFileName = string;
        return this;
    }

    @Deprecated
    public Luban.Builder setRenameListener(OnRenameListener onRenameListener) {
        this.mRenameListener = onRenameListener;
        return this;
    }

    public Luban.Builder setTargetDir(String string) {
        this.mTargetDir = string;
        return this;
    }
}
