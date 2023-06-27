package com.imob.view;

import com.imob.model.dao.EstadosDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Estados;
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLTesteController implements Initializable {
    @FXML
    private AnchorPane apTeste;
    @FXML
    private Label lblFecharTeste;
    @FXML
    private TextField txtCodigoEstado;
    @FXML
    private TextField txtNomeEstado;
    @FXML
    private TextField txtSiglaEstado;
    @FXML
    private TableView<Estados> tbEstados;
    @FXML
    private TableColumn<Estados, Integer> colunaCodigoEstado;
    @FXML
    private TableColumn<Estados, String> colunaNomeEstado;
    @FXML
    private TableColumn<Estados, String> colunaSiglaEstado;
    @FXML
    private Button btnSalvar;

    //buscar os dados do banco de dados com um List
    private List<Estados> listEstados;
    //jogar  na ViemTable com o ObservableList, é necessário usar
    private ObservableList<Estados> observableEstados;

    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final EstadosDAO estadosDAO = new EstadosDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        estadosDAO.setConnection(connection);

        carregaEstadosNaTableView();
    }

    //método para poder trabalhar com os Estados no banco
    public void carregaEstadosNaTableView()
    {
        colunaCodigoEstado.setCellValueFactory(new PropertyValueFactory<>("id_Estado"));
        colunaNomeEstado.setCellValueFactory(new PropertyValueFactory<>("nome_Estado"));
        colunaSiglaEstado.setCellValueFactory(new PropertyValueFactory<>("sigla_Estado"));

        listEstados = estadosDAO.lista();

        observableEstados = FXCollections.observableArrayList(listEstados);
        tbEstados.setItems(observableEstados);
    }

    @FXML
    private void fecharTeste(MouseEvent event) {

        Stage st = (Stage) lblFecharTeste.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        Estados estados = new Estados();
        estados.setNome_Estado(txtNomeEstado.getText());
        estados.setSigla_Estado(txtSiglaEstado.getText());
        estadosDAO.inserir(estados);
        limparCampos();
        carregaEstadosNaTableView();
    }
    @FXML
    public void limparCampos()
    {
        txtCodigoEstado.setText("");
        txtNomeEstado.setText("");
        txtSiglaEstado.setText("");
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {
        txtCodigoEstado.setText(String.valueOf(tbEstados.getSelectionModel().getSelectedItem().getId_Estado()));
        txtNomeEstado.setText(tbEstados.getSelectionModel().getSelectedItem().getNome_Estado());
        txtSiglaEstado.setText(tbEstados.getSelectionModel().getSelectedItem().getSigla_Estado());
    }
    @FXML
    private void deletarDadosSelecionados(ActionEvent event) {
        Estados estados = new Estados();
        estados.setId_Estado(Integer.parseInt(txtCodigoEstado.getText()));
        estadosDAO.remover(estados);
        limparCampos();
        carregaEstadosNaTableView();
    }
    @FXML
    private void atualizarDadosSelecionados(ActionEvent event) {
        Estados estados = new Estados();
        estados.setNome_Estado(txtNomeEstado.getText());
        estados.setSigla_Estado(txtSiglaEstado.getText());
        estados.setId_Estado(Integer.parseInt(txtCodigoEstado.getText()));
        estadosDAO.alterar(estados);
        limparCampos();
        carregaEstadosNaTableView();
    }

}

