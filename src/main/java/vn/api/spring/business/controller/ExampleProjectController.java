package vn.api.spring.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vn.api.spring.business.application.issue.delete.DeleteIssueApplication;
import vn.api.spring.business.application.issue.delete.DeleteIssueInput;
import vn.api.spring.business.application.issue.register.RegisterIssueApplication;
import vn.api.spring.business.application.issue.register.RegisterIssueInput;
import vn.api.spring.business.application.issue.request.RequestIssueApplication;
import vn.api.spring.business.application.issue.request.RequestIssueInput;
import vn.api.spring.business.application.issue.request.RequestIssueOutput;
import vn.api.spring.business.application.issue.update.UpdateIssueApplication;
import vn.api.spring.business.application.issue.update.UpdateIssueInput;
import vn.api.spring.business.application.user.delete.DeleteUserApplication;
import vn.api.spring.business.application.user.delete.DeleteUserInput;
import vn.api.spring.business.application.user.register.RegisterUserApplication;
import vn.api.spring.business.application.user.register.RegisterUserInput;
import vn.api.spring.business.application.user.request.RequestUserApplication;
import vn.api.spring.business.application.user.request.RequestUserInput;
import vn.api.spring.business.application.user.request.RequestUserOutput;
import vn.api.spring.business.application.user.update.UpdateUserApplication;
import vn.api.spring.business.application.user.update.UpdateUserInput;
import vn.api.spring.business.domain.exception.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class ExampleProjectController {
	private final RequestIssueApplication requestIssueApplication;
	private final RegisterIssueApplication registerIssueApplication;
	private final UpdateIssueApplication updateIssueApplication;
	private final DeleteIssueApplication deleteIssueApplication;
	private final RequestUserApplication requestUserApplication;
	private final RegisterUserApplication registerUserApplication;
	private final UpdateUserApplication updateUserApplication;
	private final DeleteUserApplication deleteUserApplication;

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
	private void sessionIssueUpdatePost(@PathVariable("id") int id, @RequestBody UpdateIssueInput input) {
		input = UpdateIssueInput.builder().id(id).type(input.type()).createDate(input.createDate()).build();
		updateIssueApplication.start(input);
	}

	@RequestMapping(value = "/issue/delete/{id}", produces = { "application/json" }, method = RequestMethod.POST)
	private void sessionIssueDeletePost(@PathVariable("id") int id) {
		DeleteIssueInput input = DeleteIssueInput.builder().id(id).build();
		deleteIssueApplication.start(input);
	}

	@RequestMapping(value = "/user/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	private ResponseEntity<RequestUserOutput> sessionUserImformationGet(@PathVariable("id") int id)
			throws NoSuchElementException {
		RequestUserInput input = RequestUserInput.builder().id(id).build();
		RequestUserOutput output = requestUserApplication.start(input);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/create", produces = { "application/json" }, method = RequestMethod.POST)
	private void sessionUserCreatePost(@RequestBody RegisterUserInput input) {
		registerUserApplication.start(input);
	}

	@RequestMapping(value = "/user/update/{id}", produces = { "application/json" }, method = RequestMethod.POST)
	private void sessionUserUpdatePost(@PathVariable("id") int id, @RequestBody UpdateUserInput input) {
		input = UpdateUserInput.builder().id(input.id()).account(input.account()).name(input.name())
				.password(input.password()).email(input.email()).address(input.address())
				.permissionType(input.permissionType()).createDate(input.createDate()).build();
		updateUserApplication.start(input);
	}

	@RequestMapping(value = "/user/delete/{id}", produces = { "application/json" }, method = RequestMethod.POST)
	private void sessionUserDeletePost(@PathVariable("id") int id) {
		DeleteUserInput input = DeleteUserInput.builder().id(id).build();
		deleteUserApplication.start(input);
	}
}
