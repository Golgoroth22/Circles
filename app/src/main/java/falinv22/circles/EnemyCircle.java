package falinv22.circles;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int TO_RADIUS = 100;
    public static final int FROM_RADIUS = 10;
    public static final int ENEMY_CIRCLE_COLOR = Color.DKGRAY;
    public static final int FOOD_CIRCLE_COLOR = Color.GREEN;

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyCircle getEnemyCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle circle = new EnemyCircle(x, y, radius);
        return circle;
    }

    public void setColorForEnemyOrFoodCirle(MainCircle circle) {
        if (isSmollerThen(circle)) {
            setColor(FOOD_CIRCLE_COLOR);
        } else {
            setColor(ENEMY_CIRCLE_COLOR);
        }
    }

    private boolean isSmollerThen(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        }
        return false;
    }
}
