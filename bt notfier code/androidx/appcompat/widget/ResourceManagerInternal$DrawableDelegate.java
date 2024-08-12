/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.ResourceManagerInternal;
import org.xmlpull.v1.XmlPullParser;

static class ResourceManagerInternal.DrawableDelegate
implements ResourceManagerInternal.InflateDelegate {
    ResourceManagerInternal.DrawableDelegate() {
    }

    public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String string = attributeSet.getClassAttribute();
        if (string == null) return null;
        try {
            string = ResourceManagerInternal.DrawableDelegate.class.getClassLoader().loadClass(string).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (Build.VERSION.SDK_INT >= 21) {
                string.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
            } else {
                string.inflate(context.getResources(), xmlPullParser, attributeSet);
            }
            return string;
        }
        catch (Exception exception) {
            Log.e((String)"DrawableDelegate", (String)"Exception while inflating <drawable>", (Throwable)exception);
        }
        return null;
    }
}
