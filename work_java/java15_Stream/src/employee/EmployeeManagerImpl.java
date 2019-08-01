package employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerImpl implements Manager {
	
	private static EmployeeManagerImpl emi = new EmployeeManagerImpl();
	
	BufferedReader br;
	BufferedWriter bw;
	FileReader fr;
	FileWriter fw;
	List<Employee> eList  = new ArrayList<>();
	File file;
	
	/////////////////////////////////////////////////
	//////////      싱글톤으로 변경하세요     ///////////
	///////////////////////////////////////////////

	private EmployeeManagerImpl() {
		file = new File("employee.txt");
		if(file.exists()) {
			//파일이 존재한다면....
			/*   
			   	파일에 있는 내용을 읽어와서
				Employee를 생성하고 생성된 
				Employee들을 List에 저장한다.
			*/
			getFile();
		} else {
			//파일이 존재하지 않는다면...파일을 생성부터 한다.			
			try
			{
				boolean check = file.createNewFile();
				System.out.println("파일 생성 성공");
			}catch(IOException e)
			{
				System.out.println("파일 생성 실패");
			}
			
		} 
	}

	public static EmployeeManagerImpl getInstance() {
		return emi;
	}
	@Override
	public void saveFile() {
	/*
	 * 프로그램 종료 시 ArrayList에 저장된 모든 사원에 대한 정보를
	 * 파일에 출력한다.
	 */
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(Employee e : eList)
			{
				bw.write(e+"\n");
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fw != null)
					fw.close();
				if(bw != null)
					bw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		// 예외 추가
		return eList.add(employee); 
	}

	@Override
	public boolean deleteEmployee(String eid) {
		////
		for(Employee e : eList)
		{
			if(e.getEid().equals(eid))
			{
				eList.remove(e);
				return true;
			}
		}

		return false;
	}

	@Override
	public Employee findEmployee(String eid) {		
		Employee emp = null;
		for(int i = 0 ; i < eList.size() ; i++)
		{
			if(eList.get(i).getEid().equals(eid))
				emp = eList.get(i);
		}

		return emp;
	}
	@Override
	public void showAll() {
		////
		System.out.println(eList.size());
		for(Employee e : eList)
		{
			System.out.println(e);
		}


	}

	@Override
	public void getFile() {
		// TODO Auto-generated method stub
		try {
			br = new BufferedReader(new FileReader(file));
			String temp = null;
			while(true)
			{
				List<String> license = new ArrayList<>();
				temp = br.readLine();
				if(temp == null)
					break;
				String[] data = temp.split(",");
				
				Employee emp = new Employee();
				emp.setEid(data[0]);
				
				Employee.serial = Integer.parseInt(data[0]);
				emp.setName(data[1]);
				emp.setSalary(Integer.parseInt(data[2]));
				
				for(int i = 3 ; i < data.length ; i++)
				{
					license.add(data[i]);
				}
				emp.setLicense(license);
				eList.add(emp);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(Exception e)
			{
				
			}
		}
	}
}




