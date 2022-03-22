package co.com.sofka.util;

public enum UpDateKey {
    NAME("[name]"),
    JOB("[job]");

    private final String value;

    UpDateKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

