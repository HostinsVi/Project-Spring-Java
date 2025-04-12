package ProjectSpringIO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;

@SpringBootApplication
@Controller

public class controller {

	@GetMapping
	public String index() {
		return "index";
	}

	@PostMapping
	public String calcularIMC(@RequestParam("peso") double peso, @RequestParam("altura") double altura, RedirectAttributes redirectAttrs) {

		if (peso <= 0 || altura <= 0) {
			return "redirect:/";
		}

		double imc = peso / (altura*altura);
		DecimalFormat df = new DecimalFormat("##.##");
		String valorIMC = df.format(imc);

		String indicacao;

		if (imc < 18.5) {
			indicacao = "Você está abaixo do peso ideal, vai comer uma pizza, seja feliz!";
		} else if (imc <= 24.9) {
			indicacao = "Você está no peso ideal, Parabéns!";
		} else if (imc <= 25) {
			indicacao = "Você está levemente acima do peso. uma maçã aqui e ali resolve!";
		} else if (imc <= 30) {
			indicacao = "Você está no primeiro nível de obesidade. Uma alimentação mais equilibrada é o segredo pra um eu mais equilibrado!";
		} else if (imc <= 35) {
			indicacao = "Voce está no segundo nível de obesidade. Vamo dar uma mudança no estilo de vida pra ter um futuro melhor!";
		} else {
			indicacao = "Você está no terceiro nível de obesidade. Talvez seja uma boa hora de buscar ajuda para mudar sua alimentação e melhorar sua saúde. Estamos torcendo por você!";
		}

		redirectAttrs.addFlashAttribute("peso", peso);
		redirectAttrs.addFlashAttribute("altura", altura);
		redirectAttrs.addFlashAttribute("imc", imc);
		redirectAttrs.addFlashAttribute("valorIMC", valorIMC);
		redirectAttrs.addFlashAttribute("indicacao", indicacao);

		return "redirect:/resultado";
	}

	@GetMapping("/resultado")
	public String resultado() {
		return "resultado";
	}
}

