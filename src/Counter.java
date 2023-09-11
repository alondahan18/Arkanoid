//Alon Dahan 215314303

/**
 * Class for the counter object.
 */
public class Counter {
    private int count;

    /**
     * The constructor for the counter object.
     */
    public Counter() {
        this.count = 0;
    }
    // add number to current count.

    /**
     * Increasing the value that is counted.
     * @param number the increased amount.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }
    // subtract number from current count.

    /**
     * Deacrising the value that is counted.
     * @param number the decreased amount.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }
    // get current count.

    /**
     * Getting the counted value.
     * @return the counted value
     */
    public int getValue() {
        return count;
    }
}
