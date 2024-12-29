package Invincibles.gestionrh.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Invincibles.gestionrh.controller.AuthController;

class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignIn() throws Exception {
        // Exemple de test (ajoutez ici votre code pour tester)
        System.out.println("Test SignIn executed!");
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        // You can add assertions here to validate the behavior
    }
}
