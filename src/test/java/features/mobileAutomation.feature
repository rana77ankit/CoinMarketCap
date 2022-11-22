Feature: Mobile Tasks

  @MobileTasks @MobileTasks1
  Scenario: Verify and Launch Zoom app
    Given Launch zoom app
    And Click Join a meeting
    Then Validate Join button is disabled
    And Enter "987654321" digits meeting id
    Then Validate Join button is enabled
    And Toggle on Turn off my video
    Then Click on Join
    When Put the app in background
    And then launch it back to foreground
    Then Validate the Invalid meeting Id text in pop up

  @MobileTasks @MobileTasks2
  Scenario: Verify and Launch LinkedIn App
    Given Launch LinkedIn app
#    When Swipe left till last slide and verify the text on each one
    When Login using correct credentials

#  • Login using correct credentials.
#  • In the global search, type text ‘Callsign’
#  • Verify the ‘See all results’ button
#  • Validate that all results listings have 'Callsign' in the name
#  • Open ‘Chat’ from top right
#  • Tap on Filter icon in ‘Search messages’
#  • Filter with ‘My connections’ radio button option
#  • Verify ‘My connections’ text appears beneath with cross/cancel mark
#  • Tap on profile photo on top left and then tap on settings
#  • Scroll down to last and validate LinkedIn banner/text

  