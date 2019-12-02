package apitest;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PokemonTest {

    private final static String URL = "https://pokeapi.co";
    private final static String END_POINT = "/api/v2/pokemon/";

    @Test(dataProvider = "dataForPokemon")
    public void pokemonTest (String name, String path) {
        String response = given().baseUri(URL).when().get(END_POINT + name).then().extract().asString();
        MatcherAssert.assertThat(response, JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
    }

    @DataProvider(name = "dataForPokemon")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"pikachu/", "schemas/pikachu.json"},
                {"snorlax/", "schemas/snorlax.json"},
                {"charizard/", "schemas/charizard.json"}
        };
    }
}
