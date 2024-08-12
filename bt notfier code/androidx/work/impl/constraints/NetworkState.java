/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.constraints;

public class NetworkState {
    private boolean mIsConnected;
    private boolean mIsMetered;
    private boolean mIsNotRoaming;
    private boolean mIsValidated;

    public NetworkState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.mIsConnected = bl;
        this.mIsValidated = bl2;
        this.mIsMetered = bl3;
        this.mIsNotRoaming = bl4;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof NetworkState)) {
            return false;
        }
        object = (NetworkState)object;
        if (this.mIsConnected == ((NetworkState)object).mIsConnected && this.mIsValidated == ((NetworkState)object).mIsValidated && this.mIsMetered == ((NetworkState)object).mIsMetered && this.mIsNotRoaming == ((NetworkState)object).mIsNotRoaming) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        int n = this.mIsConnected ? 1 : 0;
        int n2 = n;
        if (this.mIsValidated) {
            n2 = n + 16;
        }
        n = n2;
        if (this.mIsMetered) {
            n = n2 + 256;
        }
        n2 = n;
        if (!this.mIsNotRoaming) return n2;
        n2 = n + 4096;
        return n2;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isMetered() {
        return this.mIsMetered;
    }

    public boolean isNotRoaming() {
        return this.mIsNotRoaming;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", this.mIsConnected, this.mIsValidated, this.mIsMetered, this.mIsNotRoaming);
    }
}
