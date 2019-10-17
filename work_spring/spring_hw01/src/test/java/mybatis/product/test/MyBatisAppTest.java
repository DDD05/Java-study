package mybatis.product.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssafy.vo.MyProductVO;

/*
 * session.insert()
 * session.selectOne()
 * session.selectList()
 */
public class MyBatisAppTest {

	public static void main(String[] args) throws IOException {
		
		// 1.xml metadata 읽는 Stream 생성
		Reader r = Resources.getResourceAsReader("sql/SqlMapConfig.xml");
		// 2. Reader 객체를 이용 xml metadata에 설정된 각 정보를 접근, 사용가능한 sqlSession 객체 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상품 이름 : ");
		String name = sc.next();
		System.out.print("상품 브랜드 : ");
		String maker = sc.next();
		System.out.print("상품 가격 : ");
		int price = sc.nextInt();
		MyProductVO product = new MyProductVO();
		product.setName(name);
		product.setMaker(maker);
		product.setPrice(price);

		// 1) 상품등록
		System.out.println("1) 상품 등록");
		Object obj = session.insert("Product.addProduct",product);
		session.commit();
		System.out.println("1 :: 상품이 " + obj + " 등록 되었습니다. ");
		System.out.println();
		
		// 객체에 데이터가 모두 들어갔는지 확인용 
		System.out.println(product);
		
		// 2) 등록된 모든 상품정보 출력하기
		System.out.println("2) 상품 등록");
		List<MyProductVO> list = session.selectList("Product.getUserList");
		session.commit();
		for(int i = 0 ; i < list.size() ; i++)
		{
			System.out.println("상품 " + (i+1) + ".  " + list.get(i));
		}
		System.out.println();
		
		// 3) 세탁기, 세탁.. 같은 특정한 제품으로 검색하기
		System.out.println("3) 특정 상품 검색하기");
		MyProductVO prd = session.selectOne("Product.searchProductByName", product);
		session.commit();
		System.out.println(prd);
		System.out.println();
		
		// 4) 특정한 상품 삭제하기
		System.out.println("4) 틀정한 상품 삭제하기");
		int deleteResult = session.delete("Product.deleteProductByName", product);
		session.commit();
		System.out.println(deleteResult + "가 삭제되었습니다.");
		
		// 5) 제품 정보 수정하기
		System.out.println("5) 제품 정보 수정하기");
		int updateResult = session.update("Product.updateProduct",product);
		session.commit();
		System.out.println(updateResult + "가 수정되었습니다.");
	}
}

/*

		
	1. Test 클래스
	--> MyProductAppTest
	1) 상품등록
	2) 등록된 모든 상품정보 출력하기
	3) 세탁기, 세탁...같은 특정한 제품으로 검색하기
	4) 특정한 상품 삭제하기
	5) 제품 정보 수정하기
	로직을 작성한다.
	
	
	2. package이름은 알아서 작성하도록 합시다.

	
*/