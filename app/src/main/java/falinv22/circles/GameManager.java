package falinv22.circles;


import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {

    private MainCircle mainCircle;
    private Paint paint;

    public GameManager() {
        initMainCircle();
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(200, 500);
    }


    public void onDrow(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
