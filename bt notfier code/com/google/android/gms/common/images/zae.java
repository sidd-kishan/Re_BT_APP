/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 *  com.google.android.gms.common.images.zag
 *  com.google.android.gms.common.internal.Asserts
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.internal.base.zai
 *  com.google.android.gms.internal.base.zaj
 */
package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zai;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zae
extends zag {
    private final WeakReference<ImageView> zac;

    public zae(ImageView imageView, int n) {
        super(Uri.EMPTY, n);
        Asserts.checkNotNull((Object)imageView);
        this.zac = new WeakReference<ImageView>(imageView);
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull((Object)imageView);
        this.zac = new WeakReference<ImageView>(imageView);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zae)) {
            return false;
        }
        zae zae2 = (zae)((Object)object);
        object = (ImageView)this.zac.get();
        zae2 = (ImageView)zae2.zac.get();
        if (zae2 == null) return false;
        if (object == null) return false;
        if (!Objects.equal((Object)((Object)zae2), (Object)object)) return false;
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    protected final void zaa(Drawable drawable, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        ImageView imageView = (ImageView)this.zac.get();
        if (imageView == null) return;
        if (!bl2 && !bl3 && imageView instanceof zaj) {
            drawable = (zaj)imageView;
            throw null;
        }
        boolean bl5 = bl4 = false;
        if (!bl2) {
            bl5 = bl ? bl4 : true;
        }
        Drawable drawable2 = drawable;
        if (bl5) {
            Drawable drawable3 = imageView.getDrawable();
            if (drawable3 != null) {
                drawable2 = drawable3;
                if (drawable3 instanceof zai) {
                    drawable2 = ((zai)drawable3).zab();
                }
            } else {
                drawable2 = null;
            }
            drawable2 = new zai(drawable2, drawable);
        }
        imageView.setImageDrawable(drawable2);
        if (!(imageView instanceof zaj)) {
            if (drawable2 == null) return;
            if (!bl5) return;
            ((zai)drawable2).zac(250);
            return;
        }
        drawable = (zaj)imageView;
        throw null;
    }
}
