/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.common.internal.zzac
 *  com.google.android.gms.common.internal.zzae
 *  com.google.android.gms.internal.common.zzb
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.internal.common.zzb;

public abstract class zzad
extends zzb
implements zzae {
    public static zzae zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (!(iInterface instanceof zzae)) return new zzac(iBinder);
        return (zzae)iInterface;
    }
}
