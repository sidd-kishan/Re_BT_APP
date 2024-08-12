/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

static final class AdapterHelper.UpdateOp {
    static final int ADD = 1;
    static final int MOVE = 8;
    static final int POOL_SIZE = 30;
    static final int REMOVE = 2;
    static final int UPDATE = 4;
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;

    AdapterHelper.UpdateOp(int n, int n2, int n3, Object object) {
        this.cmd = n;
        this.positionStart = n2;
        this.itemCount = n3;
        this.payload = object;
    }

    String cmdToString() {
        int n = this.cmd;
        if (n == 1) return "add";
        if (n == 2) return "rm";
        if (n == 4) return "up";
        if (n == 8) return "mv";
        return "??";
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AdapterHelper.UpdateOp)) {
            return false;
        }
        AdapterHelper.UpdateOp updateOp = (AdapterHelper.UpdateOp)object;
        int n = this.cmd;
        if (n != updateOp.cmd) {
            return false;
        }
        if (n == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
            return true;
        }
        if (this.itemCount != updateOp.itemCount) {
            return false;
        }
        if (this.positionStart != updateOp.positionStart) {
            return false;
        }
        object = this.payload;
        if (object != null) {
            if (object.equals(updateOp.payload)) return true;
            return false;
        }
        if (updateOp.payload == null) return true;
        return false;
    }

    public int hashCode() {
        return (this.cmd * 31 + this.positionStart) * 31 + this.itemCount;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("[");
        stringBuilder.append(this.cmdToString());
        stringBuilder.append(",s:");
        stringBuilder.append(this.positionStart);
        stringBuilder.append("c:");
        stringBuilder.append(this.itemCount);
        stringBuilder.append(",p:");
        stringBuilder.append(this.payload);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
