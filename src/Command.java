public record Command(String direction, int step) {
    public Command(String direction, int step) {
        this.direction = direction;
        this.step = step;
    }
}
