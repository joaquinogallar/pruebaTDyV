package junit;

import entity.NominaSocios;
import entity.Persona;
import entity.Socio;
import exception.YaExisteSocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SocioTest {
    Persona persona;
    NominaSocios nominaSocios;
    Socio socio;

    @BeforeEach
    void setUp() throws YaExisteSocioException {
        persona = new Persona("Jose", "Perez", "1", 20);
        nominaSocios.Asociar(persona);
        socio = new Socio(persona);
        Socio socio2 = new Socio("Michael", "Rodriguez", "2", 18);
        Socio socio3 = new Socio("Josefina", "Kendrick", "3", 23);
        Socio socio4 = new Socio("Bianca", "Perez", "4", 19);
        Socio socio5 = new Socio("Nicolas", "Scofield", "5", 26);
        nominaSocios.nomina.add(socio);
        nominaSocios.nomina.add(socio2);
        nominaSocios.nomina.add(socio3);
        nominaSocios.nomina.add(socio4);
        nominaSocios.nomina.add(socio5);
    }

    @Test
    void testSociosRepetidos() {
        Socio nuevoSocio = new Socio("Jose", "Perez", "1", 20);

        Assertions.assertFalse(nominaSocios.nomina.contains(nuevoSocio), "El socio ya existe");

        nominaSocios.nomina.add(nuevoSocio);
    }
}
