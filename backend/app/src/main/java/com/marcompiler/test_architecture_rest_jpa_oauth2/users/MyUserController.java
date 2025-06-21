package com.marcompiler.test_architecture_rest_jpa_oauth2.users;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class MyUserController {

    private final MyUserRepository userRepository;

    public MyUserController(MyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<MyUser> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/sub/{sub}")
    public Optional<MyUser> getUserBySub(@PathVariable String sub) {
        return userRepository.findBySub(sub);
    }

    @GetMapping("/surname/{surname}")
    public Optional<MyUser> getUserBySurname(@PathVariable String surname) {
        return userRepository.findBySurname(surname);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(JwtAuthenticationToken auth, @RequestBody Map<String, String> payload)
    {
        try {
            String sub = auth.getToken().getClaimAsString(StandardClaimNames.SUB);
            String surname = payload.get("surname");

            MyUser newUser = new MyUser(sub, surname);

            MyUser result = userRepository.save(newUser);

            return ResponseEntity.ok(result.getId());
        }
        catch(DataIntegrityViolationException ex) {
            // Si un utilisateur avec le même pseudo/sub existe déjà, erreur car colonne NOT NULL et UNIQUE
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A user with the same sub/username already exists !");
        }
        catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while registering user: " + ex.getMessage());
        }
    }
}
