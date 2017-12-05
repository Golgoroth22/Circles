package falinv22.circles;

import java.util.ArrayList;

public class GameManager {

    public static final int MAX_ENEMY_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> enemyCircles;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initEnemyCircles();
        initMainCircle();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    private void initEnemyCircles() {
        enemyCircles = new ArrayList<>();
        for (int i = 0; i < MAX_ENEMY_CIRCLES; i++) {
            EnemyCircle circle;
            circle = EnemyCircle.getEnemyCircle();
            enemyCircles.add(circle);
        }
    }

    public void onDrow() {
        canvasView.drowCircle(mainCircle);
        for (EnemyCircle e : enemyCircles) {
            canvasView.drowCircle(e);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
