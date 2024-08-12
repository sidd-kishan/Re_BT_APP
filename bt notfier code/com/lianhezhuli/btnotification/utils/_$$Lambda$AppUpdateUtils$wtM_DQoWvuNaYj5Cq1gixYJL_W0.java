/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.utils.AppUpdateUtils
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 */
package com.lianhezhuli.btnotification.utils;

import com.lianhezhuli.btnotification.utils.AppUpdateUtils;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public final class _$$Lambda$AppUpdateUtils$wtM_DQoWvuNaYj5Cq1gixYJL_W0
implements QMUIDialogAction.ActionListener {
    private final AppUpdateUtils f$0;
    private final String f$1;

    public /* synthetic */ _$$Lambda$AppUpdateUtils$wtM_DQoWvuNaYj5Cq1gixYJL_W0(AppUpdateUtils appUpdateUtils, String string) {
        this.f$0 = appUpdateUtils;
        this.f$1 = string;
    }

    public final void onClick(QMUIDialog qMUIDialog, int n) {
        this.f$0.lambda$checkIsNewVersion$3$AppUpdateUtils(this.f$1, qMUIDialog, n);
    }
}
