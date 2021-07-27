package ch.prodigio.vmt.demo.application.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ResourceNotFoundExceptionTest {

	@Test
	public void when_exception_is_created_then_data_can_be_retrieved() {
		ResourceNotFoundException actual = new ResourceNotFoundException(
			"::resourceName::",
			"::fieldName::",
			"::fieldValue::"
		);

		assertEquals("::resourceName::", actual.getResourceName());
		assertEquals("::fieldName::", actual.getFieldName());
		assertEquals("::fieldValue::", actual.getFieldValue());
	}

}