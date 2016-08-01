# AnswersForQuestions

## Answer for 1st Question:
I’ll write about two projects. 

The technical project I’m most proud of is islerburada.com. It was a job search engine. It was the project I technically matured. I and my business partner developed it from zero to production. We used a microservice architecture. We wrote unit tests. We did code reviewing. We had serverside build and deployment. The code was clean. It didn’t have an impact businesswise, because at the time we planned to look for investment, we were out of patience and faith. But it had a big impact on my technical skills. It was the technically the best project I ever worked for. 

The second project I’m most proud of is non-technical. I started a women’s developer group in Turkey and I’m leading it with other women in the community. I started a blog called women developer (in Turkish - www.kadinyazilimci.com). I invited ten senior women developers, and the blog turned into a community in a short time. We write blog posts, go to universities for technical and motivational talks, we open stands at software conferences, we have a Twitter account with over two thousand five hundred followers, we maintain an email list with over five hundred participants and we recently organized several Django Girls events. You can read our only English blog post here. http://www.kadinyazilimci.com/en/make-a-difference-through-differences/ I met tens of women developers through this organization, and the idea of having an impact on people’s lives is a big source of joy for me and makes me very proud.  

## Answer for 2nd Question:
The answer for the 2nd question is at https://github.com/elifkus/AnswersForQuestions/tree/master/unpacker
I implemented it in Python. 

## Answer for 3rd Question:
The answer for the 3rd question is at https://github.com/elifkus/AnswersForQuestions/tree/master/CustomerFilter
I implemented it in Java.

I divided the task into several tasks:

 * Reading the lines from the file
 * Converting the JSON strings into a Java Object
 * Calculating the distances and filtering based on that distance
 *  Printing the list
 

### Reading the lines from the file
The first task is reading the lines from the file. I put that method into a FileUtils file, because I think this method can be reused. 

### Converting the JSON strings into a Java Object
The second task is converting the JSON strings into Customer objects. I implemented two objects, the Customer object and the ExternalCustomer object. I use the ExternalCustomer object for deserializing the JSON string into a Java object. I prefered to use an intermediate object, to keep the internal and external data formats separate. Also the Gson deserialization to ExternalCustomer was much simpler than implementing the Gson deserialization to the Customer object directly. I immediately convert the converted object to the Customer object. The Customer object, has a Location field for the latitude and longitude fields. I put them together in an object because they don't make sense on their own and distance implementation belongs best in the location object. Both the Location and Customer objects are immutable.

### Calculating the distances and filtering based on that distance
The third task is filtering the customers based on the distance from the Intercom office. I implemented the distance calculation within the Location class, because a distance is between two locations.
I created a CustomerDistanceFilter object where I calculate the distance and filter the Customers that are within the desired distance.

### Sorting
For sorting by user_id, I implemented the Comparable interface and the equals method on the Customer object. Then I sorted the list using the sort method on the Collections class. 

### Printing the list
I print the filtered list in the Main class.

