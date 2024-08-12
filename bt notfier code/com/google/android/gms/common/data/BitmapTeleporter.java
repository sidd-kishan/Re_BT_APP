/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 *  com.google.android.gms.common.data.zaa
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 */
package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.zaa;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
    final int zaa;
    ParcelFileDescriptor zab;
    final int zac;
    private Bitmap zad;
    private boolean zae;
    private File zaf;

    BitmapTeleporter(int n, ParcelFileDescriptor parcelFileDescriptor, int n2) {
        this.zaa = n;
        this.zab = parcelFileDescriptor;
        this.zac = n2;
        this.zad = null;
        this.zae = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        this.zaa = 1;
        this.zab = null;
        this.zac = 0;
        this.zad = bitmap;
        this.zae = true;
    }

    private static final void zaa(Closeable closeable) {
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            Log.w((String)"BitmapTeleporter", (String)"Could not close stream", (Throwable)iOException);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public Bitmap get() {
        Throwable throwable2222222;
        Object object;
        block4: {
            if (this.zae) return this.zad;
            object = new DataInputStream((InputStream)new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor)Preconditions.checkNotNull((Object)this.zab)));
            byte[] byArray = new byte[((DataInputStream)object).readInt()];
            int n = ((DataInputStream)object).readInt();
            int n2 = ((DataInputStream)object).readInt();
            Bitmap.Config config = Bitmap.Config.valueOf((String)((DataInputStream)object).readUTF());
            ((DataInputStream)object).read(byArray);
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (IOException iOException) {}
                {
                    IllegalStateException illegalStateException = new IllegalStateException("Could not read from parcel file descriptor", iOException);
                    throw illegalStateException;
                }
            }
            BitmapTeleporter.zaa((Closeable)object);
            object = ByteBuffer.wrap(byArray);
            config = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
            config.copyPixelsFromBuffer((Buffer)object);
            this.zad = config;
            this.zae = true;
            return this.zad;
        }
        BitmapTeleporter.zaa((Closeable)object);
        throw throwable2222222;
    }

    public void release() {
        if (this.zae) return;
        try {
            ((ParcelFileDescriptor)Preconditions.checkNotNull((Object)this.zab)).close();
            return;
        }
        catch (IOException iOException) {
            Log.w((String)"BitmapTeleporter", (String)"Could not close PFD", (Throwable)iOException);
        }
    }

    public void setTempDir(File file) {
        if (file == null) throw new NullPointerException("Cannot set null temp directory");
        this.zaf = file;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void writeToParcel(Parcel object, int n) {
        Throwable throwable222222;
        Object object2;
        if (this.zab == null) {
            FileOutputStream fileOutputStream;
            Bitmap bitmap = (Bitmap)Preconditions.checkNotNull((Object)this.zad);
            Object object3 = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer((Buffer)object3);
            object3 = ((ByteBuffer)object3).array();
            object2 = this.zaf;
            if (object2 == null) throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            try {
                object2 = File.createTempFile("teleporter", ".tmp", (File)object2);
            }
            catch (IOException iOException) {
                throw new IllegalStateException("Could not create temporary file", iOException);
            }
            try {
                fileOutputStream = new FileOutputStream((File)object2);
                this.zab = ParcelFileDescriptor.open((File)object2, (int)0x10000000);
                ((File)object2).delete();
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
            object2 = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
            ((DataOutputStream)object2).writeInt(((Object)object3).length);
            ((DataOutputStream)object2).writeInt(bitmap.getWidth());
            ((DataOutputStream)object2).writeInt(bitmap.getHeight());
            ((DataOutputStream)object2).writeUTF(bitmap.getConfig().toString());
            ((FilterOutputStream)object2).write((byte[])object3);
            BitmapTeleporter.zaa((Closeable)object2);
        }
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)object);
        SafeParcelWriter.writeInt((Parcel)object, (int)1, (int)this.zaa);
        SafeParcelWriter.writeParcelable((Parcel)object, (int)2, (Parcelable)this.zab, (int)(n | 1), (boolean)false);
        SafeParcelWriter.writeInt((Parcel)object, (int)3, (int)this.zac);
        SafeParcelWriter.finishObjectHeader((Parcel)object, (int)n2);
        this.zab = null;
        return;
        {
            catch (Throwable throwable222222) {
            }
            catch (IOException iOException) {}
            {
                object = new IllegalStateException("Could not write into unlinked file", iOException);
                throw object;
            }
        }
        BitmapTeleporter.zaa((Closeable)object2);
        throw throwable222222;
    }
}
