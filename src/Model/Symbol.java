package Model;

public class Symbol {
    private Character symbol;
    private String avatar;

    public Symbol(Character symbol, String avatar) {
        this.symbol = symbol;
        this.avatar = avatar;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
