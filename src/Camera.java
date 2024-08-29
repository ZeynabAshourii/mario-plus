package src;

public class Camera  {
    public int x;
    public int y;
    public void update(Entity entity){
        setX((int) (-1*entity.getX() + Game.getFrameWidth()) - 800);
        setY((int) (-1*entity.getY() + Game.getFrameHeight() + -200));

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
