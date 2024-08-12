/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 *  com.google.android.gms.internal.ads.zzfjm
 *  com.google.android.gms.internal.ads.zzfki
 *  com.google.android.gms.internal.ads.zzfkl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzfjm;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzfkl;

public final class zzfkk {
    boolean zza;
    zzfkl zzb;

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public zzfkk(Context object, String object2, String string) {
        IInterface iInterface;
        string = DynamiteModule.load((Context)object, (DynamiteModule.VersionPolicy)DynamiteModule.PREFER_REMOTE, (String)"com.google.android.gms.ads.dynamite");
        string = string.instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
        string = string == null ? null : ((iInterface = string.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut")) instanceof zzfkl ? (zzfkl)iInterface : new zzfkl((IBinder)string));
        {
            catch (Exception exception) {
                try {
                    super((Throwable)exception);
                    throw object2;
                }
                catch (RemoteException | zzfjm | NullPointerException | SecurityException throwable) {
                    Log.d((String)"GASS", (String)"Cannot dynamite load clearcut");
                    return;
                }
            }
        }
        this.zzb = string;
        object = ObjectWrapper.wrap((Object)object);
        this.zzb.zzj((IObjectWrapper)object, object2, null);
        this.zza = true;
        Log.i((String)"GASS", (String)"GassClearcutLogger Initialized.");
        return;
        catch (Exception exception) {
            super((Throwable)exception);
            throw object;
        }
    }

    public final zzfki zza(byte[] byArray) {
        return new zzfki(this, byArray, null);
    }
}
