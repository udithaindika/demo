package com.uditha.autogeneral.api;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4633578364014572392L;

	public NotFoundException (String msg) {
        super(msg);
    }
}
