public class Rectangle {
    public int x;
    public int y;
    public int width;
    public int height;

    public Rectangle (int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public static boolean checkRectangleOverlap (Rectangle a, Rectangle b) {
        return !(a.x > b.x + b.width && a.y + a.height < b.y && a.x > b.x + b.width && a.y > b.y + b.height);
    }
}
