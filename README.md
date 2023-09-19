# Final Project

# Members, Roles, Github Repositories, LinkedIn, and Email

Amanda Gonzalez 
- Scrum Master 
- amandue10 
- https://www.linkedin.com/in/amanda-gonzalez-40a61818b/ 
- amanda.christine.gonzalez@gmail.com

Isaac Mina 
- Database Administrator 
- imina93 https://www.linkedin.com/in/isaac-mina-048b52224/ 
- isaacmina93@gmail.com

Jessia Armendariz
- Developer
- jessicarmendariz
- https://www.linkedin.com/in/jessica-armendariz-7517291b7/
- jessica.n.armendariz@gmail.com

Ken Hiveley 
- Repository Owner 
- Khiveley 
- https://www.linkedin.com/in/ken-hiveley/ 
- kenneth.hiveley@gmail.com



# Overview

Quarantine has changed how we interact with the world...or don't.  With all the
time at home, it can be a challenge to find things to do for entertainment.
With all the streaming options and hundreds of channels at your fingertips,
there are only so many episodes of Dance Moms, Keeping Up With The Kardashians
or other blasé programming that one can watch before they go insane.  Enter
BorrowIt, your source for borrowed entertainment!  We created a peer to peer
loaning site where registered users can share what they are willing to let
others borrow.  In the process, perhaps friendships are also formed?

# How to Use

This has been deployed to AWS.  Please use this link: http://3.143.202.149:8080/BorrowIt/
Upon start, you will be taken to the landing page upon which you can view items that are
 available to borrow.  When you click on an item, you will be taken to an error
 page providing that to borrow an item you will need to be logged in.  On the
 page(/mustLogIn), as a returning user, you have the ability to click Login. As
 a new user, click the Register link in the navbar.

 The register page allows for taking user inputs for username, email, etc. that
 when completed you will click Register Account.  Registering routes you to the user page which shows an
 inventory of items available for borrowing.

 If you as a user, do not see a specific item listed in our inventory,
 you are welcome to add it to the inventory by providing its image as a url, a
 title, description, and its category from the dropdown and then click Add Product.

 Your specific version of an item in our catalog (an item you are willing to loan) is able to be
 created by first clicking on the product and then providing details regarding
 its quality and version as well as clicking available followed by
 Add Product Item.  This specific item is then added to the borrowing pool of our
 items and viewable by clicking home and then the specific item from the list. When clicked
 the item of interest can then be borrowed by clicking the Borrow button.

 Additional features are the ability to Logout and an About page.

# Technologies Used

* Angular
* Spring Boot
* Spring Security
* Gradle
* TypeScript
* Java
* JavaScript
* HTML 5
* CSS
* TDD
* MySQL Workbench (SQL)

# Application Expected Routes

| Return Type        | Route                        | Functionality                           |
|--------------------|------------------------------|-----------------------------------------|
| Product            |                              |                                         |
|`List<Product>`     |`GET api/products`            | Get all products                        |
|`Product`           |`GET api/products/{id}`       | Get one product by id                   |
|`Product`           |`POST api/products`           | Create a new product                    |
|`Product`           |`PUT api/products/{id}`       | Replace an existing product by id       |
|`void`              |`DELETE api/products/{id}`    | Delete an existing product by id        |
|--------------------|------------------------------|-----------------------------------------|
| Product Item       |                              |                                         |
|`ProductItem`       |`POST api/productitems`       | Create a new product items              |
|`ProductItem`       |`PUT api/productitems/{id}`   | Replace an existing product items by id |
|--------------------|------------------------------|-----------------------------------------|
| Borrow             |                              |                                         |
|`Borrow`            |`POST api/productitems`       | Create a borrow                         |
|`void`              |`DELETE api/productitems/{id}`| Delete an existing borrow by id         |
|--------------------|------------------------------|-----------------------------------------|
|`User`              |`POST api/ratings`            | Create a user                           |

# Lessons Learned

### Rubber Duck Effect
We experienced the reality that sometimes just asking or having someone present
to run questions past answers our own questions.

### Never work in the same files on similar code
We ran into issues with merge because we were hard pressed for time to complete
our pages on the front end.  More time was spent trying to correct the merge
than if we would have worked separately.

### Always restart your server

Code that is working doesn't always demonstrate that it works without refreshing
 either in browser or in the project itself.

Simple and thorough Database Structure
Time spent methodically creating a database with a working, simple structure
that encompasses all of what we set out to accomplish on the front end saved
having to restructure relationships and tables later.

