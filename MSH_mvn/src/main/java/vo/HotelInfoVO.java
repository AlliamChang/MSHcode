package vo;

import java.io.File;

import po.hotelPO.HotelPO;
import tools.ImageConverter;
import javafx.scene.image.Image;

public class HotelInfoVO {
	private int hotel_id;
	private int stuff_id;
	private String imagePath;
	private String adress;
	private String hotel;
	private String phone;
	private String[] facility;
	private String introduction;
	private String province;
	private String tradingArea;
	private String city;
	private int year;
	private byte[] scul;
	private int star;
	private double score;
	private int lowest_price;
	
	public HotelInfoVO(String hotel, String adress,String phone, String[] facility, String introduction, String province,
			String tradingArea,int year,String imagePath,int star,double score,int hotel_id,int stuff_id,String city) {
		this.hotel = hotel;
		this.adress = adress;
		this.phone = phone;
		this.facility = facility;
		this.introduction = introduction;
		this.province = province;
		this.tradingArea = tradingArea;
		this.year = year;
		this.imagePath=imagePath;
		this.star=star;
		this.score=score;
		this.hotel_id=hotel_id;
		this.stuff_id=stuff_id;
		this.city=city;
	}
	public HotelInfoVO(HotelPO po){
		this.hotel=po.getName();
		this.adress=po.getAddress();
		this.phone=po.getPhone();
		this.facility=po.getFacility().split("%");
		this.introduction=po.getIntroduction();
		this.province=po.getProvince();
		this.tradingArea=po.getTrade_area();
		this.year=po.getYear();
		if (po.getScul() != null) {
			File path = new File("image/hotel");
			if (!path.exists())
				path.mkdirs();
			this.imagePath = "image/hotel/" + po.getId() + "." + po.getImageExtension();
			ImageConverter.byteToFile(po.getScul(), imagePath);
		}
		this.star=po.getStar_level();
		this.score=po.getScore();
		this.hotel_id=po.getId();
		this.stuff_id=po.getStuff_id();
		this.city=po.getCity();
	}
	
	public HotelPO toPO(){
		HotelPO po=new HotelPO();
		po.setProvince(province);
		po.setCity(city);
		po.setTrade_area( tradingArea);
		po.setAddress(adress);
		StringBuilder build = new StringBuilder("");
		if(facility != null)
			for(int i = 0; i < facility.length; i ++){
				build.append(facility[i]);
				if(facility.length - 1 != i){
					build.append("%");
				}
			}
		po.setFacility(build.toString());
		po.setId(hotel_id);
		po.setIntroduction(introduction);
		po.setLowest_price(lowest_price);
		po.setName(hotel);
		po.setPhone(phone);
		po.setScore(score);
		po.setStar_level(star);
		po.setStuff_id(stuff_id);
		po.setYear(year);
		if (imagePath != null) {
			po.setScul(ImageConverter.fileToByte(imagePath));
			po.setImageExtension(new File(imagePath).getName().split("\\.")[1]);
		}
		return po;
	}
	public int getLowest_price() {
		return lowest_price;
	}
	public void setLowest_price(int lowest_price) {
		this.lowest_price = lowest_price;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int get_hotel_id(){
		return hotel_id;
	}
	public void set_hotel_id(int id){
		this.hotel_id=id;
	}
	
	public int get_stuff_id(){
		return stuff_id;
	}
	
	public void set_stuff_id(int id){
		this.stuff_id=id;
	}
	public Image getScul() {
		if (imagePath == null || !new File(imagePath).exists())
			return new Image("/image/default.png");
		return new Image("file:" + imagePath);
	}
	
	/**
	 * 
	 * @param imagePath 图片路径
	 */
	public void setScul(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getFacility() {
		return facility;
	}
	public void setFacility(String[] facility) {
		this.facility = facility;
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
	public String getTradingArea() {
		return tradingArea;
	}
	public void setTradingArea(String tradingArea) {
		this.tradingArea = tradingArea;
	}
	
	public void setScore(double score){
		this.score=score;
	}
	
	public int star(){
		return star;
	}
	
	public void setStar(int star){
		this.star=star;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getStuff_id() {
		return stuff_id;
	}
	public void setStuff_id(int stuff_id) {
		this.stuff_id = stuff_id;
	}
	public int getStar() {
		return star;
	}
	public double getScore() {
		return score;
	}
}
