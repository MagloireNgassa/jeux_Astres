package com.aninterface.interactive.app_mob2_labo3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class StartView extends View {

    private int screenW;
    private int screenH;
    private Bitmap newPage;
    private Bitmap startPageLogo;
    private Bitmap startPageLog;
    private Bitmap btnStartUp1;
    private Bitmap btnStartDown1;
    private Bitmap btnStartUp11;
    private Bitmap btnStartDown11;
    private Bitmap btnStartUp2;
    private Bitmap btnStartDown2;
    private Bitmap btnStartUp22;
    private Bitmap btnStartDown22;
    private boolean playBtnState1;
    private boolean playBtnState2;
    private Context MyContext;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        screenW = w;
        screenH = h;
    }

    public StartView(Context context)
    {
        super(context);
        MyContext = context;
        startPageLog = BitmapFactory.decodeResource(getResources(),R.drawable.astrejpg);
        startPageLogo = Bitmap.createScaledBitmap(startPageLog, 500, 700, false); // redimensionne l'image bitmap avant de l'afficher
        btnStartUp11 = BitmapFactory.decodeResource(getResources(),R.drawable.tourne);
        btnStartUp1 = Bitmap.createScaledBitmap(btnStartUp11, 100, 100, false);
        btnStartDown11 = BitmapFactory.decodeResource(getResources(),R.drawable.tournecol);
        btnStartDown1 = Bitmap.createScaledBitmap(btnStartDown11, 100, 100, false);
        btnStartUp22 = BitmapFactory.decodeResource(getResources(),R.drawable.imagesdoigtok1);
        btnStartUp2 = Bitmap.createScaledBitmap(btnStartUp22, 100, 100, false);
        btnStartDown22 = BitmapFactory.decodeResource(getResources(),R.drawable.imagesdoigtok);
        btnStartDown2 = Bitmap.createScaledBitmap(btnStartDown22, 100, 100, false);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //  super.onDraw(canvas);
        canvas.drawBitmap (startPageLogo, (screenW-startPageLogo.getWidth())/2,(int)(screenH*0.00), null);
        if (playBtnState1) {canvas.drawBitmap(btnStartDown1, (screenW/2)-btnStartDown1.getWidth(),
                (int)(screenH*0.75), null);
        } else {
            canvas.drawBitmap(btnStartUp1,
                    (screenW/2)-btnStartDown1.getWidth(),
                    (int)(screenH*0.75), null);
        }
        if (playBtnState2) {canvas.drawBitmap(btnStartDown2, (screenW/2)+10 ,
                (int)(screenH*0.75), null);
        } else {
            canvas.drawBitmap(btnStartUp2,
                    (screenW/2)+10,
                    (int)(screenH*0.75), null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // return super.onTouchEvent(event);
        int action = event.getAction();
        int touchX = (int)event.getX();
        int touchY = (int)event.getY();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                if ((touchX > (screenW/2)+10 &&
                        touchX< (screenW/2)+10 +
                                btnStartUp2.getWidth())&& ((touchY > (int)(screenH*0.75)) &&
                        (touchY < ((int)(screenH*0.75) +
                                btnStartUp2.getHeight())))) {
                    playBtnState2 = true;
                }

               if ((touchX > (screenW/2)-btnStartUp1.getWidth() &&
                        touchX< (screenW/2)-btnStartUp1.getWidth() +
                                btnStartUp1.getWidth())&& ((touchY > (int)(screenH*0.75)) &&
                        (touchY < ((int)(screenH*0.75) +
                                btnStartUp1.getHeight())))) {
                    playBtnState1 = true;
                }

                break;

            case MotionEvent.ACTION_UP:
                if(playBtnState1)
                {
                    Intent gameIntent = new Intent(MyContext,GalaxyMove.class);
                    MyContext.startActivity(gameIntent);
                }
                playBtnState1 = false;


                if(playBtnState2)
                {
                    Intent gameIntent = new Intent(MyContext,Galaxy.class);
                    MyContext.startActivity(gameIntent);
                }
                playBtnState2 = false;

                break;

            case MotionEvent.ACTION_MOVE:

                break;
        }
        invalidate();
        return true;
    }

}
