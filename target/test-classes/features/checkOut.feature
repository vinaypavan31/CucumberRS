Feature: Place the order for products
@PlaceOrder
Scenario Outline: Search experience for the product search i both home and offers page

Given User is on Greenkart landing page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout  and validate the <Name> items in checkout page
And verify the user has ability to enter promocode and place the order 
Examples:
|Name|
|Tom|

	
