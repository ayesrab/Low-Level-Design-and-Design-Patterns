package ChainOfResponsibilityDesignPattern;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }
    public void log(int logLevel, String msg){
        if (logLevel == ERROR){
            System.out.println("ERROR : " + msg);
        }
        else{
            this.nextLogger.log(logLevel,msg);
        }
    }
}
