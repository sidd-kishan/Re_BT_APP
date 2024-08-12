/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.lianhezhuli.btnotification.WelcomeActivity
 */
package com.lianhezhuli.btnotification;

import android.content.DialogInterface;
import com.lianhezhuli.btnotification.WelcomeActivity;
import java.util.List;

public final class _$$Lambda$WelcomeActivity$ITX_AP2mc22w8XXp7vc8ub9L4vE
implements DialogInterface.OnClickListener {
    private final WelcomeActivity f$0;
    private final List f$1;
    private final String[] f$2;

    public /* synthetic */ _$$Lambda$WelcomeActivity$ITX_AP2mc22w8XXp7vc8ub9L4vE(WelcomeActivity welcomeActivity, List list, String[] stringArray) {
        this.f$0 = welcomeActivity;
        this.f$1 = list;
        this.f$2 = stringArray;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.f$0.lambda$initView$1$WelcomeActivity(this.f$1, this.f$2, dialogInterface, n);
    }
}
