package br.edu.unifacs.formularioapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int numero;
    private TextView txtUsu;
    private TextView txtPas;
    private Usuario contUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoentrar = (Button) findViewById(R.id.btnEntrar);
        Button botaosair = (Button) findViewById(R.id.btnSair);
        botaoentrar.setOnClickListener(this);
        botaosair.setOnClickListener(this);

        contUsuario = new Usuario(getApplicationContext());

        if (!contUsuario.uValido()) {
            Intent i = new Intent(this, bloqueio.class);
            startActivity(i);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        contUsuario.salvar();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnEntrar:

                txtUsu = (TextView) findViewById(R.id.editText);
                txtPas = (TextView) findViewById(R.id.editText2);

                if (contUsuario.Login(txtUsu.getText().toString(), txtPas.getText().toString())) {

                    contUsuario.setTentativas(0);
                    Intent i=new Intent(this,telaPrincipal.class);
                    startActivity(i);

                } else {

                    numero = numero + 1;
                    contUsuario.setTentativas(numero);
                    Toast.makeText(this, "Usuário/Senha incorreto", Toast.LENGTH_SHORT).show();
                }

                if (!contUsuario.uValido()) {

                    Intent i=new Intent(this,bloqueio.class);
                    startActivity(i);
                }
                break;
            case R.id.btnSair:
                finish();
                break;

        }

    }
}