package co.com.sofka.util;

public enum RegisterKey {
    EMAIL("[email]"),
    PASSWORD("[password]");

    private final String value;

    RegisterKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
