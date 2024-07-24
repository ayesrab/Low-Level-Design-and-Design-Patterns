package ChainOfResponsibilityDesignPattern;

public class Main {
    public static void main(String[] args) {
        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
        logger.log(Logger.INFO, "INFO");
        logger.log(Logger.DEBUG, "DEBUG");
        logger.log(Logger.ERROR, "ERROR");
    }
}
