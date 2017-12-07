package com.sktelecom.jse.serviceImpl;

import com.sktelecom.jse.doamin.MemberBean;
import com.sktelecom.jse.doamin.PhoneBean;
import com.sktelecom.jse.service.PhoneService;

public class PhoneServiceImpl implements PhoneService {
	MemberBean[] members;
	PhoneBean[] phones;
	
	private int membercount , phonecount;
	public PhoneServiceImpl() {
		
		members = new MemberBean[2];
		phones = new PhoneBean[2];
		membercount = phonecount = 0;
	}
	public void addUser(MemberBean member,
			PhoneBean phone) {
		member.setCustomNum(null);
		phone.setCustomNum(null);
		this.members[membercount] = member;
		this.phones[phonecount] = phone;
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
		return "010-"+
					String.valueOf((int)(Math.random() * 9999 + 0000))+"-"+
					String.valueOf((int)(Math.random() * 9999 + 0000));
	}
}

