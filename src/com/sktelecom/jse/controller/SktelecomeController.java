
package com.sktelecom.jse.controller;

import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.JOptionPane;

import com.sktelecom.jse.doamin.MemberBean;
import com.sktelecom.jse.doamin.PhoneBean;
import com.sktelecom.jse.service.PhoneService;
import com.sktelecom.jse.serviceImpl.PhoneServiceImpl;


public class SktelecomeController {
	public static void main(String[] args) {
		PhoneService service = new PhoneServiceImpl();
		PhoneBean phone = null;
		MemberBean member = null;
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료1.개통? 2.목록 3.고객넘버\n4.고객이름 5.번호이동 6.삭제할번호")) {
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
					JOptionPane.showMessageDialog(null,service.list());
					break;
				case "3" :
					JOptionPane.showMessageDialog(null,service.findByKey(JOptionPane.showInputDialog("고객번호를 입력하세요")));
					break;
				case "4" :
					JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("고객이름을 입력하세요")));
					break;
				case "5" :
					break;
				case "6" :
					break;
			}
		}
	}
}
