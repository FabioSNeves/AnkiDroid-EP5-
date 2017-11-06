package lucas.com.br.ankioab;

import android.os.AsyncTask;
import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * Created by aluno on 07/06/2017.
 */

public class CriarUsuarioTask extends AsyncTask<Usuario, Void, Void>{
    @Override
    protected Void doInBackground(Usuario... params) {
        try {
            // 1. usando a Feign para fazer uma chamada a uma api rest
            UsuarioRequest request = Feign.builder().
                    encoder(new GsonEncoder()).
                    target(UsuarioRequest.class, "http://20.0.1.67/Anki2");

            // 2. Fazendo a chamada e enviando o objeto convertido em JSON
            request.createUsuario(params[0]);
            return null;

        } catch (Exception e) {
            System.err.println("Erro ao tentar criar Usuario!");
            e.printStackTrace();
            return null;
        }
    }
}
