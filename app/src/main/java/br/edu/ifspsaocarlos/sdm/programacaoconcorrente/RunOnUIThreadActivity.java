package br.edu.ifspsaocarlos.sdm.programacaoconcorrente;

/**
 * Created by rafae on 11/06/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RunOnUIThreadActivity extends Activity implements View.OnClickListener {
    private Button btCliqueAqui;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral);
        TextView tvNomeActivity = (TextView) findViewById(R.id.tv_nome_activity);
        tvNomeActivity.setText("RunOnUIThread");
        btCliqueAqui = (Button) findViewById(R.id.bt_clique_aqui);
        btCliqueAqui.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == btCliqueAqui) {
            new Thread() {
                public void run() {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            TextView tvAlvo = (TextView) findViewById(R.id.tv_alvo);
                            tvAlvo.setText(getString(R.string.texto_alterado));
                        }
                    });
                }
            }.start();
        }
    }
}