package br.edu.unifacs.formularioapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefsEditor;

    private int numero;
    TextView txtUsu;
    TextView txtPas;
    private String usuario="admin";
    private String senha="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sharedPrefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        numero = sharedPrefs.getInt("Numero", 0);
        usuario = sharedPrefs.getString("Usuario","");
        senha = sharedPrefs.getString("Senha","");
       // numero++;


        /*String mens = "Esta é a " + numero + "a. vez que esta aplicação roda";
        tv.setText(mens);*/


        Button botaoentrar = (Button) findViewById(R.id.btnEntrar);
        Button botaosair = (Button) findViewById(R.id.btnSair);
        botaoentrar.setOnClickListener(this);
        botaosair.setOnClickListener(this);


    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPrefsEditor = sharedPrefs.edit();
        if (sharedPrefsEditor != null) {
            sharedPrefsEditor.putInt("Numero", numero);
            sharedPrefsEditor.putString("Usuario", usuario);
            sharedPrefsEditor.putString("Senha", senha);

            sharedPrefsEditor.commit();
        }
    }

    @Override
    public void onClick(View v) {
        // Identifique quem é v e defina uma ação
        switch (v.getId()) {
            case R.id.btnEntrar:
                // ação associado ao click do botão “Botão 1”
                txtUsu = (TextView) findViewById(R.id.editText);
                txtPas = (TextView) findViewById(R.id.editText2);
                if(usuario.equals(txtUsu.getText().toString()) && senha.equals(txtPas.getText().toString())){

                    // proxima pagina
                    numero=0;
                    Intent i=new Intent(this,telaPrincipal.class);
                    startActivity(i);

                } else {
                    numero++;
                    Toast.makeText(this,"Usuário/Senha incorreto", Toast.LENGTH_SHORT).show();

                }

                if(numero == 4){
                    Intent i=new Intent(this,bloqueio.class);
                    startActivity(i);
                }
                break;
            case R.id.btnSair:
                finish();
                break;
           /* case R.id.button_sair:
                finish();  // finaliza a atividade
                 break;*/
        }

    }
}