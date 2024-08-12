/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 */
package androidx.coordinatorlayout.widget;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@Retention(value=RetentionPolicy.RUNTIME)
public static @interface CoordinatorLayout.DefaultBehavior {
    public Class<? extends CoordinatorLayout.Behavior> value();
}
