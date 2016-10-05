package br.edu.unifacs.formularioapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class telaPrincipal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Button botaoSair = (Button) findViewById(R.id.btnFim);
        Button botaoConfig = (Button) findViewById(R.id.btnConfig);
        botaoSair.setOnClickListener(this);
        botaoConfig.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnConfig:


                Intent i=new Intent(this,TelaConfig.class);
                startActivity(i);

                break;
            case R.id.btnFim:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;

        }

    }
}
