package allyson.com.br.desafio_zup.Util;

import com.google.gson.Gson;

/**
 * Created by Allyson Rodrigues on 25/03/2017.
 */

public class Deserialize {
    public static <T> T deserializeMovie(String serilized, Class<T> tClass) {
        return new Gson().fromJson(serilized, tClass);
    }
}
