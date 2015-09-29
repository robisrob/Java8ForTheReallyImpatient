package chapter3;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class Ex9Test {

    private static class Persoon {
        public  String firstname;
        public  String lastname;
        public  String street;

        private Persoon(String firstname, String lastname, String street) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.street = street;
        }
    }

    private Persoon timAftobbenBijenStraat;
    private Persoon vincentMcAsomePantsAlleeStraat;
    private Persoon timTheNewOnAhNobodyKnows;

    @Before
    public void setUp() {
        timAftobbenBijenStraat = new Persoon("Tim", "Aftobben", "Bijenstraat");
        vincentMcAsomePantsAlleeStraat = new Persoon("Vincent", "McAsomePants", "Alleestraat");
        timTheNewOnAhNobodyKnows = new Persoon("Tim", "TheNewOne", "Ah nobody knows");
    }

    @Test
    @Ignore
    public void testLexicographicComparator_CompareFieldsInFollowingOrder_FirstnameLastnameStreet() {
        List<Persoon> gesorteerdePersonen = asList(timAftobbenBijenStraat, vincentMcAsomePantsAlleeStraat, timTheNewOnAhNobodyKnows)
                .stream().sorted(Ex9.lexicographicComparator("firstname", "lastname", "street"))
                .collect(Collectors.toList());

        assertThat(gesorteerdePersonen).containsExactly(timAftobbenBijenStraat, timTheNewOnAhNobodyKnows, vincentMcAsomePantsAlleeStraat);
    }
}