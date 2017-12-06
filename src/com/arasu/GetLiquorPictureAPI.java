package com.arasu;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consumeclass.GetLiquourPictureClass;

@Path("/getLiquorPicture")
public class GetLiquorPictureAPI {
	@GET
//	@Secured
	@Path("/{userprofileid}/{barid}/{sectionid}/{bottleid}")
	@Produces("image/jpeg")
	public InputStream getpicture(@javax.ws.rs.PathParam("userprofileid")String proid,@javax.ws.rs.PathParam("sectionid")String sectionid,
			@javax.ws.rs.PathParam("barid")String barid,@javax.ws.rs.PathParam("bottleid")String bottleid	){
		System.out.println("input query: "+proid+" / "+sectionid+" / "+barid+" / "+bottleid);
		return GetLiquourPictureClass.getpictureres(proid,sectionid,barid,bottleid);
	}
}
