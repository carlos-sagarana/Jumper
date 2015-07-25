package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Rect;

import br.com.alura.jumper.graficos.Cores;
import br.com.alura.jumper.graficos.Tela;

/**
 * Created by carloseduardo on 25/07/15.
 */
public class GameOver {

    private final Tela tela;

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas) {
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroHorizontal, tela.getAltura()/2, Cores.getCorDoGameOver());
    }

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        Cores.getCorDoGameOver().getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
        return centroHorizontal;
    }
}
