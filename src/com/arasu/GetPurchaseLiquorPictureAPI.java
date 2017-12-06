package com.arasu;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import consumeclass.GetLiquourPictureClass;

@Path("/getPurchaseLiquorPicture")

public class GetPurchaseLiquorPictureAPI {
	@GET
	@Secured
	@Path("/{userprofileid}/{id}")
	@Produces("image/jpeg")
	public InputStream getpicture(@javax.ws.rs.PathParam("userprofileid")String proid,@javax.ws.rs.PathParam("id")String sectionid
		){
		return GetLiquourPictureClass.getpurchasepictureres(proid,sectionid);
	}
}
