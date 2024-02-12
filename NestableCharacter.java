import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NestableCharacter extends Nestable {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 184829138437L;

    private static final char[][] syntaxPairs = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
    private static final Map<Character, Character> mSyntaxPairs = new HashMap<>();
    private static final Map<Character, NestEffect> charType = new HashMap<>();

    /*
     * populate the lookup tables for pairing and effects
     */
    static {
        for (char[] pair : syntaxPairs) {
            charType.put(pair[0], NestEffect.OPEN);
            charType.put(pair[1], NestEffect.CLOSE);
            mSyntaxPairs.put(pair[0], pair[1]);
            mSyntaxPairs.put(pair[1], pair[0]);
        }
    }

    /**
     * The character value represented by this NestableCharacter
     */
    final char value;

    /**
     * Constructs an immutable NestableCharacter whose value is initialized to c and whose nesting effect
     * is initialized to OPEN if it's one of ([{, CLOSE if it's one of )]}, otherwise NEUTRAL
     *
     * @param c The character to be represented by this NestableCharacter
     */
    public NestableCharacter(char c) {
        super(charType.getOrDefault(c, NestEffect.NEUTRAL));
        value = c;
    }

    /**
     * This constructor is for compatibility with input stream reading, which produces a stream of ints
     *
     * @param i The int given by an input stream
     */
    public NestableCharacter(int i) {
        this((char) i);
    }

    /**
     * A NestableCharacter matches another NestableCharacter if they have matching (i.e. inverse)
     * effects (OPEN+CLOSE or CLOSE+OPEN) and their characters are complementary as defined in
     * mSyntaxPairs.
     *
     * @param other The other Nestable object
     * @return True if other is NestableCharacter, has a matching effect, and has a complementary value
     */
    @Override
    public boolean matches(Nestable other) {
        if (other == null || !(other instanceof NestableCharacter) || !this.effect.matches(other.effect))
            return false;

        var otherValue = ((NestableCharacter) other).value;
        return value == mSyntaxPairs.getOrDefault(otherValue, otherValue);
    }

    @Override
    protected boolean innerEquals(Object other) {
        return other instanceof NestableCharacter && value == ((NestableCharacter) other).value;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }

    @Override
    public String toString() {
        return "'" + value + "':" + effect;
    }

    /**
     * This function reads a file into a Queue of NestableCharacter
     */
    public static Queue<NestableCharacter> getNestableCharactersFromFile(String filename) throws IOException {
        Queue<NestableCharacter> out = new LinkedList<>();
        FileReader in = new FileReader(filename);

        while (in.ready())
            out.add(new NestableCharacter(in.read()));
        in.close();

        return out;
    }
}
