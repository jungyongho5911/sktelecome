package com.sktelecom.jse.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jse.doamin.MemberBean;
import com.sktelecom.jse.doamin.PhoneBean;
import com.sktelecom.jse.service.PhoneService;
import com.sktelecom.jse.serviceImpl.PhoneServiceImpl;


public class SktelecomeController {
	public static void main(String[] args) {
		PhoneBean phone = null;
		MemberBean member = null;
		PhoneService service = new PhoneServiceImpl();
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료1.개통?\n")) {
				case "0" :
					JOptionPane.showMessageDialog(null, "종료");
					break;
				case "1" :
					phone = new PhoneBean();
					member = new MemberBean();
					phone.setName((JOptionPane.showInputDialog("1갤럭시,2아이폰").equals("1"))?"갤럭시":"아이폰");
					member.setName(JOptionPane.showInputDialog("이름?"));
					JOptionPane.showMessageDialog(null, service.showMessage(member, phone));
					break;
				case "2" :
					
					break;
					
			}
		}
	}
}
