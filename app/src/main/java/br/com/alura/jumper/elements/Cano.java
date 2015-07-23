package br.com.alura.jumper.elements;

import android.graphics.Canvas;

import br.com.alura.jumper.graficos.Cores;
import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Cano {

    private int posicao;
    private Tela tela;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
    }

    public static final int ALTURA_DO_CANO = 250;
    public static final int LARGURA_DO_CANO = 100;

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, tela.getAltura() - ALTURA_DO_CANO, posicao + LARGURA_DO_CANO, tela.getAltura(), Cores.getCorDoCano());
    }

    public void move() {
        posicao -= 5;
    }
}
