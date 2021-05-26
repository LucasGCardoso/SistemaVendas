package com.bcopstein.adaptadores;

import java.util.List;

import com.bcopstein.aplicacao.UC_ConsultaDisponibilidade;
import com.bcopstein.aplicacao.UC_ConsultaHistoricoVendas;
import com.bcopstein.aplicacao.UC_ConsultaProdutos;
import com.bcopstein.aplicacao.UC_EfetivarVenda;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.aplicacao.UC_CalculaSubtotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/vendas")
public class controller {
  private UC_ConsultaProdutos consultaProdutos;
  private UC_ConsultaHistoricoVendas consultaHistoricoVendas;
  private UC_ConsultaDisponibilidade consultaEstoque;
  private UC_EfetivarVenda efetivaVenda;
  private UC_CalculaSubtotal calculaSubtotal;

  @Autowired
  public controller(UC_ConsultaProdutos consultaProdutos, UC_ConsultaHistoricoVendas consultaHistoricoVendas, UC_ConsultaDisponibilidade consultaEstoque, UC_EfetivarVenda efetivaVenda, UC_CalculaSubtotal calculaSubtotal) {
    this.consultaProdutos = consultaProdutos;
    this.consultaHistoricoVendas = consultaHistoricoVendas;
    this.consultaEstoque = consultaEstoque;
    this.efetivaVenda = efetivaVenda;
    this.calculaSubtotal = calculaSubtotal;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return this.consultaProdutos.run();
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> listaVendas() {
    return this.consultaHistoricoVendas.run();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Long codProd, @RequestParam final Integer qtdade) {
    return this.consultaEstoque.run(codProd, qtdade);
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemVenda[] itens) {
    return this.efetivaVenda.run(itens);
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer[] calculaSubtotal(@RequestBody final ItemVenda[] itens) {
    return this.calculaSubtotal.run(itens);
  }




  // @GetMapping("/autorizacao")
  // @CrossOrigin(origins = "*")

  // @PostMapping("/confirmacao")
  // @CrossOrigin(origins = "*")

  // @GetMapping("/historico")
  // @CrossOrigin(origins = "*")

  // @PostMapping("/subtotal")
  // @CrossOrigin(origins = "*")


}
