package com.imob.view;

import com.imob.model.dao.ImobiliariaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Imobiliaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLImobiliariaController implements Initializable {

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private ImobiliariaDAO imobiliariaDAO = new ImobiliariaDAO(connection);

    @FXML
    private Button lblFecharImobiliaria;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imobiliariaDAO.setConnection(connection);
    }


    @FXML
    private Button lblFecharImobiliaria(ActionEvent event) {
        Stage st = (Stage) lblFecharImobiliaria.getScene().getWindow();
        st.close();
        return null;
    }

    // Construtor
    public FXMLImobiliariaController() {
        // Configurar conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/bd_imob";
        String username = "root";
        String password = "7273";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            imobiliariaDAO = new ImobiliariaDAO(connection);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    @FXML
    // Método para adicionar uma nova imobiliária
    public void adicionarImobiliaria(int id_Codigo_imobiliaria, int numero_Creci) {
        Imobiliaria imobiliaria = new Imobiliaria(0, id_Codigo_imobiliaria, numero_Creci);

        imobiliariaDAO.inserirImobiliaria(imobiliaria);
        System.out.println("Imobiliária adicionada com sucesso!");
    }

    @FXML
    // Método para atualizar uma imobiliária existente
    public void atualizarImobiliaria(int id_Imobiliaria, int id_Codigo_imobiliaria, int numero_Creci) {
        Imobiliaria imobiliaria = new Imobiliaria(id_Imobiliaria, id_Codigo_imobiliaria, numero_Creci);

        imobiliariaDAO.atualizarImobiliaria(imobiliaria);
        System.out.println("Imobiliária atualizada com sucesso!");
    }

    @FXML
    // Método para excluir uma imobiliária
    public void excluirImobiliaria(int id_Imobiliaria) {
        Imobiliaria imobiliaria = new Imobiliaria(id_Imobiliaria, 0, 0);
        imobiliariaDAO.excluirImobiliaria(imobiliaria);
        System.out.println("Imobiliária excluída com sucesso!");
    }

    @FXML
    // Método para buscar todas as imobiliárias
    public List<Imobiliaria> buscarTodasImobiliaria() {
        return imobiliariaDAO.buscarTodasImobiliaria();
    }

    public void adicionarImobiliaria(ActionEvent actionEvent) {
    }

    public void pesquisarImobiliaria(ActionEvent actionEvent) {
    }

    public void atualizarImobiliaria(ActionEvent actionEvent) {
    }

    public void excluirImobiliaria(ActionEvent actionEvent) {
    }
}
