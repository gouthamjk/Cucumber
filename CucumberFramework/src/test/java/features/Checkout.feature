Feature: Place the order for Products
@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenKart Landing Page
When User searched with ShortName <Name> and extracted actual name of product
And added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name	|
|	Tom		|