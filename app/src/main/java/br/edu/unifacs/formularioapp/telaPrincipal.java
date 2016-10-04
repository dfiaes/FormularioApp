package br.edu.unifacs.formularioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telaPrincipal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Button botaosair = (Button) findViewById(R.id.btnSair);
        botaosair.setOnClickListener(this);

        Button botaoConfig= (Button) findViewById(R.id.btnConfig);
        botaoConfig.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSair:
                finish();
                break;

            case R.id.btnConfig:
                Intent i=new Intent(this,TelaConfig.class);
                startActivity(i);
                break;
        }

    }
}
