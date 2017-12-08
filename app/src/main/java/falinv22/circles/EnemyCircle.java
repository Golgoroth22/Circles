package falinv22.circles;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int TO_RADIUS = 100;
    public static final int FROM_RADIUS = 10;
    public static final int ENEMY_CIRCLE_COLOR = Color.DKGRAY;
    public static final int FOOD_CIRCLE_COLOR = Color.GREEN;
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getEnemyCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle circle = new EnemyCircle(x, y, radius, dx, dy);
        return circle;
    }

    public void setColorForEnemyOrFoodCirle(MainCircle circle) {
        if (isSmallerThen(circle)) {
            setColor(FOOD_CIRCLE_COLOR);
        } else {
            setColor(ENEMY_CIRCLE_COLOR);
        }
    }

    private boolean isSmallerThen(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }
    }
}
