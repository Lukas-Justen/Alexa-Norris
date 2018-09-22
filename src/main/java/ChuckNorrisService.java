
import retrofit2.Call;
import retrofit2.http.GET;

public interface ChuckNorrisService {
        @GET("jokes/random")
        Call<Joke> getJoke();
}
