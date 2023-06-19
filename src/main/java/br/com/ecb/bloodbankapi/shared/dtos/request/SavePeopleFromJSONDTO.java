package br.com.ecb.bloodbankapi.shared.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SavePeopleFromJSONDTO {
    @NotEmpty(message = "'nome' is required.")
    public String nome;

    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$\n", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "CPF is invalid.")
    @NotEmpty(message = "'cpf' is required.")
    public String cpf;

    @NotEmpty(message = "'rg' is required.")
    public String rg;

    @NotEmpty(message = "'data_nasc' is required.")
    public String data_nasc;

    @NotEmpty(message = "'sexo' is required.")
    public String sexo;

    @NotEmpty(message = "'mae' is required.")
    public String mae;

    @NotEmpty(message = "'pai' is required.")
    public String pai;

    @NotEmpty(message = "'email' is required.")
    public String email;

    @NotEmpty(message = "'cep' is required.")
    public String cep;

    @NotEmpty(message = "'endereco' is required.")
    public String endereco;

    @NotEmpty(message = "'numero' is required.")
    public Integer numero;

    @NotEmpty(message = "'bairro' is required.")
    public String bairro;

    @NotEmpty(message = "'cidade' is required.")
    public String cidade;

    @NotEmpty(message = "'estado' is required.")
    public String estado;

    @NotEmpty(message = "'telefone_fixo' is required.")
    public String telefone_fixo;

    @NotEmpty(message = "'celular' is required.")
    public String celular;

    @NotEmpty(message = "'altura' is required.")
    public Double altura;

    @NotEmpty(message = "'peso' is required.")
    public Double peso;

    @NotEmpty(message = "'tipo_sanguineo' is required.")
    public String tipo_sanguineo;
}
