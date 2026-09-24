1. From one of the examples in the blog post, I spotted the "Final" property when establishing a field within a class and after exploring,
I learned that using Final makes it so that that field can never be changed once it is set, forming another layer of protection beyond "Private".

2. I included a scanner object to the driver file to let the user create the buildings they want with a switch controlling each building type. I 
also added error handling anywhere that exceptions could arise, like within the switch, and before every non-string input. I decided to add an 
additional class extending Store called Cafe which has the field hoursOpen.

3. I added overloading to the House initializer function in the case that square footage isn't entered, and overriding to the new Cafe 
class's toString function.

4. The only challenge I experienced was figuring out where to include overloading/overriding in the first place as Alvin had the foresight to 
include multiple examples within the code before he gave it to me.

5. For my contributions, I used Github Copilot to assist me in building the switch in the driver class as well as teach me the syntax for 
the try-catch statement.