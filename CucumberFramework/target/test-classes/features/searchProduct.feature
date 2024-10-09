Feature: Search and Place the order for Products
@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenKart Landing Page
When User searched with ShortName <Name> and extracted actual name of product
Then User Searched for <Name> ShortName in offers page
And Validate product name in offers page matches with Landing Page

Examples:
| Name	|
|	Tom		|
|	Beet	|