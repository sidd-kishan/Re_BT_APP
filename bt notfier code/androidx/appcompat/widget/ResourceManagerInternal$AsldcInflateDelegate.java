/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat
 *  androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.widget.ResourceManagerInternal;
import org.xmlpull.v1.XmlPullParser;

static class ResourceManagerInternal.AsldcInflateDelegate
implements ResourceManagerInternal.InflateDelegate {
    ResourceManagerInternal.AsldcInflateDelegate() {
    }

    public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            context = AnimatedStateListDrawableCompat.createFromXmlInner((Context)context, (Resources)context.getResources(), (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
            return context;
        }
        catch (Exception exception) {
            Log.e((String)"AsldcInflateDelegate", (String)"Exception while inflating <animated-selector>", (Throwable)exception);
            return null;
        }
    }
}
