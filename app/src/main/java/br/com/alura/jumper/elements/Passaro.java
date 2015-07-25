package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.R;
import br.com.alura.jumper.graficos.Cores;
import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Passaro {

    public static final int RAIO = 50;
    public static final float X = 100;
    private final Tela tela;
    private final Context context;
    private final Bitmap passaro;

    private int altura;

    public Passaro(Tela tela, Context context) {
        this.context = context;
        this.tela = tela;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if (!chegouNoChao) {
            altura += 6;
        }
    }

    public void pula() {
        int bordaSuperior = (int) (altura - RAIO);
        if (bordaSuperior > 0) {
            altura -= 100;
        }
    }

    public int getAltura() {
        return altura;
    }
}
