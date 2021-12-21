public class LanternFish {
    private int timer;

    public LanternFish(int timer) {
        this.timer = timer;
    }

    public LanternFish() {
        this.timer = 9;
    }

    public int getTimer() {
        return timer;
    }

    public void resetTimer() {
        this.timer = 6;
    }

    public void decreaseTimer() {
        timer--;
    }

    @Override
    public String toString() {
        return String.valueOf(timer);
    }
}
