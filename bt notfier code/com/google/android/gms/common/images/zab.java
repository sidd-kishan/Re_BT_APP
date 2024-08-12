/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.common.images.ImageManager
 *  com.google.android.gms.common.images.ImageManager$ImageReceiver
 *  com.google.android.gms.common.images.zad
 *  com.google.android.gms.common.images.zaf
 *  com.google.android.gms.common.images.zag
 *  com.google.android.gms.common.internal.Asserts
 */
package com.google.android.gms.common.images;

import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zad;
import com.google.android.gms.common.images.zaf;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.common.internal.Asserts;

final class zab
implements Runnable {
    final ImageManager zaa;
    private final zag zab;

    public zab(ImageManager imageManager, zag zag2) {
        this.zaa = imageManager;
        this.zab = zag2;
    }

    @Override
    public final void run() {
        Asserts.checkMainThread((String)"LoadImageRunnable must be executed on the main thread");
        Object object = (ImageManager.ImageReceiver)ImageManager.zab((ImageManager)this.zaa).get(this.zab);
        if (object != null) {
            ImageManager.zab((ImageManager)this.zaa).remove(this.zab);
            object.zab(this.zab);
        }
        object = this.zab;
        zad zad2 = ((zag)object).zaa;
        if (zad2.zaa == null) {
            object.zac(ImageManager.zac((ImageManager)this.zaa), ImageManager.zad((ImageManager)this.zaa), true);
            return;
        }
        object = (Long)ImageManager.zae((ImageManager)this.zaa).get(zad2.zaa);
        if (object != null) {
            if (SystemClock.elapsedRealtime() - (Long)object < 3600000L) {
                this.zab.zac(ImageManager.zac((ImageManager)this.zaa), ImageManager.zad((ImageManager)this.zaa), true);
                return;
            }
            ImageManager.zae((ImageManager)this.zaa).remove(zad2.zaa);
        }
        this.zab.zaa(null, false, true, false);
        Object object2 = (ImageManager.ImageReceiver)ImageManager.zaf((ImageManager)this.zaa).get(zad2.zaa);
        object = object2;
        if (object2 == null) {
            object = new ImageManager.ImageReceiver(this.zaa, zad2.zaa);
            ImageManager.zaf((ImageManager)this.zaa).put(zad2.zaa, object);
        }
        object.zaa(this.zab);
        if (!(this.zab instanceof zaf)) {
            ImageManager.zab((ImageManager)this.zaa).put(this.zab, object);
        }
        object2 = ImageManager.zag();
        synchronized (object2) {
            if (ImageManager.zah().contains(zad2.zaa)) return;
            ImageManager.zah().add(zad2.zaa);
            object.zac();
            return;
        }
    }
}
