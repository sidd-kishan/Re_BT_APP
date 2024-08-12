/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.ImageView
 *  com.google.android.gms.common.images.ImageManager$ImageReceiver
 *  com.google.android.gms.common.images.ImageManager$OnImageLoadedListener
 *  com.google.android.gms.common.images.zab
 *  com.google.android.gms.common.images.zae
 *  com.google.android.gms.common.images.zaf
 *  com.google.android.gms.common.images.zag
 *  com.google.android.gms.common.internal.Asserts
 *  com.google.android.gms.internal.base.zak
 *  com.google.android.gms.internal.base.zao
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.images.zae;
import com.google.android.gms.common.images.zaf;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object zaa = new Object();
    private static HashSet<Uri> zab = new HashSet();
    private static ImageManager zac;
    private final Context zad;
    private final Handler zae;
    private final ExecutorService zaf;
    private final zak zag;
    private final Map<zag, ImageReceiver> zah;
    private final Map<Uri, ImageReceiver> zai;
    private final Map<Uri, Long> zaj;

    private ImageManager(Context context, boolean bl) {
        this.zad = context.getApplicationContext();
        this.zae = new zap(Looper.getMainLooper());
        this.zaf = zao.zaa().zaa(4, 2);
        this.zag = new zak();
        this.zah = new HashMap<zag, ImageReceiver>();
        this.zai = new HashMap<Uri, ImageReceiver>();
        this.zaj = new HashMap<Uri, Long>();
    }

    public static ImageManager create(Context context) {
        if (zac != null) return zac;
        zac = new ImageManager(context, false);
        return zac;
    }

    static /* synthetic */ Map zab(ImageManager imageManager) {
        return imageManager.zah;
    }

    static /* synthetic */ Context zac(ImageManager imageManager) {
        return imageManager.zad;
    }

    static /* synthetic */ zak zad(ImageManager imageManager) {
        return imageManager.zag;
    }

    static /* synthetic */ Map zae(ImageManager imageManager) {
        return imageManager.zaj;
    }

    static /* synthetic */ Map zaf(ImageManager imageManager) {
        return imageManager.zai;
    }

    static /* synthetic */ Object zag() {
        return zaa;
    }

    static /* synthetic */ HashSet zah() {
        return zab;
    }

    static /* synthetic */ ExecutorService zai(ImageManager imageManager) {
        return imageManager.zaf;
    }

    static /* synthetic */ Handler zaj(ImageManager imageManager) {
        return imageManager.zae;
    }

    public void loadImage(ImageView imageView, int n) {
        this.zaa((zag)new zae(imageView, n));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        this.zaa((zag)new zae(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int n) {
        imageView = new zae(imageView, uri);
        imageView.zab = n;
        this.zaa((zag)imageView);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        this.zaa((zag)new zaf(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int n) {
        onImageLoadedListener = new zaf(onImageLoadedListener, uri);
        onImageLoadedListener.zab = n;
        this.zaa((zag)onImageLoadedListener);
    }

    public final void zaa(zag zag2) {
        Asserts.checkMainThread((String)"ImageManager.loadImage() must be called in the main thread");
        new zab(this, zag2).run();
    }
}
