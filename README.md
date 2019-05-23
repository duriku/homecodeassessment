# homecodeassessment
This is my solution for the [PolicyExpert's coding assessment](https://policyexpert.github.io/coding-assessment) 

### Building the app

`mvn clean install`

The maven command builds the app, executes the unit tests and packages the source files with the 
dependencies into a single jar `homecodeassessment-1.0-SNAPSHOT.jar` under the target folder

### Starting the project
The built executable jar file can be started with the following command from the projects root directory

`java -jar target/homecodeassessment-1.0-SNAPSHOT.jar `

### Using the app
Once the app is started it shows the Supermarket with the products and discounts.
The user is being asked to provide an item through the command line wizard from the provided list of products. 
After the product is entered, the count, respectively the weight for measurable items, 
should be entered after the product.With `checkout` the recipe is printed and the app execution is finished
```
*******************************************
*              SUPERMARKET                *
*                                         *
*   PRODUCTS                              *
*   ===================================   *
*   COCA_COLA          £3.00              *
*   PEPSI_COLA         £2.50              *
*   DORITOS            £1.00              *
*   BANANAS            £3.00 (kg)         *
*   KIWIS              £2.00 (kg)         *
*                                         *
*   TODAYS DISCOUNTS                      *
*   ===================================   *
*   THREE COKE FOR TWO                    *
*   FIVE DORITOS FOR THREE POUNDS         *
*                                         *
*******************************************
Type a product name from the list or type 'checkout' once you are done:
```