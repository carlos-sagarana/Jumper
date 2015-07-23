package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.graficos.Cores;
import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Passaro {

    private static final float RAIO = 50;
    private static final float X = 100;
    private final Tela tela;

    private int altura;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, Cores.getCorDoPassaro());
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if (!chegouNoChao) {
            altura += 5;
        }
    }

    public void pula() {
        int bordaSuperior = (int) (altura - RAIO);
        if (bordaSuperior > 0) {
            altura -= 150;
        }
    }

}
