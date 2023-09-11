//Alon Dahan 215314303

/**
 * Class for the block remover listener.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * The constructor for the block remover.
     * @param gameLevel the game.
     * @param removedBlocks the amount of remaining blocks (mistake in the signature)
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        remainingBlocks.decrease(1);
    }
}
