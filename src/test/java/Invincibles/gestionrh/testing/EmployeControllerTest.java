package Invincibles.gestionrh.testing;

import Invincibles.gestionrh.controller.EmployeController;
import Invincibles.gestionrh.model.Employe;
import Invincibles.gestionrh.service.EmployeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeControllerTest {

    @Mock
    private EmployeService employeService;

    @InjectMocks
    private EmployeController employeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployes() {
        Employe employe1 = new Employe(1, "User1", "password");
        Employe employe2 = new Employe(2, "User2", "password");
        List<Employe> mockEmployes = Arrays.asList(employe1, employe2);

        when(employeService.getAllEmployes()).thenReturn(mockEmployes);

        List<Employe> result = employeController.getAllEmployes();

        assertEquals(2, result.size());
        verify(employeService, times(1)).getAllEmployes();
    }

    @Test
    void testGetEmployeById_Found() {
        Employe mockEmploye = new Employe(1, "User1", "user1@example.com", "password");
        when(employeService.getEmployeById(1)).thenReturn(mockEmploye);

        ResponseEntity<Employe> response = employeController.getEmployeById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("User1", response.getBody().getUsername());
        verify(employeService, times(1)).getEmployeById(1);
    }

    @Test
    void testGetEmployeById_NotFound() {
        when(employeService.getEmployeById(1)).thenReturn(null);

        ResponseEntity<Employe> response = employeController.getEmployeById(1);

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(employeService, times(1)).getEmployeById(1);
    }

    @Test
    void testCreateEmploye() {
        Employe mockEmploye = new Employe(0, "User1", "user1@example.com", "password");
        when(employeService.addEmploye(any(Employe.class))).thenReturn(mockEmploye);

        ResponseEntity<Employe> response = employeController.createEmploye(mockEmploye);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("User1", response.getBody().getUsername());
        verify(employeService, times(1)).addEmploye(any(Employe.class));
    }

    @Test
    void testUpdateEmploye_Found() {
        Employe updatedEmploye = new Employe(1, "UpdatedUser", "updated@example.com", "password");
        when(employeService.updateEmploye(eq(1), any(Employe.class))).thenReturn(updatedEmploye);

        ResponseEntity<Employe> response = employeController.updateEmploye(1, updatedEmploye);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("UpdatedUser", response.getBody().getUsername());
        verify(employeService, times(1)).updateEmploye(eq(1), any(Employe.class));
    }

    @Test
    void testUpdateEmploye_NotFound() {
        when(employeService.updateEmploye(eq(1), any(Employe.class))).thenReturn(null);

        ResponseEntity<Employe> response = employeController.updateEmploye(1, new Employe());

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(employeService, times(1)).updateEmploye(eq(1), any(Employe.class));
    }

    @Test
    void testDeleteEmploye() {
        doNothing().when(employeService).deleteEmploye(1);

        ResponseEntity<Void> response = employeController.deleteEmploye(1);

        assertEquals(204, response.getStatusCodeValue());
        verify(employeService, times(1)).deleteEmploye(1);
    }

    @Test
    void testCountEmployes() {
        when(employeService.countEmployes()).thenReturn(5L);

        long count = employeController.countEmployes();

        assertEquals(5, count);
        verify(employeService, times(1)).countEmployes();
    }
}
