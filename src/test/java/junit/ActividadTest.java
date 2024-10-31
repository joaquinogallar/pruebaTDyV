package junit;

import entity.Actividad;
import entity.OfertaActividades;
import entity.Persona;
import entity.Socio;
import exception.CupoExcedidoException;
import exception.EdadInsuficienteException;
import org.junit.jupiter.api.*;

public class ActividadTest {
    Actividad actividad;
    OfertaActividades ofertaActividades;
    Socio encargado;

    @BeforeEach
    void setUp() throws CupoExcedidoException, EdadInsuficienteException {
        encargado = new Socio("Jose", "Perez", "1", 40);
        ofertaActividades.NuevaActividad(actividad);
        actividad = new Actividad("Actividad 1", encargado.getPersona(), 0, 0);
        actividad.inscribirSocio(encargado);
        Actividad actividad1 = new Actividad("Actividad 2", encargado.getPersona(), 40, 16);
        Actividad actividad2 = new Actividad("Actividad 3", encargado.getPersona(), 20, 14);
        Actividad actividad3 = new Actividad("Actividad 4", encargado.getPersona(), 30, 20);
        Actividad actividad4 = new Actividad("Actividad 5", encargado.getPersona(), 40, 10);
        Actividad actividad5 = new Actividad("Actividad 6", encargado.getPersona(), 70, 11);
        ofertaActividades.nomina.add(actividad1);
        ofertaActividades.nomina.add(actividad2);
        ofertaActividades.nomina.add(actividad3);
        ofertaActividades.nomina.add(actividad4);
        ofertaActividades.nomina.add(actividad5);
    }

    @Test
    void testActividadesRepetidas() {
        Actividad nuevaActividad = new Actividad("Actividad 7", encargado.getPersona(), 30, 20);

        Assertions.assertFalse(ofertaActividades.nomina.contains(nuevaActividad), "La activadad ya existe");

        ofertaActividades.nomina.add(nuevaActividad);
    }

    @Test
    @DisplayName("Comprueba que el encargado de una actividad es un socio de la nómina")
    void testEncargadoActividadYSocioDeNomina() {
        Assertions.assertTrue(actividad.getInscriptos().contains(encargado), "El encargado no forma parte de la nomina");
    }
}
