package com.imob.view;

import com.imob.model.dao.ImobiliariaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Imobiliaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Imobiliaria, Integer> tbPessoaPJ;
    @FXML
    private TableColumn<Imobiliaria, Integer> tbPessoaIdPessoa;
    @FXML
    private TableColumn<Imobiliaria, Integer> tbPagComissao;
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
    private Label lblPessoaPj;
    @FXML
    private Label lblPagcomissao;
    @FXML
    private Label lblIdImobiliaria;
    @FXML
    private Label lblCodigoImobiliaria;
    @FXML
    private Label lblPessoaId;
    @FXML
    private TextField tfCodigoCreci;
    @FXML
    private TextField tfIdImobiliaria;
    @FXML
    private TextField tfPessoaPj;
    @FXML
    private TextField tfPessoaId;
    @FXML
    private TextField tfPagcomissao;
    @FXML
    private TextField tfCodigoImobiliaria;

    @FXML
    private Label lblFecharImobiliaria;
    private List<Imobiliaria> listImobiliaria;
    private ObservableList<Imobiliaria> observableImobiliaria;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imobiliariaDAO.setConnection(connection);
        try {
            carregaImobiliariaNaTableView();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Controlador inicializado");
    }

    @FXML
    private void fecharImobiliaria(MouseEvent event) {
        Stage stage = (Stage) lblFecharImobiliaria.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void adicionarImobiliaria(ActionEvent event) {
        int id_Codigo_imobiliaria = Integer.parseInt(tfCodigoImobiliaria.getText());
        int numero_Creci = Integer.parseInt(tfCodigoCreci.getText());
        int id_Imobiliaria = Integer.parseInt(tfIdImobiliaria.getText());
        int tb_pessoa_juridica_id_PessoaPJ = Integer.parseInt(tfPessoaPj.getText());
        int tb_pessoa_juridica_tb_pessoa_id_Pessoa = Integer.parseInt(tfPessoaId.getText());
        int tb_pagamento_comissao_id_Pag_Comissao = Integer.parseInt(tfPagcomissao.getText());

        Imobiliaria imobiliaria = new Imobiliaria(id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria, tb_pessoa_juridica_id_PessoaPJ, tb_pessoa_juridica_tb_pessoa_id_Pessoa, tb_pagamento_comissao_id_Pag_Comissao);

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
        int id_Imobiliaria = Integer.parseInt(tfIdImobiliaria.getText());
        int tb_pessoa_juridica_id_PessoaPJ = Integer.parseInt(tfPessoaPj.getText());
        int tb_pessoa_juridica_tb_pessoa_id_Pessoa = Integer.parseInt(tfPessoaId.getText());
        int tb_pagamento_comissao_id_Pag_Comissao = Integer.parseInt(tfPagcomissao.getText());

        Imobiliaria imobiliaria = new Imobiliaria(id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria, tb_pessoa_juridica_id_PessoaPJ, tb_pessoa_juridica_tb_pessoa_id_Pessoa, tb_pagamento_comissao_id_Pag_Comissao);

        try {
            imobiliariaDAO.atualizarImobiliaria(imobiliaria);
            System.out.println("Imobiliária atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar imobiliária: " + e.getMessage());
        }
    }

    @FXML
    private void excluirImobiliaria(ActionEvent event) {
        int id_Imobiliaria = Integer.parseInt(tfIdImobiliaria.getText());

        try {
            Imobiliaria imobiliaria = new Imobiliaria(0, 0, id_Imobiliaria, 0, 0, 0);
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

    public void carregaImobiliariaNaTableView() throws SQLException {
        tbCreci.setCellValueFactory(new PropertyValueFactory<>("numero_Creci"));
        tbIdImobiliaria.setCellValueFactory(new PropertyValueFactory<>("id_Imobiliaria"));
        tbCodigoImobiliaria.setCellValueFactory(new PropertyValueFactory<>("id_Codigo_imobiliaria"));
        tbPessoaPJ.setCellValueFactory(new PropertyValueFactory<>("tb_pessoa_juridica_id_PessoaPJ"));
        tbPessoaIdPessoa.setCellValueFactory(new PropertyValueFactory<>("tb_pessoa_juridica_tb_pessoa_id_Pessoa"));
        tbPagComissao.setCellValueFactory(new PropertyValueFactory<>("tb_pagamento_comissao_id_Pag_Comissao"));

        listImobiliaria = imobiliariaDAO.lista();
        observableImobiliaria = FXCollections.observableArrayList(listImobiliaria);
        tableViewImobiliaria.setItems(observableImobiliaria);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {
        Imobiliaria imobiliaria = tableViewImobiliaria.getSelectionModel().getSelectedItem();
        if (imobiliaria != null) {
            tfCodigoCreci.setText(String.valueOf(imobiliaria.getNumero_Creci()));
            tfIdImobiliaria.setText(String.valueOf(imobiliaria.getId_Imobiliaria()));
            tfCodigoImobiliaria.setText(String.valueOf(imobiliaria.getId_Codigo_imobiliaria()));
            tfPessoaPj.setText(String.valueOf(imobiliaria.getTb_pessoa_juridica_id_PessoaPJ()));
            tfPessoaId.setText(String.valueOf(imobiliaria.getTb_pessoa_juridica_tb_pessoa_id_Pessoa()));
            tfPagcomissao.setText(String.valueOf(imobiliaria.getTb_pagamento_comissao_id_Pag_Comissao()));
        }
    }
}
