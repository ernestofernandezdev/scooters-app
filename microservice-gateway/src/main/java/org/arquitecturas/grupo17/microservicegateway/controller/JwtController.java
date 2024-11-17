package org.arquitecturas.grupo17.microservicegateway.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.arquitecturas.grupo17.microservicegateway.dto.LoginDTO;
import org.arquitecturas.grupo17.microservicegateway.security.JwtFilter;
import org.arquitecturas.grupo17.microservicegateway.security.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authenticate" )
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Endpoints for user authentication and JWT token management")
public class JwtController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    @Operation(
            summary = "Authenticate a user and generate a JWT token",
            description = "This endpoint authenticates the user using their username and password. "
                    + "If successful, it returns a JWT token in the response header and body.",
            tags = {"Authentication"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully authenticated. JWT token is returned.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = JWTToken.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Invalid username or password.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error.",
                    content = @Content
            )
    })
    @PostMapping()
    public ResponseEntity<JWTToken> authorize(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User credentials for authentication",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = LoginDTO.class)
                    )
            )
            @Valid @RequestBody LoginDTO request
    ) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate( authenticationToken );
        SecurityContextHolder.getContext().setAuthentication( authentication );
        final var jwt = tokenProvider.createToken( authentication );
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add( JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt );
        return new ResponseEntity<>( new JWTToken( jwt ), httpHeaders, HttpStatus.OK );
    }

    @Schema(description = "Represents the JWT token returned after successful authentication")
    static class JWTToken {

        @Schema(description = "The JWT token string", example = "eyJhbGciOiJIUzI1NiIsInR...")
        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
