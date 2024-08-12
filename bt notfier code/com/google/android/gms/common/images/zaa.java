/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  com.google.android.gms.common.images.ImageManager
 *  com.google.android.gms.common.images.zac
 *  com.google.android.gms.common.internal.Asserts
 */
package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zac;
import com.google.android.gms.common.internal.Asserts;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class zaa
implements Runnable {
    final ImageManager zaa;
    private final Uri zab;
    private final ParcelFileDescriptor zac;

    public zaa(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = parcelFileDescriptor;
    }

    @Override
    public final void run() {
        Asserts.checkNotMainThread((String)"LoadBitmapFromDiskRunnable can't be executed in the main thread");
        Object object = this.zac;
        ParcelFileDescriptor parcelFileDescriptor = null;
        boolean bl = false;
        if (object != null) {
            try {
                object = BitmapFactory.decodeFileDescriptor((FileDescriptor)object.getFileDescriptor());
                parcelFileDescriptor = object;
            }
            catch (OutOfMemoryError outOfMemoryError) {
                String string = String.valueOf(this.zab);
                object = new StringBuilder(String.valueOf(string).length() + 34);
                ((StringBuilder)object).append("OOM while loading bitmap for uri: ");
                ((StringBuilder)object).append(string);
                Log.e((String)"ImageManager", (String)((StringBuilder)object).toString(), (Throwable)outOfMemoryError);
                bl = true;
            }
            try {
                this.zac.close();
            }
            catch (IOException iOException) {
                Log.e((String)"ImageManager", (String)"closed failed", (Throwable)iOException);
            }
        } else {
            parcelFileDescriptor = null;
            bl = false;
        }
        object = new CountDownLatch(1);
        ImageManager.zaj((ImageManager)this.zaa).post((Runnable)new zac(this.zaa, this.zab, (Bitmap)parcelFileDescriptor, bl, (CountDownLatch)object));
        try {
            ((CountDownLatch)object).await();
            return;
        }
        catch (InterruptedException interruptedException) {
            object = String.valueOf(this.zab);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 32);
            stringBuilder.append("Latch interrupted while posting ");
            stringBuilder.append((String)object);
            Log.w((String)"ImageManager", (String)stringBuilder.toString());
            return;
        }
    }
}
