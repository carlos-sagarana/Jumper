package br.com.alura.jumper.graficos;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Cores {

    public static Paint getCorDoPassaro() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }

    public static Paint getCorDoCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }

    public static Paint getCorDaPontuacao() {
        Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5, 0xFF000000);
        return branco;
    }

    public static Paint getCorDoGameOver() {
        Paint gameOver = new Paint();
        gameOver.setColor(0xFFFF0000);
        gameOver.setTextSize(50);
        gameOver.setShadowLayer(2, 3, 3, 0xFF000000);
        return gameOver;
    }
}
