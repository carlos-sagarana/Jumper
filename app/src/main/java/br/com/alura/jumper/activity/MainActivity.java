package br.com.alura.jumper.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.alura.jumper.R;
import br.com.alura.jumper.engine.Game;


public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        game = new Game(this);
        game.inicia();
        container.addView(game);
        new Thread(game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.cancela();
    }
}
