/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal$OnCancelListener
 *  androidx.print.PrintHelper$PrintUriAdapter$1
 */
package androidx.print;

import android.os.CancellationSignal;
import androidx.print.PrintHelper;

class PrintHelper.PrintUriAdapter.1
implements CancellationSignal.OnCancelListener {
    final PrintHelper.PrintUriAdapter.1 this$2;

    PrintHelper.PrintUriAdapter.1(PrintHelper.PrintUriAdapter.1 var1_1) {
        this.this$2 = var1_1;
    }

    public void onCancel() {
        this.this$2.this$1.cancelLoad();
        this.this$2.cancel(false);
    }
}
