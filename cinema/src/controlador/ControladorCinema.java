/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.ManutencaoCinema;

import dao.DaoCinema;
import javax.swing.JOptionPane;
import modelo.Cinema;
import tela.manutencao.ManutencaoCinema;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ControladorCinema {

    public static void inserir(ManutencaoCinema man){
        Cinema objeto = new Cinema();
        objeto.setCapacidade(Integer.parseInt(man.jtfCapacidade.getText()));
        objeto.setEndereco(man.jtfEndereco.getText());
        
        boolean resultado = DaoCinema.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Capacidade");
        modelo.addColumn("Endereco");
        List<Cinema> resultados = DaoCinema.consultar();
        for (Cinema objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            
            linha.add(objeto.getCapacidade());
            linha.add(objeto.getEndereco());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
