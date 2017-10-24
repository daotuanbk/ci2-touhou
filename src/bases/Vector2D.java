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
    public void set(Vector2D v) {
        this.set(v.x, v.y);
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public void addUp(float a, float b) {
        this.x += a;
        this.y += b;
    }

    public void addUp(Vector2D v) {
        this.addUp(v.x, v.y);
    }

    public Vector2D add(Vector2D v) {
        return this.add(v.x, v.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D v) {
        this.subtractBy(v.x, v.y);
    }

    public Vector2D subtract(Vector2D v) {
        return this.subtract(v.x, v.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D multiply(float x) {
        return new Vector2D(this.x * x, this.y * x);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize () {
        float length = length();
        return new Vector2D(this.x/length, this.y/length);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
