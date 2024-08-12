/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets$Type
 */
package androidx.core.view;

import android.view.WindowInsets;

private static final class WindowInsetsCompat.TypeImpl30 {
    private WindowInsetsCompat.TypeImpl30() {
    }

    static int toPlatformType(int n) {
        int n2 = 0;
        int n3 = 1;
        while (n3 <= 256) {
            int n4;
            block1: {
                block10: {
                    block2: {
                        block3: {
                            block4: {
                                block5: {
                                    block6: {
                                        block7: {
                                            block8: {
                                                block9: {
                                                    n4 = n2;
                                                    if ((n & n3) == 0) break block1;
                                                    if (n3 == 1) break block2;
                                                    if (n3 == 2) break block3;
                                                    if (n3 == 4) break block4;
                                                    if (n3 == 8) break block5;
                                                    if (n3 == 16) break block6;
                                                    if (n3 == 32) break block7;
                                                    if (n3 == 64) break block8;
                                                    if (n3 == 128) break block9;
                                                    n4 = n2;
                                                    break block1;
                                                }
                                                n4 = WindowInsets.Type.displayCutout();
                                                break block10;
                                            }
                                            n4 = WindowInsets.Type.tappableElement();
                                            break block10;
                                        }
                                        n4 = WindowInsets.Type.mandatorySystemGestures();
                                        break block10;
                                    }
                                    n4 = WindowInsets.Type.systemGestures();
                                    break block10;
                                }
                                n4 = WindowInsets.Type.ime();
                                break block10;
                            }
                            n4 = WindowInsets.Type.captionBar();
                            break block10;
                        }
                        n4 = WindowInsets.Type.navigationBars();
                        break block10;
                    }
                    n4 = WindowInsets.Type.statusBars();
                }
                n4 = n2 | n4;
            }
            n3 <<= 1;
            n2 = n4;
        }
        return n2;
    }
}
