/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.common.internal.zam
 *  com.google.android.gms.common.internal.zax
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.zam;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zaz
extends RemoteCreator<zam> {
    private static final zaz zaa = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context object, int n, int n2) throws RemoteCreator.RemoteCreatorException {
        zaz zaz2 = zaa;
        try {
            zax zax2 = new zax(1, n, n2, null);
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)object);
            object = (View)ObjectWrapper.unwrap((IObjectWrapper)((zam)zaz2.getRemoteCreatorInstance((Context)object)).zae(iObjectWrapper, zax2));
            return object;
        }
        catch (Exception exception) {
            object = new StringBuilder(64);
            ((StringBuilder)object).append("Could not get button with size ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" and color ");
            ((StringBuilder)object).append(n2);
            throw new RemoteCreator.RemoteCreatorException(((StringBuilder)object).toString(), (Throwable)exception);
        }
    }
}
