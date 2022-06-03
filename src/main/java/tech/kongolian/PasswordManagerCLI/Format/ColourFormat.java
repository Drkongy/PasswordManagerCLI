package tech.kongolian.PasswordManagerCLI.Format;

public class ColourFormat {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static final String ANSI_BOLD = "\u001B[1m";
    private static final String ANSI_UNDERLINE = "\u001B[4m";
    private static final String ANSI_BLINK = "\u001B[5m";
    private static final String ANSI_REVERSE = "\u001B[7m";
    private static final String ANSI_HIDDEN = "\u001B[8m";

    private static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
    private static final String ANSI_BRIGHT_RED = "\u001B[91m";
    private static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    private static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    private static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    private static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    private static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    private static final String ANSI_BRIGHT_WHITE = "\u001B[97m";

    private static final String ANSI_BRIGHT_BLACK_BACKGROUND = "\u001B[100m";
    private static final String ANSI_BRIGHT_RED_BACKGROUND = "\u001B[101m";
    private static final String ANSI_BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    private static final String ANSI_BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    private static final String ANSI_BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    private static final String ANSI_BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
    private static final String ANSI_BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    private static final String ANSI_BRIGHT_WHITE_BACKGROUND = "\u001B[107m";

    public ColourFormat() {

    }

    public void test() {
        System.out.println("this is a test");
    }

    public String ANSI_RED(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    public String ANSI_GREEN(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    public String ANSI_YELLOW(String text) {
        return ANSI_YELLOW + text + ANSI_RESET;
    }

    public String ANSI_BLUE(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }

    public String ANSI_PURPLE(String text) {
        return ANSI_PURPLE + text + ANSI_RESET;
    }

    public String ANSI_CYAN(String text) {
        return ANSI_CYAN + text + ANSI_RESET;
    }

    public String ANSI_WHITE(String text) {
        return ANSI_WHITE + text + ANSI_RESET;
    }

    public String ANSI_BLACK(String text) {
        return ANSI_BLACK + text + ANSI_RESET;
    }

    public String ANSI_BOLD(String text) {
        return ANSI_BOLD + text + ANSI_RESET;
    }

    public String ANSI_UNDERLINE(String text) {
        return ANSI_UNDERLINE + text + ANSI_RESET;
    }

    public String ANSI_BLINK(String text) {
        return ANSI_BLINK + text + ANSI_RESET;
    }

    public String ANSI_REVERSE(String text) {
        return ANSI_REVERSE + text + ANSI_RESET;
    }

    public String ANSI_HIDDEN(String text) {
        return ANSI_HIDDEN + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_RED(String text) {
        return ANSI_BRIGHT_RED + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_GREEN(String text) {
        return ANSI_BRIGHT_GREEN + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_YELLOW(String text) {
        return ANSI_BRIGHT_YELLOW + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_BLUE(String text) {
        return ANSI_BRIGHT_BLUE + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_PURPLE(String text) {
        return ANSI_BRIGHT_PURPLE + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_CYAN(String text) {
        return ANSI_BRIGHT_CYAN + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_WHITE(String text) {
        return ANSI_BRIGHT_WHITE + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_BLACK(String text) {
        return ANSI_BRIGHT_BLACK + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_RED_BACKGROUND(String text) {
        return ANSI_BRIGHT_RED_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_GREEN_BACKGROUND(String text) {
        return ANSI_BRIGHT_GREEN_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_YELLOW_BACKGROUND(String text) {
        return ANSI_BRIGHT_YELLOW_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_BLUE_BACKGROUND(String text) {
        return ANSI_BRIGHT_BLUE_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_PURPLE_BACKGROUND(String text) {
        return ANSI_BRIGHT_PURPLE_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_CYAN_BACKGROUND(String text) {
        return ANSI_BRIGHT_CYAN_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_WHITE_BACKGROUND(String text) {
        return ANSI_BRIGHT_WHITE_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BRIGHT_BLACK_BACKGROUND(String text) {
        return ANSI_BRIGHT_BLACK_BACKGROUND + text + ANSI_RESET;
    }

    // setters for backgrounds

    public String ANSI_BLACK_BACKGROUND(String text) {
        return ANSI_BLACK_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_RED_BACKGROUND(String text) {
        return ANSI_RED_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_GREEN_BACKGROUND(String text) {
        return ANSI_GREEN_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_YELLOW_BACKGROUND(String text) {
        return ANSI_YELLOW_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_BLUE_BACKGROUND(String text) {
        return ANSI_BLUE_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_PURPLE_BACKGROUND(String text) {
        return ANSI_PURPLE_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_CYAN_BACKGROUND(String text) {
        return ANSI_CYAN_BACKGROUND + text + ANSI_RESET;
    }

    public String ANSI_WHITE_BACKGROUND(String text) {
        return ANSI_WHITE_BACKGROUND + text + ANSI_RESET;
    }

}
