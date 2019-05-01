package user;


public enum UserKind {
    STANDARD (0),
    VIP (1),
    EXECUTIVO (2);

    private int kind;

    UserKind(int kind) {
        this.kind = kind;
    }

    public int getKind() {
        return this.kind;
    }
}