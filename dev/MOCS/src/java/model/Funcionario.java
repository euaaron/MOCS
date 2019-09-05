/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author euaar
 */
public class Funcionario extends Usuario {
    private int id;
    private Date dataAdmissao;
    private Boolean statusConta;
    private ArrayList<Permissao> Permissoes;
    
}
