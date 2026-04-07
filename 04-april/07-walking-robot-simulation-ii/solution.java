class Robot {
    private final int width;
    private final int height;
    private final int perimeter;
    private int index;
    private boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
        this.index = 0;
        this.moved = false;
    }

    public void step(int num) {
        moved = true;
        int steps = num % perimeter;
        if (steps == 0) {
            steps = perimeter;
        }
        index = (index + steps) % perimeter;
    }

    public int[] getPos() {
        return new int[] {getX(), getY()};
    }

    public String getDir() {
        if (index == 0) {
            return moved ? "South" : "East";
        }
        if (index < width) {
            return "East";
        }
        if (index < width + height - 1) {
            return "North";
        }
        if (index < 2 * width + height - 2) {
            return "West";
        }
        return "South";
    }

    private int getX() {
        if (index < width) {
            return index;
        }
        if (index < width + height - 1) {
            return width - 1;
        }
        if (index < 2 * width + height - 2) {
            return 2 * width + height - 3 - index;
        }
        return 0;
    }

    private int getY() {
        if (index < width) {
            return 0;
        }
        if (index < width + height - 1) {
            return index - width + 1;
        }
        if (index < 2 * width + height - 2) {
            return height - 1;
        }
        return perimeter - index;
    }
}
