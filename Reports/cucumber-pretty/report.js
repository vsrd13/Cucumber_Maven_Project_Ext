$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Testing the Login Feature of any website",
  "description": "I want to use this template for my feature file",
  "id": "testing-the-login-feature-of-any-website",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 4,
      "value": "#@tag1"
    }
  ],
  "line": 5,
  "name": "Login Functionality",
  "description": "",
  "id": "testing-the-login-feature-of-any-website;login-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user will navigates to \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user log in using \"\u003cUserName\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "click on login button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user login should be successful",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "testing-the-login-feature-of-any-website;login-functionality;",
  "rows": [
    {
      "cells": [
        "URL",
        "UserName",
        "Password"
      ],
      "line": 12,
      "id": "testing-the-login-feature-of-any-website;login-functionality;;1"
    },
    {
      "cells": [
        "https://www.gmail.com",
        "vertuser2@vertex.local",
        "U@tP@ssw0rd"
      ],
      "line": 13,
      "id": "testing-the-login-feature-of-any-website;login-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Login Functionality",
  "description": "",
  "id": "testing-the-login-feature-of-any-website;login-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user will navigates to \"https://www.gmail.com\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user log in using \"vertuser2@vertex.local\" and \"U@tP@ssw0rd\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "click on login button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user login should be successful",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.gmail.com",
      "offset": 24
    }
  ],
  "location": "StepDefinitionsLogin.user_will_navigates_to(String)"
});
formatter.result({
  "duration": 184627714,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "vertuser2@vertex.local",
      "offset": 19
    },
    {
      "val": "U@tP@ssw0rd",
      "offset": 48
    }
  ],
  "location": "StepDefinitionsLogin.user_log_in_using_and(String,String)"
});
formatter.result({
  "duration": 318175,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionsLogin.click_on_login_button()"
});
formatter.result({
  "duration": 217676,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionsLogin.user_login_should_be_successful()"
});
formatter.result({
  "duration": 236921,
  "status": "passed"
});
});