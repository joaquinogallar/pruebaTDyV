package testng;

import entity.Socio;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SocioTestNG {
    List<Socio> socios;
    int cantidad;

    @BeforeTest
    void setUp(@Optional("3") int cantidad) {
        this.cantidad = cantidad;
        socios = new ArrayList<>();
        socios.add(new Socio("Jennifer", "Lawrence", "1", (int) (Math.random() * 100)));
        socios.add(new Socio("Peeta", "Mellark", "2", (int) (Math.random() * 100)));
        socios.add(new Socio("Michael", "Scofield", "3", (int) (Math.random() * 100)));
        socios.add(new Socio("Amy", "Santiago", "4", (int) (Math.random() * 100)));
        socios.add(new Socio("Jacob", "Pereyra", "5", (int) (Math.random() * 100)));
        socios.add(new Socio("Terry", "Jefferson", "6", (int) (Math.random() * 100)));
        socios.add(new Socio("Rosa", "Diaz", "7", (int) (Math.random() * 100)));
    }

    @DataProvider
    Iterator<Socio> generarSocios() {
        List<Socio> sociosATestear = new ArrayList<>();
        while(cantidad >= 0) {
            sociosATestear.add(socios.get((int) (Math.random() * socios.size())));
            cantidad--;
        }

        return sociosATestear.iterator();
    }

    @Test(dataProvider = "generarSocios")
    void testToString(Socio s) {
        Assertions.assertEquals(s.getPersona().getApellido() + " " + s.getPersona().getNombre(), s.toString());

    }
}
