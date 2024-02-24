package com.exemplo.sabado.sabado.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exemplo.sabado.sabado.exception.InvoiceNotFoundException;
import com.exemplo.sabado.sabado.model.Invoice;
import com.exemplo.sabado.sabado.service.IInvoiceService;

@Controller // Indica que esta classe é um controlador Spring MVC, responsável por processar pedidos HTTP.
@RequestMapping("/invoice") // Mapeia todas as requisições que começam com "/invoice" para este controlador.
public class InvoiceController {

	@Autowired // Injeção automática da instância de IInvoiceService, para usar seus métodos para operações CRUD sobre faturas.
	private IInvoiceService service;

	@GetMapping("/") // Mapeia requisições GET para "/", relativas ao caminho "/invoice", para este método.
	public String showHomePage() {
		return "homePage"; // Retorna o nome da view (página) que deve ser exibida ao usuário.
	}

	@GetMapping("/register") // Mapeia requisições GET para "/register", relativas ao caminho "/invoice", para este método.
	public String showRegistration() {
		return "registerInvoicePage"; // Retorna o nome da view para o registro de novas faturas.
	}

	@PostMapping("/save") // Mapeia requisições POST para "/save", relativas ao caminho "/invoice", para este método.
	public String saveInvoice(@ModelAttribute Invoice invoice, Model model) {
		// @ModelAttribute vincula parâmetros de solicitação a um objeto Invoice.
		
		service.saveInvice(invoice); // Salva a fatura enviada pelo formulário na base de dados.
		Long id = service.saveInvice(invoice).getId(); // Salva novamente a fatura (redundante) e obtém seu ID.
		String message = "Record with id : '" + id + "' is saved successfully !";
		model.addAttribute("message", message); // Adiciona uma mensagem de sucesso ao modelo.
		return "registerInvoicePage"; // Retorna o nome da view, permitindo ao usuário ver a mensagem de sucesso.
	}

	@GetMapping("/getAllInvoices") // Mapeia requisições GET para "/getAllInvoices", relativas ao caminho "/invoice".
	public String getAllInvoices(@RequestParam(value = "message", required = false) String message, Model model) {
		// @RequestParam obtém o parâmetro "message" da URL, se presente.
		List<Invoice> invoices = service.getAllInvoices(); // Busca todas as faturas.
		model.addAttribute("list", invoices); // Adiciona a lista de faturas ao modelo.
		model.addAttribute("message", message); // Adiciona a mensagem ao modelo, se houver.
		return "allInvoicesPage"; // Retorna o nome da view que mostra todas as faturas.
	}

	@GetMapping("/edit") // Mapeia requisições GET para "/edit", permitindo editar uma fatura existente.
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		// @RequestParam obtém o ID da fatura a ser editada.
		String page;
		try {
			Invoice invoice = service.getInvoiceById(id); // Busca a fatura pelo ID.
			model.addAttribute("invoice", invoice); // Adiciona a fatura ao modelo.
			page = "editInvoicePage"; // Define a página de edição como destino.
		} catch (InvoiceNotFoundException e) {
			// Se a fatura não for encontrada, captura a exceção.
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage()); // Adiciona a mensagem de erro aos atributos de redirecionamento.
			page = "redirect:getAllInvoices"; // Redireciona para a lista de todas as faturas.
		}
		return page; // Retorna o nome da view ou o caminho de redirecionamento.
	}

	@PostMapping("/update") // Mapeia requisições POST para "/update", permitindo atualizar uma fatura.
	public String updateInvoice(@ModelAttribute Invoice invoice, RedirectAttributes attributes) {
		// @ModelAttribute vincula os dados do formulário a um objeto Invoice.
		service.updateInvoice(invoice); // Atualiza a fatura.
		Long id = invoice.getId(); // Obtém o ID da fatura atualizada.
		attributes.addAttribute("message", "Invoice with id: '" + id + "' is updated successfully !");
		// Adiciona uma mensagem de sucesso aos atributos de redirecionamento.
		return "redirect:getAllInvoices"; // Redireciona para a lista de todas as faturas, mostrando a mensagem de sucesso.
	}

	@GetMapping("/delete") // Mapeia requisições GET para "/delete", permitindo deletar uma fatura.
	public String deleteInvoice(@RequestParam Long id, RedirectAttributes attributes) {
		// @RequestParam obtém o ID da fatura a ser deletada.
		try {
			service.deleteInvoiceById(id); // Tenta deletar a fatura pelo ID.
			attributes.addAttribute("message", "Invoice with Id : '" + id + "' is removed successfully!");
			// Adiciona uma mensagem de sucesso aos atributos de redirecionamento.
		} catch (InvoiceNotFoundException e) {
			// Se a fatura não for encontrada, captura a exceção.
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage()); // Adiciona a mensagem de erro aos atributos de redirecionamento.
		}
		return "redirect:getAllInvoices"; // Redireciona para a lista de todas as faturas, onde a mensagem será mostrada.
	}
}
