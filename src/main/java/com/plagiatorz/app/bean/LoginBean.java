package com.plagiatorz.app.bean;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import com.plagiatorz.app.exception.ValidationException;
import com.plagiatorz.global.Utils;

public class LoginBean extends BaseBean {

	private JTextField email = new JTextField();
	private JPasswordField passwort = new JPasswordField();
	private JButton loginBtn = new JButton("Login");
	private JButton createBtn = new JButton("Registrieren");

	public LoginBean(JFrame frame, JPanel contentPanel) {
		super(frame, contentPanel);
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JPasswordField getPasswort() {
		return passwort;
	}

	public void setPasswort(JPasswordField passwort) {
		this.passwort = passwort;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getCreateBtn() {
		return createBtn;
	}

	public void setCreateBtn(JButton createBtn) {
		this.createBtn = createBtn;
	}
	
	public String getPasswortVal(){
		char[] pwChar = passwort.getPassword();
		StringBuilder sb = new StringBuilder();
		for(char c : pwChar) {
			sb.append(c);
		}

		return sb.toString();
	}

	@Override
	public void validate() throws ValidationException {

		if(StringUtils.isEmpty(email.getText())){
			throw new ValidationException("Emailadresse leer");
		}
		else if(!Utils.checkRegex(email.getText(), "[\\.\\w\\_\\-]+[\\w]+@[\\.\\w\\_\\-]+\\.\\w{2,4}$")) {
			throw new ValidationException("Ungueltige Emailadresse");
		}
		char[] pwStr = passwort.getPassword();
		if(pwStr == null) {
			throw new ValidationException("Passwort ist leer");
		}
	}

}
