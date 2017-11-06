package lucas.com.br.ankioab;

import android.os.AsyncTask;

import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * Created by aluno on 07/06/2017.
 */

public class AtualizarBaralhoTask extends AsyncTask<Baralho, Void, Void> {
    @Override
    protected Void doInBackground(Baralho... params) {
        try {
            // 1. usando a Feign para fazer uma chamada a uma api rest
            BaralhoRequest request = Feign.builder().
                    encoder(new GsonEncoder()).
                    target(BaralhoRequest.class, "http://20.0.1.67/Anki2");

            // 2. Fazendo a chamada e enviando o objeto convertido em JSON
            request.updateBaralho(params[0].getCodBaralho(), params[0]);
            return null;

        } catch (Exception e) {
            System.err.println("Erro ao tentar atualizar Baralho!");
            e.printStackTrace();
            return null;
        }
    }

}
