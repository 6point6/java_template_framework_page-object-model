# Page Object Model

This is a sample Java UI test framework implementing Page Object Model which can be used as a template for any Java UI test automation framework using BDD.

The design pattern of this framework wraps HTML pages with application-specific interfaces allowing your tests to interact with the page elements 
without the tests themselves needing knowledge of the underlying HTML. This means any changes to the application HTML are
limited to your page classes - the test code doesn't need to change.

## Application under test
The website I have used for this demo project is a 3rd-party website called ["the-internet"](https://the-internet.herokuapp.com/), 
which is one I came across when I first started learning to develop automated tests. It is divided into a number of 
sub-pages, each demonstrating a different type of HTML element (e.g. checkboxes, dropdowns, inputs etc) and common challenges
you might face when automating a website (e.g. uploading files, infinite scrolls, nested frames etc).

I have chosen to write tests for a subset of these pages, namely:
* Home i.e. the main page
* Checkboxes
* Dropdown
* Dynamic Controls
* Form Authentication

## Project structure
Each page tested has a corresponding feature file, step file and a page class - implementing the Page Object Model

### Page Object Models
My Page Object Model classes are split into three main sections:
1. private locators/selectors - defines the ID/HTML tag/xpath etc used to identify the element on the page, declared using 
   `selenium.By`. These are declared private as nothing but this page class should require access to them. They are 
   separate to the associated getters for easier maintenance if any of the selectors change. 
2. private WebElement getters - methods that use the above selectors to obtain the specified element(s) using `findElement` 
   and `findElements` calls. These methods are private as tests shouldn't use WebElements directly. 
3. public interaction methods - the methods that interact with the elements on the web page via the above getter methods. 
   It is these methods that the tests call. This set of methods determines the interactions the tests (representing the 
   user) can perform on the page i.e. which elements they can click, which they can get the text from etc. This prevents
   your tests from doing anything unexpected as they can only interact with the page in ways you define via these methods.

## Running the tests
As the project uses Maven for dependency management the tests can be run using the Maven SureFire plugin:
`mvn clean test`

This can be modified to use a different browser, and to change whether the browser is run in headless mode, e.g.
`mvn clean test -Dbrowser=firefox -Dheadless=false`
will run the tests in non-headless Firefox.