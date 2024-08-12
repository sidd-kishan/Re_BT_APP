/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Message
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ListView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AppCompatDialog
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AppCompatDialog;

public class AlertDialog
extends AppCompatDialog
implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert = new AlertController(this.getContext(), (AppCompatDialog)this, this.getWindow());

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    protected AlertDialog(Context context, int n) {
        super(context, AlertDialog.resolveDialogTheme(context, n));
    }

    protected AlertDialog(Context context, boolean bl, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        this.setCancelable(bl);
        this.setOnCancelListener(onCancelListener);
    }

    static int resolveDialogTheme(Context context, int n) {
        if ((n >>> 24 & 0xFF) >= 1) {
            return n;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int n) {
        return this.mAlert.getButton(n);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (!this.mAlert.onKeyDown(n, keyEvent)) return super.onKeyDown(n, keyEvent);
        return true;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        if (!this.mAlert.onKeyUp(n, keyEvent)) return super.onKeyUp(n, keyEvent);
        return true;
    }

    public void setButton(int n, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(n, charSequence, onClickListener, null, null);
    }

    public void setButton(int n, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(n, charSequence, onClickListener, null, drawable);
    }

    public void setButton(int n, CharSequence charSequence, Message message) {
        this.mAlert.setButton(n, charSequence, null, message, null);
    }

    void setButtonPanelLayoutHint(int n) {
        this.mAlert.setButtonPanelLayoutHint(n);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int n) {
        this.mAlert.setIcon(n);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int n) {
        TypedValue typedValue = new TypedValue();
        this.getContext().getTheme().resolveAttribute(n, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int n, int n2, int n3, int n4) {
        this.mAlert.setView(view, n, n2, n3, n4);
    }
}
