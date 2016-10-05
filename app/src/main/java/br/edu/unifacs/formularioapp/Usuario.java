package br.edu.unifacs.formularioapp;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by denis on 04/10/2016.
 */

public class Usuario {

    private String usuario;
    private String senha;
    private int tentativaLogin;


    private SharedPreferences sp;
    private SharedPreferences.Editor spEdit;


    public Usuario(Context ApCont) {
        sp = ApCont.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        this.tentativaLogin = sp.getInt("nTentativa", 0);
        this.usuario = sp.getString("usuario", "admin");
        this.senha = sp.getString("senha", "admin");
    }

    public void setUsuSenha(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.tentativaLogin = 0;
        comitar();
    }

    public void setTentativas(int nTentativa) {
        this.tentativaLogin = nTentativa;
        comitar();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        comitar();

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        comitar();

    }

    public int getNtentativas() {
        return tentativaLogin;
    }

    public void salvar() {
        comitar();
    }

    private void comitar() {

        spEdit = sp.edit();
        if (spEdit != null) {
            spEdit.putInt("nTentativa", tentativaLogin);
            spEdit.putString("usuario", usuario);
            spEdit.putString("senha", senha);

            spEdit.commit();
        }

    }


    public boolean Login(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public boolean uValido() {
        return getNtentativas() <= 3;
    }


}
