/*
 * Author: Rafi Rubin
 */
public abstract class Nestable {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 294891280812308L;

    /**
     * A Nestable object can either OPEN a new nesting context, CLOSE an existing
     * nesting context, or have a NEUTRAL effect (i.e. no effect) on the nesting
     * context. OPEN matches to CLOSE, CLOSE matches to OPEN, and NEUTRAL
     * matches to NEUTRAL; no other combination matches.
     */
    public enum NestEffect {
        OPEN, NEUTRAL, CLOSE;

        /**
         * a matches b only if a closes b or b closes a
         *
         * @param e the other NestEffect
         * @return true if this effect closes e or vice versa
         */
        public boolean matches(NestEffect e) {
            if (e == null) throw new NullPointerException();
            switch (e) {
                case OPEN:
                    return this == CLOSE;
                case CLOSE:
                    return this == OPEN;
                case NEUTRAL:
                    return this == NEUTRAL;
                default:
                    return false;
            }
        }
    }

    /**
     * The effect of this Nestable element on the current nesting context.
     * Non-nullable; defaults to NEUTRAL.
     */
    protected final NestEffect effect;

    /**
     * Constructs an immutable Nestable object. Implementations of Nestable must first call
     * super(effect). Attempting to make effect null will result in an IllegalArgumentException.
     *
     * @param effect The non-null nesting effect with which to initialize this Nestable
     * @throws IllegalArgumentException when the supplied effect is null
     */
    public Nestable(NestEffect effect) {
        if (effect == null)
            throw new IllegalArgumentException("null enum supplied as effect argument to Nestable");
        this.effect = effect;
    }

    public NestEffect getEffect() {
        return this.effect;
    }

    /* Implementations of Nestable must define a matches function that should first verify
     * if NestEffect.matches returns true on their effects, and then performs some other
     * implementation-specific matching logic.
     */
    public abstract boolean matches(Nestable other);

    /* Equality-checking logic shared between all implementations of Nestable.
     */
    @Override
    public final boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!effect.equals(((Nestable) other).effect)) return false;
        return innerEquals(other);
    }

    /* Implementations of Nestable must provide implementation-specific
     * equality-checking by overriding innerEquals.
     */
    protected abstract boolean innerEquals(Object other);
}
