/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCanceledListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.OnSuccessListener
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

interface zzab<T>
extends OnSuccessListener<T>,
OnFailureListener,
OnCanceledListener {
}
