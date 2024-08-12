/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.SystemClock
 *  com.google.android.gms.common.images.ImageManager
 *  com.google.android.gms.common.images.ImageManager$ImageReceiver
 *  com.google.android.gms.common.images.zaf
 *  com.google.android.gms.common.images.zag
 *  com.google.android.gms.common.internal.Asserts
 */
package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zaf;
import com.google.android.gms.common.images.zag;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class zac
implements Runnable {
    final ImageManager zaa;
    private final Uri zab;
    private final Bitmap zac;
    private final CountDownLatch zad;

    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean bl, CountDownLatch countDownLatch) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = bitmap;
        this.zad = countDownLatch;
    }

    @Override
    public final void run() {
        Asserts.checkMainThread((String)"OnBitmapLoadedRunnable must be executed in the main thread");
        Object object = this.zac;
        Object object2 = (ImageManager.ImageReceiver)ImageManager.zaf((ImageManager)this.zaa).remove(this.zab);
        if (object2 != null) {
            object2 = ImageManager.ImageReceiver.zad((ImageManager.ImageReceiver)object2);
            int n = ((ArrayList)object2).size();
            for (int i = 0; i < n; ++i) {
                zag zag2 = (zag)((ArrayList)object2).get(i);
                if (this.zac != null && object != null) {
                    zag2.zab(ImageManager.zac((ImageManager)this.zaa), this.zac, false);
                } else {
                    ImageManager.zae((ImageManager)this.zaa).put(this.zab, SystemClock.elapsedRealtime());
                    zag2.zac(ImageManager.zac((ImageManager)this.zaa), ImageManager.zad((ImageManager)this.zaa), false);
                }
                if (zag2 instanceof zaf) continue;
                ImageManager.zab((ImageManager)this.zaa).remove(zag2);
            }
        }
        this.zad.countDown();
        object = ImageManager.zag();
        synchronized (object) {
            try {
                ImageManager.zah().remove(this.zab);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
