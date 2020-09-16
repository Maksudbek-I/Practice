package Practice.Practice_2;

public class Shape {
    private int width, length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }


}
