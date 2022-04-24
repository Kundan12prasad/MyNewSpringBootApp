package com.practice.binding;

import lombok.Data;

@Data
public class UnlockAccForm
{
	private String email;
	private String tmpPwd;
	private String newpwd;
	private String confirmPwd;

}
