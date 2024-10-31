package junit;

import entity.Actividad;
import entity.OfertaActividades;
import entity.Persona;
import org.junit.jupiter.api.*;

public class ActividadTest {
    Actividad actividad;
    OfertaActividades ofertaActividades;
    Persona encargado;

    @BeforeEach
    void setUp() {
        encargado = new Persona("Jose", "Perez", "1", 20);
        ofertaActividades.NuevaActividad(actividad);
        Actividad actividad1 = new Actividad("Actividad 2", encargado, 40, 16);
        Actividad actividad2 = new Actividad("Actividad 3", encargado, 20, 14);
        Actividad actividad3 = new Actividad("Actividad 4", encargado, 30, 20);
        Actividad actividad4 = new Actividad("Actividad 5", encargado, 40, 10);
        Actividad actividad5 = new Actividad("Actividad 6", encargado, 70, 11);
        ofertaActividades.nomina.add(actividad1);
        ofertaActividades.nomina.add(actividad2);
        ofertaActividades.nomina.add(actividad3);
        ofertaActividades.nomina.add(actividad4);
        ofertaActividades.nomina.add(actividad5);
    }

    @Test
    void testActividadesRepetidas() {
        Actividad nuevaActividad = new Actividad("Actividad 7", encargado, 30, 20);

        Assertions.assertFalse(ofertaActividades.nomina.contains(nuevaActividad), "La activadad ya existe");

        ofertaActividades.nomina.add(nuevaActividad);
    }

    @Test
    @DisplayName("Comprueba que el encargado de una actividad es un socio de la nómina")
    void testEncargadoActividadYSocioDeNomina() {

    }
}
