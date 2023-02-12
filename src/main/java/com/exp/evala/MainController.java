package com.exp.evala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String homePage()
	{
		System.out.println("Entering Home Page");
		return "home";
	}
	
	@RequestMapping("/submitPostfix")
	public String infixToPostFix(HttpServletRequest req, Model model)
	{
		System.out.println("Inside infixToPostFix Method");
		String expression = req.getParameter("expression");
		expression = expression.replaceAll("\\s", "");
		model.addAttribute("Expression", expression);
		System.out.println("Infix Expression: " + expression);
		String postFix=InfixToPostfix.infixToPostfix(expression);
		System.out.println("Postfix Exoression:" + postFix);
		model.addAttribute("PostFix", "Postfix: ");
		model.addAttribute("postfixExpression", postFix);
		return "home";
		
	}
	
	@RequestMapping("/submitPrefix")
	public String infixToPreFix(HttpServletRequest req, Model model)
	{
		System.out.println("Inside infixToPrefix Method");
		String expression = req.getParameter("expression");
		expression = expression.replaceAll("\\s", "");
		model.addAttribute("Expression", expression);
		
		System.out.println("Infix Expression: " + expression);
		String postFix=InfixToPrefix.infixToPrefix(expression);
		System.out.println("Prefix Exoression:" + postFix);
		model.addAttribute("PreFix", "Prefix: ");
		model.addAttribute("prefixExpression", postFix);
		return "home";
		
	}
}
