package com.inved.domain.pedido;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TCLIENTE")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODCLI")
    private Long codigo;

    @Column(name = "NOMCLI")
    private String nome;

    @Column(name = "IDTCPF")
    private String cpf;

    @Column(name = "EMLCLI")
    private String email;

    @Column(name = "SNHCLI")
    private String senha;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
