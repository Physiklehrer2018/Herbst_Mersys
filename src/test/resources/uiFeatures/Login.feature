#US_001 As a user I should be able to access the homepage
    #https://test.mersys.io/
    #The homepage must be accessible when the Url entered
    #By Mehmet Bozabali
    @smoke
    Feature: US_001 As a user I should be able to access the homepage

        Background:
            Given The user goes to homepage
            Then The user verifies that the url is "https://test.mersys.io/"

        Scenario: US_001_TC_01 The user is on the homepage

            @test1
        Scenario: US_001_TC_02 The user uses the right credentials
            When The user enters with the right credentials
            Then The user should login successfully

        Scenario: US_001_TC_03 The user uses the wrong credentials
            When The user enters with the right username but wrong password
            Then The user should not login successfully

        Scenario: US_001_TC_04 The user uses the wrong credentials
            When The user enters with the wrong username but right password
            Then The user should not login successfully





