import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BookMgrImpl implements IBookMgr{
	
	private static BookMgrImpl mgr = new BookMgrImpl();
	ArrayList<Book> books = new ArrayList<>();
	private BookMgrImpl() {	}
	
	public static BookMgrImpl getInstance()
	{
		return mgr;
	}
	

	@Override
	public void addBook(Book b) {
		books.add(b);
	}

	@Override
	public List<Book> search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException{
		boolean findBook = false;
		for(int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getIsbn().equals(isbn))
			{
				findBook = true;
				try {
					books.get(i).minusQuantity(quantity);
				} catch (QuantityException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		if(!findBook)
			throw new ISBNNotFoundException();
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		boolean findBook = false;
		for(int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getIsbn().equals(isbn))
			{
				findBook = true;
				books.get(i).plusQuantity(quantity);
			}
		}
		if(!findBook)
			throw new ISBNNotFoundException();
	}

	@Override
	public int getTotalAmount() {
		int totalPrice = 0;
		for(Book b : books)
		{
			totalPrice += b.getPrice() * b.getQuantity();
		}
		return totalPrice;
	}

	@Override
	public ArrayList<Book> open() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("book.dat")));
			String line = "";
			while((line = br.readLine()) != null)
			{
				String[] data = line.split(",");
				Book b;
				if(data.length == 4)
					b = new Book();
				else
					b = new Magazine();
				b.setIsbn(data[0]);
				b.setTitle(data[1]);
				b.setPrice(Integer.parseInt(data[2]));
				b.setQuantity(Integer.parseInt(data[3]));
				if(b instanceof Magazine)
					((Magazine) b).setMonth(Integer.parseInt(data[4]));
				books.add(b);
			}
		}finally{
			try
			{
				if(br != null)
					br.close();
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return books;
	}

	@Override
	public void close() throws IOException {
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new FileWriter(new File("book.dat")));
			for(Book b : books)
			{
				pw.print(b.getIsbn() + "," + b.getTitle() + "," + b.getPrice() + "," +
						b.getQuantity());
				if(b instanceof Magazine)
					pw.print("," + ((Magazine)b).getMonth());
				pw.println();
			}
			pw.flush();
		}finally
		{
			try
			{
				if(pw != null)
					pw.close();
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	@Override
	public boolean addBooks(Book... b) {
		boolean result = false;
		try {
			books.addAll(Arrays.asList(b));
			result = true;
		}catch(Exception e)
		{
			System.out.println("도서 추가 실패");
		}
		return result;
	}

}
