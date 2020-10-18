package Practice.Practice_12;

public enum Colors {
    BLUE("\u001B[34m"),
    RED("\u001B[91m"),
    YELLOW("\u001B[93m");


    private final String code;

    Colors(String code) {
        this.code = code;
    }

    public String getColorCode() {
        return code;
    }
}
