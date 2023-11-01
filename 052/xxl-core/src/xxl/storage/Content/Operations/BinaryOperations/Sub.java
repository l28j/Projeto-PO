package xxl.storage.Content.Operations.BinaryOperations;

import java.util.Map;
import xxl.storage.Cell;
import xxl.DesignPatterns.Visitor.Visitor;

/*
 * Class that represents a subtraction.
 */
public class Sub extends BinaryOperations {

    public Sub(String address ,String input, Map<String,Cell> cells) {
        setArguments(address,input,cells);
    }

    /**
     * Returns the value of the subtraction.
     * @param cells the cells of the spreadsheet.
     * @return the value of the subtraction.
    */
    @Override
    public String getValue(Map<String,Cell> cells) {
        resetInvalidoperation();
        setArgumentsInt(cells);
        
        if (getInvalidOperation() != null ) { return getInvalidOperation(); }    // if the subtraction is invalid, return #VALUE
        else {
            return String.valueOf(getResult_value_1() - getResult_value_2());
        }
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitSub(this);
    }

}
