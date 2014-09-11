package com.hp.hponeview.rest;

import com.hp.hponeview.data.OneViewError;

public class HPOneViewRestException extends HPOneViewException {	
	static final long serialVersionUID = 1;
	public OneViewError	err;
	
	public HPOneViewRestException( OneViewError err ) {
		super(err.message);
		this.err = err;
	}
}
