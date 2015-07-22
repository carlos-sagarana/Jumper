package br.com.alura.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import br.com.alura.jumper.elements.Passaro;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Game extends SurfaceView implements Runnable {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;

    public Game(Context context) {
        super(context);
        inicializaElementos();
    }

    private void inicializaElementos() {
        passaro = new Passaro();
    }

    @Override
    public void run() {
        while(isRunning) {
            if(!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            passaro.desenhaNo(canvas);
            passaro.cai();

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void cancela() {
        isRunning = false;
    }
}
