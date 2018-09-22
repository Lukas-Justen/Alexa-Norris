import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Optional;

public class RandomRestaurantHandler implements RequestHandler {

    public boolean canHandle(HandlerInput handlerInput) {
        return true;
    }

    public Optional<Response> handle(HandlerInput handlerInput) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChuckNorrisService service = retrofit.create(ChuckNorrisService.class);
        Call<Joke> jokeCall = service.getJoke();

        String joke = "";
        try {
            retrofit2.Response<Joke> response = jokeCall.execute();
            joke = response.body().getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return handlerInput.getResponseBuilder().withSpeech(joke).build();
    }

}
