package com.imob.model.domain;

public class Imobiliaria extends PessoaJuridica {

    private int id_Imobiliaria;
    private int id_Codigo_imobiliaria;
    private int numero_Creci;
    private int tb_pessoa_juridica_id_PessoaPJ;
    private int tb_pessoa_juridica_tb_pessoa_id_Pessoa;
    private int tb_pagamento_comissao_id_Pag_Comissao;

    public Imobiliaria(int id_Imobiliaria, int id_Codigo_imobiliaria, int numero_Creci, int tb_pessoa_juridica_id_PessoaPJ) {
        this.id_Imobiliaria = id_Imobiliaria;
        this.id_Codigo_imobiliaria = id_Codigo_imobiliaria;
        this.numero_Creci = numero_Creci;
        this.tb_pessoa_juridica_id_PessoaPJ = tb_pessoa_juridica_id_PessoaPJ;
    }

    public Imobiliaria(int idCodigoImobiliaria, int numeroCreci, int idImobiliaria, int tb_pessoa_juridica_id_PessoaPJ, int tb_pessoa_juridica_tb_pessoa_id_Pessoa, int tb_pagamento_comissao_id_Pag_Comissao) {
        super();
        this.id_Imobiliaria = idImobiliaria;
        this.id_Codigo_imobiliaria = idCodigoImobiliaria;
        this.numero_Creci = numeroCreci;
        this.tb_pessoa_juridica_id_PessoaPJ = tb_pessoa_juridica_id_PessoaPJ;
        this.tb_pessoa_juridica_tb_pessoa_id_Pessoa = tb_pessoa_juridica_tb_pessoa_id_Pessoa;
        this.tb_pagamento_comissao_id_Pag_Comissao = tb_pagamento_comissao_id_Pag_Comissao;
    }

    public int getId_Imobiliaria() {
        return id_Imobiliaria;
    }

    public void setId_Imobiliaria(int id_Imobiliaria) {
        this.id_Imobiliaria = id_Imobiliaria;
    }

    public int getId_Codigo_imobiliaria() {
        return id_Codigo_imobiliaria;
    }

    public void setId_Codigo_imobiliaria(int id_Codigo_imobiliaria) {
        this.id_Codigo_imobiliaria = id_Codigo_imobiliaria;
    }

    public int getNumero_Creci() {
        return numero_Creci;
    }

    public void setNumero_Creci(int numero_Creci) {
        this.numero_Creci = numero_Creci;
    }

    public int getTb_pessoa_juridica_id_PessoaPJ() {
        return tb_pessoa_juridica_id_PessoaPJ;
    }

    public void setTb_pessoa_juridica_id_PessoaPJ(int tb_pessoa_juridica_id_PessoaPJ) {
        this.tb_pessoa_juridica_id_PessoaPJ = tb_pessoa_juridica_id_PessoaPJ;
    }

    public int getTb_pessoa_juridica_tb_pessoa_id_Pessoa() {
        return tb_pessoa_juridica_tb_pessoa_id_Pessoa;
    }

    public void setTb_pessoa_juridica_tb_pessoa_id_Pessoa(int tb_pessoa_juridica_tb_pessoa_id_Pessoa) {
        this.tb_pessoa_juridica_tb_pessoa_id_Pessoa = tb_pessoa_juridica_tb_pessoa_id_Pessoa;
    }

    public int getTb_pagamento_comissao_id_Pag_Comissao() {
        return tb_pagamento_comissao_id_Pag_Comissao;
    }

    public void setTb_pagamento_comissao_id_Pag_Comissao(int tb_pagamento_comissao_id_Pag_Comissao) {
        this.tb_pagamento_comissao_id_Pag_Comissao = tb_pagamento_comissao_id_Pag_Comissao;
    }
}
