package ch.prodigio.vmt.demo.application.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Gloria R. Leyva Jerez
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FileCsvErrorException extends RuntimeException {

	private static final long serialVersionUID = 6019553804512089739L;
	private String message;

	public FileCsvErrorException(String message) {
		super(message);
		this.message = message;
	}
}
