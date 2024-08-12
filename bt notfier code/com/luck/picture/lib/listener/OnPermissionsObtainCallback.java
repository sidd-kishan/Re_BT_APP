/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.luck.picture.lib.listener.OnPermissionDialogOptionCallback
 */
package com.luck.picture.lib.listener;

import android.content.Context;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;

public interface OnPermissionsObtainCallback {
    public void onPermissionsIntercept(Context var1, boolean var2, String[] var3, String var4, OnPermissionDialogOptionCallback var5);
}
