    package Invincibles.gestionrh.controller;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;
    import java.util.stream.Collectors;

    import Invincibles.gestionrh.model.Departement;
    import Invincibles.gestionrh.model.ERole;
    import Invincibles.gestionrh.model.Post;
    import Invincibles.gestionrh.model.Role;
    import Invincibles.gestionrh.repository.EmployeRepository;
    import Invincibles.gestionrh.repository.PostRepository;
    import Invincibles.gestionrh.request.LoginRequest;
    import Invincibles.gestionrh.request.SignupRequest;
    import Invincibles.gestionrh.response.JwtResponse;
    import Invincibles.gestionrh.response.MessageResponse;
    import Invincibles.gestionrh.security.JwtUtils;
    import Invincibles.gestionrh.service.UserDetailsImpl;
    import jakarta.validation.Valid;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import Invincibles.gestionrh.model.Employe;
    import Invincibles.gestionrh.repository.RoleRepository;
    import Invincibles.gestionrh.repository.DepartementRepository;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {
      @Autowired
      AuthenticationManager authenticationManager;

      @Autowired
      EmployeRepository userRepository;

      @Autowired
      RoleRepository roleRepository;

      @Autowired
      PasswordEncoder encoder;

      @Autowired
      JwtUtils jwtUtils;

      @Autowired
      private PostRepository postRepository;

      @Autowired
      private DepartementRepository departementRepository;

      @PostMapping("/signin")
      public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                             userDetails.getId(),
                             userDetails.getUsername(),
                             userDetails.getEmail(),
                             roles));
      }


      @PostMapping("/signup")
      public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
          if (userRepository.existsByUsername(signUpRequest.getUsername())) {
              return ResponseEntity
                  .badRequest()
                  .body(new MessageResponse("Error: Username is already taken!"));
          }

          if (userRepository.existsByEmail(signUpRequest.getEmail())) {
              return ResponseEntity
                  .badRequest()
                  .body(new MessageResponse("Error: Email is already in use!"));
          }

          Employe user;
          Set<String> strRoles = signUpRequest.getRole();
          Set<Role> roles = new HashSet<>();

          if (strRoles == null) {
              Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYE)
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(userRole);
          } else {
              strRoles.forEach(role -> {
                  switch (role) {
                      case "gestionnairerh":
                          Role gestionnairerhRole = roleRepository.findByName(ERole.ROLE_GESTIONNAIRERH)
                              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                          roles.add(gestionnairerhRole);
                          break;
                      case "employe":
                          Role employeRole = roleRepository.findByName(ERole.ROLE_EMPLOYE)
                              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                          roles.add(employeRole);
                          break;
                      default:
                          Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYE)
                              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                          roles.add(userRole);
                  }
              });
          }

          if (signUpRequest.getMatricule() != null &&
                    signUpRequest.getUsername() != null &&
                    signUpRequest.getDatenaissance() != null &&
                    signUpRequest.getCin() != null &&
                    signUpRequest.getVille() != null &&
                    signUpRequest.getNom() != null &&
                    signUpRequest.getPrenom() != null &&
                    signUpRequest.getAge() != 0 &&
                    signUpRequest.getNumerotelephone() != null &&
                    signUpRequest.getSexe() != null &&
                    signUpRequest.getTotalAllocatedDays() != 0
                  ) {

              // Fetch Departement and Post entities by their IDs
              Departement departement = departementRepository.findById(signUpRequest.getDepartement().getId_departement())
                      .orElseThrow(() -> new RuntimeException("Error: Departement not found."));

              Post post = postRepository.findById(signUpRequest.getPost().getId_post())
                      .orElseThrow(() -> new RuntimeException("Error: Post not found."));
                    // Use the constructor with more arguments if matricule, datenaissance, and cin are provided
                    user = new Employe(
                        0,
                        signUpRequest.getUsername(),
                        signUpRequest.getMatricule(),
                        signUpRequest.getNom(),
                        signUpRequest.getPrenom(),
                        signUpRequest.getDatenaissance(),
                        signUpRequest.getVille(),
                        signUpRequest.getCin(),
                        signUpRequest.getEmail(),
                        encoder.encode(signUpRequest.getPassword()),
                        signUpRequest.getAge(),
                        signUpRequest.getNumerotelephone(),
                        signUpRequest.getSexe(),
                        signUpRequest.getTotalAllocatedDays(),
                        departement,
                        post
                    );
                } else {
                    // Use the constructor with fewer arguments
                    user = new Employe(signUpRequest.getUsername(), signUpRequest.getEmail(),
                        encoder.encode(signUpRequest.getPassword()));
                }

          user.setRoles(roles);
          userRepository.save(user);

          return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
      }
    }
