package presentación;

import datos.EmpleadoDAO;
import dominio.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private EmpleadoDAO empleadoDAO;

    @BeforeEach
    public void setUp() {
        empleadoDAO = new EmpleadoDAO();
    }

    @Test
    public void testMostrarEmpleados() {
        List<Empleado> empleados = empleadoDAO.mostrar();
        assertTrue(empleados.size() > 0);
    }

    @Test
    public void testInsertarEmpleado() {
        Empleado empleado = new Empleado("Harol", "Medina", 23, 1500.50);
        int registrosAfectados = empleadoDAO.insertar(empleado);
        assertEquals(1, registrosAfectados);
    }

    @Test
    public void testActualizarEmpleado() {
        Empleado empleadoActualizar = new Empleado(7, "Karla", "Romero", 40, 1800.50);
        int registrosAfectados = empleadoDAO.actualizar(empleadoActualizar);
        assertEquals(1, registrosAfectados);
    }

    @Test
    public void testEliminarEmpleado() {
        Empleado empleadoEliminar = new Empleado(7);
        int registrosAfectados = empleadoDAO.eliminar(empleadoEliminar);
        assertEquals(1, registrosAfectados);
    }
}
