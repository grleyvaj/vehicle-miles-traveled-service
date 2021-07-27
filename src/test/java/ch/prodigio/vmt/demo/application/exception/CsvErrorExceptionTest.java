package ch.prodigio.vmt.demo.application.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CsvErrorExceptionTest {

	@Test
	public void when_exception_is_created_then_data_can_be_retrieved() {
		FileCsvErrorException actual = new FileCsvErrorException("::message::");

		assertEquals("::message::", actual.getMessage());
	}

}