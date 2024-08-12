/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase
 */
package androidx.camera.core;

import androidx.camera.core.UseCase;

public static interface UseCase.StateChangeCallback {
    public void onUseCaseActive(UseCase var1);

    public void onUseCaseInactive(UseCase var1);

    public void onUseCaseReset(UseCase var1);

    public void onUseCaseUpdated(UseCase var1);
}
