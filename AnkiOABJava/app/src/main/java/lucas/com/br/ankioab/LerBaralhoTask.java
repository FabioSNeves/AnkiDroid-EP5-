package lucas.com.br.ankioab;

import android.os.AsyncTask;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by aluno on 07/06/2017.
 */

public class LerBaralhoTask extends AsyncTask<Integer, Void, Baralho> {
    @Override
    protected Baralho doInBackground(Integer... params) {
        try {
            // 1. usando a Feign para fazer uma chamada a uma api rest
            BaralhoRequest request = Feign.builder().
                    decoder(new GsonDecoder()).
                    target(BaralhoRequest.class, "http://20.0.1.67/Anki2");

            // 2. Fazendo a chamada e recuperando o objeto convertido
            Baralho baralho = request.getBaralho(params[0]);
            return baralho;

        } catch (Exception e) {
            System.err.println("Erro na chamada à API "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
