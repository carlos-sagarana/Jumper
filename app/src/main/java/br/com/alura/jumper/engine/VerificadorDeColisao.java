package br.com.alura.jumper.engine;

import br.com.alura.jumper.elements.Canos;
import br.com.alura.jumper.elements.Passaro;

/**
 * Created by carloseduardo on 25/07/15.
 */
public class VerificadorDeColisao {

    private final Canos canos;
    private final Passaro passaro;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
