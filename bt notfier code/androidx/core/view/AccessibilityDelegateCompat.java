/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.style.ClickableSpan
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.R$id
 *  androidx.core.view.AccessibilityDelegateCompat$AccessibilityDelegateAdapter
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 */
package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View object) {
        List list = (List)object.getTag(R.id.tag_accessibility_actions);
        object = list;
        if (list != null) return object;
        object = Collections.emptyList();
        return object;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View clickableSpanArray) {
        if (clickableSpan == null) return false;
        clickableSpanArray = AccessibilityNodeInfoCompat.getClickableSpans((CharSequence)clickableSpanArray.createAccessibilityNodeInfo().getText());
        int n = 0;
        while (clickableSpanArray != null) {
            if (n >= clickableSpanArray.length) return false;
            if (clickableSpan.equals(clickableSpanArray[n])) {
                return true;
            }
            ++n;
        }
        return false;
    }

    private boolean performClickableSpanAction(int n, View view) {
        Object object = (SparseArray)view.getTag(R.id.tag_accessibility_clickable_spans);
        if (object == null) return false;
        if ((object = (WeakReference)object.get(n)) == null) return false;
        if (!this.isSpanStillValid((ClickableSpan)(object = (ClickableSpan)((Reference)object).get()), view)) return false;
        object.onClick(view);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (Build.VERSION.SDK_INT < 16) return null;
        if ((view = this.mOriginalDelegate.getAccessibilityNodeProvider(view)) == null) return null;
        return new AccessibilityNodeProviderCompat((Object)view);
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.unwrap());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        boolean bl;
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = AccessibilityDelegateCompat.getActionList(view);
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= list.size()) break;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = list.get(n2);
            if (accessibilityActionCompat.getId() == n) {
                bl = accessibilityActionCompat.perform(view, bundle);
                break;
            }
            ++n2;
        }
        bl2 = bl;
        if (!bl) {
            bl2 = bl;
            if (Build.VERSION.SDK_INT >= 16) {
                bl2 = this.mOriginalDelegate.performAccessibilityAction(view, n, bundle);
            }
        }
        bl = bl2;
        if (bl2) return bl;
        bl = bl2;
        if (n != R.id.accessibility_action_clickable_span) return bl;
        bl = this.performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
        return bl;
    }

    public void sendAccessibilityEvent(View view, int n) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, n);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
