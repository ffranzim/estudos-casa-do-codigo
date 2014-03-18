package br.com.cc.validation;

import java.text.MessageFormat;
import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxAnoAtualMaisValidator implements ConstraintValidator<MaxAnoAtualMais, Integer> {

	private int valorMaximo;

	@Override
	public void initialize(MaxAnoAtualMais annotation) {
		int anosAdicionais = annotation.value();
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		valorMaximo = anoAtual + anosAdicionais;

	}

	@Override
	public boolean isValid(Integer valor, ConstraintValidatorContext context) {
		if (valor > valorMaximo) {
			String template = context.getDefaultConstraintMessageTemplate();
			String message = MessageFormat.format(template, valorMaximo);
			context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();
			return false;
		}
		return true;
	}

}
