package com.dataProvider;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class encryptor {
	@Test
public void Encrypt() {
	
	System.out.println(
			new String(Base64.encodeBase64("aA111111".getBytes()))
			);
}
}
