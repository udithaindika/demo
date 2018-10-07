package com.uditha.autogeneral.api;

public class NotFoundException extends ApiException {

	private static final long serialVersionUID = -4633578364014572392L;
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
	@Override
	public int getCode() {
		return code;
	}
	@Override
	public void setCode(int code) {
		this.code = code;
	}  
}
