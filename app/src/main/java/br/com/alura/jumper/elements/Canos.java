package br.com.alura.jumper.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.jumper.graficos.Tela;

/**
 * Created by Carlos Eduardo on 22/07/2015.
 */
public class Canos {

    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private static final int QUANTIDADE_DE_CANOS = 5;
    List<Cano> canos = new ArrayList<>();

    public Canos(Tela tela) {
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
        for (Cano cano : canos) {
            cano.move();
        }
    }
}
