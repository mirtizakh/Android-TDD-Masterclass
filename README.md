# Android-TDD-Masterclass
## Table of contents
* [1- What Is TDD](#1-What-Is-TDD)
* [2- Advantages Of TDD](#2-Advantages-Of-TDD)
* [3- TDD Development Lifecycle](#3-TDD-Development-Lifecycle)
* [4- 3 Rules Of TDD](#4-3-Rules-Of-TDD)
* [5- Types Of Automated Test](#5-Types-Of-Automated-Test)
* [6- Types of TDD](#6-Types-of-TDD)
* [7- Classicist vs Outside In TDD](#7-Classicist-vs-Outside-In-TDD)

### 1-What Is TDD
* Test driven development is a software development methodology inspired by Kent Beck in 2003 in which the test drive the development of the application.
* In other words it is a software engineering practice that requires a unit test to be written before the code that they are supposed to validate.
* It is also equally important to understand what is not test driven development, a common misconception even amound senior developers of the industry is that writing a lot of automated test means that we are practicing test driven development. This is an absolutely false argument , test driven development is a methodology that defines how we are develop our application to be driven and guided by test .
* It is perfectly possible to get 100% test code coverage without practicing TDD.While having automated test for our application is always a good thing .

### 2-Advantages Of TDD
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

### 3-TDD Development Lifecycle
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

### 4-3 Rules Of TDD 
The lifecycle can also be explained by the three rules of test driven development introduced by Uncle Bob Martin.
* The first rule is that you cannot write production code until you have written a failing unit test .
* The second rule is that you may not write more of a unit test than is sufficient to fail and having an apllication not compiling is failing.
* Finally the third rule is that , you may not write more production code than is sufficient to pass the current failing test.

### 5-Types Of Automated Test
#### 1- Unit Test :
* First of all we have the unit test. The unit test are the amallest and the simplest test you can write and they typically test a very small block of code for example a method.
* They provide certain inout to the method and they expect a certain output. Unit test are supposed to be very small.
* Typically if a unit test requires more than five or six lines of code it should give us heads up for refactoring the code. It is very likely that it is testing too many things, what our code has beed developed without making use of best software engineering practices.
* The test that are written with junit, they simply required a JVM in order to run , we could copy a test from the Android application paste it over to a spring boot application and run it over there. A junit test is not aware that it is written for an Android application or bacend application or any other java based system it only knows that it is supposed to test a Java or Kotlin class.

#### 2- Integration Test :
* The second type of test is the integration test . In integration testing individual software modules are combined and tested as a group.
* It is usually testing the whole application component is meeting certain functional requirements, it occurs after unit testing and before end to end testing. 
* Technically there is no limit to the amount of classes in integration test is going to validate, it can be any thing between two classes or a whole software module apart from dozen of classes.
* For the case of Android development those test are also called instrumentation test and they live under "Android Test" folder.They required a real device or the emulator to run. 
* We typically use them to test certain modules of the application or certain parts that required Android context.

#### 3- End to End Test :
* They are also called functional or acceptance test .
* Those are testing an application work flow from the beginning to the end.
* They practically simulates a real human user and they verify that our application meets all the application functionsl requirements.
* Those test are live in "Android Test" folder and they required a real device or the emulator in order to run. They build the whole application and install on the phone, they simulate the user interactions like buttons or the menu navigation links and they verify that the UI elements that are being rendered on the screen are the correct ones.

### 6-Types of TDD
* Now coming back to the subject of test d.riven development , there are two main flavours "Classicist (Chicago)" and "Outside In (London)".
* One of the most confusing things with those flavours is the amount of names that people are using refer to them. So in different courses you may hear that "Classicist" TDD also referred to as the "Detroit School of TDD" (or state based testing, Inside-out, black-box testing).
Yes all those names are referring to the same thing.
* The second one also referred as "London School of TDD" (or Mockist, Interaction testing, Outside-in testing, white-box testing)
* Both of those schools agree that the test driven development is an effective tool but how they applied test driven development differs enough to classify them into two distinct schools of thought.

#### 1- Classicist TDD :
* You may have heard some of the famous Classicist practitioners including "Kent Beck", "Uncle Bob" and "Ron Jeffries".
* The most important aspect of Classicist TDD is that it does not make any use of mocks. Only they include the component at a real instances of objects.
The only thing that is possibly allowed to be mocked at a third party system and possibly the application database.
* The testing in this technique are designed to only test the end results and not the implementation.
* Another important aspect in this TDD technique is that the design is emerging, testing begins at the unit level and the design is supposed to emerge from the test.
* The name black box testing heavily comes from point 2 and 3 , this type of TDD only cares about the end result regardless of which method of the collaborator classes are being called. 


#### 2- Outside In TDD :
* On the other hand on the "Outside In" testing , the most famous practitioners are "Steve Freeman", "Sandi Metz" and "J.B Rainsberger".
* The Outside In is making vast use of mock objects.
* Practically in every test , we only have one real object instance under test and all the collaborating classes or otherwise its dependencies are being mocked.
* In this TDD , besides the result , we also test the interactions between the classes. We verify that the class under test is calling the right methods from the collaborating classes.
* In this TDD , we are doing unfront design at the start of its development cycle , we sit down and think of a design that would accommodate the implementation of the feature in a clean way. Of cource we are always allowed to refactor the design later.
* You may also hear this method as White box testing which comes from point 2 and 3, we do care about the methods that we call from the collaborating classes, therefore we are treating them as white boxes not as black boxes.

### 7-Classicist vs Outside In TDD
#### Classicist
##### Pros
* Faster Refactoring
As we stated before this approach is dealing all the collaborating classes as black boxes and does not test the implementation .When the public API of one class changes, we only need to refactor the unit test of this particular class and not the unit test of all the classes that is using it as it dependants.
This can lead to a much faster refactored.
##### Cons
* The most important disadvantage is that it can be hard to identify what the issue is . Since you would not make use of mocks a particular test might fail for bugs that are hidden inside the classes dependencies and not the class under test. Therefore it can be tricky to track down and fix the issues.
* The above point also leads to the second disadvantage which is redundant coverage. Certain parts of the code are tested over and over again.
#### Outside In  
##### Pros
* Easier to track down issues . Outside In TDD typically produce test that are more focused and isolated so in most cases it is very obvious why this failed and what needs to be fixed.
* It is also considered as an advantage the dedicated time for unfront design. Good design can not happen accident and to taking the time to think of it upfront and refactoring it later and go a long way.
* It forces that the architecture design is made . y testing the implementation for example testing that if view model is requesting the data from a repository and not carrying the HTTP request by itself , we also verify that the right architecture is being implemented.
##### Cons
* We are treating all the collaboating classes as white boxes , whichmeans we are also testing the implementation of them. This can lead to higher refactoring effort when we are changing the public API of the classes.
* The second disadvantage of this flavour is that it might produce false positives which means that we might have a green test suit while a bug has managed to slip inside our code. This happens because the vast majority of the test are isolated unit test which prove that the specific unit is behaving properly , but they donot prove that the end result is correct.

