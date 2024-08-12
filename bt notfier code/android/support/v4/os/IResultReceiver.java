/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package android.support.v4.os;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface IResultReceiver
extends IInterface {
    public void send(int var1, Bundle var2) throws RemoteException;
}
