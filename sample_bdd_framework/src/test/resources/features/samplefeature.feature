@googlesearch
Feature: google search
  I want to use selenium so, i would like to findout by searching in google

  @sanity
  Scenario: searching google with keyword selenium
    Given user in the http://google.com/ home page
    When user enters a keyword "selenium" in the search textbox 
    And user clicked on the google search button
    Then user should see the title of the page as "selenium - Google Search"

  @regression
  Scenario Outline: search google with multiple keywords
    Given user in the google home page
    When user search with "<keyword>" in google search text box
    And user clicked on the google search button1
    Then user should navigate to the search results page with title "<expected title>"

    Examples: 
      | keyword            | expected title                     |
      | selenium           | selenium - Google Search           |
      | selenium webdriver | selenium webdriver - Google Search |
