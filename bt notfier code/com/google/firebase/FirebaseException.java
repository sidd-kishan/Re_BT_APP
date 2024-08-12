/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException
extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    public FirebaseException(String string) {
        Preconditions.checkNotEmpty((String)string, (Object)"Detail message must not be empty");
        super(string);
    }

    public FirebaseException(String string, Throwable throwable) {
        Preconditions.checkNotEmpty((String)string, (Object)"Detail message must not be empty");
        super(string, throwable);
    }
}
