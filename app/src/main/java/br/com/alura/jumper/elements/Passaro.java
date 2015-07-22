package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.graficos.Cores;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Passaro {

    private static final float RAIO = 50;
    private static final float X = 100;

    private int altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, Cores.getCorDoPassaro());
    }

    public void cai() {
        altura += 5;
    }

}
