/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.util.Xml
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyAttributes
 *  androidx.constraintlayout.motion.widget.KeyCycle
 *  androidx.constraintlayout.motion.widget.KeyPosition
 *  androidx.constraintlayout.motion.widget.KeyTimeCycle
 *  androidx.constraintlayout.motion.widget.KeyTrigger
 *  androidx.constraintlayout.motion.widget.MotionController
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)TAG, (String)"unable to load", (Throwable)noSuchMethodException);
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Key key = null;
        try {
            int n = xmlPullParser.getEventType();
            while (n != 1) {
                Key key2;
                if (n != 2) {
                    if (n != 3) {
                        key2 = key;
                    } else {
                        key2 = key;
                        if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    }
                } else {
                    Object object = xmlPullParser.getName();
                    boolean bl = sKeyMakers.containsKey(object);
                    if (bl) {
                        block19: {
                            block18: {
                                try {
                                    key2 = sKeyMakers.get(object).newInstance(new Object[0]);
                                }
                                catch (Exception exception) {
                                    object = exception;
                                    break block18;
                                }
                                try {
                                    key2.load(context, Xml.asAttributeSet((XmlPullParser)xmlPullParser));
                                    this.addKey(key2);
                                    key = key2;
                                    break block19;
                                }
                                catch (Exception exception) {
                                    key = key2;
                                }
                            }
                            Log.e((String)TAG, (String)"unable to create ", (Throwable)object);
                        }
                        key2 = key;
                    } else {
                        key2 = key;
                        if (((String)object).equalsIgnoreCase("CustomAttribute")) {
                            key2 = key;
                            if (key != null) {
                                key2 = key;
                                if (key.mCustomConstraints != null) {
                                    ConstraintAttribute.parse((Context)context, (XmlPullParser)xmlPullParser, (HashMap)key.mCustomConstraints);
                                    key2 = key;
                                }
                            }
                        }
                    }
                }
                n = xmlPullParser.next();
                key = key2;
            }
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (XmlPullParserException xmlPullParserException) {
            xmlPullParserException.printStackTrace();
        }
    }

    private void addKey(Key key) {
        if (!this.mFramesMap.containsKey(key.mTargetId)) {
            this.mFramesMap.put(key.mTargetId, new ArrayList());
        }
        this.mFramesMap.get(key.mTargetId).add(key);
    }

    static String name(int n, Context context) {
        return context.getResources().getResourceEntryName(n);
    }

    public void addFrames(MotionController motionController) {
        Key key = this.mFramesMap.get(motionController.mId);
        if (key != null) {
            motionController.addKeys(key);
        }
        if ((key = this.mFramesMap.get(-1)) == null) return;
        Iterator<Key> iterator = key.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            if (!key.matches(((ConstraintLayout.LayoutParams)motionController.mView.getLayoutParams()).constraintTag)) continue;
            motionController.addKey(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int n) {
        return this.mFramesMap.get(n);
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
