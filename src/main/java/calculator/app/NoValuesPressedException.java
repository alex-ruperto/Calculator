package calculator.app;
//custom exception for when no values are entered into the calculator and user selects an operation button.
public class NoValuesPressedException extends Exception{
    public NoValuesPressedException(String message){
        super(message);
    }

}
