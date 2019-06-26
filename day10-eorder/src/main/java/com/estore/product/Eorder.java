package com.estore.product;

import org.json.JSONObject;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class Eorder implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		MuleMessage msg = eventContext.getMessage();
		JSONObject obj = (JSONObject) msg.getPayload();
		String model = ((JSONObject) obj.get("order")).getString("model");
		ProductCost pc = new ProductCost();
		double price = pc.getprice(model);
		String pkey="price";
		((JSONObject) obj.get("order")).put(pkey,price);
		return obj.toString();
	}

}
