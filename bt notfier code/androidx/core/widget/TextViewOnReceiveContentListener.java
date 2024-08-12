/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 *  androidx.core.view.ContentInfoCompat
 *  androidx.core.view.OnReceiveContentListener
 *  androidx.core.widget.TextViewOnReceiveContentListener$Api16Impl
 *  androidx.core.widget.TextViewOnReceiveContentListener$ApiImpl
 */
package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import androidx.core.widget.TextViewOnReceiveContentListener;

/*
 * Exception performing whole class analysis ignored.
 */
public final class TextViewOnReceiveContentListener
implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    private static CharSequence coerceToText(Context context, ClipData.Item item, int n) {
        if (Build.VERSION.SDK_INT < 16) return ApiImpl.coerce((Context)context, (ClipData.Item)item, (int)n);
        return Api16Impl.coerce((Context)context, (ClipData.Item)item, (int)n);
    }

    private static void replaceSelection(Editable editable, CharSequence charSequence) {
        int n = Selection.getSelectionStart((CharSequence)editable);
        int n2 = Selection.getSelectionEnd((CharSequence)editable);
        int n3 = Math.max(0, Math.min(n, n2));
        n2 = Math.max(0, Math.max(n, n2));
        Selection.setSelection((Spannable)editable, (int)n2);
        editable.replace(n3, n2, charSequence);
    }

    public ContentInfoCompat onReceiveContent(View view, ContentInfoCompat object) {
        StringBuilder stringBuilder;
        if (Log.isLoggable((String)"ReceiveContent", (int)3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("onReceive: ");
            stringBuilder.append(object);
            Log.d((String)"ReceiveContent", (String)stringBuilder.toString());
        }
        if (object.getSource() == 2) {
            return object;
        }
        stringBuilder = object.getClip();
        int n = object.getFlags();
        object = (TextView)view;
        view = (Editable)object.getText();
        Context context = object.getContext();
        int n2 = 0;
        boolean bl = false;
        while (n2 < stringBuilder.getItemCount()) {
            object = TextViewOnReceiveContentListener.coerceToText(context, stringBuilder.getItemAt(n2), n);
            boolean bl2 = bl;
            if (object != null) {
                if (!bl) {
                    TextViewOnReceiveContentListener.replaceSelection((Editable)view, (CharSequence)object);
                    bl2 = true;
                } else {
                    view.insert(Selection.getSelectionEnd((CharSequence)view), (CharSequence)"\n");
                    view.insert(Selection.getSelectionEnd((CharSequence)view), (CharSequence)object);
                    bl2 = bl;
                }
            }
            ++n2;
            bl = bl2;
        }
        return null;
    }
}
