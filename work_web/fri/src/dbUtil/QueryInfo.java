package dbUtil;

public interface QueryInfo {
	String searchBookList = "select * from book where book.isbn=any (select bookIsbn from registerBookByUser where registerBookByUser.userID=?)";
	String searchBookByIsbn = "SELECT * FROM book WHERE isbn=?";
	String insertBook = "INSERT INTO book(isbn,title,catalogue, nation,publishDate,publisher, author,price,currency, description) VALUES(?,?,?, ?,?,?, ?,?,?,?)";
	String userByBook = "INSERT INTO registerBookByUser(userID,bookIsbn) VALUES(?,?)";
	String updateBook = "UPDATE book SET title=?,catalogue=?,nation=?,publishDate=?,author=?,price=?,currency=?,description=? WHERE isbn=?";
	
}
