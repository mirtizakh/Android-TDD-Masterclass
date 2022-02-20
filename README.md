# Android-TDD-Masterclass
## Table of contents
* [What is TDD](#What-is-TDD)
* [Advantages of TDD](#Advantages-of-TDD)
* [TDD Development Lifecycle](#TDD-Development-Lifecycle)
* [3 Rules of TDD](#3-Rules-of-TDD)


### What is TDD
* Test driven development is a software development methodology inspired by Kent Beck in 2003 in which the test drive the development of the application.
* In other words it is a software engineering practice that requires a unit test to be written before the code that they are supposed to validate.
* It is also equally important to understand what is not test driven development, a common misconception even amound senior developers of the industry is that writing a lot of automated test means that we are practicing test driven development. This is an absolutely false argument , test driven development is a methodology that defines how we are develop our application to be driven and guided by test .
* It is perfectly possible to get 100% test code coverage without practicing TDD.While having automated test for our application is always a good thing .

### Advantages of TDD
#### 1- Great understanding of the product requirements.
First of all we get the great product understanding. When we force ourselves to write the test before we write the implementation we get to think of all the factors that will make our product successful , at this point we also realize very early that certain user stories do not meet the definition of ready and we need to clarify many ambiguities with the product owner and the designers.
#### 2- Faster Development.
While at first it may seem overwhelming in the long run , we get to develop much faster. Just think how much time you spent debugging your application.
Even worse, how much time you are going to spend if the defected code was written by someone else a long time ago. With TDD we minimize and almost eliminate the time we spend using the debugger.
#### 3- Better Design : High cohesion , Low coupling.
Another advantage of TDD is that we get to produce high quality code with high cohesion and low coupling when those two conditions are not met writing test is really difficult. By writing the test first we are making sure that our application is meeting all the conditions to be easily testable. Easy to test also means easy to read and easy to maintain.
#### 4- Less Defects.
A system developed with test driven development is going to have much less defects.
#### 5- Promotes Quality Culture.
A very important side effect of practicing TDD is that promotes a high quality culture inside the organization . TDD is a direct opposite of the quick and dirty that has destroyed a lot of projects even companies in the long run.
Practicing test driven development on a massive scale within the oraganization guarantees the success of the project in the long run and therefore the retention of its customers . Furthermore it attracts top talent and top software engineers who realize the benefits of working on such a high level.
#### 6- Regression Test Suite.
Another massive advantage is that we inherit for free a great regression test suit that is going to assure that newly introduce changes have not broken past behavior. How many times have you released a new version of the production and realized months later that the old features are not working anymore?
Having an automated test suit in place in the best tool to avoid those situations.
#### 7- Documentation
We are getting documentation for free , there is no better documentation than the one which doesn't only describes what the system is doing but it is also assuring that the system works. 

### TDD Development Lifecycle
Test driven development relies on the repitition of a very short development cycle.
This cycle can be broken down into 3 distinct steps.
#### 1- Red :
At first we need to write unit test that intends to validate a new functionality.
Initially this is always going to fail , as there is no production code that fulfills this functionality.

#### 2- Green :
The next step is the green , here we need to write the minimum software solution in order to make our test pass.
The goal here is not to develop the whole feature but just to get the test passing as fast as possible.
We should only focus only a very small bit of fucntionality.

#### 3- Blue :
The last step is blue or otherwise called refactor.
This step is often neglected but it is essential as it eliminates possible code duplications or any other code smells. 
In this phase any dirty solution that we have implemented there has to be refactored to match perfectly the overall system architecture .
Refactor is an internal process that aims to improve the reliability and maintainability of our system, but must not moidify the external behaviour of the program.
An important thing ,that they want to state , is that we shaould also spend time to refactor the testing code in not only the production code , the test also part of our system.

### 3 Rules of TDD 
The lifecycle can also be explained by the three rules of test driven development introduced by Uncle Bob Martin.
1- The first rule is that you cannot write production code until you have written a failing unit test .
2- The second rule is that you may not write more of a unit test than is sufficient to fail and having an apllication not compiling is failing.
3- Finally the third rule is that , you may not write more production code than is sufficient to pass the current failing test.


