package chapter_Iv

/**
 * Chapter 4, Task 17, page 161
 */
interface Blender {

    /**
     * @invariant getSpeed() > 0
     *            implies isFull()
     * @invariant getSpeed() >= 0
     *            && getSpeed() < 10
     */

    fun getSpeed(): Int

    /**
     * @pre Math.abs(getSpeed() - x) <= 1
     * @pre x > 0 && x <10
     * @post getSpeed() == x
     */
    fun setSpeed(x: Int)

    fun isFull(): Boolean

    /**
     * @pre !isFull()
     * @post isFull()
     */
    fun fill()

    /**
     * @pre isFull()
     * @post !isFull()
     */
    fun empty()
}
