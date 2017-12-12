package com.sktelecom.jse.service;

import com.sktelecom.jse.doamin.MemberBean;
import com.sktelecom.jse.doamin.PhoneBean;
import com.sktelecom.jse.serviceImpl.PhoneServiceImpl;

public interface PhoneService {
	public String showMessage(MemberBean member,PhoneBean phone);
	public String makeNumber();
	public String list();
	public String findByKey(String key);
	public String findByName(String name);
	public void updatePhoneNumber(String key);
	public void deleteMember(String key);
}
