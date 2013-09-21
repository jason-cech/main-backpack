/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.phb.properties;

/**
 *
 * @author Jason
 */
public enum VisionType implements org.sizzle.dd.core.properties.types.VisionType {

	COMMON(0x0001, "Common"),
	DWARVISH(0x0002, "Dwarvish")
	;
	
	private final String text;
	private final int bit;

	VisionType(int bit, String text) {
		this.bit = bit;
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public int getBit() {
		return bit;
	}
}
