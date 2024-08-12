/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.api.Scope
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class zaa
implements Comparator {
    static final Comparator zaa = new zaa();

    private zaa() {
    }

    public final int compare(Object object, Object object2) {
        object = (Scope)object;
        Scope scope = (Scope)object2;
        object2 = GoogleSignInAccount.CREATOR;
        return object.getScopeUri().compareTo(scope.getScopeUri());
    }
}
