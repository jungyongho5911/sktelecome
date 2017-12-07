package com.sktelecom.jse.service;

import com.sktelecom.jse.doamin.MemberBean;
import com.sktelecom.jse.doamin.PhoneBean;

public interface PhoneService {
	public String showMessage(MemberBean member,PhoneBean phone);
	public String makeNumber();
	
	
}
