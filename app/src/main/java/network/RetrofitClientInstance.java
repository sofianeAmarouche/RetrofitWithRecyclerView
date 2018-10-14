package network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sofiane on 10/12/2018.
 */

public class RetrofitClientInstance {
    private static Retrofit retrofit;

    private static final String BASE_URL = "https://gist.githubusercontent.com";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()

                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build();

        }

        return retrofit;

    }
}
