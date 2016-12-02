package vo;

import java.util.List;

	public class HotelVO {
		String name,address,tradeArea,introduction,facility;
		
		public HotelVO(){}
		
		public HotelVO(String n,String ad,String tA,String intro,String f){
			this.name=n;
			this.address=ad;
			this.tradeArea=tA;
			this.introduction=intro;
			this.facility=f;

		}
		
		public String getName(){
			return name;
		}
		
		public String getAdd(){
			return address;
		}
		
		public String getTR(){
			return tradeArea;
		}
		
		public String getIntro(){
			return introduction;
		}
		
		public String getF(){
			return facility;
		}
		
		
		
		public void setName(String Name){
			name=Name;
		}
		
		public void setAdd(String Address){
			address=Address;
		}
		
		public void setTradeArea(String TA){
			tradeArea=TA;
		}
		
		public void setIntroduction(String intro){
			introduction=intro;
		}
		
		public void setfacility(String f){
			facility=f;
		}
		
		
		
		
	}

