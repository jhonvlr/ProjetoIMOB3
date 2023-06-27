package com.imob.model.dao;

import com.imob.model.domain.Imobiliaria;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDAO {

    private final Connection connection;

    public ImobiliariaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirImobiliaria(Imobiliaria imobiliaria) throws SQLException {
        String sql = "INSERT INTO tb_imobiliaria (id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria, tb_pessoa_juridica_id_PessoaPJ, tb_pessoa_juridica_tb_pessoa_id_Pessoa, tb_pagamento_comissao_id_Pag_Comissao) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, imobiliaria.getId_Codigo_imobiliaria());
        stmt.setInt(2, imobiliaria.getNumero_Creci());
        stmt.setInt(3, imobiliaria.getId_Imobiliaria());
        stmt.setInt(4, imobiliaria.getTb_pessoa_juridica_id_PessoaPJ());
        stmt.setInt(5, imobiliaria.getTb_pessoa_juridica_tb_pessoa_id_Pessoa());
        stmt.setInt(6, imobiliaria.getTb_pagamento_comissao_id_Pag_Comissao());
        stmt.executeUpdate();
        stmt.close();
    }

    public boolean atualizarImobiliaria(Imobiliaria imobiliaria) throws SQLException {
        String sql = "UPDATE tb_imobiliaria SET id_Codigo_imobiliaria = ?, numero_Creci = ?, tb_pessoa_juridica_id_PessoaPJ = ?, tb_pessoa_juridica_tb_pessoa_id_Pessoa = ?, tb_pagamento_comissao_id_Pag_Comissao = ? WHERE id_Imobiliaria = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, imobiliaria.getId_Codigo_imobiliaria());
            stmt.setInt(2, imobiliaria.getNumero_Creci());
            stmt.setInt(3, imobiliaria.getTb_pessoa_juridica_id_PessoaPJ());
            stmt.setInt(4, imobiliaria.getTb_pessoa_juridica_tb_pessoa_id_Pessoa());
            stmt.setInt(5, imobiliaria.getTb_pagamento_comissao_id_Pag_Comissao());
            stmt.setInt(6, imobiliaria.getId_Imobiliaria());
            System.out.println("UPDATE ID: " + imobiliaria.getId_Imobiliaria());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
            return false;
        }
    }






    public void excluirImobiliaria(Imobiliaria imobiliaria) throws SQLException {
        String sql = "DELETE FROM tb_imobiliaria WHERE id_Imobiliaria = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, imobiliaria.getId_Imobiliaria());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Imobiliaria> buscarTodasImobiliaria() throws SQLException {
        String sql = "SELECT * FROM tb_imobiliaria";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Imobiliaria> imobiliarias = new ArrayList<>();
        while (rs.next()) {
            int id_Codigo_imobiliaria = rs.getInt("id_Codigo_imobiliaria");
            int numero_Creci = rs.getInt("numero_Creci");
            int id_Imobiliaria = rs.getInt("id_Imobiliaria");
            int tb_pessoa_juridica_id_PessoaPJ = rs.getInt("tb_pessoa_juridica_id_PessoaPJ");
            int tb_pessoa_juridica_tb_pessoa_id_Pessoa = rs.getInt("tb_pessoa_juridica_tb_pessoa_id_Pessoa");
            int tb_pagamento_comissao_id_Pag_Comissao = rs.getInt("tb_pagamento_comissao_id_Pag_Comissao");

            Imobiliaria imobiliaria = new Imobiliaria(id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria, tb_pessoa_juridica_id_PessoaPJ, tb_pessoa_juridica_tb_pessoa_id_Pessoa, tb_pagamento_comissao_id_Pag_Comissao);
            imobiliarias.add(imobiliaria);
        }

        rs.close();
        stmt.close();

        return imobiliarias;
    }

    public List<Imobiliaria> lista() throws SQLException {
        String sql = "SELECT * FROM tb_imobiliaria";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Imobiliaria> imobiliarias = new ArrayList<>();
        while (rs.next()) {
            int id_Codigo_imobiliaria = rs.getInt("id_Codigo_imobiliaria");
            int numero_Creci = rs.getInt("numero_Creci");
            int id_Imobiliaria = rs.getInt("id_Imobiliaria");
            int tb_pessoa_juridica_id_PessoaPJ = rs.getInt("tb_pessoa_juridica_id_PessoaPJ");
            int tb_pessoa_juridica_tb_pessoa_id_Pessoa = rs.getInt("tb_pessoa_juridica_tb_pessoa_id_Pessoa");
            int tb_pagamento_comissao_id_Pag_Comissao = rs.getInt("tb_pagamento_comissao_id_Pag_Comissao");

            Imobiliaria imobiliaria = new Imobiliaria(id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria, tb_pessoa_juridica_id_PessoaPJ, tb_pessoa_juridica_tb_pessoa_id_Pessoa, tb_pagamento_comissao_id_Pag_Comissao);
            imobiliarias.add(imobiliaria);
        }

        rs.close();
        stmt.close();

        return imobiliarias;
    }

    public void setConnection(Connection connection) {
    }
}
