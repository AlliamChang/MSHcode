package po.hotelPO;

import java.io.Serializable;

import javafx.scene.image.Image;

public class HotelPO implements Serializable{
	
		private static final long serialVersionUID = 8961415443390938361L;
		private String address,trade_area,city,name,phone,introduction,province,imageExtension;
		private int id,lowest_price,star_level,stuff_id,year;
		private double score;
		private String[]facility;
		private byte[] scul;
		
		public HotelPO(){
			
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		public String getTrade_area() {
			return trade_area;
		}

		public void setTrade_area(String trade_area) {
			this.trade_area = trade_area;
		}
		
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String getIntroduction() {
			return introduction;
		}

		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		
		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public int getLowest_price() {
			return lowest_price;
		}

		public void setLowest_price(int lowest_price) {
			this.lowest_price = lowest_price;
		}
		
		public int getStar_level() {
			return star_level;
		}

		public void setStar_level(int star_level) {
			this.star_level = star_level;
		}
		
		public int getStuff_id() {
			return stuff_id;
		}

		public void setStuff_id(int stuff_id) {
			this.stuff_id = stuff_id;
		}
		
		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}
		
		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}
		
		public String[] getFacility() {
			return facility;
		}

		public void setFacility(String[] facility) {
			this.facility = facility;
		}
		
		public byte[] getScul() {
			return scul;
		}

		public void setScul(byte[] scul) {
			this.scul = scul;
		}

		public String getImageExtension() {
			return imageExtension;
		}

		public void setImageExtension(String imageExtension) {
			this.imageExtension = imageExtension;
		}
		
		
	

}


