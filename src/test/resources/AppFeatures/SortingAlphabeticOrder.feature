Feature: Verify Sorting names Alphabetic order

Scenario: Test sorting last names by alphabetic order in table1
Given user is on Data tables page
When user click on sort lastname for Data table "table1"
Then verify the names are sorted in A-Z order for "table1"
When user click on sort lastname for Data table "table1"
Then verify the names are sorted in Z-A order for "table1"

Scenario: Test sorting last names by alphabetic order in table2
Given user is on Data tables page
When user click on sort lastname for Data table "table2"
Then verify the names are sorted in A-Z order for "table2"
When user click on sort lastname for Data table "table2"
Then verify the names are sorted in Z-A order for "table2"