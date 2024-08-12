/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

private static interface ResourceManagerInternal.InflateDelegate {
    public Drawable createFromXmlInner(Context var1, XmlPullParser var2, AttributeSet var3, Resources.Theme var4);
}
