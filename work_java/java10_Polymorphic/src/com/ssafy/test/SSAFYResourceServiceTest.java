package com.ssafy.test;

import com.ssafy.child.Instructor;
import com.ssafy.child.Manager;
import com.ssafy.child.Student;
import com.ssafy.service.SSAFYResourceService;

public class SSAFYResourceServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SSAFYResourceService service = new SSAFYResourceService();
		service.ssafyManage(new Student("신혜진",25,"진평동"));
		service.ssafyManage(new Manager("제임스", 35, "구평동", "교육부"));
		service.ssafyManage(new Instructor("고슬링", 45, "인동", "파이썬"));
	
	}

}
