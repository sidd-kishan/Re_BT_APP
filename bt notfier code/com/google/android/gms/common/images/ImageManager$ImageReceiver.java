/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  com.google.android.gms.common.images.ImageManager
 *  com.google.android.gms.common.images.zaa
 *  com.google.android.gms.common.images.zag
 *  com.google.android.gms.common.internal.Asserts
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.images;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
private final class ImageManager.ImageReceiver
extends ResultReceiver {
    final ImageManager zaa;
    private final Uri zab;
    private final ArrayList<zag> zac;

    ImageManager.ImageReceiver(ImageManager imageManager, Uri uri) {
        this.zaa = imageManager;
        super((Handler)new zap(Looper.getMainLooper()));
        this.zab = uri;
        this.zac = new ArrayList();
    }

    static /* synthetic */ ArrayList zad(ImageManager.ImageReceiver imageReceiver) {
        return imageReceiver.zac;
    }

    public final void onReceiveResult(int n, Bundle bundle) {
        bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
        ImageManager.zai((ImageManager)this.zaa).execute((Runnable)new zaa(this.zaa, this.zab, (ParcelFileDescriptor)bundle));
    }

    public final void zaa(zag zag2) {
        Asserts.checkMainThread((String)"ImageReceiver.addImageRequest() must be called in the main thread");
        this.zac.add(zag2);
    }

    public final void zab(zag zag2) {
        Asserts.checkMainThread((String)"ImageReceiver.removeImageRequest() must be called in the main thread");
        this.zac.remove(zag2);
    }

    public final void zac() {
        Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("com.google.android.gms.extras.uri", (Parcelable)this.zab);
        intent.putExtra("com.google.android.gms.extras.resultReceiver", (Parcelable)this);
        intent.putExtra("com.google.android.gms.extras.priority", 3);
        ImageManager.zac((ImageManager)this.zaa).sendBroadcast(intent);
    }
}
