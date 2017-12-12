package com.sktelecom.jse.serviceImpl;

import java.lang.reflect.Member;

import javax.swing.JOptionPane;

import com.sktelecom.jse.doamin.MemberBean;
import com.sktelecom.jse.doamin.PhoneBean;
import com.sktelecom.jse.service.PhoneService;

public class PhoneServiceImpl implements PhoneService {
	MemberBean[] members;
	PhoneBean[] phones;
	
	private int memberCount , phoneCount,customeNum;
	public PhoneServiceImpl() {
		memberCount = phoneCount = 0;
		customeNum = 1000;
		members = new MemberBean[10];
		phones = new PhoneBean[10];
		                       
	}
	public void addUser(MemberBean member,
			PhoneBean phone) {
		String customNum = createCustomNum();
		member.setCustomNum(customNum);
		phone.setCustomNum(customNum);
		this.members[memberCount++] = member;
		this.phones[phoneCount++] = phone;
	}
	@Override
	public String showMessage(MemberBean member,
			PhoneBean phone) {
		phone.setNumber(makeNumber());
		addUser(member,phone);
		String message = 
				String.format("%s님 이름으로\n"
				+ "%s 으로  %s 폰이\n"
				+ "개통 되었습니다.",member.getName(),phone.getNumber(),phone.getName());
		
		return message;
		
	}
	@Override
	public String makeNumber() {
		return "010-"+String.valueOf(String.format("%04d", (int)(Math.random()*10000)))
		   		 +"-"+String.valueOf(String.format("%04d", (int)(Math.random()*10000)));
	}
	public String createCustomNum() {
		return String.valueOf(customeNum++);
	}
	@Override
	public String list() {
		String res = "";
		for(int i =0; i<phoneCount;i++) {
			if(members[i].getCustomNum().equals(phones[i].getCustomNum())) {
			res  =  res.concat("고객넘버 "+ members[i].getCustomNum()+"".
						concat("이름"+members[i].getName()+"".
					    concat("핸드폰기종"+phones[i].getName()+"".
					    concat("핸드폰번호"+phones[i].getNumber()+"\n"))));
		}
	}
		return res;
	}
	@Override
	public String findByKey(String key) {
		String foo = "";
		for(int i=0; i<memberCount; i++) {
			if(key.equals(members[i].getCustomNum())) {
			foo = foo.concat("고객넘버 "+members[i].getCustomNum()+"\n".
					concat("고객이름 "+members[i].getName()+"\n".
							concat("핸드폰번호 " + " 010- "+phones[i].getNumber())));
	}
}
		return foo;
	}
	@Override
	public String findByName(String name) {
		String foo = "";
		for(int i=0; i<memberCount; i++) {
			if(name.equals(members[i].getName())) {
			foo = foo.concat("고객넘버"+members[i].getCustomNum()+"\n".
					concat("고객이름"+members[i].getName()+"\n").
					concat("핸드폰번호" + "010 - "+phones[i].getNumber()));
			}
		}
		return foo;
	}
	@Override
	public void updatePhoneNumber(String key) {
		PhoneBean makeNumber = new PhoneBean();
		String temp = "";
		for(int i=0; i<memberCount; i++) {
			if(key.equals(phones[i].getCustomNum())) {
				phones[i].setNumber(makeNumber());
				}
			}
		 
	}
	@Override
	public void deleteMember(String key) {
			
	}

	}
	

