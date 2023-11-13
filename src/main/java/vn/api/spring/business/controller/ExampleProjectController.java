package vn.api.spring.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.application.issue.register.RegisterIssueApplication;
import vn.api.spring.business.application.issue.register.RegisterIssueInput;
import vn.api.spring.business.application.issue.request.RequestIssueApplication;
import vn.api.spring.business.application.issue.request.RequestIssueInput;
import vn.api.spring.business.application.issue.request.RequestIssueOutput;
import vn.api.spring.business.application.issue.update.UpdateIssueApplication;
import vn.api.spring.business.application.issue.update.UpdateIssueInput;
import vn.api.spring.business.domain.exception.NoSuchElementException;

@RestController
@RequiredArgsConstructor

public class ExampleProjectController {
	private final RequestIssueApplication requestIssueApplication;
	private final RegisterIssueApplication registerIssueApplication;
	private final UpdateIssueApplication updateIssueApplication;

	@RequestMapping(value = "/issue/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	private ResponseEntity<RequestIssueOutput> sessionIssueImformationGet(@PathVariable("id") int id)
			throws NoSuchElementException {
		RequestIssueInput input = RequestIssueInput.builder().id(id).build();
		RequestIssueOutput output = requestIssueApplication.start(input);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@RequestMapping(value = "/issue/create", produces = { "application/json" }, method = RequestMethod.POST)
	private void sessionIssueCreatePost(@RequestBody RegisterIssueInput input) {
		registerIssueApplication.start(input);
	}
	
	@RequestMapping(value = "/issue/update/{id}", produces = { "application/json" }, method = RequestMethod.POST)
	private void sessionIssueUpdatePost(@PathVariable("id") int id,@RequestBody UpdateIssueInput input) {
		input = UpdateIssueInput.builder().id(id).type(input.type()).createDate(input.createDate()).updateDate(input.updateDate()).build();
		updateIssueApplication.start(input);
	}
}
