package br.edu.unifacs.formularioapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaConfig extends AppCompatActivity implements View.OnClickListener {

    private Usuario contUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_config);

        Button botaoConf = (Button) findViewById(R.id.btnConf);
        Button botaoCancel = (Button) findViewById(R.id.btnCancelar);
        botaoConf.setOnClickListener(this);
        botaoCancel.setOnClickListener(this);


        contUsuario = new Usuario(getApplicationContext());
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnConf:

                TextView txtUsuario = (TextView) findViewById(R.id.editText3);
                TextView txtSenha1 = (TextView) findViewById(R.id.editText4);
                TextView txtSenha2 = (TextView) findViewById(R.id.editText5);

                if (txtSenha1.getText().toString().equals(txtSenha2.getText().toString())) {
                    contUsuario.setUsuSenha(txtUsuario.getText().toString(), txtSenha1.getText().toString());
                    finish();
                } else {
                    Toast.makeText(this, "A senha não é igual nos dois campos", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnCancelar:
                finish();
                break;

        }

    }


}
