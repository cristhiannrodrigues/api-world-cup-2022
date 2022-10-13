package br.com.cristhiannrodrigues.worldcup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginApiDTO {

    private String email;
    private String password;

}
