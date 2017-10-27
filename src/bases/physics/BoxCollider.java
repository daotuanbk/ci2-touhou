package bases.physics;

import bases.Vector2D;

public class BoxCollider {
    public Vector2D postition;

    public float width;
    public float height;
    public BoxCollider(float width, float height) {
        postition = new Vector2D();
        this.width = width;
        this.height = height;
    }
    public float left () {
        return postition.x - width/2;
    }
    public float right () {
        return  postition.x + width/2;
    }
    public float top () {
        return  postition.y - height/2;
    }
    public float bot () {
        return  postition.y + height/2;
    }

    public boolean collideWith (BoxCollider other) {
        return ((other.right() >= this.left() && other.left() <= this.right()) && (other.bot() >= this.top() && other.top() <= this.bot()) );
    }
}
