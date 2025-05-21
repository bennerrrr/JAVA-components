package components.ErrorReport;

public class Error {
    
    
    private String errorMessage;
    private String errorType;
    private String errorLocation;
    private String errorTime;
    private String errorSeverity;
    private String errorCode;
    

    public enum ErrorType {
        SYNTAX_ERROR,
        RUNTIME_ERROR,
        LOGIC_ERROR,
        SEMANTIC_ERROR
    }
    public enum ErrorSeverity {
        LOW,
        MEDIUM,
        HIGH
    }

    public Error(String errorMessage, String errorType, String errorLocation, String errorTime) {
        this.errorMessage = errorMessage;
        this.errorType = errorType;
        this.errorLocation = errorLocation;
        this.errorTime = errorTime;
    }
    public Error(String errorMessage, String errorType, String errorLocation, String errorTime, String errorSeverity, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorType = errorType;
        this.errorLocation = errorLocation;
        this.errorTime = errorTime;
        this.errorSeverity = errorSeverity;
        this.errorCode = errorCode;
    }
    public String getErrorSeverity() {
        return errorSeverity;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String getErrorType() {
        return errorType;
    }
    
    public String getErrorLocation() {
        return errorLocation;
    }
    
    public String getErrorTime() {
        return errorTime;
    }

    public void setErrorSeverity(String errorSeverity) {
        this.errorSeverity = errorSeverity;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
    public void setErrorLocation(String errorLocation) {
        this.errorLocation = errorLocation;
    }
    public void setErrorTime(String errorTime) {
        this.errorTime = errorTime;
    }


    public void sendErrorReport(){

        // Code to send the error report to a server or log it
        // This could involve making an HTTP request or writing to a file
        // For now, we'll just print the error details to the console

        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m";
        final String BOLD = "\u001B[1m";
        final String UNDERLINE = "\u001B[4m";



        System.err.println(UNDERLINE +"*************************************************" + RESET);
        System.out.println( RED + "     "+ UNDERLINE + "****************Error Report************"+RESET+"    ");
        System.out.println(BOLD + "      Type: " + errorType);
        System.out.println();
        System.out.println("      Message: " + errorMessage);
        System.out.println();
        System.out.println("      Location: " + errorLocation);
        System.out.println(UNDERLINE+ "      Time: " + errorTime + "                   " + RESET);
        
        switch (errorSeverity) {
            case "LOW"    -> System.out.println(YELLOW + "                   Severity: " + errorSeverity+RESET);
            case "MEDIUM" -> System.out.println(CYAN + "                   Severity: " + errorSeverity +RESET);
            case "HIGH"   -> System.out.println(BOLD + RED + "                   Severity: " + errorSeverity +RESET);
            default       -> System.out.println("                   Severity: " + errorSeverity);
        }

        System.out.println("                   Code: " + errorCode);
        System.err.println("****************************************************");

    }

}
