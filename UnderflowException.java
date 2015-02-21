/**
 * An Exception to be used with the Queue hierarchy.
 * 
 * @@author Hank Etlinger
 * @@author Lois Rixner
 */

public class UnderflowException  extends Exception {

    /**
     * The constructor for this exception
     *
     * @@param message the detailed message associated with this exception.
     */

    public UnderflowException( String message ) {
        super( message );
    }

} // UnderflowException