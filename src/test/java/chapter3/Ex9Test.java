package chapter3;

import jdk.Exported;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class Ex9Test {

    private static class Persoon {
        public String firstname;
        public String lastname;
        public String street;
        public Integer houseNumber = 2;

        private Persoon(String firstname, String lastname, String street, Integer houseNumber) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.street = street;
            this.houseNumber = houseNumber;
        }
    }

    private Persoon timAftobbenBijenStraat;
    private Persoon vincentMcAsomePantsAlleeStraat;
    private Persoon timTheNewOnAhNobodyKnowsNumber1;
    private Persoon timTheNewOnAhNobodyKnowsNumber2;


    @Before
    public void setUp() {
        timAftobbenBijenStraat = new Persoon("Tim", "Aftobben", "Bijenstraat", 3);
        vincentMcAsomePantsAlleeStraat = new Persoon("Vincent", "McAsomePants", "Alleestraat", 3);
        timTheNewOnAhNobodyKnowsNumber1 = new Persoon("Tim", "TheNewOne", "Ah nobody knows", 1);
        timTheNewOnAhNobodyKnowsNumber2 = new Persoon("Tim", "TheNewOne", "Ah nobody knows", 2);
    }

    @Test
    public void testLexicographicComparator_CompareFieldsInFollowingOrder_FirstnameLastnameStreetHousenumber() {
        List<Persoon> gesorteerdePersonen = asList(timAftobbenBijenStraat, vincentMcAsomePantsAlleeStraat, timTheNewOnAhNobodyKnowsNumber1, timTheNewOnAhNobodyKnowsNumber2)
                .stream().sorted(Ex9.lexicographicComparator("firstname", "lastname", "houseNumber", "street"))
                .collect(toList());

        assertThat(gesorteerdePersonen).containsExactly(timAftobbenBijenStraat, timTheNewOnAhNobodyKnowsNumber1, timTheNewOnAhNobodyKnowsNumber2, vincentMcAsomePantsAlleeStraat);
    }
}