package com.imob.view;

import com.imob.model.dao.ImobiliariaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Imobiliaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLImobiliariaController implements Initializable {

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private ImobiliariaDAO imobiliariaDAO = new ImobiliariaDAO(connection);

    @FXML
    private TableView<Imobiliaria> tableViewImobiliaria;
    @FXML
    private TableColumn<Imobiliaria, Integer> tbCreci;
    @FXML
    private TableColumn<Imobiliaria, Integer> tbIdImobiliaria;
    @FXML
    private TableColumn<Imobiliaria, Integer> tbCodigoImobiliaria;
    @FXML
    private Button btInserir;
    @FXML
    private Button btPesquisar;
    @FXML
    private Button btAtualizar;
    @FXML
    private Button btDeletar;
    @FXML
    private Label lblCodigoCreci;
    @FXML
    private TextField tfCodigoCreci;
    @FXML
    private Label lblCodigoImobiliaria;
    @FXML
    private TextField tfIdImobiliaria;
    @FXML
    private TextField tfCodigoImobiliaria;

    public FXMLImobiliariaController(TableView<Imobiliaria> tableViewImobiliaria) {
        this.tableViewImobiliaria = tableViewImobiliaria;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imobiliariaDAO.setConnection(connection);
    }

    @FXML
    private void fecharImobiliaria(MouseEvent event) {
        Stage stage = (Stage) lblCodigoImobiliaria.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void adicionarImobiliaria(ActionEvent event) {
        int id_Codigo_imobiliaria = Integer.parseInt(tfCodigoImobiliaria.getText());
        int numero_Creci = Integer.parseInt(tfCodigoCreci.getText());
        int id_imobiliaria = Integer.parseInt(tfIdImobiliaria.getText());

        Imobiliaria imobiliaria = new Imobiliaria(id_Codigo_imobiliaria, numero_Creci, id_imobiliaria);

        try {
            imobiliariaDAO.inserirImobiliaria(imobiliaria);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void atualizarImobiliaria(ActionEvent event) {
        int id_Codigo_imobiliaria = Integer.parseInt(tfCodigoImobiliaria.getText());
        int numero_Creci = Integer.parseInt(tfCodigoCreci.getText());
        int id_imobiliaria = Integer.parseInt(tfIdImobiliaria.getText());

        Imobiliaria imobiliaria = new Imobiliaria(id_Codigo_imobiliaria, numero_Creci, id_imobiliaria);

        try {
            imobiliariaDAO.atualizarImobiliaria(imobiliaria);
            System.out.println("Imobiliária atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar imobiliária: " + e.getMessage());
        }
    }

    @FXML
    private void excluirImobiliaria(ActionEvent event) {
        int id_imobiliaria = Integer.parseInt(tfIdImobiliaria.getText());

        try {
            Imobiliaria imobiliaria = new Imobiliaria(id_imobiliaria, 0, 0);
            imobiliariaDAO.excluirImobiliaria(imobiliaria);
            System.out.println("Imobiliária excluída com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir imobiliária: " + e.getMessage());
        }
    }

    @FXML
    private List<Imobiliaria> buscarTodasImobiliaria() {
        try {
            return imobiliariaDAO.buscarTodasImobiliaria();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar imobiliárias: " + e.getMessage());
            return null;
        }
    }
}
