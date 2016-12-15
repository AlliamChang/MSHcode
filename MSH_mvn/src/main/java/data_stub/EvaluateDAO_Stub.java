package data_stub;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import po.EvaluatePO;
import dao.hotel.EvaluateDAO;

public class EvaluateDAO_Stub implements EvaluateDAO {

	@Override
	public List<EvaluatePO> getEvaluate(int hotel_id) throws RemoteException {
		return Arrays.asList(new EvaluatePO("条件很不错","悦听风吟",1,"2016/10/01",4.5),
				new EvaluatePO("交通很方便","夜色",2,"2016/10/01",4.5));
	}

}
