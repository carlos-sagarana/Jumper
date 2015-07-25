package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import br.com.alura.jumper.R;
import br.com.alura.jumper.graficos.Cores;
import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Cano {

    private final int alturaCanoInferior;
    private final Context context;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;
    private int posicao;
    private Tela tela;
    private int alturaCanoSuperior;
    public static final int ALTURA_DO_CANO = 250;
    public static final int LARGURA_DO_CANO = 100;

    public Cano(Tela tela, int posicao, Context context) {
        this.context = context;
        this.tela = tela;
        this.posicao = posicao;
        alturaCanoSuperior = ALTURA_DO_CANO + valorAleatorio();
        alturaCanoInferior = tela.getAltura() - ALTURA_DO_CANO - valorAleatorio();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaCanoInferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaCanoSuperior, false);

    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawBitmap(canoInferior, posicao, alturaCanoInferior, null);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    public void move() {
        posicao -= 5;
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 80);
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - Passaro.RAIO < alturaCanoSuperior
                || passaro.getAltura() + Passaro.RAIO > alturaCanoInferior;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return posicao - Passaro.X < Passaro.RAIO;
    }
}
