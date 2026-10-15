1.
A hash set has many advantages that make them more desirable over array lists for this scenario. Mainly, hash sets don't allow duplicate items 
to be added as each item is hashed individually to make searching more efficient. By using array lists, the program would have to loop over
every index to see if the list contains the item which can take very long as the number of items in the list gets larger. Opting to use a hash
set instead cuts down on runtime by having all items within the set be readily available to be checked. The trade-off to this is not allowing
multiple instances of the same item be stored inside the set. In this case, that isn't so much of a limitation as no parts of the program
check the number of times a user has watched a particular movie, just if the user has watched the movie at some point.

2.
By choosing to store movies as keys with a hash set of users as a value allows us to answer questions centered around movies instead of users.
Since you start with the movie first, you can see how many users have seen that movie by checking the size of the set. From there, you can 
see of that number compares to factors like runtime and ratings easily as they are fields stored directly within the movie object. On the other 
hand, this approach complicates the process to answer questions that would be easy to answer with the user-centered approach. Without a hash map 
to associate users with a set of movies, it becomes harder to generate that set of movies as it requires you to loop through every movie's set of
users to look for a specific user. You could also choose to have both, either by having two hash maps or by making movie objects store a set of
users which grows whenever a new user watches a particular movie. This approach can be seen as the best of both worlds as it performs the processes
to answer all the questions in the most time-efficient manner at the cost of taking up double the amount of space in memory.