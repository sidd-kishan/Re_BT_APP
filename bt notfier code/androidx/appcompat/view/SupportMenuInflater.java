/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.view.Menu
 *  android.view.MenuInflater
 *  androidx.appcompat.view.SupportMenuInflater$MenuState
 */
package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.view.SupportMenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater
extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    static {
        Class[] classArray = new Class[]{Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = classArray;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = classArray;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objectArray = new Object[]{context};
        this.mActionViewConstructorArguments = objectArray;
        this.mActionProviderConstructorArguments = objectArray;
    }

    private Object findRealOwner(Object object) {
        if (object instanceof Activity) {
            return object;
        }
        Object object2 = object;
        if (!(object instanceof ContextWrapper)) return object2;
        object2 = this.findRealOwner(((ContextWrapper)object).getBaseContext());
        return object2;
    }

    private void parseMenu(XmlPullParser object, AttributeSet attributeSet, Menu object2) throws XmlPullParserException, IOException {
        int n;
        MenuState menuState = new MenuState(this, (Menu)object2);
        int n2 = object.getEventType();
        do {
            if (n2 == 2) {
                object2 = object.getName();
                if (!((String)object2).equals(XML_MENU)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Expecting menu, got ");
                    ((StringBuilder)object).append((String)object2);
                    throw new RuntimeException(((StringBuilder)object).toString());
                }
                n = object.next();
                break;
            }
            n2 = n = object.next();
        } while (n != 1);
        Object object3 = null;
        n2 = 0;
        int n3 = 0;
        while (n2 == 0) {
            int n4;
            if (n == 1) throw new RuntimeException("Unexpected end of document");
            if (n != 2) {
                if (n != 3) {
                    n4 = n2;
                    n = n3;
                    object2 = object3;
                } else {
                    String string = object.getName();
                    if (n3 != 0 && string.equals(object3)) {
                        object2 = null;
                        n = 0;
                        n4 = n2;
                    } else if (string.equals(XML_GROUP)) {
                        menuState.resetGroup();
                        n4 = n2;
                        n = n3;
                        object2 = object3;
                    } else if (string.equals(XML_ITEM)) {
                        n4 = n2;
                        n = n3;
                        object2 = object3;
                        if (!menuState.hasAddedItem()) {
                            if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                                menuState.addSubMenuItem();
                                n4 = n2;
                                n = n3;
                                object2 = object3;
                            } else {
                                menuState.addItem();
                                n4 = n2;
                                n = n3;
                                object2 = object3;
                            }
                        }
                    } else {
                        n4 = n2;
                        n = n3;
                        object2 = object3;
                        if (string.equals(XML_MENU)) {
                            n4 = 1;
                            n = n3;
                            object2 = object3;
                        }
                    }
                }
            } else if (n3 != 0) {
                n4 = n2;
                n = n3;
                object2 = object3;
            } else {
                object2 = object.getName();
                if (((String)object2).equals(XML_GROUP)) {
                    menuState.readGroup(attributeSet);
                    n4 = n2;
                    n = n3;
                    object2 = object3;
                } else if (((String)object2).equals(XML_ITEM)) {
                    menuState.readItem(attributeSet);
                    n4 = n2;
                    n = n3;
                    object2 = object3;
                } else if (((String)object2).equals(XML_MENU)) {
                    this.parseMenu((XmlPullParser)object, attributeSet, (Menu)menuState.addSubMenuItem());
                    n4 = n2;
                    n = n3;
                    object2 = object3;
                } else {
                    n = 1;
                    n4 = n2;
                }
            }
            int n5 = object.next();
            n2 = n4;
            n3 = n;
            object3 = object2;
            n = n5;
        }
    }

    Object getRealOwner() {
        if (this.mRealOwner != null) return this.mRealOwner;
        this.mRealOwner = this.findRealOwner(this.mContext);
        return this.mRealOwner;
    }

    /*
     * Exception decompiling
     */
    public void inflate(int var1_1, Menu var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [6 : 80->126)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}
