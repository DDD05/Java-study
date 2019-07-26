public class BookTest {
	public static void main(String[] args)
	{
		Book[] bookList = new Book[6];
		
		bookList[0]=new Book("0","java","java god","javac",1000,"so NoJam");
		bookList[1]=new Book("1","power java","child of java","javac",2000,"so BigJam");
		bookList[2]=new Book("2","young man","ss501","sm",3000,"I'm young Jam");
		bookList[3]=new Magazine("3","just do it","doitman","magazie world",4000,"so so",2019,8);
		bookList[4]=new Magazine("4","impossible it's noting","man","magazine world",5000,"so good",2012,11);
		bookList[5]=new Magazine("5","Maxim","woman","magazine world",6000,"so bad",2022,3);
		
		BookManager bm = new BookManager();
		for(int i = 0 ; i < 6; i++)
		{
			bm.addBook(bookList[i]);
		}
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("번호로 찾기");
		Book b1 = bm.searchBookByIsbn("3");
		System.out.println(b1);
		System.out.println("---------------------------------------------------------------------------");
		
		System.out.println("타이틀로 찾기");
		Book[] bookList2 = bm.searchBookByTitle("java");
		
		for(Book b : bookList2)
		{
			if(b != null)
				System.out.println(b);
		}
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("모든 책 찾기");
		Book[] bookList3 = bm.getAllBook();
		
		for(Book b : bookList3)
		{
			if(b != null)
				System.out.println(b);
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("모든 잡지 찾기");
		bookList3 = bm.getAllMagazine();
		
		for(Book b : bookList3)
		{
			if(b != null)
				System.out.println(b);
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("모든 출판사 찾기");
		bookList3 = bm.searchBookByPublisher("javac");
		
		for(Book b : bookList3)
		{
			if(b != null)
				System.out.println(b);
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("낮은 가격");
		bookList3 = bm.searchBookByLowPrice(2000);
		
		for(Book b : bookList3)
		{
			if(b != null)
				System.out.println(b);
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("모든 가격");
		System.out.println(bm.getSumPrice());
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("평균");
		System.out.println(bm.getAvgPrice());
		
		
	}
}
