/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  android.os.ParcelFileDescriptor$AutoCloseOutputStream
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelable
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzcbg
 *  com.google.android.gms.internal.ads.zzcbi
 *  com.google.android.gms.internal.ads.zzchg
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzcbi;
import com.google.android.gms.internal.ads.zzchg;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzcbh
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbh> CREATOR = new zzcbi();
    ParcelFileDescriptor zza;
    private Parcelable zzb;
    private boolean zzc;

    public zzcbh(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = parcelFileDescriptor;
        this.zzb = null;
        this.zzc = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void writeToParcel(Parcel parcel, int n) {
        block9: {
            Object object;
            Parcel parcel2;
            block10: {
                Object var6_8;
                block8: {
                    ParcelFileDescriptor[] parcelFileDescriptorArray;
                    if (this.zza != null) break block9;
                    parcel2 = Parcel.obtain();
                    this.zzb.writeToParcel(parcel2, 0);
                    object = parcel2.marshall();
                    var6_8 = null;
                    try {
                        parcelFileDescriptorArray = ParcelFileDescriptor.createPipe();
                    }
                    catch (IOException iOException) {
                        parcel2 = null;
                        break block8;
                    }
                    ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArray[1];
                    {
                        parcel2 = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                    }
                    try {
                        parcelFileDescriptor = zzchg.zza;
                        zzcbg zzcbg2 = new zzcbg((OutputStream)parcel2, object);
                        parcelFileDescriptor.execute((Runnable)zzcbg2);
                    }
                    catch (IOException iOException) {
                        break block8;
                    }
                    object = parcelFileDescriptorArray[0];
                    break block10;
                }
                zze.zzg((String)"Error transporting the ad response", (Throwable)object);
                zzt.zzg().zzk((Throwable)object, "LargeParcelTeleporter.pipeData.2");
                IOUtils.closeQuietly((Closeable)parcel2);
                object = var6_8;
            }
            this.zza = (ParcelFileDescriptor)object;
            break block9;
            finally {
                parcel2.recycle();
            }
        }
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zza, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        Throwable throwable2222222;
        Object object;
        block8: {
            if (!this.zzc) return (T)((SafeParcelable)this.zzb);
            object = this.zza;
            if (object == null) {
                zze.zzf((String)"File descriptor is empty, returning null.");
                return null;
            }
            object = new DataInputStream((InputStream)new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor)object));
            int n = ((DataInputStream)object).readInt();
            byte[] byArray = new byte[n];
            ((DataInputStream)object).readFully(byArray, 0, n);
            {
                catch (Throwable throwable2222222) {
                    break block8;
                }
                catch (IOException iOException) {}
                {
                    zze.zzg((String)"Could not read from parcel file descriptor", (Throwable)iOException);
                }
                IOUtils.closeQuietly((Closeable)object);
                return null;
            }
            IOUtils.closeQuietly((Closeable)object);
            object = Parcel.obtain();
            try {
                object.unmarshall(byArray, 0, n);
                object.setDataPosition(0);
                this.zzb = (Parcelable)creator.createFromParcel((Parcel)object);
                this.zzc = false;
                return (T)((SafeParcelable)this.zzb);
            }
            finally {
                object.recycle();
            }
        }
        IOUtils.closeQuietly((Closeable)object);
        throw throwable2222222;
    }
}
