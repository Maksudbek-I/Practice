package Practice.Practice_5;

public class MovableRectangle implements Movable {
    private int x1, x2, y1, y2, width, length;

    public MovableRectangle(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        if (x2 < x1)
            x1 = x1 ^ x2 ^ (x2 = x1);
        if (y2 > y1)
            y1 = y1 ^ y2 ^ (y2 = y1);
        width = y1 - y2;
        length = x2 - x1;
        MovablePoint upLeft = new MovablePoint(x1, y1);
        MovablePoint downRight = new MovablePoint(x2, y2);

    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        this.y2 = this.y1 - width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        this.x2 = x1 + length;
    }

    @Override
    public void Move(int right, int down) {
        this.y1 -= down;
        this.y2 -= down;
        this.x1 += right;
        this.x2 += right;

    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
