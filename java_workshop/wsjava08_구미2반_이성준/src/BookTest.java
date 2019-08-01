import java.io.IOException;
import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args)
	{
		BookMgrImpl mgr = BookMgrImpl.getInstance();
		ArrayList<Book> bookList = null;
		try {
			bookList = mgr.open();
			if(mgr.addBooks(bookList.toArray(new Book[bookList.size()])))
				printing("도서 파일 읽어오기~");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}

//		printing("도서 추가");
//		mgr.addBook(new Book("b1","오브젝트",38000,2));
//		mgr.addBook(new Book("b2","리눅스마스터",50000,1));
//		mgr.addBook(new Book("b3","CentOS",42000,3));
//		mgr.addBook(new Magazine("m1","노션이란?",10000,3,1));
//		mgr.addBook(new Magazine("m2","에버노트",20000,1,2));
//		mgr.addBook(new Magazine("m3","메모장?",30000,1,3));
		System.out.println(mgr.search());

		printing("b1 도서 3개 판매");
		try {
			mgr.sell("b1",3);
		}catch(ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}

		printing("b4 도서 1개 구매");
		try {
			mgr.buy("b4",1);
		}catch(ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}

		printing("총 재고 금액");
		System.out.println(mgr.getTotalAmount());

		try {
			mgr.close();
			printing("프로그램 종료.. 도서 파일 저장");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void printing(String str)
	{
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.format("|%55s\t%45s\n",str,"|");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	}
}
