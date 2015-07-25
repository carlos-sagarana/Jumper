package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Canos {

    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private static final int QUANTIDADE_DE_CANOS = 5;
    private final Tela tela;
    private final Pontuacao pontuacao;
    private final Context context;
    List<Cano> canos = new ArrayList<>();
    private int maximo;

    public Canos(Tela tela, Pontuacao pontuacao, Context context) {
        this.context = context;
        this.pontuacao = pontuacao;
        this.tela = tela;
        int posicao = 400;
        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            canos.add(new Cano(tela, posicao, context));
            posicao += DISTANCIA_ENTRE_CANOS;
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator<Cano> iterator = canos.listIterator();

        while (iterator.hasNext()) {
            Cano cano = iterator.next();
            cano.move();

            if (cano.saiuDaTela()) {
                pontuacao.aumenta();
                iterator.remove();
                iterator.add(new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context));
            }
        }
    }

    public int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano : canos) {
            if (cano.temColisaoHorizontalCom(passaro)
                    && cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }
}
