package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("x = " + x + " y = " + y);
    }

    public void set(float a, float b) {
        this.x = a;
        this.y = b;
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public void addUp(float a, float b) {
        this.x += a;
        this.y += b;
    }

    public void addUp(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    public Vector2D add(float a, float b) {
        return new Vector2D(this.x + a, this.y + b);
    }

    public void subtractBy(float a, float b) {
        this.x -= a;
        this.y -= b;
    }

    public void subtractBy(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public Vector2D subtract(float a, float b) {
        return new Vector2D(this.x - a, this.y - b);
    }

    public Vector2D multiply(float a) {
        return new Vector2D(this.x * a, this.y * a);
    }

    public double length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
