/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Request
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.net.Uri
 *  android.os.Environment
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbym
 */
package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbym;

final class zzbyk
implements DialogInterface.OnClickListener {
    final String zza;
    final String zzb;
    final zzbym zzc;

    zzbyk(zzbym zzbym2, String string, String string2) {
        this.zzc = zzbym2;
        this.zza = string;
        this.zzb = string2;
    }

    public final void onClick(DialogInterface object, int n) {
        DownloadManager downloadManager = (DownloadManager)zzbym.zza((zzbym)this.zzc).getSystemService("download");
        try {
            String string = this.zza;
            object = this.zzb;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse((String)string));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, (String)object);
            zzt.zzc();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            this.zzc.zzf("Could not store picture.");
            return;
        }
    }
}
