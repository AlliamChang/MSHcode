package tools;

public enum BedStyle {
	DOUBLE_BEDS("双床"),KING_SIZE_BED("大床"),BUNK_BED("上下铺");
	
	private final String value;
	
	private BedStyle(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
