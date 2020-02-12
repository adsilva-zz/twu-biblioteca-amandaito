A - Who checked out the book 'The Hobbit’?
sqlite> select member.name from book, checkout_item, member
   ...> where book.id = checkout_item.book_id and
   ...> member.id =
   ...> checkout_item.member_id and
   ...> book.title = 'The Hobbit';

Result = Anand Beck


B - How many people have not checked out anything?
sqlite> select count(id) from member
		where id not in
		(select checkout_item.member_id from checkout_item);
Result = 37


C - What books and movies aren't checked out?
sqlite> select title from book
   ...> where book.id NOT IN
   ...>      (select book_id
   ...>       from checkout_item
   ...>       where book_id IS NOT NULL)
   ...> UNION
   ...> select title from movie
   ...> where movie.id NOT IN
   ...>      (select movie_id
   ...>       from checkout_item
   ...>       where movie_id IS NOT NULL);

Result =
1984
Catcher in the Rye
Crouching Tiger, Hidden Dragon
Domain Driven Design
Fellowship of the Ring
Lawrence of Arabia
Office Space
Thin Red Line
To Kill a Mockingbird
Tom Sawyer


D - Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database:

sqlite> insert into book (id, title) values (11, 'The Pragmatic Programmer');

sqlite> insert into member (id, name) values (43, 'Amanda Ito');

sqlite> insert into checkout_item (member_id, book_id) values (43, 11);

sqlite> select member.name from book, checkout_item, member
   ...> where book.id = checkout_item.book_id and
   ...> member.id = checkout_item.member_id and book.title = 'The Pragmatic Programmer';

Result = Amanda Ito


E - Who has checked out more than 1 item?

sqlite> select member.name, count(checkout_item.book_id) as QUANT from checkout_item
   ...> left join member on checkout_item.member_id = member.id
   ...> group by name
   ...> HAVING COUNT(member_id) > 1;

Result =
Anand Beck|2
Frank Smith|1