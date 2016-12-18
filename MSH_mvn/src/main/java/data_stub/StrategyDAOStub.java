package data_stub;
import dao.strategy_dao.*;
import java.util.*;
import po.strategyPO.*;
import tools.*;
import tools.Date;
import java.rmi.*;
import po.*;
import po.hotelPO.RoomPO;
import java.time.LocalDate;

public class StrategyDAOStub implements StrategyDAO{
	private ArrayList<StrategyPO> database;
	
	public StrategyDAOStub(){
		database=new ArrayList<StrategyPO>();
		database.add(new StrategyPO("double11",StrategyType.BIRTHDAY,"Nanjing","Qixia"
				,new Date("2016/11/11",false),new Date("2016/11/12",false),99.00,PeopleType.VIP));
	}
	
	public StrategyPO findStrategy(String name) throws RemoteException{
		StrategyPO ret=null;
		for(int i=0;i<database.size();i++){
			if(database.get(i).getName().equals(name)){
			    ret=database.get(i);
			    break;
			}	
		}
		return ret;
	}

	public ResultMessage addStrategy(StrategyPO po) throws RemoteException{
    	boolean isExist=false;
    	for(int i=0;i<database.size();i++){
    		if(database.get(i).getName().equals(po.getName()))
    			isExist=true;
    	}
    	if(isExist)
    		return ResultMessage.EXIST;
    	else{
    		database.add(po);
    		return ResultMessage.SUCCESS;
    	}
    }
	
	public ResultMessage deleteStrategy(String name) throws RemoteException{
		for(int i=0;i<database.size();i++){
			if(database.get(i).getName().equals(name)){
				database.remove(i);
			}
		}
		return ResultMessage.SUCCESS;
	}
	
	public void updateStrategy(StrategyPO po) throws RemoteException{
		System.out.println("Update Succeed!");
	}
	
	public ResultMessage modifyStrategy(StrategyPO po) throws RemoteException{
		for(int i=0;i<database.size();i++){
			if(database.get(i).getName().equals(po.getName())){
				database.set(i, po);
			}
		}
		return ResultMessage.SUCCESS;
	}
	
	public void initStrategy() throws RemoteException{
		System.out.println("Init Succeed!");
	}
	
	public ArrayList<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException{
		ArrayList<StrategyPO> ret=new ArrayList<StrategyPO>();
		for(int i=0;i<database.size();i++){
			if(database.get(i).getHotelId()!=0&&database.get(i).getHotelId()==hotelId){
				ret.add(database.get(i));
			}
		}
		return ret;
	}
	
	public ArrayList<StrategyPO> getStrategyInWeb() throws RemoteException{
		ArrayList<StrategyPO> ret=new ArrayList<StrategyPO>();
		for(int i=0;i<database.size();i++){
			if(database.get(i).getHotelId()==0){
				ret.add(database.get(i));
			}
		}
		return ret;
	}
	
	public double getFinalPriceInHotel(UserPO user,OrderPO order,int hotelId) throws RemoteException{
		double finalPrice=0.00;
		finalPrice+=getLowestPrice(user,hotelId)+getRoomPrice(order,hotelId);
		return finalPrice;
	}//下完单后酒店中显示的最低价
	
	public double getFinalPriceInWeb(UserPO user) throws RemoteException{
		double finalPrice=0.00;
		return finalPrice;
	}
	
	public double getLowestPrice(UserPO user,int hotelId) throws RemoteException{
		double lowestPrice=0.00;
		lowestPrice+=getBirthPrice(user,hotelId)+getTimePrice(hotelId)+getVipPrice(user)+getCooperationPrice(user,hotelId);
		return lowestPrice;
	}//酒店策略--未下单时减少的价格
	
	public double getBirthPrice(UserPO user,int hotelId){
		double birthPrice=0.00;
		LocalDate now=LocalDate.now();
		for(int i=0;i<database.size();i++){
			if(database.get(i).getHotelId()==hotelId&&database.get(i).getStrategyType()==StrategyType.BIRTHDAY
					&&now.getYear()==user.getYear()&&now.getMonthValue()==user.getMonth()&&now.getDayOfMonth()==user.getDay()){
				birthPrice+=database.get(i).getCost();
			}
		}
		return birthPrice;
	}//酒店策略--生日策略减少价
	
	public double getTimePrice(int hotelId){
		double timePrice=0.00;
		LocalDate now=LocalDate.now();
		for(int i=0;i<database.size();i++){
			if(database.get(i).getStrategyType()==StrategyType.HOLIDAY&&database.get(i).getHotelId()==hotelId){
				String startTime=database.get(i).getStartTime().getDate();
				String endTime=database.get(i).getEndTime().getDate();
				String[] temp1=startTime.split("/");
				String[] temp2=endTime.split("/");
				int sYear=Integer.valueOf(temp1[0]);
				int eYear=Integer.valueOf(temp2[0]);
				int sMonth=Integer.valueOf(temp1[1]);
				int eMonth=Integer.valueOf(temp2[1]);
				int sDay=Integer.valueOf(temp1[2]);
				int eDay=Integer.valueOf(temp2[2]);
				if(now.getYear()>=sYear&&now.getYear()<eYear){
					if(now.getMonthValue()>=sMonth){
						if(now.getDayOfMonth()>=sDay){
							timePrice+=database.get(i).getCost();
						}
					}
				}
				else if(now.getYear()==sYear){
					if(now.getMonthValue()>=sMonth){
						if(now.getMonthValue()<eMonth){
							timePrice+=database.get(i).getCost();
						}
						else if(now.getMonthValue()==eMonth){
							if(now.getDayOfMonth()<=eDay){
								timePrice+=database.get(i).getCost();
							}
						}
					}
				}
			}
		}
		return timePrice;
	}//酒店策略--特定日期减少价
	
	public double getRoomPrice(OrderPO order,int hotelId){
		double roomPrice=0.00;
		for(int i=0;i<database.size();i++){
			if(order.getRoomNum()>=3&&database.get(i).getStrategyType()==StrategyType.TRIPLEROOM&&database.get(i).getHotelId()==hotelId)
				roomPrice+=database.get(i).getCost();
		}
		return roomPrice;
	}//酒店策略--三间房减少价
	
	public double getVipPrice(UserPO user){
		double vipPrice=0.00;
		
		return vipPrice;
	}
	
	public double getCooperationPrice(UserPO user,int hotelId){
		double cooperationPrice=0.00;
		for(int i=0;i<database.size();i++){
			if(database.get(i).getStrategyType()==StrategyType.CO_OPERATION&&user.getType()==UserType.COMPANY_CUSTOMER&&database.get(i).getHotelId()==hotelId)
				cooperationPrice+=database.get(i).getCost();
		}
		return cooperationPrice;
	}//酒店--合作企业折扣
	//public void setName(String name);
	
	//public StrategyType getStrategyType();
	
	//public void setStrategyType(StrategyType strategyType);
	
//<<<<<<< HEAD
	//public String getCity();
	
	//public void setCity(String city);
	
	//public String getArea();
	
	

}
