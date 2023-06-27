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
    private Connection connection;

    public ImobiliariaDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserirImobiliaria(Imobiliaria imobiliaria) throws SQLException {
        String sql = "INSERT INTO tb_imobiliaria (id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, imobiliaria.getId_Codigo_imobiliaria());
            stmt.setInt(2, imobiliaria.getNumero_Creci());
            stmt.setInt(3, imobiliaria.getId_Imobiliaria());

            stmt.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }
    }

    public boolean atualizarImobiliaria(Imobiliaria imobiliaria) throws SQLException {
        String sql = "UPDATE tb_imobiliaria SET id_Codigo_imobiliaria = ?, numero_Creci = ? WHERE id_Imobiliaria = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, imobiliaria.getId_Codigo_imobiliaria());
            stmt.setInt(2, imobiliaria.getNumero_Creci());
            stmt.setInt(3, imobiliaria.getId_Imobiliaria());

            stmt.executeUpdate();

        }
        return false;
    }

    public boolean excluirImobiliaria(Imobiliaria imobiliaria)throws SQLException {
        String sql = "DELETE FROM tb_imobiliaria WHERE id_Imobiliaria = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, imobiliaria.getId_Imobiliaria());

            stmt.executeUpdate();
        }
        return false;
    }

    public List<Imobiliaria> buscarTodasImobiliaria() throws SQLException {
        List<Imobiliaria> imobiliarias = new ArrayList<>();
        String sql = "SELECT * FROM tb_imobiliaria";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                int id_Imobiliaria = resultado.getInt("id_Imobiliaria");
                int id_Codigo_imobiliaria = resultado.getInt("id_Codigo_imobiliaria");
                int numero_Creci = Integer.parseInt(resultado.getString("numero_Creci"));

                Imobiliaria imobiliaria = new Imobiliaria(id_Imobiliaria, id_Codigo_imobiliaria, numero_Creci);
                imobiliarias.add(imobiliaria);
            }
        }
        return imobiliarias;
    }
}
