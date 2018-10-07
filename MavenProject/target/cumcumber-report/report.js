$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("f1.feature");
formatter.feature({
  "line": 1,
  "name": "Test facebook login",
  "description": "",
  "id": "test-facebook-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Test FB Login with valid credentials",
  "description": "",
  "id": "test-facebook-login;test-fb-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "open Firefox and go to fb application",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I enter valid username and password",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user should be able to login",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeTestFB2.open_Firefox_and_go_to_fb_application()"
});
formatter.result({
  "duration": 11230045482,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTestFB2.i_enter_valid_username_and_password()"
});
formatter.result({
  "duration": 3220250570,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTestFB2.user_should_be_able_to_login()"
});
formatter.result({
  "duration": 346647152,
  "status": "passed"
});
});