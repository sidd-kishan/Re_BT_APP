/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzanl
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzaru
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzavh
 */
package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzanl;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzavh;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzanm
implements Parcelable {
    public static final Parcelable.Creator<zzanm> CREATOR = new zzanl();
    private int zzA;
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final zzaru zzd;
    public final String zze;
    public final String zzf;
    public final int zzg;
    public final List<byte[]> zzh;
    public final zzapk zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final float zzn;
    public final int zzo;
    public final byte[] zzp;
    public final zzavh zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final int zzu;
    public final int zzv;
    public final long zzw;
    public final int zzx;
    public final String zzy;
    public final int zzz;

    zzanm(Parcel parcel) {
        this.zza = parcel.readString();
        this.zze = parcel.readString();
        this.zzf = parcel.readString();
        this.zzc = parcel.readString();
        this.zzb = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzj = parcel.readInt();
        this.zzk = parcel.readInt();
        this.zzl = parcel.readFloat();
        this.zzm = parcel.readInt();
        this.zzn = parcel.readFloat();
        byte[] byArray = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzp = byArray;
        this.zzo = parcel.readInt();
        this.zzq = (zzavh)parcel.readParcelable(zzavh.class.getClassLoader());
        this.zzr = parcel.readInt();
        this.zzs = parcel.readInt();
        this.zzt = parcel.readInt();
        this.zzu = parcel.readInt();
        this.zzv = parcel.readInt();
        this.zzx = parcel.readInt();
        this.zzy = parcel.readString();
        this.zzz = parcel.readInt();
        this.zzw = parcel.readLong();
        int n = parcel.readInt();
        this.zzh = new ArrayList<byte[]>(n);
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zzi = (zzapk)parcel.readParcelable(zzapk.class.getClassLoader());
                this.zzd = (zzaru)parcel.readParcelable(zzaru.class.getClassLoader());
                return;
            }
            this.zzh.add(parcel.createByteArray());
            ++n2;
        }
    }

    zzanm(String list, String string, String string2, String string3, int n, int n2, int n3, int n4, float f, int n5, float f2, byte[] byArray, int n6, zzavh zzavh2, int n7, int n8, int n9, int n10, int n11, int n12, String string4, int n13, long l, List<byte[]> list2, zzapk zzapk2, zzaru zzaru2) {
        this.zza = list;
        this.zze = string;
        this.zzf = string2;
        this.zzc = string3;
        this.zzb = n;
        this.zzg = n2;
        this.zzj = n3;
        this.zzk = n4;
        this.zzl = f;
        this.zzm = n5;
        this.zzn = f2;
        this.zzp = byArray;
        this.zzo = n6;
        this.zzq = zzavh2;
        this.zzr = n7;
        this.zzs = n8;
        this.zzt = n9;
        this.zzu = n10;
        this.zzv = n11;
        this.zzx = n12;
        this.zzy = string4;
        this.zzz = n13;
        this.zzw = l;
        list = list2 == null ? Collections.emptyList() : list2;
        this.zzh = list;
        this.zzi = zzapk2;
        this.zzd = zzaru2;
    }

    public static zzanm zza(String string, String string2, String string3, int n, int n2, int n3, int n4, float f, List<byte[]> list, int n5, float f2, byte[] byArray, int n6, zzavh zzavh2, zzapk zzapk2) {
        return new zzanm(string, null, string2, null, -1, n2, n3, n4, -1.0f, n5, f2, byArray, n6, zzavh2, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzapk2, null);
    }

    public static zzanm zzb(String string, String string2, String string3, int n, int n2, int n3, int n4, List<byte[]> list, zzapk zzapk2, int n5, String string4) {
        return zzanm.zzc(string, string2, null, -1, -1, n3, n4, -1, -1, -1, null, zzapk2, 0, string4, null);
    }

    public static zzanm zzc(String string, String string2, String string3, int n, int n2, int n3, int n4, int n5, int n6, int n7, List<byte[]> list, zzapk zzapk2, int n8, String string4, zzaru zzaru2) {
        return new zzanm(string, null, string2, null, -1, n2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, n3, n4, n5, -1, -1, n8, string4, -1, Long.MAX_VALUE, list, zzapk2, null);
    }

    public static zzanm zzd(String string, String string2, String string3, int n, int n2, String string4, int n3, zzapk zzapk2, long l, List<byte[]> list) {
        return new zzanm(string, null, string2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, n2, string4, -1, l, list, zzapk2, null);
    }

    public static zzanm zze(String string, String string2, String string3, int n, List<byte[]> list, String string4, zzapk zzapk2) {
        return new zzanm(string, null, string2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, string4, -1, Long.MAX_VALUE, list, zzapk2, null);
    }

    public static zzanm zzf(String string, String string2, String string3, int n, zzapk zzapk2) {
        return new zzanm(string, null, "application/x-camera-motion", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, zzapk2, null);
    }

    private static void zzm(MediaFormat mediaFormat, String string, int n) {
        if (n == -1) return;
        mediaFormat.setInteger(string, n);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzanm)object;
        if (this.zzb != ((zzanm)object).zzb) return false;
        if (this.zzg != ((zzanm)object).zzg) return false;
        if (this.zzj != ((zzanm)object).zzj) return false;
        if (this.zzk != ((zzanm)object).zzk) return false;
        if (this.zzl != ((zzanm)object).zzl) return false;
        if (this.zzm != ((zzanm)object).zzm) return false;
        if (this.zzn != ((zzanm)object).zzn) return false;
        if (this.zzo != ((zzanm)object).zzo) return false;
        if (this.zzr != ((zzanm)object).zzr) return false;
        if (this.zzs != ((zzanm)object).zzs) return false;
        if (this.zzt != ((zzanm)object).zzt) return false;
        if (this.zzu != ((zzanm)object).zzu) return false;
        if (this.zzv != ((zzanm)object).zzv) return false;
        if (this.zzw != ((zzanm)object).zzw) return false;
        if (this.zzx != ((zzanm)object).zzx) return false;
        if (!zzave.zza((Object)this.zza, (Object)((zzanm)object).zza)) return false;
        if (!zzave.zza((Object)this.zzy, (Object)((zzanm)object).zzy)) return false;
        if (this.zzz != ((zzanm)object).zzz) return false;
        if (!zzave.zza((Object)this.zze, (Object)((zzanm)object).zze)) return false;
        if (!zzave.zza((Object)this.zzf, (Object)((zzanm)object).zzf)) return false;
        if (!zzave.zza((Object)this.zzc, (Object)((zzanm)object).zzc)) return false;
        if (!zzave.zza((Object)this.zzi, (Object)((zzanm)object).zzi)) return false;
        if (!zzave.zza((Object)this.zzd, (Object)((zzanm)object).zzd)) return false;
        if (!zzave.zza((Object)this.zzq, (Object)((zzanm)object).zzq)) return false;
        if (!Arrays.equals(this.zzp, ((zzanm)object).zzp)) return false;
        if (this.zzh.size() != ((zzanm)object).zzh.size()) return false;
        int n = 0;
        while (n < this.zzh.size()) {
            if (!Arrays.equals(this.zzh.get(n), ((zzanm)object).zzh.get(n))) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzA;
        if (n != 0) return n2;
        String string = this.zza;
        int n3 = 0;
        n2 = string == null ? 0 : string.hashCode();
        string = this.zze;
        n = string == null ? 0 : string.hashCode();
        string = this.zzf;
        int n4 = string == null ? 0 : string.hashCode();
        string = this.zzc;
        int n5 = string == null ? 0 : string.hashCode();
        int n6 = this.zzb;
        int n7 = this.zzj;
        int n8 = this.zzk;
        int n9 = this.zzr;
        int n10 = this.zzs;
        string = this.zzy;
        int n11 = string == null ? 0 : string.hashCode();
        int n12 = this.zzz;
        string = this.zzi;
        int n13 = string == null ? 0 : string.hashCode();
        string = this.zzd;
        if (string != null) {
            n3 = string.hashCode();
        }
        this.zzA = n2 = ((((((((((((n2 + 527) * 31 + n) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n3;
        return n2;
    }

    public final String toString() {
        String string = this.zza;
        String string2 = this.zze;
        String string3 = this.zzf;
        int n = this.zzb;
        String string4 = this.zzy;
        int n2 = this.zzj;
        int n3 = this.zzk;
        float f = this.zzl;
        int n4 = this.zzr;
        int n5 = this.zzs;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 100 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length());
        stringBuilder.append("Format(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string3);
        stringBuilder.append(", ");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(string4);
        stringBuilder.append(", [");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append(f);
        stringBuilder.append("], [");
        stringBuilder.append(n4);
        stringBuilder.append(", ");
        stringBuilder.append(n5);
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zze);
        parcel.writeString(this.zzf);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzg);
        parcel.writeInt(this.zzj);
        parcel.writeInt(this.zzk);
        parcel.writeFloat(this.zzl);
        parcel.writeInt(this.zzm);
        parcel.writeFloat(this.zzn);
        int n2 = this.zzp != null ? 1 : 0;
        parcel.writeInt(n2);
        byte[] byArray = this.zzp;
        if (byArray != null) {
            parcel.writeByteArray(byArray);
        }
        parcel.writeInt(this.zzo);
        parcel.writeParcelable((Parcelable)this.zzq, n);
        parcel.writeInt(this.zzr);
        parcel.writeInt(this.zzs);
        parcel.writeInt(this.zzt);
        parcel.writeInt(this.zzu);
        parcel.writeInt(this.zzv);
        parcel.writeInt(this.zzx);
        parcel.writeString(this.zzy);
        parcel.writeInt(this.zzz);
        parcel.writeLong(this.zzw);
        n2 = this.zzh.size();
        parcel.writeInt(n2);
        n = 0;
        while (true) {
            if (n >= n2) {
                parcel.writeParcelable((Parcelable)this.zzi, 0);
                parcel.writeParcelable((Parcelable)this.zzd, 0);
                return;
            }
            parcel.writeByteArray(this.zzh.get(n));
            ++n;
        }
    }

    public final zzanm zzg(int n) {
        return new zzanm(this.zza, this.zze, this.zzf, this.zzc, this.zzb, n, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, this.zzd);
    }

    public final zzanm zzh(int n, int n2) {
        return new zzanm(this.zza, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, n, n2, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, this.zzd);
    }

    public final zzanm zzi(zzapk zzapk2) {
        return new zzanm(this.zza, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, zzapk2, this.zzd);
    }

    public final zzanm zzj(zzaru zzaru2) {
        return new zzanm(this.zza, this.zze, this.zzf, this.zzc, this.zzb, this.zzg, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzx, this.zzy, this.zzz, this.zzw, this.zzh, this.zzi, zzaru2);
    }

    public final int zzk() {
        int n = this.zzj;
        if (n == -1) return -1;
        int n2 = this.zzk;
        if (n2 != -1) return n * n2;
        return -1;
    }

    public final MediaFormat zzl() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzf);
        Object object = this.zzy;
        if (object != null) {
            mediaFormat.setString("language", (String)object);
        }
        zzanm.zzm(mediaFormat, "max-input-size", this.zzg);
        zzanm.zzm(mediaFormat, "width", this.zzj);
        zzanm.zzm(mediaFormat, "height", this.zzk);
        float f = this.zzl;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zzanm.zzm(mediaFormat, "rotation-degrees", this.zzm);
        zzanm.zzm(mediaFormat, "channel-count", this.zzr);
        zzanm.zzm(mediaFormat, "sample-rate", this.zzs);
        zzanm.zzm(mediaFormat, "encoder-delay", this.zzu);
        zzanm.zzm(mediaFormat, "encoder-padding", this.zzv);
        for (int i = 0; i < this.zzh.size(); ++i) {
            object = new StringBuilder(15);
            ((StringBuilder)object).append("csd-");
            ((StringBuilder)object).append(i);
            mediaFormat.setByteBuffer(((StringBuilder)object).toString(), ByteBuffer.wrap(this.zzh.get(i)));
        }
        object = this.zzq;
        if (object == null) return mediaFormat;
        zzanm.zzm(mediaFormat, "color-transfer", ((zzavh)object).zzc);
        zzanm.zzm(mediaFormat, "color-standard", ((zzavh)object).zza);
        zzanm.zzm(mediaFormat, "color-range", ((zzavh)object).zzb);
        object = ((zzavh)object).zzd;
        if (object == null) return mediaFormat;
        mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap((byte[])object));
        return mediaFormat;
    }
}
