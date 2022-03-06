###############################################
############### CLARITI ASSESSMENT ############
###############################################

Feature: Search functionality on Air Canada website

  @Search
  Scenario: Validate Search functionality on Air Canada website
    Given User open the "chrome" browser
    And open the AirCanada home page
    When user click on the Flight tab
    And select the trip type as Round trip
    And Set the trip Origin as "YVR"
    And Set the trip destination as "YYZ"
    And Set Departure date "15/07"
    And Set  Return date "22/07"
    And click the Find button
    And Wait for the Select Flights page to be displayed
    Then validate the display date on search results page
    And validate various ranges are displayed for the tickets
    Then close the browser