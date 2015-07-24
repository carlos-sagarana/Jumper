package br.com.alura.jumper.elements;

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
    List<Cano> canos = new ArrayList<>();
    private int maximo;

    public Canos(Tela tela, Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
        this.tela = tela;
        int posicao = 400;
        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            canos.add(new Cano(tela, posicao));
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
                iterator.add(new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS));
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
}
