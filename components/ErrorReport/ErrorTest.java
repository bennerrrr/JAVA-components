package components.ErrorReport;

public class ErrorTest {
    

    public static void main(String[] args) {
        // Create an instance of the Error class
        Error error = new Error("Null Pointer Exception", "RUNTIME_ERROR", "Line 42", "2023-10-01 12:00:00", "HIGH", "ERR001");
        
        error.sendErrorReport();

        


    }
}
