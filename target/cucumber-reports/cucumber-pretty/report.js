$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Actions.feature");
formatter.feature({
  "name": "First testcase",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login and Launch",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch and Login with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "ActionStepDef.Launch_logon()"
});
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "status": "passed"
});
});