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

public final class _$$Lambda$AppUpdateUtils$vt_hQkp4Pf9N0pgPfXhdkKtiWDc
implements QMUIDialogAction.ActionListener {
    public static final _$$Lambda$AppUpdateUtils$vt_hQkp4Pf9N0pgPfXhdkKtiWDc INSTANCE = new _$$Lambda$AppUpdateUtils$vt_hQkp4Pf9N0pgPfXhdkKtiWDc();

    private /* synthetic */ _$$Lambda$AppUpdateUtils$vt_hQkp4Pf9N0pgPfXhdkKtiWDc() {
    }

    public final void onClick(QMUIDialog qMUIDialog, int n) {
        AppUpdateUtils.lambda$checkIsNewVersion$2((QMUIDialog)qMUIDialog, (int)n);
    }
}
