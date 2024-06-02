package MyHTM.htmMaker.Service;

public class DataBaseOperationResult {
    private boolean operationDone;
    private String message;

    public DataBaseOperationResult(boolean success, String message) {
        this.operationDone = success;
        this.message = message;
    }

    public boolean isOperationDone() {
        return operationDone;
    }

    public String getMessage() {
        return message;
    }

}
