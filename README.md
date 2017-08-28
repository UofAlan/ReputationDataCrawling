# ReputationDataCrawling

The URL is https://github.com/UofAlan/ReputationDataCrawling
The folder of dataCrawling-addCookie is the project I did for Crawling data from Linkedin.
But I failed to log in the Linkedin website the Cookies.
So I did the second project, which is crawling data from github.com.

As I mentioned last Friday, I tried 2 ways to log in the website. One from the HttpClient way, which I prefer, because it will be safer and stable. What’s more, it won’t expire. The other way is to add the Cookies directly.  
But unfortunately, I failed both. I didn’t figure out the reason. I searched from Internet, discussed with my engineer friends and my peers and also posted a question about it on Stack Overflow.  But so far, I still haven’t got a way to solve the problem. Most of the answers are to add the cookies directly. I also tried the same way in other website, it works! So maybe Linkedin has some restrictions for simulate login or there’s some other things wrong rather than the cookies issue. But no matter what is it, I will still work on it. And I will figure it out! 

In order to do other part of the test, I switch to crawl data from github.com/apache.
I crawled all the repositories data of Apache.  Crawled all the repositories’ name, author, pullsNum, firstFileName, ReadmeTitle, and so on. I stored the data in mongoDB at the collection of apache_git in mydb database.

1. Crawling part, I involved WebMagic framework, which covers the whole lifecycle of crawler.  

At first, I used the Basic crawler. Overided the process to add the page to the queue and to crawl the useful data. And with more understanding of that framework, I found I can also use an Annotation way. 

1.1 Defined a model class, GitInfo. And with the help of annotations, I set the final destination URL with @TargetUrl and the process URL with @HelpUrl. In another word, @TargetUrl refers to article pages, while @HelpUrl refers to lists of pages. 
Crawling process starts with the page :github.com/apache. Then find the list page for example:github.com/apache?page=2. And the destination page is github.com/apache/{repositoryName}.

I also set the extraction rule with regular expressions, which helps to save the extracted result into the field.  
For this case, it refers to search from a h1 class=’public’tag, then goes into a strong tag, then goes into an a tag. The target source is the text words within the <a> and </a>. And this will refers to the repostory’s name.

1.2 Customized and overrided the PageModelPipeline to process the crawled data(store the data into mongodb in this case).
1.3 In class Crawling.java. I created 2 way to to start the crawling process startAndPrintInConsole() which will print the data on console.                   startAndStoreInMongoDb() which will store data to mongodb. I also set the startAndStoreInMongoDb()  execute every 2 hours from 00:00 with the annotation of @Scheduled(cron=“0 0 0/2 * *?”). It will also drop the database first before starts a new crawling process in order to keep the data fresh.
 
2. For Rest API part, I applied a POST method, a PUT method , a PATCH method and several GET methods.


Please let me know if you have any questions or need more explanations.

