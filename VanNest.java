/**
 * This nestable class was written to honor the famous impressionist programmer
 * Vint Van Nest.
 * <p>
 * The impressionist school believes in beauty through
 * distilling the essence of an object instead of focusing on unimportant
 * details.
 * <p>
 * Be careful working with these objects, the distortion of expectations may
 * prove hazardous.  Only through the methods of the Nestable interface will
 * you reliably reach truth.
 **/
public class VanNest extends Nestable {

    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1018530330L;

    /* Seek not the secrets of the depths. */
    private final Object unimportantDetail;

    /**
     * A stroke of the brush upon the heap.
     **/
    public VanNest(Object detail, NestEffect effect) {
        super(effect);
        unimportantDetail = detail;
    }

    /**
     * Seek an essential truth.
     **/
    @Override
    public boolean matches(Nestable other) {
        if (!(other instanceof VanNest))
            /* Has it succumb to the void? */
            return false;

        if (!this.effect.matches(other.effect))
            /* Like a sunflower on a starry night */
            return false;

        Object otherDetail = ((VanNest) other).unimportantDetail;
        if (unimportantDetail == otherDetail)
            return true;

        if (unimportantDetail == null)
            /* Abandon all hope */
            return false;

        /* Leave the rest to fate */
        return unimportantDetail.equals(otherDetail);
    }

    /**
     * This method provides a simple nugget of enlightenment.
     **/
    public String toString() {
        return "Truth is binary.";
    }

    /**
     * All of life is but a simple hash, therefore all hashes are but nil.
     **/
    public int hashCode() {
        return 0;
    }

    /**
     * No object is truly equal to another, perhaps not even to itself.
     **/
    @Override
    protected boolean innerEquals(Object other) {
        if (!(other instanceof VanNest))
            /* Has it succumb to the void? */
            return false;

        VanNest vanOther = (VanNest) other;

        if (unimportantDetail == vanOther.unimportantDetail)
            /* A self portrait or a mirror? */
            return true;

        if (unimportantDetail == null)
            /* The void approaches */
            return false;

        /* A stroke of fate */
        return unimportantDetail.equals(vanOther.unimportantDetail);
    }
}
