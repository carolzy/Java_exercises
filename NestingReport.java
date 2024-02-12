import java.util.Objects;
import java.util.Stack;

/**
 * NestingReport indicates whether the input was correctly nested (valid) and
 * additional state to provide details when the input is not valid.
 */
public class NestingReport {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 679233489923471L;

    public enum Status {
        VALID, NULL_INPUT, NULL_ITEM, INVALID_CLOSE, NOT_TERMINATED
    }

    private final Status status; // non-nullable
    private final Nestable badItem; // nullable
    private final Stack<? extends Nestable> stackState; // nullable

    /**
     * Constructs an immutable NestingReport, a data class, using the given parameters
     *
     * @param status     One of VALID, NULL_INPUT, NULL_ITEM, INVALID_CLOSE, or NOT_TERMINATED
     * @param badItem    If status is INVALID_CLOSE, badItem is the Nestable item that attempted to perform the invalid
     *                   closing; if status is anything else, set to null
     * @param stackState The current state of the stack at the moment of generating this report (if applicable: not
     *                   including the badItem). Do not set to null.
     */
    public NestingReport(Status status, Nestable badItem, Stack<? extends Nestable> stackState) {
        if (status == null)
            throw new IllegalArgumentException("null enum supplied as argument to NestingReport");
        this.status = status;
        this.badItem = badItem;
        this.stackState = stackState;
    }

    public Status getStatus() {
        return status;
    }

    public Nestable getBadItem() {
        return badItem;
    }

    public Stack<? extends Nestable> getStackState() {
        return stackState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NestingReport that = (NestingReport) o;
        return status == that.status && Objects.equals(badItem, that.badItem) && Objects.equals(stackState, that.stackState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, badItem, stackState);
    }

    @Override
    public String toString() {
        return "NestingReport{" +
                "status=" + status +
                ", badItem=" + badItem +
                ", stackState=" + stackState +
                '}';
    }
}
