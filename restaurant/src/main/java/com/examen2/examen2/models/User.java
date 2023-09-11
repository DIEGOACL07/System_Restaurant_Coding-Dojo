package com.examen2.examen2.models;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseModel {

    @NotNull
    @NotBlank
    @Size(min = 5, max = 250, message = "El campo name debe contener minino 5 caracteres y maximo 250")
    private String name;

    @NotNull
    @NotBlank
    @Email(message = "Formato de email invalido")
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8, message = "Contraseña debe ser de minimo de 8 caracteres")
    private String password;

    @Transient
    private String passwordConfirmation;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Mesa> mesas;

}