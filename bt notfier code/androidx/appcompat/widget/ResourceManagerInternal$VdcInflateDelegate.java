/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

private static class ResourceManagerInternal.VdcInflateDelegate
implements ResourceManagerInternal.InflateDelegate {
    ResourceManagerInternal.VdcInflateDelegate() {
    }

    public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            context = VectorDrawableCompat.createFromXmlInner((Resources)context.getResources(), (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
            return context;
        }
        catch (Exception exception) {
            Log.e((String)"VdcInflateDelegate", (String)"Exception while inflating <vector>", (Throwable)exception);
            return null;
        }
    }
}
