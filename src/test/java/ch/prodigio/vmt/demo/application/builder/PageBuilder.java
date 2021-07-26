package ch.prodigio.vmt.demo.application.builder;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageBuilder {

	public Pageable build(int page, int size, String sort) {
		return PageRequest.of(page, size, Sort.by(sort));
	}
}