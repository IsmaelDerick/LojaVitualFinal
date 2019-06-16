package br.com.lojavirtual.negocio;


import br.com.lojavirtual.beans.Servico;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.lojavirtual.persistencia.ServicoDAO;
import java.io.FileOutputStream;



@ManagedBean(name = "servicoC")
@SessionScoped
public class ServicoCtrl implements Serializable {

    private static final long serialVersionUID = 1L;
    private String filtro = "";
    private Servico servico = new Servico();

    public List<Servico> getListagem() {
        return ServicoDAO.listagem(filtro);
    }

    public void actionGravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (servico.getId() == 0) {
            ServicoDAO.inserir(servico);
            context.addMessage(null, new FacesMessage("Sucesso", "Inserido com sucesso!"));
        } else {
            ServicoDAO.alterar(servico);
            context.addMessage(null, new FacesMessage("Sucesso", "Alterado com sucesso!"));
        }
    }

    public void actionInserir() {
        servico = new Servico();
    }

    public void actionExcluir() {
        ServicoDAO.excluir(servico);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "Excluído com sucesso!"));
    }


    private void criaArquivo(byte[] bytes, String arquivo) {
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);

            fos.flush();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String formatarNumero(double num) {
        return String.format("R$ " + "%,.2f", num);
    }

    //GET-SET
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
