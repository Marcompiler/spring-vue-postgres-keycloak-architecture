package com.marcompiler.backend.users;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class MyUserController {

    private final MyUserService myUserService;

    public MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping
    public ResponseEntity<List<MyUser>> getUsers() {
        List<MyUser> users = myUserService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MyUser> getUserById(@PathVariable Long id) {
        return myUserService.getUserById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/sub/{sub}")
    public ResponseEntity<MyUser> getUserBySub(@PathVariable String sub) {
        return myUserService.getUserBySub(sub)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity<MyUser> getUserBySurname(@PathVariable String surname) {
        return myUserService.getUserBySurname(surname)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(JwtAuthenticationToken auth, @RequestBody Map<String, String> payload)
    {
        try {
            String sub = auth.getToken().getClaimAsString(StandardClaimNames.SUB);
            String surname = payload.get("surname");

            MyUser newUser = new MyUser(sub, surname);

            MyUser result = myUserService.saveUser(newUser);

            return ResponseEntity.ok(result.getId());
        }
        catch(DataIntegrityViolationException ex) {
            // If a user with the same sub/nickname already exists, error due to NOT NULL and UNIQUE constraint
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        if (myUserService.userExistsById(id)) {
            myUserService.deleteUserById(id);
        } else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
