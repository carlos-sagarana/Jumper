package br.com.alura.jumper.elements;

import android.graphics.Canvas;

import br.com.alura.jumper.engine.Som;
import br.com.alura.jumper.graficos.Cores;

/**
 * Created by Carlos Eduardo on 24/07/2015.
 */
public class Pontuacao {

    private final Som som;
    private int pontos = 0;

    public Pontuacao(Som som) {
        this.som = som;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, Cores.getCorDaPontuacao());
    }

    public void aumenta() {
        pontos++;
        som.toca(Som.PONTUACAO);
    }
}