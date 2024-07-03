package pokemon.api;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class PokemonTestAPI extends Simulation {

    //Define preconditions
    

    //Case 1 - como switcehar ambientes
    String baseUrl = System.getProperty("baseUrl","https://pokeapi.co/api/v2/pokemon");

    private HttpProtocolBuilder httpProtocol = http.baseUrl(baseUrl);


    ScenarioBuilder sc = scenario("Pokemon API TEst")
            .exec(http("Get Pikachu").get("/pikachu").check(status().is(200)));

    {
        setUp(
                sc.injectOpen(
                        rampUsers(10)
                                .during(10)
                )
        ).protocols(httpProtocol);
    }
}
