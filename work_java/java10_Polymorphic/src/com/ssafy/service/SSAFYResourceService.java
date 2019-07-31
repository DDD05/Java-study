package com.ssafy.service;

import com.ssafy.child.Instructor;
import com.ssafy.child.Manager;
import com.ssafy.parent.SSAFYResource;

public class SSAFYResourceService {
	
	private static SSAFYResourceService service = new SSAFYResourceService();
	private SSAFYResourceService() {}
	public static SSAFYResourceService getInstance()
	{
		return service;
	}
	
	
//	step1
//	public void StudentManage(Student st) {}
//	public void InstructorManage(Instructor in) {}
//	public void ManagerManage(Manager mg) {}
	
//	step2
//	public void ssafyManage(Student st) {}
//	public void ssafyManage(Instructor in) {}
//	public void ssafyManage(Manager mg) {}
	
//	step3
	public void ssafyManage(SSAFYResource ssafy)	// polymorphic argument
	{
		if(ssafy instanceof Instructor)	//부모타입으로 생성된 객체가 Instructor라면
		{
				((Instructor) ssafy).changeSubject("자바");
		}
		else if(ssafy instanceof Manager)
		{
			((Manager)ssafy).changeDept("마케팅부");
		}
		System.out.println(ssafy.toString());
	}
}
