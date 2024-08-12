/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.google.android.gms.common.images.ImageManager$OnImageLoadedListener
 *  com.google.android.gms.common.images.zag
 *  com.google.android.gms.common.internal.Asserts
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zaf
extends zag {
    private final WeakReference<ImageManager.OnImageLoadedListener> zac;

    public zaf(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull((Object)onImageLoadedListener);
        this.zac = new WeakReference<ImageManager.OnImageLoadedListener>(onImageLoadedListener);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zaf)) {
            return false;
        }
        object = (zaf)((Object)object);
        ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zac.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((zaf)((Object)object)).zac.get();
        if (onImageLoadedListener2 == null) return false;
        if (onImageLoadedListener == null) return false;
        if (!Objects.equal((Object)onImageLoadedListener2, (Object)onImageLoadedListener)) return false;
        if (!Objects.equal((Object)((zaf)((Object)object)).zaa, (Object)this.zaa)) return false;
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zaa});
    }

    protected final void zaa(Drawable drawable, boolean bl, boolean bl2, boolean bl3) {
        if (bl2) return;
        ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zac.get();
        if (onImageLoadedListener == null) return;
        onImageLoadedListener.onImageLoaded(this.zaa.zaa, drawable, bl3);
    }
}
