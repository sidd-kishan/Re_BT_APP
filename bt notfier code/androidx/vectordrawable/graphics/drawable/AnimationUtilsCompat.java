/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.os.Build$VERSION
 *  android.util.Xml
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AnimationUtils
 *  android.view.animation.AnticipateInterpolator
 *  android.view.animation.AnticipateOvershootInterpolator
 *  android.view.animation.BounceInterpolator
 *  android.view.animation.CycleInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  android.view.animation.OvershootInterpolator
 *  androidx.interpolator.view.animation.FastOutLinearInInterpolator
 *  androidx.interpolator.view.animation.FastOutSlowInInterpolator
 *  androidx.interpolator.view.animation.LinearOutSlowInInterpolator
 *  androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    private static Interpolator createInterpolatorFromXml(Context object, Resources object2, Resources.Theme object3, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n = xmlPullParser.getDepth();
        object2 = null;
        while (true) {
            int n2;
            if ((n2 = xmlPullParser.next()) == 3) {
                if (xmlPullParser.getDepth() <= n) return object2;
            }
            if (n2 == 1) return object2;
            if (n2 != 2) continue;
            object3 = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
            object2 = xmlPullParser.getName();
            if (((String)object2).equals("linearInterpolator")) {
                object2 = new LinearInterpolator();
                continue;
            }
            if (((String)object2).equals("accelerateInterpolator")) {
                object2 = new AccelerateInterpolator((Context)object, (AttributeSet)object3);
                continue;
            }
            if (((String)object2).equals("decelerateInterpolator")) {
                object2 = new DecelerateInterpolator((Context)object, (AttributeSet)object3);
                continue;
            }
            if (((String)object2).equals("accelerateDecelerateInterpolator")) {
                object2 = new AccelerateDecelerateInterpolator();
                continue;
            }
            if (((String)object2).equals("cycleInterpolator")) {
                object2 = new CycleInterpolator((Context)object, (AttributeSet)object3);
                continue;
            }
            if (((String)object2).equals("anticipateInterpolator")) {
                object2 = new AnticipateInterpolator((Context)object, (AttributeSet)object3);
                continue;
            }
            if (((String)object2).equals("overshootInterpolator")) {
                object2 = new OvershootInterpolator((Context)object, (AttributeSet)object3);
                continue;
            }
            if (((String)object2).equals("anticipateOvershootInterpolator")) {
                object2 = new AnticipateOvershootInterpolator((Context)object, (AttributeSet)object3);
                continue;
            }
            if (((String)object2).equals("bounceInterpolator")) {
                object2 = new BounceInterpolator();
                continue;
            }
            if (!((String)object2).equals("pathInterpolator")) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown interpolator name: ");
                ((StringBuilder)object).append(xmlPullParser.getName());
                throw new RuntimeException(((StringBuilder)object).toString());
            }
            object2 = new PathInterpolatorCompat((Context)object, (AttributeSet)object3, xmlPullParser);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Interpolator loadInterpolator(Context object, int n) throws Resources.NotFoundException {
        Throwable throwable;
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator((Context)object, (int)n);
        }
        Object object2 = null;
        XmlResourceParser xmlResourceParser = null;
        Object object3 = null;
        if (n == 17563663) {
            try {
                return new FastOutLinearInInterpolator();
            }
            catch (IOException iOException) {}
            catch (XmlPullParserException xmlPullParserException) {}
            finally {
            }
        } else {
            if (n == 17563661) {
                return new FastOutSlowInInterpolator();
            }
            if (n == 17563662) {
                return new LinearOutSlowInInterpolator();
            }
            XmlResourceParser xmlResourceParser2 = object.getResources().getAnimation(n);
            object3 = xmlResourceParser2;
            object2 = xmlResourceParser2;
            xmlResourceParser = xmlResourceParser2;
            object = AnimationUtilsCompat.createInterpolatorFromXml((Context)object, object.getResources(), object.getTheme(), xmlResourceParser2);
            if (xmlResourceParser2 == null) return object;
            xmlResourceParser2.close();
            return object;
        }
        if (object3 == null) throw throwable;
        object3.close();
        throw throwable;
    }
}
