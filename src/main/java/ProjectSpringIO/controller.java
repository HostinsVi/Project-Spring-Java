package ProjectSpringIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller

public class controller {

	@Autowired
	@Qualifier("methods")
	private Methods methods;

	@GetMapping
	public String index() {
		return "index";
	}

	@PostMapping
	public String calcularIMC(@RequestParam("peso") double peso, @RequestParam("altura") double altura, RedirectAttributes redirectAttrs) {

		if (!methods.confirmarValores(peso, altura)) {
			return "redirect:/";
		}

		double imc = methods.calcularIMC(peso, altura);
		String valorIMC = methods.formatarIMC(imc);
		String indicacao = methods.gerarIndicacao(imc);

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

