package br.com.alura.jumper.elements;

import android.graphics.Canvas;

import br.com.alura.jumper.graficos.Cores;
import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Cano {

    private final int alturaCanoInferior;
    private int posicao;
    private Tela tela;
    private int alturaCanoSuperior;
    public static final int ALTURA_DO_CANO = 250;
    public static final int LARGURA_DO_CANO = 100;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        alturaCanoSuperior = ALTURA_DO_CANO + valorAleatorio();
        alturaCanoInferior = tela.getAltura() - ALTURA_DO_CANO - valorAleatorio();
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), Cores.getCorDoCano());
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaCanoSuperior, Cores.getCorDoCano());
    }

    public void move() {
        posicao -= 5;
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 200);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }
}
